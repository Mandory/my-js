# DOM

## DOM (Document Object Model)

DOM은 문서(document / 예: HTML, XML 문서)에 접근하고 관리할 수 있는 프로그래밍 인터페이스이다.

문서의 구조화된 표현을 제공하고 프로그래밍 언어가 DOM 구조에 접근할 수 있는 방법을 제공하여 문서 구조, 스타일, 내용 등을 변경할 수 있게 한다.

브라우저는 HTML 문서를 로드하고 파싱하여 해당 문서에 대한 모델을 메모리에 생성한다. 이 모델은 객체의 트리로 구성되는데 이것을 DOM tree라 한다.

### DOM tree
- 모든 요소, 어트리뷰트, 텍스트는 하나의 객체, Document 객체의 자식
- 진입점: document 객체 / 최종점: 요소의 텍스트를 나타내는 객체

### DOM API
자바스크립트는 DOM을 통해 웹페이지를 조작할 수 있는 API를 제공한다.
> [DOM 관리를 자바스크립트로 직접 하는 연습 문제들](https://dev.to/jonraxa/why-i-keep-failing-my-frontend-interviews-dom-manipulation-2a18)

## 참고
* 비교<br>
    **CSSOM** (CSS Object Model)<br>
    A set of APIs allowing the manipulation of CSS from JavaScript<br>
    DOM이랑 비슷하지만 HTML보다는 CSS를 위한 것<br>
    CSS 스타일을 동적으로 읽고 수정할 수 있는 방법<br>
    https://developer.mozilla.org/ko/docs/Web/API/CSS_Object_Model

    **BOM** (Browser Object Model)<br>
    브라우저와 관련된 객체들의 집합<br>
    https://chrismare.tistory.com/m/entry/Object-ModelDOM-BOM?category=973304

* [poiemaweb - 설명 잘 되어있음](https://poiemaweb.com/js-dom)
* [MDN - DOM 설명](https://developer.mozilla.org/ko/docs/Glossary/DOM)
* [MDN - DOM이란](https://developer.mozilla.org/ko/docs/Web/API/Document_Object_Model/%EC%86%8C%EA%B0%9C)
* [스펙](https://dom.spec.whatwg.org/#introduction-to-the-dom)<br>
    In its original sense, "The DOM" is an API for accessing and manipulating documents (in particular, HTML and XML documents). In this specification, the term "document" is used for any markup-based resource, ranging from short static documents to long essays or reports with rich multimedia, as well as to fully-fledged interactive applications.

    Each such document is represented as a node tree. Some of the nodes in a tree can have children, while others are always leaves. 

* [Live dom viewer](https://software.hixie.ch/utilities/js/live-dom-viewer/)

* [TCPschool 설명](http://www.tcpschool.com/javascript/js_dom_concept)

* [모던자바스크립트 설명](https://ko.javascript.info/dom-nodes)






