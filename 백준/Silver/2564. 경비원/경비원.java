
import java.util.Scanner;

class Store {
	int dir;
	int dis;
	public Store(int dir, int dis) {
		super();
		this.dir = dir;
		this.dis = dis;
	}
}

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int C = sc.nextInt();
		int R = sc.nextInt();
		int N = sc.nextInt();
		Store[] stores = new Store[N];
		
		for (int i=0; i<N; i++) {
			int dir = sc.nextInt();
			int dis = sc.nextInt();
			
			stores[i] = new Store(dir, dis);
			
		}
		int answer = 0;
		Store dong = new Store(sc.nextInt(), sc.nextInt());
		for (int i=0;i <N; i++) {
			Store store = stores[i];
			if (dong.dir == store.dir) answer += Math.abs(dong.dis-store.dis);
			else if ((dong.dir == 3 && store.dir == 4)||(dong.dir==4 && store.dir == 3) || (dong.dir == 1 && store.dir == 2) || (dong.dir == 2 && store.dir==1) ) {
				if (store.dir == 1 || store.dir == 2) 
					answer += R + Math.min(dong.dis + store.dis, 2*C - dong.dis - store.dis);
				else if (store.dir == 3 || store.dir == 4) 
					answer += C + Math.min(dong.dis + store.dis, 2*R - dong.dis - store.dis);
			} else {
				if (store.dir == 1) {
					if (dong.dir == 3) answer += dong.dis + store.dis;
					else if (dong.dir == 4) answer += dong.dis + C - store.dis;
				} 
				else if (store.dir == 2) {
					if (dong.dir == 3) answer += R - dong.dis + store.dis;
					else if (dong.dir == 4) answer += R - dong.dis + C - store.dis;
				}
				else if (store.dir == 3) {
					if (dong.dir == 1) answer += dong.dis + store.dis;
					else if (dong.dir == 2) answer += dong.dis + R - store.dis;
				} else if (store.dir == 4) {
					if (dong.dir == 1) answer += store.dis + C - dong.dis;
					if (dong.dir == 2) answer += R - store.dis + C-dong.dis;
				}
			}
		}
		System.out.println(answer);
		
		
	}

}
