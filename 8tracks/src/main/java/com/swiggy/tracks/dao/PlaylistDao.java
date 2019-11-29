package com.swiggy.tracks.dao;

import java.util.List;

import com.swiggy.tracks.dto.Playlist;

public interface PlaylistDao {
	void save(Playlist playlist);
	void update(Playlist playlist);
	Playlist fetch(String playlistName);
	List<Playlist> findByTag(List<String> tags);
	List<Playlist> explore(List<String> tags);
}
