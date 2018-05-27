package com.github.dgarcia202.springcrm.dataaccess.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class CustomerStatus {

    @Id
    private long id;

    private String description;

    public CustomerStatus(long id) {
        setId(id);
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
