with rent as (select CAR_ID
from CAR_RENTAL_COMPANY_RENTAL_HISTORY
where START_DATE <= '2022-11-30' and END_DATE >= '2022-11-01'
order by END_DATE)

select c.CAR_ID, c.CAR_TYPE, ROUND(DAILY_FEE * 30 * (100 - DISCOUNT_RATE) / 100) FEE
from CAR_RENTAL_COMPANY_CAR c
join CAR_RENTAL_COMPANY_DISCOUNT_PLAN p on c.CAR_TYPE = p.CAR_TYPE
where c.CAR_TYPE in ('SUV', '세단')
    and DURATION_TYPE = '30일 이상'
    and (c.CAR_ID) not in (select * from rent)
    and DAILY_FEE * 30 * (100 - DISCOUNT_RATE) / 100 >= 500000 and DAILY_FEE * 30 * (100 - DISCOUNT_RATE) / 100 <= 2000000
order by FEE desc, c.CAR_TYPE, c.CAR_ID desc