import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] distance = new int[N-1];
		int[] price = new int[N-1];
		for (int i=0; i<N-1; i++) {
			distance[i] = sc.nextInt();
		}
		
		for (int i=0;i <N-1; i++) {
			price[i] = sc.nextInt();
		}
		sc.nextInt();
		
		int answer = 0;
		int cost = price[0];
		for (int i=0; i<N-1; i++) {
			if (cost > price[i]) cost = price[i];
			answer += distance[i] * cost;
		}
		System.out.println(answer);
		
		
		
	}

}
