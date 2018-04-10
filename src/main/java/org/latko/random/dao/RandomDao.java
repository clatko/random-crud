package org.latko.random.dao;

import java.util.List;

import org.latko.random.model.RandomModel;

public interface RandomDao {
	public RandomModel save(RandomModel random);
	public List<RandomModel> findAll();
    public RandomModel findById(String randomId);
    public RandomModel update(RandomModel model);
    public void delete(String randomId);
}
