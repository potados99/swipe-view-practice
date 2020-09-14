# swipe-view-practice

<img src="/docs/screenshot.png" width="300"/>

> 스크린샷

<img src="/docs/layout-inspector.png"/>

> Layout Inspector

PlayStore나 AppStore처럼 세로 스크롤 뷰 속에 가로 스크롤 컨텐츠 넣어 보기.

## 뷰 계층

<img src="/docs/screenshot-marked.png" width="300"/>

~~~
root
  └ the_section_recycler
    └ Section
      └ the_prop_stack_pager
        └ Prop Stack
          └ the_prop_recycler
            └ Prop
          └ ...
        └ ...
      └ ...
    └ ...
~~~
