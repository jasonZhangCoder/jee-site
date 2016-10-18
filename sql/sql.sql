CREATE TABLE `tb_vehicle_record` (
  `id` varchar(50) NOT NULL,
  `vehicle_id` varchar(255) DEFAULT NULL,
  `record_type` varchar(255) DEFAULT NULL,
  `money` double DEFAULT NULL COMMENT '���',
  `descprition` varchar(255) DEFAULT NULL,
  `operate_user` varchar(255) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `create_user` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

 	CREATE TABLE `tb_vehicle_information` (
  `id` varchar(255) NOT NULL,
  `license_num` varchar(50) NOT NULL,
  `department` varchar(255) DEFAULT NULL,
  `driver` varchar(255) DEFAULT NULL,
  `mileage` double DEFAULT NULL COMMENT '��ʻ���',
  `create_time` datetime DEFAULT NULL,
  `create_user` varchar(255) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `update_user` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `tb_staff` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(0) NOT NULL,
  `phone` varchar(0) DEFAULT NULL,
  `is_soldier` tinyint(2) NOT NULL COMMENT '是否当过兵  0:是,1:否',
  `id_num` varchar(0) NOT NULL,
  `id_photo_above` varchar(255) DEFAULT NULL COMMENT '身份证照片正面',
  `id_photo_back` varchar(255) DEFAULT NULL COMMENT '身份证照片反面',
  `political_examination` varchar(255) DEFAULT NULL COMMENT '政审表照片',
  `photo` varchar(255) DEFAULT NULL COMMENT '照片',
  `resume` text COMMENT '简历',
  `birthday` date NOT NULL,
  `entry_date` date NOT NULL,
  `leave_date` date DEFAULT NULL,
  `department` varchar(0) NOT NULL,
  `role` varchar(0) NOT NULL,
  `remark` varchar(255) DEFAULT NULL COMMENT '备注（拒绝原因等）',
  `status` int(11) NOT NULL DEFAULT '0' COMMENT '0:在职 1：离职 2：待岗 3:拒绝',
  `create_time` datetime NOT NULL,
  `create_user_id` varchar(50) NOT NULL,
  `update_time` datetime NOT NULL,
  `update_user_id` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

