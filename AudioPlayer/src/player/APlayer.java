package player;

import java.io.File;
import java.util.ArrayList;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class APlayer {
	
	private ArrayList<MediaPlayer> playlist = new ArrayList<MediaPlayer>();
	private int coursor = 0;
	
	private MediaPlayer actualMediaPlayer;
	
	/**
	 * Fuegt ein neues Medium zur Playlist hinzu
	 * @param file darf nicht {@code null} sein
	 */
	public void addToPlaylist(File file){
		if(file.exists()){
			playlist.add(new MediaPlayer(new Media(file.toURI().toString())));
		}
	}
	
	/**
	 * Spielt das aktuelle Medium ab. wenn bisher keines geladen wurde, wird das zuletzt markierte oder das erste aus der Playlist abgespielt
	 */
	public void play(){
		
		
		//noch die verschiedenen Stati der Mediaplayer abfangen
		
		
		if(actualMediaPlayer != null){
			actualMediaPlayer.play();
		}
		else{
			if((playlist.size()>0) && (coursor < playlist.size())) {
				actualMediaPlayer=playlist.get(coursor);
				
				//dies refactoren
				actualMediaPlayer.play();
			}
			else if(playlist.size() > 0){
				actualMediaPlayer=playlist.get(0);
				actualMediaPlayer.play();
			}
		}
		
	}
	
	public void pause(){
		
		if(actualMediaPlayer != null){
			actualMediaPlayer.pause();
		}
		
	}
	
	public void stop(){
		
		if(actualMediaPlayer != null){
			actualMediaPlayer.stop();
		}
		
	}
	

}
