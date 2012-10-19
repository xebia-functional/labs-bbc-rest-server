package com.fortysevendeg.labs.bbc.rest.services.api.response;

import com.fortysevendeg.labs.bbc.rest.model.Beer;

/**
 * A delegate based wrapper to expose certain properties of the Beer entity
 */
public class BeerResponse {

    /**
     * internal delegate
     */
    private Beer delegate;

    /**
     * Private constructor prevents from external instantiation
     * @param delegate
     */
    private BeerResponse(Beer delegate) {
        this.delegate = delegate;
    }

    /**
     * Public factory method
     * @param delegate the Beer delegate
     * @return a user response that delegates property calls to a Beer
     */
    public static BeerResponse createBeerResponse(Beer delegate) {
        return new BeerResponse(delegate);
    }

    /**
     *
     * @return the beer id
     */
    public Long getId() {
        return delegate.getId();
    }

    /**
     *
     * @return the beer first name
     */
    public String getName() {
        return delegate.getName();
    }

    /**
     *
     * @return the beer last name
     */
    public String getUpc() {
        return delegate.getUpc();
    }
}
