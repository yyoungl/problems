import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    static class Node implements Comparable<Node> {
        int r;
        int c;
        int cost;

        public Node(int r, int c, int cost) {
            this.r = r;
            this.c = c;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.cost, o.cost);
        }

        @Override
        public String toString() {
            return "Node{" +
                    "r=" + r +
                    ", c=" + c +
                    ", cost=" + cost +
                    '}';
        }
    }

    static int N;
    static int M;
    static int T;
    static int[][] castle;
    static int[][] cnt;
    static int swordR = 0;
    static int swordC = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        T = sc.nextInt();
        castle = new int[N][M];
        int answer = T + 1;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                int input = sc.nextInt();
                castle[i][j] = input;
                if (input == 2) {
                    swordR = i;
                    swordC = j;
                }
            }
        }


        int go = bfs(new Node(0, 0, 0), N - 1, M - 1, false);

        int sword = bfs(new Node(0, 0, 0), swordR, swordC, false);
        int sword_end = bfs(new Node(swordR, swordC, sword), N - 1, M - 1, true);

        answer = Math.min(sword_end, go);

        if (answer > T) System.out.println("Fail");
        else System.out.println(answer);


    }

    static int bfs(Node start, int endR, int endC, boolean haveSword) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        boolean[][] visited = new boolean[N][M];
        int r = start.r;
        int c = start.c;
        int cost = start.cost;
        pq.add(start);
        visited[r][c] = true;

        while (!pq.isEmpty()) {
            Node curr = pq.poll();
            r = curr.r;
            c = curr.c;
            cost = curr.cost;


            if (r == endR && c == endC) {
                return cost;
            }


            int nr, nc;

            for (int d = 0; d < 4; d++) {
                nr = r + dr[d];
                nc = c + dc[d];
                if (!isValid(nr, nc) || visited[nr][nc]) continue;


                if (castle[nr][nc] == 0 || castle[nr][nc] == 2) {
                    pq.add(new Node(nr, nc, cost + 1));
                    visited[nr][nc] = true;
                }
                else if (castle[nr][nc] == 1 && haveSword) {
                    pq.add(new Node(nr, nc, cost + 1));
                    visited[nr][nc] = true;
                }

            }

        }

        return T+1;
    }

    static boolean isValid(int r, int c) {
        if (r < 0 || r >= N || c < 0 || c >= M) return false;
        else return true;
    }


}
