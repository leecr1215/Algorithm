import java.util.Arrays;
import java.util.Scanner;

public class 백준_1654_랜선자르기 {
	static int K;
	static int N;
	static long[] cables;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		K = sc.nextInt(); // 가지고 있는 랜선의 개수
		N = sc.nextInt(); // 필요한 랜선의 개수

		cables = new long[K];

		for (int i = 0; i < K; i++) {
			cables[i] = sc.nextLong();
		}

		Arrays.sort(cables);

		System.out.println(binarySearch());
	}

	private static long binarySearch() {
		long start = 1;
		long end = cables[K-1];
		long result = 0;
		
		while(start <= end) {
			long mid = (start + end) / 2;
			
			int cableSum = 0;
			for(int i = 0; i < K; i++) {
				cableSum += cables[i] / mid;
			}
			
			if(cableSum >= N) { // 원하는 애보다 더 많이 케이블 나옴
				start = mid + 1;
				result = mid;
			}else if(cableSum < N) { // 원하는 애보다 더 적게 케이블 나옴
				end = mid - 1;
			}
		}
		
		
		return result;
	}

	
}
