package org.com.br.Estrutura;

import java.util.Map;

public class MoedaRecebida {
    private String moedaRecebida;

    public MoedaRecebida(String moedaRecebida) {
        this.moedaRecebida = moedaRecebida;
    }

    public String getMoedaRecebida() {
        return moedaRecebida;
    }

    public void setMoedaRecebida(String moedaRecebida) {
        this.moedaRecebida = moedaRecebida;
    }

    public Map<String, Double> conversionRates() {
        return Map.of(
                "USD", 5.25,
                "EUR", 6.20,
                "GBP", 7.10,
                "BRL", 1.00,
                "ARS", 0.05,
                "CHF", 5.70
        );
    }
}
