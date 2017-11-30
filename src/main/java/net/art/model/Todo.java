package net.art.model;

import com.sun.istack.internal.NotNull;

import java.io.Serializable;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "todo")
public class Todo implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    private Integer id;

    @Column(name = "name")
    @NotNull

    private String name;

    @Column(name = "priority")
    @NotNull
    private Integer priority;

    @Column(name = "status")
    @NotNull
    private String status;

    public Todo(Integer id, String name, Integer priority, String status) {
        super();
        this.id = id;
        this.name = name;
        this.priority = priority;
        this.status = status;
    }

    public Todo() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Todo [id=" + id + ", name=" + name
                + ", priority=" + priority + ", status=" + status + "]";
    }

}