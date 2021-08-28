# 호이스팅 (Hoisting)
> [var const let](https://github.com/kuongee/my-js/blob/kuongee/Frontend/varConstLet.md) 공부하다가 보면 항상 나오는 호이스팅

호이스팅은 자바스크립트를 처음 접하고 보면 정말 이게 된다고? 라고 생각하게 되는 이상한 특징이다.

아래 예제를 살펴보자.
```js
console.log(hoisted);
var hoisted = 'strange';
```
과연 이 코드의 결과는 어떻게 될까?
`hoisted`라는 변수가 선언되기도 전에 변수에 접근했는데도 에러는 발생하지 않고 `undefined`라는 메시지를 남기고 끝나버린다.
이게 *hoisting*이 이루어졌기 때문에 가능한 일이다.
이 코드가 말이 되려면 `console.log` 코드 위쪽으로 `hoisted` 변수가 미리 선언되어있다는 것을 밝혀내야한다.

자바스크립트 컴파일러는 위의 코드를 아래처럼 본다.
```js
var hoisted = undefined;
console.log(hoisted);
hoisted = 'strange';
```

자바스크립트 컴파일러는 var로 선언된 선언부나 function으로 선언된 함수가 있다면 코드 실행 전에 메모리에 올리고 실제 코드에서 선언부 이전에 사용되더라도 사용할 수 있게 한다. 특히 var로 선언된 변수의 경우 `undefined`로 초기화 시켜버린다.

그런데 실제 코드에서 이런 일이 발생한다면 문제가 너무 많이 생길 거 같은데...?

**const, let으로 선언하자.**

`hoisted` 변수를 `const`로 바꿔서 선언해보자.
```js
console.log(hoisted);
const hoisted = 'strange';
```
`Uncaught ReferenceError: can't access lexical declaration 'hoisted' before initialization` 라는 에러가 발생한다.
> Firefox에서 테스트했는데 브라우저마다 에러 메시지가 다를 줄이야<br>[MDN 에러 설명](https://developer.mozilla.org/ko/docs/Web/JavaScript/Reference/Errors/Cant_access_lexical_declaration_before_init)

이 에러는 block statement 안에서 let, const의 선언이 정의되기 전에 접근되었을 때 발생하는 에러이다. let, const로 선언한 변수를 완전히 초기화가 되기 전에 사용하려고 한다면 'ReferenceError'를 발생시킨다. var로 선언된 변수와의 차이점이다.

조금 더 정리해보자. 에러 내용을 보면 `hoisted`라는 변수가 초기화 되기 전에 접근할 수 없다는 것인데 그렇다는 말은 초기화만 안 됐지 선언은 이미 되어있다는 것일까?

let으로 선언된 블록 스코프의 처음부터 변수가 초기화되기 전까지 그 변수는 Temporal dead zone(TDZ)에 존재하게 된다고 한다. 블록 스코프 내에서 호이스팅이 발생하기는 하지만 `undefined`로 초기화되지 않고 TDZ에 막히게 된다. 그리고 TDZ에 있는 동안 접근하려고 하면 다행히 에러가 발생한다.

```js
// MDN TDZ 예제
{
    // TDZ starts at beginning of scope
    const func = () => console.log(letVar); // OK

    // Within the TDZ letVar access throws `ReferenceError`

    let letVar = 3; // End of TDZ (for letVar)
    func(); // Called outside TDZ!
}
```

결론 const와 let을 사용해서 조금 더 안전한 코드를 작성하자.

## Reference
* [MDN 호이스팅 설명](https://developer.mozilla.org/en-US/docs/Glossary/Hoisting)
  > JavaScript Hoisting refers to the process whereby the compiler allocates memory for variable and function declarations prior to execution of the code. Declarations that are made using var are initialized with a default value of undefined. Declarations made using let and const are not initialized as part of hoisting.

* [MDN let, TDZ](https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Statements/let#temporal_dead_zone_tdz
)
  > MDN 문서의 TDZ 설명을 살펴보니 const에 대한 예제가 없다. const는 최초 초기화하지 않으면 바로 SyntaxError(`Uncaught SyntaxError: missing = in const declaration`)를 발생시킨다. 아무래도 const 변수는 재할당이 불가하기 때문에 그냥 처음부터 에러를 발생시켜버리고 TDZ에 빠질 일이 없기 떄문이 아닐까?

* [예제와 설명이 잘 정리되어있는 블로그](https://gist.github.com/LeoHeo/7c2a2a6dbcf80becaaa1e61e90091e5d)
* [한눈에 보기 쉽게 정리되어있는 블로그](https://junhobaik.github.io/js-let-cont-hoisting/)
* https://dev.to/menaaziz27/hoisting-in-javascript-variables-5f4m

> 2021-08-28 1차 작성