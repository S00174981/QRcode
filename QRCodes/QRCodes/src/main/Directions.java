/**
	QRCode allows us to create, display and modify our own QRCode.
	@autor Guillaume DESHAYES / Julien KOENIG / CAMBON Thibaut
	@version 1.0.0
	@date 01/05/2017
*/

package main;

import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 * This class catches direction to play the right sound.
 */
public class Directions {
	private final int ROOM_LENGTH = 5; // size of the room string
	private char building ;
	private char floor;
	private String locationOnFloor = null;

	/** Constructor of our class. */
	public Directions() {

	}

	public char getBuilding() {
		return building;
	}


	public void setBuilding(char building) {
		this.building = building;
	}


	public char getFloor() {
		return floor;
	}


	public void setFloor(char floor) {
		this.floor = floor;
	}


	public String getLocationOnFloor() {
		return locationOnFloor;
	}

	public void setLocaationOnFloor(String locationOnFloor) {
		this.locationOnFloor = locationOnFloor;
	}

	/*
	 * This method takes in a room eg E2004 and splits up into the correct block
	 * (Engineering, Science, Business, etc) The correct floor The correct room
	 * number
	 */
	public boolean validate(String room) {
		if (room.length() != ROOM_LENGTH) {
			return false;
		}
		if (Character.isLetter(room.charAt(0)) == false || room.charAt(0) < 'A' || room.charAt(0) > 'F') {
			this.playit("Building");
			delayfor(3);
			return false; // room must start with a letter
		}
		for (int i = 1; i < ROOM_LENGTH; i++) {
			if (Character.isDigit(room.charAt(i)) == false) {
				return false; // room must have digit
			}
		}
		if(!(room.substring(2).equals("003") || room.substring(2).equals("004") || room.substring(2).equals("006") || room.substring(2).equals("007"))){
			this.playit("Room");
			delayfor(3);
			return false; // room need to be set
		}
		if(!(room.charAt(1) == '0' || room.charAt(1) == '1' || room.charAt(1) == '2')){
			this.playit("Floor");
			delayfor(3);
			return false; // floor need to be set
		}
		
		// all ok - store the info
		building = room.charAt(0);
		floor = room.charAt(1);
		locationOnFloor = room.substring(2);
		
		return true;
	}
	
	/*
	 * Get directions to building
	 */
	public String toBuilding() {
		String directions = null;
		switch (this.building) {
		case 'A':
			directions = "From reception, walk straight ahead and then turn to your right";
			break;
		case 'B':
			directions = "From reception, go up main stairs on your left and turn right.  Walk for 40m past Library until you read the Booknest";
			break;
		case 'C':
			directions = "From reception, go up main stairs on your left and turn right.  Walk for 40m past Library until you read the Booknest, then turn left and continute through long corridor";
			break;
		case 'D':
			directions = "From reception, go up main stairs on your left and turn right.  Walk for 40m past Library until you read the Booknest, then turn left and continute through long corridor";
			break;
		case 'E':
			directions = "From reception, move the centre of reception and turn left into the engineering building";
			break;
		case 'F':
			directions = "From reception, walk outside and turn to your right.  Walk past the engineering building and the F block is straight in front";
			break;
		default:
			directions = "Sorry, that building in not recognised";
			break;
			
		}  
		
	    this.playit(this.building);
	    delayfor(10);
        
		return(directions);
	}
	
	/*
	 * Get directions to floor
	 */
	public String toFloor() {
		String directions = null;
		switch (this.floor) {
		case '0':
			directions = "Stay on this floor";
			break;
		case '1':
			directions = "Ascend the stairs or take the lift to the first floor";			
			break;
		case '2':
			directions = "Ascend two flight of stairs or take the lift to the second floor";			
			break;
		default:
			directions = "Sorry, floor " + this.floor + " is not recognised";
			break;
			
		}
		
		this.playit(this.floor);
		delayfor(4);
        
		return(directions);
	}

	/*
	 * Get directions to floor
	 */
	public String toLocation() {
		String directions = null;
		switch (this.locationOnFloor) {
		case "006":
			directions = "This is a room to the right on this level";
			break;
		case "007":
			directions = "This is a room to the right on this level";			
			break;
		case "003":
			directions = "This is the last room to the right on this level";			
			break;
		case "004":
			directions = "This is the second last room to the right on this level";			
			break;
		default:
			directions = "Sorry, that room in not recognised";
			break;
			
		}
		
		this.playit(this.locationOnFloor);
		delayfor(3);
        
		return(directions);
	}
	
    /*
	 * Method is passed a sound flag it will play that sound there is only one
	 * currently supported.
	 */
	public void playit(int soundRequired) {
		String fn = null;
		File sound; 

		switch (soundRequired) {
		case 'A':
			fn = "./src/main/resources/sounds/A.wav";
			break;
		case 'B':
			fn = "./src/main/resources/sounds/B.wav";
			break;
		case 'C':
			fn = "./src/main/resources/sounds/C.wav";
			break;
		case 'D':
			fn = "./src/main/resources/sounds/D.wav";
			break;
		case 'E':
			fn = "./src/main/resources/sounds/E.wav";
			break;
		case 'F':
			fn = "./src/main/resources/sounds/E.wav";
			break;
		case '0':
			fn = "./src/main/resources/sounds/0.wav";
			break;
		case '1':
			fn = "./src/main/resources/sounds/1.wav";
			break;
		case '2':
			fn = "./src/main/resources/sounds/2.wav";
			break;
		default:
			break;

		}

		// Go for it!
		try {
			// Open an audio input stream.
			sound = new File(fn);
			AudioInputStream audioIn = AudioSystem.getAudioInputStream(sound);
			Clip clip = AudioSystem.getClip();
			// Open audio clip and load samples from the audio input stream.
			clip.open(audioIn);
			clip.start();
			// plays
		} catch (UnsupportedAudioFileException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (LineUnavailableException e) {
			e.printStackTrace();
		}
	}
	
    /*
	 * Overload previous method
	 */
	public void playit(String soundRequired) {
		String fn = null;
		File sound; 

		switch (soundRequired) {
		case "003":
			fn = "./src/main/resources/sounds/003.wav";
			break;
		case "004":
			fn = "./src/main/resources/sounds/004.wav";
			break;
		case "006":
			fn = "./src/main/resources/sounds/006.wav";
			break;
		case "007":
			fn = "./src/main/resources/sounds/007.wav";
			break;
		case "Room":
			fn = "./src/main/resources/sounds/Room.wav";
			break;
		case "Building":
			fn = "./src/main/resources/sounds/Building.wav";
			break;
		case "Floor":
			fn = "./src/main/resources/sounds/Floor.wav";
			break;
		default:
			break;

		}

		// Go for it!
		try {
			// Open an audio input stream.
			sound = new File(fn);
			AudioInputStream audioIn = AudioSystem.getAudioInputStream(sound);
			Clip clip = AudioSystem.getClip();
			// Open audio clip and load samples from the audio input stream.
			clip.open(audioIn);
			clip.start();
			// plays
		} catch (UnsupportedAudioFileException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (LineUnavailableException e) {
			e.printStackTrace();
		}
	}
	
	public static void delayfor(int n)
	{
		try {
		    Thread.sleep(n * 1000);                 //1000 milliseconds is one second.
		} catch(InterruptedException ex) {
		    Thread.currentThread().interrupt();
		}
	}


}
