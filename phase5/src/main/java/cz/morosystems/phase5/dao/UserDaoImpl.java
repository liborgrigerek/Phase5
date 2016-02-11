package cz.morosystems.phase5.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import cz.morosystems.phase5.entity.UserEntity;
import cz.morosystems.phase5.exception.UserNotFoundException;

@Repository
public class UserDaoImpl implements UserDAO  {

	@Autowired
    private SessionFactory sessionFactory;
	
	@Transactional
	@SuppressWarnings("unchecked")
	public List<UserEntity> getAllUsers() {
		return this.sessionFactory.getCurrentSession().createCriteria(UserEntity.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).addOrder(Order.asc("id")).list();
	}
	
	@Transactional
	public UserEntity getUser(Integer id) {
		UserEntity user = (UserEntity) sessionFactory.getCurrentSession().createQuery("from UserEntity user where user.id = :id").setParameter("id", id).uniqueResult();
		return user;
	}
	
	@Transactional
	public UserEntity getUserWithLinks(Integer id) {
		UserEntity user = getUser(id);
		// tady toto bylo pridano jako podpora pro LAZY
		Hibernate.initialize(user.getAccounts());
		//Hibernate.initialize(user.getBooks());
		return user;
	}
}
