package 브루트포스;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 블랙잭 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine() ," ");
		
		int N = Integer.parseInt(st.nextToken());	// 카드 개수
		int M = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine(), " ");
		
		int[] ss = new int[N];
		
		for(int i = 0; i < N; i++) {
			ss[i] = Integer.parseInt(st.nextToken());
		}
			
		
		// 브루트 포스
		int max = 0;
		int temp = 0;
		for(int i = 0; i < N; i++) {
			if(ss[i] > M) {
				continue;
			}
			for(int j = i+1; j < N; j++) {
				if(ss[i] + ss[j] > M) {
					continue;
				}
				for(int k = j+1; k < N; k++) {
					temp = ss[i] + ss[j] + ss[k];
					
					if(temp > max && temp <= M) {
						max = temp;
					}		
				}
			}
		}
		
		System.out.println(max);
	}
}
