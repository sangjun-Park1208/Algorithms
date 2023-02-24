Select 
    DATE_FORMAT(DATETIME, '%H') HOUR,
    Count(*) COUNT
From ANIMAL_OUTS 
Group by HOUR
Having HOUR Between 9 And 19
Order by HOUR 