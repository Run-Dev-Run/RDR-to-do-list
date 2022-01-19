# Diary Rest API

## Diary 구조

```json
{
  "id": "number",
  "author": "string",
  "status": "string",
  "title": "string",
  "content": "string"
}
```

## 요구사항

* 다이어리는 `title`과 `content`만 수정이 가능하다.
* 처음 만든 다이어리의 `status`는 `TODO`이다.
* 다이어리를 삭제할 경우 `status` 값이 `DELETED`가 된다.
* 다이어리의 상태 변경은 두 가지가 존재한다.
  * `TODO`에서 `DOING`으로
  * `DOING`에서 `DONE`으로
* `DONE`에서 상태 변경이 불가하다.
* `status`가 `DELETED`인 다이어리는 조회할 수 없다.

## Diary 생성

> POST http://localhost:8080/api/v1/diaries

> Request
> ```json
> {
>   "author": "string",
>   "title": "string",
>   "content": "string"
> }
> ```

> Response
> ```json
> {
>   "localDateTime": "number",
>   "message": "string",
>   "code": "string",
>   "result": {
>     "author": "string",
>     "status": "string",
>     "title": "string",
>     "content": "string",
>     "createDate": "number",
>     "modifiedDate": "number"
>   }
> }
> ```

## Diary 전체 조회

> GET http://localhost:8080/api/v1/diaries

> Response
> ```json
> {
>   "localDateTime": "number",
>   "message": "string",
>   "code": "string",
>   "result": {
>     "totalCount": "number",
>     "diaries": [
>       {
>         "author": "string",
>         "status": "string",
>         "title": "string",
>         "content": "string",
>         "createDate": "number",
>         "modifiedDate": "number"
>       }
>     ]
> }
> ```

## Diary 하나 조회

> GET http://localhost:8080/api/v1/diaries/{id}

> Request
> ```json
> {
>   "id": "number"
> }
> ```

> Response
> ```json
> {
>   "localDateTime": "number",
>   "message": "string",
>   "code": "string",
>   "result": {
>     "author": "string",
>     "status": "string",
>     "title": "string",
>     "content": "string",
>     "createDate": "number",
>     "modifiedDate": "number"
>   }
> }
> ```

## Diary 수정

> PUT http://localhost:8080/api/v1/diaries/{id}

> Request
> ```json
> {
>   "id": "number"
>   "title": "string",
>   "content": "string"
> }
> ```

> Response
> ```json
> {
>   "localDateTime": "number",
>   "message": "string",
>   "code": "string",
>   "result": {
>     "author": "string",
>     "status": "string",
>     "title": "string",
>     "content": "string",
>     "createDate": "number",
>     "modifiedDate": "number"
>   }
> }
> ```

## Diary 상태 수정

> PATCH http://localhost:8080/api/v1/diaries/{id}

> Request
> ```json
> {
>   "id": "number"
>   "author": "string",
>   "title": "string",
>   "content": "string"
> }
> ```

> Response
> ```json
> {
>   "localDateTime": "number",
>   "message": "string",
>   "code": "string",
>   "result": {
>     "author": "string",
>     "status": "string",
>     "title": "string",
>     "content": "string",
>     "createDate": "number",
>     "modifiedDate": "number"
>   }
> }
> ```

## Diary 삭제

> DELETE http://localhost:8080/api/v1/diaries/{id}

> Request
> ```json
> {
>   "id": "number"
> }
> ```

> Response
> ```json
> {
>   "localDateTime": "number",
>   "message": "string",
>   "code": "string",
>   "result": {
>     "author": "string",
>     "status": "string",
>     "title": "string",
>     "content": "string",
>     "createDate": "number",
>     "modifiedDate": "number"
>   }
> }
> ```