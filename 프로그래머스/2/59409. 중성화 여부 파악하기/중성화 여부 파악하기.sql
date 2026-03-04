with temp as (select distinct ANIMAL_ID
from ANIMAL_INS
where SEX_UPON_INTAKE like '%Neutered%' or SEX_UPON_INTAKE like '%Spayed%')

select a.ANIMAL_ID, a.NAME, if(t.ANIMAL_ID is null, 'X', 'O') 중성화
from ANIMAL_INS a
left join temp t on a.ANIMAL_ID = t.ANIMAL_ID
order by a.ANIMAL_ID