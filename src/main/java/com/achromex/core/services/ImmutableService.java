/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.achromex.core.services;

import com.achromex.core.models.DateStampedModel;

import java.util.List;

/**
 * This interface extends {@link com.achromex.core.services.Service}.
 * Any entity which extends {@link com.achromex.core.models.DateStampedModel} should have a service which
 * extends this interface.
 *
 * @author Aung Thu Moe
 * @since 1.0.0
 */
public interface ImmutableService<T extends DateStampedModel> extends Service<T> {

    /**
     * Create a list of entities provided.
     *
     * @param entities to be saved.
     * @return a list of created entities.
     */
    List<T> create(List<T> entities);

    /**
     * Delete a list of given id.
     *
     * @param ids to be deleted.
     * @since 1.1.0
     */
    void delete(List<Long> ids);
}
