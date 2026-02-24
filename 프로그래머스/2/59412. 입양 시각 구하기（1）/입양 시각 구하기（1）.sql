select hour(DATETIME) HOUR, count(*) COUNT
from ANIMAL_OUTS
where hour(DATETIME) between 9 and 19
group by HOUR
order by HOUR