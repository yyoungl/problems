import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] distance = new int[N - 1];
		int[] price = new int[N];
		for (int i = 0; i < N - 1; i++) {
			distance[i] = sc.nextInt();
		}

		for (int i = 0; i < N; i++) {
			price[i] = sc.nextInt();
		}

		int answer = 0;
		int cost = price[0];
		for (int i = 0; i < N - 1; i++) {
			if (cost <= price[i]) answer += cost * distance[i];
			else {
				answer += price[i] * distance[i];
				cost = price[i];
			}
		}
		System.out.println(answer);

	}

}
