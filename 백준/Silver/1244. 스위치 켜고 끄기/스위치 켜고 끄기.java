import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] light = new int[N + 1];
		for (int i = 1; i < N + 1; i++) {
			light[i] = sc.nextInt();
		}

		int p = sc.nextInt();
		for (int command = 0; command < p; command++) {
			int gender = sc.nextInt();
			int index = sc.nextInt();
			if (light[index] > 0)
				light[index]--;
			else
				light[index]++;
			if (gender == 1) {
				for (int i=index*2; i<=N; i+=index) {
					if (light[i] > 0) light[i]--;
					else light[i] ++;
				}
			}
			if (gender == 2) {
				for (int i = 1; i < N; i++) {
					if (index + i <= N && index - i > 0) {

						if (light[index + i] == light[index - i]) {
							if (light[index + i] > 0) {
								light[index + i]--;
								light[index - i]--;
							} else {
								light[index + i]++;
								light[index - i]++;
							}
						} else
							break;
					}
				}
			}
			
			
		}
		for (int i = 1; i < N + 1; i++) {

			if (i % 20 == 0) {
				
				System.out.print(light[i]);
				System.out.println();
			} else if (i==N)
				System.out.print(light[i]);
			else System.out.print(light[i] + " ");

		}
		System.out.println();

	}

}
