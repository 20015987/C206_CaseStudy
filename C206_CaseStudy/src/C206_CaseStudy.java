import java.util.ArrayList;

public class C206_CaseStudy {
	
	// Instantiate ArrayLists
	
	private static ArrayList<Account> accountList = new ArrayList<Account>();
	private static ArrayList<requestQuotation> requestQuotationList = new ArrayList<requestQuotation>();
	private static Account currentLoginAccount = null;
	
	public static void main(String[] args) {
		
		// Test Data
		
		Account account1 = new Account("Ammar", "Customer", "ammar@jimmy.com", "Republ!c01", "new");
		accountList.add(account1);
		
		// Login Account
		
		while (currentLoginAccount == null) {
			currentLoginAccount = loginAccount();
		}
		
		// Check Role Of Account
		
		if (currentLoginAccount.getRole().equals("Customer")) {
			
			int customerOption = 0;
			
			while (customerOption != 3) {
				
				// Show Menu
				showCustomerMenu();
				
				// Prompt Customer
				customerOption = Helper.readInt("Option: ");
				
				switch(customerOption) {
				case 1:
					int manageRFQOption = 0;
					
					while (manageRFQOption != 4) {
						
						// Show Manage Request For Quotation Menu
						showManageRFQMenu();
						
						// Prompt Customer
						manageRFQOption = Helper.readInt("Option: ");
						
						// Switch Case
						
						switch(manageRFQOption) {
						case 1:
							// Add RQF
							break;
						case 2:
							// View RQF
							break;
						case 3:
							// Delete RFQ
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
					// Log out
					break;
				default:
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
						manageCustomerOption = Helper.readInt("Enter the option");
					switch(manageCustomerOption) {
					
					
					case 1:
						// Add 
						break;
					case 2:
						// View 
						break;
					case 3:
						// Delete 
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
		
		// Goodbye message
		System.out.println("Thank you for using Renovation Ace");
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
		System.out.println("WELCOME TO RENOVATION ACE");
		Helper.line(60, "=");
		
		System.out.println("1. Manage Request For Quotation\n"
						 + "2. Manage Appointment\n"
						 + "3. Log out");
	}
	
	public static void showAdministratorMenu() {
		
		// Write Menu + Options
		
		Helper.line(60, "=");
		System.out.println("WELCOME TO RENOVATION ACE");
		Helper.line(60, "=");
		
		System.out.println("1. Manage Customer\n"
						 + "2. Manage Package\n"
						 + "3. Manage Request For Quotation\n"
						 + "4. Manage Quotation\n"
						 + "5. Manage Appointment\n"
						 + "6. Log out");
	}
	
	// Add your methods here
	
	public static void showManageRFQMenu() {
		Helper.line(60, "-");
		System.out.println("Manage Request For Quotation");
		Helper.line(60, "-");
		
		System.out.println("1. Add Request For Quotation\n"
						 + "2. View Request For Quotation\n"
						 + "3. Delete Request For Quotation\n"
						 + "4. Exit");
		
		
	}
	
	public static Account loginAccount() {
		
		Helper.line(60, "=");
		System.out.println("WELCOME TO RENOVATION ACE");
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
	
	public static void addUser() {
		
		
	}
	
	public static requestQuotation addReqForQuote() {
		
	}
	
}