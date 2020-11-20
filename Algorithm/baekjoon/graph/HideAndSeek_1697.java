package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class HideAndSeek_1697 {
	public static int bfs(int start, int end) {
		int[] arr = new int[100001];
		Queue<Integer> queue = new LinkedList<>();
		queue.add(start);

		while (!queue.isEmpty()) {
			int cur = queue.remove();
			if (cur == end) {
				return arr[cur];
			}
			int[] range = new int[] { cur + 1, cur - 1, cur * 2 };
			for (int next : range) {
				if (next >= 0 && next <= 100000 && arr[next] == 0) {
					arr[next] = arr[cur] + 1;
					queue.add(next);
				}
			}
		}
		return -1;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());

		System.out.println(bfs(start, end));

		br.close();
	}
}
