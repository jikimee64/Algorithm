-- https://school.programmers.co.kr/learn/courses/30/lessons/131124

-- REST_REVIEW 테이블의 MEMBER_ID 기준 개수까지는 구했지만,
-- 최대 개수를 가지는 MEMBER_ID 추출 실패

-- 실패
select t.member_id, cnt
from (select MEMBER_ID, count(MEMBER_ID) as cnt
      from REST_REVIEW
      group by MEMBER_ID
      order by count(MEMBER_ID) desc) t

-- 정답
-- https://seonjun0906.tistory.com/entry/%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%A8%B8%EC%8A%A4-SQL-%EA%B3%A0%EB%93%9D%EC%A0%90-Kit-%EA%B7%B8%EB%A3%B9%EB%B3%84-%EC%A1%B0%EA%B1%B4%EC%97%90-%EB%A7%9E%EB%8A%94-%EC%8B%9D%EB%8B%B9-%EB%AA%A9%EB%A1%9D-%EC%B6%9C%EB%A0%A5%ED%95%98%EA%B8%B0
