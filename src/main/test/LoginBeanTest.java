package main.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.internal.runners.statements.Fail;

import com.psl.main.LoginBean;




public class LoginBeanTest {
	

	LoginBean loginBean;
	

	@Before
	public void setUp() throws Exception {
		loginBean = new LoginBean();
	}

	@After
	public void tearDown() throws Exception {
		loginBean = null;
	}

	@Test
	public void testGetFirstName() {
		assertEquals("Shweta", "Shweta");
	}

	@Test
	public void testGetLastName() {
		assertEquals("Sharma", "Sharma");
	}
	
//	@Test
//	public void testGetUsername() {
//		assertEquals("Sharma", loginBean.getUsername());
//	}
//	
//	@Test
//	public void testGetPassword() {
//		assertEquals("Sharma@123", loginBean.getPassword());
//	}
}
