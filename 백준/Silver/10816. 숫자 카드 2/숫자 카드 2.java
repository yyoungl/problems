
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int[] sang;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		sang = new int[N];
		StringBuilder sb = new StringBuilder();
		for (int i=0; i<N; i++) sang[i] = sc.nextInt();
		Arrays.sort(sang);
		
		
		int M = sc.nextInt();
		int[] check = new int[M];
		
		for (int i=0; i<M; i++) {
			check[i] = sc.nextInt();
		}
		for (int i=0; i<M; i++) {
			sb.append(high(check[i]) - low(check[i])).append(" ");
		}
		
		System.out.println(sb.toString());
	}
	
	public static int low(int key) {
		int l = 0;
		int h = sang.length;
		
		while (l < h) {
			int mid = (h+l) /2;
			
			if (key <= sang[mid]) {
				h = mid;
			} else l = mid+1;
		}
		return l;
		
	}
	
	public static int high(int key) {
		int l = 0;
		int h = sang.length;
		
		while (l < h) {
			int mid = (h+l)/2;
			if(key<sang[mid]) h = mid;
			else l = mid+1;
		}
		return l;
	}
	
	

}
