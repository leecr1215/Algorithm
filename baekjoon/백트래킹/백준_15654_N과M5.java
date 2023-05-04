package 백트래킹;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// N개 중에 M개 뽑기
public class 백준_15654_N과M5 {
	
	static int N, M;
	static int[] arr;
	static int[] picked;
	static boolean[] visited;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[N];
		picked = new int[M];
		visited = new boolean[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		permutation(0);
		
	}
	
	private static void permutation(int cnt) {
		if (cnt == M) {
			for(int i = 0; i < M; i++) {
				System.out.print(picked[i] + " ");
			}
			System.out.println();
			return;
		}

		for (int i = 0; i < N; i++) {
			if (visited[i]) continue;
			picked[cnt] = arr[i];
			
			visited[i] = true;
			permutation(cnt + 1);
			visited[i] = false;
		}
	}
}