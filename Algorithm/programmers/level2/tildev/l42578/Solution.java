package level2.tildev.l42578;

import java.util.*;

/**
 * 위장
 * <p>
 * 해시
 *
 * @author tildev
 * @data 2021. 05. 02.
 */
class Solution {

  public int solution(String[][] clothes) {
    int answer = 1;

    Map<String, Integer> clothesTypeMap = new HashMap<>();

    for (int i = 0; i < clothes.length; i++) {
      clothesTypeMap.put(clothes[i][1], clothesTypeMap.getOrDefault(clothes[i][1], 0) + 1);
    }

    for (String key : clothesTypeMap.keySet()) {
      // 해당 옷 종류를 입지 않았을 경우의 수 +1 을 해준다.
      answer *= (clothesTypeMap.get(key) + 1);
    }

    // 아무것도 위장하지 않은 경우의 수 1을 빼준다.
    return answer - 1;
  }

  public static void main(String[] args) {
    String[][] clothes = {{"yellowhat", "headgear"}, {"bluesunglasses", "eyewear"},
        {"green_turban", "headgear"}};

    int ans = new Solution().solution(clothes);
    int ans1 = new Solution().solution1(clothes);
    System.out.println(ans);
    System.out.println(ans1);

  }
}