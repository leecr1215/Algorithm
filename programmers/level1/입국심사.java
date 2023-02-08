import java.util.Arrays;

public class 입국심사 {
	public static void main(String[] args) {
		System.out.println(solution(6, new int[] { 7, 10 }));
	}

	public static long solution(int n, int[] times) {
        long answer = 0;
        
		// n은 targetPeople
		// right: 제일 오래걸리는 최악의 시간
		Arrays.sort(times);
		long left = 0;
		long right = times[times.length - 1] * (long) n;

		while (left <= right) {
			long middle = (left + right) / 2;

			// mid 시간안에 검사 가능한 사람 수
			long people = 0;

			// middle 시간안에 각 심사대에서 검사할 수 있는 사람 수 구하기
			for (int time : times) {
				people += middle / time;
			}
            
			if (people < n) {
				// mid 시간안에 검사할 수 있는 사람이 n명 보다 적음
				left = middle + 1;
			} else {
                // mid 시간안에 검사할 수 있는 사람이 n명 이상임.
				right = middle - 1;
                answer = middle;
			}

		}

		return answer;
	}
}
