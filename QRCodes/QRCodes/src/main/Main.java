/**
	QRCode allows us to create, display and modify our own QRCode.
	@autor Guillaume DESHAYES / Julien KOENIG / CAMBON Thibaut
	@version 1.0.0
	@date 01/05/2017
*/

package main;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JTextField;

import com.google.zxing.EncodeHintType;
import com.google.zxing.NotFoundException;
import com.google.zxing.WriterException;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

/**
	This class manages all the program.
*/
public class Main {
		static JTextField textField = null;
		static String qrCodeData = "Day: Tuesday\nTime: 09:00 to 11:00\nSubject: Software Engineering\nRoom: E2004";
		static String filePath = "./src/main/resources/images/myQRCode.png";
		
		static QR qr = new QR(qrCodeData, filePath);
		static Room room = new Room();
		static DateTime dateTime = new DateTime();
		static Subject subject = new Subject();
		static Directions directions = new Directions();
		static WindowGUI window = new WindowGUI();
		static String theRoom = "E2004";
		static String theDateTime = "Tuesday, 9:00 to 11:00";
		static String theSubject = "Software Engineering";

		/** This method creates our user interface and creates our first example of QRCode. */
		 public static void main(String[] args){
			 try {
				create();
			} catch (NotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (WriterException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			window.buildGUI();			
		}
		
		 /**
			This class creates the QRCode and display in the console different information about it.
		*/
		 @SuppressWarnings({ "unchecked", "rawtypes" })
		public static void create() throws WriterException, IOException, NotFoundException {
			Map hintMap = new HashMap();
			hintMap.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);
			
			// create the QR barcode
			qr.createQRCode(qrCodeData, filePath, hintMap, 200, 200);
			System.out.println("QR Code image created successfully!");

			// read the barcode
			String QRdata = qr.readQRCode(filePath, hintMap);
			System.out.println("The barcode reads : " + QRdata);
			
			// Find the room
			theRoom = room.get(QRdata);
			System.out.println("The room is " + theRoom);
			
			// Find the date and the time
			theDateTime = dateTime.get(QRdata);
			System.out.println("The date and the time are " + theDateTime);
			
			// Find the subject
			theSubject = subject.get(QRdata);
			System.out.println("The subject is " + theSubject);
		}		 
}
