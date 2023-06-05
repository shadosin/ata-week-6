package com.kenzie.book;

public class Genre {
    private String title;
    private String bookType;

    public Genre (String title){
        
    }

    public Genre(String title, String bookType) {
        this.title = title;
        this.bookType = bookType;
    }

    public String getTitle() {
        return title;
    }
}
