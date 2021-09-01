package algo.study.boj.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// BOJ 2941. 크로아티아 알파벳
public class BOJ_2941 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		char c;
		int cnt = 0;

		for (int i = 0; i < str.length(); i++) {
			c = str.charAt(i);
			if (c == 'c') {
				if (i + 1 < str.length() && (str.charAt(i + 1) == '=' || str.charAt(i + 1) == '-')) {
					cnt++;
					i++;
					continue;
				}
			} else if (c == 'd') {
				if (i + 1 < str.length()) {
					if (str.charAt(i + 1) == 'z') {
						if (i + 2 < str.length() && str.charAt(i + 2) == '=') {
							i = i + 2;
							cnt++;
							continue;
						}
					} else if (str.charAt(i + 1) == '-') {
						i = i + 1;
						cnt++;
						continue;
					}
				}
			} else if (c == 'l') {
				if (i + 1 < str.length()) {
					if (str.charAt(i + 1) == 'j') {
						i++;
						cnt++;
						continue;
					}
				}
			} else if (c == 'n') {
				if (i + 1 < str.length()) {
					if (str.charAt(i + 1) == 'j') {
						i++;
						cnt++;
						continue;
					}
				}
			} else if (c == 's') {
				if (i + 1 < str.length()) {
					if (str.charAt(i + 1) == '=') {
						i++;
						cnt++;
						continue;
					}
				}
			} else if (c == 'z') {
				if (i + 1 < str.length()) {
					if (str.charAt(i + 1) == '=') {
						i++;
						cnt++;
						continue;
					}
				}
			}
			cnt++;

		}
		System.out.println(cnt);
	}

}
