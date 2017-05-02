/**
	QRCode allows us to create, display and modify our own QRCode.
	@autor Guillaume DESHAYES / Julien KOENIG / CAMBON Thibaut
	@version 1.0.0
	@date 01/05/2017
*/

package main;

/**
 * This class parses information to catch the room.
 */
public class Room {
	private String room, delims;
	private String[] tokens;

	/** Constructor of our class.*/
	public Room() {
		
	}
	
	/** Catch the room.*/
	public String get(String data)
	{
		delims = "[ ]+";
		tokens = data.split(delims);
		room = tokens[tokens.length-1];
		
		return(room);
	}

}
