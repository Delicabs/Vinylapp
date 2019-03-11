package com.example.vinska.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
public class Vinyl {
@Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private long id;
    private String artist, albumName, label;
    private int year, amount;
    private double price, lastSoldPrice;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "genreId")
    private Genre genre;

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public Vinyl(){
        artist="";
        albumName="";
        label="";
        year=0;
        amount=0;
        price=0.00;
        lastSoldPrice=0.00;
        genre=null;

    }

    public Vinyl(String artist, String albumName, String label, int year, int amount, double price, double lastSoldPrice, Genre genre) {
        this.artist = artist;
        this.albumName = albumName;
        this.label = label;
        this.year = year;
        this.amount = amount;
        this.price = price;
        this.lastSoldPrice = lastSoldPrice;
        this.genre = genre;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getAlbumName() {
        return albumName;
    }

    public void setAlbumName(String albumName) {
        this.albumName = albumName;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getLastSoldPrice() {
        return lastSoldPrice;
    }

    public void setLastSoldPrice(double lastSoldPrice) {
        this.lastSoldPrice = lastSoldPrice;
    }

    @Override
    public String toString() {
        if (this.genre != null)
        return "Vinyl{" + "id=" + id + ", artist='" + artist + '\'' + ", albumName='" + albumName + '\'' + ", label='" + label + '\'' + ", year=" + year + ", amount=" + amount + ", price=" + price + ", lastSoldPrice=" + lastSoldPrice + ", genre=" + this.getGenre() + '}';
        else
            return "Vinyl{" + "id=" + id + ", artist='" + artist + '\'' + ", albumName='" + albumName + '\'' + ", label='" + label + '\'' + ", year=" + year + ", amount=" + amount + ", price=" + price + ", lastSoldPrice=" + lastSoldPrice +'}';

    }
}
