# **개발자 분양합니다.**

## **필수 기능**

### **검색 - 로그인/회원가입 - 메인 홈 - 상세 페이지, 마이페이지**

### **DB 설계 - DB, 회원DB , 언어 DB**

## **부가 기능**

회원가입 인증/주소 입력(카카오 주소 검색)/ 카카오 로그인/ 네이버 로그인/ 깃허브 로그인 / 링크드인 -  네이버 챗봇/바빌론

- [개발자 채용](https://www.rocketpunch.com/people)
- [개발자 스택 기준 채용](https://holaworld.io/)

## 파트 분배

---

- 로그인/회원가입 : 정재민, 남효정
- 메인/상세페이지/검색 : 김종완, 이주원, 조명환

---

## 플로우차트
main -> 로그인/회원가입 -> 로그인 -> 메인/홈 -> 상세페이지
                                        -> 마이페이지

/common/util - 부가기능 ex) 파일 읽기
/configuration - 실행, ContextConfiguration
/database - mybatis (SQL)

/menu/application/
/controller - 서비스 매핑 (분배) 보내고 받아와서 모델에 담는다
/dto - application 내의 데이터 이동
/service - 로직검증호출

/menu/domain/aggregate -도메인 내부의 데이터 전송
/entity --db에 저장할 단위를 만들어줌
/enumtype Y N 만 있음
/vo 실제 예외처리 로직

/exception -예외검증 (호출만)
/repository - 인터페이스 (인프라에 상속시켜줌, 의존성 역전)
/service - 인터페이스 (인프라에 상속시켜줌, 의존성 역전) ,
/valid - 검증 

/menu/infra
/repository - DB랑 직접적인 연결만 
/service- 서비스 인터페이스를 오버라이딩
## 참고 사이트

- [https://inpa.tistory.com/entry/CSS-💍-로그인-회원가입-페이지-스타일-🖌️-모음](https://inpa.tistory.com/entry/CSS-%F0%9F%92%8D-%EB%A1%9C%EA%B7%B8%EC%9D%B8-%ED%9A%8C%EC%9B%90%EA%B0%80%EC%9E%85-%ED%8E%98%EC%9D%B4%EC%A7%80-%EC%8A%A4%ED%83%80%EC%9D%BC-%F0%9F%96%8C%EF%B8%8F-%EB%AA%A8%EC%9D%8C)