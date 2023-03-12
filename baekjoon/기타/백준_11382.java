package 기타;

import java.io.*;
import java.util.StringTokenizer;

public class 백준_11382 {
    public static void main(String[] args) throws IOException{  
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long sum = Long.parseLong(st.nextToken()) + Long.parseLong(st.nextToken()) + Long.parseLong(st.nextToken());
        System.out.println(sum);
    }
}