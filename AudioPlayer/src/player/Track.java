package player;

import java.io.File;
import java.net.URI;

public class Track {
	
	
	private String pfad = "";
	private File pathFile = null;
	
	public Track(String path) {
		pfad = path;
		pathFile = new File(path);
	}
	
	public Track(File file) {
		pfad = file.getAbsolutePath();
		pathFile = file;
	}
	
	public boolean check(){
		
		return false;
		
	}
	
	
}
