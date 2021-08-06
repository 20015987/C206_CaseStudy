import java.util.ArrayList;

public class C206_CaseStudy {
	
	// Instantiate ArrayLists
	
	private static ArrayList<Account> accountList = new ArrayList<Account>();
	private static Account currentLoginAccount = null;
	private static ArrayList<Quotation> ql = new ArrayList<Quotation>();
	private static ArrayList<Appointment> appointmentList = new ArrayList<Appointment>(); // code made by charmaine - 20028846

	
	public static void main(String[] args) {
		
		// Test Data
		
		Account account1 = new Account("Ammar", "Customer", "ammar@jimmy.com", "Republ!c01", "new");
		accountList.add(account1);
		Account admin_account = new Account("Sai", "Administrator", "Sai@yahoo.com", "abcdefg", "Confirmed");
		accountList.add(admin_account);
		
		requestQuotation rq1 = new requestQuotation("Property Type", 12, "Test Request Name", 92961140, "student@rp.edu.sg",
				10, "2021", "Reno Type", 0, 0,
				"Status", "RQ01");
		requestQuotation rq2 = new requestQuotation("Property Type", 12, "Test Request Name", 92961140, "student@rp.edu.sg",
				10, "2021", "Reno Type", 0, 0,
				"Status", "RQ01");
		
		account1.RQlist.add(rq1);
		account1.RQlist.add(rq2);
		
		ql.add(new Quotation("1", "1","Living Room","Windows - $500", "Kirito", "06-08-2021", "500.00"));
		ql.add(new Quotation("2", "2","Living Room","Doors - $200", "Shinon", "06-08-2021", "200.00"));

		int visitorOption = 0;
		
		while (visitorOption != 3) {
			// Show Visitor Page
			showVisitorMenu();
			// Prompt Option
			Helper.line(60, "-");
			visitorOption = Helper.readInt("Enter Option: ");
			Helper.line(60, "-");
			
			if (visitorOption == 1) {
				currentLoginAccount = loginAccount();
			}
			else if (visitorOption == 2) {
				// Call The Register Method Here
			}
			else if (visitorOption == 3) {
				// Goodbye message
				System.out.println("Thank you for using Renovation Ace");
			}
			else {
				System.out.println("Invalid Option");
			}
			
			while (currentLoginAccount != null) {
				
				// Check Role Of Account
				
				if (currentLoginAccount.getRole().equals("Customer")) {
					
					int customerOption = 0;
					
					while (customerOption != 3) {
						
						// Show Menu
						showCustomerMenu();
						
						// Prompt Customer
						Helper.line(60, "-");
						customerOption = Helper.readInt("Option: ");
						Helper.line(60, "-");
						
						switch(customerOption) {
						case 1:
							int manageRFQOption = 0;
							
							while (manageRFQOption != 4) {
								
								// Show Manage Request For Quotation Menu
								showManageRFQMenu();
								
								// Prompt Customer
								Helper.line(60, "-");
								manageRFQOption = Helper.readInt("Option: ");
								Helper.line(60, "-");
								
								// Switch Case
								
								switch(manageRFQOption) {
								case 1:
									// Add RQF
									addReqForQuote(currentLoginAccount.RQlist);
									break;
								case 2:
									// View RQF
									if (currentLoginAccount.RQlist.size() != 0) {
										System.out.println(viewReqForQuote(currentLoginAccount));
									}
									else {
										System.out.println("No Existing Request For Quotations");
									}
									break;
								case 3:
									// Delete RFQ
									if (currentLoginAccount.RQlist.size() != 0) {
										deleteReqForQuote(currentLoginAccount);
									}
									else {
										System.out.println("No Existing Request For Quotations (Feature Unavailable)");
									}
									break;
								case 4:
									// Exit
									break;
								default:
									System.out.println("Invalid Option");
								}
							}
							
						case 2:
							// Manage Appointments
							break;
						case 3:
							// Manage Quotations
							int option = 0;
							while (option != 4) {
								showManageQuotationMenu();
								Helper.line(60, "-");
								option = Helper.readInt("Option > ");
								Helper.line(60, "-");

								switch(option) {
								case 1: 
									//Add Quotation
									Quotation a = addQuotation();
									if (a != null) {
										ql.add(a);
										System.out.println("Quotation has been added. ");
									} else {
										System.out.println("Invalid Input");
									}
									break;
								case 2: 
									//View Quotation
									C206_CaseStudy.viewAll(ql);
									break;
								case 3: 
									//Delete Quotation
									Quotation b = null;
							        if (ql.size() != 0) {
							            String QID = Helper.readString("Enter Quotation ID > ");
							            for (Quotation c : ql) {
							                if (c.getQID().equals(QID)) {
							                    b = c;
							                    C206_CaseStudy.deleteQuotation(ql, b);
							                }
							            }
							        } else {
							            System.out.println("Invalid Quotation ID. ");
							        }
							        break;
								case 4: 
									break;
									
								}

							}
						case 4: 
							// Log out
							currentLoginAccount = null;
							System.out.println("Log out successful");
							break;
						default:
							Helper.line(60, "-");
							System.out.println("Invalid Option");
						}
					}
				}
				else if (currentLoginAccount.getRole().equals("Administrator")) {
					
					int adminOption = 0;
					
					// While loop
					while (adminOption != 6) {
						
						// Show Menu
						showAdministratorMenu();
						// Prompt Customer
						adminOption = Helper.readInt("Option: ");
						// Switch case
						
						
						switch(adminOption) {
						case 1:
							// Manage Customer
							// Switch Case
												
							int manageCustomerOption = 0;
							while (manageCustomerOption !=4) {
								showManageCustomerMenu();
								manageCustomerOption = Helper.readInt("Enter the option : ");
							switch(manageCustomerOption) {
								case 1:
									// Add 
									
									String name = Helper.readString("Enter your name : ");
									String role = Helper.readString("Enter the role : ");
									String email = Helper.readString("Enter the email : ");
									String password = Helper.readString("Enter the password : ");
									String status = Helper.readString("Enter the status : ");
									
									accountList.add(addUser(name, role, email, password, status));
									break;
								case 2:
									// View 
									System.out.println(viewUser());
									break;
								case 3:
									// Delete 
									deleteUser();
									break;
								case 4:
									// Exit
									break;
								default:
									System.out.println("Invalid Option");
								break;
								}
							}
						case 2:
							// Manage Package
							break;
						case 3:
							// Manage Request For Quotation
							break;
						case 4:
							// Manage Quotation
							
							break;
						case 5:
							// Manage Appointments
							break;
						case 6:
							// Log out
							break;
						default:
							System.out.println("Invalid Option");
						}
					}
				}
			}
		}
	}
	
	private static void setHeader(String string) {
		// TODO Auto-generated method stub
		
	}
	private static void deleteQuotation(ArrayList<Quotation> ql, Quotation b) {
		// TODO Auto-generated method stub
		if (b != null && ql.remove(b)) {
			System.out.println("Quotation removed.");
		} else {
			System.out.println("Invalid Quotation");
		}
	}

	/**
	 * @return
	 */
	public static void viewAll(ArrayList<Quotation> ql) {
		Helper.line(60, "=");
		System.out.println("Quotation List");
		Helper.line(60, "=");
		
		String output = String.format("%-15s %-15s %-15s %-15s %-15s %-15s %s\n", "REQUEST ID", "QUOTATION ID", "CATEGORY", "DESCRIPTION", "DESIGNER", "EARLIEST DATE", "TOTAL AMOUNT");
        output += viewQuotation(ql);
        System.out.println(output);
	}
	private static String viewQuotation(ArrayList<Quotation> ql) {
		// TODO Auto-generated method stub
		String output = "";


        for (Quotation q : ql) {
            output += String.format("%s", q.stringQuote());
        }
        return output;
	}

	/**
	 * @return 
	 * 
	 */
	private static Quotation addQuotation() {
		// TODO Auto-generated method stub
		Quotation a = null;

		String RID = Helper.readString("Enter Request ID > ");

		String QID = Helper.readString("Enter Quotation ID > ");

		String RC = Helper.readString("Enter Renovation Category [Kitchen|Living Room|Bedroom] > ");

		String RD = Helper.readString("Enter Renovation Description > ");

		String DN = Helper.readString("Enter Designers Name > ");

		String  ESA = Helper.readString("Enter Date [dd-MM-yyyy] > ");

		String TQA = Helper.readString("Enter Total Quotation Amount [0000.00] > ");

		a = new Quotation(RID, QID, RC, RD, DN , ESA, TQA);
		
		return a;
	}


	/**
	 * 
	 */
	private static void showManageQuotationMenu() {
		// TODO Auto-generated method stub
		Helper.line(60, "=");
		System.out.println("Manage Quotations");
		Helper.line(60, "=");

		System.out.println("1. Add a Quotation \n"
				+ "2. View All Quotation \n"
				+ "3. Delete a Quotation \n"
				+ "4. Back");
	}
	
	public static void showManageCustomerMenu() {
		
		// Write Menu + Options
		
		Helper.line(60, "=");
		System.out.println("Manage Customers");
		Helper.line(60, "=");
		
		System.out.println("1. Add User\n"
						 + "2. View User\n"
						 + "3. Delete by Name");
	}
	
	public static void showCustomerMenu() {
		
		// Write Menu + Options
		
		Helper.line(60, "=");
		System.out.println("WELCOME TO RENOVATION ACE (CUSTOMER)");
		Helper.line(60, "=");
		
		System.out.println("1. Manage Request For Quotation\n"
						 + "2. Manage Appointment\n"
						 + "3. Log out");
	}
	
	public static void showAdministratorMenu() {
		
		// Write Menu + Options
		
		Helper.line(60, "=");
		System.out.println("WELCOME TO RENOVATION ACE (ADMINISTRATOR)");
		Helper.line(60, "=");
		
		System.out.println("1. Manage Customer\n"
						 + "2. Manage Package\n"
						 + "3. Manage Request For Quotation\n"
						 + "4. Manage Quotation\n"
						 + "5. Manage Appointment\n"
						 + "6. Log out");
	}
	
	public static void showVisitorMenu() {
		
		// Write Menu + Options
		
		Helper.line(60, "=");
		System.out.println("WELCOME TO RENOVATION ACE");
		Helper.line(60, "=");
		
		System.out.println("1. Login Account\n"
						 + "2. Register Account\n"
						 + "3. Exit Renovation Ace");
	}
	
	// Add your methods here
	
	public static void showManageRFQMenu() {
		Helper.line(60, "-");
		System.out.println("Manage Request For Quotation");
		Helper.line(60, "-");
		
		System.out.println("1. Add Request For Quotation\n"
						 + "2. View Request For Quotation\n"
						 + "3. Delete Request For Quotation\n"
						 + "4. Return To Homepage");
		
		
	}
	
	public static Account loginAccount() {
		
		Helper.line(60, "=");
		System.out.println("LOGIN PAGE");
		Helper.line(60, "=");
		
		// Prompt User For Username and Password
		String username = Helper.readString("Enter Username: ");
		String password = Helper.readString("Enter Password: ");
		
		for (int i = 0; i < accountList.size(); i ++) {
			if (username.equals(accountList.get(i).getName())) {
				if (password.equals(accountList.get(i).getPassword())) {
					return accountList.get(i);
				}
			}
		}
		System.out.println("Username or Password is incorrect");
		return null;
	}
	
	
	public static void addReqForQuote(ArrayList<requestQuotation> requestQuotationList) {
		
		String propertyType = Helper.readString("Enter Property Type: ");
		double areaSize = Helper.readDouble("Enter Area Size: ");
		String requestName = Helper.readString("Enter Request Name: ");
		int contactNumber = Helper.readInt("Enter Contact Number: ");
		String email = Helper.readString("Enter Email: ");
		double budget = Helper.readDouble("Enter Budget: ");
		String targetDate = Helper.readString("Enter Target Date: ");
		String renovationType = Helper.readString("Enter Renovation Type: ");
		int numOfToilets = Helper.readInt("Enter Number Of Toilets: ");
		int numOfRooms = Helper.readInt("Enter Number Of Rooms: ");
		String requestStatus = Helper.readString("Enter Request Status (Urgent/Not Urgent): ");
		
		String requestID = Integer.toString(requestQuotationList.size() + 1);
		
		requestQuotationList.add(new requestQuotation(propertyType, areaSize, requestName, contactNumber, email,
				budget, targetDate, renovationType, numOfToilets, numOfRooms,
				requestStatus, requestID));
		
		System.out.println(requestQuotationList.get(0).getRequestName() + " has been successfully added!");
		
	}
	
	public static String viewReqForQuote(Account account) {
		String output = String.format("%-5s %-20s %-10s %-18s %-10s\n", "ID", "Request Name", "Type", "Target Date", "Status");
		
		for (requestQuotation anRQObject: account.RQlist) {
			String ID = anRQObject.getRequestID();
			String RenovName = anRQObject.getRequestName();
			String RenovType = anRQObject.getRenovationType();
			String Date = anRQObject.getTargetDate();
			String Status = anRQObject.getRequestStatus();
			
			output += String.format("%-5s %-20s %-10s %-18s %-10s\n", ID, RenovName, RenovType, Date, Status);
		}
		
		return output;
	}
	// Comment
	public static void deleteReqForQuote(Account account) {
		
		String searchRQN = Helper.readString("Enter Request Name To Delete: ");
		int deleteIndex = -1;
		for (int i = 0; i < account.RQlist.size(); i ++) {
			if (account.RQlist.get(i).getRequestName().equals(searchRQN)) {
				deleteIndex = i;
				break;
			}
		}
		
		if (deleteIndex != -1) {
			account.RQlist.remove(deleteIndex);
			System.out.println("Successfully Deleted!");
		}
		else {
			System.out.println("No Such Request Name Exists");
		}
		
	}
	
	public static Account addUser(String name, String role, String email, String password, String status) {		
		
		Account newAccount = new Account(name,role,email,password,status);
		
		System.out.println("Account successfully added!");

		return newAccount;
		
	}
	
	public static String viewUser() {
		
		String output = String.format("%-10s %-11s %-25s %-25s %-10s\n","NAME","ROLE","E-MAIL","PASSWORD","STATUS");
		
		for (Account User : accountList ) {
			if (User.getRole().equals("Customer")) {
				output += String.format("%-10s %-11s %-25s %-25s %-10s\n", User.getName(), User.getRole(), User.getEmail(), User.getPassword(), User.getStatus());
			}
			
		}
		//System.out.println(output);
		
		return output;
		
	}
	
	public static boolean dodeleteUser(String delOption, ArrayList<Account> accountList ) {
		
		boolean isFound = false;
		
		for (int i = 0; i < accountList.size(); i++) {
			
			String Name = accountList.get(i).getName();
			if(delOption.equalsIgnoreCase(Name)) {
				accountList.remove(i);
				isFound = true;
			}
			
		}
		
		return isFound;
		
	}
	
	public static void deleteUser() {
		
		 //viewAccount(accountList);
   	 	String delOption = Helper.readString("Enter the name to delete : ");
   	 	Boolean isFound = dodeleteUser(delOption,accountList);
   	 
   	 	if (isFound == false) {
   	 		System.out.println("Name does not exist!");
   	 	}
   	 
   	 	else {
   	 		System.out.println("Name : " + delOption + " has been deleted!");
   	 	}
   	 
	
	}
	
	public static Appointment inputAppointment() { // code made by charmaine - 20028846
		
		String custName = Helper.readString("Enter Name > ");
		String date = Helper.readString("Enter Date-Of-Appointment > ");
		int time = Helper.readInt("Enter Time-of-Appointment > ");
		String designerName = Helper.readString("Enter Designer Name > ");
		String address = Helper.readString("Enter Address of premise > ");
		
		Appointment app = new Appointment(custName, date, time, designerName, address);
		return app;
			
	}
		
	public static void addAppointment(ArrayList<Appointment> appointmentList, Appointment app) { // code made by charmaine - 20028846
			
		appointmentList.add(app);
		System.out.println("Appointment has been added!");
			
	}
		
	public static String retrieveAllAppointments(ArrayList<Appointment> appointmentList) { // code made by charmaine - 20028846
			
		String output = "";
			
		for (int i = 0; i < appointmentList.size(); i++) {
			output += String.format("%-10s %-20s %-20s %-20s %-10s\n", appointmentList.get(i).getCustName(), appointmentList.get(i).getDate(), appointmentList.get(i).getTime(), 
					appointmentList.get(i).getDesignerName(), appointmentList.get(i).getAddress());
		}
		return output;
			
	}
		
	public static void viewAllAppointment(ArrayList<Appointment> appointmentList) { // code made by charmaine - 20028846
		C206_CaseStudy.setHeader("APPOINTMENT LIST");
		String output = String.format("%-10s %-20s %-20s %-20s %-10s\n", "Customer Name", "Date", "Time", "Designer's Name", "Address");
		output += retrieveAllAppointments(appointmentList);
		System.out.println(output);
			
	}
	
	public static Boolean doDeleteAppointment(String deleteApp, ArrayList<Appointment> appointmentList) { // code made by charmaine - 20028846
		
		Boolean isFound = false;
		
		for (int i = 0; i < appointmentList.size(); i++) { 
			String custName = appointmentList.get(i).getCustName();
			
			if (deleteApp.equalsIgnoreCase(custName)) {
				appointmentList.remove(i);
				isFound = true;
			}
		}
		return isFound;
	}
	
	public static void deleteAppointment() {
		
		String deleteApp = Helper.readString("Enter Your Name > ");
		Boolean isFound = doDeleteAppointment(deleteApp, appointmentList);
		
		if (isFound == false) {
			System.out.println("Name does not exist!");
		} else {
			System.out.println("Appointment has been deleted!");
		}
		
	}
	
}
