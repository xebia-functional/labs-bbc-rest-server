package com.fortysevendeg.labs.bbc.rest.services.persistence.memory;

import com.fortysevendeg.labs.bbc.rest.model.PersistentObject;
import com.fortysevendeg.labs.bbc.rest.services.persistence.PersistenceService;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

/**
 * In memory implementation of the persistence service
 */
@Service("MEMORY")
@SuppressWarnings("unchecked")
public class MemoryPersistenceServiceImpl implements PersistenceService {

    private AtomicLong idGenerator = new AtomicLong();

    private ConcurrentHashMap<Long, PersistentObject> dataStore = new ConcurrentHashMap<Long, PersistentObject>();

    @Override
    public <T extends PersistentObject> long count(Class<T> entityClass) {
        long count = 0;
        for (Map.Entry<Long, PersistentObject> entry : dataStore.entrySet()) {
            if (entityClass.equals(entry.getValue().getClass())) {
                count++;
            }
        }
        return count;
    }

    @Override
    public <T extends PersistentObject> Collection<T> list(Class<T> entityClass) {
        return (Collection<T>) dataStore.values();
    }

    @Override
    public <T extends PersistentObject> T create(T entity) {
        if (entity.getId() == null) {
            long id = idGenerator.incrementAndGet();
            entity.setId(id);
        }
        dataStore.putIfAbsent(entity.getId(), entity);
        return entity;
    }

    @Override
    public <T extends PersistentObject> T read(Class<T> entityClass, Long id) {
        return (T) dataStore.get(id);
    }

    @Override
    public <T extends PersistentObject> T update(T entity) {
        return (T) dataStore.put(entity.getId(), entity);
    }

    @Override
    public <T extends PersistentObject> T delete(Class<T> entityClass, Long id) {
        return (T) dataStore.remove(id);
    }
}
