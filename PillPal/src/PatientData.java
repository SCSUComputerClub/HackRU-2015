import java.util.ArrayList;
public class PatientData {
	private String name = "";
	private double age;
	private double weight;
	private String sex = "";
	private ArrayList<MedicationData> medications = new ArrayList<>();
	
	public void addMedication(MedicationData medication) {
		medications.add(medication);
	}
	
	public ArrayList<MedicationData> getMedications() {
		return medications;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public void setAge(double age) {
		this.age = age;
	}
	
	public double getAge() {
		return age;
	}
	
	public void setWeight(double weight) {
		this.weight = weight;
	}
	
	public double getWeight(){
		return weight;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}
}
