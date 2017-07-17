public class Fibonacci {

    private static void printUsage() {
        System.out.println("Usage: java Exponent <fibonacci>, where <fibonacci> is a non-negative integer.");
    }

    private static int fibonacci(int num) {
        if (num <= 1) {
            return num;
        } else {
            return fibonacci(num - 1) + fibonacci(num - 2);
        }
    }

    public static void main(String[] args) {
        int num;
        try {
            if (args.length == 0) {
                num = 10;
            } else {
                num = Integer.parseInt(args[0]);
                if (num < 0) {
                    System.out.println("Sorry, but this program only accepts non-negative integers.");
                    throw new IllegalArgumentException();
                }
            }
        } catch(IllegalArgumentException iae) {
            printUsage();
            return;
        }

        System.out.println("The " + num + "th number in the Fibonacci sequence is " + fibonacci(num) + ".");
    }
}
