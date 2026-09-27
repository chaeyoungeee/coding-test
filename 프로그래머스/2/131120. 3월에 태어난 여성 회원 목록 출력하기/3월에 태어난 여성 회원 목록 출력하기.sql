-- select MEMBER_ID, MEMBER_NAME, GENDER, date_format(DATE_OF_BIRTH, '%Y-%m-%d') DATE_OF_BIRTH
-- from MEMBER_PROFILE
-- where month(DATE_OF_BIRTH) = '03' and GENDER = 'W' and TLNO is not null
-- order by MEMBER_ID

select MEMBER_ID, MEMBER_NAME, GENDER, to_char(DATE_OF_BIRTH, 'YYYY-MM-DD') DATE_OF_BIRTH
from MEMBER_PROFILE
where to_char(DATE_OF_BIRTH, 'MM') = '03' and GENDER = 'W' and TLNO is not null
order by MEMBER_ID