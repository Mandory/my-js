# 모던 JavaScript 튜토리얼 읽기

> 모던 JavaScript 튜토리얼 (https://ko.javascript.info/)을 읽으면서 잘 몰랐던 부분 위주로 정리 <br>
> 주의!! 문장 연결이 어색하고 일관성이 없을 수 있음
## 파트2 코어 자바스크립트 > 객체: 기본
### 참조에 의한 객체 복사

객체와 원시 타입의 근본적인 차이!<br>
: 객체는 '참조에 의해 (by reference)' 저장되고 복사된다는 것<br>
: 원시값 (문자열, 숫자, 불린 값)은 '값 그대로' 저장, 할당되고 복사

객체의 복사본을 만들고 싶으면 <br>
shallow copy하는 Object.assign이나<br>
deep copy로 _.cloneDeep(obj)가 있음

### 가비지 컬렉션

가비지 컬렉션 기준
- 도달 가능성(reachability)이라는 개념을 사용해 메모리 관리를 수행<br>
: 도달 가능한 값은 쉽게 말해 어떻게든 접근하거나 사용할 수 있는 값을 의미 -> 도달 가능한 값은 메모리에서 삭제되지 않음

내부 알고리즘 <br>
'mark-and-sweep'

### 'new' 연산자와 생성자 함수

'new' 연산자와 생성자 함수를 사용하면 유사한 객체 여러 개를 쉽게 만들 수 있다.

생성자 함수(constructor function)와 일반 함수에 기술적인 차이는 없음<br> 대신 아래 두가지를 따름
1. 함수 이름의 첫 글자는 대문자로 시작 (모든 함수는 생성자 함수가 될 수 있기 때문에 공동의 약속을 한 것)
2. 반드시 'new' 연산자를 붙여 실행

생성자의 의의는 재사용할 수 있는 객체 생성 코드를 구현하는 것

```js
function User(name) {
    this.name = name;
}

let user = new User('Jack');
// 이렇게 하면 무슨 일이 벌어지냐
/*
1. 빈 객체를 만들어 this에 할당
2. 함수 본문을 실행. this에 새로운 프로퍼티를 추가해 this를 수정
3. this를 반환
*/
function User(name) {
    // this = {}; 빈 객체가 암시적으로 만들어짐
    this.name = name; // 새로운 프로퍼티를 this에 추가
    // return this; this가 암시적으로 반환됨
    // 그런데 return 문이 있다면?
    // - 객체를 return 한다면, this 대신 객체가 반환
    // - 원시형을 return 한다면, return 문은 무시하고 this가 반환
}
```

### 옵셔널 체이닝

### 심볼형

### 객체를 원시형으로 변환하기