import java.util.Arrays;
import java.util.Scanner;

public class bread {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int test_case=1; test_case<=T; test_case++) {
			int N = sc.nextInt(); // »ç¶÷ ¼ö
			int M = sc.nextInt(); // MÃÊ¿¡
			int K = sc.nextInt(); // ºØ¾î»§ K°³
			int[] people = new int[N];
			int bread = 0;
			boolean isOkay = true;
			for (int i=0; i<N; i++) {
				people[i] = sc.nextInt();
			}
			
			Arrays.sort(people);
			
			int timeFinal = people[N-1];
			int person = 0;
			
//			System.out.println(Arrays.toString(people));
			
			for (int time =0; time<=timeFinal; time++) {
				if (time%M==0 && time>0) bread += K;
//				System.out.println("BREAD: "+ bread+" time: "+ time);
				if (people[person] == time && bread>0) {
//					System.out.println("person: "+person+" people: "+people[person] + " bread: "+bread);
					bread--;
					person++;
				} else if (people[person] == time && bread <= 0) {
					isOkay = false;
					break;
				}
			}
			
			if (isOkay) System.out.println("#"+test_case+" Possible");
			else System.out.println("#"+test_case+" Impossible");
			
		}
	}

}
