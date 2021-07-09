# 읽고 기억에 남는 것

- [21 Bad Front-End Habits to Drop in 2021](https://dev.to/sachagreif/21-bad-front-end-habits-to-drop-in-2021-1698?ref=uxcollective)<br>
  10번에 Using Margin 기억에 남는다. 가장 많이 쓰이는 속성 같은데 사용하지 말라니<br>
  사용하지 말라는 사람들의 이야기를 들어보면 이렇다. Margin은 **component encapsulation**을 깨뜨린다고 한다. 컴포넌트 외부에 영향을 주는건 좋지 않은 것이기 때문인 거 같다. 그리고 재사용성도 떨어트린다. 대신 상위에서 공간을 관리하도록 담당하는 *spacer components*를 권장하고 있다.
  한번도 생각해보지 않은 접근이어서 기록해두고 싶었다.<br>
  그래도 사용하려고 한다면 Margin Collapse 규칙에 대해 읽어보기

- [What the heck, z-index??](https://www.joshwcomeau.com/css/stacking-contexts/)<br>
  구독하고 있는 frontend news에서 요즘 가장 눈여겨 보고 있는 블로그의 글이 올라왔다. (내용이 깔끔하고 사이트가 예뻐서 좋아함)<br>
  z-index에 대한 내용으로 css 영역이기는 하지만 개발하다가 보면 z-index를 많이 보게 되기 때문에 쭉 읽어보았다.<br>
  이 글을 읽기 전에 z-index로 큰 값이 주어진 원소가 가장 맨 위로 올라온다는 것을 추측으로 알고 있었다.<br>
  그런데 이 글을 읽어보니 꼭 그렇지 않다는 것이다. 여기서 기억해야 할 것은 **stacking contexts**! z-index는 같은 **context**에 있는 원소들끼리 비교된다는 것이다. (좀 더 자세하고 심화된 내용은 다시 한번 읽어보기)

https://lea.verou.me/2021/03/inverted-lightness-variables/

https://github.blog/2021-03-25-how-github-actions-renders-large-scale-logs/

https://blog.bitsrc.io/how-to-avoid-javascript-type-conversions-29e1258f37d8

https://dmitripavlutin.com/javascript-queue/?utm_campaign=Frontend%2BWeekly&utm_medium=email&utm_source=Frontend_Weekly_248
