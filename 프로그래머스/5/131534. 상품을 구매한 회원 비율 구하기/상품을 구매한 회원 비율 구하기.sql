with temp as (
    select *
    from USER_INFO
    where year(JOINED) = '2021'
)

select year(SALES_DATE) YEAR,
        month(SALES_DATE) MONTH,
        count(distinct o.USER_ID) PURCHASED_USERS,
        round(count(distinct o.USER_ID) / (select count(*) from temp), 1) PUCHASED_RATIO
from temp u
join ONLINE_SALE o on u.USER_ID = o.USER_ID
group by YEAR, MONTH
order by YEAR, MONTH