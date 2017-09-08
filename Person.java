package package1;

import java.io.*;
import java.util.*;
//node class; skeleton for a node with basic info on the person;
//no connections or pointers to other nodes
public class Person implements Serializable{

	/** Person's Name */
	private String name;

	/** Person's Gender */
	private Gender gender;

	/** Person's Birthday */
	private Date bDay;

	/** Person's Eye Color */
	private EyeColor eyeColor;

	/** Stores the filename for the person's photo */
	private String imageFilename;


	/*******************************************************************
	 *Constructor: Creates a person with no children
	 ******************************************************************/
	public Person(String name){
		gender = null; 
		bDay = null;
		eyeColor = null;
		imageFilename = "C:\\Users\\Bryana\\workspace\\Family Tree\\src\\package1\\default.jpg";
		this.name = name;

	}


	/*******************************************************************
	 *Helper: Returns the name of the current person
	 *@return name Name of current person
	 ******************************************************************/
	public String getName() {
		return name;
	}


	/*******************************************************************
	 *Helper: Sets the name of the current person to the given name
	 *@param name New name of the current person
	 ******************************************************************/
	public void setName(String name) {
		this.name = name;
	}


	/*******************************************************************
	 *Helper: Returns the gender of the current person
	 *@return gender Gender of current person
	 ******************************************************************/
	public Gender getGender() {
		return gender;
	}


	/*******************************************************************
	 *Helper: Sets the gender of the current person to the given gender
	 *@param gender New gender of the current person
	 ******************************************************************/
	public void setGender(Gender gender) {
		this.gender = gender;
	}


	/*******************************************************************
	 *Helper: Returns the gender of the person; if that has not been 
	 *determined, then the name of the person is returned
	 *@return "Male" String indication of gender
	 *@return "Female" String indication of gender
	 *@return name the name of the person in a String
	 ******************************************************************/
	public String genderToString() {
		if (this.getGender() == Gender.MALE) {
			return "Male";
		} else if (this.getGender() == Gender.FEMALE) {
			return "Female";
		} else {
			return name;
		}
	}


	/*******************************************************************
	 *Helper: Returns the gender of the current person
	 *@return gender Gender of current person
	 ******************************************************************/
	public EyeColor getEyeColor() {
		return eyeColor;
	}


	/*******************************************************************
	 *Helper: Sets the gender of the current person to the given gender
	 *@param gender New gender of the current person
	 ******************************************************************/
	public void setEyeColor(EyeColor eyeColor) {
		this.eyeColor = eyeColor;
	}


	/*******************************************************************
	 *Helper: Returns the gender of the person; if that has not been 
	 *determined, then the name of the person is returned
	 *@return eyeC String indication of the persons eye color
	 ******************************************************************/
	public String eyeColorToString() {
		String eyeC = new String();
		switch (this.getEyeColor()) {
		case BLACK:
			eyeC = "Black";
			break;
		case BLUE:
			eyeC = "Blue";
			break;
		case BROWN:
			eyeC = "Brown";
			break;
		case GREEN:
			eyeC = "Green";
			break;
		case GREY:
			eyeC = "Grey";
			break;
		case HAZEL:
			eyeC = "Hazel";
			break;
		case MULTICOLOR:
			eyeC = "Multicolor";
			break;
		}
		return eyeC;
	}


	/*******************************************************************
	 *Helper: Returns the birthday of the current person
	 *@return bDay Birthday of current person
	 ******************************************************************/
	public Date getbDay() {
		return bDay;
	}
	
	public String bDayToString(){
		return bDay.getDay() + "/" + bDay.getMonth() + "/" + (bDay.getYear()+1900);
	}


	/*******************************************************************
	 *Helper: Sets the birthday of the current person
	 *@param bday Given date for the current person's birthday
	 ******************************************************************/
	public void setbDay(Date bDay) {
		this.bDay = bDay;
	}
	/******************************************************************
	 * Helper: Returns the location of the person's biography image
	 * @return imageFilename filename of the person's photo
	 ******************************************************************/
	public String getImageFilename() {
		return imageFilename;
	}

	/******************************************************************
	 * Helper: Sets the location of the person's biography image
	 * @param imageFilename given location of image file
	 ******************************************************************/
	public void setImageFilename(String imageFilename) {
		this.imageFilename = imageFilename;
	}


	//	/*******************************************************************
	//	 *Helper: Compares People's name for similarity, if the names are the
	//	 *same it compares the birthdays; depends on characters values 
	//	 *contained in the strings
	//	 *@param o the name in question, whether it is earlier or later in the 
	//	 *alphabet
	//	 *@return this.bDay.compareTo(o.getbDay()) an int based on equality 
	//	 *of the birthdays
	//	 *@return return this.name.compareTo(o.getName()) an int based
	//	 *on equality of the names
	//	 *******************************************************************/
	//	public int compareTo(Person o) {
	//		if (this.name.compareTo(o.getName()) == 0){
	//			return this.bDay.compareTo(o.getbDay());
	//		}else{
	//			return this.name.compareTo(o.getName());
	//		}
	//
	//	}
}
