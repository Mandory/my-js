# Babel?

아래 코드는 IE에서 실행이 되지 않는다.<br>
"구문 오류" 라고 빨간 에러가 남는다.
```js
const hello = () => console.log("test for Babel");
hello();
```

ES6 이상의 버전을 거의 지원하지 않는 브라우저(IE 또는 구형 버전)에서도 쓸 수 있게 ES5 이하 버전으로 변환해야 한다.

바벨을 설치하고 변환해보자.
```bash
npm i -D @babel/core @babel/cli
npx babel testForBabel.js --out-file output.js
```
output.js를 확인해보자. <br>
아무런 변화가 없다. <br>
원하는 것을 얻으려면 프리셋과 플러그인들을 설정해줘야 한다.<br>
각 플러그인들은 각자가 또 npm 라이브러리이기 때문에 설치해주거나 preset으로 설정해줄 수 있다.

ES6의 화살표 함수를 transpile 해줄 수 있는 플러그인을 설치해보자.
```bash
npm i -D @babel/plugin-transform-arrow-functions
```

그 다음 바벨이 이 플러그인을 쓸 수 있도록 알려줘야 한다.<br>
그걸 .babelrc에 적어주는 것이다. 프로젝트 제일 root에 생성해주면 된다.<br>
그 다음 babel을 돌려주면 ES5로 transpiling 된다.

그런데 이렇게 모든 ES6 기능을 설치하고 적어주기에는 너무 번거롭기 때문에 이미 모아둔 preset을 설정해주면 된다.

공식 preset은 이런 것들이 있다. <br>
@babel/preset-env, @babel/preset-flow, @babel/preset-react, @babel/preset-typescript

아래 preset만 설치하면 ES6 모든 기능이 transpile 될 것이다.
```bash
npm i -D @babel/preset-env
```
```
// .babelrc에 선언
{
    "presets": ["@babel/preset-env"]
}
```

### 참고
- https://blog.jakoblind.no/babel-preset-env/
- https://poiemaweb.com/es6-babel-webpack-1
