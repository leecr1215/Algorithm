import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 백준_1992_쿼드트리 {
	static String[][] map;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine()); // 영상의 크기
		map = new String[N][N];

		for (int i = 0; i < N; i++) {
			map[i] = br.readLine().split("");
		}

		divideConquer(0, 0, N);
		System.out.println(sb.toString());
	}

	/**
	 * 
	 * @param x     : 좌상단 x 좌표
	 * @param y     : 좌상단 y 좌표
	 * @param width : 한 변의 길이
	 */
	public static void divideConquer(int x, int y, int width) {
		int sum = 0;

		for (int i = x; i < x + width; i++) {
			for (int j = y; j < y + width; j++) {
				sum += Integer.parseInt(map[i][j]);
			}
		}

		if (sum == width * width) {
			// 모두 1인 경우
			sb.append("1");
		} else if (sum == 0) {
			// 모두 0인 경우
			sb.append("0");
		} else {
			// 0과 1이 혼합된 경우
			int half = width / 2;
			
			sb.append("(");
			divideConquer(x, y, half); // 왼쪽 위
			divideConquer(x, y + half, half); // 오른쪽 위
			divideConquer(x + half, y, half); // 왼쪽 아래
			divideConquer(x + half, y + half, half); // 오른쪽 아래
			sb.append(")");
			
		}
	}
}
