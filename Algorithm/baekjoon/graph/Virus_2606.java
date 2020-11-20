package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Virus_2606 {
	public static int[][] map;
	public static int[] visit;
	public static int N, M;

	public static int bfs() {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(1);

		while (!queue.isEmpty()) {
			int cur = queue.remove();
			visit[cur] = 1;
			for (int i = 0; i <= N; i++) {
				if (map[cur][i] == 1 && visit[i] == 0) {
					queue.add(i);
				}
			}
		}

		int count = 0;
		for (int i = 1; i <= N; i++) {
			if (visit[i] == 1) {
				count += 1;
			}
		}

		return count - 1;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());

		map = new int[N + 1][N + 1];
		visit = new int[N + 1];

		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int v1 = Integer.parseInt(st.nextToken());
			int v2 = Integer.parseInt(st.nextToken());
			map[v1][v2] = map[v2][v1] = 1;
		}

		System.out.println(bfs());

		br.close();
	}
}
