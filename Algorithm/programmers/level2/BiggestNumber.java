package level2;

import java.util.Arrays;
import java.util.Comparator;

public class BiggestNumber {

	public static String solution(int[] numbers) {
		String[] arr = new String[numbers.length];
		for (int i = 0; i < numbers.length; i++) {
			arr[i] = String.valueOf(numbers[i]);
		}

		Arrays.sort(arr, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return (o2 + o1).compareTo(o1 + o2);
			}
		});

		StringBuilder sb = new StringBuilder();
		if (arr[0].equals("0")) {
			return "0";
		} else {
			for (String i : arr) {
				sb.append(i);
			}
		}

		return sb.toString();
	}

	public static void main(String[] args) {
		System.out.println(solution(new int[] { 6, 10, 2 }));
		System.out.println(solution(new int[] { 3, 30, 34, 5, 9 }));
	}
}
