import java.util.Scanner;

public class Solution {
	static int cnt = 0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int test_case=1; test_case<=T; test_case++) {
			cnt = 0;
			int N = sc.nextInt();
			int[] points = new int[N];
			bt(0, N, points);
			System.out.println("#"+test_case+" "+cnt);
		}
	}
	
	static void bt(int r, int N, int[] points) {
		// bt (r+1, N,  ...);
		if(r == N) {
			cnt++;
			return;
		}
		for (int dc = 0; dc<N; dc++) {
			boolean check = true;
			for (int i=0; i<r; i++) { 
				if ( points[i]== dc || ((r-i) == Math.abs(points[i]-dc))) {
					check=false;
				}
			}
			if (check) {
				points[r] = dc;
				bt(r+1, N, points);
			}
			
		}
		
	}

}
