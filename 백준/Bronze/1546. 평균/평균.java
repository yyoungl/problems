import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
			
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int[] arr = new int[N];
		double[] arr2 = new double[N];
		double max = 0;
		double sum = 0;
		
		for(int i = 0;i<arr.length;i++) {
			arr[i] = sc.nextInt();
			if(arr[i]>=max) {
				max = arr[i];
			}
		}
		for(int i = 0;i<arr.length;i++) {
			arr2[i] = arr[i]/max*100;
			sum += arr2[i];
		}
		System.out.println(sum/N);
	}
}