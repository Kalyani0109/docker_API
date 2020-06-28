package com.docker.music.services;

import java.util.List;

import com.docker.music.Entities.Music;
import com.docker.music.ExceptionHandling.MusicException;

public interface MusicService {
	
	public boolean addMusic(Music music) throws MusicException;
	
	public boolean deleteMusicById(long musicId) throws MusicException;
	
	public Music getMusicById(long musicId) throws MusicException;
	
	public List<Music> getAllMusic() throws MusicException;

}
