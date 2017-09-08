package package1;

import static org.junit.Assert.*;

import org.junit.Test;

import package1.Person.Gender;

public class FamilyTreeTest {

	@Test
	public void testPersonCreation() {
		Person p1 = new Person();
		assertEquals(p1.getChildrenList().size(),0);
	}
	
	@Test
	public void testPersonGender() {
		Person p1 = new Person();
		p1.setGender(Gender.MALE);
		assertEquals(p1.getGender(),Gender.MALE);
	}
	
	@Test
	public void testPersonGender2() {
		Person p1 = new Person();
		p1.setGender(Gender.FEMALE);
		assertEquals(p1.getGender(),Gender.FEMALE);
	}
	
	@Test
	public void testPersonGender3() {
		Person p1 = new Person();
		assertEquals(p1.getGender(),null);
	}
	
	@Test 
	public void testPersonName() {
		Person p1 = new Person();
		p1.setName("Name");
		assertEquals(p1.getName(), "Name");
	}
	
	@Test 
	public void testPersonChildren() {
		Person p1 = new Person();
		Person p2 = new Person();
		p1.setChildren(p2);
		assertEquals(p1.getChildrenList().size(), 1);
	}
	
//	@Test 
//	public void testPersonChildren2() {
//		Person p1 = new Person();
//		Person p2 = new Person();
//		p1.addChildren(p2);
//		assertEquals(p1.getChildrenListEngine().getSize(), 1);
//	}
//	
//	@Test 
//	public void testPersonChildren3() {
//		Person p1 = new Person();
//		Person p2 = new Person();
//		p2.setName("Name");
//		p1.setChildren(p2);
//		assertEquals(p1.childToString(p1.getChildrenList()), "Name");
//	}
//	
//	@Test 
//	public void testPersonChildren4() {
//		Person p1 = new Person();
//		p1.addChildren("NameA" + "/n" + "NameB" + "/n"+ "NameC");
//		assertTrue(p1.getChildrenList().contains("NameA"));
//		assertTrue(p1.getChildrenList().contains("NameB"));
//		assertTrue(p1.getChildrenList().contains("NameC"));
//	}
	
	@Test 
	public void testPersonHasFather() {
		Person p1 = new Person();
		Person p2 = new Person();
		p2.setName("Name");
		p1.setFather(p2);
		assertTrue(p1.hasFather());
	}
	
	@Test 
	public void testPersonFather() {
		Person p1 = new Person();
		Person p2 = new Person();
		p2.setName("Name");
		p1.setFather(p2);
		assertEquals(p1.getFather(), p2);
	}

	@Test 
	public void testPersonHasMother() {
		Person p1 = new Person();
		Person p2 = new Person();
		p2.setName("Name");
		p1.setMother(p2);
		assertTrue(p1.hasMother());
	}
	
	@Test 
	public void testPersonMother() {
		Person p1 = new Person();
		Person p2 = new Person();
		p2.setName("Name");
		p1.setMother(p2);
		assertEquals(p1.getMother(), p2);
	}
	
	@Test 
	public void testPersonHasSpouse() {
		Person p1 = new Person();
		Person p2 = new Person();
		p2.setName("Name");
		p1.setSpouse(p2);
		assertTrue(p1.hasSpouse());
	}
	
	@Test 
	public void testPersonSpouse() {
		Person p1 = new Person();
		Person p2 = new Person();
		p2.setName("Name");
		p1.setSpouse(p2);
		assertEquals(p1.getSpouse(), p2);
	}
	
	@Test 
	public void testPersonCompareTo() {
		Person p1 = new Person();
		p1.setName("Name");
		assertEquals(p1.compareTo(p1), 0);
	}
	
	@Test 
	public void testPersonToString() {
		Person p1 = new Person();
		p1.setName("Name");
		assertEquals(p1.toString(), "Name");
	}
	
	@Test
	public void testAdd() {
		ListEngine l = new ListEngine ();
		Person c = new Person();
		Person a = new Person();
		Person d = new Person();
		Person b = new Person();

		c.setName("TestPersonC");
		a.setName("TestPersonA");
		d.setName("TestPersonD");
		b.setName("TestPersonB");

		l.add(c);
		l.add(a);
		l.add(d);
		l.add(b);

		Person first = l.get(0);
		Person second = l.get(1);
		Person third = l.get(2);
		Person fourth = l.get(3);

		assertTrue (first.getName().equals(a.getName()));
		assertTrue (second.getName().equals(b.getName()));
		assertTrue (third.getName().equals(c.getName()));
		assertTrue (fourth.getName().equals(d.getName()));	
	}

	@Test
	public void testRemove() {
		ListEngine l = new ListEngine ();
		Person c = new Person();
		Person a = new Person();
		Person d = new Person();
		Person b = new Person();

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

	@Test
	public void testFind() {
		ListEngine l = new ListEngine ();
		Person c = new Person();
		Person a = new Person();
		Person d = new Person();
		Person b = new Person();

		c.setName("TestPersonC");
		a.setName("TestPersonA");
		d.setName("TestPersonD");
		b.setName("TestPersonB");

		l.add(c);
		l.add(a);
		l.add(d);
		l.add(b);

		Person found = l.find("TestPersonD");

		assertTrue(found.getName().equals(d.getName()));
	}
}
