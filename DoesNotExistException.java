package package1;


/***********************************************************************
 * EditorException object is thrown when an error condition occurs in 
 * the editor. 
 * Examples: sending invalid commands to the editor or attempt to 
 * process a valid command that results in an error situation.
 * @author Emily Peterson
 * @version 11/5/2014
 **********************************************************************/
public class DoesNotExistException extends Exception{


	/** Serializable Variable */
	private static final long serialVersionUID = 1L;


	/*******************************************************************
	 * Constructs an EditorException with the specified detail message.
	 * @param message the detail message
	 ******************************************************************/
	public DoesNotExistException(String message) {
		super(message);
	}
}


