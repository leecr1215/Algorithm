package 동적계획법;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 백준_1495_기타리스트 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int v[] = new int[N];
        boolean dp[][] = new boolean[101][1001]; // 노래를 시작할 때 해당 볼륨이 가능하면 true

        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < N; i++){
            v[i] = Integer.parseInt(st.nextToken());
        }

        dp[0][S] = true;

        int ans = -1;

        for(int i = 1; i <= N; i++){
            for(int j = 0; j <= M; j++){
                if(!dp[i-1][j]){
                    continue;
                }

                if(j - v[i-1] >= 0){
                    dp[i][j - v[i-1]] = true;
                }

                if(j + v[i-1] <= M){
                    dp[i][j + v[i-1]] = true;
                }
            }
        }

        for(int i = 0; i <= M; i++){
            if(dp[N][i] && i > ans){
                ans = i;
            }
        }

        System.out.println(ans);


    }
}
