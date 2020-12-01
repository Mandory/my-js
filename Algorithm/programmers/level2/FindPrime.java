package level2;

import java.util.HashSet;
import java.util.Set;

public class FindPrime {

	public static Set<Integer> set;

	public static void perm(char[] arr, int depth, int n, int r) {
		if (depth == r) {
			add(arr, r);
			return;
		}

		for (int i = depth; i < n; i++) {
			swap(arr, depth, i);
			perm(arr, depth + 1, n, r);
			swap(arr, depth, i);
		}
	}

	public static void swap(char[] arr, int depth, int i) {
		char temp = arr[depth];
		arr[depth] = arr[i];
		arr[i] = temp;
	}

	public static void add(char[] arr, int r) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < r; i++) {
			sb.append(arr[i]);
		}
		int num = Integer.parseInt(sb.toString());
		set.add(num);
	}

	public static int findPrime() {
		int count = 0;
		for (int i : set) {
			if (isPrime(i)) {
				count += 1;
			}
		}
		return count;
	}

	public static boolean isPrime(int n) {
		if (n == 2) {
			return true;
		}

		if (n % 2 == 0 || n == 1) {
			return false;
		}

		for (int i = 3; i <= (int) Math.sqrt(n); i += 2) {
			if (n % i == 0) {
				return false;
			}
		}
		return true;
	}

	public static int solution(String numbers) {
		set = new HashSet<Integer>();
		char[] arr = numbers.toCharArray();

		for (int i = 1; i <= arr.length; i++) {
			perm(arr, 0, arr.length, i);
		}

		return findPrime();
	}

	public static void main(String[] args) {
		System.out.println(solution("17"));
		System.out.println(solution("011"));
	}
}
