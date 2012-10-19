package com.fortysevendeg.labs.bbc.rest.services.api.request;

/**
 * Request object to create an update beers
 */
public class BeerRequest {

    /**
     * the beer's first name
     */
    private String name;

    /**
     * the beer's description
     */
    private String description;

    /**
     * the beer alcohol volume
     */
    private Double avb;

    /**
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the beer name
     * @param name the beer name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the beer description
     * @return the beer last name
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the beer description
     * @param description the beer description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Gets the beer alcohol volume
     * @return the beer alcohol volume
     */
    public Double getAvb() {
        return avb;
    }

    /**
     * Sets the beer alcohol volume
     * @param avb the beer alcohol volume
     */
    public void setAvb(Double avb) {
        this.avb = avb;
    }
}
