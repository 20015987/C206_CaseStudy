
public class requestQuotation {
	
	private String propertyType;
	private double areaSize;
	private String requestName;
	private int contactNumber;
	private String email;
	private double budget;
	private String targetDate;
	private String renovationType;
	private int numOfToilets;
	private int numOfRooms;
	private String requestStatus;
	private String requestID;
	
	public requestQuotation(String propertyType, double areaSize, String requestName, int contactNumber, String email,
			double budget, String targetDate, String renovationType, int numOfToilets, int numOfRooms,
			String requestStatus, String requestID) {
		this.propertyType = propertyType;
		this.areaSize = areaSize;
		this.requestName = requestName;
		this.contactNumber = contactNumber;
		this.email = email;
		this.budget = budget;
		this.targetDate = targetDate;
		this.renovationType = renovationType;
		this.numOfToilets = numOfToilets;
		this.numOfRooms = numOfRooms;
		this.requestStatus = requestStatus;
		this.requestID = requestID;
	}

	public String getPropertyType() {
		return propertyType;
	}

	public double getAreaSize() {
		return areaSize;
	}

	public String getRequestName() {
		return requestName;
	}

	public int getContactNumber() {
		return contactNumber;
	}

	public String getEmail() {
		return email;
	}

	public double getBudget() {
		return budget;
	}

	public String getTargetDate() {
		return targetDate;
	}

	public String getRenovationType() {
		return renovationType;
	}

	public int getNumOfToilets() {
		return numOfToilets;
	}

	public int getNumOfRooms() {
		return numOfRooms;
	}

	public String getRequestStatus() {
		return requestStatus;
	}
	
	public String getRequestID() {
		return requestID;
	}
	
}
