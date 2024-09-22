package SequenciaFibonacci;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Informe um número: ");
        int numero = scanner.nextInt();

        if (isFibonacci(numero)) {
            System.out.println("O número " + numero + " pertence à sequência de Fibonacci.");
        } else {
            System.out.println("O número " + numero + " não pertence à sequência de Fibonacci.");
        }

        scanner.close();
    }

    public static boolean isFibonacci(int num) {
        int a = 0;
        int b = 1;

        while (a <= num) {
            if (a == num) {
                return true;
            }

            int next = a + b;
            a = b;
            b = next;
        }

        return false;
    }
}
