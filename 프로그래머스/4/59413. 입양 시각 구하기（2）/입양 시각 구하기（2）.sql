set @hour := -1;

select @hour := @hour + 1 HOUR, (select count(*) from ANIMAL_OUTS o where hour(o.DATETIME) = @hour) COUNT
from ANIMAL_OUTS
where @hour < 23