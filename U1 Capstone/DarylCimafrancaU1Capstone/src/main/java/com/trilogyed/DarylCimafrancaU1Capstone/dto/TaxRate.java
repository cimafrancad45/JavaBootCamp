package com.trilogyed.DarylCimafrancaU1Capstone.dto;

import java.math.BigDecimal;
import java.util.Objects;

public class TaxRate {
    private String state;
    private BigDecimal rate;

    public String getState() {
        return state;
    }

    public BigDecimal getRate() {
        return rate;
    }
}
