import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Solution_1225 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for(int t = 1; t <= 10; t++) {
			int testCase = sc.nextInt();
			
			Queue<Integer> queue = new ArrayDeque<>();
			
			for(int i = 0; i < 8; i++) {
				queue.add(sc.nextInt());
			}
			
			int cnt = 1;
			while(true) {
				if(queue.peek()-cnt <= 0) {
					queue.add(queue.poll()-cnt <= 0 ? 0: queue.poll()-cnt);
					break;
				}
				
				queue.add(queue.poll()-cnt);
				if(++cnt > 5) {
					cnt = 1;
				}
			}
			System.out.print("#" + testCase + " ");
			for(int q: queue) {
				System.out.print( q + " ");
			}
			System.out.println();
		}
	}
}