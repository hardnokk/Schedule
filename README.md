### API 명세서
|기능|Method|URL|request|response|
|-----------|----|----------|------------------|------------------|
|일정 단건 등록|POST|/schedules|{</br>"title" : "제목",</br>"content" : "내용",</br>"name" : "작성자",</br>"password" : "비밀번호"</br>} | {</br>"Id" : "id",</br>"title" : "제목",</br>"content" : "내용",</br>"name" : "작성자",</br>"createTime" : "작성일"</br>"updateTime" : "수정일"</br>}|
|일정 전체 조회|GET|/schedules||{</br>"Id" : "id",</br>"title" : "제목",</br>"content" : "내용",</br>"name" : "작성자",</br>"createTime" : "작성일"</br>"updateTime" : "수정일"</br>}|
|일정 단건 조회|GET|/schedules/{Id}|{</br>"Id" : "id"</br>} | {</br>"Id" : "id",</br>"title" : "제목",</br>"content" : "내용",</br>"name" : "작성자",</br>"createTime" : "작성일"</br>"updateTime" : "수정일"</br>}|
|일정 단건 수정|PUT|/schedules/{Id}/{password}|{</br>"Id" : "id"</br>"password" : "비밀번호"</br>"content" : "내용"</br>"name" : "작성자"</br>} | {</br>"Id" : "id",</br>"title" : "제목",</br>"content" : "내용",</br>"name" : "작성자",</br>"createTime" : "작성일"</br>"updateTime" : "수정일"</br>}|
|일정 단건 삭제|DELETE|/schedules/{Id}/{password}|{</br>"Id" : "id"</br>"password" : "비밀번호"</br>} |


### ERD
![schedule](https://github.com/user-attachments/assets/d17117ca-8ec7-429c-8264-ad5cd567a698)
