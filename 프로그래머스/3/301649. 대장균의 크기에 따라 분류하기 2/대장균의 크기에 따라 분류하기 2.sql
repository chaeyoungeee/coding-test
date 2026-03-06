with rnk as (select ID, percent_rank() over(order by SIZE_OF_COLONY desc) p
from ECOLI_DATA)

select ID, case when p <= 0.25 then 'CRITICAL'
                when p <= 0.5 then 'HIGH'
                when p <= 0.75 then 'MEDIUM'
                else 'LOW' end
                COLONY_NAME       
from rnk
order by 1