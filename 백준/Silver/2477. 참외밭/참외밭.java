
import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		// 1: 동 2: 서 3: 남 4: 북
		int[] len = new int[6];
		int maxGaro = 0;
		int garoI = 0;
		int maxSero = 0;
		int seroI = 0;
		for (int i=0; i<6; i++) {
			int d = sc.nextInt();
			len[i] = sc.nextInt();
			if ((d==1 || d==2) && len[i] > maxGaro) {
				maxGaro = len[i];
				garoI = i;
			}
			else if ((d==3 || d==4) && len[i] > maxSero) {
				maxSero = len[i];
				seroI = i;
			}
		}
		int area = maxSero * maxGaro;
		int r, l, minGaro, minSero;
		
		if (garoI + 1 == 6) r = 0;
		else r = garoI+1;
		
		if (garoI-1 == -1) l = 5;
		else l = garoI-1;
		
		minGaro = Math.abs(len[l]-len[r]);
		
		if (seroI + 1 == 6) r = 0;
		else r = seroI+1;
		if (seroI-1==-1) l=5;
		else l = seroI-1;
		
		minSero = Math.abs(len[l]-len[r]);
		
		area-=minSero*minGaro;
		
		System.out.println(area*N);
		
	}
	

}
