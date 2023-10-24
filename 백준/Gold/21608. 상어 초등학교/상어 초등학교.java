import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	static int N;
	static int[][] seat;
	static int[] happy = {0, 1, 10, 100, 1000};
	static ArrayList<Integer>[] like;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	static int[] students;
	static class Node {
		int r;
		int c;
		int like;
		int vacant;
		public Node(int r, int c, int like, int vacant) {
			super();
			this.r = r;
			this.c = c;
			this.like = like;
			this.vacant = vacant;
		}
		@Override
		public String toString() {
			return "Node [r=" + r + ", c=" + c + ", like=" + like + ", vacant=" + vacant + "]";
		}
		
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		// 학생 수 N*N명
		seat = new int[N][N];
		like = new ArrayList[N*N+1];
		students = new int[N*N];
		int answer = 0;
		for (int i=0; i<=N*N; i++) {
			like[i] = new ArrayList<>();
		}
		
		for (int i=0; i<N*N; i++) {
			int person = sc.nextInt();
			students[i] = person;
			for (int j=0; j<4; j++) {
				like[person].add(sc.nextInt());
			}
		}
		int maxLike = 0;
		int likeCnt = 0;
		int vacant = 0;
		Node selected;
		for (int student: students) {
			boolean isSelected = false;
			selected = new Node(0, 0, 0, 0);
			for (int r=0; r<N; r++) {
				for (int c=0; c<N; c++) {
					if (seat[r][c] > 0) continue;

					likeCnt = 0;
					vacant = 0;
					for (int d=0; d<4; d++) {
						int nr = r+dr[d];
						int nc = c+dc[d];
						if (isValid(nr, nc)) {
							if (like[student].contains(seat[nr][nc])) likeCnt++;
							if(seat[nr][nc] == 0) vacant++;
						}
						
						if (likeCnt > selected.like) {
							selected = new Node(r, c, likeCnt, vacant);
                            isSelected = true;
						} else if (likeCnt == selected.like && vacant > selected.vacant) {
							selected = new Node(r, c, likeCnt, vacant);
                            isSelected = true;
						}
						if (!isSelected) {
							selected = new Node(r, c, likeCnt, vacant);
							isSelected = true;
						}
					}
					
				}
			}
			seat[selected.r][selected.c] = student;
		}
		
		for (int r=0; r<N; r++) {
			for (int c=0; c<N; c++) {
				int curr = seat[r][c];
				int cnt = 0;
				for (int d=0; d<4; d++) {
					int nr = r+dr[d];
					int nc = c+dc[d];
					if (isValid(nr, nc) && like[curr].contains(seat[nr][nc])) cnt++;
											
				}
				answer += happy[cnt];
			}
		}
		
		System.out.println(answer);
	}
	
	static boolean isValid(int r, int c) { 
		if (r < 0 || r>=N || c<0 || c>=N) return false;
		return true;
	}

}
