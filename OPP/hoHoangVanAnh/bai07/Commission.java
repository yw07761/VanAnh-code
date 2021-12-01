package hoHoangVanAnh.bai07;

import java.text.DecimalFormat;

public class Commission extends Employee {
	private double grossSales;
	private double commissionRate;
	
	public Commission(String firstName, String lastName, String socialSecurityNumber, double grossSales,
			double commissionRate) {
		super(firstName, lastName, socialSecurityNumber);
		setGrossSales(grossSales);
		setCommissionRate(commissionRate);
	}

	public Commission() {
		this("un-known", "un-known", "un-known",0,0);
	}

	

	public double getGrossSales() {
		return grossSales;
	}

	public void setGrossSales(double grossSales) {
		this.grossSales = grossSales;
	}

	public double getCommissionRate() {
		return commissionRate;
	}

	public void setCommissionRate(double commissionRate) {
		this.commissionRate = commissionRate;
	}
	
	
	
	@Override
	public String toString() {
		DecimalFormat df = new DecimalFormat("#,###");
		 return String.format("commission employee: %s: gross sales%s:"
				+ "\n%s:commission rate nearned: $%s", super.toString(),
				df.format(grossSales),df.format(commissionRate),df.format(earnings()));
	}

	@Override
	public double earnings() {
		// TODO Auto-generated method stub
		return grossSales * commissionRate;
	}
	
}

