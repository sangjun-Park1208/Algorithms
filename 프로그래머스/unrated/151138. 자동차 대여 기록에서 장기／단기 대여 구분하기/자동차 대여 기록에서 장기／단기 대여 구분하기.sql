Select 
    HISTORY_ID,
    CAR_ID,
    DATE_FORMAT(START_DATE, '%Y-%m-%d') START_DATE,
    DATE_FORMAT(END_DATE, '%Y-%m-%d') END_DATE,
    (Case When Round(DATEDIFF(END_DATE, START_DATE)+1, 0)>=30 
     Then '장기 대여' 
     Else '단기 대여'
     End
    ) As RENT_TYPE
From CAR_RENTAL_COMPANY_RENTAL_HISTORY
Where Month(START_DATE)='9'
Order by HISTORY_ID Desc;
