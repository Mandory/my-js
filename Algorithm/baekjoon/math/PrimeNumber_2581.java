package math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 소수 찾기
 * <p>
 * 메모리, 시간 제한  - 128 MB,   1초
 * 메모리, 시간      - 11532 KB, 80 ms
 *
 * @author tildev
 * @data 2020. 12. 20.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int m = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());

        int sum = 0;

        boolean[] noPrimeNumberArr = new boolean[n + 1];
        noPrimeNumberArr[0] = noPrimeNumberArr[1] = true;
        for (int i = 2; i <= Math.sqrt(n); i++) {

            if (noPrimeNumberArr[i]) {
                continue;
            }
            for (int j = i * i; j < noPrimeNumberArr.length; j += i) {
                noPrimeNumberArr[j] = true;
            }
        }
        boolean isFirst = true;
        int firstValue = -1;
        for (int i = m; i <= n; i++) {
            if (!noPrimeNumberArr[i]) {
                if (isFirst) {
                    isFirst = false;
                    firstValue = i;
                }
                sum += i;
            }
        }
        if (firstValue == -1) {
            System.out.println("-1");
        } else {
            System.out.println(sum);
            System.out.println(firstValue);
        }
    }
}
