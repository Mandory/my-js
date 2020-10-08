package dynamic;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Tile01_1904 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		int[] d = new int[N + 1];

		// initialize
		d[0] = 0;
		d[1] = 1;
		d[2] = 2;

		for (int i = 3; i <= N; i++) {
			d[i] = d[i - 1] + d[i - 2];
		}

		bw.write(String.valueOf(d[N] % 15746));

		bw.close();
		br.close();
	}
}
