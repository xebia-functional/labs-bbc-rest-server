package com.fortysevendeg.labs.bbc.rest.services.api.response;

import com.fortysevendeg.labs.bbc.rest.model.Beer;

import java.util.ArrayList;
import java.util.List;

/**
 * A response objects that encapsulates list of beers
 */
public class BeerResponseList {

    private List<BeerResponse> beers = new ArrayList<BeerResponse>();

    private BeerResponseList(Iterable<Beer> beers) {
        if (beers != null) {
            for (Beer beer : beers) {
                this.beers.add(BeerResponse.createBeerResponse(beer));
            }
        }
    }

    public static BeerResponseList create(Iterable<Beer> beers) {
        return new BeerResponseList(beers);
    }

    public List<BeerResponse> getBeers() {
        return beers;
    }

}
