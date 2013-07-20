package com.monthcat.dao;

import java.io.Serializable;
import java.util.Collection;

import org.hibernate.Criteria;

public interface ObjectDaoI<T> {
	public Serializable save(T o);

	public void update(T o);

	@SuppressWarnings("rawtypes")
	public T findById(Class T, Integer id);

	public void delete(T o);

	@SuppressWarnings("rawtypes")
	public Collection<T> findByProperty(Class clazz, String propertyName,
			Object o);

	@SuppressWarnings("rawtypes")
	public Collection<T> findAll(Class clazz);

	@SuppressWarnings("rawtypes")
	public Collection<T> findByPropertyAndLimit(Class clazz,
			String propertyName, Object o, Integer start, Integer limit);

	public Criteria getCriteria(Class clazz);

	public Collection<T> listCriteria(Criteria crit);
}
