import java.util.Arrays;

public class H_Index {
    public static int solution(int[] citations) {
		int answer = 0;
		
		Arrays.sort(citations);
		
		// 논문 개수만큼 돌면서
		// 논문의 인용수 >= h 면 다시 지정
		for(int i = 0; i < citations.length; i++) {
			if(citations[i] >= citations.length - i) {
				answer = citations.length - i;
                break;
			}
		}
		
		return answer;
	}

    public static void main(String[] args) {
        System.out.println(solution(new int[]{3,0,6,1,5}));
    }
}
