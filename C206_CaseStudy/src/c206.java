import java.util.ArrayList;


public class c206 {

	public static void main(String[] args) {
		
		ArrayList<Package> PackageList = new ArrayList<Package>();
		
		int option = -1;
		
		while(option != 4)
		{
			menu();
			option = Helper.readInt("Enter an option: ");
			
			if(option == 1)
			{
				
				String output = String.format("%-10s %-30s %-20s %-20s %-15s\n", "CODE", "DESCRIPTION", "START-DATE", "END-DATE", "AMOUNT");
				for(Package i : PackageList) {
					output+= String.format("%-10s %-30s %-20s %-20s %-15d\n", i.getCode(), i.getDescription(), i.getStartDate(), i.getEndDate(), i.getAmount());
				}
				System.out.println(output);
			}else if(option == 2) {
				String code = Helper.readString("Enter a code: ");
				String description = Helper.readString("Enter a Description: ");
				String startdate = Helper.readString("Enter a start date (xx/xx/xxxx): ");
				String enddate = Helper.readString("Enter a end date (xx/xx/xxxx): ");
				int amount = Helper.readInt("Enter the package amount: $" );
				
				PackageList.add(new Package(code,description,startdate,enddate,amount));
				}else if(option == 3) {
					String deletecode = Helper.readString("Enter package code: ");
					
					for(int i = 0; i < PackageList.size(); i++) {
							if(PackageList.get(i).getCode().matches(deletecode)) {
								PackageList.remove(i);
								System.out.println("Package successfully deleted!");
						}else {
							System.out.println("Package code not found");
						}
					}
				}
		}
		
		
		
	}

	private static void menu() {
		Helper.line(30,"-");
		System.out.println("WELCOME TO ADMIN PACKAGE MANAGEMENT!");
		Helper.line(30,"-");
		System.out.println("1.View All Packages");
		System.out.println("2.Add a Package");
		System.out.println("3.Delete a Package");
		System.out.println("4.Quit");
		
	}
	
		

	
}
