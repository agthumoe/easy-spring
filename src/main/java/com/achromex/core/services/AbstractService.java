/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.achromex.core.services;

import com.achromex.core.models.Model;
import com.achromex.core.repositores.CoreRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

/**
 * This abstract class implements {@link com.achromex.core.services.Service}.
 * Any entity which extends {@link com.achromex.core.models.Model} should extends this abstract class.
 *
 * @author Aung Thu Moe
 * @see com.achromex.core.services.Service
 * @see com.achromex.core.models.Model
 * @since 1.0.0
 */
public abstract class AbstractService<T extends Model> implements Service<T> {

    protected final CoreRepository<T> repository;

    /**
     * Construct the service with the relevant repository.
     *
     * @param repository to be used for this service.
     */
    public AbstractService(CoreRepository<T> repository) {
        this.repository = repository;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public T create(T entity) {
        return this.repository.save(entity);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Optional<T> findOne(Long id) {
        if (id == null) return Optional.empty();
        return this.repository.findById(id);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<T> findAll() {
        return this.repository.findAll();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Page<T> findAll(Pageable pageable) {
        return this.repository.findAll(pageable);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void delete(Long id) {
        if (id != null) {
            this.repository.deleteById(id);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void delete(T entity) {
        if (entity != null) {
            this.repository.delete(entity);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Boolean exist(Long id) {
        if (id == null) return false;
        return this.repository.existsById(id);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long count() {
        return this.repository.count();
    }
}
