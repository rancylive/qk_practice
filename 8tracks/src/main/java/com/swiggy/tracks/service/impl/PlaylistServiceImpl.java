package com.swiggy.tracks.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.swiggy.tracks.dao.PlaylistActivityDao;
import com.swiggy.tracks.dao.PlaylistDao;
import com.swiggy.tracks.dto.Playlist;
import com.swiggy.tracks.dto.PlaylistActivity;
import com.swiggy.tracks.service.PlaylistService;

@Service
public class PlaylistServiceImpl implements PlaylistService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(PlaylistServiceImpl.class);

	@Autowired
	private PlaylistDao playlistDao;
	
	@Autowired
	private PlaylistActivityDao playlistActivityDao;
	
	public void save(Playlist playlist) {
		LOGGER.info("Saving [Playlist {}]",playlist);
		Playlist existingPlaylist = playlistDao.fetch(playlist.getName());
		if(existingPlaylist != null) {
			playlist.setId(existingPlaylist.getId());
			playlistDao.update(playlist);
		} else {
			playlistDao.save(playlist);
		}
	}

	public Playlist fetch(String playlistName) {
		LOGGER.info("Fetchign playlist [playlistName {}]",playlistName);
		return playlistDao.fetch(playlistName);
	}
	
	public List<Playlist> explore(List<String> tags) {
		return playlistDao.explore(tags);
	}
	
	public void play(String playlistName) {
		Playlist playlist = playlistDao.fetch(playlistName);
		if(playlist == null) {
			throw new IllegalArgumentException("Can not play. Playlist not found.");
		}
		PlaylistActivity activity = playlistActivityDao.fetchByPlaylistId(playlist.getId());
		if(activity == null) {
			activity = new PlaylistActivity();
			activity.setLikes(1);
			activity.setPlays(1);
			activity.setPlaylistId(playlist.getId());
			playlistActivityDao.save(activity);
		} else {
			activity.setLikes(activity.getLikes()+1);
			activity.setPlays(activity.getPlays()+1);
			playlistActivityDao.update(activity);
		}
	}
}
