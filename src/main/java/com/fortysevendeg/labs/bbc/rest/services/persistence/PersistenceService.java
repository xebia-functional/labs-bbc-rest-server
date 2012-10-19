package com.fortysevendeg.labs.bbc.rest.services.persistence;

import com.fortysevendeg.labs.bbc.rest.model.PersistentObject;

import java.util.Collection;

/**
 * Defines the allowed persistence operations through a persistence agnostic interface
 */
public interface PersistenceService {

    /**
     * Fetches the list of objects of a given type from the data store
     * @param entityClass the entity class
     * @param <T> the page type
     * @return the list
     */
    <T extends PersistentObject>  long count(Class<T> entityClass);

    /**
     * Fetches the list of objects of a given type from the data store
     * @param entityClass the entity class
     * @param <T> the page type
     * @return the list
     */
    <T extends PersistentObject> Collection<T> list(Class<T> entityClass);

    /**
     * Creates an object and adds it to the data store
     * @param entity the entity
     * @param <T> the entity type
     * @return the merged object
     */
    <T extends PersistentObject> T create(T entity);

    /**
     * Retrieves an object by id
     * @param entityClass  the entity class
     * @param id the entity id
     * @param <T> the entity type
     * @return an object by id
     */
    <T extends PersistentObject> T read(Class<T> entityClass, Long id);

    /**
     * Creates an object and adds it to the data store
     * @param entity the entity
     * @param <T> the entity type
     * @return the merged object
     */
    <T extends PersistentObject> T update(T entity);

    /**
     * Removes an entity from the data store
     * @param entityClass the entity class
     * @param id the entity id
     * @param <T> the entity type
     * @return the removed entity
     */
    <T extends PersistentObject> T delete(Class<T> entityClass, Long id);

}
