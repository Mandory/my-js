
package graph;

import java.io.*;
import java.util.Arrays;

/**
 * 단지번호붙이기
 * 메모리, 시간 제한  - 128 MB,   1초
 * 메모리, 시간      - 11668 KB, 88 ms
 *
 * @author tildev
 * @data 2020. 12. 24.
 */
public class Main {

    private static final int[] xArr = {0, 0, -1, 1};
    private static final int[] yArr = {-1, 1, 0, 0};

    private static int complexNum = 0;
    private static int[] complexCnt = new int[25 * 25];

    private static int n;

    private static int[][] matrix = new int[25][25];
    private static boolean[][] visited = new boolean[25][25];

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());

        String s;
        for (int i = 0; i < n; i++) {
            s = br.readLine();
            for (int j = 0; j < n; j++) {
                matrix[i][j] = s.charAt(j) - '0';
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 1 && !visited[i][j]) {
                    complexNum += 1;
                    dfs(i, j);
                }
            }
        }

        bw.write(complexNum + "\n");
        Arrays.sort(complexCnt);

        for (int i = complexCnt.length - complexNum; i < complexCnt.length; i++) {
            bw.write(complexCnt[i] + "\n");
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

        complexCnt[complexNum]++;
        visited[x][y] = true;

        int impX;
        int impY;
        for (int i = 0; i < 4; i++) {
            impX = x + xArr[i];
            impY = y + yArr[i];

            if (impX >= 0 && impY >= 0 && impX < n && impY < n) {
                if (matrix[impX][impY] == 1 && (!visited[impX][impY])) {
                    dfs(impX, impY);
                }
            }
        }
    }
}
