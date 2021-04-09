# Map 함수에서 Async Await 사용하기

## 문제 상황
아이디 리스트만 받아오고
아이디로 상세 정보를 받아와서 사용하려고 했다.

그리고 리스트를 자연스럽게 map으로 처리하고 보니 원하는 값이 아니었다.

```js
// 예시
const idList = await getIdList();
const detailList = idList.map(async id => {
    return await getDetail(id); // promise 반환됨!!
});
```

이건 promise 배열일 뿐이라는 것이다.

## 해결 방법

- for문 
- Promise.all

## 참고
* https://mygumi.tistory.com/328
* https://velog.io/@minsangk/2019-09-06-0209-%EC%9E%91%EC%84%B1%EB%90%A8-eik06xy8mm