package dynamic;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Tile01_1904 {
	public static int N;
	public static int[] d;

	public static int getCount(int N) {
		if (N <= 2) {
			return N;
		} else {
			d[1] = 1;
			d[2] = 2;
			for (int i = 3; i <= N; i++) {
				d[i] = (d[i - 1] + d[i - 2]) % 15746;
			}
		}
		return d[N];
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(br.readLine());
		d = new int[N + 1];
		bw.write(String.valueOf(getCount(N)));

		bw.close();
		br.close();
	}
}