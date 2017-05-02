/**
	QRCode allows us to create, display and modify our own QRCode.
	@autor Guillaume DESHAYES / Julien KOENIG / CAMBON Thibaut
	@version 1.0.0
	@date 01/05/2017
*/

package main;

/**
 *  This class catches the subject of our QRCode.
 */
public class Subject {
	private String subject, delims;
	private String[] tokens;

	/**Constructor of our class.*/
	public Subject() {
		
	}
	
	/**Parce the information.*/
	public String get(String data)
	{
		delims = "[\n:]+";
		tokens = data.split(delims);
		subject = tokens[tokens.length-3];
		
		return(subject);
	}

}
