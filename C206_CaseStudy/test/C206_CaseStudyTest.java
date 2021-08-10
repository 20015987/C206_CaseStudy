import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class C206_CaseStudyTest {

	static ArrayList<Account> accountList;
	ArrayList<requestQuotation> requestQuotationList;
	ArrayList<Appointment> appointmentList;

	static Account user1;
	static Account user2;
	static Account user3;
	static Account user4;
	static Account user5;
	requestQuotation rq1;
	requestQuotation rq2;
	static Appointment app1;
	static Appointment app2;
	static Appointment app3;

	@Before
	public void setUp() throws Exception {

		// Instantiate Test Data Here


		user1 = new Account("proApple", "Customer","gamer@yahoo.com","Republ!c01","New");
		user2 = new Account("", "Customer","Rapper@yahoo.com","Republ!c01","New");
		user3 = new Account("Doctor", "Customer","Doctor@yahoo.com","Republ!c01","New");
		user4 = new Account("Player69", "Customer","Player69@yahoo.com","Republ!c01","New");
		user5 = new Account("Dogman", "Customer","Dogman@yahoo.com","Republ!c01","New");

		accountList = new ArrayList<Account>();
		requestQuotationList = new ArrayList<requestQuotation>();
		rq1 = new requestQuotation("Property Type", 12, "Test Request Name", 92961140, "student@rp.edu.sg",
				10, "2021", "Reno Type", 0, 0,
				"Status", "RQ01");
		rq2 = new requestQuotation("Property Type", 12, "Test Request Name", 92961140, "student@rp.edu.sg",
				10, "2021", "Reno Type", 0, 0,
				"Status", "RQ01");

		app1 = new Appointment("Charmaine", "9 August 2021", 1300, "Michelle", "Woodlands Avenue 1");
		app2 = new Appointment("Bob", "9 July 2021", 1900, "Mark", "Woodlands Drive 1");
		app3 = new Appointment("Michael", "9 September 2021", 1230, "Peter", "Woodlands Avenue 2");
		
		appointmentList = new ArrayList<Appointment>();
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

	@Test
	public void testViewReqForQuote() {
		// Test that one RFQ is displayed when list has 1 element
		user1.RQlist.add(rq1);
		assertEquals("Test that one RFQ is displayed when list has 1 element.","ID    Request Name         Type       Target Date        Status    \n"
				+ "RQ01  Test Request Name    Reno Type  2021               Status    \n",
				C206_CaseStudy.viewReqForQuote(user1));
		// Test that no RFQ is displayed when list has 0 element
		user1.RQlist.clear();
		assertEquals("Test that no RFQ is displayed when list has 0 element", 
				String.format("%-5s %-20s %-10s %-18s %-10s\n", 
						"ID", "Request Name", "Type", "Target Date", "Status"), C206_CaseStudy.viewReqForQuote(user1));
		// Test that two RQF is displayed when list has 2 element
		user1.RQlist.add(rq1);
		user1.RQlist.add(rq2);
		assertEquals("Test that two RQF is displayed when list has 2 element", "ID    Request Name         Type       Target Date        Status    \n"
				+ "RQ01  Test Request Name    Reno Type  2021               Status    \n"
				+ "RQ01  Test Request Name    Reno Type  2021               Status    \n", C206_CaseStudy.viewReqForQuote(user1));
		// Test that the list is not null
		assertNotNull("Test that the list is not null", user1.RQlist);
	}

	@Test
	public void testDeleteReqForQuote() {
		// Test that the list is not null
		assertNotNull("Test that the list is not null", user1.RQlist);
		// Test that the Request Quote Name is not empty
		user1.RQlist.add(rq1);
		assertEquals("RQN not empty", "Test Request Name", user1.RQlist.get(0).getRequestName());
		// Test that list has 0 elements after removing 1 element 
		user1.RQlist.remove(0);
		assertEquals("Test that the list has 0 element after removing 1 element", 0, user1.RQlist.size());
		// Test check that the request name match the deleted request
		user1.RQlist.add(rq1);
		assertEquals("Test that the RQN match the deleted request", "Test Request Name", user1.RQlist.get(0).getRequestName());
	}
	@Test
	public void testAddUser() {

		// Test if the list is not null
		assertNotNull("Test that the list is not null", accountList);

		// Test if list is empty, after adding new customer the list is no longer empty 

		accountList.add(C206_CaseStudy.addUser("Sai", "Administrator", "sai@gmail.com", "abcd1234", "New"));
		assertEquals("Test that the list is empty after adding new customer", 1 , accountList.size());

		// Test if the list contains one element after adding a null element
		accountList.clear();
		accountList.add(null);
		assertEquals("Test that the Empty list remains empty after adding a null component", 1 , accountList.size());

		// Test if the list having one customer. And after adding it to the list, the list will have two customers 
		accountList.add(C206_CaseStudy.addUser("Sai", "Administrator", "sai@gmail.com", "abcd1234", "New"));
		assertEquals("Test that the the list has 2 customers now from previous value of 1", 2 , accountList.size());
	}
	@Test
	public void testDeleteUser() {

		// Test if the list is not null
		assertNotNull("Test that the list is not null", accountList);

		// Test if, list has one customer, check that the customer to delete by name matches the customer in the list  
		accountList.clear();
		accountList.add(user1);
		if (user1.getName().equals("proApple")) {
			accountList.remove(0);	
		}
		assertEquals("Test that the list becomes empty after deleting cutomer once matched from list", 0 , accountList.size());

		// Test if, the list has one customer and after removing the customer from the customer list, it will no longer have any customers remaining 
		accountList.clear();
		accountList.add(user1);
		accountList.remove(0);	
		assertEquals("Test that the list becomes empty after deleting cutomer once matched from list", 0 , accountList.size());

		// Test if, the name parameter when deleting is empty 
		accountList.clear();
		accountList.add(user2);
		accountList.remove(0);	
		assertEquals("Test that the list is empty despite having no name as a parameter ", 0 , accountList.size());

	}
	@Test
	public void testViewUser() {

		// Test if the list is not null
		assertNotNull("Test that the list is not null", accountList);

		// Test if, when list has one customer. After viewing, only one customer is displayed 
		accountList.clear();
		accountList.add(user1);
		C206_CaseStudy.viewUser();
		assertEquals("Test that the list contains only one customer when opted to view ", 1 , accountList.size());

		// Test if, when list has zero customers. After viewing there is no customer that is displayed 
		accountList.clear();
		C206_CaseStudy.viewUser();
		assertEquals("Test that the list contains only one customer when opted to view ", 0 , accountList.size());

		// Test if, Customer list has four customers. After viewing, only four customers are displayed 
		accountList.clear();
		accountList.add(user1);
		accountList.add(user3);
		accountList.add(user4);
		accountList.add(user5);
		C206_CaseStudy.viewUser();
		assertEquals("Test that the list contains four customers when opted to view ", 4 , accountList.size());

	}
	
@Test
public void testAddAppointment() {

	// Test if the list is not null
	assertNotNull("Test that the list is not null", appointmentList);

	// Test if list is empty, after adding new appointment the list is no longer empty 

	appointmentList.add(C206_CaseStudy.inputAppointment("Charmaine", "6 August 2021", 1600, "Michelle", "Woodlands Drive 1"));
	assertEquals("Test that the list is empty after adding new appointment", 1 , appointmentList.size());

	// Test if the list contains one element after adding a null element
	appointmentList.clear();
	appointmentList.add(null);
	assertEquals("Test that the Empty list remains empty after adding a null component", 1 , appointmentList.size());

	// Test if the list having one appointment. And after adding it to the list, the list will have two appointments 
	appointmentList.add(C206_CaseStudy.inputAppointment("Charmaine", "6 August 2021", 1600, "Michelle", "Woodlands Drive 2"));
	assertEquals("Test that the the list has 2 appointments now from previous value of 1", 2 , appointmentList.size());

}

@Test
public void testViewAllAppointment() {
	// Test if the list is not null
	assertNotNull("Test that the list is not null", appointmentList);

	// Test if, when list has one appointment. After viewing, only one appointment is displayed 
	appointmentList.clear();
	appointmentList.add(app1);
	C206_CaseStudy.viewAllAppointment(appointmentList);
	assertEquals("Test that the list contains only one appointment when opted to view ", 1 , appointmentList.size());

	// Test if, when list has zero appointment. After viewing there is no appoint that is displayed 
	appointmentList.clear();
	C206_CaseStudy.viewAllAppointment(appointmentList);
	assertEquals("Test that the list contains only one customer when opted to view ", 0 , appointmentList.size());

	// Test if, Customer list has 3 appointment. After viewing, only 3 appointment are displayed 
	appointmentList.clear();
	appointmentList.add(app1);
	appointmentList.add(app2);
	appointmentList.add(app3);

	C206_CaseStudy.viewAllAppointment(appointmentList);
	assertEquals("Test that the list contains 3 appointments when opted to view ", 3 , appointmentList.size());

}
@Test
public void testDeleteAppointment() {

	// Test if the list is not null
	assertNotNull("Test that the list is not null", appointmentList);

	// Test if, list has one appointment, check that the appointment to delete by name matches the customer in the list  
	appointmentList.clear();
	appointmentList.add(app1);
	if (app1.getCustName().equals("Charmaine")) {
		appointmentList.remove(0);	
	}
	assertEquals("Test that the list becomes empty after deleting appointment once matched from list", 0 , appointmentList.size());

	// Test if, the list has one appointment and after removing the appointment from the appointment list, it will no longer have any appointment remaining 
	appointmentList.clear();
	appointmentList.add(app1);
	appointmentList.remove(0);	
	assertEquals("Test that the list becomes empty after deleting appointment once matched from list", 0 , appointmentList.size());

	// Test if, the name parameter when deleting is empty 
	appointmentList.clear();
	appointmentList.add(app2);
	appointmentList.remove(0);	
	assertEquals("Test that the list is empty despite having no appointment as a parameter ", 0 , appointmentList.size());

}

}


