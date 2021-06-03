package com.victim.viccompleteboot.models;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "sanctionlist")
public class Sanction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String status;
    private LocalDateTime dateinserted = LocalDateTime.now();
    private Date dateupdated;
    private String source;

    public Sanction() {
    }

    public Sanction(int id, String name, String status, LocalDateTime dateinserted, Date dateupdated, String source) {
        this.id = id;
        this.name = name;
        this.status = status;
        this.dateinserted = dateinserted;
        this.dateupdated = dateupdated;
        this.source = source;
    }

    @Override
    public String toString() {
        return "Sanction{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", status='" + status + '\'' +
                ", dateinserted=" + dateinserted +
                ", dateupdated=" + dateupdated +
                ", source='" + source + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getDateupdated() {
        return dateupdated;
    }

    public void setDateupdated(Date dateupdated) {
        this.dateupdated = dateupdated;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

}
