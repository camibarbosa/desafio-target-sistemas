package InversaoString;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite uma string: ");
        String input = scanner.nextLine();
        String invertida = inverterString(input);

        System.out.println("String invertida: " + invertida);
    }

    public static String inverterString(String str) {
        char[] caracteres = str.toCharArray();
        StringBuilder invertida = new StringBuilder();
        for (int i = caracteres.length - 1; i >= 0; i--) {
            invertida.append(caracteres[i]);
        }
        return invertida.toString();
    }
}
