package 정수론및조합론;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 백준_11051_실패 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
        String[] arr = br.readLine().split(" ");
        int N = Integer.parseInt(arr[0]);
        int K = Integer.parseInt(arr[1]);
        
        int[] nk = new int[N+1];
        nk[1] = N;

        for(int i = 2; i <= K; i++){
            nk[i] = nk[i-1] * ((N-i+1)/(i));
        }
        System.out.println(nk[K]%10007);
    }
}
