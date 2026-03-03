set @hour := -1;
select (@hour := @hour + 1) HOUR, 
    (select count(*) from ANIMAL_OUTS where @hour = hour(DATETIME)) COUNT
from ANIMAL_OUTS
where @hour < 23
order by @hour