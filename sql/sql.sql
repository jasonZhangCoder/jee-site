CREATE TABLE `tb_vehicle_record` (
  `id` varchar(50) NOT NULL,
  `vehicle_id` varchar(255) DEFAULT NULL,
  `record_type` varchar(255) DEFAULT NULL,
  `money` double DEFAULT NULL COMMENT '金额',
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
  `mileage` double DEFAULT NULL COMMENT '行驶里程',
  `create_time` datetime DEFAULT NULL,
  `create_user` varchar(255) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `update_user` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

