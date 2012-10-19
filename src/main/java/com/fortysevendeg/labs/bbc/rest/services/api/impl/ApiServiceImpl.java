package com.fortysevendeg.labs.bbc.rest.services.api.impl;

import com.fortysevendeg.labs.bbc.rest.model.Beer;
import com.fortysevendeg.labs.bbc.rest.services.api.ApiService;
import com.fortysevendeg.labs.bbc.rest.services.api.request.BeerRequest;
import com.fortysevendeg.labs.bbc.rest.services.api.response.BeerResponse;
import com.fortysevendeg.labs.bbc.rest.services.api.response.BeerResponseList;
import com.fortysevendeg.labs.bbc.rest.services.persistence.PersistenceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@Controller
@RequestMapping(value = "/api")
public class ApiServiceImpl implements ApiService {

    @Autowired
    @Qualifier("JPA")
    private PersistenceService persistenceService;

	private static final Logger logger = LoggerFactory.getLogger(ApiServiceImpl.class);

    @Override
    @RequestMapping(value = "/beers", method = RequestMethod.PUT)
    @ResponseBody
    @Transactional
    public BeerResponse create() {
        Beer beer = new Beer();
        beer = persistenceService.create(beer);
        return BeerResponse.createBeerResponse(beer);
    }

    @Override
    @RequestMapping(value = "/beers", method = RequestMethod.GET)
    @ResponseBody
    public BeerResponseList list() {
        Collection<Beer> beers = persistenceService.list(Beer.class);
        return BeerResponseList.create(beers);
    }

    @Override
    @RequestMapping(value = "/beers/{id}", method = RequestMethod.GET)
    @ResponseBody
	public BeerResponse get(@PathVariable("id") Long id) {
        Beer beer = persistenceService.read(Beer.class, id);
        return BeerResponse.createBeerResponse(beer);
    }

    @Override
    @RequestMapping(value = "/beers/{id}", method = RequestMethod.POST)
	@ResponseBody
    @Transactional
    public BeerResponse update(@PathVariable("id") Long id, @RequestBody BeerRequest beerRequest) {
        Beer beer = persistenceService.read(Beer.class, id);
        beer.setName(beerRequest.getName());
        beer.setDescription(beerRequest.getDescription());
        beer = persistenceService.update(beer);
        return BeerResponse.createBeerResponse(beer);
    }

    @Override
    @RequestMapping(value = "/beers/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    @Transactional
    public BeerResponse delete(@PathVariable("id") Long id) {
        Beer beer = persistenceService.delete(Beer.class, id);
        return BeerResponse.createBeerResponse(beer);
    }

}
