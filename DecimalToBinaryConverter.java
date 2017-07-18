public class DecimalToBinaryConverter {

    private static StringBuilder decimalToBinary(int decimal) {
        String binary = "";
        while (decimal > 0) {
            if (decimal % 2 == 0) {
                binary += "0";
            } else {
                binary += "1";
            }
            decimal /= 2;
        }
        StringBuilder str = new StringBuilder(binary);
        return str.reverse();
    }

    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Please enter a number to be converted to binary.");
        } else {
            int decimal = Integer.parseInt(args[0]);
            System.out.println(decimalToBinary(decimal));
        }
    }
}
