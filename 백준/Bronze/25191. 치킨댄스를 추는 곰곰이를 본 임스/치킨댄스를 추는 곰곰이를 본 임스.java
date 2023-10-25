
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int chickens = sc.nextInt();
		int coke = sc.nextInt();
		int beer = sc.nextInt();
		int cnt = coke/2 + beer;
		if (cnt > chickens) System.out.println(chickens);
		else System.out.println(cnt);
	}

}
