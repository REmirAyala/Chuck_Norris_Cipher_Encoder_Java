package chucknorris;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        showMenu();
    }

    private static void showMenu() {
        boolean show = false;

        while(!show) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Please input operation (encode/decode/exit):");
            String menuOption = scanner.nextLine();

            switch (menuOption) {
                case "encode" -> chuckNorris();
                case "decode" -> decodeChuckNorris();
                case "exit" -> {
                    System.out.println("Bye!");
                    show = true;
                }
                default -> {
                    System.out.printf("There is no '%s' operation%n", menuOption);
                    System.out.println();
                }
            }


        }
    }
    private static void chuckNorris() {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Input string:");

        String readLine = scanner.nextLine();

        StringBuilder binaryValue = new StringBuilder(encodeBinary(readLine));



            StringBuilder code = new StringBuilder();

            char currentChar = binaryValue.charAt(0);
            int count = 1;

            for (int i = 1; i < binaryValue.length(); i++) {
                if (binaryValue.charAt(i) == currentChar) {
                    count++;
                } else {
                    code.append(currentChar == '1' ? "0 " : "00 ");
                    code.append("0".repeat(count)).append(" ");
                    currentChar = binaryValue.charAt(i);
                    count = 1;
                }
            }

            code.append(currentChar == '1' ? "0 " : "00 ");
            code.append("0".repeat(count));

        System.out.println("Encoded string:");
        System.out.println(code);
        System.out.println();

    }

    private static StringBuilder encodeBinary(String readLine) {

        StringBuilder binaryMessage = new StringBuilder();

        for (int i = 0; i < readLine.length(); i++) {
            char ch = readLine.charAt(i);
            String binaryValue = Integer.toBinaryString(ch);
            while (binaryValue.length() < 7) {
                binaryValue = "0" + binaryValue;
            }
            binaryMessage.append(binaryValue);
        }

        return binaryMessage;
    }

    private static void decodeChuckNorris() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Input encoded string:");
        String encoded = scanner.nextLine();

        if (!encoded.matches("[0 ]+")) {
            System.out.println("Encoded string is not valid.");
            return;
        }

        String[] blocks = encoded.split(" ");

        for (int i = 0; i < blocks.length; i+=2) {
            if (!blocks[i].equals("0") && !blocks[i].equals("00")) {
                System.out.println("Encoded string is not valid.");
                return;
            }
        }

        if (blocks.length % 2 != 0) {
            System.out.println("Encoded string is not valid.");
            return;
        }

        StringBuilder binary = new StringBuilder();
        for (int i = 0; i < blocks.length; i+=2) {
            char type = blocks[i].equals("00") ? '0' : '1';
            int count = blocks[i + 1].length();
            binary.append(String.valueOf(type).repeat(count));
        }

        if (binary.length() % 7 != 0) {
            System.out.println("Encoded string is not valid.");
            return;
        }

        System.out.println("Decoded string:");
        System.out.println(binaryToText(binary.toString()));
        System.out.println();
    }

    private static StringBuilder binaryToText(String binary) {
        StringBuilder text = new StringBuilder();

        for (int i = 0; i < binary.length(); i += 7) {
            String charBinary = binary.substring(i, i + 7);
            char c = (char) Integer.parseInt(charBinary, 2);
            text.append(c);
        }

        return text;
    }

}