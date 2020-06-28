package com.docker.music.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.docker.music.Entities.Music;
import com.docker.music.ExceptionHandling.MusicException;
import com.docker.music.repository.MusicRepository;
import com.docker.music.services.MusicService;

@Service
public class MusicServiceImpl implements MusicService {
	
	@Autowired
	private MusicRepository musicRepo;

	@Override
	public boolean addMusic(Music music) throws MusicException {
		try{
			musicRepo.saveAndFlush(music);
			return true;
		}catch(Exception e){
			System.out.println("Error in addMusic method" + e);
			throw new MusicException();
		}
	}

	@Override
	public boolean deleteMusicById(long musicId) throws MusicException {
		try{
			this.musicRepo.deleteById(musicId);
			return true;
		}catch(Exception e){
			System.out.println("Error in deleteMusic method" + e);
			throw new MusicException();
		}
	}

	@Override
	public Music getMusicById(long musicId) throws MusicException {
		try{
			Optional<Music> musicObj = this.musicRepo.findById(musicId);
			Music returnObj = musicObj.get();
			return returnObj;
		}catch(Exception e){
			System.out.println("Error in getMusic" + e);
			throw new MusicException();
		}
	}

	@Override
	public List<Music> getAllMusic() throws MusicException {
		try{
			List<Music> musicList = this.musicRepo.findAll();
			return musicList;
		}catch(Exception e){
			System.out.println("Error in getMusicList" + e);
			throw new MusicException();
		}
	}

}
