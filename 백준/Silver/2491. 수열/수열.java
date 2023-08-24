import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int[] increase = new int[N];
		int[] decrease = new int[N];
		int[] arr = new int[N];
		for (int i=0; i<N; i++) {
			arr[i] = sc.nextInt();
			increase[i] = 1;
			decrease[i] = 1;
		}
		
		
		
		for (int i=0; i<N-1; i++) {
			if (arr[i+1]>=arr[i]) {
				increase[i+1] = increase[i]+1;
			}
			if (arr[i+1]<=arr[i]) {
				decrease[i+1] = decrease[i]+1;
			}
		}
		
		int maxLen = 0;
		
		for (int i=0; i<N; i++) {
			maxLen = Math.max(Math.max(decrease[i], increase[i]),  maxLen);
		}
		
		
		System.out.println(maxLen);
		
	}

}
