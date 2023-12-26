-- https://school.programmers.co.kr/learn/courses/30/lessons/144856

-- 틀린 답안
-- 코드를 입력하세요
SELECT a.AUTHOR_ID, ah.AUTHOR_NAME, a.CATEGORY, a.TOTAL_SALES
from (select b.book_id, b.AUTHOR_ID, b.CATEGORY, b.price * sum(bs.SALES) as TOTAL_SALES
      from BOOK b
               join BOOK_SALES bs on b.book_id = bs.book_id
      where YEAR (bs.SALES_DATE) = 2022 AND MONTH (bs.SALES_DATE) = 1
      group by b.book_id) a
         join AUTHOR ah on a.AUTHOR_ID = ah.AUTHOR_ID
group by a.AUTHOR_ID, ah.AUTHOR_NAME, a.CATEGORY
order by a.AUTHOR_ID asc, a.CATEGORY desc

-- 정답
--서브쿼리 X https://velog.io/@js4183/%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%A8%B8%EC%8A%A4-%EC%A0%80%EC%9E%90-%EB%B3%84-%EC%B9%B4%ED%85%8C%EA%B3%A0%EB%A6%AC-%EB%B3%84-%EB%A7%A4%EC%B6%9C%EC%95%A1-%EC%A7%91%EA%B3%84%ED%95%98%EA%B8%B0.MySQL
--서브쿼리 O https://heestory0324.tistory.com/68
