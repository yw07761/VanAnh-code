package hoHoangVanAnh.phan03;
import java.util.InputMismatchException;
import java.util.Scanner;
/**
 * Tính tổng các số nguyên tố nhỏ hơn N 
 */
public class Bai07 {
    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
    	try {
    		System.out.print("Nhap n = ");
            int n = scanner.nextInt();
            if(n>0)
            {
            	if(isPrimeNumber(n)==1) {
            		System.out.println(n+ " la so nguyen to");
            		System.out.printf("Tong cua cac so nguyen to nho hon " + n + " = " +TinhTong(n) );
            	}            		
            	else
            		System.out.println(n+ " khong la so nguyen to vui long nhap so khac ! ");
            }
            
		} catch (InputMismatchException e) {
			System.out.println("khong nhap chu cai !");
			}         
    	}
     
    /**
     * check so nguyen to
     * @param n: so nguyen duong
     * @return true la so nguyen so, 
     *         false khong la so nguyen to
     */
    public static int isPrimeNumber(int n) {
       int dem =0;
       for(int i=1;i<=n;i++)
       {
    	   if(n%i==0)
    		   dem++;
       }
       if(dem ==2)
    	   return 1;
       else return 0;
    }
	public static int TinhTong(int n){
	  int s =0 ;
	  for (int i=1; i<n; i++)
	        if (isPrimeNumber(i) == 1)
	            s+=i;
	    return s;
	 }    
}