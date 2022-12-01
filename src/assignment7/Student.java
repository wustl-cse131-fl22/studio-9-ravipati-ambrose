package assignment7;

public class Student {
	
	private String firstName;
	private String lastName;
	private int studentId;
	private int attemptedCredits;
	private int passingCredits;
	private double totalGradeQualityPoints;
	private double BearBucksBalance;

	/**
	 * Constructor method, specific for unit test with just these variables
	 * @param firstName Students first name
	 * @param lastName Students last name
	 * @param studentId Student Id
	 */
	public Student(String firstName, String lastName, int studentId) { 
		this.firstName = firstName;
		this.lastName = lastName;
		this.studentId = studentId;
	}
	/**
	 * Constructor method for remaining variables
	 * @param attemptedCredits Students attempted credits
	 * @param passingCredits Students passing credits
	 * @param totalGradeQualityPoints Total grade quality points
	 * @param BearBucksBalance Students bear bucks balance
	 */
	public Student(int attemptedCredits, int passingCredits, double totalGradeQualityPoints, double BearBucksBalance) { 
		this.attemptedCredits = attemptedCredits;
		this.passingCredits = passingCredits;
		this.totalGradeQualityPoints = totalGradeQualityPoints;
		this.BearBucksBalance = BearBucksBalance;
	}

	/**
	 * Method concentating string of student's name
	 * @return String of students name
	 */
	public String getFullName () { 
		return firstName + " " + lastName;
	}
	/**
	 * Getter method for student id
	 * @return Student Id
	 */
	public int getId() { 
		return studentId;
	}
	/**
	 * Getter method for total attempted credits
	 * @return Total attempted credits
	 */
	public int getTotalAttemptedCredits() { 
		return attemptedCredits;
	}
	/**
	 * Getter method for total passing credits
	 * @return Total passing credits
	 */
	public int getPassingCredits() {
		return passingCredits;
	}
	/**
	 * Calculating GPA using total quality points and attempted credits
	 * @return GPA average
	 */
	public double calculateGradePointAverage() {
		return (totalGradeQualityPoints/attemptedCredits);
	}
	
	/**
	 *  Calculate grade quality points
	 * @param grade Grade for specific course
	 * @param credits Credits for specific course
	 */
	public void submitGrade(double grade, int credits) {
		totalGradeQualityPoints = totalGradeQualityPoints + (grade*credits);
		attemptedCredits = attemptedCredits + credits;
		if (grade > 1.7) {
			passingCredits = passingCredits + credits;
		}
	}
	/**
	 *  Getter method for class standing
	 * @return Specific standing based on passing credits
	 */
	public String getClassStanding() {
		if (passingCredits < 30) {
			return "First Year";
		}
		else {
			if (passingCredits < 60) {
				return "Sophomore";
			}
			else {
			if (passingCredits < 90) {
				return "Junior";
			}
			else {
				return "Senior";
			}
		}
	}
	}
	/**
	 * Getter method for PBK
	 * @return If student is eligible for phi beta kappa
	 */
	public boolean isEligibleForPhiBetaKappa() { 
		if (calculateGradePointAverage() >= 3.60 && attemptedCredits >= 98 || calculateGradePointAverage() >= 3.80 && attemptedCredits >= 75) {
			return true;
		}
		else {
			return false;
		}
	}
	/**
	 * Deposit bear bucks
	 * @param amount Bear bucks balance
	 */
	public void depositBearBucks(double amount) { 
		BearBucksBalance = BearBucksBalance + amount;
	}
	/**
	 * Deduct bear bucks
	 * @param amount Bear bucks balance
	 */
	public void deductBearBucks(double amount) { 
		BearBucksBalance = BearBucksBalance - amount;
	}
	/**
	 * Getter method for bear bucks
	 * @return Bear bucks balance
	 */
	public double getBearBucksBalance() { 
		return BearBucksBalance;
	}
	/**
	 * Cash out method
	 * @return
	 */
	public double cashOutBearBucks() {
		if (BearBucksBalance < 10) {
			BearBucksBalance = 0;
			return BearBucksBalance;
		}
		else {
			double temp = BearBucksBalance - 10;
			BearBucksBalance = 0;
			return temp;
		}
	}
	/** 
	 * Creating a legacy student
	 * @param firstName Students first name
	 * @param other Other parent
	 * @param isHyphenated If last name should be hyphenated
	 * @param id Student Id number
	 * @return
	 */
	public Student createLegacy(String firstName, Student other, boolean isHyphenated, int id) { 
		if (isHyphenated == true) { 
			Student legacy = new Student(firstName,this.lastName + "-" + other.lastName,studentId); 
			legacy.depositBearBucks(this.cashOutBearBucks() + other.cashOutBearBucks());
			return legacy;
		}
		else {
			Student legacy = new Student(firstName,lastName,studentId); 
			legacy.depositBearBucks(this.cashOutBearBucks() + other.cashOutBearBucks());
			return legacy;
		}
	}
	
	/**
	 * Concentating string of full name and student id
	 */
	public String toString() { 
		return firstName + " " + lastName + ", " + studentId;
	}
}