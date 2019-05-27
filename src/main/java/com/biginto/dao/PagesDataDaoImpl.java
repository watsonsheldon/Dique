package com.biginto.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.biginto.entities.PagesData;

@Repository
public class PagesDataDaoImpl implements PagesDataDao<PagesData> {
	private static final long serialVersionUID = 1L;

	private EntityManager entityManager;

	public PagesDataDaoImpl() {
		super();
	}

	public PagesDataDaoImpl(EntityManager manager) {
		this();
		entityManager = manager;
	}

	@Override
	public List<PagesData> getAll() {
		Query query = entityManager.createQuery("from PagesData");

		@SuppressWarnings("unchecked")
		List<PagesData> list = query.getResultList();
		entityManager.close();

		return list;

	}
}
