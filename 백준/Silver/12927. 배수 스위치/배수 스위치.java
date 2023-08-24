import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		int N = s.length();
		boolean[] light = new boolean[N+1];
		for (int i=0; i<N; i++) {
			if (s.charAt(i)=='Y') light[i+1] = true;
		}
		
		int cnt = 0;
		
		for (int i=1; i<=N; i++) {
			if (light[i]) {
				cnt++;
				int idx = i;
				while (idx < N+1) {
					light[idx] = !light[idx];
					idx+=i;
				}
			}
		}
		
		boolean isOkay = true;
		for (int i=1; i<=N; i++) {
			if (light[i]) {
				isOkay = false;
				break;
			}
		}
		
		if (isOkay) System.out.println(cnt);
		else System.out.println(-1);
		
		
	}

}
