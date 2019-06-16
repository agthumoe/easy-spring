/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.achromex.core.services;

import com.achromex.core.models.Model;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

/**
 * Interface for generic CRUD operations on a service level for a specific type which extends {@link com.achromex.core.models.Model}.
 * Any entity which extends {@link com.achromex.core.models.Model} should have a service which extends this interface.
 *
 * @author Aung Thu Moe
 * @see {@link com.achromex.core.models.Model}
 * @since 1.0.0
 */
public interface Service<T extends Model> {

    /**
     * Create a given entity by saving it. Use the returned instance for further operations as the save
     * operation might have changed the entity instance completely.
     *
     * @param entity to be saved.
     * @return the saved entity with the generated ID.
     */
    T create(T entity);

    /**
     * Retrieve an entity by given id.
     *
     * @param id of the entity.
     * @return the found entity from the repository.
     */
    Optional<T> findOne(Long id);

    /**
     * Returns all the entities of the type.
     *
     * @return all the entities.
     */
    List<T> findAll();

    /**
     * Returns a {@link org.springframework.data.domain.Page} of entities meeting the paging restriction provided in
     * the {@link org.springframework.data.domain.Pageable} object.
     *
     * @param pageable - the pagination information.
     * @return A page of entities.
     */
    Page<T> findAll(Pageable pageable);

    /**
     * Delete the entity by the given id.
     *
     * @param id to be deleted.
     */
    void delete(Long id);

    /**
     * Delete the given entity.
     *
     * @param entity to be delete.
     */
    void delete(T entity);

    /**
     * Return the number of entities available.
     *
     * @return the number of entities.
     */
    Long count();

    /**
     * Returns whether an entity with the given id exists.
     *
     * @param id to be checked whether if it is existed or not.
     * @return true if an entity with the given id exists, false otherwise.
     */
    Boolean exist(Long id);
}
