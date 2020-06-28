package com.docker.music.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.docker.music.Entities.Music;

@Repository
public interface MusicRepository extends JpaRepository<Music, Long> {

}
