import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
		public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		for (int test_case=1; test_case<=10; test_case++) {
			int[] boxes = new int[100];
			int dumps = sc.nextInt();
			for (int i=0; i<100; i++) {
				boxes[i] = sc.nextInt();
			}
			int maxIdx = 0;
			int minIdx = 0;
			int diff = Integer.MAX_VALUE;
			while (dumps > 0 && diff > 1) {
				for (int i=0; i<100; i++) {
					if (boxes[i] > boxes[maxIdx]) maxIdx = i;
					if (boxes[i] < boxes[minIdx]) minIdx = i;
				}
				
				boxes[maxIdx] -= 1;
				boxes[minIdx] += 1;
				diff = Math.min(diff, boxes[maxIdx] - boxes[minIdx]);
				dumps-=1;
//				System.out.println("diff: "+ diff+" dumps: " +dumps+" maxIdx: "+maxIdx + " max: "+ boxes[maxIdx] + " minIdx: "+ minIdx+ " min: " + boxes[minIdx]);
			}
			for (int i=0; i<100; i++) {
				if (boxes[i] > boxes[maxIdx]) maxIdx = i;
				if (boxes[i] < boxes[minIdx]) minIdx = i;
			}
			diff = boxes[maxIdx] - boxes[minIdx];
			
			System.out.println("#" + test_case + " " +diff);
		}
	}

}