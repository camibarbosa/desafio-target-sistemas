package FaturamentoMensal;

public class Main {
    public static void main(String[] args) {
        String[] estados = {"SP", "RJ", "MG", "ES", "Outros"};
        double[] faturamentos = {67836.43, 36678.66, 29229.88, 27165.48, 19849.53};

        double totalFaturamento = 0;
        for (double faturamento : faturamentos) {
            totalFaturamento += faturamento;
        }

        System.out.printf("Faturamento total: R$ %.2f%n", totalFaturamento);
        for (int i = 0; i < estados.length; i++) {
            double percentual = (faturamentos[i] / totalFaturamento) * 100;
            System.out.printf("%s: %.2f%%%n", estados[i], percentual);
        }
    }
}
