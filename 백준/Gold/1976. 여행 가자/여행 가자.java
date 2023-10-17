
import java.util.Scanner;

public class Main {
	static int[] arr;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		arr = new int[N];
		for (int i=0; i<N; i++) arr[i] = i;
		for (int i=0; i<N; i++) {
			for (int j=0; j<N; j++) {
				int temp = sc.nextInt();
				if (temp==1) {
					union(i, j);
				}
			}
		}
		
		int answer = find(sc.nextInt()-1);
		boolean chk = true;
		for (int i=0; i<M-1; i++) {
			int find = sc.nextInt() -1;
			if (answer != find(find)) chk = false;
		}
		
		if (!chk) System.out.println("NO");
		else System.out.println("YES");
		
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
