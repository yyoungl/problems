import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	static int[] set;
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int T = sc.nextInt();
		for(int test_case=1; test_case<=T; test_case++) {
			int n = sc.nextInt();
			int m = sc.nextInt(); // 연산의 개수
			
			set = new int[n+1];
			
			// 0 a b a, b 가 포함되어 있는 집합을 합친다는 이야기
			// 1 a b 같은 집합에 포함되어 있는지 확인하기 
			
			for (int i=1; i<=n; i++) {
				set[i] = i;
			}
			System.out.print("#"+test_case+" ");
			for (int command=0; command<m; command++) {
				int com = sc.nextInt();
				int x = sc.nextInt();
				int y = sc.nextInt();
				
				switch(com) {
				case 0:
					union(x, y);
					break;
				case 1: 
					if (find(x) == find(y)) System.out.print(1);
					else System.out.print(0);
					break;
				}
				
			}
			System.out.println();
			
		}
	}
	
	static void union(int x, int y) {
		set[find(y)] = find(x);
	}
	
	static int find(int x) {
		if (set[x] == x) return x;
		else return set[x] = find(set[x]);
	}

}
