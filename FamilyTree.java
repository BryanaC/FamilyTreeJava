package package1;

import java.io.Serializable;
import java.util.ArrayList;

//tree of a single person, skeleton for basic starting tree
//pointer to only mother and father
@SuppressWarnings("serial")
public class FamilyTree implements Serializable, Comparable<FamilyTree>{

	/** Main Person */
	private Person root;

	/** Pointer to the Father */
	private Person father;

	/** Pointer to the Mother */
	private Person mother;
	
	/** Pointer to the Spouse */
	private Person spouse;

	/** List of Children */
	private ArrayList<Person> children;


	/*******************************************************************
	 *Constructor: Creates a family tree that is null with no relations. 
	 *There is no root person created yet
	 ******************************************************************/
	public FamilyTree() {
		root = null;
		father = null;
		mother = null;
		spouse = null;
		children = new ArrayList<Person>();
	}


	/*******************************************************************
	 *Constructor: Creates a family tree that is null with no relations. 
	 *The root has been created
	 *@param root the person node selected to be the root of this tree
	 ******************************************************************/
	public FamilyTree(Person root){
		this.root = root;
		father = null;
		mother = null;
		spouse = null;
		children = new ArrayList<Person>();
	}


	/*******************************************************************
	 *Helper: Returns the root person node of this tree
	 *@return root the main person/starter or the base of this tree
	 ******************************************************************/
	public void setRoot(Person root) {
		this.root = root;
	}


	/*******************************************************************
	 *Helper: Sets the father of the current person to the given father
	 *The Father must have a name; not null
	 *@param fater New father of the current person
	 ******************************************************************/
	public void setFather(FamilyTree pfather) {
		this.father = pfather.getRoot();
		
		//pfather.addChild(this);
	}


	/*******************************************************************
	 *Helper: Sets the mother of the current person to the given mother
	 *@param mother New mother of the current person
	 ******************************************************************/
	public void setMother(FamilyTree pmother) {
		this.mother = pmother.getRoot();
		
		//pmother.addChild(this);
	}


	/*******************************************************************
	 *Helper: Sets the spouse of the current person to the given spouse
	 *@param pspouse New Spouse of the current person
	 ******************************************************************/
	public void setSpouse(FamilyTree pspouse) {
		this.spouse = pspouse.getRoot();
		
		//pspouse.addChild(this);
	}


//	/*******************************************************************
//	 *Helper: Adds children to the current person from the given string 
//	 *of children by making the children's parents as the current person
//	 *@param list String of children of a person
//	 *@throws Exception 
//	 ******************************************************************/
//	public void addChild(String list) {
//		FamilyTree tempChild = new FamilyTree();
//		if(!list.isEmpty() && list != null){
//			String[] parts = list.split("\n");
//			for(int i = 0; i < parts.length; i++){
//				if(library.doesContainName(parts[i])){
//					tempChild = library.getPerson(parts[i]);
//					if(root.getGender() == Gender.FEMALE){
//						tempChild.setMother(root);
//					}
//					if(root.getGender() == Gender.MALE){
//						tempChild.setFather(root);
//					}
//				}
//	
//				//Child does not exist
//				else{
//					system.out.println("Child Does not exist");
//				}
//	
//			}
//		}
//	}


	/*******************************************************************
	 *Helper: Adds children to the current person from the given a 
	 *person by designating this person as the child's parent
	 *@param person A given person 
	 ******************************************************************/
	public void addChild(FamilyTree pchild){
		children.add(pchild.getRoot());
//		if(root.getGender() == Gender.FEMALE){
//			tree.setMother(this);
//		}if(root.getGender() == Gender.FEMALE){
//			tree.setFather(this);
//		}
	}
	
	
//	/*******************************************************************
//	 *Helper: Adds a person of specified relation to the tree
//	 ******************************************************************/
//	public void addPerson(Person person, Person relation){
//
//	}


	/*******************************************************************
	 *Helper: Returns the root person node of this tree
	 *@return root the main person/starter or the base of this tree
	 ******************************************************************/
	public Person getRoot() {
		return root;
	}
	
	
	/*******************************************************************
	 *Helper: Returns the father of the current persons children
	 *@return father Father of current person
	 ******************************************************************/
	public Person getFather() {
		return father;
	}


	/*******************************************************************
	 *Helper: Returns the mother of the current persons mother
	 *@return mother Mother of current person 
	 ******************************************************************/
	public Person getMother() {
		return mother;
	}


	/*******************************************************************
	 *Helper: Returns the spouse of the current persons spouse
	 *@return spouse Spouse of current persons children 
	 ******************************************************************/
	public Person getSpouse() {
		return spouse;
	}


	/*******************************************************************
	 *Helper: Returns the list of the current persons children
	 *@return childrenList List of current persons children 
	 ******************************************************************/
	public ArrayList<Person> getChildrenList() {
		return children; 
	}


	/*******************************************************************
	 *Helper: Determines if the current person has a father
	 *@return true The current person has a father
	 *@return false The current person does not have a father
	 ******************************************************************/
	public boolean hasFather(){
		if(father == null)
			return false;
		return true;
	}


	/*******************************************************************
	 *Helper: Determines if the current person has a mother
	 *@return true The current person has a mother
	 *@return false The current person does not have a mother
	 ******************************************************************/
	public boolean hasMother(){
		if(mother == null)
			return false;
		return true;
	}


	/*******************************************************************
	 *Helper: Determines if the current person has a spouse
	 *@return true The current person has a spouse
	 *@return false The current person does not have a spouse
	 ******************************************************************/
	public boolean hasSpouse(){
		if(spouse == null)
			return false;
		return true;
	}


	/*******************************************************************
	 *Helper: Returns if the current person has and children
	 *@return true the current person does have children
	 *@return false the current person does not have children
	 ******************************************************************/
	public boolean hasChildren(){
		if(children.size() == 0)
			return false;
		return true;
	}


	/*******************************************************************
	 *Helper: Returns a string of a persons children
	 *@return list string list of the current persons children
	 ******************************************************************/
	public String childToString(ArrayList<Person> children){
		String list = "";
		for (Person s : children)
		{
			list += s.getName() + "\n";
		}
		return list;
	}


	/*******************************************************************
	 *Helper: Determines if the current person is the same as the given 
	 *person
	 *@param p Person to compare to the current one
	 *@return true if the given person is the same object as the root
	 *@return false if the given person is the not the same object as 
	 *the root
	 ******************************************************************/
	public boolean comparePeople(Person p) {
		return root.equals(p);
	}


	/*******************************************************************
	 *Helper: Compares People's name for similarity, if the names are the
	 *same it compares the birthdays; depends on characters values 
	 *contained in the strings
	 *@param o the name in question, whether it is earlier or later in the 
	 *alphabet
	 *@return this.bDay.compareTo(o.getbDay()) an int based on equality 
	 *of the birthdays
	 *@return return this.name.compareTo(o.getName()) an int based
	 *on equality of the names
	 *******************************************************************/
	public int compareTo(FamilyTree o) {
		if (this.getRoot().getName().compareTo(o.getRoot().getName()) == 0){
			return this.getRoot().getbDay().compareTo(o.getRoot().getbDay());
		}else{
			return this.getRoot().getName().compareTo(o.getRoot().getName());
		}

	}
	/*******************************************************************
	 *Helper: Returns the name of the root node in a string 
	 *@return name string of the name associated with the root node
	 ******************************************************************/
	public String toString() {
		return root.getName();
		
	}
}
