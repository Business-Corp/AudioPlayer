package player;

import java.io.File;
import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class APlayer {
	
//	private ArrayList<MediaPlayer> playlist = new ArrayList<MediaPlayer>();
	private int coursor = 0;
	
	private MediaPlayer actualMediaPlayer;
	private ObservableList<AudioFile> playlist = FXCollections.observableArrayList();
	
	/**
	 * Fuegt ein neues Medium zur Playlist hinzu
	 * @param file darf nicht {@code null} sein
	 */
	public void addToPlaylist(File file){
		if(file.exists()){
//			playlist.add(new MediaPlayer(new Media(file.toURI().toString())));
			playlist.add(new AudioFile(file));
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
				
				actualMediaPlayer=new MediaPlayer(new Media(playlist.get(coursor).getFile().toURI().toString()));
				
				
				//dies refactoren
				actualMediaPlayer.play();
			}
			else if(playlist.size() > 0){
				actualMediaPlayer=new MediaPlayer(new Media(playlist.get(0).getFile().toURI().toString()));
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
	
	public void next(){
		
		if(actualMediaPlayer!=null){
		
			coursor=(coursor+1)%playlist.size();
			
			//alten status des players speichern (ob pause, play oder stop) und am neuen player weiterführen
			
			actualMediaPlayer.stop();
			
			actualMediaPlayer=new MediaPlayer(new Media(playlist.get(coursor).getFile().toURI().toString()));
//			actualMediaPlayer.stop();
			actualMediaPlayer.play();
			
			
		}
		
	}
	

	public ObservableList<AudioFile> getObservableList(){
		return playlist;
	}
}
