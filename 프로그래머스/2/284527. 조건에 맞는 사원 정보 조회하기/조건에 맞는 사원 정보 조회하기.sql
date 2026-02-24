select a.SCORE, b.EMP_NO, b.EMP_NAME, b.POSITION, b.EMAIL
from (select g.EMP_NO, sum(SCORE) SCORE
    from HR_EMPLOYEES e
    join HR_GRADE g on e.EMP_NO = g.EMP_NO
    where YEAR = '2022'
    group by g.EMP_NO
    order by SCORE desc
    limit 1) a
join HR_EMPLOYEES b on a.EMP_NO = b.EMP_NO

