package 정수론및조합론;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 백준_13241_최소공배수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());

        long result = getGCD(B,A);
        System.out.println(A*B / result);

    }

    public static long getGCD (long a, long b){
        if(b==0){
            return a;
        }else{
            return getGCD(b, a%b);
        }
        
    }
}