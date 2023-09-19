/*
* Student.java
* A Student class
*/
public class Student {

	private String sID;
	private int grade;

	public Student() {
		sID = "";
		grade = -1;
	}

	public Student(String sID, int grade) {
		this.sID = sID;
		this.grade = grade;
	}
	
	public String getSID() {
		return sID;
	}

	public void setSID(String studentSID) {
		this.sID = studentSID;
	}
	
	public int getGrade() {
		return grade;
	}

	public void setGrade(int studentGrade) {
		this.grade = studentGrade;
	}

	public String toString() {
		return "sID: " + sID + " & grade: " + grade;

	}

}
