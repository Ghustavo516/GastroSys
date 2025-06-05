package com.pos.restaurante.api.util;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Locale;

public class CurrencyUtil {

    private CurrencyUtil() {
        // Prevent instantiation
    }
    
    public static String formatCurrency(BigDecimal valor) {
        Locale localBrasil =  Locale.of("pt", "BR");
        return NumberFormat.getCurrencyInstance(localBrasil).format(valor);
    }

     
}
