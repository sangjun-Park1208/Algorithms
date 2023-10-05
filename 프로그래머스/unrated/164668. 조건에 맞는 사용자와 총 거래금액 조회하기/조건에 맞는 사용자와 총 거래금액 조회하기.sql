SELECT USER_ID, NICKNAME, SUM(PRICE) AS TOTAL_SALES
FROM USED_GOODS_BOARD B, USED_GOODS_USER U
WHERE B.WRITER_ID=U.USER_ID 
    AND B.STATUS LIKE 'DONE'
GROUP BY B.WRITER_ID
HAVING TOTAL_SALES >= 700000
ORDER BY TOTAL_SALES