package c03.association;

public class StudentBody {
	public static void main(String[] args) {
		Address ad = new Address("12 Nguyen Van Bao", "HCM", "VN", 12345);
		System.out.println(ad);
		
		Student st = new Student("Nguyen","Van An", new Address("12 Nguyen Van Bao", "HCM", "VN", 12345), new Address("Le Van Bao","HCM", "VN", 10000));
		System.out.println(st);
	}
}
