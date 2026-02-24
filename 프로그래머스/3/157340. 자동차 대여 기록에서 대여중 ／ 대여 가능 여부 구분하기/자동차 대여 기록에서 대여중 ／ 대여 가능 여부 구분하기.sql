with rent as (
    select distinct CAR_ID, '대여중' AVAILABILITY
from CAR_RENTAL_COMPANY_RENTAL_HISTORY
where START_DATE <= '2022-10-16'and END_DATE >= '2022-10-16'
)

select distinct h.CAR_ID, IFNULL(r.AVAILABILITY, '대여 가능') AVAILABILITY
from CAR_RENTAL_COMPANY_RENTAL_HISTORY h
left join rent r on h.CAR_ID = r.CAR_ID
order by h.CAR_ID desc