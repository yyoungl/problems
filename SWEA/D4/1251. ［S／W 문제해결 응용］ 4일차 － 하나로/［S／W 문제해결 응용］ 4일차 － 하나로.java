import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Solution {
	
	static class Edge {
		int start;
		int end;
		double L;
		
		public Edge(int start, int end, double l) {
			super();
			this.start = start;
			this.end = end;
			L = l;
		}

		@Override
		public String toString() {
			return "Edge [start=" + start + ", end=" + end + ", L=" + L + "]";
		}
		
		
		
	}
	
	static int[][] islands;
	static int[] p;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int test_case=1; test_case<=T; test_case++) {
			int N = sc.nextInt();
			islands = new int[N][2];
			double answer = 0;
			p = new int[N];
			for (int i=0; i<N; i++) {
				islands[i][0] = sc.nextInt();
				p[i] = i;
			}
			
			for (int i=0; i<N; i++) {
				islands[i][1] = sc.nextInt();
			}
			double E = sc.nextDouble();
			Edge[] len = new Edge[N*(N-1)/2];
			int idx=0;
			for (int i=0; i<N; i++) {
				for (int j=i+1; j<N; j++) {
					double l = Math.pow(islands[i][0]-islands[j][0], 2) + Math.pow(islands[i][1]-islands[j][1], 2);
					len[idx++] = new Edge(i, j, l);
				}
			}
			Arrays.sort(len, Comparator.comparingDouble(edge -> edge.L));
			
			
			for (Edge e: len) {
				if (find(e.start) != find(e.end)) { 
					union(e.start, e.end);
					answer += e.L;
				}
			}
			
			
			answer *= E;
			
			System.out.println("#"+test_case+" "+ Math.round(answer));
		}
	} 
	
	static void union(int x, int y) {
		p[find(y)] = find(x);
	}
	
	static int find(int x) {
		if (p[x] == x) return x;
		else return p[x] = find(p[x]);
	}

}
