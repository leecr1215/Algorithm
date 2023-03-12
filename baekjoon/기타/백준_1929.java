package 기타;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 백준_1929 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] input = br.readLine().split(" ");
		int M = Integer.parseInt(input[0]);
		int N = Integer.parseInt(input[1]);
		
		int[] arr = new int[N+1];
		// 소수가 아니면 0으로 변경
		arr[0] = 0;
		arr[1] = 0;
		
		for(int i = 2; i <=N; i++) {
			arr[i] = 1;
		}
		
		for(int i = 2; i <=N; i++) {
			if(arr[i]==0) continue;
			
			for(int j = i*2; j <= N; j+=i) {
				arr[j] = 0;
			}
		}
		int start = Math.max(2, M);
		for(int i = start; i<=N; i++) {
			if(arr[i] == 1) {
				System.out.println(i);
			}
		}
		
	}
}
