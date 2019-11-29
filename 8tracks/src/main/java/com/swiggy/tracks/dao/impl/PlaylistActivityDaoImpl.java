package com.swiggy.tracks.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.swiggy.tracks.dao.PlaylistActivityDao;
import com.swiggy.tracks.dto.PlaylistActivity;

@Repository("playlistActivityDao")
@Transactional
public class PlaylistActivityDaoImpl implements PlaylistActivityDao {

	private static final Logger LOGGER = LoggerFactory.getLogger(PlaylistActivityDaoImpl.class);

	@Autowired
	private EntityManager entityManager;

	public void save(PlaylistActivity activity) {
		this.entityManager.persist(activity);
		this.entityManager.flush();
	}

	public void update(PlaylistActivity activity) {
		this.entityManager.merge(activity);
		this.entityManager.flush();
	}

	public PlaylistActivity fetchByPlaylistId(int playlistId) {
		try {
			Session session = (Session) entityManager.getDelegate();
			Criteria criteria = session.createCriteria(PlaylistActivity.class);
			criteria.add(Restrictions.in("playlistId", playlistId));
			return (PlaylistActivity) criteria.uniqueResult();
		} catch (NoResultException noResultException) {
			LOGGER.error("PlaylistActivity details not found for playlistId {} ", playlistId, noResultException);
			return null;
		}
	}

}
