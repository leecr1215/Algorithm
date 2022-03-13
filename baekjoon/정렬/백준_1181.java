import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.*;

public class 백준_1181 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		ArrayList<String> arr = new ArrayList<>();

		int N = Integer.parseInt(br.readLine());

		for (int i = 0; i < N; i++) {
			arr.add(br.readLine());
		}
		
		Collections.sort(arr, new Comparator<String>() {
			@Override
			public int compare(String s1, String s2) {
				if (s1.length() == s2.length()) {
					return s1.compareTo(s2);
				} else {
					return  s1.length() - s2.length();
				}
	
			}
			});
		for (int i = 0; i < N; i++) {
			System.out.println(arr.get(i));
		}

	}
}
