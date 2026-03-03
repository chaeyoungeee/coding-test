with temp as (select MEMBER_ID, rank() over(order by count(*) desc) r
from REST_REVIEW
group by MEMBER_ID)

select MEMBER_NAME, REVIEW_TEXT, date_format(REVIEW_DATE,'%Y-%m-%d') REVIEW_DATE
from temp t
join REST_REVIEW r on t.MEMBER_ID = r.MEMBER_ID
join MEMBER_PROFILE m on r.MEMBER_ID = m.MEMBER_ID
where t.r = 1
order by REVIEW_DATE, REVIEW_TEXT