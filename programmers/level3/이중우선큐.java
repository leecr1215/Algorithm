package level3;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class 이중우선큐 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new String[]{"I 16", "I -5643", "D -1", "D 1", "D 1", "I 123", "D -1"})));
        System.out.println(Arrays.toString(solution(new String[]{"I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"})));
    }
    public static int[] solution(String[] operations) {
        PriorityQueue<Integer> maxQueue = new PriorityQueue<>(Collections.reverseOrder()); // 큰 값이 맨 앞으로
        PriorityQueue<Integer> minQueue = new PriorityQueue<>(); // 작은 값이 맨 앞으로
        
        for(int i = 0; i < operations.length; i++){
            String[] arr = operations[i].split(" ");
            if(arr[0].equals("I")){
                // 큐에 추가
                maxQueue.offer(Integer.parseInt(arr[1]));
                minQueue.offer(Integer.parseInt(arr[1]));
            }else{
                // 큐에서 삭제
                if(!maxQueue.isEmpty()){
                    if(arr[1].equals("1")){
                        // 최댓값 삭제
                        minQueue.remove(maxQueue.poll());
                    }else {
                        // 최솟값 삭제
                        maxQueue.remove(minQueue.poll());
                    }
                }
            }
        }
        if(minQueue.isEmpty()){
            return new int[]{0,0};
        }else{
            return new int[]{maxQueue.poll(), minQueue.poll()};
        }
        
    }
}
