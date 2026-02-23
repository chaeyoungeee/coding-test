with recursive GEN as (
    select ID, PARENT_ID, 1 gen
    from ECOLI_DATA
    where PARENT_ID is null
    
    union all
    
    select e.ID, e.PARENT_ID, g.gen + 1 gen
    from ECOLI_DATA e
    join gen g on e.PARENT_ID = g.ID
)

 
select count(id) COUNT, gen GENERATION 
from GEN g
where g.ID not in (
   select PARENT_ID from ECOLI_DATA where PARENT_ID is not null
)
group by gen
order by gen