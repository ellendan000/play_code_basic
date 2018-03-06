package net.shadow.withspring.entity;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;

import static javax.persistence.CascadeType.*;
import static javax.persistence.CascadeType.DETACH;

@Entity
@Table(name = "wheel")
public class Wheel {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne(cascade = { PERSIST, MERGE, REFRESH, DETACH })
    @JoinColumn(name = "car_id")
    @NotFound(action = NotFoundAction.EXCEPTION)
    private Car belongsTo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Car getBelongsTo() {
        return belongsTo;
    }

    public void setBelongsTo(Car belongsTo) {
        this.belongsTo = belongsTo;
    }
}
