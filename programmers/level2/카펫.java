package level2;

import java.util.Arrays;

public class 카펫 {
    public static void main(String[] args) {
        int[] answer1 = solution(10,2);
        int[] answer2 = solution(8,1);
        int[] answer3 = solution(24,24);
        System.out.println(Arrays.toString(answer1));
        System.out.println(Arrays.toString(answer2));
        System.out.println(Arrays.toString(answer3));
    }
    public static int[] solution(int brown, int yellow) {
        int[] answer = new int[2];

        int count = brown + yellow;
        for(int i = 1; i <= (int)Math.round(count/2); i++){
            if(count % i != 0) continue;
            int y = count / i;
            if(y*2 + i*2 - 4 == brown){
                answer[0] = Math.max(y, i);
                answer[1] = Math.min(y, i);
            }
        }

        return answer;
    }
}
