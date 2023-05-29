package com.kenzie.book;

import java.math.BigDecimal;
import java.util.Set;

public class Book {
    private ProductInformation productInformation;
    private String author;
    private BigDecimal length;

    public Book(ProductInformation productInformation, String author, BigDecimal length) {
        this.productInformation = productInformation;
        this.author = author;
        this.length = length;
    }

    public String getAsin() {
        return null;
    }

    public String getTitle() {
        return null;
    }

    public String getAuthor() {
        return null;
    }

    public String getDescription() {
        return null;
    }

    public Set<String> getImageUrls() {
        return null;
    }

    public BigDecimal getLength() {
        return null;
    }

    public double calculateSimilarity(Book other) {
        return 0;
    }

    @Override
    public int hashCode() {
        return 0;
    }

    @Override
    public boolean equals(Object o) {
        return false;
    }
}