## OneMoreThing

### Repositories   [![Hits](https://hits.seeyoufarm.com/api/count/incr/badge.svg?url=https%3A%2F%2Fgithub.com%2Fmtvs-server-second-study%2Fdeveloper-agency&count_bg=%2379C83D&title_bg=%23555555&icon=&icon_color=%23E7E7E7&title=hits&edge_flat=false)](https://hits.seeyoufarm.com)

---
# DEVELNOM (Development + 미친놈)
> **MTVS-SERVER-2ND-ONEMORETHING** <br/> **개발기간: 2023.06.21 ~ 2022.06.29**

---
## Team Member Introduction
|김종완|남효정|이주원|
|--------|--------|-------|
|<img width="160px" src="https://avatars.githubusercontent.com/u/115992753?v=4" />| <img width="160px" src="https://avatars.githubusercontent.com/u/122511826?v=4" /> | <img width="160px" src="https://avatars.githubusercontent.com/u/134987216?v=4" /> |
|<center>[@Subak-Uncle](https://github.com/Subak-Uncle)| <center>[@namhyojeong](https://github.com/namhyojeong)| <center>[@juunewon](https://github.com/juunewon)                                |

| 정재민                                            | 조명환                                           |
|------------------------------------------------|-----------------------------------------------|
|<img width="160px" src="https://avatars.githubusercontent.com/u/125876896?v=4" />|<img width="160px" src="https://avatars.githubusercontent.com/u/114536581?v=4" />                                               |
| <center>[@devJaem](https://github.com/devJaem) | <center>[@MyeongHwan](https://github.com/ChoMyeongHwan) |

---
## Project Introduction

### 디벨놈은 개발자들에게 다음과 같은 기능을 제공합니다.

### 자기소개 프로필
- 개발자들은 회원가입을 진행합니다.
- 자신의 프로필을 작성하여 전문적인 경력, 기술 스택, 프로젝트 경험 등을 소개할 수 있습니다.

---

## Getting Started Guide
### 요구사항
For building and running the application you need:

- [MySQL8.0.33](https://dev.mysql.com/downloads/mysql/)
- [Strapi 3.6.6](https://www.npmjs.com/package/strapi/v/3.6.6)

---

## Stacks 🐈

### 개발환경
<img src="https://img.shields.io/badge/Intelii J-000000?style=for-the-badge&logo=intellijidea&logoColor=white">
<img src="https://img.shields.io/badge/GitHub-000000?style=for-the-badge&logo=github&logoColor=white">

### 구성
![npm](https://img.shields.io/badge/figma-F24E1E?style=for-the-badge&logo=figma&logoColor=white)

### 사용언어
![JS](https://img.shields.io/badge/JavaScript-F7DF1E?style=for-the-badge&logo=Javascript&logoColor=white)
![springboot](https://img.shields.io/badge/springboot-6DB33F?style=for-the-badge&logo=springboot&logoColor=white)
![MYSQL](https://img.shields.io/badge/mysql-4479A1?style=for-the-badge&logo=mysql&logoColor=white)

### 소통수단
<img src="https://img.shields.io/badge/discord-5865F2?style=for-the-badge&logo=discord&logoColor=white">
<img src="https://img.shields.io/badge/Notion-000000?style=for-the-badge&logo=Notion&logoColor=white">

---
## Screen Layout 📺
[화면구성도](https://github.com/mtvs-server-second-study/developer-agency/wiki/Screen-Layout)

---
## Main Function 📦

### ⭐️ 회원가입
- 간단한 회원가입
- 향후 추가 API를 활용하여 기능업데이트 예정

### ⭐️ 프로필(게시물) 작성
- 프로필 작성만으로 이력서처럼 활용할수 있도록 DATA 변환 구축
- 프로필사진, 깃허브 잔디 업로드 지원

---
## Architecture
[Architecture](https://github.com/mtvs-server-second-study/developer-agency/wiki/Architecture)

[Reference](https://velog.io/@hanblueblue/%EB%B2%88%EC%97%AD-Layered-Architecture)

---
## directory tree
```bash
├─.github
├─.idea
├─build
└─src
    ├─main
    │  ├─java
    │  │  └─com
    │  │      └─onemorething
    │  │          └─layered
    │  │              ├─configuration
    │  │              └─menu
    │  │                  ├─application
    │  │                  │  ├─controller //각 기능 컨트롤러 모음
    │  │                  │  ├─dto //DTO 구현 디렉토리
    │  │                  │  └─service  //실제 로직 수행 클래스
    │  │                  │      └─mapper //DTO Entity 매퍼 클래스
    │  │                  ├─domain
    │  │                  │  ├─aggregate
    │  │                  │  │  ├─entity //엔티티 집합
    │  │                  │  │  ├─enumtype //기술 숙련도 Enum
    │  │                  │  ├─repository //infra/repository  인터페이스 클래스
    │  │                  │  └─service
    │  │                  │      ├─common //로그인,회원가입 유효성 로직 (공통)
    │  │                  │      └─signup //회원가입 유효성 로직
    │  │                  └─infra
    │  │                      └─repository //저장장치에 접근하는 Domain/repository를 상속받은 클래스 모음
    │  └─resources
    │      ├─mapper //SQLMapper 보관
    │      ├─static
    │      │  ├─css // CSS 보관폴더
    │      │  └─js //JS 보관폴더
    │      └─templates
    │          ├─account //회원가입, 로그인 관련 페이지
    │          └─contents // 게시물 관련 페이지
    └─test //Test 코드 구현
        └─java
            └─com
                └─onemorething
                    └─layered
                        └─menu
                            ├─application
                            │  ├─controller
                            │  └─service
                            └─domain
                                └─service
                                    ├─common
                                    ├─login
                                    │  ├─common
                                    │  └─signup
                                    └─signup

```
