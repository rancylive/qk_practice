package com.swiggy.tracks.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.swiggy.tracks.dto.Playlist;
import com.swiggy.tracks.service.PlaylistService;

@RestController
public class PlaylistController {
	
	@Autowired
	private PlaylistService playlistService;
	
	@RequestMapping(name="/playlist", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public String addPlaylist(@RequestBody Playlist playlist) {
		playlistService.save(playlist);
		return "Saved";
	}
	
	@RequestMapping(name="/playlist", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Playlist fetchPlaylist(@RequestParam String playlistName) {
		return playlistService.fetch(playlistName);
	}
	
	@RequestMapping(name = "/explore", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Playlist> explore(@RequestBody List<String> tags) {
		return playlistService.explore(tags);
	}
	
	@RequestMapping(name = "/play", method = RequestMethod.GET)
	public String play(@RequestParam(value = "playlistName") String playlistName) {
		playlistService.play(playlistName);
		return "Playing";
	}
}
