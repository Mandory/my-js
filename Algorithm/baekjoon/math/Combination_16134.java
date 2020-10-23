package math;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Combination_16134 {
	public static int M = 1000000007;

	public static long pow(long num, int p) {
		long ret = 1;
		long tmp = num;

		while (p > 0) {
			if (p % 2 == 1) {
				ret = ret * tmp % M;
			}
			p = p / 2;
			tmp = tmp * tmp % M;
		}
		return ret;
	}

	public static long factorial(long num) {
		long ret = 1;
		while (num > 1) {
			ret = ret * num % M;
			num -= 1;
		}
		return ret;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		long N = Long.parseLong(st.nextToken());
		long R = Long.parseLong(st.nextToken());

		if (N == R) {
			System.out.println(1);
			return;
		}

		long denumerator = factorial(N);
		long numerator = factorial(N - R) * factorial(R) % M;

		long ret = denumerator * pow(numerator, M - 2) % M;

		bw.write(String.valueOf(ret));
		bw.close();
		br.close();
	}

}