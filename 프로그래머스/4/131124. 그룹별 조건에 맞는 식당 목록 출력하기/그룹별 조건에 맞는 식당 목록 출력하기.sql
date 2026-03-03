with max as (select count(*) c
    from REST_REVIEW
    group by MEMBER_ID
    order by c desc
    limit 1),

    member as (select MEMBER_ID
from REST_REVIEW
group by MEMBER_ID
having count(*) = (select * from max))

select MEMBER_NAME, REVIEW_TEXT, date_format(REVIEW_DATE, '%Y-%m-%d') REVIEW_DATE
from REST_REVIEW r
join MEMBER_PROFILE m on r.MEMBER_ID = m.MEMBER_ID
where r.MEMBER_ID in (select * from member)
order by REVIEW_DATE, REVIEW_DATE