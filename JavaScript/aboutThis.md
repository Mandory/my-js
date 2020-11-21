# JavaScript에서 'this'

> JavaScript에서 this는 다른 언어와는 조금 다르게 동작한다.

객체를 생성할 때 프로퍼티에 행동할 수 있는 함수를 할당할 수 있다.
```js
let person = {
    name: 'js',
    // 프로퍼티에 할당된 함수: 메서드
    // 아래는 단축 문법으로 만듬
    run() {
        console.log(`Let's Run, ${this.name}!`);
    }
}
```

코드에서 볼 수 있듯이 메서드에서는 <mark>this</mark> 키워드로 객체에 저장된 정보에 접근할 수 있다.
```js
person.run(); // Let's Run, js!
// 이 때 run() 메소드 내부 this는 person을 가리킴
```
this의 값은 런타임에 결정된다. 컨텍스트에 따라 달라진다.

```js
// 모던 자바스크립트 튜토리얼에서 따온 코드
let user = { name: "John" };
let admin = { name: "Admin" };

function sayHi() {
  alert( this.name );
}

user.f = sayHi;
admin.f = sayHi;

user.f(); // John 여기서 this는 user를 가리킴
admin.f(); // Admin 여기서는 admin을 가리킴
// 함수를 하나만 만들어서 여러 객체에서 재사용할 수 있는 장점
// 하지만 실수하기 쉬움...
```

### 화살표 함수
화살표 함수에는 **this**가 없다!?
> 어딘가에 함수를 전달하게 되면 함수의 컨텍스트를 잃을 수 있다. 이럴 때 화살표 함수를 사용하면 현재 컨텍스트를 잃지 않아 편리하다.

```js
// You don't know js 280쪽
var obj = {
    count: 0,
    cool: function coolFn() {
        var self = this; // 클로저!
        if(self.count < 1) {
            setTimeout(function timer() {
                self.count++;
                console.log(`awesome? ${this.count}`); // ***
            }, 100);
        }
    }
};
obj.cool(); // awesome? NaN
```

코드에서 *** 표시있는 줄에 this.count라고 하면 NaN이 출력된다. <br>
this가 function을 벗어나서 위의 count를 가져올 수가 없다.<br>
여기서 this는 전역 개체(window)를 바라보고 있다.

이 코드를 화살표 함수를 이용한다면 이렇게 된다.
```js
var obj = {
    count: 0,
    cool: function coolFn() {
        if (this.count < 1) {
            setTimeout( () => {
                this.count++;
                console.log(`awesome? ${this.count}`);
            }, 100);
        }
    }
};
obj.cool();
```

화살표 함수에는 this가 없기 때문에 상위의 this를 가리키게 된다.

### 참고
- [모던 자바스크립트 튜토리얼 - 메서드와 'this'](https://javascript.info/object-methods)
- YOU DON'T KNOW JS (타입과 문법, 스코프와 클로저 편)