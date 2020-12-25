package graph;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 유기농 배추
 * 메모리, 시간 제한  - 512 MB,   1초
 * 메모리, 시간      - 13488 KB, 112 ms
 *
 * @author tildev
 * @data 2020. 12. 25.
 */
public class Main {

    private static final int[] xArr = {0, 0, -1, 1};
    private static final int[] yArr = {-1, 1, 0, 0};

    private static int earthwormCnt = 0;

    private static int t, m, n, k;

    private static int[][] matrix = new int[50][50];
    private static boolean[][] visited = new boolean[50][50];

    private static StringTokenizer st;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            earthwormCnt = 0;
            matrix = new int[50][50];
            visited = new boolean[50][50];

            st = new StringTokenizer(br.readLine());
            m = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());

            for (int j = 0; j < k; j++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                matrix[x][y] = 1;
            }

            for (int x = 0; x < m; x++) {
                for (int y = 0; y < n; y++) {
                    if (matrix[x][y] == 1 && !visited[x][y]) {
                        earthwormCnt += 1;
                        dfs(x, y);
                    }
                }
            }
            bw.write(earthwormCnt + "\n");
        }

        bw.flush();
        bw.close();
    }

    /**
     * dfs
     *
     * @param x
     * @param y
     */
    private static void dfs(int x, int y) {
        if (visited[x][y]) {
            return;
        }
        visited[x][y] = true;

        int impX;
        int impY;
        for (int i = 0; i < 4; i++) {
            impX = x + xArr[i];
            impY = y + yArr[i];

            if (impX >= 0 && impY >= 0 && impX < m && impY < n) {
                if (matrix[impX][impY] == 1 && (!visited[impX][impY])) {
                    dfs(impX, impY);
                }
            }
        }
    }
}