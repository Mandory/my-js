# Webpack DevServer

브라우저에서 서로 다른 도메인에 요청을 보낼 때 데이터에 접근이 안 되는데 이때 CORS 설정이 필요하다. 서버 쪽에서 허용하도록 구현해주는 방법도 있지만 웹팩 개발 서버를 통해 개발 단계에서 해결할 수 있다. 바로 웹팩 개발 서버에서 재공하는 Proxy를 이용하면 된다.

## 웹팩 개발 서버

웹팩 설정을 적용한 결과물을 만들어주고 로컬 서버를 띄워 결과물을 보여준다. (개발 환경을 운영 환경과 유사하게 갖출 수 있도록)

- Hot reloading 제공
- Proxy 기능으로 CORS 설정도 가능

> 여기서는 Proxy 기능을 위주로 살펴본다.

### Proxy

웹팩 개발 서버는 http-proxy-middleware 패키지를 사용한다.
프록시는 서로 다른 도메인의 서버에 API 요청을 날릴 때 유용하게 사용할 수 있다. 브라우저에서 API 요청을 보낼 때 웹팩 개발 서버로 요청을 보내게 되면 설정된 프록시에 의해 해당 요청을 그대로 백엔드 서버로 전달하고 응답 받은 내용은 브라우저로 보내준다.

예시를 보면 /api 로 들어온 요청을 백엔드 서버의 도메인 localhost:3000 로 돌려 보내도록 설정한 것이다.

```js
// webpack.config.js
module.exports = {
  //...
  devServer: {
    proxy: {
      '/api': {
        target: 'http://localhost:3000',
      },
    },
  },
};
```

❓ 여기서 /api 말고 /qwe로 오는 요청처럼 다른 타겟으로 넘기고 싶을 때 어떻게 해야할까?

router라는 옵션을 참고해보자.
https://github.com/chimurai/http-proxy-middleware/blob/master/recipes/router.md

## 참고

- https://webpack.js.org/configuration/dev-server/#devserverproxy
- https://www.zerocho.com/category/Webpack/post/5f97c8c6591c990004e1f5f1
- https://jeonghwan-kim.github.io/series/2020/01/02/frontend-dev-env-webpack-intermediate.html
- https://react.vlpt.us/redux-middleware/09-cors-and-proxy.html
