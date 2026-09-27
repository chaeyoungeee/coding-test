-- select r1.REST_ID, r1.REST_NAME, r1.FOOD_TYPE, r1.FAVORITES, r1.ADDRESS, ROUND(avg(r2.REVIEW_SCORE), 2) SCORE
-- from REST_INFO r1
-- natural join REST_REVIEW r2
-- where ADDRESS like '서울%'
-- group by  r1.REST_ID, r1.REST_NAME, r1.FOOD_TYPE, r1.FAVORITES, r1.ADDRESS
-- order by SCORE desc, r1.FAVORITES desc


select i.REST_ID, i.REST_NAME, i.FOOD_TYPE, i.FAVORITES, i.ADDRESS, round(avg(r.REVIEW_SCORE), 2) SCORE
from REST_INFO i
join REST_REVIEW r on i.REST_ID = r.REST_ID
where ADDRESS like '서울%'
group by i.REST_ID, i.REST_NAME, i.FOOD_TYPE, i.FAVORITES, i.ADDRESS
order by SCORE desc, i.FAVORITES desc