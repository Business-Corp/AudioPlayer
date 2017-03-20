package player;

import java.io.File;
import java.util.ArrayList;

import javafx.beans.Observable;
import javafx.beans.property.Property;
import javafx.beans.property.ReadOnlyObjectProperty;
import javafx.scene.control.ProgressBar;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;

public class AudioPlayer {
	
	private ArrayList<Media> playlist = new ArrayList<Media>();
	private MediaPlayer mp;
	private int abspielen=1;
	private ProgressBar progb;
	private long prevTime=System.currentTimeMillis();
	
	public AudioPlayer(MediaPlayer mediaplayer) {
//		if(mediaplayer == null){
//			//das ändern
//			mp = new MediaPlayer(new Media(""));
//		}
		mp=mediaplayer;
		
		
	}
	public AudioPlayer(Media track) {
	
		playlist.add(track);
	}
	/**
	 * Fuegt der Playlist ein Medium hinzu
	 * @param pfad zum Medium
	 */
	public void addToPlaylist(String pfad){
		
		File file = new File(pfad);
		
		if(file.exists()){
			playlist.add(new Media(file.toURI().toString()));
		}
		
	}
	/**
	 * Spielt das Medium das sich momentan im Player befindet. Wenn kein Medium vorhanden ist, wird das erste
	 * Medium der Playlist geladen
	 */
	public void play(){
		
		if(mp!=null){
			mp.play();
		}
		else if(mp==null && (playlist.size() > 0) && (abspielen <= playlist.size())){
			mp=new MediaPlayer(playlist.get(abspielen-1));
			mp.play();
		}
		
		
	}
	
	/**
	 * Stoppt die Wiedergabe des momentanen Mediums
	 */
	public void stop(){
		if(mp != null){
			mp.stop();
		}
	}
	
	/**
	 * Pausiert die Wiedergabe des aktuellen Mediums.
	 */
	public void pause(){
		if(mp != null){
			mp.pause();
		}
	}
	
	/**
	 * Spielt das Naechste Medium welches sich in der Playlist befindet. Wenn es keinen Nachfolger 
	 * gibt, wird von forne angefangen
	 */
	public void next(){
//		if(abspielen <= playlist.size()){
		abspielen= (abspielen+1);	
		if(mp != null){
			mp.stop();
		}
			mp = new MediaPlayer(playlist.get((abspielen-1)%playlist.size()));
			mp.stop();
			mp.play();
			
			
			
//			
//			
//		}else{
//			mp.stop();
//			mp = new MediaPlayer(playlist.get(0));
//			mp.stop();
//			mp.play();
//			
//		}
//		mp.currentTimeProperty().addListener((Observable ov) -> {
//			long currTime = System.currentTimeMillis();
//			
//			if((currTime-prevTime) > 1){
//				progb.setProgress(getProgress());
//				prevTime=currTime;
//			}
//			
//		});
	}
	/**
	 * Berechnet den Fortschritt den das lied bisher durchs abspielen gemacht hat
	 * @return Der Fortschritt in % als double
	 */
	public double getProgress(){
		if(mp != null){
			
			double max = mp.getStopTime().toSeconds();
			double moment = mp.getCurrentTime().toSeconds();
			System.out.println("current: "+moment+" max: "+max);
			return moment/max;
		}
		return 0.0;
		
	}
	public void setProgressBar(ProgressBar pb){
		progb=pb;
	}
	public ReadOnlyObjectProperty<Duration> getCurrentTime(){
		if(mp != null){
			return mp.currentTimeProperty();
		}
		
		return null;
	}

}
