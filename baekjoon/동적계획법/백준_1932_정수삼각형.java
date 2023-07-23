package 동적계획법;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 백준_1932_정수삼각형 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		int[][] triangle = new int[n][n];
		
		for(int i = 0; i < n; i++) {
			String temp[] = br.readLine().split(" ");
			
			for(int j = 0; j < temp.length; j++) {
				triangle[i][j] = Integer.parseInt(temp[j]);
			}
		}
		
		for(int i = 1; i < n; i++) {
			for(int j = 0; j < n; j++) {
				if(j==0) {
					triangle[i][j] += triangle[i-1][j];
				}else {
					triangle[i][j] = Math.max(triangle[i][j] + triangle[i-1][j-1], triangle[i][j] + triangle[i-1][j]);
				}
			}
		}
		
		// 마지막 줄에서 최댓값 찾기
		int max = 0;
		
		for(int i = 0; i < n; i++) {
			if(max < triangle[n-1][i]) {
				max = triangle[n-1][i];
			}
		}
		
		System.out.println(max);
		
	}
}
