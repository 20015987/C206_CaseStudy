import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class C206_CaseStudyTest {
	
	ArrayList<Account> accountList;
	ArrayList<requestQuotation> requestQuotationList;
	requestQuotation rq1;
	requestQuotation rq2;

	@Before
	public void setUp() throws Exception {
		// Instantiate Test Data Here
		
		accountList = new ArrayList<Account>();
		requestQuotationList = new ArrayList<requestQuotation>();
		rq1 = new requestQuotation("Property Type", 12, "Test Request Name", 92961140, "student@rp.edu.sg",
				10, "2021", "Reno Type", 0, 0,
				"Status", "RQ01");
		rq2 = new requestQuotation("Property Type", 12, "Test Request Name", 92961140, "student@rp.edu.sg",
				10, "2021", "Reno Type", 0, 0,
				"Status", "RQ01");
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
		assertEquals("Test that the list is contains 1 element after adding a null element", 1, requestQuotationList.size());
		// Test that given empty list, after adding new request, list is not empty
		requestQuotationList.clear();
		requestQuotationList.add(rq1);
		assertEquals("Test that the list contains 1 element after adding", 1, requestQuotationList.size());
		// Test that given list contains 1 request, after adding another, the list size is 2
		requestQuotationList.add(rq2);
		assertEquals("Test that the list contains 2 elements after adding again", 2, requestQuotationList.size());
		
	}

}
