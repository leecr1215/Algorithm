package 슬라이딩윈도우;

import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.IOException;

public class 백준_21921_블로그 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());

		int[] people = new int[N];
		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; i++) {
			people[i] = Integer.parseInt(st.nextToken());
		}

		// 초기값
		int sum = 0;
        for (int i = 0; i < X; i++) {
        	sum += people[i];
        }

        int max = sum;
        int maxCnt = 1;
        for (int end = X; end < N; end++) {
            sum += people[end] - people[end-X];
            if (max == sum) {
            	maxCnt++;
            }
            else if (max < sum) {
                max = sum;
                maxCnt = 1;
            }
        }

		
		if(max == 0) {
			System.out.println("SAD");
		}else {			
			System.out.println(max);
			System.out.println(maxCnt);
		}
//		System.out.println(Arrays.toString(list.toArray()));
	}
}