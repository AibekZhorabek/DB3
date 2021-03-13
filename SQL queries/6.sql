SELECT d_surname,d_name,m_name,drm_efficiencyRating,drm_priceQualityRating,drm_sideEffectsRating ,drm_pros,drm_cons,drm_info
FROM doctor_review_medicine
INNER JOIN doctor
ON drm_doctorId=d_id
INNER JOIN medicine
ON drm_medicineId=m_id
INNER JOIN status
ON drm_statusId=s_id
WHERE s_name='running'
AND drm_medicineId=1;