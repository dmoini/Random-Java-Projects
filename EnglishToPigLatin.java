public class EnglishToPigLatin {

    private static String englishToPigLatin(String s) {
        if (isVowel(s.charAt(0))) {
            return s + "-way";
        }
        boolean consonant = true;
        int index = 1;
        while (consonant) {
            if (isVowel(s.charAt(index))) {
                consonant = false;
            }
            index++;
        }
        String addon = "-" + s.substring(0, index - 1) + "ay";
        return s.substring(index - 1, s.length()) + addon;
    }

    private static boolean isVowel(char a) {
        if (a == 'a' || a == 'e' || a == 'i' || a == 'o' || a == 'u') {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Please enter a word to be translated into pig latin.");
        } else {
            System.out.println(englishToPigLatin(args[0]));
        }
    }
}
