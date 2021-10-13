package hoHoangVanAnh.bai06;

public class TestAccount {
	 public static void main(String[] args) {
	        Account acc1 = new Account(72354,"Ted Murphy",102.56);
	        Account acc2 = new Account(69713,"Jane Smith",40.00);
	        Account acc3 = new Account(93757,"Edward Demsey", 759.32);

	        acc1.deposit(25.85);
	        acc2.deposit(500);
	        acc2.withdraw(430.75, 1.5);
	        acc3.addInterest();
	        System.out.println(String.format("%-15s %-15s %-15s %-15s",
	                "AccuontNumber","Name","Balence","RATE"));
	        System.out.println(acc1);
	        System.out.println(acc2);
	        System.out.println(acc3);
	        System.out.println("Thông tin mới");
	        System.out.println(String.format("%-15s %-15s %-15s %-15s",
	                "AccuontNumber","Name","Balence","RATE"));
	        acc2.transfer(acc1, 100.00);
	        System.out.println(acc1);
	        System.out.println(acc2);
	        System.out.println(acc3);
	    }
}
