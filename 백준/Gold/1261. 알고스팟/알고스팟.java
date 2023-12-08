import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    static int N;
    static int M;
    static boolean[][] visited;
    static int[][] map;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    static class Node implements Comparable<Node> {
        int r;
        int c;
        int crash;

        public Node(int r, int c, int crash) {
            this.r = r;
            this.c = c;
            this.crash = crash;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "r=" + r +
                    ", c=" + c +
                    ", crash=" + crash +
                    '}';
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.crash, o.crash);
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        M = sc.nextInt();
        N = sc.nextInt();
        map = new int[N][M];
        visited = new boolean[N][M];
        int answer = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            String input = sc.next();
            for (int j = 0; j < M; j++)
                map[i][j] = input.charAt(j) - '0';
        }

        int r = 0;
        int c = 0;
        int crash = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>();
        Node curr = new Node(r, c, crash);
        visited[r][c] = true;
        pq.add(curr);

        while(!pq.isEmpty()) {
            curr = pq.poll();
            r = curr.r;
            c = curr.c;
            crash = curr.crash;


            if ( r == N-1 && c == M-1) {
                break;
            }

            int nr, nc;

            for (int d=0; d<4; d++) {
                nr = r+dr[d];
                nc = c+dc[d];
                if (!isValid(nr, nc) || visited[nr][nc]) continue;

                if (map[nr][nc] == 1) {
                    pq.add(new Node(nr, nc, crash+1));
                    visited[nr][nc] = true;
                } else{
                    pq.add(new Node(nr, nc, crash));
                    visited[nr][nc] = true;
                }

            }

        }

        System.out.println(crash);

    }

    static boolean isValid(int r, int c) {
        return r >= 0 && r < N && c >= 0 && c < M;
    }
}
