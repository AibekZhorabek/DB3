CREATE TABLE `appointment` (
  `a_id` int(11) NOT NULL,
  `a_userId` int(11) NOT NULL,
  `a_doctorMedCenterId` int(11) NOT NULL,
  `a_statusId` int(11) NOT NULL DEFAULT '1',
  `a_doctorWorkingHourId` int(11) NOT NULL
);

CREATE TABLE `appointment_type` (
  `at_id` int(11) NOT NULL,
  `at_name` varchar(50) NOT NULL
);

CREATE TABLE `city` (
  `c_id` int(11) NOT NULL,
  `c_name` varchar(50) NOT NULL
);

CREATE TABLE `clinic_group` (
  `cg_id` int(11) NOT NULL,
  `cg_name` varchar(200) NOT NULL
);


CREATE TABLE `doctor` (
  `d_id` int(11) NOT NULL,
  `d_email` varchar(50) NOT NULL,
  `d_password` varchar(50) NOT NULL,
  `d_name` varchar(50) NOT NULL,
  `d_surname` varchar(50) NOT NULL,
  `d_phone` varchar(20) NOT NULL,
  `d_gender` varchar(20) NOT NULL,
  `d_briefInfo` text NOT NULL,
  `d_experience` int(2) NOT NULL,
  `d_statusId` int(11) NOT NULL DEFAULT '2'
);

CREATE TABLE `doctor_education_history` (
  `deh_id` int(11) NOT NULL,
  `deh_placeName` varchar(200) NOT NULL,
  `deh_year` varchar(4) NOT NULL,
  `deh_doctorId` int(11) NOT NULL
);

CREATE TABLE `doctor_job_history` (
  `djh_id` int(11) NOT NULL,
  `djh_placeName` varchar(200) NOT NULL,
  `djh_startedYear` varchar(4) NOT NULL,
  `djh_finishedYear` varchar(4) NOT NULL,
  `djh_profession` varchar(200) NOT NULL,
  `djh_doctorId` int(11) NOT NULL
);

CREATE TABLE `doctor_medical_center` (
  `dmc_id` int(11) NOT NULL,
  `dmc_price` int(7) NOT NULL,
  `dmc_doctorId` int(11) NOT NULL,
  `dmc_medCenterId` int(11) NOT NULL,
  `dmc_professionId` int(11) NOT NULL,
  `dmc_appointmentTypeId` int(11) NOT NULL,
  `dmc_statusId` int(11) NOT NULL DEFAULT '1'
);

CREATE TABLE `doctor_review_medicine` (
  `drm_id` int(11) NOT NULL,
  `drm_doctorId` int(11) NOT NULL,
  `drm_medicineId` int(11) NOT NULL,
  `drm_pros` text NOT NULL,
  `drm_cons` text NOT NULL,
  `drm_info` text NOT NULL,
  `drm_efficiencyRating` double(2,1) NOT NULL,
  `drm_priceQualityRating` double(2,1) NOT NULL,
  `drm_sideEffectsRating` double(2,1) NOT NULL,
  `drm_postDate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `drm_statusId` int(11) NOT NULL DEFAULT '1'
);


CREATE TABLE `doctor_working_hour` (
  `dwh_id` int(11) NOT NULL,
  `dwh_doctorId` int(11) NOT NULL,
  `dwh_medCenterId` int(11) NOT NULL,
  `dwh_numOfDay` int(2) NOT NULL,
  `dwh_time` time NOT NULL,
  `dwh_statusId` int(11) NOT NULL DEFAULT '1'
);


CREATE TABLE `medical_center` (
  `mc_id` int(11) NOT NULL,
  `mc_name` varchar(200) NOT NULL,
  `mc_phone` varchar(20) NOT NULL,
  `mc_address` varchar(200) NOT NULL,
  `mc_type` varchar(200) NOT NULL,
  `mc_briefInfo` text NOT NULL,
  `mc_info` mediumtext NOT NULL,
  `mc_statusId` int(11) NOT NULL DEFAULT '2',
  `mc_cityId` int(11) NOT NULL,
  `mc_clinicGroupId` int(11) NOT NULL
);


CREATE TABLE `medicine` (
  `m_id` int(11) NOT NULL,
  `m_name` varchar(200) NOT NULL,
  `m_manufacturer` varchar(200) NOT NULL,
  `m_shortDescription` mediumtext NOT NULL,
  `m_pharmacology` mediumtext NOT NULL,
  `m_dosage` mediumtext NOT NULL,
  `m_sideEffect` mediumtext NOT NULL,
  `m_indication` mediumtext NOT NULL,
  `m_contraindication` mediumtext NOT NULL,
  `m_groupForId` int(11) NOT NULL,
  `m_groupHowId` int(11) NOT NULL,
  `m_groupFromId` int(11) NOT NULL
);

CREATE TABLE `medicine_group_for` (
  `mgf_id` int(11) NOT NULL,
  `mgf_name` varchar(200) NOT NULL
);

CREATE TABLE `medicine_group_from` (
  `mgfr_id` int(11) NOT NULL,
  `mgfr_name` varchar(200) NOT NULL
);

CREATE TABLE `medicine_group_how` (
  `mgh_id` int(11) NOT NULL,
  `mgh_name` varchar(200) NOT NULL
);


CREATE TABLE `medicine_pharmacy` (
  `mp_id` int(11) NOT NULL,
  `mp_pharmacyId` int(11) NOT NULL,
  `mp_medicineId` int(11) NOT NULL,
  `mp_price` int(7) NOT NULL,
  `mp_statusId` int(11) NOT NULL DEFAULT '1'
);


CREATE TABLE `pharmacy` (
  `ph_id` int(11) NOT NULL,
  `ph_name` varchar(200) NOT NULL,
  `ph_address` varchar(200) NOT NULL,
  `ph_phone` varchar(20) NOT NULL,
  `ph_statusId` int(11) NOT NULL DEFAULT '2',
  `ph_cityId` int(11) NOT NULL
);


CREATE TABLE `profession` (
  `pr_id` int(11) NOT NULL,
  `pr_name` varchar(70) NOT NULL
);



CREATE TABLE `role` (
  `r_id` int(11) NOT NULL,
  `r_name` varchar(50) NOT NULL
);



CREATE TABLE `status` (
  `s_id` int(11) NOT NULL,
  `s_name` varchar(50) NOT NULL
);



CREATE TABLE `user` (
  `u_id` int(11) NOT NULL,
  `u_email` varchar(50) NOT NULL,
  `u_password` varchar(50) NOT NULL,
  `u_name` varchar(50) NOT NULL,
  `u_surname` varchar(50) NOT NULL,
  `u_phone` varchar(20) NOT NULL,
  `u_gender` varchar(20) NOT NULL,
  `u_roleId` int(11) NOT NULL DEFAULT '2',
  `u_statusId` int(11) NOT NULL DEFAULT '1'
);

CREATE TABLE `user_comment_medicine` (
  `ucm_id` int(11) NOT NULL,
  `ucm_userId` int(11) NOT NULL,
  `ucm_medicineId` int(11) NOT NULL,
  `ucm_info` text NOT NULL,
  `ucm_postDate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `ucm_statusId` int(11) NOT NULL DEFAULT '1'
);


CREATE TABLE `user_review_doctor` (
  `urd_id` int(11) NOT NULL,
  `urd_userId` int(11) NOT NULL,
  `urd_medCenterId` int(11) NOT NULL,
  `urd_doctorId` int(11) NOT NULL,
  `urd_appointmentDate` date NOT NULL,
  `urd_info` text NOT NULL,
  `urd_pros` text NOT NULL,
  `urd_cons` text NOT NULL,
  `urd_postDate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `urd_statusId` int(11) NOT NULL DEFAULT '1',
  `urd_carefulnessRating` double(2,1) NOT NULL,
  `urd_efficiencyRating` double(2,1) NOT NULL,
  `urd_attitudeRating` double(2,1) NOT NULL,
  `urd_informingRating` double(2,1) NOT NULL,
  `urd_willAdviseRating` double(2,1) NOT NULL
);


CREATE TABLE `user_review_medcenter` (
  `urm_id` int(11) NOT NULL,
  `urm_userId` int(11) NOT NULL,
  `urm_medCenterId` int(11) NOT NULL,
  `urm_doctorId` int(11) NOT NULL,
  `urm_appointmentDate` date NOT NULL,
  `urm_info` text NOT NULL,
  `urm_pros` text NOT NULL,
  `urm_cons` text NOT NULL,
  `urm_postDate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `urm_statusId` int(11) NOT NULL DEFAULT '1',
  `urm_buildingRating` double(2,1) NOT NULL,
  `urm_equipmentRating` double(2,1) NOT NULL,
  `urm_attitudeRating` double(2,1) NOT NULL,
  `urm_comfortRating` double(2,1) NOT NULL,
  `urm_punctualityRating` double(2,1) NOT NULL
);

ALTER TABLE `appointment`
  ADD PRIMARY KEY (`a_id`),
  ADD KEY `a_doctorMedCenterId_fk` (`a_doctorMedCenterId`),
  ADD KEY `a_doctorWorkingHourId_fk` (`a_doctorWorkingHourId`),
  ADD KEY `a_statusId_fk` (`a_statusId`),
  ADD KEY `a_userId_fk` (`a_userId`);


ALTER TABLE `appointment_type`
  ADD PRIMARY KEY (`at_id`),
  ADD UNIQUE KEY `at_name_uniq` (`at_name`);


ALTER TABLE `city`
  ADD PRIMARY KEY (`c_id`),
  ADD UNIQUE KEY `c_name_uniq` (`c_name`);


ALTER TABLE `clinic_group`
  ADD PRIMARY KEY (`cg_id`),
  ADD UNIQUE KEY `cg_name_uniq` (`cg_name`);


ALTER TABLE `doctor`
  ADD PRIMARY KEY (`d_id`),
  ADD UNIQUE KEY `d_email_uniq` (`d_email`),
  ADD KEY `d_statusId_fk` (`d_statusId`);


ALTER TABLE `doctor_education_history`
  ADD PRIMARY KEY (`deh_id`),
  ADD KEY `deh_doctorId_fk` (`deh_doctorId`);


ALTER TABLE `doctor_job_history`
  ADD PRIMARY KEY (`djh_id`),
  ADD KEY `djh_doctorId_fk` (`djh_doctorId`);


ALTER TABLE `doctor_medical_center`
  ADD PRIMARY KEY (`dmc_id`),
  ADD KEY `dmc_appointmentTypeId_fk` (`dmc_appointmentTypeId`),
  ADD KEY `dmc_doctorId_fk` (`dmc_doctorId`),
  ADD KEY `dmc_medCenterId_fk` (`dmc_medCenterId`),
  ADD KEY `dmc_professionId_fk` (`dmc_professionId`),
  ADD KEY `dmc_statusId_fk` (`dmc_statusId`);


ALTER TABLE `doctor_review_medicine`
  ADD PRIMARY KEY (`drm_id`),
  ADD KEY `drm_doctorId_fk` (`drm_doctorId`),
  ADD KEY `drm_statusId_fk` (`drm_statusId`),
  ADD KEY `drm_medicineId_fk` (`drm_medicineId`);


ALTER TABLE `doctor_working_hour`
  ADD PRIMARY KEY (`dwh_id`),
  ADD KEY `dwh_doctorId_fk` (`dwh_doctorId`),
  ADD KEY `dwh_medCenterId_fk` (`dwh_medCenterId`),
  ADD KEY `dwh_statusId_fk` (`dwh_statusId`);


ALTER TABLE `medical_center`
  ADD PRIMARY KEY (`mc_id`),
  ADD KEY `mc_statusId_fk` (`mc_statusId`),
  ADD KEY `mc_cityId_fk` (`mc_cityId`),
  ADD KEY `mc_clinicGroupId_fk` (`mc_clinicGroupId`);


ALTER TABLE `medicine`
  ADD PRIMARY KEY (`m_id`),
  ADD UNIQUE KEY `m_name_uniq` (`m_name`),
  ADD KEY `m_groupForId_fk` (`m_groupForId`),
  ADD KEY `m_groupFromId_fk` (`m_groupFromId`),
  ADD KEY `m_groupHowId_fk` (`m_groupHowId`);


ALTER TABLE `medicine_group_for`
  ADD PRIMARY KEY (`mgf_id`),
  ADD UNIQUE KEY `mgf_name_uniq` (`mgf_name`);


ALTER TABLE `medicine_group_from`
  ADD PRIMARY KEY (`mgfr_id`),
  ADD UNIQUE KEY `mgfr_name_uniq` (`mgfr_name`);


ALTER TABLE `medicine_group_how`
  ADD PRIMARY KEY (`mgh_id`),
  ADD UNIQUE KEY `mgh_name_uniq` (`mgh_name`);


ALTER TABLE `medicine_pharmacy`
  ADD PRIMARY KEY (`mp_id`),
  ADD KEY `mp_pharmacyId_fk` (`mp_pharmacyId`),
  ADD KEY `mp_medicineId_fk` (`mp_medicineId`),
  ADD KEY `mp_statusId_fk` (`mp_statusId`);


ALTER TABLE `pharmacy`
  ADD PRIMARY KEY (`ph_id`),
  ADD KEY `ph_statusId_fk` (`ph_statusId`),
  ADD KEY `ph_cityId_fk` (`ph_cityId`);


ALTER TABLE `profession`
  ADD PRIMARY KEY (`pr_id`),
  ADD UNIQUE KEY `pr_name_uniq` (`pr_name`);

--
-- Индексы таблицы `role`
--
ALTER TABLE `role`
  ADD PRIMARY KEY (`r_id`),
  ADD UNIQUE KEY `r_name_uniq` (`r_name`);

--
-- Индексы таблицы `status`
--
ALTER TABLE `status`
  ADD PRIMARY KEY (`s_id`),
  ADD UNIQUE KEY `s_name_uniq` (`s_name`);

--
-- Индексы таблицы `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`u_id`),
  ADD UNIQUE KEY `u_email_uniq` (`u_email`),
  ADD KEY `u_roleId_fk` (`u_roleId`),
  ADD KEY `u_statusId_fk` (`u_statusId`);

--
-- Индексы таблицы `user_comment_medicine`
--
ALTER TABLE `user_comment_medicine`
  ADD PRIMARY KEY (`ucm_id`),
  ADD KEY `ucm_userId_fk` (`ucm_userId`),
  ADD KEY `ucm_medicineId_fk` (`ucm_medicineId`),
  ADD KEY `ucm_statusId_fk` (`ucm_statusId`);

--
-- Индексы таблицы `user_review_doctor`
--
ALTER TABLE `user_review_doctor`
  ADD PRIMARY KEY (`urd_id`),
  ADD KEY `urd_doctorId_fk` (`urd_doctorId`),
  ADD KEY `urd_medCenterId_fk` (`urd_medCenterId`),
  ADD KEY `urd_statusId_fk` (`urd_statusId`),
  ADD KEY `urd_userId_fk` (`urd_userId`);

--
-- Индексы таблицы `user_review_medcenter`
--
ALTER TABLE `user_review_medcenter`
  ADD PRIMARY KEY (`urm_id`),
  ADD KEY `urm_doctorId_fk` (`urm_doctorId`),
  ADD KEY `urm_medCenterId_fk` (`urm_medCenterId`),
  ADD KEY `urm_statusId_fk` (`urm_statusId`),
  ADD KEY `urm_userId_fk` (`urm_userId`);


ALTER TABLE `appointment`
  MODIFY `a_id` int(11) NOT NULL AUTO_INCREMENT;


ALTER TABLE `appointment_type`
  MODIFY `at_id` int(11) NOT NULL AUTO_INCREMENT;


ALTER TABLE `city`
  MODIFY `c_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT для таблицы `clinic_group`
--
ALTER TABLE `clinic_group`
  MODIFY `cg_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT для таблицы `doctor`
--
ALTER TABLE `doctor`
  MODIFY `d_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT для таблицы `doctor_education_history`
--
ALTER TABLE `doctor_education_history`
  MODIFY `deh_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT для таблицы `doctor_job_history`
--
ALTER TABLE `doctor_job_history`
  MODIFY `djh_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT для таблицы `doctor_medical_center`
--
ALTER TABLE `doctor_medical_center`
  MODIFY `dmc_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT для таблицы `doctor_review_medicine`
--
ALTER TABLE `doctor_review_medicine`
  MODIFY `drm_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT для таблицы `doctor_working_hour`
--
ALTER TABLE `doctor_working_hour`
  MODIFY `dwh_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT для таблицы `medical_center`
--
ALTER TABLE `medical_center`
  MODIFY `mc_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT для таблицы `medicine`
--
ALTER TABLE `medicine`
  MODIFY `m_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT для таблицы `medicine_group_for`
--
ALTER TABLE `medicine_group_for`
  MODIFY `mgf_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT для таблицы `medicine_group_from`
--
ALTER TABLE `medicine_group_from`
  MODIFY `mgfr_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT для таблицы `medicine_group_how`
--
ALTER TABLE `medicine_group_how`
  MODIFY `mgh_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT для таблицы `medicine_pharmacy`
--
ALTER TABLE `medicine_pharmacy`
  MODIFY `mp_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT для таблицы `pharmacy`
--
ALTER TABLE `pharmacy`
  MODIFY `ph_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT для таблицы `profession`
--
ALTER TABLE `profession`
  MODIFY `pr_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT для таблицы `role`
--
ALTER TABLE `role`
  MODIFY `r_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT для таблицы `status`
--
ALTER TABLE `status`
  MODIFY `s_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT для таблицы `user`
--
ALTER TABLE `user`
  MODIFY `u_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT для таблицы `user_comment_medicine`
--
ALTER TABLE `user_comment_medicine`
  MODIFY `ucm_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT для таблицы `user_review_doctor`
--
ALTER TABLE `user_review_doctor`
  MODIFY `urd_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT для таблицы `user_review_medcenter`
--
ALTER TABLE `user_review_medcenter`
  MODIFY `urm_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- Ограничения внешнего ключа сохраненных таблиц
--

--
-- Ограничения внешнего ключа таблицы `appointment`
--
ALTER TABLE `appointment`
  ADD CONSTRAINT `a_doctorMedCenterId_fk` FOREIGN KEY (`a_doctorMedCenterId`) REFERENCES `doctor_medical_center` (`dmc_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `a_doctorWorkingHourId_fk` FOREIGN KEY (`a_doctorWorkingHourId`) REFERENCES `doctor_working_hour` (`dwh_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `a_statusId_fk` FOREIGN KEY (`a_statusId`) REFERENCES `status` (`s_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `a_userId_fk` FOREIGN KEY (`a_userId`) REFERENCES `user` (`u_id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Ограничения внешнего ключа таблицы `doctor`
--
ALTER TABLE `doctor`
  ADD CONSTRAINT `d_statusId_fk` FOREIGN KEY (`d_statusId`) REFERENCES `status` (`s_id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Ограничения внешнего ключа таблицы `doctor_education_history`
--
ALTER TABLE `doctor_education_history`
  ADD CONSTRAINT `deh_doctorId_fk` FOREIGN KEY (`deh_doctorId`) REFERENCES `doctor` (`d_id`);

--
-- Ограничения внешнего ключа таблицы `doctor_job_history`
--
ALTER TABLE `doctor_job_history`
  ADD CONSTRAINT `djh_doctorId_fk` FOREIGN KEY (`djh_doctorId`) REFERENCES `doctor` (`d_id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Ограничения внешнего ключа таблицы `doctor_medical_center`
--
ALTER TABLE `doctor_medical_center`
  ADD CONSTRAINT `dmc_appointmentTypeId_fk` FOREIGN KEY (`dmc_appointmentTypeId`) REFERENCES `appointment_type` (`at_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `dmc_doctorId_fk` FOREIGN KEY (`dmc_doctorId`) REFERENCES `doctor` (`d_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `dmc_medCenterId_fk` FOREIGN KEY (`dmc_medCenterId`) REFERENCES `medical_center` (`mc_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `dmc_professionId_fk` FOREIGN KEY (`dmc_professionId`) REFERENCES `profession` (`pr_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `dmc_statusId_fk` FOREIGN KEY (`dmc_statusId`) REFERENCES `status` (`s_id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Ограничения внешнего ключа таблицы `doctor_review_medicine`
--
ALTER TABLE `doctor_review_medicine`
  ADD CONSTRAINT `drm_doctorId_fk` FOREIGN KEY (`drm_doctorId`) REFERENCES `doctor` (`d_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `drm_medicineId_fk` FOREIGN KEY (`drm_medicineId`) REFERENCES `medicine` (`m_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `drm_statusId_fk` FOREIGN KEY (`drm_statusId`) REFERENCES `status` (`s_id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Ограничения внешнего ключа таблицы `doctor_working_hour`
--
ALTER TABLE `doctor_working_hour`
  ADD CONSTRAINT `dwh_doctorId_fk` FOREIGN KEY (`dwh_doctorId`) REFERENCES `doctor` (`d_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `dwh_medCenterId_fk` FOREIGN KEY (`dwh_medCenterId`) REFERENCES `doctor_medical_center` (`dmc_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `dwh_statusId_fk` FOREIGN KEY (`dwh_statusId`) REFERENCES `status` (`s_id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Ограничения внешнего ключа таблицы `medical_center`
--
ALTER TABLE `medical_center`
  ADD CONSTRAINT `mc_cityId_fk` FOREIGN KEY (`mc_cityId`) REFERENCES `city` (`c_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `mc_clinicGroupId_fk` FOREIGN KEY (`mc_clinicGroupId`) REFERENCES `clinic_group` (`cg_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `mc_statusId_fk` FOREIGN KEY (`mc_statusId`) REFERENCES `status` (`s_id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Ограничения внешнего ключа таблицы `medicine`
--
ALTER TABLE `medicine`
  ADD CONSTRAINT `m_groupForId_fk` FOREIGN KEY (`m_groupForId`) REFERENCES `medicine_group_for` (`mgf_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `m_groupFromId_fk` FOREIGN KEY (`m_groupFromId`) REFERENCES `medicine_group_from` (`mgfr_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `m_groupHowId_fk` FOREIGN KEY (`m_groupHowId`) REFERENCES `medicine_group_how` (`mgh_id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Ограничения внешнего ключа таблицы `medicine_pharmacy`
--
ALTER TABLE `medicine_pharmacy`
  ADD CONSTRAINT `mp_medicineId_fk` FOREIGN KEY (`mp_medicineId`) REFERENCES `medicine` (`m_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `mp_pharmacyId_fk` FOREIGN KEY (`mp_pharmacyId`) REFERENCES `pharmacy` (`ph_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `mp_statusId_fk` FOREIGN KEY (`mp_statusId`) REFERENCES `status` (`s_id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Ограничения внешнего ключа таблицы `pharmacy`
--
ALTER TABLE `pharmacy`
  ADD CONSTRAINT `ph_cityId_fk` FOREIGN KEY (`ph_cityId`) REFERENCES `city` (`c_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `ph_statusId_fk` FOREIGN KEY (`ph_statusId`) REFERENCES `status` (`s_id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Ограничения внешнего ключа таблицы `user`
--
ALTER TABLE `user`
  ADD CONSTRAINT `u_roleId_fk` FOREIGN KEY (`u_roleId`) REFERENCES `role` (`r_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `u_statusId_fk` FOREIGN KEY (`u_statusId`) REFERENCES `status` (`s_id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Ограничения внешнего ключа таблицы `user_comment_medicine`
--
ALTER TABLE `user_comment_medicine`
  ADD CONSTRAINT `ucm_medicineId_fk` FOREIGN KEY (`ucm_medicineId`) REFERENCES `medicine` (`m_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `ucm_statusId_fk` FOREIGN KEY (`ucm_statusId`) REFERENCES `status` (`s_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `ucm_userId_fk` FOREIGN KEY (`ucm_userId`) REFERENCES `user` (`u_id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Ограничения внешнего ключа таблицы `user_review_doctor`
--
ALTER TABLE `user_review_doctor`
  ADD CONSTRAINT `urd_doctorId_fk` FOREIGN KEY (`urd_doctorId`) REFERENCES `doctor` (`d_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `urd_medCenterId_fk` FOREIGN KEY (`urd_medCenterId`) REFERENCES `medical_center` (`mc_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `urd_statusId_fk` FOREIGN KEY (`urd_statusId`) REFERENCES `status` (`s_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `urd_userId_fk` FOREIGN KEY (`urd_userId`) REFERENCES `user` (`u_id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Ограничения внешнего ключа таблицы `user_review_medcenter`
--
ALTER TABLE `user_review_medcenter`
  ADD CONSTRAINT `urm_doctorId_fk` FOREIGN KEY (`urm_doctorId`) REFERENCES `doctor` (`d_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `urm_medCenterId_fk` FOREIGN KEY (`urm_medCenterId`) REFERENCES `medical_center` (`mc_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `urm_statusId_fk` FOREIGN KEY (`urm_statusId`) REFERENCES `status` (`s_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `urm_userId_fk` FOREIGN KEY (`urm_userId`) REFERENCES `user` (`u_id`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

