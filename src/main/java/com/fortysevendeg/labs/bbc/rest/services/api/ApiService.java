package com.fortysevendeg.labs.bbc.rest.services.api;

import com.fortysevendeg.labs.bbc.rest.services.api.request.BeerRequest;
import com.fortysevendeg.labs.bbc.rest.services.api.response.BeerResponse;
import com.fortysevendeg.labs.bbc.rest.services.api.response.BeerResponseList;

/**
 * API entry point for all user operations
 */
public interface ApiService {

    /**
     * Lists all
     * @return a list of all objects
     */
    BeerResponseList list();

    /**
     * Creates a beer
     * @return the beer api representation response
     */
    BeerResponse create();

    /**
     * Gets a beer
     * @param id a beer id
     * @return the beer api representation response
     */
    BeerResponse get(Long id);

    /**
     * Updates a beer
     * @param id a beer id
     * @return the beer api representation response
     */
    BeerResponse update(Long id, BeerRequest beerRequest);

    /**
     * Deletes a beer
     * @param id a beer id
     * @return the beer api representation response
     */
    BeerResponse delete(Long id);

}
