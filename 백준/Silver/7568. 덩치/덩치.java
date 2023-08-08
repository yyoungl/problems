import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[][] chart = new int[N][2];
		int[] rank = new int[N];
		for (int i=0; i<N; i++) {
			int[] temp = new int[2];
			temp[0] = sc.nextInt();
			temp[1] = sc.nextInt();
			chart[i] = temp;
			rank[i] ++;
		}

		for (int i=0; i<N; i++) {
			for (int j=0; j<N; j++) {
				if (i==j) continue;
				else {
					if (chart[i][0] < chart[j][0] && chart[i][1] < chart[j][1]) {
						rank[i] ++;
					}
				}
			}
		}
		for (int r: rank) {
			System.out.print(r+" ");
		}
	}

}
