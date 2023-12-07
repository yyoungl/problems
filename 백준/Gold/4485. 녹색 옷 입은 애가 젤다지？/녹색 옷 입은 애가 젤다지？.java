import java.util.*;

public class Main {
    static class Node implements Comparable<Node>{
        int r;
        int c;
        int lost;

        public Node(int r, int c, int lost) {
            this.r = r;
            this.c = c;
            this.lost = lost;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.lost, o.lost);
        }

        @Override
        public String toString() {
            return "Node{" +
                    "r=" + r +
                    ", c=" + c +
                    ", lost=" + lost +
                    '}';
        }
    }
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static int N;
    static int[][] cave;
    static int[][] cost;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = 1;
        while (true) {
            N = sc.nextInt();
            if (N==0) break;
            cave = new int[N][N];
            cost = new int[N][N];

            for (int i=0; i<N; i++) {
                for (int j=0; j<N; j++) {
                    cave[i][j] = sc.nextInt();
                    cost[i][j] = Integer.MAX_VALUE;
                }
            }
            PriorityQueue<Node> pq = new PriorityQueue<>();
            int r = 0;
            int c = 0;
            int lost = cave[0][0];
            pq.add(new Node(r, c, lost));
            cost[0][0] = lost;

            while (!pq.isEmpty()) {
                Node curr = pq.poll();
                r = curr.r;
                c = curr.c;
                lost = curr.lost;

                if (r == N-1 && c == N-1) break;

                int nr, nc;
                for (int d=0; d<4; d++) {
                    nr = r+dr[d];
                    nc = c+dc[d];

                    if (!isValid(nr, nc)) continue;

                    if (cost[nr][nc] > lost + cave[nr][nc]) {
                        pq.add(new Node(nr, nc, lost+cave[nr][nc]));
                        cost[nr][nc] = lost+cave[nr][nc];
                    }

                }
            }

            System.out.println("Problem "+(T++)+ ": "+cost[N-1][N-1]);


        }
    }

    static boolean isValid(int r, int c) {
        return r >= 0 && r < N && c >= 0 && c < N;
    }

}
