
import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
		public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N];
		
		for (int i=0; i<N; i++) arr[i] = sc.nextInt();
		for (int i=0; i<(N/2)+1; i++) {
			int minIndex = i;
			for (int j=i+1; j<N; j++) {
				if (arr[minIndex] > arr[j]) {
					minIndex = j;
				}
			}
			int temp = arr[i];
			arr[i] = arr[minIndex];
			arr[minIndex] = temp;
		}
		System.out.println(arr[(N/2)]);
        }
}