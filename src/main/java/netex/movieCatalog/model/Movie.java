package netex.movieCatalog.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.solr.client.solrj.beans.Field;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "moviestabel")
public class Movie implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Field
    private Integer id;

    @JsonProperty("Title")
    @Field
    private String title;

    @JsonProperty("Year")
    @Field
    private String releaseyear;

    @JsonProperty("imdbID")
    @Field
    private String imdbid;

    @JsonProperty("Type")
    @Field
    private String type;

    @JsonProperty("Poster")
    @Field
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
