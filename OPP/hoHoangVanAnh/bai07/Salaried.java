package hoHoangVanAnh.bai07;

import java.text.DecimalFormat;

public class Salaried  extends Employee{
	private double weeklySalary;

	
	
	public Salaried(String firstName, String lastName, String socialSecurityNumber, double weeklySalary) {
		super(firstName, lastName, socialSecurityNumber);
		setWeeklySalary(weeklySalary);
	}

	

	public Salaried() {
		this("un-known", "un-known", "un-known",0);
	}

	

	public double getWeeklySalary() {
		return weeklySalary;
	}



	public void setWeeklySalary(double weeklySalary) {
		if(weeklySalary  > 0)
			this.weeklySalary = weeklySalary;
		else 
			this.weeklySalary = 0;
	}

	

	@Override
	public String toString() {
		DecimalFormat df = new DecimalFormat("#,###");
		return String.format("salaried employee:%s weekly salary %s %s", 
				super.toString(), df.format(weeklySalary), df.format(earnings()));
	}


	@Override
	public double earnings() {
		// TODO Auto-generated method stub
		return weeklySalary;
	}
	
	
	
}