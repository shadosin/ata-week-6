package com.kenzie.freshfruit;


import java.util.Objects;

public class FreshFruit {

    private String name;
    private boolean isSeedless;
    private long purchaseCount;

    public FreshFruit(String name, boolean isSeedless, long purchaseCount) {
        this.name = name;
        this.isSeedless = isSeedless;
        this.purchaseCount = purchaseCount;
    }

    // Updates the current purchase count by the provided purchaseQuantity
    public void addPurchase(int purchaseQuantity) {
        this.purchaseCount = this.purchaseCount + purchaseQuantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FreshFruit that)) return false;
        return isSeedless == that.isSeedless && name.equals(that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, isSeedless);
    }
}
