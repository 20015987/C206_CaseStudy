import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class C206_CaseStudyTest {
	
	ArrayList<Account> accountList;
	ArrayList<requestQuotation> requestQuotationList;

	@Before
	public void setUp() throws Exception {
		// Instantiate Test Data Here
		
		accountList = new ArrayList<Account>();
		requestQuotationList = new ArrayList<requestQuotation>();
	}

	@After
	public void tearDown() throws Exception {
		// Undo Instantiation Of Test Data Here
	}

	@Test
	public void testAddReqForQuote() {
		
		// Test that the list is not null
		assertNotNull("Test that the list is not null", requestQuotationList);
		// Given that the list is empty, test that the list is empty after adding a null element
		requestQuotationList.add(null);
		assertEquals("Test that the list is empty after adding a null element", 0, accountList.size());
		// Test that given empty list, after adding new request, list is not empty
		C206_CaseStudy.addReqForQuote(requestQuotationList);
		assertEquals("Test that the list contains 1 element after adding", 1, accountList.size());
		// Test that given list contains 1 request, after adding another, the list size is 2
		C206_CaseStudy.addReqForQuote(requestQuotationList);
		assertEquals("Test that the list contains 2 elements after adding again", 2, accountList.size());
		
	}

}
