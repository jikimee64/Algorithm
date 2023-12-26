-- https://school.programmers.co.kr/learn/courses/30/lessons/133027

-- 테이블의 칼럼이 같아서 union이 떠오름

-- 코드를 입력하세요
SELECT FLAVOR
from (select *
      from FIRST_HALF
      union all
      select *
      from JULY) t
group by FLAVOR
order by sum(TOTAL_ORDER) desc limit 3

