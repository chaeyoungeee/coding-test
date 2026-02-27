select distinct ID, EMAIL, FIRST_NAME, LAST_NAME
from DEVELOPERS d, SKILLCODES s
where s.CATEGORY = 'Front End' and
            s.CODE & d.SKILL_CODE = s.CODE
order by ID