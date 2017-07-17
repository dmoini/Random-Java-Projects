public class WordSearchGenerator {

    public static final int defaultBounds = 10;
    public static final char[] alphabet = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
    public static final String[] testWords = {"apple", "banana", "mango", "pizza", "grapes"};
    public static final String allWordsUsed = "ALL WORDS USED";
    public static String unusedWords = allWordsUsed;

    private static char[][] wordSearch;
    private static boolean[][] openSpots;
    private static int height; // row
    private static int width; // column

    public static void createWordSearch(int h, int w) {
        height = h;
        width = w;
        wordSearch = new char[height][width];
        openSpots = new boolean[height][width];
        resetOpenSpots();
    }

    public static void resetOpenSpots() {
        for (int i = 0; i < openSpots.length; i++) {
            for (int j = 0; j < openSpots[0].length; j++) {
                openSpots[i][j] = true;
            }
        }
    }

    public static void addUnusedWord(String s) {
        String word = s.toUpperCase();
        if (allWordsUsed.equals(unusedWords)) {
            unusedWords = "Unused words: ";
        }
        unusedWords += word + " ";
    }

    public static char generateRandomLetter() {
        int num = (int) Math.floor(Math.random() * 26);
        return alphabet[num];
    }

    public static void insertWordHorizontally(String s) {
        if (!checkIfWordValid(s)) {
            addUnusedWord(s);
            return;
        }
        char[] word = s.toUpperCase().toCharArray();
        boolean done = false;
        int tries = 0;
        while(!done) {
            int x = (int) Math.floor(Math.random() * (width - word.length + 1));
            int y = (int) Math.floor(Math.random() * (height - word.length + 1));
            boolean works = true;
            for (int i = x; i < x + word.length; i++) {
                if (!openSpots[y][i]) {
                    works = false;
                }
            }
            if (works) {
                for (int i = x; i < x + word.length; i++) {
                    wordSearch[y][i] = word[i - x];
                    openSpots[y][i] = false;
                }
                done = true;
            }
            if (tries >= Math.pow(width + height, 2)) {
                addUnusedWord(s);
                done = true;
            }
            tries++;
        }
    }

    public static void insertWordVertically(String s) {
        if (!checkIfWordValid(s)) {
            addUnusedWord(s);
            return;
        }
        char[] word = s.toUpperCase().toCharArray();
        boolean done = false;
        int tries = 0;
        while(!done) {
            int x = (int) Math.floor(Math.random() * (width - word.length + 1));
            int y = (int) Math.floor(Math.random() * (height - word.length + 1));
            boolean works = true;
            for (int i = y; i < y + word.length; i++) {
                if (!openSpots[i][x]) {
                    works = false;
                }
            }
            if (works) {
                for (int i = y; i < y + word.length; i++) {
                    wordSearch[i][x] = word[i - y];
                    openSpots[i][x] = false;
                }
                done = true;
            }
            if (tries >= Math.pow(width + height, 2)) {
                addUnusedWord(s);
                done = true;
            }
            tries++;
        }
    }


    public static void insertWordDiagonally(String s) {
        if (!checkIfWordValid(s)) {
            addUnusedWord(s);
            return;
        }
        char[] word = s.toUpperCase().toCharArray();
        boolean done = false;
        int tries = 0;
        while(!done) {
            int x = (int) Math.floor(Math.random() * (width - word.length + 1));
            int y = (int) Math.floor(Math.random() * (height - word.length + 1));
            boolean works = true;
            for (int i = y; i < y + word.length; i++) {
                    if (!openSpots[i][i]) {
                        works = false;
                    }
            }
            if (works) {
                for (int i = y; i < y + word.length; i++) {
                        wordSearch[i][i] = word[i - y];
                        openSpots[i][i] = false;
                }
                done = true;
            }
            if (tries >= Math.pow(width + height, 2)) {
                addUnusedWord(s);
                done = true;
            }
            tries++;
        }
    }

    public static void insertWords(String[] words) {
        int counter = 0;
        boolean done = false;
        while(!done) {
            int num = (int) Math.floor(Math.random() * 3);
            if (num == 0) {
                insertWordHorizontally(words[counter]);
            } else if (num == 1) {
                insertWordVertically(words[counter]);
            } else {
                insertWordDiagonally(words[counter]);
            }
            if (counter >= words.length - 1) {
                done = true;
            }
            counter++;
        }
    }

    public static boolean checkIfWordValid(String s) {
        if (s.length() > width || s.length() > height) {
            return false;
        }
        char[] word = s.toCharArray();
        for (int i = 0; i < word.length; i++) {
            if (!Character.isLetter(word[i])) {
                return false;
            }
        }
        return true;
    }

    public static void fillRestOfWordSearch() {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (openSpots[i][j]) {
                    char randomLetter = generateRandomLetter();
                    wordSearch[i][j] = randomLetter;
                    openSpots[i][j] = false;
                }
            }
        }
    }

    public static void printWordSearch() {
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                System.out.print(wordSearch[i][j] + " ");
            }
            System.out.println();
        }
    }


    public static void main(String[] args) {
        if (args.length == 0) {
            createWordSearch(defaultBounds, defaultBounds);
        } else if (args.length == 1) {
            createWordSearch(Integer.parseInt(args[0]), Integer.parseInt(args[0]));
        } else {
            createWordSearch(Integer.parseInt(args[0]), Integer.parseInt(args[1]));
        }
        insertWords(testWords);
        fillRestOfWordSearch();
        printWordSearch();
        System.out.println("-------------------");
        System.out.println(unusedWords);
        System.out.println("-------------------");
    }
}
