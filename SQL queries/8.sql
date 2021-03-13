SELECT mc_name,mc_address 
FROM medical_center
INNER JOIN status
ON mc_statusId=s_id
WHERE mc_cityId=1
AND s_name='running';