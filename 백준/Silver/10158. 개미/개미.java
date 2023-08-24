import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int X = sc.nextInt();
		int Y = sc.nextInt();
		int x = sc.nextInt();
		int y = sc.nextInt();
		
		int time = sc.nextInt();
		int xFinal = x+time;
		int yFinal = y+time;
		if ((xFinal/X)%2 == 0) x = xFinal%X;
		else x = X - xFinal%X; 
		
		if ((yFinal/Y) % 2 == 0) y = (yFinal%Y);
		else y = Y - yFinal%Y;
		
		System.out.println(x+" "+y);
	}

}
