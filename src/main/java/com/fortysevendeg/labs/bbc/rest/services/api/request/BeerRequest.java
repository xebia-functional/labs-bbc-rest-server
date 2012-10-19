package com.fortysevendeg.labs.bbc.rest.services.api.request;

/**
 * Request object to create an update users
 */
public class BeerRequest {

    /**
     * the user's first name
     */
    private String firstName;

    /**
     * the user's lastName
     */
    private String lastName;

    /**
     *
     * @return the first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets the user first name
     * @param firstName the user first name
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Gets the user last name
     * @return the user last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets the user last name
     * @param lastName the user last name
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
