--Where can patients/users buy this medicine?
SELECT ph_name,ph_address
FROM medicine_pharmacy
INNER JOIN medicine
ON mp_medicineId=m_id
INNER JOIN pharmacy
ON mp_pharmacyId=ph_id
INNER JOIN status
ON ph_statusId=s_id
WHERE mp_medicineId=1
AND s_name='running'
AND ph_cityId=1;
