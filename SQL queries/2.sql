SELECT ph_name,m_name 
FROM medicine_pharmacy
INNER JOIN status
ON mp_statusId=s_id
INNER JOIN medicine
ON mp_medicineId=m_id
INNER JOIN pharmacy
ON mp_pharmacyId=ph_id
WHERE s_name='running'
AND mp_pharmacyId=1;