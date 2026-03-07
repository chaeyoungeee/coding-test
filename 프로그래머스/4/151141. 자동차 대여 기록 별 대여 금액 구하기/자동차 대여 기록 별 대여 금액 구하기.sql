select HISTORY_ID, round((DAILY_FEE * (datediff(END_DATE, START_DATE) + 1))*(100-ifnull(DISCOUNT_RATE, 0))/100) FEE
from CAR_RENTAL_COMPANY_CAR c
join CAR_RENTAL_COMPANY_RENTAL_HISTORY h on c.CAR_ID = h.CAR_ID
left join CAR_RENTAL_COMPANY_DISCOUNT_PLAN p on c.CAR_TYPE = p.CAR_TYPE
        and case when datediff(END_DATE, START_DATE) + 1 >= 90 then '90'
                when datediff(END_DATE, START_DATE) + 1 >= 30 then '30'
                when datediff(END_DATE, START_DATE) + 1 >= 7 then '7'
                else '' end
                = REPLACE(DURATION_TYPE, '일 이상', '')
where c.CAR_TYPE = '트럭'
order by 2 desc, 1 desc