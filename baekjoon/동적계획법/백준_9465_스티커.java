package 동적계획법;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 백준_9465_스티커 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 0; t < T; t++) {
			int n = Integer.parseInt(br.readLine());
			
			int[][] stickers = new int[2][n];
			
			for(int i = 0; i < 2; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < n; j++) {
					stickers[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			
			
			for(int i = 1; i < n; i++) {
				if(i==1) {
					// i가  1일때??
					stickers[0][1] += stickers[1][0];
					stickers[1][1] += stickers[0][0];
				}else {					
					stickers[0][i] += Math.max(stickers[1][i-1], stickers[1][i-2]);
					stickers[1][i] += Math.max(stickers[0][i-1], stickers[0][i-2]);
				}
			}
			
			
//			for(int i = 0; i < 2; i++) {
//				for(int j = 0; j < n; j++) {
//					System.out.print(stickers[i][j] + " ");
//				}
//				System.out.println();
//			}
			
			System.out.println(Math.max(stickers[0][n-1], stickers[1][n-1]));
			
		}
		
	}
}