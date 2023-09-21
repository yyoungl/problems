import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class Solution {
	static int[] people;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for( int test_case=1; test_case<=T; test_case++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			HashSet<Integer> crowd = new HashSet<>();
			
			people = new int[N+1];
			
			for (int i=1; i<=N; i++) {
				people[i] = i;
				
			}
			
			for (int i=0; i<M; i++) {
				int x = sc.nextInt();
				int y = sc.nextInt();
				union(x, y);
			}
			
			for (int i=1; i<=N; i++) {
				crowd.add(find(i));
			}
			System.out.println("#"+test_case+" "+crowd.size());
		}
	}
	
	static void union(int x, int y) {
		people[find(y)] = find(x);
	}
	
	static int find(int x) {
		if (people[x] == x) return x;
		else return people[x] = find(people[x]);
	}

}
