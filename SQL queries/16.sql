SELECT m_name,mgf_name 
FROM `medicine_group_for`
INNER JOIN medicine
ON mgf_id=m_groupForId
WHERE mgf_id=1;


SELECT m_name,mgfr_name 
FROM `medicine_group_from`
INNER JOIN medicine
ON mgfr_id=m_groupFromId
WHERE mgfr_id=1;


SELECT m_name,mgh_name 
FROM `medicine_group_how`
INNER JOIN medicine
ON mgh_id=m_groupHowId
WHERE mgh_id=1;