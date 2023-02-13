import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 백준_1158_요세푸스_문제 {
    public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt(); // N명
		int K = sc.nextInt(); // K번째

		Queue<Integer> queue = new LinkedList<>();
		for(int i = 1; i <= N; i++) {
			queue.add(i);
		}
		
		System.out.print("<");
		while(!queue.isEmpty()) {
			for(int i = 1; i < K; i++) {
				queue.add(queue.poll());
			}
			if(queue.size() == 1) {
				System.out.print(queue.poll());
			}else {
				System.out.print(queue.poll() + ", ");
			}
		}
		System.out.print(">");
	}
}
