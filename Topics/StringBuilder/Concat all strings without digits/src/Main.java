import java.util.Scanner;

class ConcatenateStringsProblem {

    public static String concatenateStringsWithoutDigits(String[] strings) {
        StringBuilder output = new StringBuilder();

        for (String str : strings) {
            for (char ch : str.toCharArray()) {
                if(!Character.isDigit(ch)) {
                    output.append(ch);
                }
            }
        }

        return output.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] strings = scanner.nextLine().split("\\s+");
        String result = concatenateStringsWithoutDigits(strings);
        System.out.println(result);
    }
}