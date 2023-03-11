package 문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 백준_12891_DNA_비밀번호 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int S = Integer.parseInt(st.nextToken()); // 문자열 길이
		int P = Integer.parseInt(st.nextToken()); // 부분문자열 길이

		String DNAStr = br.readLine();

		int[] ACGT = new int[4];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 4; i++) {
			ACGT[i] = Integer.parseInt(st.nextToken());
		}

		int count = 0;

		// 일단 p개의 문자는 ACGT에서 빼고 (첫번째 부분 문자열 확인)
		// 확인하고
		// ACGT 에 있는 애들이 0 이하면 count++ 해주기

		for (int i = 0; i < P; i++) {
			char DNA = DNAStr.charAt(i);
			if (DNA == 'A') {
				ACGT[0] -= 1;
			} else if (DNA == 'C') {
				ACGT[1] -= 1;
			} else if (DNA == 'G') {
				ACGT[2] -= 1;
			} else if (DNA == 'T') {
				ACGT[3] -= 1;
			}
		}

		boolean check = true;

		for (int j = 0; j < 4; j++) {
			if (ACGT[j] > 0) {
				check = false;
				break;
			}
		}

		if (check) {
			count++;
		}

		// p개 이후로는 하나씩 확인
		// i-P번째 있는 애의 ACGT 위치는 하나 더해주고
		// i번째 있는 애는 ACGT에서 하나 빼주고
		// 확인해서 ACGT 에 있는 애들이 다 0 이하면 count++
		for (int i = P; i < DNAStr.length(); i++) {
			char addDNA = DNAStr.charAt(i-P);
			if (addDNA == 'A') {
				ACGT[0] += 1;
			} else if (addDNA == 'C') {
				ACGT[1] += 1;
			} else if (addDNA == 'G') {
				ACGT[2] += 1;
			} else if (addDNA == 'T') {
				ACGT[3] += 1;
			}
			
			
			char subDNA = DNAStr.charAt(i);
			if (subDNA == 'A') {
				ACGT[0] -= 1;
			} else if (subDNA == 'C') {
				ACGT[1] -= 1;
			} else if (subDNA == 'G') {
				ACGT[2] -= 1;
			} else if (subDNA == 'T') {
				ACGT[3] -= 1;
			}

			
			check = true;
			for (int j = 0; j < 4; j++) {
				if (ACGT[j] > 0) {
					check = false;
					break;
				}
			}
			if (check) {
				count++;
			}
		}
		
		System.out.println(count);

	}
}