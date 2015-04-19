import com.mongodb.MongoClient;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.util.JSON;

import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class PatientReader {
	public static void main(String args[]) {
		try {
			MongoClient mongoClient = new MongoClient("45.55.140.167");
			@SuppressWarnings("deprecation")
			DB database = mongoClient.getDB("pill_pal");
			DBCollection coll = database.getCollection("patient_information");
			DBCursor cursor = coll.find();
			String line = "";
			PatientData patient = new PatientData();
			
			JSONParser jsonParser = new JSONParser();
			JSONObject jsonObject;
			try {
				while(cursor.hasNext()) {
					line = JSON.serialize(cursor.next());
					jsonObject = (JSONObject) jsonParser.parse(line);
					patient.setName((String) jsonObject.get("name"));
					patient.setAge((double) jsonObject.get("age"));
					patient.setWeight((double) jsonObject.get("weight"));
					patient.setSex((String) jsonObject.get("Sex"));
					
					JSONArray prescriptions = (JSONArray) jsonObject.get("Prescriptions");
					Iterator<?> i = prescriptions.iterator();
					while(i.hasNext()) {
						JSONObject innerObject = (JSONObject) i.next();
						MedicationData medication = new MedicationData();
						medication.setDrugName((String) innerObject.get("Drug Name"));
						medication.setIssuingDoctor((String) innerObject.get("Issuing Doctor"));
						medication.setIssuingDate((String) innerObject.get("Issuing Date"));
						medication.setNumberOfPills((double) innerObject.get("NumberOfPills"));
						medication.setFrequency((double) innerObject.get("Frequency"));
						medication.setDirections((String) innerObject.get("Directions"));
						medication.setConflictingDrugs((String) innerObject.get("Conflicting_Drugs"));
						medication.setSideEffects((String) innerObject.get("Common Side Effects"));
						medication.setPersonalSideEffects((String) innerObject.get("Personal Side Effects"));
						patient.addMedication(medication);
					}
				}
			}
			catch (ParseException e) {
	            System.out.println(e);
			}
			finally {
				cursor.close();
				mongoClient.close();
			}
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
}
