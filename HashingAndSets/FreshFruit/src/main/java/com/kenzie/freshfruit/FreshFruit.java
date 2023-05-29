package com.kenzie.freshfruit;


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

        //TODO: Change this line to actually check for equality
        return false;
    }

    @Override
    public int hashCode() {
        //TODO: Change this line to actually check for equality
        return 0;
    }
}
