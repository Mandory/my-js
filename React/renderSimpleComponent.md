# React는 어떻게 그릴까?

## Intro

hello-example 안에 "Hello {name}" 메시지를 넣어보려고 한다.

```html
<div id="hello-example"></div>
```

```js
const name = 'kuongee';
const target = document.getElementById('hello-example');
target.innerHTML = `<div>Hello ${name}</div>`;
```

이런 상황에서 만약 name 값이 계속 변한다면 어떨까?
훨씬 복잡하고 큰 애플리케이션이라면 하나하나 Element를 찾고 추가하고 수정하는 등 해줘야 할 일이 많아지고 그 사이에 실수도 생길 수 있다.
이렇게 직접 자바스크립트로만 관리하기에는 어렵기 때문에 다양한 프레임워크, 라이브러리의 도움으로 좀 더 편하고 안전하게 구현할 수 있게 되었다.

그 중 React를 살펴보자!<br>
리액트 컴포넌트는 간단하게 이렇게 만들 수 있다.

```js
// React 공식문서 참고
class HelloMessage extends React.Component {
  // 리액트 컴포넌트는 input 데이터를 받아서 어떤걸 보여줄지 반환한다.
  render() {
    return React.createElement('div', null, 'Hello', this.props.name);
  }
}

ReactDOM.render(
  React.createElement(HelloMessage, { name: 'Taylor' }),
  document.getElementById('hello-example')
);
```

리액트는 매번 createElement 함수를 사용하지 않고도 마치 HTML 코드를 작성하는 것처럼 좀 더 쉽고 익숙하게 UI를 만들 수 있도록 JSX를 지원한다. 위의 코드를 JSX로 변환한 코드는 다음과 같다.

```js
class HelloMessage extends React.Component {
  render() {
    return <div>Hello {this.props.name}</div>;
  }
}

// 컴포넌트로 전달되는 데이터는 (여기서는 name과 같이) this.props로 접근
ReactDOM.render(
  <HelloMessage name="Taylor" />,
  document.getElementById('hello-example')
);
```

---

React [예제](https://reactjs.org/docs/add-react-to-a-website.html)를 보니까 기본적으로 아래 두개를 넣어줘야 하나보다.

```html
<script
  src="https://unpkg.com/react@17/umd/react.development.js"
  crossorigin
></script>
<script
  src="https://unpkg.com/react-dom@17/umd/react-dom.development.js"
  crossorigin
></script>
```

`react` 패키지

- https://github.com/facebook/react/tree/main/packages/react
- `react` 패키지는 React 컴포넌트를 만드는데 기능적으로 필수적인 것들을 포함
- React.Component 베이스 클래스 제공
- `react-dom`과 같이 Web에서의 React renderer와 같이 사용
- 리액트 코어는 reconciliation algorithm이나 플랫폼에 특화된 코드를 포함하고 있지 않음

`react-dom` 패키지

- https://github.com/facebook/react/tree/main/packages/react-dom
- Renderers manage how a React tree turns into the underlying platform calls. [출처](https://reactjs.org/docs/codebase-overview.html#renderers)
- `react`랑 같이 써라
- 예제 코드에서 render를 쓰고 있는데 ReactDOM.render는 React 18에서는 더이상 지원하지 않는데 대신 앞으로 createRoot를 사용하라고 함 ([참고](https://github.com/reactwg/react-18/discussions/5))

## 리액트 내부

Reconciliation

fiber

https://fiber-debugger.surge.sh/

https://github.com/acdlite/react-fiber-architecture
React is designed so that reconciliation and rendering are separate phases. The reconciler does the work of computing which parts of a tree have changed; the renderer then uses that information to actually update the rendered app.

https://www.facebook.com/groups/2003630259862046/permalink/2054053404819731/

---

render -> legacyRenderSubtreeIntoContainer -> updateContainer
legacy로 표시되어있다

createRoot의 render -> updateContainer (fiber?, lane?)

createUpdate
enqueueUpdate
Current Queue, Work-in-progress Queue 두개를 사용
https://github.com/facebook/react/blob/fe905f152f1c9740279e31ce4478a5b8ca75172e/packages/react-reconciler/src/ReactUpdateQueue.new.js#L197

https://github.com/facebook/react/blob/fe905f152f1c9740279e31ce4478a5b8ca75172e/packages/react-reconciler/src/ReactFiberReconciler.new.js#L237

https://blog.logrocket.com/deep-dive-into-react-fiber-internals/

https://goidle.github.io/react/in-depth-react-reconciler_1/

## Reference

- https://reactjs.org/docs/codebase-overview.html

immutable code

- https://dev.to/dglsparsons/how-to-write-immutable-code-and-never-get-stuck-debugging-again-4p1
- https://www.freecodecamp.org/news/write-safer-and-cleaner-code-by-leveraging-the-power-of-immutability-7862df04b7b6/
