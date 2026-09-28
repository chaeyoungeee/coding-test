-- SELECT MCDP_CD '진료과코드', count(*) '5월예약건수'
-- FROM appointment
-- WHERE APNT_YMD >= '2022-05-01'
-- AND APNT_YMD <= '2022-05-31'
-- GROUP BY MCDP_CD   
-- ORDER BY '5월예약건수', '진료과코드'



SELECT MCDP_CD "진료과코드", COUNT(*) "5월예약건수"
FROM APPOINTMENT
WHERE APNT_YMD >= TO_DATE('2022-05-01', 'YYYY-MM-DD')
AND APNT_YMD < TO_DATE('2022-06-01', 'YYYY-MM-DD')
GROUP BY MCDP_CD
ORDER BY "5월예약건수", "진료과코드"