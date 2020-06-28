package com.docker.music.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.docker.music.Entities.Music;
import com.docker.music.ExceptionHandling.MusicException;
import com.docker.music.services.MusicService;

@CrossOrigin
@RestController
@RequestMapping(value="/music")
public class MusicController {
	
	@Autowired
	private MusicService musicServ;
	
	@RequestMapping(value="/display")
	public List<Music> displayAllMusic() throws MusicException{
		List<Music> returnObj = this.musicServ.getAllMusic();
		System.out.println("Music List" + returnObj);
		return returnObj;
	}
	
	@RequestMapping(value="/addMusic")
	public List<Music> addMusic() throws MusicException{
		Music music1 = new  Music();
		music1.setMusicId(1);
		music1.setArtist("kalyani");
		music1.setDescription("Songs");
		music1.setSongName("kalyaniSong");
		this.musicServ.addMusic(music1);
		return this.musicServ.getAllMusic();
	}
	
	@RequestMapping(value="/{music_id}")
	public Music getMusicById(@PathVariable ("music_id") long musicId) throws MusicException{
		return this.musicServ.getMusicById(musicId);
	}
	
	@CrossOrigin(origins="*")
	@RequestMapping(value="/delete/{music_id}", method=RequestMethod.GET)
	public boolean deleteMusicById(@PathVariable ("music_id") long musicId) throws MusicException{
		return this.musicServ.deleteMusicById(musicId);
		
	}
	
	@RequestMapping(value="addSong", method=RequestMethod.POST)
	public Music addMusic(@RequestBody Music requestBody) throws MusicException{
		System.out.println("Request body" + requestBody);
		this.musicServ.addMusic(requestBody);
		return this.musicServ.getMusicById(requestBody.getMusicId());
	}

}
