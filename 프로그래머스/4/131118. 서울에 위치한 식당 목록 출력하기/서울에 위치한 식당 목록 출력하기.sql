select r1.REST_ID, r1.REST_NAME, r1.FOOD_TYPE, r1.FAVORITES, r1.ADDRESS, ifnull(r2.SCORE, 0) SCORE
from REST_INFO r1
join (select ri.REST_ID, ROUND(avg(rr.REVIEW_SCORE), 2) SCORE
    from REST_INFO ri
    natural join REST_REVIEW rr
    where ADDRESS like '서울%'
    group by ri.REST_ID) r2
    on r1.REST_ID = r2.REST_ID
order by r2.SCORE desc, r1.FAVORITES desc