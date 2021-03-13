SELECT d_name,m_name,drm_pros,drm_info,drm_cons,drm_efficiencyRating,drm_priceQualityRating,drm_sideEffectsRating,drm_postDate
FROM doctor_review_medicine
INNER JOIN doctor
ON drm_doctorId=d_id
INNER JOIN medicine
ON drm_medicineId=m_id
INNER JOIN status
ON drm_statusId=s_id
WHERE drm_doctorId=1 
AND m_id=1
AND s_name='running'