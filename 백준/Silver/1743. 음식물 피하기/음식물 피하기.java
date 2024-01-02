import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int N;
    static int M;
    static int K;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static int[][] map;
    static boolean[][] visited;
    static int answer = 0;
    static class Node {
        int r;
        int c;

        public Node(int r, int c) {
            this.r = r;
            this.c = c;
        }

        public Node() {
        }

        @Override
        public String toString() {
            return "Node{" +
                    "r=" + r +
                    ", c=" + c +
                    '}';
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        K = sc.nextInt();
        map = new int[N][M];
        visited = new boolean[N][M];
        int r;
        int c;

        for (int i=0; i<K; i++) {
            r = sc.nextInt();
            c = sc.nextInt();
            map[r-1][c-1] = 1;
        }
        

        for (int i=0; i<N; i++) {
            for (int j=0; j<M; j++) {
                if (map[i][j] == 1 && !visited[i][j]) {
                    bfs(i, j);
                }
            }
        }

        System.out.println(answer);
    }


    static void bfs(int r, int c) {
        int cnt = 1;
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(r, c));
        visited[r][c] = true;
        while(!q.isEmpty()) {
            Node curr = q.poll();
            r = curr.r;
            c = curr.c;

            for (int d=0; d<4; d++) {
                int nr = r+dr[d];
                int nc = c+dc[d];
                if (isValid(nr, nc) && map[nr][nc] == 1 && !visited[nr][nc]) {
                    q.add(new Node(nr, nc));
                    cnt++;
                    visited[nr][nc] = true;
                }
            }


        }
        answer = Math.max(cnt, answer);
    }


    static boolean isValid(int r, int c) {
        return r >= 0 && r < N && c >= 0 && c<M;
    }

}
