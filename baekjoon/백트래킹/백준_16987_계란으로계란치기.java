package 백트래킹;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 1. 제일 왼쪽 계란 들기
 * 2. 깨지지 않은 계란 중에서 하나 치기
 * 	2-1. 손에 든 계란이 깨져있음 or 깨지지 않은 계란이 없는 경우,
 * 		 가장 최근에 든 계란의 한 칸 오른쪽 계란을 들고 다시 2번으로!
 * 			만약 가장 최근에 든 계란이 마지막 계란이면 계란 치기 종료
 * 
 *https://4ngeunlee.tistory.com/402
 */

// 아직도 어려운 dfs..;;
public class 백준_16987_계란으로계란치기 {
	
	private static class Egg {
		int durability; // 내구도
		int weight; // 무게
		
		@Override
		public String toString() {
			return "계란 [내구도=" + durability + ", 무게=" + weight + "]";
		}

		public Egg(int durability, int weight) {
			this.durability = durability;
			this.weight = weight;
		}

	
	}
	
	static Egg[] eggs;
	static int max; // 최대로 깨진 계란 수
	static int N; // 계란 개수
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		 
		N = Integer.parseInt(br.readLine());
		
		eggs = new Egg[N];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			
			int durability = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			
			eggs[i] = new Egg(durability, weight);
		}
		
		max = 0;
		
		dfs(0,0);
		
		System.out.println(max);
		
	}
	
	/**
	 * 
	 * @param handIdx : 손에 든 계란 인덱스
	 * @param breakCnt : 여태까지 깬 계란 개수
	 */
	public static void dfs(int handIdx, int breakCnt) {
		
		max = Math.max(max,breakCnt);
		
		// 가장 최근에 손에 든 계란이 마지막 계란인 경우 종료
		if(handIdx == N) return;
		
//		System.out.println(Arrays.toString(eggs));
//		System.out.println("손에 든 계란 " + eggs[handIdx] + " 깬 계란 수" + breakCnt);
		
		// 손에 든 계란이 깨져있는 경우, 한 칸 오른쪽 계란을 손에 들고 ㄱㄱ
		if(eggs[handIdx].durability <= 0) {
			dfs(handIdx+1, breakCnt);
			return;
		}
		
		for(int i = 0; i < N; i++) {
			// 지금 내가 들고 있는 계란이 아니고
			// 계란의 내구성이 0보다 큰 경우
			
			if(handIdx != i && eggs[i].durability > 0) {
				// 계란 깨보기!
				int cnt = hitting(handIdx, i); // 깨진 계란 개수
				dfs(handIdx + 1, breakCnt + cnt);
			
				// 계란 깨지기 전으로 돌리기
				backtracking(handIdx, i);
			}
		}
		
	}
	
	/**
	 * 계란 2개 중에 깨진 개수 세기
	 * @param eggIdx1
	 * @param eggIdx2
	 * @return
	 */
	public static int hitting(int egg1Idx, int egg2Idx) {
		int cnt = 0;
		
		eggs[egg1Idx].durability -= eggs[egg2Idx].weight;
		eggs[egg2Idx].durability -= eggs[egg1Idx].weight;
		
		if(eggs[egg1Idx].durability <= 0) {
			cnt++;
		}
		
		if(eggs[egg2Idx].durability <= 0) {
			cnt++;
		}
		
		return cnt;
		
	}
	
	/**
	 * 다시 계란 깨지기 전 상태로 돌리기
	 * @param egg1Idx
	 * @param egg2Idx
	 */
	public static void backtracking(int egg1Idx, int egg2Idx) {
		eggs[egg1Idx].durability += eggs[egg2Idx].weight;
		eggs[egg2Idx].durability += eggs[egg1Idx].weight;
		
	}
}
