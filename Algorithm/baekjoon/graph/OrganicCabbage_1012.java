package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class OrganicCabbage_1012 {

	public static int[][] map, visit;
	public static int M, N, K;

	static class Point {
		int x;
		int y;

		Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void bfs(int x, int y) {
		Queue<Point> queue = new LinkedList<>();
		queue.add(new Point(x,y));
		visit[x][y] = 1;
		
		while(!queue.isEmpty()) {
			Point cur = queue.remove();
			int[] xArr = {-1,0,1,0};
			int[] yArr = {0,-1,0,1};
			
			for(int i = 0; i < 4; i++) {
				int nX = cur.x+xArr[i];
				int nY = cur.y+yArr[i];
				if(nX >=0 && nX <= M && nY >=0 && nY <= N
						&& map[nX][nY] == 1 && visit[nX][nY] == 0) {
					visit[nX][nY] = 1;
					queue.add(new Point(nX, nY));
				}
			}
		}
	}

	public static int find() {
		int count = 0;

		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 1 && visit[i][j] == 0) {
					count += 1;
					bfs(i, j);
				}
			}
		}
		return count;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			map = new int[M + 1][N + 1];
			visit = new int[M + 1][N + 1];
			for (int k = 0; k < K; k++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				map[x][y] = 1;
			}
			System.out.println(find());
		}

		br.close();
	}
}
