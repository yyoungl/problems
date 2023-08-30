import java.util.ArrayList;
import java.util.Scanner;

class Hamburger {
	int t;
	int k;
	
	public Hamburger(int t, int k) {
		super();
		this.t = t;
		this.k = k;
	}
	
}
public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int test_case=1; test_case<=T; test_case++) {
			int N = sc.nextInt();
			int L = sc.nextInt();
			Hamburger[] list = new Hamburger[N];
			
			for (int i=0; i<N; i++) {
				int t = sc.nextInt();
				int k = sc.nextInt();
				list[i] = new Hamburger(t, k);
			}
			
			int tSum = 0;
			
			for (int i=1; i<(1<<N); i++) {
				ArrayList<Hamburger> result = new ArrayList<>();
				for (int j=0; j<N; j++) {
					if ((i&(1<<j)) > 0) {
						result.add(list[j]);
					}
				}
				int tempT = 0;
				int tempK = 0;
				int size  = result.size();
				for (int k=0; k < size; k++) {
					tempK += result.get(k).k;
					tempT += result.get(k).t;
				}
				if (tempK <= L) tSum = Math.max(tempT, tSum);
				
			}
			System.out.println("#"+test_case+" "+tSum);
			
		}
	}

}
