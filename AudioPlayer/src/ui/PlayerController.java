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
import player.APlayer;
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
	

	private APlayer newAP = new APlayer();
	
	private long updatePrevTime = 0;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
	
		String pfad = "01 - Darwin feat Fraz - We-re Getting Faster.mp3";

		
		File file = new File(pfad);
		newAP.addToPlaylist(file);
		
		
		
		play.setOnAction((ActionEvent e) -> {

			newAP.play();
		});
		pauseButton.setOnAction((ActionEvent e)-> {

			newAP.pause();
		});
		stopButton.setOnAction((ActionEvent e) -> {

			newAP.stop();
		});
		nextButton.setOnAction((ActionEvent e)->{

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
