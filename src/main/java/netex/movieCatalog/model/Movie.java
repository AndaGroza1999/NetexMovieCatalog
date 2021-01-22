package netex.movieCatalog.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "movie_tabel")
public class Movie implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;
    private String releaseyear;
    private String imdbid;
    private String type;
    private String poster;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getReleaseYear() {
        return releaseyear;
    }

    public void setReleaseYear(String releaseYear) {
        this.releaseyear = releaseYear;
    }

    public String getImdbid() {
        return imdbid;
    }

    public void setImdbid(String imdbid) {
        this.imdbid = imdbid;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", releaseYear='" + releaseyear + '\'' +
                ", imdbID='" + imdbid + '\'' +
                ", type='" + type + '\'' +
                ", poster='" + poster + '\'' +
                '}';
    }
}
