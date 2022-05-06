package fr.univrouen.rss22.entities;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;

@XmlAccessorType(XmlAccessType.PROPERTY)
@Entity
@Data
public class Author {

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getUri() {
        return uri;
    }

    @Id
    @GeneratedValue
    private Long id;

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    @XmlAttribute
    @Column
    private String name;
    @XmlAttribute
    @Column
    private String email;
    @XmlAttribute
    @Column
    private String uri;
}
