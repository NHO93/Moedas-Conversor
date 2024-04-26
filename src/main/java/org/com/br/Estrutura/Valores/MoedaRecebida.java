package org.com.br.Estrutura.Valores;

import java.util.Map;

public record MoedaRecebida
        (String result, String baseCode,
         Map<String, Double> conversionRates){
}
