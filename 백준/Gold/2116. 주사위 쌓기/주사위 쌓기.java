import java.util.Scanner;
class Dice {
	int a;
	int b; 
	int c;
	int d; 
	int e;
	int f;
	
	public Dice(int a, int b, int c, int d, int e, int f) {
		super();
		this.a=a;
		this.b=b;
		this.c=c;
		this.d=d;
		this.e=e;
		this.f=f;
	}
	
	public int opposite(int x) {
		if (a==x) return f;
		else if (b==x) return d;
		else if (c==x) return e;
		else if (d==x) return b;
		else if (e==x) return c;
		else if (f==x) return a;
		return -1;
	}
	
	public int max(int x) {
		if (a==x || f==x) {
			return Math.max(Math.max(b, d), Math.max(c,  e));
		}
		
		else if (b==x || d==x) {
			return Math.max(Math.max(a, f), Math.max(c, e));
		}
		
		else if (c==x || e==x) {
			return Math.max(Math.max(a, f), Math.max(b, d));
		}
		return -1;
	}

	
}
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		Dice[] dices = new Dice[N];
		
		for (int i=0; i<N; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
			int d = sc.nextInt();
			int e = sc.nextInt();
			int f = sc.nextInt();
			dices[i] = new Dice(a, b, c, d, e, f);
		}
		int answer = 0;
		
		
		for (int i=1; i<=6; i++) {
			int temp = 0;
			int top = i;
			int bottom = dices[0].opposite(i);
			temp += dices[0].max(top);
			int idx = 1;
			while (idx<N) {
				top = bottom;
				bottom = dices[idx].opposite(top);
				temp += dices[idx].max(top);
				idx++;
			}
			answer = Math.max(temp, answer);
			
		}
		System.out.println(answer);
		
		
	}
}
