with five as (select CAR_ID
    from CAR_RENTAL_COMPANY_RENTAL_HISTORY
    where START_DATE >= '2022-08-01' and START_DATE < '2022-11-01'
    group by CAR_ID
    having count(*) >= 5)

select month(START_DATE) MONTH, CAR_ID, count(*) RECORDS
from five
natural join CAR_RENTAL_COMPANY_RENTAL_HISTORY 
where START_DATE >= '2022-08-01' and START_DATE < '2022-11-01'
group by CAR_ID, month(START_DATE)
having count(*) <> 0
order by MONTH, CAR_ID desc