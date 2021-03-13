--What are pharmacies in the patient/user’s city?
SELECT ph_id,ph_name,ph_address,ph_phone
FROM pharmacy 
INNER JOIN status
ON ph_statusId=s_id
WHERE ph_cityId=3 
AND s_name='running';
