select distinct c.CAR_ID
from CAR_RENTAL_COMPANY_CAR c
join CAR_RENTAL_COMPANY_RENTAL_HISTORY h on c.CAR_ID = h.CAR_ID
where CAR_TYPE = '세단' and START_DATE like '%-10-%'
order by  c.CAR_ID desc