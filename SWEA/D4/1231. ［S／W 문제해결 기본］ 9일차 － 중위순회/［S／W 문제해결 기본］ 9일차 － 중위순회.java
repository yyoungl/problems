import java.util.Scanner;

class Node {
	int num;
	String data;
	int left;
	int right;
	
	public Node(int num) {
		this.num = num;
		this.data = null;
		this.left = 0;
		this.right = 0;
	}
	
	
}


public class Solution {
	

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 입력된 노드 번호 * 2 가 8(N, 총 노드의 개수) 보다 작다면 당연히 자식이 있음
		for (int test_case=1; test_case<=10; test_case++) {
			int N = sc.nextInt();
			Node[] tree = new Node[N+1];
			for (int i=1; i<=N; i++) {
				int node = sc.nextInt();
				tree[node] = new Node(node);
				String data = sc.next();
				tree[node].data = data;
				if (node * 2 <= N) {
					tree[node].left = sc.nextInt();
				}
				if (node*2 < N) {
					tree[node].right = sc.nextInt();
				}
				
			}
			System.out.print("#"+test_case+" ");
			inorderTraverse(1, tree);
			System.out.println();
			
		}
		
	}
	
	static void inorderTraverse(int node, Node[] tree) {
		if (tree[node] != null) {
			inorderTraverse(tree[node].left, tree);
			System.out.print(tree[node].data);
			inorderTraverse(tree[node].right, tree);
		}
	}
	

}

