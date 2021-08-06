
public class Package {
	
	private String code;
	private String description;
	private String startDate;
	private String endDate;
	private int amount;
	
	public Package(String code, String description, String startDate, String endDate, int amount) {
		this.code = code;
		this.description = description;
		this.startDate = startDate;
		this.endDate = endDate;
		this.amount = amount;
	}

	public String getCode() {
		return code;
	}

	public String getDescription() {
		return description;
	}

	public String getStartDate() {
		return startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public int getAmount() {
		return amount;
	}

}
