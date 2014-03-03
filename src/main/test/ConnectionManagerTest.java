package main.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.psl.main.LoginDAO;

public class ConnectionManagerTest {

	LoginDAO dao;
	@Before
	public void setUp() throws Exception {
		dao = new LoginDAO();
	}

	@After
	public void tearDown() throws Exception {
		LoginDAO dao = null;
	}

	@Test
	public void testGetConnection() {
		assertTrue(dao.TestCase("Shweta", "Shweta@123"));
	}
	
	@Test
	public void testEx() {
		assertTrue(true);
	}

}
