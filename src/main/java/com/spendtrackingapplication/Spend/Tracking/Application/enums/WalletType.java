package com.spendtrackingapplication.Spend.Tracking.Application.enums;

public enum WalletType {
    BASIC(50000L,"basic"),STANDARD(80000L,"standard"),PREMIUM(100000L,"prmimum");
    private Long amount;
    private String name;
    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    WalletType(Long amount, String name) {
        this.amount = amount;
        this.name = name;
    }
}

