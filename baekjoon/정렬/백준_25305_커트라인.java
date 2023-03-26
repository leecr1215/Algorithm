package 정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 백준_25305_커트라인 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        Integer[] scores = new Integer[N];

        for(int i = 0; i < N; i++){
            scores[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(scores, (a,b)->b-a);

       System.out.println( scores[k-1]);
    }
}
