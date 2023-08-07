import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		

		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		int[] arr = new int[N];
		
		for(int m = 0;m<M;m++) {
			int i = sc.nextInt();
			int j = sc.nextInt();
			int k = sc.nextInt();
			for(int s=i-1;s<=j-1;s++) {
				arr[s] = k;
			}
		}
		for(int i = 0;i<arr.length;i++) {
			System.out.print(arr[i]+" ");
		}
	}
}