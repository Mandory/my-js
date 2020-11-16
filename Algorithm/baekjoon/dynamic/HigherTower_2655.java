package dynamic;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;
import java.util.StringTokenizer;

public class HigherTower_2655 {
	static class Brick implements Comparable<Brick> {
		int num;
		int width;
		int height;
		int weight;

		public Brick(int num, int width, int height, int weight) {
			this.num = num;
			this.width = width;
			this.height = height;
			this.weight = weight;
		}

		@Override
		public int compareTo(Brick o) {
			return this.weight < o.weight ? -1 : 1;
		}
	}

	public static void main(String[] args) throws IOException {
		// System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		ArrayList<Brick> bricks = new ArrayList<>();
		bricks.add(new Brick(0, 0, 0, 0));

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			int width = Integer.parseInt(st.nextToken());
			int height = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());

			bricks.add(new Brick(i, width, height, weight));
		}

		Collections.sort(bricks);

		int[] d = new int[N + 1];
		for (int i = 1; i < bricks.size(); i++) {
			Brick b1 = bricks.get(i);
			for (int j = 0; j < i; j++) {
				Brick b2 = bricks.get(j);
				if (b2.width < b1.width) {
					d[i] = Math.max(d[i], d[j] + b1.height);
				}
			}
		}

		int max = 0;
		int maxIdx = 0;
		for (int i = 0; i < d.length; i++) {
			if (d[i] > max) {
				max = d[i];
				maxIdx = i;
			}
		}

		Stack<Integer> stack = new Stack<>();
		while (maxIdx > 0) {
			if (d[maxIdx] == max) {
				stack.push(bricks.get(maxIdx).num);
				max = max - bricks.get(maxIdx).height;
			}
			maxIdx -= 1;
		}

		bw.write(String.valueOf(stack.size()) + "\n");

		while (!stack.isEmpty()) {
			bw.write(String.valueOf(stack.pop()) + "\n");
		}

		bw.close();
		br.close();

	}
}
