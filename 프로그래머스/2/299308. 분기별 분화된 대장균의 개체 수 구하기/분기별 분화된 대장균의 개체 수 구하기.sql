select concat(quarter(DIFFERENTIATION_DATE), 'Q') QUARTER, count(*) ECOLI_COUNT
from ECOLI_DATA e
group by 1
order by 1