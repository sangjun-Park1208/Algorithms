Select USER_ID, PRODUCT_ID
From ONLINE_SALE 
Group by USER_ID, PRODUCT_ID
Having Count(*)>1
Order by USER_ID, PRODUCT_ID Desc
