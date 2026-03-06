with rate as (select replace(DURATION_TYPE, '일 이상', '') t, DISCOUNT_RATE r
             from CAR_RENTAL_COMPANY_DISCOUNT_PLAN 
             where CAR_TYPE ='트럭')

select HISTORY_ID, round(DAILY_FEE * (datediff(h.END_DATE, h.START_DATE) + 1) * ((100-ifnull(r.r, 0)) / 100)) FEE
from CAR_RENTAL_COMPANY_RENTAL_HISTORY h
join CAR_RENTAL_COMPANY_CAR c on h.CAR_ID = c.CAR_ID
left join rate r on
    case 
        when datediff(h.END_DATE, h.START_DATE) + 1 >= 90 then '90'
        when datediff(h.END_DATE, h.START_DATE) + 1 >= 30 then '30'
        when datediff(h.END_DATE, h.START_DATE) + 1 >= 7 then '7'
        else '' end 
    = r.t
where c.CAR_TYPE = '트럭'
order by 2 desc, 1 desc