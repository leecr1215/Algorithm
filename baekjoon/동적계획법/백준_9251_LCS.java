package 동적계획법;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://velog.io/@emplam27/%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98-%EA%B7%B8%EB%A6%BC%EC%9C%BC%EB%A1%9C-%EC%95%8C%EC%95%84%EB%B3%B4%EB%8A%94-LCS-%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98-Longest-Common-Substring%EC%99%80-Longest-Common-Subsequence

public class 백준_9251_LCS {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
        String s1 = br.readLine();
        String s2 = br.readLine();

        int s1Len = s1.length();
        int s2Len = s2.length();
        
        int[][] arr = new int[s1Len+1][s2Len+1];

        for(int i = 0; i <= s1Len; i++){
            for(int j = 0; j <= s2Len; j++){
                if(i==0 || j==0) {
                    arr[i][j] = 0;
                }
                else if(s1.charAt(i-1)==s2.charAt(j-1)){
                    // 둘이 같은 문자일 때
                    arr[i][j] = arr[i-1][j-1] + 1;
                }
                else{
                    // 둘이 다른 문자일 때
                    arr[i][j] = Math.max(arr[i-1][j], arr[i][j-1]);
                }
            }
        }

        System.out.println(arr[s1Len][s2Len]);
    }
}
