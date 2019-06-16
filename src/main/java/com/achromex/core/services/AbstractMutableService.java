/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.achromex.core.services;

import com.achromex.core.models.MutableModel;
import com.achromex.core.repositores.CoreRepository;
import com.achromex.core.utils.DateTimeProvider;

import java.util.List;
import java.util.stream.Collectors;

/**
 * This abstract class implements {@link com.achromex.core.services.MutableService}.
 * Any entity which extends {@link com.achromex.core.models.MutableModel} should extends this abstract class.
 *
 * @author Aung Thu Moe
 * @see com.achromex.core.services.MutableService
 * @see com.achromex.core.models.MutableModel
 * @since 1.0.0
 */
public abstract class AbstractMutableService<T extends MutableModel> extends
    AbstractImmutableService<T> implements MutableService<T> {

    /**
     * {@inheritDoc}
     */
    public AbstractMutableService(CoreRepository<T> repository, DateTimeProvider dateTimeProvider) {
        super(repository, dateTimeProvider);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public T create(T entity) {
        entity.setLastModifiedDate(dateTimeProvider.now());
        return super.create(entity);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<T> create(List<T> entities) {
        return entities.stream().map(this::create).collect(Collectors.toList());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public T update(T entity) {
        entity.setLastModifiedDate(dateTimeProvider.now());
        return super.repository.save(entity);
    }
}
