package com.fortysevendeg.labs.bbc.rest.model;

/**
 * Interface for entities that declare themselves as persistent to control access through the Persistence Adapter
 */
public interface PersistentObject {

    /**
     * Gets the entity id
     * @return the entity id
     */
    Long getId();

    /**
     * Sets the entity id
     * @param id the entity id
     */
    void setId(Long id);

}
