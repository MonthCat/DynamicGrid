package com.monthcat.dao.impl;

import java.io.Serializable;
import java.util.Collection;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

import com.monthcat.dao.ObjectDaoI;

public class ObjectDaoImpl<T> implements ObjectDaoI<T> {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Serializable save(T o) {
		return sessionFactory.getCurrentSession().save(o);
	}

	@Override
	public void delete(T o) {
		sessionFactory.getCurrentSession().delete(o);
	}

	@Override
	public void update(T o) {
		sessionFactory.getCurrentSession().update(o);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public T findById(Class clazz, Integer id) {
		return (T) sessionFactory.getCurrentSession().load(clazz, id);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public Collection<T> findByProperty(Class clazz, String propertyName,
			Object o) {
		Criteria ct = sessionFactory.getCurrentSession().createCriteria(clazz);
		ct.add(Restrictions.eq(propertyName, o));
		return ct.list();
	}

	public Criteria getCriteria(Class clazz) {
		return sessionFactory.getCurrentSession().createCriteria(clazz);
	}
	
	public Collection<T> listCriteria(Criteria crit){
		return crit.list();
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public Collection<T> findAll(Class clazz) {
		return sessionFactory.getCurrentSession().createCriteria(clazz).list();
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public Collection<T> findByPropertyAndLimit(Class clazz,
			String propertyName, Object o, Integer start, Integer limit) {
		Criteria ct = sessionFactory.getCurrentSession().createCriteria(clazz);
		ct.setFirstResult(start);
		ct.setMaxResults(limit);
		ct.add(Restrictions.eq(propertyName, o));
		return ct.list();
	}

}
