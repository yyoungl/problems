import java.util.Scanner;
import java.util.Arrays;

public class Main {
	static int N;
	static int[] homes;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		int C = sc.nextInt();
		// 10억??
		homes = new int[N];
		for (int i=0; i<N; i++)
			homes[i] = sc.nextInt();
		Arrays.sort(homes);
		int low = 1;
		int high = homes[N-1] - homes[0] + 1;
		
		
		while (low < high) {
			int mid = (high + low)/2;
			if (binary(mid) < C) high = mid;
			else low = mid+1;
		}
		
		System.out.println(low-1);
		
	}
	
	public static int binary(int mid) {
		int cnt = 1;
		int last = homes[0];
		
		for (int i=1; i<N; i++) {
            int temp = homes[i];
			if (temp - last >= mid) {
				cnt++;
				last = homes[i];
			}
		}
		
		return cnt;
	} 

}
