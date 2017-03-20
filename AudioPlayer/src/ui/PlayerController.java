package ui;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.Observable;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.media.Media;
import player.AudioPlayer;

public class PlayerController implements Initializable{

	@FXML
	Button play = new Button("Play");
	
	@FXML
	Button pauseButton = new Button("Pause");
	
	@FXML
	Button stopButton = new Button("Stop");
	
	@FXML
	Button nextButton = new Button();
	
	@FXML
	ProgressBar fortschritt = new ProgressBar();
	
	private AudioPlayer ap;
	
	private long updatePrevTime = 0;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
	
		String pfad = "01 - Darwin feat Fraz - We-re Getting Faster.mp3";
		Media media = new Media(new File(pfad).toURI().toString());
		
		ap = new AudioPlayer(media);
//		ap.addToPlaylist("D:\\Multimedia\\Musik\\MP3\\Bonkers 18\\Bonkers 1\\02 - Arkitech - When Tears Fall - Kaotik.mp3");
//		ap.addToPlaylist("D:\\Multimedia\\Musik\\MP3\\Bonkers 18\\Bonkers 1\\03 - Ham - Jump 2 Da Groove 2009.mp3");
//		ap.addToPlaylist("D:\\Multimedia\\Musik\\MP3\\Bonkers 18\\Bonkers 1\\04 - Sharkey, Odyssey & Arkitech - Black Rain.mp3");
		
		play.setOnAction((ActionEvent e) -> {
			ap.play();
		});
		pauseButton.setOnAction((ActionEvent e)-> {
			ap.pause();
		});
		stopButton.setOnAction((ActionEvent e) -> {
			ap.stop();
		});
		nextButton.setOnAction((ActionEvent e)->{
			ap.next();
		});
		
//		ap.setProgressBar(fortschritt);
//		ap.play();
//		ap.pause();
//		ap.next();
		
//		ap.getCurrentTime().addListener((Observable ov) -> {
//			long currTime = System.currentTimeMillis();
//			
//			if((currTime-updatePrevTime) > 10){
//				fortschritt.setProgress(ap.getProgress());
//				updatePrevTime=currTime;
//			}
//			
//		});
		
		
	}
	
}
