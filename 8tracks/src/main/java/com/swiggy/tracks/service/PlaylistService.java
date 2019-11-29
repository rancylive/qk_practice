package com.swiggy.tracks.service;

import java.util.List;

import com.swiggy.tracks.dto.Playlist;

public interface PlaylistService {
	void save(Playlist playlist);
	Playlist fetch(String playlistName);
	List<Playlist> explore(List<String> tags);
	void play(String playlistName);
}
