package 백트래킹;

import java.util.Scanner;

public class 백준_2961_도영이가_만든_맛있는_음식 {
	static int N; // 재료의 개수
	static Ingredient[] ingredients;
	static long min = 1000000000; // 신맛 - 쓴맛
	static boolean[] visited;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();

		ingredients = new Ingredient[N];
		visited = new boolean[N];

		for (int i = 0; i < N; i++) {
			long sour = sc.nextLong(); // 신맛
			long bitter = sc.nextLong(); // 쓴맛
			ingredients[i] = new Ingredient(sour, bitter);
		}
		// 재료는 최소 하나 이상 사용해야함
		// 부분집합
		subSet(0);
		
		System.out.println(min);
	}

	/**
	 * 
	 * @param cnt
	 */
	private static void subSet(int cnt) {
		if (cnt == N) {
			long sSum = 1;
			long bSum = 0;
			boolean check = false;
			for (int i = 0; i < N; i++) {
				if (visited[i] == true) {
					check = true;
					sSum *= ingredients[i].sour;
					bSum += ingredients[i].bitter;
				}
			}
			if (!check) return;

			min = Math.min(min, Math.abs(sSum - bSum));
			return;
		}

		// 현재 원소를 포함
		visited[cnt] = true;
		subSet(cnt + 1);

		// 현재 원소를 포함하지 않는 경우
		visited[cnt] = false;
		subSet(cnt + 1);

	}

}

class Ingredient {
	long sour;
	long bitter;

	public Ingredient(long sour, long bitter) {
		this.sour = sour;
		this.bitter = bitter;
	}
}