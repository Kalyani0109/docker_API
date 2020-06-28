package com.docker.music.exceptionHandler;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import com.docker.music.ExceptionHandling.MusicException;

@ControllerAdvice
@RestController
public class MusicExceptionHandler {
	
	@ExceptionHandler(value=MusicException.class)
	public ResponseEntity<String> HandleMusicException(MusicException musExp){
		System.out.println(musExp.getStackTrace());
		return ResponseEntity.status(488).body("Error while fetching User Details");
	}

}
