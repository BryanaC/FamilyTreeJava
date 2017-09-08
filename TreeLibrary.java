package package1;

import java.io.*;
import java.util.*;
import javax.swing.*;
//Library of trees, when you add a person a new tree is created and added to the library 
@SuppressWarnings("serial")
public class TreeLibrary extends AbstractListModel<FamilyTree> implements Serializable{



	/** ArrayList of People */
	public ArrayList<FamilyTree> library;


	/*******************************************************************
	 *Constructor: Sets up an empty array list of trees
	 ******************************************************************/
	public TreeLibrary(){
		super();
		library = new ArrayList<FamilyTree>();
	}

	/*******************************************************************
	 *Helper: Returns the tree at indicated index starting at zero
	 *@return tree tree at indicated index
	 ******************************************************************/
	public FamilyTree getElementAt(int i) {
		if(i >= 0 && library.size() > i){
				FamilyTree tree = library.get(i);
				return tree;
		}
		return null;
	}


	/*******************************************************************
	 *Helper: Returns the number of people in the current list
	 *@return size Size of the listPeople array list
	 ******************************************************************/
	public int getSize() {
		return library.size();
	}


	/*******************************************************************
	 *Helper: Adds a person to the current list, then sorts the list and 
	 *updates the GUI
	 ******************************************************************/
	public void add(FamilyTree a) {
		library.add(a);
		//Collections.sort(library);
	}


	/*******************************************************************
	 *Helper: Removes a person to the current list, then updates the GUI
	 *and return the person that was deleted. Index's start at zero
	 *@return unit Person that was deleted
	 ******************************************************************/
	public void remove(int i){
		if(getSize() > i){
			library.remove(i);	
		}
	}


	/*******************************************************************
	Helper: Lets the GUI know something has been changed and updates the 
	entire array list
	 *******************************************************************/
	public void update(){
		fireContentsChanged(this, 0, library.size());
	}


	/*******************************************************************
	 *Helper: Finds the person with the indicated name
	 *@return person Person with the indicated name
	 ******************************************************************/
	public FamilyTree findName(String name){
		FamilyTree person = null;
		if(name == null){
			System.out.println("Whoops");
		}else{
			for(int i = 0; i < library.size(); i++){
				if(library.get(i).getRoot().getName().equals(name)){
					person = library.get(i);
				}
			}
		}
		return person;
	}


	/*******************************************************************
	 *Helper: Determines if the person given is in the current library
	 *@return true if the person given is in the current library
	 *@return false if the person given is not in the current library
	 ******************************************************************/
	public boolean doesContainPerson(Person person){
		FamilyTree temp = new FamilyTree();
		if(person != null){
			for(int i=1; i <= library.size(); i++){
				temp = library.get(i-1);
				if(temp.getRoot() == person){
					return true;
				}
			}
		}
		return false;
	}


	/*******************************************************************
	 *Helper: Determines if the name given is in the current library
	 *@return true if the name given is in the current library
	 *@return false if the name given is not in the current library
	 ******************************************************************/
	public boolean doesContainName(String name){
		FamilyTree temp = new FamilyTree();
		if(name != null){
			for(int i=1; i <= library.size(); i++){
				temp = library.get(i-1);
				if(temp.getRoot().getName() == name){
					return true;
				}
			}
		}
		return false;
	}


	/******************************************************************
	 * Saves the list of people as a serializable file
	 * @param parent
	 *****************************************************************/
	public void saveSerializable (JFrame parent){
		try {
			// Allows user to choose filename
			JFileChooser chooser = new JFileChooser();
			chooser.showSaveDialog(parent);
			File filename = chooser.getSelectedFile();

			FileOutputStream fos = new FileOutputStream(filename);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(library);
			oos.close();

		} catch (Exception f) {   
			JOptionPane.showConfirmDialog(null, f.toString() 
					+ "\nFail to save file state.", 
					"Family Tree", 
					JOptionPane.DEFAULT_OPTION);
		}
	}


	/******************************************************************
	 * Loads a list of people from a serializable file
	 * @param parent
	 *****************************************************************/
	@SuppressWarnings("unchecked")
	public void loadSerializable (JFrame parent) {
		try {
			// Allows user to choose file from directory
			JFileChooser fileChooser = new JFileChooser();
			int result = fileChooser.showOpenDialog(parent);
			if (result == JFileChooser.APPROVE_OPTION){
				File selectedFile = fileChooser.getSelectedFile();
				FileInputStream fileStream = 
						new FileInputStream(selectedFile);   
				ObjectInputStream objectStream = 
						new ObjectInputStream(fileStream);

				try {  
					// Assigns information from file to list
					library = (ArrayList<FamilyTree>) 
							objectStream.readObject();
					// Updates GUI
					//fireIntervalAdded(this,0,library.size());
				} catch (ClassNotFoundException c) {
					System.out.println("Class not found");
					c.printStackTrace();
				}   
				finally {
					fileStream.close();
				}
			} else {

			}
		} catch (IOException i) {
			System.out.println("Sorry, something went "
					+ "wrong. Your file "
					+ "	was not able to load.");
			i.printStackTrace();

		}
	}

}
