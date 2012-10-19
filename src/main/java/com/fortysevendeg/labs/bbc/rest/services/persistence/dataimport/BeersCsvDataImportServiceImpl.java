package com.fortysevendeg.labs.bbc.rest.services.persistence.dataimport;

import au.com.bytecode.opencsv.CSVReader;
import com.fortysevendeg.labs.bbc.rest.model.Beer;
import com.fortysevendeg.labs.bbc.rest.services.persistence.DataImportService;
import com.fortysevendeg.labs.bbc.rest.services.persistence.PersistenceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.io.FileReader;

/**
 *
 */
@Service
public class BeersCsvDataImportServiceImpl implements DataImportService, ApplicationListener<ContextRefreshedEvent> {

    private static final Logger logger = LoggerFactory.getLogger(BeersCsvDataImportServiceImpl.class);

    @Autowired
    @Qualifier("JPA")
    private PersistenceService persistenceService;

    @Value("classpath:beers.csv")
    private Resource resource;

    @Override
    public synchronized void onApplicationEvent(ContextRefreshedEvent event) {
        try {
            if (persistenceService.count(Beer.class) == 0) {
                CSVReader reader = new CSVReader(new FileReader(resource.getFile()));
                reader.readNext(); //skip first line with headers
                String[] beer;
                while ((beer = reader.readNext()) != null) {
                    try {
                        Beer persistentBeer = new Beer();
                        persistentBeer.setId(Long.parseLong(beer[0]));
                        persistentBeer.setName(beer[2]);
                        persistentBeer.setDescription(beer[10]);
                        persistentBeer.setAvb(Double.parseDouble(beer[5]));
                        persistenceService.create(persistentBeer);
                        logger.debug(String.format("imported: %s", persistentBeer.getName()));
                    } catch (Throwable t) {
                        logger.error("error importing beers", t.getMessage());
                    }
                }
                reader.close();
            }
        } catch (Exception ex) {
            logger.error("error importing beers", ex.getMessage());
        }
    }


}
