import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
        while (N-->0) {
			int[] coins = new int[4];
			int change = sc.nextInt();
			while (change > 0) {
				coins[0] += change/25;
				change %= 25;
				coins[1] += change/10;
				change %= 10;
				coins[2] += change/5;
				change %= 5;
				coins[3] += change;
				change %= 1;
			}
			for (int cnt: coins)
				System.out.print(cnt + " ");
			System.out.print("\n");
		}
	}
}
