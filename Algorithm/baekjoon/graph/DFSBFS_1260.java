package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class DFSBFS_1260 {

	public static int[][] map;
	public static int[] visit;
	public static int N, M, V;

	public static void dfs(int v) {
		visit[v] = 1;
		System.out.print(v + " ");

		for (int i = 1; i <= N; i++) {
			if (map[v][i] == 1 && visit[i] == 0) {
				dfs(i);
			}
		}
	}

	public static void bfs(int v) {
		Queue<Integer> queue = new LinkedList<>();
		visit[v] = 1;
		queue.add(v);

		while (!queue.isEmpty()) {
			int i = queue.remove();
			System.out.print(i + " ");
			for (int j = 0; j <= N; j++) {
				if (map[i][j] == 1 && visit[j] == 0) {
					visit[j] = 1;
					queue.add(j);
				}
			}
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());

		map = new int[N + 1][N + 1];
		visit = new int[N + 1];

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int y = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			map[y][x] = map[x][y] = 1;
		}

		dfs(V);

		System.out.println();

		Arrays.fill(visit, 0);

		bfs(V);

		br.close();
	}
}
