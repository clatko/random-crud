package org.latko.random.service;


import java.util.List;

import org.latko.random.model.RandomModel;

public interface RandomService {
    public RandomModel create(RandomModel randomModel);
    public List<RandomModel> list() throws RandomServiceException;
    public RandomModel update(RandomModel randomModel);
    public void delete(String randomId);
}
