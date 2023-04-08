package 백트래킹;

import java.util.Arrays;
import java.util.Scanner;

public class 백준_15652_N과M4 {
	
	static int N,M;
	static int[] picked;
	static int[] arr;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		
		picked = new int[M];
		
		arr = new int[N];
		for(int i = 1; i <= N; i++) {
			arr[i-1] = i;
		}
		
		duplicateCombination(0,0);
	}
	
	/**
	 * N개 중 M개 뽑는 중복조합
	 */
	private static void duplicateCombination(int start, int cnt) {
		if(cnt == M) {
			printArr();
			return;
		}
		
		for(int i = start; i < N; i++) {
			picked[cnt] = arr[i];
			duplicateCombination(i, cnt+1);
		}
		
	}
	
	/**
	 * picked 출력하는 함수
	 */
	private static void printArr() {
		for(int p : picked) {
			System.out.print(p + " ");
		}
		System.out.println();
	}
	

}