import java.util.Scanner;
public class Main {
	static int cnt = 0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] points = new int[N];
		bt(0, N, points);
		System.out.println(cnt);
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
