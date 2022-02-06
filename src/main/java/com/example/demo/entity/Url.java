package com.example.demo.entity;



import javax.persistence.*;

@Entity
@Table(name = "url")
public class Url {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;
    @Column
    private String nameURl;
    @Column
    private String shortURL;
    @Column
    private int count;


    public Url() {
    }

    public String getNameURl() {
        return nameURl;
    }

    public void setNameURl(String nameURl) {
        this.nameURl = nameURl;
    }

    public String getShortURL() {
        return shortURL;
    }

    public void setShortURL(String shortURL) {
        this.shortURL = shortURL;
    }

    public void setId(int id) {
        this.id = id;
    }


    public int getId() {
        return id;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
