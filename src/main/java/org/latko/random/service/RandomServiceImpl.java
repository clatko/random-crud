package org.latko.random.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.latko.random.dao.RandomDao;
import org.latko.random.model.RandomModel;

@Service
public class RandomServiceImpl implements RandomService {
    @Autowired
    RandomDao randomDao;

    @Override
    public RandomModel create(final RandomModel random) {
    	// do fancy stuff with request
    	RandomModel model = new RandomModel(random);
    	return randomDao.save(model);
    }

    @Override
    public List<RandomModel> list() throws RandomServiceException {
    	final Iterable<RandomModel> findAll = randomDao.findAll();
        final List<RandomModel> result = new ArrayList<RandomModel>();
        for(final RandomModel rm : findAll) {
        	result.add(rm);
        }
        return result;
    }

    @Override
    public RandomModel update(final RandomModel random) {
        final RandomModel model = randomDao.findById(random.getId());

        if(random != null) {
        	// do neat stuff
        	model.setName(random.getName());
        	randomDao.update(model);
        }
        return model;
    }

    @Override
    public void delete(final String randomId) {
        final RandomModel random = randomDao.findById(randomId);
        if(random != null) {
        	randomDao.delete(random.getId());
        }
    }
}
