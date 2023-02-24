Select *
From FOOD_PRODUCT 
Where PRICE=(Select Max(F.PRICE) From FOOD_PRODUCT F)