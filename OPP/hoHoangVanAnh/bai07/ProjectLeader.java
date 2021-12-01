package hoHoangVanAnh.bai07;

public class ProjectLeader extends Programmer {

	public ProjectLeader(int thePayrollNumber, 
			String theName, double theBasicMounthlySalary, String theLanguage) {
		super(thePayrollNumber, theName, theBasicMounthlySalary, theLanguage);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public double getMonthlySalary() {
		// TODO Auto-generated method stub
		return theBasicMounthlySalary + (theBasicMounthlySalary*0.2);
	}
}

