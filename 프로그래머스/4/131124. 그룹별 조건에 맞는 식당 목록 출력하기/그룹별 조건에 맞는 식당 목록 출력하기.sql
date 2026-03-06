with mid as (select MEMBER_ID
        from REST_REVIEW
          group by MEMBER_ID
          having count(*) = (select count(*) max
                                from REST_REVIEW
                                group by MEMBER_ID
                                order by max desc
                                limit 1))

select m.MEMBER_NAME, r.REVIEW_TEXT, date_format(r.REVIEW_DATE, '%Y-%m-%d') REVIEW_DATE
from REST_REVIEW r
join MEMBER_PROFILE m on r.MEMBER_ID = m.MEMBER_ID
where r.MEMBER_ID in (select MEMBER_ID from mid)
order by REVIEW_DATE, r.REVIEW_TEXT