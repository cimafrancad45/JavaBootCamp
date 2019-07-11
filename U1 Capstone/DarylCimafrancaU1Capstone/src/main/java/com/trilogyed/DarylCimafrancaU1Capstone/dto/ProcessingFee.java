package com.trilogyed.DarylCimafrancaU1Capstone.dto;

import java.math.BigDecimal;
import java.util.Objects;

public class ProcessingFee {
    private String productType;
    private BigDecimal fee;

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public BigDecimal getFee() {
        return fee;
    }

    public void setFee(BigDecimal fee) {
        this.fee = fee;
    }
}
