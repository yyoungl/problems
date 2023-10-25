
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		beer(N);
		if (N==1) 
			System.out.println("Go to the store and buy some more, "+N+" bottle of beer on the wall.");
		else 
			System.out.println("Go to the store and buy some more, "+N+" bottles of beer on the wall.");
	}

	static void beer(int N) {
		if (N==0) {
			System.out.println("No more bottles of beer on the wall, no more bottles of beer.");
			return;
		}
		if (N==1) {
			System.out.println(N+ " bottle of beer on the wall, "+N+ " bottle of beer.\nTake one down and pass it around, no more bottles of beer on the wall.\n");
			
		} else if (N==2) {
			System.out.println(N+ " bottles of beer on the wall, "+N+ " bottles of beer.\nTake one down and pass it around, "+(N-1)+" bottle of beer on the wall.\n");
		} else {
			System.out.println(N+ " bottles of beer on the wall, "+N+ " bottles of beer.\nTake one down and pass it around, "+(N-1)+" bottles of beer on the wall.\n");
		}
		beer(N-1);
	}
}
