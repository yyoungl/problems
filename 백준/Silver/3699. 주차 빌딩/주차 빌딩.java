
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int tc=1; tc<=T; tc++) {
            int answer = 0;
            int N = sc.nextInt();
            int M = sc.nextInt();
            
            int[][] tower = new int[N][M];
            int[] position = new int[N];
            int cars = 0;
            
            for (int i=0; i<N; i++) {
            	position[i] = 0;
                for (int j=0; j<M; j++) {
                    int temp = sc.nextInt();
                    if (temp > 0) cars++;
                    tower[i][j] = temp;
                }
            }
            
            
            int now = 1;
            int c = 0;
            while (now <= cars) {
                
                for (int i=0; i<N; i++) {
                    for (int j=0; j<M; j++) {
                        if (tower[i][j]==-1) continue;
                        if (tower[i][j] == now) {
                        	c = position[i];
                            now++;
                            int clock = 0;
                            int counterclock = 0;
                            if (j > c) {
                                clock = M-j+c;
                                counterclock = j-c;
                            }
                            else {
                                clock = c-j;
                                counterclock = M-c+j;
                            }
                            
                            
                            position[i] = j;
                            answer += Math.min(clock, counterclock) * 5;
                            answer += 2*i * 10;
                        }
                    }
                }
                
            }
            
            System.out.println(answer);
            
            
        }
    }

}