public class PasswordEncryption {

    public static final String[] lettersEncrypted = {"/-\\", "|3", "(", "|)", "3", "|=", "(-", "|-|", "1", "_|", "|<", "|_", "/v\\",
                                                     "|\\|", "0", "|D", "(,)", "|2", "$", "7", "|_|", "\\/", "\\^/", "}{", "`/", "2"};
    public static final String[] digitsEncrypted = {"o", "L", "R", "E", "A", "S", "b", "T", "B", "g"};
    public static final char[] alphabet = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M',
                                           'N', 'O', 'P', 'Q','R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
    public static final String ENTER_VALID_PASSWORD = "Please enter a password with only letters, digits, and no spaces.";

    public static int getLetterIndex(char n) {
        n = Character.toUpperCase(n);
        int index = 0;
        for (int i = 0; i < alphabet.length; i++) {
            if (n == alphabet[i]) {
                index = i;
            }
        }
        return index;
    }

    public static String encryptPassword(String password) {
        char[] passwordArray = password.toCharArray();
        String encryptedPassword = "";
        int num;
        for (int i = 0; i < passwordArray.length; i++) {
            char value = passwordArray[i];
            String addon = "";
            try {
                if (Character.isLetter(value)) {
                    num = getLetterIndex(value);
                    addon = lettersEncrypted[num];
                } else if (Character.isDigit(value)) {
                    num = Character.getNumericValue(value);
                    addon = digitsEncrypted[num];
                } else {
                    throw new Exception();
                }
            } catch(Exception e) {
                return ENTER_VALID_PASSWORD;
            }
            encryptedPassword += addon;
        }
        return encryptedPassword;
    }

    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println(ENTER_VALID_PASSWORD);
        } else {
            if (encryptPassword(args[0]).equals(ENTER_VALID_PASSWORD)) {
                System.out.println(encryptPassword(args[0]));
            } else {
                System.out.println();
                System.out.println("Encrypted Password");
                System.out.println("******************");
                System.out.println(encryptPassword(args[0]));
                System.out.println("******************");
                System.out.println();
            }
        }
    }
}
