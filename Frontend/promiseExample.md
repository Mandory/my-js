# 프로미스 이럴 때 이렇게 쓰자!!

> 어느날 동료가 이럴 때 어떻게 하면 좋을지에 대해서 물어왔다.<br>
> '무슨 방법이 있을 거 같은데... 프로미스로 하면 될 거 같은데...'<br>
> 잘 모르겠어서 같이 찾아보겠다고 했고 찾은 것을 잊어버리지 않기 위해 기록!

## 문제 상황

웹 애플리케이션에서 파일의 내용을 읽을 때 사용하는 `FileReader` 객체를 사용할 때 다음과 같은 상황이 생길 수 있다.
`FileReader`의 `onload` 이벤트에서 reader의 결과를 성공적으로 받고 난 후 결과를 전달해주어야 하는데 어떻게 넘겨줘야 할지에 대한 동료의 고민이 있었다. 동료의 첫번째 접근 방법은 onload 이벤트가 불릴 때 결과를 받을 callback을 넘겨주는 것이었다(주석: \*\*\*). 그런데 문제는 callback이 불리기도 전에 '주석: ###' 이후의 코드들이 실행되는 것이었다. callback 안에는 result의 값에 따라 뒤의 코드가 더 실행되어야 할지 말지에 대한 테스트 코드가 있는데 이걸 거치지 않고 바로 다음 코드가 실행되는 것이었다.

```js
function readFile(file, cb) {
  let reader = new FileReader();

  reader.onload = () => {
    cb(reader.result);
  };

  reader.readAsArrayBuffer(file);
}

function processFile() {
  const file = document.getElementById('fileInput').file[0];
  const contentBuffer = readFile(file, result => {
    console.log('result ', result);
  }); // ***

  // ###
  // readfile의 결과에 따라 이 아래 코드가 실행될지 말지를 결정해야 하는데!
  console.log(contentBuffer);
  // ...
}
```

## 프로미스를 사용해서 해결해보자.

> 프로미스를 눈으로만 봤지 직접 만들어 사용해본 적이 없었는지 아주 쉽게 해결될 문제의 해답을 찾아내지 못했었다.

위의 코드에서 readFile 함수에서 callback을 받는 대신 프로미스를 반환하도록 만들어본다.
이렇게 하면 '주석: @@@' 부분에서 원하는 결과물이 올 때까지 기다렸다가 다음 코드로 넘어갈 수 있게 된다.

`readFilePromise`함수에서의 핵심은 하나의 Promise 객체로 만들어 반환할 코드들을 감싸고 그 내부에서 적절한 타이밍에 resolve 함수를 호출한다.

```js
function readFilePromise(file) {
  return new Promise((resolve, reject) => {
    let reader = new FileReader();

    reader.onload = () => {
      resolve(reader.result);
    };

    reader.onerror = reject;

    reader.readAsArrayBuffer(file);
  });
}

async function processFile() {
  const file = document.getElementById('fileInput').file[0];
  const contentBuffer = await readFilePromise(file); // @@@

  // ###
  console.log(contentBuffer);
  // ...
}
```

## 참고

- [코드 참고](https://simon-schraeder.de/posts/filereader-async/)
- [FileReader API](https://developer.mozilla.org/ko/docs/Web/API/FileReader)
