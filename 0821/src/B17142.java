import java.util.ArrayList;
import java.util.Scanner;

public class B17142 {

	public static class Virus {
		int i;
		int j;

		public Virus(int i, int j) {
			super();
			this.i = i;
			this.j = j;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // 연구소 크기
		int M = sc.nextInt(); // 바이러스 개수
		int[][] map = new int[N][N];
		ArrayList<Virus> virus = new ArrayList<>();
		boolean[][] visited = new boolean[N][N];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				int in = sc.nextInt();
				if (in == 2) {
					virus.add(new Virus(i, j));
				} else if (in == 1) {
					visited[i][j] = true;
				}
				map[i][j] = in;
			}
		}
		boolean[] check = new boolean[virus.size()];
		ArrayList<Virus> comb = new ArrayList<>();
		combination(virus, 0, comb, M, check);

	}

	public static void combination(ArrayList<Virus> virus, int start, ArrayList<Virus> comb, int M, boolean[] check) {
		if (comb.size() == M) {
			// 이 조합을 바탕으로 연구소 바이러스를 퍼뜨리는
			return;
		}
		for (int i = start; i < virus.size(); i++) {
			if (!check[i]) {
				check[i] = true;
				comb.add(virus.get(i));
				combination(virus, i + 1, comb, M, check);
				check[i] = false;
				comb.remove(comb.size() - 1);
			}
		}

	}

}
