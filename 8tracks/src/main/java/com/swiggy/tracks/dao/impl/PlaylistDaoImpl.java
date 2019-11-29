package com.swiggy.tracks.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.swiggy.tracks.dao.PlaylistDao;
import com.swiggy.tracks.dto.Playlist;

@Repository("playlistDao")
@Transactional
public class PlaylistDaoImpl implements PlaylistDao {

	private static final Logger LOGGER = LoggerFactory.getLogger(PlaylistDaoImpl.class);

	@Autowired
	private EntityManager entityManager;

	public void save(Playlist playlist) {
		entityManager.persist(playlist);
		entityManager.flush();
	}

	public Playlist fetch(String playlistName) {
		try {
			Session session = (Session) entityManager.getDelegate();
			Criteria criteria = session.createCriteria(Playlist.class);
			criteria.add(Restrictions.in("name", playlistName));
			return (Playlist) criteria.uniqueResult();
		} catch (NoResultException noResultException) {
			LOGGER.error("Playlist details not found for playlistName {} ", playlistName, noResultException);
			return null;
		}
	}

	public List<Playlist> findByTag(List<String> tags) {
		try {
			Session session = (Session) entityManager.getDelegate();
			Criteria criteria = session.createCriteria(Playlist.class);
			criteria.add(Restrictions.in("tag", tags));
			return criteria.list();
		} catch (NoResultException noResultException) {
			LOGGER.error("Playlist details not found for tag {} ", tags, noResultException);
			return null;
		}
	}

	public List<Playlist> explore(List<String> tags) {
		List<String> tgs = new ArrayList<String>();
		for(String tag:tags) {
			tgs.add("'"+tag+"'");
		}
		//join playlist_tags tg on (tg.id=pl.tag) where tg.id IN ("+StringUtils.join(tgs, ",")+")
		String sql = "SELECT pl.id, pl.name FROM playlist pl join playlist_activity pla on (pl.id=pla.playlistId) order by pla.plays, pla.likes desc";
		Session session = this.entityManager.unwrap(Session.class);
		SQLQuery query = session.createSQLQuery(sql.toString()).addScalar("id").addScalar("name");
		query.setResultTransformer(Transformers.aliasToBean(Playlist.class));
		LOGGER.debug("Executing sql {}", sql);
		List<Playlist> responses = query.list();
		return responses;
	}
	
	public void update(Playlist playlist) {
		entityManager.merge(playlist);
		entityManager.flush();
	}
	
	
}
