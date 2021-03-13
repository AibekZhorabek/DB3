SELECT m_name,ph_name,mp_price
FROM medicine_pharmacy
INNER JOIN medicine
ON mp_medicineId=m_id
INNER JOIN pharmacy
ON mp_pharmacyId=ph_id
INNER JOIN status
ON ph_statusId=s_id
WHERE mp_medicineId=2
AND s_name='running'
AND ph_cityId=1;