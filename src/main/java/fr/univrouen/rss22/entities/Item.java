package fr.univrouen.rss22.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import javax.xml.bind.annotation.*;
import java.util.Date;
import java.util.List;


@XmlRootElement(name = "item")
@XmlAccessorType(XmlAccessType.FIELD)
@Entity
@Data
public class Item {

    public long getGuid() {
        return guid;
    }

    public String getTitle() {
        return title;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public Date getDate() {
        return date;
    }

    public Image getImage() {
        return image;
    }

    public Content getContent() {
        return content;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public void setGuid(long guid) {
        this.guid = guid;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public void setContent(Content content) {
        this.content = content;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }

    @XmlElement(name = "guid")
    @Id
    @GeneratedValue
    private long guid;

    @XmlElement(name = "title")
    @Column(unique = true)
    private String title;

    @XmlElement(name = "category")

    @OneToMany(cascade = CascadeType.PERSIST)
    private List<Category> categories;

    @XmlElements({
            @XmlElement(name = "published", type = Date.class),
            @XmlElement(name = "updated", type = Date.class)
    })
    @Column(unique = true)
    private Date date;

    @XmlElement(name = "image", type = Image.class)
    @OneToOne(cascade = CascadeType.PERSIST)
    private Image image;

    @XmlElement(name = "content", type = Content.class)
    @OneToOne(cascade = CascadeType.PERSIST)
    @JsonIgnore
    private Content content;

    @XmlElements({
            @XmlElement(name = "author", type = Author.class),
            @XmlElement(name = "contributor", type = Author.class)
    })
    @OneToMany(cascade = CascadeType.PERSIST)
    private List<Author> authors;

}
