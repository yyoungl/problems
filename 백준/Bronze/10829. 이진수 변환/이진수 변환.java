import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long N = Long.valueOf(sc.next());
		System.out.println(binary(N));
	}

	public static String binary(long M) {

		String result = "";

		while (M > 0) {
			result = Long.toString(M % 2) + result;
			M = M / 2;
		}

		return result;

	}

}
