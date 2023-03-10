package 구현;

import java.util.Arrays;
import java.util.Scanner;

public class 백준_1244_스위치_켜고_끄기 {
	static int[] switches;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		switches = new int[N];

		for (int i = 0; i < N; i++) {
			switches[i] = sc.nextInt();
		}

		int studentNum = sc.nextInt();

		for (int i = 0; i < studentNum; i++) {
			int gender = sc.nextInt();
			int num = sc.nextInt();

			if (gender == 1) { // 남자
				for (int j = 0; j < N; j++) {
					if ((j + 1) % num == 0) {
						toggle(j);
					}
				}
			} else { // 여자
				// 처음 스위치 번호 시작은 num-1임. -> 스위치 배열 맵핑
				switches[num - 1] = switches[num - 1] == 0 ? 1 : 0;

				int left = num - 1;
				int right = num - 1;
				while (left > 0 && right < N-1) {
					left--;
					right++;
					if (switches[left] == switches[right]) {
						toggle(left);
						toggle(right);
					}else {
						break;
					}
				}

			}
		}
		for (int i = 1; i <= switches.length; i++) {
			System.out.print(switches[i-1] + " ");
			if (i % 20 == 0) {
				System.out.println();
			}
		}

	}

	private static void toggle(int idx) {
		switches[idx] = switches[idx] == 0 ? 1 : 0;
	}
}