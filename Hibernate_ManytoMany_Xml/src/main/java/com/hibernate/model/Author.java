package com.hibernate.model;


import java.util.Set;

public class Author {

    private int authorId;
    private String authorName;
    private String authorAddress;
    private Set books;

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getAuthorAddress() {
        return authorAddress;
    }

    public void setAuthorAddress(String authorAddress) {
        this.authorAddress = authorAddress;
    }

    public Set getBooks() {
        return books;
    }

    public void setBooks(Set books) {
        this.books = books;
    }

}