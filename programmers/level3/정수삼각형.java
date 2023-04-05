package level3;

public class 정수삼각형 {
	public static void main(String[] args) {
		int[][] triangle = { { 7 }, { 3, 8 }, { 8, 1, 0 }, { 2, 7, 4, 4 }, { 4, 5, 2, 6, 5 } };

		System.out.println(solution(triangle));
	}

	public static int[][] copy(int[][] src) {
		
		int[][] copy = new int[src.length][];
		for (int i = 0; i < src.length; i++) {
			copy[i] = src[i].clone();
		}

		return copy;
	}

	public static int solution(int[][] triangle) {
		int[][] copy = copy(triangle);

		for (int i = 0; i < triangle.length - 1; i++) {

			for (int j = 0; j < triangle[i].length; j++) {
				triangle[i + 1][j] = Math.max(triangle[i + 1][j], copy[i + 1][j] + triangle[i][j]);
				triangle[i + 1][j + 1] = Math.max(triangle[i + 1][j + 1], copy[i + 1][j + 1] + triangle[i][j]);
			}
		}

		// triangle 출력해보기
//		for(int i = 0; i < triangle.length; i++) {
//			System.out.println(Arrays.toString(triangle[i]));
//		}

		// 마지막 줄에서 최댓값 찾기
		int max = 0;
		for (int i = 0; i < triangle[triangle.length - 1].length; i++) {
			if (max < triangle[triangle.length - 1][i]) {
				max = triangle[triangle.length - 1][i];
			}
		}

		return max;
	}
}