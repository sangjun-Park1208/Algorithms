Select 
    CAR_TYPE, 
    Count(*) CARS
From CAR_RENTAL_COMPANY_CAR 
Where OPTIONS Like '%통풍시트%' Or OPTIONS Like '%열선시트%' Or OPTIONS Like '%가죽시트%'
Group by CAR_TYPE
Order by CAR_TYPE