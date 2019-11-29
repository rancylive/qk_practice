package com.swiggy.tracks.dao;

import com.swiggy.tracks.dto.PlaylistActivity;

public interface PlaylistActivityDao {
	void save(PlaylistActivity activity);
	void update(PlaylistActivity activity);
	PlaylistActivity fetchByPlaylistId(int id);
}
