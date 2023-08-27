
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int g = sc.nextInt();
		int s = sc.nextInt();
		ArrayList<Integer> garo = new ArrayList<>();
		ArrayList<Integer> sero = new ArrayList<>();
		garo.add(0);
		garo.add(g);
		sero.add(0);
		sero.add(s);

		int N = sc.nextInt();
		for (int i=0; i<N; i++) {	
			int direction = sc.nextInt();
			int idx = sc.nextInt();
			if (direction == 1)
				garo.add(idx);
			else
				sero.add(idx);
		}
		
		int answer =0;

		Collections.sort(garo);
		Collections.sort(sero);
		
		for (int i = 0; i < garo.size() - 1; i++) {
			for (int j = 0; j < sero.size() - 1; j++) {
				int a = garo.get(i+1) - garo.get(i);
				int b = sero.get(j+1) - sero.get(j);
				answer = Math.max(a*b, answer);
			}
		}
		System.out.println(answer);

	}

}