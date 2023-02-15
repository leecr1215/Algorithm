import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class 백준_11286_절댓값_힙 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->{
			if(Math.abs(a)==Math.abs(b)) {
				return a-b;
			}
			return Math.abs(a)-Math.abs(b);
		});
		
		int N = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < N; i++) {
			int x = Integer.parseInt(br.readLine());
			
			if(x == 0) {
				if(pq.isEmpty()) {
					System.out.println(0);
				}else {					
					System.out.println(pq.poll());
				}
			}else {
				pq.add(x);
			}
		}
		
	}
}
