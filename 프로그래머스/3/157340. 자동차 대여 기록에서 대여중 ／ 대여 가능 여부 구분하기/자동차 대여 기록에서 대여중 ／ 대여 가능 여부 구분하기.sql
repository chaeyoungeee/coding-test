select h.CAR_ID, case when c.CAR_ID is null then '대여 가능'
                    else '대여중' end
                    AVAILABILITY
                    
from

((select distinct CAR_ID
from CAR_RENTAL_COMPANY_RENTAL_HISTORY) h

left join 

(select distinct CAR_ID
from CAR_RENTAL_COMPANY_RENTAL_HISTORY
where '2022-10-16' between START_DATE and END_DATE
order by 1) c 

on c.CAR_ID = h.CAR_ID) 

order by 1 desc