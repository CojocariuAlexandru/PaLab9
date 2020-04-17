package entity;

import javax.persistence.*;

/**
 * Album table having id, release year, name, genre, and artist reference as foreign key
 */
@Entity
@Table(name = "album")
public class Album {
    public Album(int id, int release_year, String name, Artist artist){
        this.id = id;
        this.release_year = release_year;
        this.name = name;
        this.artist = artist;
    }
    @Id
    @GeneratedValue
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private int release_year;

    public int getRelease_year() {
        return release_year;
    }

    public void setRelease_year(int release_year) {
        this.release_year = release_year;
    }


    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @OneToOne
    Artist artist;


    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    private String musicGenre;

    public String getMusicGenre() {
        return musicGenre;
    }

    public void setMusicGenre(String musicGenre) {
        this.musicGenre = musicGenre;
    }
}
