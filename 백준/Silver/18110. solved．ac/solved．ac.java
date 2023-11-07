
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		for (int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(arr);
		int num = (int) Math.round((double) N * 0.15);
		int avg = 0;
		for (int i=num; i<N-num; i++) {
			avg += arr[i];
		}
		int answer =(int) Math.round((double) avg / (N - num*2)); 
		bw.write(Integer.toString(answer));
		bw.flush();
		
	}

}
