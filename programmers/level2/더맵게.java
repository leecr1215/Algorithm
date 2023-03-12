package level2;

import java.util.PriorityQueue;

public class 더맵게 {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{1,2,3,9,10,12}, 7));
        System.out.println(solution(new int[]{1,2,3,9,10,12}, 100));
        System.out.println(solution(new int[]{1,1}, 3));
    }
    public static int solution(int[] scoville, int K) {
        int answer = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int s : scoville){
            pq.add(s);
        }

        while(true){
            if(pq.peek() >= K) {
                return answer;
            }else if(pq.size() == 1) break;

            if(pq.size() == 1) break;

            int first = pq.poll();
            int second = pq.poll();

            pq.add(first + second*2);

            answer++;
        }
        return -1;
    }
}
