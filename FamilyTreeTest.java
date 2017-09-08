package package1;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Date;

import org.junit.Ignore;
import org.junit.Test;

public class FamilyTreeTest {

	@Test
	public void testPersonCreation() {
		Person p1 = new Person("name");
		assertEquals(p1.getbDay(), null);
	}
	
	@Test
	public void testPersonCreation2() {
		Person p1 = new Person("Name");
		assertEquals(p1.getEyeColor(), null);
	}
	
	@Test
	public void testPersonCreation3() {
		Person p1 = new Person("Name");
		assertEquals(p1.getGender(), null);
	}
	
	@Test
	public void testPersonCreation4() {
		Person p1 = new Person("Name");
		assertEquals(p1.getName(), "Name");
	}
	
	@Test
	public void testPersonGender() {
		Person p1 = new Person("Name");
		p1.setGender(Gender.MALE);
		assertEquals(p1.getGender(),Gender.MALE);
	}
	
	@Test
	public void testPersonGender2() {
		Person p1 = new Person("Name");
		p1.setGender(Gender.FEMALE);
		assertEquals(p1.getGender(),Gender.FEMALE);
	}
	
	@Test
	public void testPersonGender3() {
		Person p1 = new Person("Name");
		assertEquals(p1.getGender(),null);
	}
	
	@Test
	public void testPersonGenderToString() {
		Person p1 = new Person("Name");
		assertEquals(p1.genderToString(), "Name");
	}
	
	@Test
	public void testPersonGenderToString2() {
		Person p1 = new Person("Name");
		p1.setGender(Gender.FEMALE);
		assertEquals(p1.genderToString(),"Female");
	}
	
	@Test
	public void testPersonGenderToString3() {
		Person p1 = new Person("Name");
		p1.setGender(Gender.MALE);
		assertEquals(p1.genderToString(),"Male");
	}
	
	@Test 
	public void testPersonName() {
		Person p1 = new Person("Name");
		assertEquals(p1.getName(), "Name");
	}
	
	@Test 
	public void testPersonEyeColor() {
		Person p1 = new Person("Name");
		p1.setEyeColor(EyeColor.BLACK);
		assertEquals(p1.getEyeColor(), EyeColor.BLACK);
	}
	
	@Test 
	public void testPersonEyeColor2() {
		Person p1 = new Person("Name");
		p1.setEyeColor(EyeColor.BLUE);
		assertEquals(p1.getEyeColor(), EyeColor.BLUE);
	}
	
	@Test 
	public void testPersonEyeColor3() {
		Person p1 = new Person("Name");
		p1.setEyeColor(EyeColor.BROWN);
		assertEquals(p1.getEyeColor(), EyeColor.BROWN);
	}
	
	@Test 
	public void testPersonEyeColor4() {
		Person p1 = new Person("Name");
		p1.setEyeColor(EyeColor.GREEN);
		assertEquals(p1.getEyeColor(), EyeColor.GREEN);
	}
	
	@Test 
	public void testPersonEyeColor5() {
		Person p1 = new Person("Name");
		p1.setEyeColor(EyeColor.GREY);
		assertEquals(p1.getEyeColor(), EyeColor.GREY);
	}
	
	@Test 
	public void testPersonEyeColor6() {
		Person p1 = new Person("Name");
		p1.setEyeColor(EyeColor.HAZEL);
		assertEquals(p1.getEyeColor(), EyeColor.HAZEL);
	}
	
	@Test 
	public void testPersonEyeColor7() {
		Person p1 = new Person("Name");
		p1.setEyeColor(EyeColor.MULTICOLOR);
		assertEquals(p1.getEyeColor(), EyeColor.MULTICOLOR);
	}
	
	@Test 
	public void testPersonEyeColorString() {
		Person p1 = new Person("Name");
		p1.setEyeColor(EyeColor.BLACK);
		assertEquals(p1.eyeColorToString(), "Black");
	}
	
	@Test 
	public void testPersonEyeColorString2() {
		Person p1 = new Person("Name");
		p1.setEyeColor(EyeColor.BLUE);
		assertEquals(p1.eyeColorToString(), "Blue");
	}
	
	@Test 
	public void testPersonEyeColorString3() {
		Person p1 = new Person("Name");
		p1.setEyeColor(EyeColor.BROWN);;
		assertEquals(p1.eyeColorToString(), "Brown");
	}
	
	@Test 
	public void testPersonEyeColorString4() {
		Person p1 = new Person("Name");
		p1.setEyeColor(EyeColor.GREEN);
		assertEquals(p1.eyeColorToString(), "Green");
	}
	
	@Test 
	public void testPersonEyeColorString5() {
		Person p1 = new Person("Name");
		p1.setEyeColor(EyeColor.GREY);
		assertEquals(p1.eyeColorToString(), "Grey");
	}
	
	@Test 
	public void testPersonEyeColorString6() {
		Person p1 = new Person("Name");
		p1.setEyeColor(EyeColor.HAZEL);
		assertEquals(p1.eyeColorToString(), "Hazel");
	}
	
	@Test 
	public void testPersonEyeColorString7() {
		Person p1 = new Person("Name");
		p1.setEyeColor(EyeColor.MULTICOLOR);
		assertEquals(p1.eyeColorToString(), "Multicolor");
	}
	
	@Test 
	public void testPersonBirthday() {
		Person p1 = new Person("Name");

		@SuppressWarnings("deprecation")
		Date date = new Date(2016,10,1);
		p1.setbDay(date);
		assertEquals(p1.getbDay(), date);
	}
	
	@Test 
	public void testTreeConstructor() {
		FamilyTree t1 = new FamilyTree();
		assertEquals(t1.getRoot(), null);
	}
	
	@Test 
	public void testTreeConstructor2() {
		FamilyTree t1 = new FamilyTree();
		assertEquals(t1.getFather(), null);
	}
	
	@Test 
	public void testTreeConstructor3() {
		FamilyTree t1 = new FamilyTree();
		assertEquals(t1.getMother(), null);
	}
	
	@Test 
	public void testTreeConstructor4() {
		FamilyTree t1 = new FamilyTree();
		assertEquals(t1.getSpouse(), null);
	}
	
	@Test 
	public void testTreeConstructor5() {
		FamilyTree t1 = new FamilyTree();
		assertEquals(t1.getChildrenList().size(), 0);
	}
	
	@Test 
	public void testTreeConstructor2_1() {
		Person p1 = new Person("Name");
		FamilyTree t1 = new FamilyTree(p1);
		assertEquals(t1.getRoot(), p1);
	}
	
	@Test 
	public void testTreeConstructor2_2() {
		Person p1 = new Person("Name");
		FamilyTree t1 = new FamilyTree(p1);
		assertEquals(t1.getFather(), null);
	}
	
	@Test 
	public void testTreeConstructor2_3() {
		Person p1 = new Person("Name");
		FamilyTree t1 = new FamilyTree(p1);
		assertEquals(t1.getMother(), null);
	}
	
	@Test 
	public void testTreeConstructor2_4() {
		Person p1 = new Person("Name");
		FamilyTree t1 = new FamilyTree(p1);
		assertEquals(t1.getSpouse(), null);
	}
	
	@Test 
	public void testTreeConstructor2_5() {
		Person p1 = new Person("Name");
		FamilyTree t1 = new FamilyTree(p1);
		assertEquals(t1.getChildrenList().size(), 0);
	}
	
	@Test 
	public void testTreeRoot(){
		Person p1 = new Person("Name");
		FamilyTree t1 = new FamilyTree();
		t1.setRoot(p1);
		assertEquals(t1.getRoot(), p1);
	}
	
	@Test 
	public void testTreeRoot2(){
		Person p1 = new Person("Name");
		FamilyTree t1 = new FamilyTree(p1);
		assertEquals(t1.getRoot(), p1);
	}
	
	@Test 
	public void testTreeFather(){
		Person p1 = new Person("Name");
		FamilyTree t1 = new FamilyTree(p1);
		assertEquals(t1.getFather(), null);
	}
	
	@Test 
	public void testTreeFather2(){
		Person p1 = new Person("Name");
		Person p2 = new Person("Name2");
		FamilyTree t1 = new FamilyTree(p1);
		FamilyTree t2 = new FamilyTree(p2);
		p2.setGender(Gender.MALE);
		t1.setFather(t2);
		assertEquals(t1.getFather(), p2);
	}

	@Test 
	public void testTreeFather3() {
		Person p1 = new Person("Name");
		Person p2 = new Person("Name2");
		FamilyTree t1 = new FamilyTree(p1);
		FamilyTree t2 = new FamilyTree(p2);
		t1.setFather(t2);
		assertTrue(t1.hasFather());
	}
	
	@Test 
	public void testTreeMother(){
		Person p1 = new Person("Name");
		FamilyTree t1 = new FamilyTree(p1);
		assertEquals(t1.getMother(), null);
	}

	@Test 
	public void testTreeMother2() {
		Person p1 = new Person("Name");
		Person p2 = new Person("Name2");
		FamilyTree t1 = new FamilyTree(p1);
		FamilyTree t2 = new FamilyTree(p2);
		p2.setGender(Gender.FEMALE);
		t1.setMother(t2);
		assertEquals(t1.getMother(), p2);
	}

	@Test 
	public void testTreeMother3() {
		Person p1 = new Person("Name");
		Person p2 = new Person("Name2");
		FamilyTree t1 = new FamilyTree(p1);
		FamilyTree t2 = new FamilyTree(p2);
		p2.setGender(Gender.FEMALE);
		t1.setMother(t2);
		assertTrue(t1.hasMother());
	}
	
	@Test 
	public void testTreeSpouse(){
		Person p1 = new Person("Name");
		FamilyTree t1 = new FamilyTree(p1);
		assertEquals(t1.getSpouse(), null);
	}

	@Test 
	public void testTreeSpouse2() {
		Person p1 = new Person("Name");
		Person p2 = new Person("Name2");
		FamilyTree t1 = new FamilyTree(p1);
		FamilyTree t2 = new FamilyTree(p2);
		t1.setSpouse(t2);
		assertEquals(t1.getSpouse(), p2);
	}

	@Test 
	public void testTreeSpouse3() {
		Person p1 = new Person("Name");
		Person p2 = new Person("Name2");
		FamilyTree t1 = new FamilyTree(p1);
		FamilyTree t2 = new FamilyTree(p2);
		t1.setSpouse(t2);
		assertTrue(t1.hasSpouse());
	}

	@Test 
	public void testTreeChildren() {
		FamilyTree p1 = new FamilyTree();
		FamilyTree p2 = new FamilyTree();
		p1.addChild(p2);
		assertEquals(p1.getChildrenList().size(), 1);
	}
	
	@Test 
	public void testTreeChildren2() {
		FamilyTree p1 = new FamilyTree();
		FamilyTree p2 = new FamilyTree();
		p1.addChild(p2);
		assertTrue(p1.hasChildren());
	}
	
	@Test 
	public void testTreeChildren3() {
		FamilyTree p1 = new FamilyTree();
		assertFalse(p1.hasChildren());
	}
	
	@Test 
	public void testTreeChildren4() {
		Person p1 = new Person("Name");
		Person p2 = new Person("Name2");
		ArrayList<Person> children = new ArrayList<Person>();
		children.add(p2);
		FamilyTree t1 = new FamilyTree(p1);
		FamilyTree t2 = new FamilyTree(p2);
		t1.addChild(t2);
		assertEquals(t1.childToString(children), "Name2"+"\n");
	}
	
	@Test 
	@Ignore
	public void testTreeChildren5() {
		Person p1 = new Person("Name");
		Person p2 = new Person("Name2");
		FamilyTree t1 = new FamilyTree(p1);
		FamilyTree t2 = new FamilyTree(p2);
		p1.setChildren(t2);
		assertEquals(p1.childToString(p1.getChildrenList()), "Name");
	}
	
	@Test 
	@Ignore
	public void testTreeChildren5() {
		Person p1 = new Person();
		p1.addChild("NameA" + "/n" + "NameB" + "/n"+ "NameC");
		assertTrue(p1.getChildrenList().contains("NameA"));
		assertTrue(p1.getChildrenList().contains("NameB"));
		assertTrue(p1.getChildrenList().contains("NameC"));
	}
	
	@Test 
	public void testTreeCompareTo() {
		Person p1 = new Person("Name");
		FamilyTree t1 = new FamilyTree(p1);
		assertTrue(t1.compareTo(p1));
	}
	
	@Test
	@Ignore
	public void testTreeAdd() throws Exception {
	    FamilyTree l = new FamilyTree();
		Person c = new Person("Name");
		Person a = new Person("Name2");
		Person d = new Person("Name3");
		Person b = new Person("Name4");

		c.setName("TestPersonC");
		a.setName("TestPersonA");
		d.setName("TestPersonD");
		b.setName("TestPersonB");

		l.addChild(c.getName());
		l.addChild(a.getName());
		l.addChild(d.getName());
		l.addChild(b.getName());
	}

	@Test
	@Ignore
	public void testTreeRemove() {
		Person c = new Person("Name");
		Person a = new Person("Name2");
		Person d = new Person("Name3");
		Person b = new Person("Name4");

		c.setName("TestPersonC");
		a.setName("TestPersonA");
		d.setName("TestPersonD");
		b.setName("TestPersonB");

		l.add(c);
		l.add(a);
		l.add(d);
		l.add(b);

		l.remove(0);
		l.remove(2);

		int size = l.getSize();

		assertEquals(size, 2);
	}

	
	@Ignore
	@Test
	public void testLibrary() {
		FamilyTree tree = new FamilyTree();
		Person c = new Person("Name");
		Person a = new Person("Name2");
		Person d = new Person("Name3");
		Person b = new Person("Name4");

		c.setName("TestPersonC");
		a.setName("TestPersonA");
		d.setName("TestPersonD");
		b.setName("TestPersonB");

		tree.addChild(c.getName());
		tree.addChild(a.getName());
		tree.addChild(d.getName());
		tree.addChild(b.getName());
		

		assertTrue(tree.doesContainPerson(d).equals(d.getName()));
	}
	
	@Test
	@Ignore
	public void testLibrary() {
		FamilyTree tree = new FamilyTree();
		Person c = new Person("Name");
		Person a = new Person("Name2");
		Person d = new Person("Name3");
		Person b = new Person("Name4");

		c.setName("TestPersonC");
		a.setName("TestPersonA");
		d.setName("TestPersonD");
		b.setName("TestPersonB");

		tree.addChild(c.getName());
		tree.addChild(a.getName());
		tree.addChild(d.getName());
		tree.addChild(b.getName());
		

		assertTrue(tree.doesContainPerson(d.getName()).equals(d.getName()));
	}
	
}
