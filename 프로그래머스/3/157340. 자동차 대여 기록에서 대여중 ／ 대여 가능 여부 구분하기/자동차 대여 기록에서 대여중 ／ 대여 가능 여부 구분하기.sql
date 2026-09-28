SELECT DISTINCT CAR_ID, CASE 
                            WHEN CAR_ID IN (SELECT DISTINCT CAR_ID
                                                FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
                                                WHERE START_DATE <= TO_DATE('20221016', 'YYYYMMDD') 
                                                    AND END_DATE >= TO_DATE('20221016', 'YYYYMMDD')) THEN '대여중'
                            ELSE '대여 가능'
                END AS AVAILABILITY
FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
ORDER BY CAR_ID DESC


-- SELECT CAR_ID, START_DATE, END_DATE
-- FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
-- ORDER BY CAR_ID DESC