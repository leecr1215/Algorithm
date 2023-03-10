package 분할정복;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 백준_1074_Z {
	static int cnt;
	static int r, c, N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());

		divideConquer(0, 0, (int) Math.pow(2, N));
		System.out.println(cnt);
	}

	/**
	 * 현재 구역의 
	 * @param x    : 좌상단 행
	 * @param y    : 좌상단 열
	 * @param size : 한 변의 길이
	 */
	private static void divideConquer(int x, int y, int size) {
		if (size == 1) return;
		

		int half = size / 2;
		
		// 찾는 값이 2사분면에 있다
		// target의 행 값이 size / 2 보다 작고
		// target의 열 값이 size / 2 보다 작을 때
		if(r < x + half && c < y + half) {
			divideConquer(x, y, half); // 왼쪽 위
		}
		
		// 찾는 값이 1사분면에 있다.
		// target의 행 값이 size / 2보다 작고
		// target의 열 값이 size / 2 이상일 때
		else if(r < x + half && c >= y + half) {
			cnt += (size * size) / 4; // 2사분면세어주기
			divideConquer(x, y + half, half); // 오른쪽 위
		}
		
		// 찾는 값이 3사분면에 있다.
		// target의 행 값이 size / 2 이상이고
		// target의 열 값이 size / 2 보다 작을 때
		else if(r >= x + half && c < y + half) {
			cnt += ((size * size) / 4) * 2; // 2사분면 & 1사분면 세기
			divideConquer(x + half, y, half); // 왼쪽 아래			
		}
		
		// 찾는 값이 4사분면에 있다.
		// target의 행 값이 size / 2 이상이고
		// target의 열 값이 size / 2 이상일 때
		else if(r >= x + half && c >= y + half) {
			cnt += ((size * size) / 4) * 3; // 2사분면 & 1사분면 & 3사분면 세기
			divideConquer(x + half, y + half, half); // 오른쪽 아래			
		}

	}
}