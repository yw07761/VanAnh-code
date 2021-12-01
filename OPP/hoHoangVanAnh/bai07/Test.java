package hoHoangVanAnh.bai07;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Salaried salariedEmployee = new Salaried( "John", "Smith", "111-11-1111", 2000); 
		Hourly hourlyEmployee = new Hourly( "Karen", "Price", "222-22-2222", 20, 40 );
		Commission commissionEmployee = 
				new Commission( "Sue", "Jones", "333-33-3333", 10000, .06 ); 
				BasePlusCommission basePlusCommissionEmployee = 
				new BasePlusCommission( "Bob", "Lewis", "444-44-4444", 5000, .04, 300 ); 
				
		System.out.println( "Employees processed individually:\n" );
			
		System.out.printf( "%s\n%s: $%,.2f\n\n",
		salariedEmployee, "earned", salariedEmployee.earnings() );
		System.out.printf( "%s\n%s: $%,.2f\n\n",
		hourlyEmployee, "earned", hourlyEmployee.earnings() );
		System.out.printf( "%s\n%s: $%,.2f\n\n",
		commissionEmployee, "earned", commissionEmployee.earnings() );
		System.out.printf( "%s\n%s: $%,.2f\n\n",
		basePlusCommissionEmployee,
				"earned", basePlusCommissionEmployee.earnings() );
			
		Employee employees[] = new Employee[ 4 ];
		 
		employees[ 0 ] = salariedEmployee; 
		employees[ 1 ] = hourlyEmployee; 
		employees[ 2 ] = commissionEmployee; 
		employees[ 3 ] = basePlusCommissionEmployee;
				
		System.out.println( "Employees processed polymorphically:\n" );
				
		for ( Employee currentEmployee : employees )
		{
			System.out.println( currentEmployee );
	
			if ( currentEmployee instanceof BasePlusCommission )
			{
				BasePlusCommission employee = ( BasePlusCommission ) currentEmployee;
	
				double oldBaseSalary = employee.getBaseSalary();
				employee.setBaseSalary(1.1 * oldBaseSalary);
				System.out.println("new base salary with 10% increase is: " + employee.getBaseSalary());
			}
			System.out.printf("earned $%,.2f\n\n", currentEmployee.earnings() );
		}
		
	}
	}


