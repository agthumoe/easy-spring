/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.achromex.core.services;

import com.achromex.core.models.MutableModel;

/**
 * This interface extends {@link com.achromex.core.services.ImmutableService}.
 * Any entity which extends {@link com.achromex.core.models.MutableModel} should have a service which
 * extends this interface.
 *
 * @author Aung Thu Moe
 * @since 1.0.0
 */
public interface MutableService<T extends MutableModel> extends ImmutableService<T> {

    /**
     * Update the given entity.
     *
     * @param entity to be updated.
     * @return the updated entity.
     */
    T update(T entity);
}
