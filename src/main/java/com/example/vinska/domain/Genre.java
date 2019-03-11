package com.example.vinska.domain;

import javax.persistence.*;
import java.util.List;

@Entity
public class Genre {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long genreId;
    private String type;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "genre")
    private List<Vinyl> vinyls;

    public Genre(){

    }

    public Genre(String type) {
        super();
        this.type = type;
    }

    public long getGenreId() {
        return genreId;
    }

    public void setGenreId(long genreId) {
        this.genreId = genreId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<Vinyl> getVinyls() {
        return vinyls;
    }

    public void setVinyls(List<Vinyl> vinyls) {
        this.vinyls = vinyls;
    }

    @Override
    public String toString() {
        return "Genre{" + "genreId=" + genreId + ", type='" + type + '\'' + '}';
    }
}