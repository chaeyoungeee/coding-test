with temp as (select MEMBER_ID, rank() over(order by count(*) desc) rnk
from REST_REVIEW
group by 1)

select MEMBER_NAME, REVIEW_TEXT, date_format(REVIEW_DATE, '%Y-%m-%d') REVIEW_DATE
from temp p
join REST_REVIEW r on r.MEMBER_ID = p.MEMBER_ID
join MEMBER_PROFILE m on r.MEMBER_ID = m.MEMBER_ID
where rnk = 1
order by 3, 2