package 백트래킹;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.Stack;
import java.util.StringTokenizer;

// N개 중 M개 고르기
// 순열
public class 백준_15663_N과M9 {
    static int N, M;
    static boolean[] visited;
    static Integer[] arr;
    static int[] picked;
    static Set<String> set = new LinkedHashSet<>();

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        visited = new boolean[N];
        picked = new int[M];
        arr = new Integer[N];

        st = new StringTokenizer(br.readLine());
        
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
       
        Arrays.sort(arr);

        permutation(0);

        for(String str : set){
            System.out.println(str);
        }
    }

    private static void permutation(int cnt){
        if(cnt == M){
            StringBuilder sb = new StringBuilder();
            for(int p : picked){
                sb.append(p).append(' ');
            }
            set.add(sb.toString());
            return;
        }

        for(int i = 0; i < arr.length; i++){
            if(visited[i]) continue;

            picked[cnt] = arr[i];
            visited[i] = true;

            permutation(cnt+1);

            visited[i] = false;

        }
    }

    
}