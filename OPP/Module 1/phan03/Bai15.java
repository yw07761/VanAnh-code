package hoHoangVanAnh.phan03;
/**
 * Viết chương trình in ra giá trị lớn nhất và nhỏ nhất trong một dãy các giá trị user đã nhập.
 */
import java.util.InputMismatchException;
import java.util.Scanner;
public class Bai15 {
	private static Scanner scanner = new Scanner(System.in);
	public static void main(String args[]){
		try {
			System.out.print("Nhap vao so luong phan tu: ");
	        int n = scanner.nextInt();
	        int[] arr = new int[n];
	        System.out.print("Nhap cac phan tu trong mang: \n");
	        for (int i = 0; i < n; i++) {
	            System.out.printf("a[%d] = ", i);
	            arr[i] = scanner.nextInt();
		  	}
		  	System.out.println("");
		  	System.out.println("Min  = " +Min(arr));
		  	System.out.println("Max  = " +Max(arr));
		} catch (InputMismatchException e) {
			System.out.println("Khong nhap chu cai !");
	       }		
	 }
	public static int Min(int arr[]){
		int min = arr[0];
		for(int i =0 ;i<arr.length;i++){
			if(min > arr[i]){
				min = arr[i];
			}
		}
		return min;
	 }
	public static int Max(int arr[]){
		int max = arr[0];
		for(int i =0 ;i<arr.length;i++){
			if(max < arr[i]){
				max = arr[i];
			}
		}
	  return max;
	 }
}	 