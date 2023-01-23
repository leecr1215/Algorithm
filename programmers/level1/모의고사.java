import java.util.ArrayList;
import java.util.Arrays;
import java.io.*;

public class 모의고사 {
    public static void main(String[] args) {
        int[] answers = {1,2,3,4,5};
        int[] answer = solution(answers);
        System.out.println(Arrays.toString(answer));
    }
    public static int[] solution(int[] answers) {

        int count1 = 0; // 1번 수포자가 맞힌 문제의 개수
        int count2 = 0; // 2번 수포자가 맞힌 문제의 개수
        int count3 = 0; // 3번 수포자가 맞힌 문제의 개수
        
        int[] arr1 = {1,2,3,4,5}; // 반복되는 1번 수포자가 찍는 번호
        int[] arr2 = {2,1,2,3,2,4,2,5}; // 반복되는 2번 수포자가 찍는 번호
        int[] arr3 = {3,3,1,1,2,2,4,4,5,5}; // 반복되는 3번 수포자가 찍는 번호
        
        for(int i = 0; i < answers.length; i++){
            // 1번 수포자 확인
            if(answers[i] == arr1[i%5]) {
                count1++;
            }

            // 2번 수포자 확인
            if(answers[i] == arr2[i%8]){
                count2++;
            }

            // 3번 수포자 확인
            if(answers[i] == arr3[i%10]){
                count3++;
            }
        }
        ArrayList<Integer> list = new ArrayList<>();
       
        int max = Math.max(count1, Math.max(count2, count3)); // 맞은 개수의 최대값

        if(max == count1){
            list.add(1);
        }
        if(max == count2){
            list.add(2);
        }
        if(max == count3){
            list.add(3);
        }

        int[] answer = new int[list.size()];

        for(int i = 0; i < list.size(); i++){
            answer[i] = list.get(i);
        }

        return answer;
    }
}
