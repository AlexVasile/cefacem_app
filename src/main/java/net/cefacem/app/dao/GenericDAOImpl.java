package net.cefacem.app.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public abstract class GenericDAOImpl<E, PK extends Serializable> 
						implements GenericDAO<E, PK> {
	
	private SessionFactory sessionFactory;
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
	@Autowired
	@Qualifier("sessionFactory")
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}
		
	@SuppressWarnings("unchecked")
	public PK save(E newInstance) {
		return (PK) getSession().save(newInstance);
	}

	public void saveOrUpdate(E transientObject) {
		getSession().saveOrUpdate(transientObject);
	}
	
	@SuppressWarnings("unchecked")
	public E merge(E transientObject) {
		return (E) getSession().merge(transientObject);
	}

	public void delete(E persistentObject) {
		getSession().delete(persistentObject);
	}

	@SuppressWarnings("unchecked")
	public E findById(PK id) {
		return (E) getSession().get(getEntityClass(), id);
	}
	
	@SuppressWarnings("unchecked")
	public List<E> findAll() {
		Query query = getSession().createQuery("from " + getEntityClass().getName())
				.setCacheable(true);
		return (List<E>) query.list();
	}
	
	protected abstract Class<E> getEntityClass();
}
