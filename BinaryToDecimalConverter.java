public class BinaryToDecimalConverter {

    private static int binaryToDecimal (String binary) {
        int multiple = 1;
        int decimal = 0;
        for (int i = binary.length() - 1; i >= 0; i--) {
            char zeroOrOne = binary.charAt(i);
            if (zeroOrOne == '1') {
                decimal += multiple;
            }
            multiple *= 2;
        }
        return decimal;
    }

    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Please input a binary number.");
        } else {
            String binary = args[0];
            for (int i = 0; i < binary.length(); i++) {
                if (binary.charAt(i) != '0' && binary.charAt(i) != '1') {
                    System.out.println("Please input a valid binary number");
                    return;
                }
            }
            System.out.println(binaryToDecimal(binary));
        }
    }
}
