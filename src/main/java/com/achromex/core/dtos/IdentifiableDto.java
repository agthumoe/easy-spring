package com.achromex.core.dtos;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

/**
 * Provides id, createdDate and lastModifiedDate to be able to identified its identity.
 * All dto which requires those 3 fields should extends this class.
 *
 * @author Aung Thu Moe
 * @since 1.2.0
 */
public abstract class IdentifiableDto implements Serializable {
    private static final long serialVersionUID = -4162074065855260953L;

    @ApiModelProperty(hidden = true)
    private Long id;

    @ApiModelProperty(hidden = true)
    private Date createdDate;

    @ApiModelProperty(hidden = true)
    private Date lastModifiedDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(Date lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }
}
