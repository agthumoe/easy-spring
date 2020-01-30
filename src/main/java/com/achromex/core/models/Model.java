/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.achromex.core.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * Every data model which requires a unique ID should extend this class.
 *
 * @author Aung Thu Moe
 * @since 1.0.0
 */
@MappedSuperclass
public abstract class Model implements Serializable {

    private static final long serialVersionUID = 9146445559940027449L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Model model = (Model) o;
        return id.equals(model.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
