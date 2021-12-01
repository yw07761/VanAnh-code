package hoHoangVanAnh.bai07;

import java.text.DecimalFormat;

public class BasePlusCommission extends Commission {
	private double baseSalary;
	
	
	
	public BasePlusCommission(String firstName, String lastName, String socialSecurityNumber, double grossSales,
			double commissionRate, double baseSalary) {
		super(firstName, lastName, socialSecurityNumber, grossSales, commissionRate);
		setBaseSalary(baseSalary);
	}
	
	public BasePlusCommission() {
		this("un-known", "un-known", "un-known",0,0,0);
	}


	public double getBaseSalary() {
		return baseSalary;
	}

	public void setBaseSalary(double baseSalary) {
		this.baseSalary = baseSalary;
	}


	@Override
	public double earnings() {
		// TODO Auto-generated method stub
		return  baseSalary + super.earnings();
	}

	@Override
	public String toString() {
		DecimalFormat df = new DecimalFormat("#,###");
		return String.format("\nbase-salaried %s;\nbase salary: $%s\nearned:%s",
				super.toString(), df.format(baseSalary),df.format(earnings()));
	}
	
	
}

