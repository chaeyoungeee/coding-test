select count(*) FISH_COUNT
from FISH_INFO
where FISH_TYPE in (select distinct FISH_TYPE
                   from FISH_NAME_INFO
                   where FISH_NAME = 'BASS' or FISH_NAME = 'SNAPPER')