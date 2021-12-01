package hoHoangVanAnh.bai07;

import java.text.NumberFormat;
import java.util.Locale;

public class Administrator extends Employee {
	private String theDepartment;

    public Administrator(int thePayrollNumber, String theName, double theBasicMounthlySalary, String theDepartment) {
        super(thePayrollNumber, theName, theBasicMounthlySalary);
        setTheDepartment(theDepartment);
    }
    

    public String getTheDepartment() {
        return theDepartment;
    }


    public void setTheDepartment(String theDepartment) {
        if (!theDepartment.trim().equals("")) 
            this.theDepartment = theDepartment;
        else
            this.theDepartment = "un-known";
    }

 
    @Override
    public String toString() {
        Locale locale = new Locale("en", "US");      
        NumberFormat currency = NumberFormat.getCurrencyInstance(locale);
        return String.format("%-20d %-30s %-20s %20s %20s",thePayrollNumber,
        		theName,currency.format(theBasicMounthlySalary),theDepartment, 
        		currency.format(getMonthlySalary()));
    }
    
    public static String getTieuDe() {
            return String.format("%-20s %-18s %20s %15s %15s","Mã Nhân Viên",
            		"Tên Nhân Viên","Lương Cơ Bản","Cục quản lý", "Tiền Lương");
    }


	@Override
	public double getMonthlySalary() {
		// TODO Auto-generated method stub
		return theBasicMounthlySalary + (theBasicMounthlySalary*0.4);
	}

}

