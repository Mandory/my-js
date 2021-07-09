# 프로토타입

> [Modern JavaScript](https://ko.javascript.info/prototype-inheritance) 읽으면서 정리하기

### 프로토타입 상속
자바스크립트에서는 기존에 있는 기능을 가져와 확장해야 할 때 어떻게 할 수 있을까? 프로토타입 상속을 이용할 수 있다.<br>
자바스크립트의 객체는 명세서에서 명명한 <b>[[Prototype]]</b>이라는 숨김 프로퍼티를 갖는다.
숨김 프로퍼티 값은 null이나 다른 객체에 대한 참조를 가질 수 있는데 다른 객체를 참조하는 경우 참조 대상을 '프로토타입'
이라 부른다.

┌ prototype object ┐ <-**[[Prototype]]**- ┌ object ┐ <br>
└───────────┘&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└─────┘

위 그림에서 object에서 어떤 프로퍼티를 읽으려고 할 때 해당 프로퍼티가 없으면 자동으로 프로토타입으로 가서 프로퍼티를 찾는다.

```js
// 모던자바스크립트에서 따온 코드
// 이렇게 하면 프로토타입을 설정할 수 있다.
let animal = {
    eats: true,
    walk() {
        //
    }
};
let rabbit = {
    jumps: true
};

rabbit.__proto__ = animal;
// __proto__ 는 [[Prototype]]의 getter/setter
// 최근에는 Object.getPrototypeOf/Object.setPrototypeOf를 쓸 수 있다.

alert(rabbit.eats); // rabbit에는 eats가 없는데? 그럼 프로토타입에서 찾아보자!

rabbit.walk = function() {
    alert("rabbit은 앞으로 이 walk를 사용함");
};
// 프로토타입에 쓸 때는 객체에 직접해야 한다.
// rabbit.walk를 하면 객체 rabbit에 메서드가 추가되는 것
```

프로토타입 체인은 길어질 수 있지만
1. 순환참조는 허용되지 않고
2. __proto__의 값은 객체나 null만 가능하다. (다른 자료형은 무시)
3. 객체엔 하나의 [[Prototype]]만 있을 수 있다.

### 프로토타입과 this
this는 프로토타입에 영향을 받지 않는다.<br>
this는 언제나 . 앞에 있는 객체를 가리킨다.
그렇기 때문에 상속받은 메서드를 사용하더라도 객체는 프로토타입이 아닌 자신의 상태를 수정한다.

```js
// 모던자바스크립트 코드
let animal = {
    walk() {
        //...
    },
    sleep() {
        this.isSleeping = true;
    }
};

let rabbit = {
    name: "토끼",
    __proto__: animal
};

rabbit.sleep(); // 이렇게 하면 rabbit의 프로퍼티인 isSleeping에 값이 true로 설정된다.

alert(rabbit.isSleeping); // true
alert(animal.isSleeping); // undefined -> 프로토타입인 animal에는 isSleeping이 없음

// 결론! 메서드는 공유되지만 객체의 상태는 공유되지 않음
```

### 자바스크립트도 객체지향 프로그래밍??
> 아래 내용은 여기서 https://poiemaweb.com/es6-class

자바스크립트는 프로토타입 기반(prototype-based) 객체지향 언어다. 프로토타입 기반 프로그래밍은 클래스가 필요없는 (class-free) 객체지향 프로그래밍 스타일로 프로토타입 체인과 클로저 등으로 객체 지향 언어의 상속, 캡슐화(정보 은닉) 등의 개념을 구현할 수 있다.

```js
// ES5에서 객체 지향 프로그래밍을 이렇게
var Person = (function() {
    // constructor
    function Person(name) {
        this._name = name;
    }

    // public method
    Person.prototype.sayHi = function() {
        console.log('Hi! ' + this._name);
    };

    return Person;
}());

var me = new Person('Lee');
me.sayHi(); // Hi! Lee.
console.log(me instanceof Person); // true
```

