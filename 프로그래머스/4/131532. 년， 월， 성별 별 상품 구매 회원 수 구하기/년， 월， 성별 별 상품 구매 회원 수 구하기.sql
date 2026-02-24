select year(SALES_DATE) YEAR, month(SALES_DATE) MONTH, GENDER, count(distinct o.USER_ID) USERS
from USER_INFO u
join ONLINE_SALE o on u.USER_ID = o.USER_ID
where GENDER is not null
group by year(SALES_DATE), month(SALES_DATE), GENDER
order by YEAR, MONTH, GENDER