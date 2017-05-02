/**
	QRCode allows us to create, display and modify our own QRCode.
	@autor Guillaume DESHAYES / Julien KOENIG / CAMBON Thibaut
	@version 1.0.0
	@date 01/05/2017
*/

package main;

/**
 * This class catches date and time from the information given by the user using parsing method.
 */
public class DateTime {
	private String dateTime, delims;
	private String[] tokens;
	
	/** Constructor of the class. */
	public DateTime() {
		
	}
	
	/** Use parsing method to catch these information. */
	public String get(String data)
	{
		delims = "[\n ]+";
		tokens = data.split(delims);
		dateTime = tokens[1]+", "+tokens[3]+" to "+tokens[5];
		
		return(dateTime);
	}

}

