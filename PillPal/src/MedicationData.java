
public class MedicationData {
	private double numberOfPills = 0;
	private double frequency = 0;
	private String drugName = "";
	private String issuingDoctor = "";
	private String directions = "";
	private String conflictingDrugs = "";
	private String sideEffects = "";
	private String issuingDate = "";
	private String personalSideEffects = "";
	
	public double getNumberOfPills() {
		return numberOfPills;
	}
	public void setNumberOfPills(double numberOfPills) {
		this.numberOfPills = numberOfPills;
	}
	public double getFrequency() {
		return frequency;
	}
	public void setFrequency(double frequency) {
		this.frequency = frequency;
	}
	public String getDrugName() {
		return drugName;
	}
	public void setDrugName(String drugName) {
		this.drugName = drugName;
	}
	public String getIssuingDoctor() {
		return issuingDoctor;
	}
	public void setIssuingDoctor(String issueingDoctor) {
		this.issuingDoctor = issueingDoctor;
	}
	public String getDirections() {
		return directions;
	}
	public void setDirections(String directions) {
		this.directions = directions;
	}
	public String getConflictingDrugs() {
		return conflictingDrugs;
	}
	public void setConflictingDrugs(String conflictingDrugs) {
		this.conflictingDrugs = conflictingDrugs;
	}
	public String getSideEffects() {
		return sideEffects;
	}
	public void setSideEffects(String sideEffects) {
		this.sideEffects = sideEffects;
	}
	public String getIssuingDate() {
		return issuingDate;
	}
	public void setIssuingDate(String issuingDate) {
		this.issuingDate = issuingDate;
	}
	public String getPersonalSideEffects() {
		return personalSideEffects;
	}
	public void setPersonalSideEffects(String personalSideEffects) {
		this.personalSideEffects = personalSideEffects;
	}
	
	
}
