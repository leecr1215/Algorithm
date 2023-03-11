package level1;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class 기능개발 {
	public static void main(String[] args) {
		System.out.println(solution(new int[] { 93, 30, 55 }, new int[] { 1, 30, 5 }));
		System.out.println(solution(new int[] { 95, 90, 99, 99, 80, 99 }, new int[] { 1, 1, 1, 1, 1, 1 }));
	}

	public static int[] solution(int[] progresses, int[] speeds) {
		List<Integer> answer = new ArrayList<>();
		
		// 걸리는 일수 저장
		Queue<Integer> queue = new ArrayDeque<>();
		
		for(int i = 0; i < progresses.length; i++) {
			queue.add((int)Math.ceil((double)(100-progresses[i])/speeds[i]));
		}
		
		int firstWork = queue.poll(); // 첫번째 일이 걸리는 일수 
		int works = 1; // 같은 날 배포되는 일들의 수
		for(int i = 1; i < progresses.length; i++) {
			int nextWork = queue.poll();
			if(firstWork >= nextWork) {
				works++;
			}else {
				// 따로 넣어주어야함
				answer.add(works);
				works = 1;
				firstWork = nextWork;
			}
		}
		
		answer.add(works);
		return answer.stream().mapToInt(Integer::intValue).toArray();
	}
}
