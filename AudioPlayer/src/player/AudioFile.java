package player;

import java.io.File;

public class AudioFile {

	private File file;
	private String name;
	
	public AudioFile(File data) {

		file=data;
		name=data.getName();
		
	}
	
	public String toString(){
		return name;
	}
	public File getFile(){
		return file;
	
	}
	
}
