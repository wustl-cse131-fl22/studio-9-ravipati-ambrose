package studio9;

import assignment7.Student;

import java.util.HashMap;
import java.util.Map;

public class UniversityDatabase {
	//TODO: Complete this class according to the studio instructions

	private Map<String,Student> map = new HashMap<String,Student>();
	
	public UniversityDatabase() {
		this.map = map;
	}
	
	public void addStudent(String accountName, Student student) {
		map.put(accountName,student);
	}

	public int getStudentCount() {
		return map.size();
	}

	public String lookupFullName(String accountName) {
		if (map.get(accountName)==null) {
			return null;
		}
		else {
			Student temp = map.get(accountName);
			return temp.getFullName();
		}
	}

	public double getTotalBearBucks() {
		double Bucks = 0.0;
		for (String key : map.keySet()) {
            Bucks += map.get(key).getBearBucksBalance();
		}
		return Bucks;
	}
}
