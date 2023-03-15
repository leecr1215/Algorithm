package level3;

import java.util.Arrays;
import java.util.PriorityQueue;

public class 디스크컨트롤러 {
    public static void main(String[] args) {
        System.out.println(solution(new int[][]{{0,3},{1,9},{2,6}}));
    }
    public static int solution(int[][] jobs) {
        // job은 [작업 요청 시점, 작업 소요시간]
        // 요청 시간 오름차순으로 정렬
        Arrays.sort(jobs, (a,b)->a[0]-b[0]);
        
        // queue에 [작업 요청 시점, 작업 소요시간] 저장
        // 작업이 빨리 끝나는 job 먼저 선택
        PriorityQueue<int[]> queue = new PriorityQueue<>((a,b)->a[1] - b[1]);

        
        int time = 0; // 걸린 시간
        int endTime = 0; // 끝난 시점
        int jobCount = 0; // 수행 완료 된 job 개수
        int idx = 0; // 큐에 들어간 jobs 배열 인덱스
        
        while(jobCount < jobs.length){

            // 끝난 시점보다 요청 시점이 빠른 애들을 큐에 넣음
            while(idx < jobs.length && jobs[idx][0] <= endTime){
                    queue.add(jobs[idx]);
                    idx++;
            }
            

            if(!queue.isEmpty()){
                int[] job = queue.poll();            

                // 끝난시간 > 시작시간
                time += job[1] + endTime-job[0];
                endTime += job[1];
                jobCount++;
                
            }else{
                // 작업 아예 다 끝나고 나서 다른 요청이 들어온다
                // 끝난 시점을 다음 요청의 처음으로 맞추어줌
                endTime = jobs[idx][0];
            }

        }

        return (int) Math.floor(time / jobs.length);
    }

}
