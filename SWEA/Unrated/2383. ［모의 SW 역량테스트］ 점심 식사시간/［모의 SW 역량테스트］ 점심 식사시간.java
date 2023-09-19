import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Solution {

	public static class Point {
		int r;
		int c;

		public Point(int r, int c) {
			this.r = r;
			this.c = c;
		}

		@Override
		public String toString() {
			return "Point [r=" + r + ", c=" + c + "]";
		}

	}

	public static ArrayList<Point> people;
	public static ArrayList<Point> stairs;
	public static boolean[] chk;
	static int answer;
	static int pCnt;
	static int[][] graph;

	public static void main(String[] args) {
		// 점심식사
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {
			stairs = new ArrayList<>();
			people = new ArrayList<>();
			int N = sc.nextInt();
			answer = Integer.MAX_VALUE;
			graph = new int[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					int input = sc.nextInt();
					graph[i][j] = input;
					if (input == 1)
						people.add(new Point(i, j));
					else if (input > 1)
						stairs.add(new Point(i, j));
				}
			}
			pCnt = people.size(); // 사람의 숫자
			chk = new boolean[pCnt];
			bfs(0);
			
			System.out.println("#"+test_case+" "+answer);
		}

	}

	public static void bfs(int idx) {
		if (idx == pCnt) {
			timeChk(chk);
			return;
		} else {
			bfs(idx + 1);
			chk[idx] = true;
			bfs(idx + 1);
			chk[idx] = false;
		}
	}

	public static void timeChk(boolean[] chk) {
		Point stair1 = stairs.get(0);
		Point stair2 = stairs.get(1);
		int height1 = graph[stair1.r][stair1.c];
		int height2 = graph[stair2.r][stair2.c];
		ArrayList<Integer> first = new ArrayList<>();
		ArrayList<Integer> second = new ArrayList<>();
		
		for (int i=0; i<pCnt; i++) {
			Point temp = people.get(i);
			if (chk[i]) first.add(Math.abs(stair1.r - temp.r) + Math.abs(stair1.c - temp.c));
			else second.add(Math.abs(stair2.r-temp.r) + Math.abs(stair2.c-temp.c));
		}
		
		first.sort(Comparator.naturalOrder());
		second.sort(Comparator.naturalOrder());
		
		for (int i=0; i<first.size(); i++) {
			if (i<3) {
				int temp = first.get(i);
				first.set(i, temp+ height1 +1);
			} else {
				int last = first.get(i-3);
				int curr = first.get(i);
				if (last > curr) {
					first.set(i, last+height1);
				} else {
					first.set(i, curr+height1+1);
				}
			}
		}
		
		for (int i=0; i<second.size(); i++) {
			if (i<3) {
				int temp = second.get(i);
				second.set(i, temp+ height2 +1);
			} else {
				int last = second.get(i-3);
				int curr = second.get(i);
				if (last > curr) {
					second.set(i, last+height2);
				} else {
					second.set(i, curr+height2+1);
				}
			}
		}
		
		if (first.size() == 0) answer = Math.min(answer, second.get(second.size()-1));
		else if (second.size() == 0) answer = Math.min(answer, first.get(first.size()-1));
		else 
			answer = Math.min(answer, Math.max(first.get(first.size()-1), second.get(second.size()-1)));
		
		
	}

}
