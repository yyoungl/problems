import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class Solution {
	static class Node {
		int r;
		int c;
		
		public Node(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}

		@Override
		public String toString() {
			return "Node [r=" + r + ", c=" + c + "]";
		}		
		
		
	}
	
	static int[] dr = {0, 1, 0, -1};
	static int[] dc = {1, 0, -1, 0};
	static Stack<Node> stack;
	
	static boolean[][] map;
	static int N;
	static Node end = new Node(N-1, N-1);
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = 10;
		N = 16;
		for (int test_case=1; test_case<=T; test_case++) {
			int t = sc.nextInt();
			stack = new Stack<>();
			boolean answer = false;
			map = new boolean[N][N];
			
			for (int i=0; i<N; i++) {
				String input = sc.next();
				for (int j=0; j<N; j++) {
					int in = input.charAt(j)-'0';
					if (in==1) map[i][j] = true;
					else if (in==3) end = new Node(i, j);
				}
			}
			
			int r = 1;
			int c = 1;
			stack.add(new Node(r, c));
			while (!stack.isEmpty()) {
				
				boolean go = false;
				map[r][c] = true;
				if (r==end.r && c==end.c) {
					answer = true;
					break;
				}
				
				for (int d=0; d<4; d++) {
					if (r+dr[d] > 0 && r+dr[d]<N && c+dc[d] > 0 && c+dc[d] < N && !map[r+dr[d]][c+dc[d]]) {
						stack.add(new Node(r+dr[d], c+dc[d]));
						go = true;
						break;
					}
				}
				
				if (!go) {
					Node next = stack.pop();
					r = next.r;
					c = next.c;
				} else {
					Node next = stack.peek();
					r = next.r;
					c = next.c;
				}
				
			}
			
			if (answer) System.out.println("#"+t+" 1");
			else System.out.println("#"+t+" 0");
			
		}
	}

}
