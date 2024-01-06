package mountain;

public class Incident {
	private int incidentNo, reporterNo;
	private String date, time, words, incidentDet, ongoing;
	public Incident(int incidentNo, int reporterNo, String date, String time, String words, String incidentDet,
			String ongoing) {
		super();
		this.incidentNo = incidentNo;
		this.reporterNo = reporterNo;
		this.date = date;
		this.time = time;
		this.words = words;
		this.incidentDet = incidentDet;
		this.ongoing = ongoing;
	}
	
	public Incident() {
		
	}

	public int getIncidentNo() {
		return incidentNo;
	}

	public void setIncidentNo(int incidentNo) {
		this.incidentNo = incidentNo;
	}

	public int getReporterNo() {
		return reporterNo;
	}

	public void setReporterNo(int reporterNo) {
		this.reporterNo = reporterNo;
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

	public String getWords() {
		return words;
	}

	public void setWords(String words) {
		this.words = words;
	}

	public String getIncidentDet() {
		return incidentDet;
	}

	public void setIncidentDet(String incidentDet) {
		this.incidentDet = incidentDet;
	}

	public String getOngoing() {
		return ongoing;
	}

	public void setOngoing(String ongoing) {
		this.ongoing = ongoing;
	}
	
}
