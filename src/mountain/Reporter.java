package mountain;

public class Reporter {
	private String name, date, time, adrress, postCode;
	private int reportNo, telNo;

	public Reporter(String name, String date, String time, String adrress, String postCode, int reportNo, int telNo) {
		super();
		this.name = name;
		this.date = date;
		this.time = time;
		this.adrress = adrress;
		this.postCode = postCode;
		this.reportNo = reportNo;
		this.telNo = telNo;
	}
	
	public Reporter() {
		
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getAdrress() {
		return adrress;
	}

	public void setAdrress(String adrress) {
		this.adrress = adrress;
	}

	public String getPostCode() {
		return postCode;
	}

	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}

	public int getReportNo() {
		return reportNo;
	}

	public void setReportNo(int reportNo) {
		this.reportNo = reportNo;
	}

	public int getTelNo() {
		return telNo;
	}

	public void setTelNo(int telNo) {
		this.telNo = telNo;
	}
}
