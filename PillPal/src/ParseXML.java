import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;
public class ParseXML {
	public static void main(String args[]) {
		File myFile = new File("C:/Users/Kyle/Downloads/data.xml");
		Scanner readFile;
		String line;
		PatientData patient = new PatientData();
		try {
			readFile = new Scanner(myFile);
			while(readFile.hasNext() != false) {
				line = readFile.nextLine();
				if(line.contains("Patient ")) patient.setName(line.substring(line.indexOf('"')+1,line.lastIndexOf('"')));
				if(line.contains("<Age>")) patient.setAge(Integer.parseInt(line.replaceAll("[^0-9]", "")));
				if(line.contains("<Weight>")) patient.setWeight(Double.parseDouble(line.replaceAll("[^0-9.]", "")));
				if(line.contains("<Sex>")) patient.setSex(line.substring(line.indexOf('"')+1, line.lastIndexOf('"')));
				if(line.contains("<Medication ")) {
					MedicationData medication = new MedicationData();
					medication.setDrugName(line.substring(line.indexOf('"')+1,line.lastIndexOf('"')));
					line = readFile.nextLine();
					medication.setIssuingDoctor(line.substring(line.indexOf('"')+1,line.lastIndexOf('"')));
					line = readFile.nextLine();
					medication.setNumberOfPills(Integer.parseInt(line.replaceAll("[^0-9]", "")));
					line = readFile.nextLine();
					medication.setFrequency(Integer.parseInt(line.replaceAll("[^0-9]", "")));
					line = readFile.nextLine();
					medication.setDirections(line.substring(line.indexOf('"')+1,line.lastIndexOf('"')));
					line = readFile.nextLine();
					medication.setConflictingDrugs(line.substring(line.indexOf('"')+1,line.lastIndexOf('"')));
					line = readFile.nextLine();
					medication.setSideEffects(line.substring(line.indexOf('"')+1,line.lastIndexOf('"')));
					patient.addMedication(medication);
				}
			}
		} catch (FileNotFoundException e) {
			System.out.println(e);
		}
		System.out.println(patient.getName());
		System.out.println(patient.getAge());
		System.out.println(patient.getWeight());
		System.out.println(patient.getSex());
		ArrayList<MedicationData> medicationsList = patient.getMedications();
		System.out.println(medicationsList.isEmpty());
		for(MedicationData medication:medicationsList) {
			System.out.println(medication.getDrugName());
			System.out.println(medication.getIssuingDoctor());
			System.out.println(medication.getNumberOfPills());
			System.out.println(medication.getFrequency());
			System.out.println(medication.getDirections());
			System.out.println(medication.getConflictingDrugs());
			System.out.println(medication.getSideEffects());
		}
	}
}
