/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.achromex.core.models;

import org.springframework.data.annotation.CreatedDate;

import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

/**
 * Any data model which extends DateStampedModel will be stamped with a createdDate, with an id.
 *
 * @author Aung Thu Moe
 * @since 1.0.0
 */
@MappedSuperclass
public abstract class DateStampedModel extends Model {

    private static final long serialVersionUID = 5752925653889009095L;

    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date createdDate;

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }
}
