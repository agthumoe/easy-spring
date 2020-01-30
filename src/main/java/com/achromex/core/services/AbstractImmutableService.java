/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.achromex.core.services;

import com.achromex.core.models.DateStampedModel;
import com.achromex.core.repositores.CoreRepository;
import com.achromex.core.utils.DateTimeProvider;

import java.util.List;
import java.util.stream.Collectors;

/**
 * This abstract class implements {@link com.achromex.core.services.ImmutableService}.
 * Any entity which extends {@link com.achromex.core.models.DateStampedModel} should extends this abstract class.
 *
 * @author Aung Thu Moe
 * @see com.achromex.core.services.ImmutableService
 * @see com.achromex.core.models.DateStampedModel
 * @since 1.0.0
 */
public abstract class AbstractImmutableService<T extends DateStampedModel> extends
    AbstractService<T> implements ImmutableService<T> {

    /**
     * Construct the service with the relevant repository.
     *
     * @param repository       to be used for this service.
     */
    public AbstractImmutableService(CoreRepository<T> repository) {
        super(repository);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public T create(T entity) {
        return super.create(entity);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<T> create(List<T> entities) {
        return entities.stream().map(this::create).collect(Collectors.toList());
    }

    @Override
    public void delete(List<Long> ids) {
        ids.forEach(super::delete);
    }
}
