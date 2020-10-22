# == vs ===

두 연산자 모두 두 값의 '동등함(Equality)'을 비교하지만<br>
'느슨함'과 '엄격함'이라는 차이점이 있고 '동등함'의 판단 기준이 다름

> 동등함의 비교 시 ==는 강제 변환을 허용하지만, ===는 강제변환을 허용하지 않는다.

_ You don't know JS

```js
let a = 1;
let b = '1';
console.log(a == b); // true -> 이 경우 b가 Number로 변환되어 비교
console.log(a === b); // false
```

## 객체 비교는 어떻게 될까??

> ES5 명세 11.9.3.1의 마지막 항목에서는 객체(함수와 배열 포함)의 느슨한 동등 비교에 대해 두 객체가 정확히 똑같은 값에 대한 레퍼런스일 경우에만 동등하다고 기술되어 있다. 여기서 강제 변환은 일어나지 않는다.<br>_ You don't know JS

> Return true if x and y refer to the same object. Otherwise, return false. <br>
> _ ES5 명세 $11.9.6.7

```js
let a = [1];
let b = [1];
console.log(a == b, a === b); // false false
a = b;
console.log(a == b, a === b); // true true
```

### 객체 내 값이 같은지 확인하고 싶을 땐?
- 물론 좋은 라이브러리를 활용할 수 있다.
- 객체(+배열) 내 원소들을 하나 하나 비교할수도 있다. [참고](https://gomakethings.com/check-if-two-arrays-or-objects-are-equal-with-javascript/)
- stringify 처리하고 비교할수도 있다는 것을 기억해두자.
    - 배열이라면 sort하고 join으로 해볼 수 있을 거 같다.


## 참고
- https://dorey.github.io/JavaScript-Equality-Table/
- https://dmitripavlutin.com/the-legend-of-javascript-equality-operator/