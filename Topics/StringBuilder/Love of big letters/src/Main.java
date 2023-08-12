import java.util.Scanner;

class EvenUpperCase {

    public static String upperEvenLetters(String message) {
        StringBuilder upperEven = new StringBuilder();

        for (int i = 0; i < message.length(); i++) {
            if (i % 2 == 0) {
                upperEven.append(Character.toUpperCase(message.charAt(i)));
            } else {
                upperEven.append(message.charAt(i));
            }
        }

        return upperEven.toString();
    }

    // Don't change the code below
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String message = scanner.next();

        System.out.println(upperEvenLetters(message));
    }
}