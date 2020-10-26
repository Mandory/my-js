package string;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Palindrome_1259 {
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		while (true) {
			String s = br.readLine();
			if (s.equals("0")) {
				break;
			}

			char[] arr = s.toCharArray();
			boolean isPalindrome = true;
			if (s.length() % 2 == 0) {
				int mid = s.length() / 2;
				for (int i = 0; i < mid; i++) {
					if (arr[mid + i] != arr[mid + i - ((i * 2) + 1)]) {
						isPalindrome = false;
						break;
					}
				}
			} else {
				int mid = s.length() / 2;
				for (int i = 1; i <= mid; i++) {
					if (arr[mid - i] != arr[mid + i]) {
						isPalindrome = false;
						break;
					}
				}
			}
			
			System.out.println(isPalindrome ? "yes" : "no");
		}

		br.close();
	}
}
