public class Appointment {
	
	private String custName;
	private String date;
	private int time; // time will be in 24 hour
	private String designerName;
	private String address;
	
	public Appointment(String custName, String date, int time, String designerName, String address) {
		this.custName = custName;
		this.date = date;
		this.time = time;
		this.designerName = designerName;
		this.address = address;
		
	}
	
	public String getCustName() {
		return custName;
	}
	
	public void setCustName(String custName) {
		this.custName = custName;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}

	public String getDesignerName() {
		return designerName;
	}

	public void setDesignerName(String designerName) {
		this.designerName = designerName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
}