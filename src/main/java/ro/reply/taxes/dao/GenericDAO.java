package ro.reply.taxes.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

public abstract class GenericDAO<T> {

	@Autowired
	public SessionFactory sessionFactory;

	@Transactional(propagation = Propagation.MANDATORY)
	public void persist(T entity) {
		sessionFactory.getCurrentSession().saveOrUpdate(entity);
	}

	@Transactional(propagation = Propagation.MANDATORY)
	public void update(final T entity) {
		sessionFactory.getCurrentSession().update(entity);
	}

	@Transactional(propagation = Propagation.MANDATORY)
	public void delete(final T entity) {
		sessionFactory.getCurrentSession().delete(entity);
	}
}
