package book;


public class Test {
	public static void main (String[] args) {
		Author a = new Author ("Nguyen Van An","an@gmail.com",'M');
		System.out.println(a);
		
		Book b = new Book("LT HDT", a, 1000000, 10);
		System.out.println(b);
	}
}