package fr.univrouen.rss22.entities;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "image")
@XmlAccessorType(XmlAccessType.PROPERTY)
@Entity
@Data
public class Image {

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public String getAlt() {
        return alt;
    }

    public void setAlt(String alt) {
        this.alt = alt;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    @Id
    @GeneratedValue
    private Long id;

    @XmlAttribute(name = "type")
    @Column
    private String type;

    @XmlAttribute(name = "href")
    @Column
    private String href;

    @XmlAttribute(name = "alt")
    @Column
    private String alt;

    @XmlAttribute(name = "length")
    @Column
    private int length;
}
