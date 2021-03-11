# 모듈
```js
// You don't know JS - 타입과 문법, 스코프와 클로저
// p.249 예제 코드 그대로
function CoolModule() {
  /*
    1. CoolModule()은 함수이지만 반드시 호출해야 모듈 인스턴스가 생성된다.
      최외곽 함수가 실행되지 않으면 내부 스코프와 클로저는 생성되지 않는다.
    2. CoolModule() 함수는 객체를 반환하며 내장 함수들에 대한 참조를 가진다.
      하지만 내장 데이터 변수에 대한 참조는 가지지 않는다.
  */
  var something = "cool";
  var another = [1, 2, 3];

  function doSomething() {
    console.log( something );
  }

  function doAnother() {
    console.log( another.join( " ! " ) );
  }

  return {
    doSomething: doSomething,
    doAnother: doAnother
    /*
      노출된 내부 함수를 통해서 비공개 스코프에 대한 클로저를 가져 비공개 상태에 접근하고 수정할 수 있다.
    */
  };
}

var foo = CoolModule();

foo.doSomething(); // cool
foo.doAnother(); // 1 ! 2 ! 3
```
위의 코드는 ES6 이상의 자바스크립트 코드에서는 보기 드문 코드 패턴이다. ES6 이전에는 이와 같은 방법으로 모듈 패턴을 구현하였다. 이 모듈 함수를 다음과 같이 IIFE로 바꾸면 싱글톤만 생성하는 모듈로 사용할 수 있다.
```js
var foo = (function CoolModule() {
  ....

   return {
    doSomething: doSomething,
    doAnother: doAnother
  };
})();

foo.doSomething();
```

## ES6의 모듈
ES6 이전 자바스크립트에서는 모듈에 대한 표준이 없었고 위 코드와 같은 방법이나 AMD, CommonJS, UMD 방식 등의 다양한 모듈 시스템들을 사용했었다. 하지만 ES6부터는 모듈 개념을 지원하는 최신 문법이 추가되었다.

### 특징
* ES6는 파일(스크립트 파일)하나당 하나의 모듈이 정의된다. (file-based modules)
* 모듈은 항상 엄격 모드 (use strict)로 실행된다.
* 자신만의 스코프를 가진다.
* 싱글톤이다. 이 말은 모듈은 중앙의 한개 인스턴스만 있다는 것이다.
    > (이게 궁금했었다.)<br>
    > 모던 자바스크립트 튜토리얼 설명 > 최초 호출 시 단 한 번만 평가 된다. 실행된 모듈은 필요한 곳에 공유된다. [코드](https://github.com/kuongee/JS-Study/tree/master/about-module)로 직접 확인해보았다.

## 참고
* [모던 자바스크립트 튜토리얼 - 모듈](https://ko.javascript.info/modules-intro)
* [YDKJS - ES6 & Beyond - 모듈](https://github.com/getify/You-Dont-Know-JS/blob/1st-ed/es6%20%26%20beyond/ch3.md#modules)
* [ES6 Modules - Single Instance Pattern](https://k94n.com/es6-modules-single-instance-pattern)