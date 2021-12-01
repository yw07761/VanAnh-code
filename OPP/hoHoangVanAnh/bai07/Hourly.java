package hoHoangVanAnh.bai07;

import java.text.DecimalFormat;

public class Hourly extends Employee {
	private double wage;
	private double hours;
	
	
	
	public Hourly(String firstName, String lastName, String socialSecurityNumber, double wage, double hours) {
		super(firstName, lastName, socialSecurityNumber);
		setWage(wage);
		setHours(hours);
	}
	
	public Hourly() {
		this("un-known", "un-known", "un-known",0,0);
	}

	
	

	public double getWage() {
		return wage;
	}

	public void setWage(double wage) {
		this.wage = wage;
	}


	public double getHours() {
		return hours;
	}


	public void setHours(double hours) {
		this.hours = hours;
	}


	@Override
	public String toString() {
		DecimalFormat df = new DecimalFormat("#,###");
		return String.format("hourly employee:%s hourly wage: %s ;nearned: %s hours worked, %s ",super.toString(),
				df.format(wage),df.format(hours),df.format(earnings()));
	}
	
	@Override
	public double earnings() {
		if (hours <= 40) // no overtime
			return wage * hours;
		else
			return 40 * wage + (hours - 40 ) * wage * 1.5;
	}

}

