package org.latko.random.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import org.latko.random.model.RandomModel;

@Component
public class RandomDaoImpl implements RandomDao {

//    @PersistenceContext
//    private EntityManager _em;


//    @Override
//    @Transactional
    public RandomModel save(RandomModel random) {
        if (random.getId() == null) {
//            _em.persist(random);
        }
        return random;
    }

	@Override
	public List<RandomModel> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RandomModel findById(String randomId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RandomModel update(RandomModel model) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(String randomId) {
		// TODO Auto-generated method stub

	}




}
