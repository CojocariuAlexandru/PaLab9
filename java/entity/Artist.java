package entity;

import javax.persistence.*;

/**
 * Artist table having id, name and country
 */
@Entity
@Table(name = "artist")
public class Artist {
    public Artist(int id, String name, String country){
        this.id = id;
        this.name = name;
        this.country = country;
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

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    private String country;

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }


}
