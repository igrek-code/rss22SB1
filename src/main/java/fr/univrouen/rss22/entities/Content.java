package fr.univrouen.rss22.entities;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.xml.bind.annotation.*;

@XmlRootElement(name = "content")
@XmlAccessorType(XmlAccessType.PROPERTY)
@Entity
@Data
public class Content {

    public String getType() {
        return type;
    }

    public String getHref() {
        return href;
    }

    public String getContent() {
        return content;
    }

    @Id
    @GeneratedValue
    private Long id;

    public void setType(String type) {
        this.type = type;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @XmlAttribute
    @Column
    private String type;
    @XmlAttribute
    @Column
    private String href;
    @XmlValue
    @Column
    private String content;

}
