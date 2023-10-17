
import java.util.Scanner;

public class Main {
	static int[] arr;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		arr = new int[n+1];
		for (int i=0; i<=n; i++) arr[i] = i;
		// 0: 합집합
		// 1: 확인 연산
		
		for (int i=0; i<m; i++) {
			int comm = sc.nextInt();
			int num1 = sc.nextInt();
			int num2 = sc.nextInt();
			if (comm==0) union(num1, num2);
			else {
				if (find(num1) == find(num2)) System.out.println("YES");
				else System.out.println("NO");
			}
		}
		
	}
	
	
	static void union(int n1, int n2) {
		int start = find(n1);
		int end = find(n2);
		arr[start] = end;
	}
	
	static int find(int num) {
		if (num == arr[num]) return num;
		return arr[num] = find(arr[num]);
	}
}
