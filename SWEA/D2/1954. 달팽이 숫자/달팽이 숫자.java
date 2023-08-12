import java.util.Scanner;
import java.io.FileInputStream;
class Solution
{
        public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int[] dr = {0, 1, 0, -1};
        int[] dc = {1, 0, -1, 0};
         
        for (int test_case = 1; test_case <= T; test_case++) {
            int N = sc.nextInt();
            int[][] snail = new int[N][N];
            int d = 0;
            int r = 0;
            int c = 0;
            int num = 1;
            while (num <= N * N) {
                snail[r][c] = num++;
                if (!(r + dr[d] >= 0) || !(r + dr[d] < N) || !(c + dc[d] >= 0) || !(c + dc[d] < N)
                        || (snail[r + dr[d]][c + dc[d]] > 0))
                    d++;
                d %=4;
                r = r+dr[d];
                c = c+dc[d];
                 
            }
            System.out.println("#"+test_case);
            for (int i=0; i<N; i++) {
                for (int j=0; j<N; j++)
                    System.out.print(snail[i][j] + " ");
                System.out.println();
            }
             
        }
         
    }
}