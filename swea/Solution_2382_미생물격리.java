import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class Solution_2382_미생물격리 {

	// 의미 없는 값, 상, 하, 좌, 우
	final static int[] dx = { 0, -1, 1, 0, 0 };
	final static int[] dy = { 0, 0, 0, -1, 1 };

	static class Swarm {
		int x;
		int y;
		int microNum; // 미생물 수
		int dir; // 상(1) 하(2) 좌(3) 우(4)

		public Swarm(int x, int y, int microNum, int dir) {
			this.x = x;
			this.y = y;
			this.microNum = microNum;
			this.dir = dir;
		}

		@Override
		public String toString() {
			return "Swarm [x=" + x + ", y=" + y + ", microNum=" + microNum + ", dir=" + dir + "]";
		}

	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());

			int N = Integer.parseInt(st.nextToken()); // 셀의 개수
			int M = Integer.parseInt(st.nextToken()); // 격리 시간
			int K = Integer.parseInt(st.nextToken()); // 군집의 개수

			List<Swarm> swarms = new ArrayList<>();

			// 군집 입력
			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());
				Swarm s = new Swarm(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
						Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
				swarms.add(s);
			}

//			for (int i = 0; i < N; i++) {
//				for (int j = 0; j < N; j++) {
//					System.out.print(temp[i][j].microNum + " ");
//				}
//				System.out.println();
//			}

			// M 분간..
			for (int time = 1; time <= M; time++) {
				/** 좌표 이동 **/
				for (int i = swarms.size() - 1; i >= 0; i--) {
					Swarm s = swarms.get(i);
					// 다음 좌표로 이동
					s.x += dx[s.dir];
					s.y += dy[s.dir];
					
					// 빨간약
					if (s.x <= 0 || s.x >= N - 1 || s.y <= 0 || s.y >= N - 1) {
						s.microNum /= 2;
						s.dir = s.dir % 2 == 0 ? s.dir -1 : s.dir + 1;
						
						// 미생물 수 없으면 제거
						if (s.microNum == 0) {
							swarms.remove(i);
						}
					}
				}
				
				// 내림차순 정렬
				Collections.sort(swarms, (a, b) -> b.microNum - a.microNum);
				
				// j를 i에 합치기
				for (int i = 0; i <= swarms.size(); i++) { // 얘가 미생물 젤 큰 애
					for (int j = swarms.size() - 1; j >= i + 1; j--) {
						if (swarms.get(i).x == swarms.get(j).x && swarms.get(i).y == swarms.get(j).y) {
							swarms.get(i).microNum += swarms.get(j).microNum;
							swarms.remove(j);
						}
					}
				}
			}

			/** 이동 후 좌표가 같은 군집이 있는지 확인 **/

			// M분후 미생물의 총합

			System.out.println("#" + t + " " + swarms.stream().mapToInt(s -> s.microNum).sum());
		}
	}
}
