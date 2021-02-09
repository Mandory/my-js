# 읽고 기억에 남는 것

* [21 Bad Front-End Habits to Drop in 2021](https://dev.to/sachagreif/21-bad-front-end-habits-to-drop-in-2021-1698?ref=uxcollective)<br>
    10번에 Using Margin 기억에 남는다. 가장 많이 쓰이는 속성 같은데 사용하지 말라니<br>
    사용하지 말라는 사람들의 이야기를 들어보면 이렇다. Margin은 **component encapsulation**을 깨뜨린다고 한다. 컴포넌트 외부에 영향을 주는건 좋지 않은 것이기 때문인 거 같다. 그리고 재사용성도 떨어트린다. 대신 상위에서 공간을 관리하도록 담당하는 *spacer components*를 권장하고 있다.
    한번도 생각해보지 않은 접근이어서 기록해두고 싶었다.<br>
    그래도 사용하려고 한다면 Margin Collapse 규칙에 대해 읽어보기
