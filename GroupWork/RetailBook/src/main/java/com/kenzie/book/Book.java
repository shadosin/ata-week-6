package com.kenzie.book;

import java.math.BigDecimal;
import java.util.Objects;
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
        return productInformation.getAsin();
    }

    public String getTitle() {
        return productInformation.getDisplayName();
    }

    public String getAuthor() {
        return author;
    }

    public String getDescription() {
        return productInformation.getDescription();
    }

    public Set<String> getImageUrls() {
        return productInformation.getImageUrls();
    }

    public BigDecimal getLength() {
        return length;
    }

    public double calculateSimilarity(Book other) {
        return productInformation.calculateSimilarity(other.productInformation);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Book book)) return false;
        return productInformation.getAsin().equals(((Book) o).getAsin());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getAsin());
    }
}

