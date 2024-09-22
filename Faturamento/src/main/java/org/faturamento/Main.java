package org.faturamento;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Double> faturamentos = new ArrayList<>();

        try {
            String content = new String(Files.readAllBytes(Paths.get("faturamento.json")));
            JSONArray jsonArray = new JSONObject(content).getJSONArray("faturamento");

            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                double valor = jsonObject.optDouble("valor", 0);
                if (valor > 0) {
                    faturamentos.add(valor);
                }
            }

            if (!faturamentos.isEmpty()) {
                double menorFaturamento = faturamentos.stream().min(Double::compare).orElse(0.0);
                double maiorFaturamento = faturamentos.stream().max(Double::compare).orElse(0.0);

                double somaFaturamento = faturamentos.stream().mapToDouble(Double::doubleValue).sum();
                double mediaMensal = somaFaturamento / faturamentos.size();

                long diasAcimaDaMedia = faturamentos.stream().filter(valor -> valor > mediaMensal).count();

                System.out.printf("Menor valor de faturamento: R$ %.2f%n", menorFaturamento);
                System.out.printf("Maior valor de faturamento: R$ %.2f%n", maiorFaturamento);
                System.out.println("Número de dias com faturamento acima da média: " + diasAcimaDaMedia);
            } else {
                System.out.println("Nenhum faturamento disponível para cálculo.");
            }
        } catch (IOException e) {
            System.err.println("Erro ao ler o arquivo: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Erro inesperado: " + e.getMessage());
        }
    }
}