package net.cefacem.app.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;

public interface GenericDAO<E, PK extends Serializable> {
	
	public PK save(E newInstance);
	public void saveOrUpdate(E transientObject);
	public E merge(E transientObject);
	public void delete(E persistentObject);
	public E findById(PK id);
	public List<E> findAll();
	public Session getSession();
}
