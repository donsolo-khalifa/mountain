package mountain;

public class Resource {
	private int resourceNo, numOfUnits;
	private String resourceCode, resourceDesc;
	
	public Resource(int resourceNo, int numOfUnits, String resourceCode, String resourceDesc) {
		super();
		this.resourceNo = resourceNo;
		this.numOfUnits = numOfUnits;
		this.resourceCode = resourceCode;
		this.resourceDesc = resourceDesc;
	}
	
	public Resource() {
		
	}

	public int getResourceNo() {
		return resourceNo;
	}

	public void setResourceNo(int resourceNo) {
		this.resourceNo = resourceNo;
	}

	public int getNumOfUnits() {
		return numOfUnits;
	}

	public void setNumOfUnits(int numOfUnits) {
		this.numOfUnits = numOfUnits;
	}

	public String getResourceCode() {
		return resourceCode;
	}

	public void setResourceCode(String resourceCode) {
		this.resourceCode = resourceCode;
	}

	public String getResourceDesc() {
		return resourceDesc;
	}

	public void setResourceDesc(String resourceDesc) {
		this.resourceDesc = resourceDesc;
	}
	
	
}
