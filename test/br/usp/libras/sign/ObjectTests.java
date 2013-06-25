package br.usp.libras.sign;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * Test methods from Object class: clone and equals
 * @author leonardo
 *
 */
public class ObjectTests {

	Sign s1, s2, s3;
	
	@Before 
	public void setUp() {
		
		SignGenerator gen = new SignGenerator();
		s1 = gen.getRandomSign();
		s2 = gen.getRandomSign();
		s3 = gen.getRandomSign();
	}
	
	@Test
	public void testClone() {
		
		// test the clone contract

		assertTrue(s1.clone() != s1);
		assertTrue(s1.clone().getClass() == s1.getClass());
		assertTrue(s1.clone().equals(s1));

		assertTrue(s2.clone() != s2);
		assertTrue(s2.clone().getClass() == s2.getClass());
		assertTrue(s2.clone().equals(s2));

		assertTrue(s3.clone() != s3);
		assertTrue(s3.clone().getClass() == s3.getClass());
		assertTrue(s3.clone().equals(s3));
	}
	
	@Test
	public void testEquals() {
		
		// test the equals contract
		
		// reflexive
		assertTrue(s1.equals(s1));
		assertTrue(s2.equals(s2));
		assertTrue(s3.equals(s3));
		// symmetric
		Sign sc1 = s1.clone();
		assertEquals(s1.equals(sc1), sc1.equals(s1)); // true
		assertEquals(s1.equals(s2), s2.equals(s1)); // false
		// transitive
		Sign sc2 = sc1.clone();
		assertEquals(s1.equals(sc2), sc1.equals(sc2)); // true
		assertEquals(s1.equals(s3), s2.equals(s3)); // false 
		// null
		assertFalse(s1.equals(null));
	}
}
