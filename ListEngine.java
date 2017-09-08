package package1;

import java.io.*;
import java.util.*;
import javax.swing.*;

public class ListEngine extends AbstractListModel {

	/** ArrayList of People */
	public ArrayList<Person> listPeople;


	/*******************************************************************
	 *Constructor: Instantiates an empty arraylist of people 
	 ******************************************************************/
	public ListEngine() {
		super();
		listPeople = new ArrayList<Person>();
	}


	/*******************************************************************
	 *Helper: Returns the person at indicated index
	 *@return person Person at indicated index
	 *?same as get(int i)
	 ******************************************************************/
	public Object getElementAt(int arg0) {
		Person person = listPeople.get(arg0);
		return person;
	}


	/*******************************************************************
	 *Helper: Returns the number of people in the current list
	 *@return size Size of the listPeople array list
	 ******************************************************************/
	public int getSize() {
		int size = listPeople.size();
		return size;
	}


	/*******************************************************************
	 *Helper: Adds a person to the current list, then sorts the list and 
	 *updates the GUI
	 ******************************************************************/
	public void add(Person a) {
		listPeople.add(a);

		// Sorts the list
		Collections.sort(listPeople);

		// Updates GUI
		fireIntervalAdded(this,0,listPeople.size());
	}


	/*******************************************************************
	 *Helper: Removes a person to the current list, then updates the GUI
	 *and return the person that was deleted 
	 *@return unit Person that was deleted
	 ******************************************************************/
	public Person remove(int i){
		Person unit = listPeople.remove(i);
		fireIntervalRemoved(this,0,listPeople.size());

		//is this needed?
		return unit;
	}

	/*******************************************************************
	 *Helper: Returns the person at indicated index
	 *@return listPeople.get(i) Person at indicated index
	 ******************************************************************/
	public Person get(int i) {
		return listPeople.get(i);
	}


	/*******************************************************************
	 *Helper: Finds the person with the indicated name
	 *@return person Person with the indicated name
	 ******************************************************************/
	public Person find(String name){
		Person person = null;
		if(name == null){
			System.out.println("Whoops");
		}else{
			for(int i = 0; i < listPeople.size(); i++){
				if(get(i).name.equals(name)){
					person = get(i);
				}
			}
		}
		return person;
	}

//	/******************************************************************
//	 * Saves the list of people as a serializable file
//	 * @param parent
//	 *****************************************************************/
//	public void saveSerializable (JFrame parent){
//		try {
//			// Allows user to choose filename
//			JFileChooser chooser = new JFileChooser();
//			chooser.showSaveDialog(parent);
//			File filename = chooser.getSelectedFile();
//			FileOutputStream saveFileStream = 
//					new FileOutputStream(filename);   
//			ObjectOutputStream objectStream = new 
//					ObjectOutputStream(saveFileStream);   
//
//			// Saves the list of people
//			objectStream.writeObject(listPeople);     
//
//			objectStream.close();   
//			saveFileStream.close();   
//
//		} catch (Exception f) {   
//			JOptionPane.showConfirmDialog(null, f.toString() 
//					+ "\nFail to save file state.", 
//					"Family Tree", 
//					JOptionPane.DEFAULT_OPTION);
//		}
//	}
//
//
//	/******************************************************************
//	 * Loads a list of people from a serializable file
//	 * @param parent
//	 *****************************************************************/
//	public void loadSerializable (JFrame parent) {
//		try {
//			// Allows user to choose file from directory
//			JFileChooser fileChooser = new JFileChooser();
//			int result = fileChooser.showOpenDialog(parent);
//			if (result == JFileChooser.APPROVE_OPTION){
//				File selectedFile = fileChooser.getSelectedFile();
//				FileInputStream fileStream = 
//						new FileInputStream(selectedFile);   
//				ObjectInputStream objectStream = 
//						new ObjectInputStream(fileStream);
//
//				try {  
//					// Assigns information from file to list
//					listPeople = (ArrayList) 
//							objectStream.readObject();
//					// Updates GUI
//					fireIntervalAdded(this,0,listPeople.size());
//				} catch (ClassNotFoundException c) {
//					System.out.println("Class not found");
//					c.printStackTrace();
//				}   
//				finally {
//					fileStream.close();
//				}
//			} else {
//
//			}
//		} catch (IOException i) {
//			System.out.println("Sorry, something went "
//					+ "wrong. Your file "
//					+ "	was not able to load.");
//			i.printStackTrace();
//
//		}
//	}

}