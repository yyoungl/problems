import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Node {
	int num;
	ArrayList<Integer> child;
	int parent;

	public Node(int num) {
		this.num = num;
		this.child = new ArrayList<>();
		this.parent = 0;

	}

}

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {
			int V = sc.nextInt(); // 노드의 개수
			int E = sc.nextInt(); // 간선의 개수
			// 공통 조상을 찾을 두 가지
			int n1 = sc.nextInt();
			int n2 = sc.nextInt();
			Node[] tree = new Node[V + 1];
			for (int i = 1; i <= V; i++) {
				tree[i] = new Node(i);
			}

			for (int i = 0; i < E; i++) {
				int parent = sc.nextInt();
				int child = sc.nextInt();
				tree[parent].child.add(child);
				tree[child].parent = parent;
			}
			
			ArrayList<Integer> p1 = new ArrayList<>();
			int child = n1;
			while (true) {
				if (child == 0) break;
				p1.add(tree[child].parent);
				child = tree[child].parent;
			}
			
			
			int ancient = n2;
			while (true) {
				ancient = tree[ancient].parent;
				if (p1.contains(ancient)) break;
			}
			
			
			System.out.print("#"+test_case+" "+ancient);
			
			Queue<Integer> check = new LinkedList<>();
			check.add(ancient);
			int cnt = 0;
			while (!check.isEmpty()) {
				int follow = check.poll();
				
				for (int i: tree[follow].child) {
					check.add(i);
				}
				
				cnt++;
				
			}
			
			System.out.println(" "+cnt);
		}
	}
	
	
	

}
