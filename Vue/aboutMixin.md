# Mixin
> 비슷한 컴포넌트(화면) 사이의 중복되는 기능을 재사용할 수 있게 만들어보자!

화면 개발을 하다가보면 완전 동일한 형태의 화면이고 화면의 타이틀, 화면 내 목록 컬럼 헤더 등의 차이 정도만 있는 경우가 있다. 이럴 때 컴포넌트 1개로 만들고 각 화면에서 차이나는 부분은 props로 넘겨주는 방식을 써볼 수도 있다.

하지만 이렇게 무조건 props로 구분하는 경우 props가 너무 많아지고 불필요하게 코드가 복잡해질 것이다.

공통되는 코드들을 빼내어서 만들 수 있는 방법은 없을까?<br>
이러한 고민을 해결하기 위해 1Vue에서는 **Mixin**이라는 기능을 제공하고 있다.

Vue 공식 문서를 살펴보면 *Vue 컴포넌트에 재사용 가능한 기능을 배포하는 유연한 방법입니다.* 라고 말하고 있다.

```
ListA, ListB 화면에서 동일한 기능을 사용할 수 있도록 Mixin을 만들고 상속(처럼)받도록 했다.
ListA.vue <- ListMixin.js
ListB.vue <- ListMixin.js
```

## 컴포넌트와 Mixin에 중첩된 옵션이 있다면?

* data 오브젝트의 경우 컴포넌트에 선언된 data가 우선으로 병합
* mixin 훅은 컴포넌트 자체의 훅 이전에 호출
  * created, mounted 등과 같은 경우 mixin -> component
* methods, components, directive에서  충돌하는 키가 있을 때 컴포넌트의 옵션이 우선순위

## Vue extend

* 기존 컴포넌트의 기능을 확장하고 싶을 때 상속을 활용하면 좋을 거 같음
* mixin과 같은 병합 전략을 사용
* 한개의 컴포넌트만 extend 할 수 있다. (하지만 mixin은 여러개 추가할 수 있다.)

## Reference
* [Vue 공식 문서](https://kr.vuejs.org/v2/guide/mixins.html)
* [Mixin 설명](https://mygumi.tistory.com/266)
* [공통 기능 캡슐화 비교](https://laracasts.com/discuss/channels/vue/how-to-encapsulate-common-functionality-in-vuejs)
* [mixin과 extend 차이가 잘 설명되어있는 블로그](https://blog.jungbin.kim/web/2019/01/21/js-vue-mixin-extend.html)
* [우아한 형제들 vue 사용기 - mixin 내용도 있음](https://techblog.woowahan.com/2577/)