/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.achromex.core.models;

import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

/**
 * Any data model which extends MutableModel will contain a unique id, createdDate and lastModifiedDate.
 *
 * @author Aung Thu Moe
 * @since 1.0.0
 */
@MappedSuperclass
public abstract class MutableModel extends DateStampedModel {

    private static final long serialVersionUID = -5427271280750032834L;

    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    private Date lastModifiedDate;

    public Date getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(Date LastModifiedDate) {
        this.lastModifiedDate = LastModifiedDate;
    }
}
