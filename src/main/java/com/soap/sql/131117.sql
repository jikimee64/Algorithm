-- https://school.programmers.co.kr/learn/courses/30/lessons/131117

-- 코드를 입력하세요
SELECT a.PRODUCT_ID, b.PRODUCT_NAME, b.price * sum(amount) as TOTAL_SALES
from (select PRODUCT_ID, amount
      from FOOD_ORDER
      where YEAR (PRODUCE_DATE) = 2022 AND MONTH (PRODUCE_DATE) = 5) a
         join FOOD_PRODUCT b on a.product_id = b.product_id
group by a.PRODUCT_ID, b.PRODUCT_NAME
order by TOTAL_SALES desc, a.PRODUCT_ID asc
