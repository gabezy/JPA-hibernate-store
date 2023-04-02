package br.com.storeJPA.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;
@Entity
@Table(name = "book")
public class Book extends Product{

    private String author;
    private int pages;
    private int releasedYear;

    public Book(){}
    public Book(String author, int pages, int releasedYear){
        this.author = author;
        this.pages = pages;
        this.releasedYear = releasedYear;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public int getReleasedYear() {
        return releasedYear;
    }

    public void setReleasedYear(int releasedYear) {
        this.releasedYear = releasedYear;
    }
}
