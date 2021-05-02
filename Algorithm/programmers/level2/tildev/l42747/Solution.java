package level2.tildev.l42747;

import java.util.Arrays;

/**
 * H-Index
 * <p>
 * 정렬
 *
 * @author tildev
 * @data 2021. 05. 02.
 */
class Solution {

  public int solution(int[] citations) {
    int answer = 0;
    Arrays.sort(citations);

    int h;
    for (int i = 0; i < citations.length; i++) {
      h = citations.length - i;

      // h번 이상 인용된 논문의 수
      if (citations[i] >= h) {
        answer = h;
        break;
      }
    }

    return answer;
  }

  public static void main(String[] args) {
    int[] citations = {3, 0, 6, 1, 5};
    int answer = new Solution().solution(citations);

    System.out.println(answer);

  }
}