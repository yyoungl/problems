
import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr1 = new int[N];
		for (int i=0; i<N; i++) arr1[i] = sc.nextInt();
		Arrays.sort(arr1);
		int M = sc.nextInt();
		int[] arr2 = new int[M];
		for (int i=0; i<M; i++) {
			int find = sc.nextInt();
			System.out.println(binarysearch(arr1, find, N));
		}
		
		
		
	}
	
	static int binarysearch(int[] arr1, int find, int N) {
		int left = 0;
		int right = N-1;
		boolean chk = false;
		while (left <= right) {
			int mid = (left+right)/2;
			if (arr1[mid] == find) {
				return 1;
			}
			else if (arr1[mid] > find) {
				right = mid-1;
			} else {
				left = mid+1;
			}
		}
		return 0;
		
	}

}
