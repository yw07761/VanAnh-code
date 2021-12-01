package hoHoangVanAnh.bai07;


import java.text.NumberFormat;
import java.util.Locale;

public class Programmer extends Employee {
	
	protected String theLanguage;

    public Programmer(int thePayrollNumber, String theName, double theBasicMounthlySalary, String theLanguage) {
        super(thePayrollNumber, theName, theBasicMounthlySalary);
        this.theLanguage = theLanguage;
    }
    
    
    public String getTheLanguage() {
        return theLanguage;
    }


    public void setTheLanguage(String theLanguage) {
        if (!theLanguage.trim().equals(""))
            this.theLanguage = theLanguage;
        else
            this.theLanguage = "un-known";
    }

   
    @Override
    public String toString() {
        Locale locale = new Locale("en", "US");      
        NumberFormat currency = NumberFormat.getCurrencyInstance(locale);
        return String.format("%-20d %-30s %10s %20s %20s",
        		thePayrollNumber,theName,currency.format(theBasicMounthlySalary),
        		theLanguage,currency.format(getMounthSalary()));
    }
    public static String getTieuDe() {
        return String.format("%-20s %-30s %20s %15s %15s",
        		"Mã Nhân Viên","Tên Nhân Viên","Lương Cơ Bản","Ngôn Ngữ","Tiền Lương");
    }
        

	@Override
	public double getMonthlySalary() {
		// TODO Auto-generated method stub
		  if (theLanguage == "Java") 
	            return theBasicMounthlySalary + (0.2*theBasicMounthlySalary);
	        else
	            return theBasicMounthlySalary;
	        }
	}

