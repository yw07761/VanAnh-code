package hoHoangVanAnh.bai07;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Objects;

public abstract class Employee {
	 protected int thePayrollNumber; //Mã số
	 protected String theName; //Tên Nhân Viên
	 protected double theBasicMounthlySalary; // Lương Cơ Bản
	 
	 /**
	  * hàm khởi tạo 
	  * @param thePayrollNumber
	  * @param theName
	  * @param theBasicMounthlySalary
	  */
	public Employee(int thePayrollNumber, String theName, double theBasicMounthlySalary) {
		setThePayrollNumber(thePayrollNumber);
		setTheName(theName);
		setTheBasicMounthlySalary(theBasicMounthlySalary);
	}

	public Employee() {
		this(0,"xxx",0);
	}

	public int getThePayrollNumber() {
		return thePayrollNumber;
	}
	/**
	 * ktr Mã số > 0
	 * @param thePayrollNumber
	 */
	public void setThePayrollNumber(int thePayrollNumber) {
		if(thePayrollNumber > 0)
			this.thePayrollNumber = thePayrollNumber;
		else
			this.thePayrollNumber = 0;
	}

	public String getTheName() {
		return theName;
	}
	/**
	 * ktr tên có rỗng hay không
	 * @param theName
	 */
	public void setTheName(String theName) {
		if(!theName.equals(""))
			this.theName = theName;
		else
			this.theName = "xxx";
	}

	public double getTheBasicMounthlySalary() {
		return theBasicMounthlySalary;
	}
	/**
	 * ktr lương cơ bản  > 0
	 * @param theBasicMounthlySalary
	 */
	public void setTheBasicMounthlySalary(double theBasicMounthlySalary) {
		if(theBasicMounthlySalary > 0)
			this.theBasicMounthlySalary = theBasicMounthlySalary;
		else
			this.theBasicMounthlySalary = 0;
	}
	
	public abstract double getMonthlySalary();
	
	@Override
	public String toString() {
		Locale locale = new Locale("en", "US");      
        NumberFormat currency = NumberFormat.getCurrencyInstance(locale);
        return String.format("%-20d %-30s %10s",thePayrollNumber,theName,
        		currency.format(theBasicMounthlySalary));
	}
	public static String getTieuDe() {
        return String.format("%-20s %-18s %20s\n","Mã NV","Tên NV","Lương CB");    
    }

	@Override
	public int hashCode() {
		return Objects.hash(theBasicMounthlySalary);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		return Double.doubleToLongBits(theBasicMounthlySalary) == Double.doubleToLongBits(other.theBasicMounthlySalary);
	}

	public double getMounthSalary() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
	
	
	
	
	 
	
}

