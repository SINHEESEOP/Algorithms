package backjun;

import java.io.*;
import java.util.*;

public class 단어정렬 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		Set<String> wordSet = new HashSet<>();

		for (int i = 0; i < N; i++) {
			wordSet.add(br.readLine());
		}

		List<String> words = new ArrayList<>(wordSet);

		// 사전 순 정렬
		Collections.sort(words);
		// 길이 기준 정렬 (안정 정렬 유지)
		Collections.sort(words, new Comparator<String>() {
			public int compare(String s1, String s2) {
				return Integer.compare(s1.length(), s2.length());
			}
		});


		// 출력
		StringBuilder sb = new StringBuilder();
		for (String word : words) {
			sb.append(word).append('\n');
		}
		System.out.print(sb.toString());
	}
}

