select distinct ANIMAL_ID, NAME
from ANIMAL_OUTS
where ANIMAL_ID not in (
    select distinct ANIMAL_ID from ANIMAL_INS
)