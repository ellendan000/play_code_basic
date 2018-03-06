package net.shadow.withspring.entity;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.List;

import static javax.persistence.CascadeType.ALL;

@Entity
@Table(name = "car")
public class Car {
    @Id
    @GeneratedValue
    private Long id;

    @OneToMany(cascade = ALL, mappedBy = "belongsTo")
    @Fetch(FetchMode.JOIN)
    private List<Wheel> wheels;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Wheel> getWheels() {
        return wheels;
    }

    public void setWheels(List<Wheel> wheels) {
        this.wheels = wheels;
    }
}
