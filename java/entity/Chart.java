package entity;

import javax.persistence.*;

/**
 * Chart table having an id and reference to an album id, used for remembering albums in some order
 * such as by release year, as it is implemented in ChartRepository class
 */

@Entity
@Table(name="Chart")
public class Chart {
    @Id
    @GeneratedValue
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @OneToOne
    private int album_id;

    public int getAlbum_id() {
        return album_id;
    }

    public void setAlbum_id(int album_id) {
        this.album_id = album_id;
    }
}
