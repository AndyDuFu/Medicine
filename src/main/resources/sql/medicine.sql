/*
Navicat MySQL Data Transfer

Source Server         : sf
Source Server Version : 50621
Source Host           : 116.62.201.135:3306
Source Database       : medicine

Target Server Type    : MYSQL
Target Server Version : 50621
File Encoding         : 65001

Date: 2018-11-07 20:32:04
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for `attachment`
-- ----------------------------
DROP TABLE IF EXISTS `attachment`;
CREATE TABLE `attachment` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `create_date` datetime DEFAULT NULL,
  `file_name` varchar(255) DEFAULT NULL,
  `file_path` varchar(255) DEFAULT NULL,
  `file_size` bigint(20) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  `datum_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKmcdyofj155ru2vr52gq9m9mnf` (`datum_id`)
) ENGINE=MyISAM AUTO_INCREMENT=63 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of attachment
-- ----------------------------
INSERT INTO attachment VALUES ('61', '2018-11-07 00:00:00', '12.jpg', '/file/2018-11-07/15415941613931541594161393_.jpg', '10973', null, '27');
INSERT INTO attachment VALUES ('62', '2018-11-07 00:00:00', 'QQ截图20171203123653.png', '/file/2018-11-07/15415941775841541594177584_.png', '37595', null, '27');

-- ----------------------------
-- Table structure for `attiend`
-- ----------------------------
DROP TABLE IF EXISTS `attiend`;
CREATE TABLE `attiend` (
  `id` bigint(20) NOT NULL,
  `birthplace` varchar(255) DEFAULT NULL,
  `card_id` bigint(20) DEFAULT NULL,
  `citizenship` varchar(255) DEFAULT NULL,
  `city` varchar(255) DEFAULT NULL,
  `country` varchar(255) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `ethnic` varchar(255) DEFAULT NULL,
  `height` double DEFAULT NULL,
  `marriage` int(11) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `profession` varchar(255) DEFAULT NULL,
  `province` varchar(255) DEFAULT NULL,
  `sex` varchar(255) DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  `visit_time` datetime DEFAULT NULL,
  `weight` double DEFAULT NULL,
  `zip_code` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of attiend
-- ----------------------------

-- ----------------------------
-- Table structure for `component_manager`
-- ----------------------------
DROP TABLE IF EXISTS `component_manager`;
CREATE TABLE `component_manager` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cas` varchar(255) DEFAULT NULL,
  `come` varchar(255) DEFAULT NULL,
  `fzs` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of component_manager
-- ----------------------------
INSERT INTO component_manager VALUES ('1', 'null', 'JH 3598', 'C28H48O', '17αH-三去甲何帕-21-酮 / 17αH-trisnorhopan-21-one');
INSERT INTO component_manager VALUES ('2', '112-27-6', '', 'C6H14O4', '三甘醇 / triethylene glycol');
INSERT INTO component_manager VALUES ('3', 'null', 'JH 4446', 'C15H24', 'α-人参烯 / α-panasinsene');

-- ----------------------------
-- Table structure for `customer_session`
-- ----------------------------
DROP TABLE IF EXISTS `customer_session`;
CREATE TABLE `customer_session` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `auth_token` varchar(50) DEFAULT NULL,
  `is_expired` bit(1) NOT NULL,
  `start_time` datetime NOT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKoj54wvwdracenxh88uyge2f18` (`user_id`)
) ENGINE=MyISAM AUTO_INCREMENT=209 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of customer_session
-- ----------------------------
INSERT INTO customer_session VALUES ('1', 'e3bb6c85-1a09-4bac-9e29-bfe2d55722a9-c', '', '2018-08-06 16:29:59', '3');
INSERT INTO customer_session VALUES ('2', '03034197-20d1-4e54-a20b-9a183a21497b-c', '', '2018-08-08 10:58:17', '3');
INSERT INTO customer_session VALUES ('3', '65666dc3-b194-4037-9795-c2051d256ffd-c', '', '2018-08-08 10:58:59', '3');
INSERT INTO customer_session VALUES ('4', '3cdcccba-55b0-4276-8cdb-410c010c84e5-c', '', '2018-08-08 11:08:26', '3');
INSERT INTO customer_session VALUES ('5', '5b381215-1356-4806-aae9-6d13969e1e43-c', '', '2018-08-08 11:08:54', '3');
INSERT INTO customer_session VALUES ('6', '78241c3f-8fff-4be5-a527-17b5dd49a458-c', '', '2018-08-08 11:12:40', '3');
INSERT INTO customer_session VALUES ('7', 'd9523dda-6c89-4d10-abe7-ebcf17417ccf-c', '', '2018-08-08 11:14:56', '3');
INSERT INTO customer_session VALUES ('8', 'ba874b3c-926e-4b05-8e9a-87d9975b00e2-c', '', '2018-08-08 11:17:24', '3');
INSERT INTO customer_session VALUES ('9', 'e63db626-8207-4d2e-b7ce-e234cff1c9ff-c', '', '2018-08-08 11:18:37', '3');
INSERT INTO customer_session VALUES ('10', '63510cf7-3bf8-4893-924e-9ad704bffbcc-c', '', '2018-08-08 11:25:56', '3');
INSERT INTO customer_session VALUES ('11', '779c80fa-948d-4b2d-84b9-25abfe70f15e-c', '', '2018-08-08 11:26:32', '3');
INSERT INTO customer_session VALUES ('12', 'a2a16ead-f1b3-460c-9415-e97a9b96d9da-c', '', '2018-08-08 11:35:51', '3');
INSERT INTO customer_session VALUES ('13', 'c72ba370-eaf1-4e5c-a24b-225667ee92f2-c', '', '2018-08-08 15:35:16', '3');
INSERT INTO customer_session VALUES ('14', '6d3d922a-4687-417a-8b36-f07d0c293ee9-c', '', '2018-08-08 15:36:25', '3');
INSERT INTO customer_session VALUES ('15', '74fc0725-9403-4574-9585-d0b551e937a0-c', '', '2018-08-08 15:54:46', '3');
INSERT INTO customer_session VALUES ('16', '086002d1-abb1-49f3-8e72-78519906f526-c', '', '2018-08-08 15:55:15', '3');
INSERT INTO customer_session VALUES ('17', '434b9448-0ee0-43f5-9b20-0080bdef81a4-c', '', '2018-08-08 15:57:50', '3');
INSERT INTO customer_session VALUES ('18', 'fb644dac-5783-4031-8905-d8dcd7f900b4-c', '', '2018-08-08 15:59:08', '3');
INSERT INTO customer_session VALUES ('19', '717fae4a-ba9a-4091-893b-306902b78e6d-c', '', '2018-08-08 16:01:22', '3');
INSERT INTO customer_session VALUES ('20', 'b949f41a-9ca6-40e8-bc67-93168a663ddb-c', '', '2018-08-08 16:04:26', '3');
INSERT INTO customer_session VALUES ('21', '1835f5fb-d8ad-4aee-9f18-7b882aa53b63-c', '', '2018-08-08 16:33:34', '3');
INSERT INTO customer_session VALUES ('22', 'a64a886c-8fca-4ab9-a57f-152dcc8959fb-c', '', '2018-08-08 16:39:17', '7');
INSERT INTO customer_session VALUES ('23', '9b0d8e3c-1952-451f-be89-d4e0706313e2-c', '', '2018-08-08 16:40:21', '5');
INSERT INTO customer_session VALUES ('24', 'e802b8f8-d963-4ace-82f4-7b8b71f52db5-c', '', '2018-08-08 16:40:32', '3');
INSERT INTO customer_session VALUES ('25', '777b72ea-3933-4c01-8c5a-e850c3b4ad0c-c', '', '2018-08-09 10:13:47', '3');
INSERT INTO customer_session VALUES ('26', '859e40d2-d592-4875-89af-70be055ba615-c', '', '2018-08-09 11:11:29', '3');
INSERT INTO customer_session VALUES ('27', '906fc625-0726-475c-b409-5816941e7a67-c', '', '2018-08-09 11:38:45', '3');
INSERT INTO customer_session VALUES ('28', 'ca05508e-bb28-431b-a578-b67c930a3018-c', '', '2018-08-09 11:47:31', '3');
INSERT INTO customer_session VALUES ('29', 'd1432262-1039-499c-b015-6dfdb5f25767-c', '', '2018-08-09 15:30:10', '3');
INSERT INTO customer_session VALUES ('30', '42a57e23-bfc0-45c7-91c2-c6dfb9dff4a5-c', '', '2018-08-09 15:41:44', '3');
INSERT INTO customer_session VALUES ('31', '90b5c9da-c3d9-49c2-bc39-2661712b0970-c', '', '2018-08-09 15:57:59', '3');
INSERT INTO customer_session VALUES ('32', 'c6b856a6-bb67-45b8-8837-26941a92a2f7-c', '', '2018-08-13 11:36:44', '3');
INSERT INTO customer_session VALUES ('33', '3d16f4ca-a3d8-4632-b037-25cff56dd1b9-c', '', '2018-08-13 14:19:32', '3');
INSERT INTO customer_session VALUES ('34', '4dfd5741-3ddb-42c6-b971-ea8d7ebcd2fe-c', '', '2018-08-13 14:21:28', '3');
INSERT INTO customer_session VALUES ('35', 'fcd53393-8514-4939-b225-85ea1072092b-c', '', '2018-08-14 10:11:59', '3');
INSERT INTO customer_session VALUES ('36', '399bf0cf-9128-4f8d-b05d-db95f896ae1b-c', '', '2018-08-14 10:12:26', '3');
INSERT INTO customer_session VALUES ('37', '085cc75e-d351-436c-9ed1-69d67da7b485-c', '', '2018-08-14 10:39:48', '3');
INSERT INTO customer_session VALUES ('38', '2b2a0672-9253-4094-9a93-3eab1e857d91-c', '', '2018-08-14 10:40:34', '9');
INSERT INTO customer_session VALUES ('39', 'd27791a7-f670-408d-8f39-0516a68ea7b6-c', '', '2018-08-14 10:42:06', '3');
INSERT INTO customer_session VALUES ('40', '72dd2008-a810-4cbd-ac76-a7222328f997-c', '', '2018-08-14 14:21:26', '3');
INSERT INTO customer_session VALUES ('41', 'c0fae8d6-0095-4a07-a0bd-e46eec74c988-c', '', '2018-08-14 14:27:17', '3');
INSERT INTO customer_session VALUES ('42', 'c79ee5b6-b2a6-4616-920b-fc911b22aa75-c', '', '2018-08-14 15:03:00', '3');
INSERT INTO customer_session VALUES ('43', '5228657d-7a8e-4203-bf58-1a7d88fc4ba6-c', '', '2018-08-14 15:44:36', '3');
INSERT INTO customer_session VALUES ('44', '27075b2e-d884-460b-9158-5d045a311965-c', '', '2018-08-14 16:09:07', '3');
INSERT INTO customer_session VALUES ('45', 'd5ce3797-4966-4bd8-8b77-8c7a843cc10a-c', '', '2018-08-14 16:15:16', '3');
INSERT INTO customer_session VALUES ('46', '6d88946f-ae11-4242-938b-3d9a91e27545-c', '', '2018-08-14 16:18:49', '3');
INSERT INTO customer_session VALUES ('47', 'cbfcca0a-4f14-4462-b365-a5ef4a027dd3-c', '', '2018-08-14 16:20:34', '3');
INSERT INTO customer_session VALUES ('48', '7fbd4cf4-17ca-4456-ba21-d012219942b5-c', '', '2018-08-14 16:25:52', '3');
INSERT INTO customer_session VALUES ('49', '0d7976b4-7a60-42af-a04a-93b90669519e-c', '', '2018-08-14 16:30:32', '3');
INSERT INTO customer_session VALUES ('50', '36edaf27-331e-4f8e-837e-393909264036-c', '', '2018-08-14 16:58:27', '3');
INSERT INTO customer_session VALUES ('51', 'eb38a0c3-0745-40b1-b376-0f695a66f221-c', '', '2018-08-14 17:12:50', '3');
INSERT INTO customer_session VALUES ('52', '2ab69aec-2521-4c39-b8ac-6e0432e865fa-c', '', '2018-08-14 17:13:13', '9');
INSERT INTO customer_session VALUES ('53', 'fc39b40b-3183-41b9-88f2-618d4fb5b951-c', '', '2018-08-16 11:15:46', '3');
INSERT INTO customer_session VALUES ('54', 'eef96a85-854f-4eb0-aa4d-ea93627c92fb-c', '', '2018-08-16 15:04:34', '3');
INSERT INTO customer_session VALUES ('55', '6768dc52-3240-469d-810c-17d6318b7d54-c', '', '2018-08-20 14:38:22', '3');
INSERT INTO customer_session VALUES ('56', 'd6a8d2b0-4612-4924-8bdb-9e168e034276-c', '', '2018-08-22 16:51:51', '3');
INSERT INTO customer_session VALUES ('57', '058ccee4-84c9-441f-9d02-681e9cbf6519-c', '', '2018-08-23 09:48:52', '3');
INSERT INTO customer_session VALUES ('58', 'd86375c3-d0fa-487e-b14d-eb0c8927f022-c', '', '2018-08-28 10:03:34', '3');
INSERT INTO customer_session VALUES ('59', '42d8d30d-007d-40f1-aa27-9000d170b3fd-c', '', '2018-08-28 21:53:04', '9');
INSERT INTO customer_session VALUES ('60', '737beaab-6b5f-400f-99ac-e555528435d4-c', '', '2018-08-29 00:25:02', '9');
INSERT INTO customer_session VALUES ('61', 'c9fe9b1d-5782-4fd3-99ad-f10509f03549-c', '', '2018-08-29 15:44:11', '3');
INSERT INTO customer_session VALUES ('62', '6f91d81f-8d57-4f60-90ec-911283e032bb-c', '', '2018-08-29 15:45:18', '3');
INSERT INTO customer_session VALUES ('63', '358c3a63-253d-45ba-a63e-2b324875a35a-c', '', '2018-08-30 20:40:07', '9');
INSERT INTO customer_session VALUES ('64', 'a26631f1-44dd-4163-86db-ef0db54a46c4-c', '', '2018-08-30 20:59:52', '9');
INSERT INTO customer_session VALUES ('65', 'd15009df-3395-41a6-b64c-4a2f3699051c-c', '', '2018-09-03 11:26:09', '3');
INSERT INTO customer_session VALUES ('66', '95200cc5-8835-4f58-99a4-5b51872701c9-c', '', '2018-09-04 10:12:38', '3');
INSERT INTO customer_session VALUES ('67', '8bfe24fe-dac7-4b16-a8f0-f0e7efa1d3da-c', '', '2018-09-05 10:33:26', '3');
INSERT INTO customer_session VALUES ('68', '4591ca0e-e174-4ce9-bb0e-a6dc0bf91319-c', '', '2018-09-05 11:55:00', '3');
INSERT INTO customer_session VALUES ('69', '01d27158-9212-4c08-8e2c-4a5d6d700c64-c', '', '2018-09-06 09:50:27', '3');
INSERT INTO customer_session VALUES ('70', 'ff09d72f-447a-43f9-b94e-de8bdcbf9559-c', '', '2018-09-07 01:53:46', '9');
INSERT INTO customer_session VALUES ('71', '0cb3f4e3-4d91-48c8-8746-b49a8feb0527-c', '', '2018-09-07 01:57:20', '9');
INSERT INTO customer_session VALUES ('72', '98bc2c37-9a9e-4f44-ba47-c2e408c682a4-c', '', '2018-09-10 10:09:20', '3');
INSERT INTO customer_session VALUES ('73', '0a2fc2be-08ff-414c-b75a-27694291e93c-c', '', '2018-09-10 10:24:26', '3');
INSERT INTO customer_session VALUES ('74', 'b423521e-657a-479e-bb08-42d2c3325d06-c', '', '2018-09-10 10:42:06', '3');
INSERT INTO customer_session VALUES ('75', '25abe78b-ede9-4635-9d50-0a901fdbee05-c', '', '2018-09-10 14:26:06', '3');
INSERT INTO customer_session VALUES ('76', 'f931456b-70b8-4539-973f-c30d84595c03-c', '', '2018-09-10 14:44:01', '3');
INSERT INTO customer_session VALUES ('77', 'a8376b7d-f8ac-4145-912d-99679693a54c-c', '', '2018-09-10 17:10:15', '3');
INSERT INTO customer_session VALUES ('78', 'e22e8844-ae1c-42da-8fff-de6a53d65eca-c', '', '2018-09-11 09:56:42', '3');
INSERT INTO customer_session VALUES ('79', 'aa2d41a3-362c-4242-a2e1-96e07b2a35e7-c', '', '2018-09-11 10:01:12', '3');
INSERT INTO customer_session VALUES ('80', 'd3322d8d-a80b-4f63-96fc-d356c292df0e-c', '', '2018-09-11 10:09:20', '3');
INSERT INTO customer_session VALUES ('81', '9847c9ff-2f68-45e2-9ae4-544b00b42ac0-c', '', '2018-09-11 14:05:12', '3');
INSERT INTO customer_session VALUES ('82', '89f5dd32-08d2-4601-9507-8b5d496f9ae1-c', '', '2018-09-12 10:41:40', '3');
INSERT INTO customer_session VALUES ('83', '60fab0b7-63f5-42c6-bb76-c9df845e1177-c', '', '2018-09-17 10:42:49', '3');
INSERT INTO customer_session VALUES ('84', '338eb483-2615-477b-9659-68b97e1b97bd-c', '', '2018-09-17 10:47:06', '3');
INSERT INTO customer_session VALUES ('85', '7785ee59-0ba5-4a30-9188-12d5b3d8525f-c', '', '2018-09-17 11:19:34', '3');
INSERT INTO customer_session VALUES ('86', '051cebaa-059b-46e9-ad2e-16438c16556b-c', '', '2018-09-17 14:35:58', '3');
INSERT INTO customer_session VALUES ('87', 'e556ee87-b8f0-439d-84bf-72da629e7f5e-c', '', '2018-09-25 14:41:44', '3');
INSERT INTO customer_session VALUES ('88', 'da0a33c0-c3f6-4723-bbf6-d3f9edf239a9-c', '', '2018-09-25 15:08:06', '3');
INSERT INTO customer_session VALUES ('89', '1f187468-cfa1-4575-9fad-6d7628c3bdd0-c', '', '2018-09-25 16:54:41', '3');
INSERT INTO customer_session VALUES ('90', '904606f2-cc72-4801-9b55-88a4cf451c1d-c', '', '2018-09-25 17:05:15', '3');
INSERT INTO customer_session VALUES ('91', 'bf33ebd9-f72d-482e-9de8-0878db2d8866-c', '', '2018-09-27 10:29:40', '3');
INSERT INTO customer_session VALUES ('92', '63651ec9-163a-4bef-9338-9b2a8a2c7559-c', '', '2018-09-27 16:01:38', '3');
INSERT INTO customer_session VALUES ('93', '24a04a4b-977e-493e-bf12-64255402dd99-c', '', '2018-09-27 16:58:25', '3');
INSERT INTO customer_session VALUES ('94', 'abba4366-d8c1-48cc-8421-edd2bbf028ac-c', '', '2018-09-27 16:58:39', '3');
INSERT INTO customer_session VALUES ('95', 'd71f20a6-435e-4e3e-b350-146785d22933-c', '', '2018-09-27 16:58:51', '3');
INSERT INTO customer_session VALUES ('96', '4bd678de-4d22-4a7e-88d7-b6b9d5d4dd33-c', '', '2018-09-27 17:00:05', '3');
INSERT INTO customer_session VALUES ('97', '7f6aa85d-655b-496d-9b54-be53ec5fba81-c', '', '2018-09-27 17:34:31', '3');
INSERT INTO customer_session VALUES ('98', 'eeaebf05-e243-4675-8a8d-4f3e43c6970b-c', '', '2018-09-28 11:51:28', '3');
INSERT INTO customer_session VALUES ('99', 'ed8fb36e-ea95-4a41-80e0-65a77d934e09-c', '', '2018-09-28 12:14:51', '3');
INSERT INTO customer_session VALUES ('100', '00d71613-4754-4577-8468-63723f4b9ba7-c', '', '2018-09-28 12:16:52', '3');
INSERT INTO customer_session VALUES ('101', '4b233809-9bd8-4990-bba7-59f7726f5bae-c', '', '2018-09-28 12:25:45', '3');
INSERT INTO customer_session VALUES ('102', '5672e95e-dd1f-4da8-84b0-37e72a7d36a4-c', '', '2018-09-28 12:26:24', '3');
INSERT INTO customer_session VALUES ('103', '10d0e32a-e1dd-4106-b597-171fe20e79c6-c', '', '2018-09-28 12:28:27', '3');
INSERT INTO customer_session VALUES ('104', 'c08735fb-f971-47e0-8258-cf8244189d1b-c', '', '2018-09-28 12:28:47', '3');
INSERT INTO customer_session VALUES ('105', 'bea3f34b-3949-4f0d-abe4-c40f2030f7b5-c', '', '2018-09-28 12:32:15', '3');
INSERT INTO customer_session VALUES ('106', 'fbad6355-e995-471b-b5ce-7ef877dd5dfc-c', '', '2018-09-28 12:36:45', '3');
INSERT INTO customer_session VALUES ('107', '843d732b-e180-4aa8-8f26-2c973e1ef56a-c', '', '2018-09-28 12:39:15', '3');
INSERT INTO customer_session VALUES ('108', 'ec835902-6c3f-45ae-95ea-b32280cc4723-c', '', '2018-09-28 14:06:14', '3');
INSERT INTO customer_session VALUES ('109', 'ee220add-369c-4e3b-aa6f-f3025c3b9113-c', '', '2018-10-22 10:16:30', '3');
INSERT INTO customer_session VALUES ('110', '70907244-6029-4ba8-8f0e-696035c3de75-c', '', '2018-10-22 10:19:48', '3');
INSERT INTO customer_session VALUES ('111', '5c4c5783-3202-4b93-a056-f231a0df52dc-c', '', '2018-10-22 10:30:03', '3');
INSERT INTO customer_session VALUES ('112', '385ea899-6468-48f5-969c-8c93a297bb9d-c', '', '2018-10-22 10:34:08', '3');
INSERT INTO customer_session VALUES ('113', '90bc197e-01e9-4167-a077-e572cad26899-c', '', '2018-10-22 10:36:32', '3');
INSERT INTO customer_session VALUES ('114', '827659c3-8c9e-492a-9c84-dc4256d7a16e-c', '', '2018-10-22 10:49:27', '3');
INSERT INTO customer_session VALUES ('115', 'eacf5524-f2e2-42b7-bc0d-9567d2339fac-c', '', '2018-10-22 11:02:14', '3');
INSERT INTO customer_session VALUES ('116', 'cc79c19e-d7a0-448b-bedb-9b980d327ba3-c', '', '2018-10-22 14:41:43', '3');
INSERT INTO customer_session VALUES ('117', '978d59ac-9d6a-4c88-b091-f3948cac4abf-c', '', '2018-10-22 15:00:35', '3');
INSERT INTO customer_session VALUES ('118', '05a6c7ae-5e41-4c23-a80b-61e09ab8f5fe-c', '', '2018-10-22 15:28:50', '3');
INSERT INTO customer_session VALUES ('119', 'a9c2ad66-16b5-4380-b2cb-f0a77eb55b00-c', '', '2018-10-22 17:21:28', '3');
INSERT INTO customer_session VALUES ('120', '5daaee68-5dbc-4ad0-8025-afc0751f977e-c', '', '2018-10-23 10:25:18', '3');
INSERT INTO customer_session VALUES ('121', 'cdba6f84-10a0-4c51-9711-e69385851ebd-c', '', '2018-10-23 11:15:53', '3');
INSERT INTO customer_session VALUES ('122', '60468c46-39c5-46b3-9d18-a6c516bc998e-c', '', '2018-10-24 14:53:50', '3');
INSERT INTO customer_session VALUES ('123', 'cbe1ba81-7efd-4799-b94b-f7e5ff48291c-c', '', '2018-10-24 15:01:13', '3');
INSERT INTO customer_session VALUES ('124', '7d76d7bf-46a0-4f10-a9e4-7f591e1a3670-c', '', '2018-10-24 15:07:45', '3');
INSERT INTO customer_session VALUES ('125', '4fe95a07-c2f1-44cc-9ecb-dca2eb4bbe62-c', '', '2018-10-24 15:11:34', '3');
INSERT INTO customer_session VALUES ('126', '6f4ba3b3-971b-4c11-81dd-294ae400cc95-c', '', '2018-10-30 10:09:26', '3');
INSERT INTO customer_session VALUES ('127', '081b5626-ca90-48e2-9740-6dd8b49013b4-c', '', '2018-10-30 10:30:58', '3');
INSERT INTO customer_session VALUES ('128', '2e270c4e-ae16-4301-8c60-848e30204d19-c', '', '2018-10-30 10:40:39', '3');
INSERT INTO customer_session VALUES ('129', '3e24f57b-5206-4e2c-ac16-70879cd32424-c', '', '2018-10-30 10:53:25', '3');
INSERT INTO customer_session VALUES ('130', '0974becb-8e8d-4d2e-99b7-d3dfd0b13bf1-c', '', '2018-10-30 10:57:25', '3');
INSERT INTO customer_session VALUES ('131', '55bb295f-ff2f-4731-8261-57a28ee19422-c', '', '2018-10-31 10:23:27', '3');
INSERT INTO customer_session VALUES ('132', 'dba6e6f8-3bb2-4db4-90da-3030a31fb816-c', '', '2018-10-31 10:27:51', '3');
INSERT INTO customer_session VALUES ('133', '8c851f86-a751-4e1b-8552-3a8588f9bc40-c', '', '2018-11-06 10:44:44', '3');
INSERT INTO customer_session VALUES ('134', 'bb57aba9-6747-4ea1-b116-bcf96b32b072-c', '', '2018-11-06 10:44:58', '3');
INSERT INTO customer_session VALUES ('135', 'dddf4e4d-ad51-4542-9e1d-d09cf9a7114f-c', '', '2018-11-06 10:48:45', '3');
INSERT INTO customer_session VALUES ('136', 'c59ce7f1-22e9-4b1b-9940-62adbc798acd-c', '', '2018-11-06 11:10:21', '3');
INSERT INTO customer_session VALUES ('137', 'b9350cf5-43d0-4c9b-a812-7e5be7e8f7a8-c', '', '2018-11-06 11:24:19', '3');
INSERT INTO customer_session VALUES ('138', '2d604b8d-4811-4f0a-a2f9-2b27cd4421b1-c', '', '2018-11-06 11:28:05', '3');
INSERT INTO customer_session VALUES ('139', '971cf701-caab-4ec6-b4da-9ce92f9dea64-c', '', '2018-11-06 11:32:02', '3');
INSERT INTO customer_session VALUES ('140', '9808302f-86ca-42a0-b27f-fc215942cc43-c', '', '2018-11-06 11:28:36', '3');
INSERT INTO customer_session VALUES ('141', '8f18bbd0-af25-427d-934a-2cb229cc8b7c-c', '', '2018-11-06 11:31:46', '3');
INSERT INTO customer_session VALUES ('142', 'f5a9a494-c478-4e6c-8551-f44364516fce-c', '', '2018-11-06 11:32:53', '3');
INSERT INTO customer_session VALUES ('143', '2638906a-fc90-44c8-bbce-cd6a8e383609-c', '', '2018-11-06 11:33:45', '3');
INSERT INTO customer_session VALUES ('144', '7c3bb205-ef62-4cb0-aacb-1be9008bc9c2-c', '', '2018-11-06 11:38:22', '3');
INSERT INTO customer_session VALUES ('145', 'b8da5cd0-6492-445a-a5e0-577202f70993-c', '', '2018-11-06 11:39:51', '3');
INSERT INTO customer_session VALUES ('146', '633a23d5-b76a-431e-9092-ea036749987e-c', '', '2018-11-06 11:58:47', '3');
INSERT INTO customer_session VALUES ('147', 'ca456983-960e-4ef8-b31b-975e69bb6e8b-c', '', '2018-11-07 09:56:32', '3');
INSERT INTO customer_session VALUES ('148', 'b6e4a33b-dc0e-4de7-8fbe-e7cde9b99206-c', '', '2018-11-07 09:56:58', '3');
INSERT INTO customer_session VALUES ('149', '825d63ae-642c-4108-9171-5eb4504f1dcb-c', '', '2018-11-07 14:06:51', '3');
INSERT INTO customer_session VALUES ('150', '45415e17-4e70-4967-ab6a-dd75ad492c99-c', '', '2018-11-07 14:25:00', '3');
INSERT INTO customer_session VALUES ('151', '617c6574-98ef-4d4c-8ddc-cd5739d63371-c', '', '2018-11-07 14:51:36', '9');
INSERT INTO customer_session VALUES ('152', 'fd9f1177-f3e2-43ce-a452-ca1b30046453-c', '', '2018-11-07 14:51:44', '5');
INSERT INTO customer_session VALUES ('153', '5a27272b-596f-44f6-8133-7348a8faa2eb-c', '', '2018-11-07 14:52:02', '7');
INSERT INTO customer_session VALUES ('154', '2e024634-4aca-46b1-a03d-74fe755ed256-c', '', '2018-11-07 14:54:39', '10');
INSERT INTO customer_session VALUES ('155', 'afb91456-be79-4c4c-ae55-9de88eb85cf0-c', '', '2018-11-07 14:54:46', '3');
INSERT INTO customer_session VALUES ('156', '14e5fd1c-69fb-4172-a21d-dbf0293b2bfe-c', '', '2018-11-07 14:55:08', '10');
INSERT INTO customer_session VALUES ('157', '50db8590-f796-4c90-b2f7-c91d980a1d54-c', '', '2018-11-07 14:55:14', '6');
INSERT INTO customer_session VALUES ('158', 'f80f69cf-556d-4eac-88cc-751c19b44304-c', '', '2018-11-07 14:55:38', '3');
INSERT INTO customer_session VALUES ('159', '1a3b8ea6-a28d-4c78-9cd9-21b56fabdf20-c', '', '2018-11-07 14:56:29', '3');
INSERT INTO customer_session VALUES ('160', '907baefd-d9a4-4300-828d-73f9c821bc95-c', '', '2018-11-07 14:59:10', '3');
INSERT INTO customer_session VALUES ('161', '1526b469-89a4-438b-ae5e-a58b04923579-c', '', '2018-11-07 14:59:34', '3');
INSERT INTO customer_session VALUES ('162', 'ad36451f-7eac-48fd-b627-f6662bb99de7-c', '', '2018-11-07 15:13:20', '3');
INSERT INTO customer_session VALUES ('163', '43d166d0-8926-40e6-b42a-f4e989339980-c', '', '2018-11-07 16:05:23', '3');
INSERT INTO customer_session VALUES ('164', '3bf07f81-424c-40d1-9b0c-c388dcb58229-c', '', '2018-11-07 16:10:37', '3');
INSERT INTO customer_session VALUES ('165', '240fbe4d-fb8f-4e47-8d20-d44b6f73665f-c', '', '2018-11-07 16:10:55', '3');
INSERT INTO customer_session VALUES ('166', '013277ea-acf3-4854-99e7-6193afbf3d88-c', '', '2018-11-07 16:14:13', '3');
INSERT INTO customer_session VALUES ('167', '8f8ded24-1c69-458a-9cf6-6c0eb23f6413-c', '', '2018-11-07 16:14:32', '3');
INSERT INTO customer_session VALUES ('168', '07a2ebc5-3f8b-4eab-8d3a-7a1c99184586-c', '', '2018-11-07 16:18:07', '3');
INSERT INTO customer_session VALUES ('169', '704159dd-c790-420d-a618-306a6ad205cf-c', '', '2018-11-07 16:18:45', '3');
INSERT INTO customer_session VALUES ('170', 'd5896273-3c98-4219-ad19-7796141dee83-c', '', '2018-11-07 16:33:07', '3');
INSERT INTO customer_session VALUES ('171', '0bc29fa0-4873-4c6d-93bb-54820075960c-c', '', '2018-11-07 16:33:47', '3');
INSERT INTO customer_session VALUES ('172', 'd57b0c5b-f949-4955-918d-92f952a466ce-c', '', '2018-11-07 16:51:11', '3');
INSERT INTO customer_session VALUES ('173', 'c8724519-75a5-4998-9c03-aa2e20015738-c', '', '2018-11-07 16:51:52', '3');
INSERT INTO customer_session VALUES ('174', '6f3a3faa-ab62-4cd2-9135-59f2591a68d4-c', '', '2018-11-07 17:25:01', '3');
INSERT INTO customer_session VALUES ('175', '9f12ebc0-a39c-47a3-9d14-077fb493246a-c', '', '2018-11-07 17:26:17', '3');
INSERT INTO customer_session VALUES ('176', '7e7e7332-8b93-4bcd-8b9e-10f29219a76a-c', '', '2018-11-07 17:31:46', '3');
INSERT INTO customer_session VALUES ('177', '9bc23c0a-fdb5-4a98-86d4-ae8606daca11-c', '', '2018-11-07 17:32:51', '3');
INSERT INTO customer_session VALUES ('178', '86b2c7a1-f580-462f-a6a6-3cb8c9525b8e-c', '', '2018-11-07 17:37:07', '3');
INSERT INTO customer_session VALUES ('179', 'c5f17e32-fe7e-4447-997e-f4a6f07d32f2-c', '', '2018-11-07 17:43:45', '3');
INSERT INTO customer_session VALUES ('180', '9792444e-a886-4100-83bf-0343ac7d8522-c', '', '2018-11-07 17:46:29', '3');
INSERT INTO customer_session VALUES ('181', '2649700f-fcbd-4f73-aef6-a47297c968eb-c', '', '2018-11-07 18:05:45', '3');
INSERT INTO customer_session VALUES ('182', '2729e15a-2aea-4f29-bff9-1508566f003b-c', '', '2018-11-07 18:05:46', '3');
INSERT INTO customer_session VALUES ('183', '2d826026-f2c7-43a3-8ca4-0553122e8fcd-c', '', '2018-11-07 18:07:26', '3');
INSERT INTO customer_session VALUES ('184', 'dbd01d73-40a8-4d07-91b2-89fc5739da98-c', '', '2018-11-07 18:07:30', '3');
INSERT INTO customer_session VALUES ('185', 'b5f3a06b-c39a-4d10-b6c9-f5aa4f874dbc-c', '', '2018-11-07 18:44:00', '3');
INSERT INTO customer_session VALUES ('186', '4f9e66f2-60d4-487e-a42f-b8768ed7d8d4-c', '', '2018-11-07 18:54:17', '3');
INSERT INTO customer_session VALUES ('187', '7e7248e2-349c-419a-9054-776d2c3c697a-c', '', '2018-11-07 19:00:45', '3');
INSERT INTO customer_session VALUES ('188', 'd90bf93d-d746-484d-aa46-4dbb46ed45be-c', '', '2018-11-07 19:05:50', '3');
INSERT INTO customer_session VALUES ('189', 'c378f50f-3fe9-4590-8530-bf5514119cc9-c', '', '2018-11-07 19:08:17', '3');
INSERT INTO customer_session VALUES ('190', '33d7a0f2-9dcd-409b-9dbb-7712273063f5-c', '', '2018-11-07 19:08:53', '3');
INSERT INTO customer_session VALUES ('191', '69116fe9-02a2-4592-99e5-2a49044391b7-c', '', '2018-11-07 19:12:57', '3');
INSERT INTO customer_session VALUES ('192', '06ead958-4e47-4a00-9183-343e34d0f1dc-c', '', '2018-11-07 19:22:06', '3');
INSERT INTO customer_session VALUES ('193', '4c301ff3-884a-4200-b5a3-9cf8071ddad5-c', '', '2018-11-07 19:23:14', '3');
INSERT INTO customer_session VALUES ('194', '90cbe8fa-365d-4385-b267-26610b60d842-c', '', '2018-11-07 19:27:46', '3');
INSERT INTO customer_session VALUES ('195', '12a1ca5e-ac4e-45ef-8484-2297336333ef-c', '', '2018-11-07 19:31:18', '3');
INSERT INTO customer_session VALUES ('196', 'cc88c99b-62e5-4a29-b13c-e0106dfe9209-c', '', '2018-11-07 19:36:00', '3');
INSERT INTO customer_session VALUES ('197', 'dbe63e78-40b8-4577-adff-f34553bd73f6-c', '', '2018-11-07 19:36:44', '3');
INSERT INTO customer_session VALUES ('198', 'f465c84e-1bfb-4012-9487-b3e4c66fd3f1-c', '', '2018-11-07 19:38:19', '3');
INSERT INTO customer_session VALUES ('199', 'e793a350-e6ee-47f8-b361-e31200f4a2c7-c', '', '2018-11-07 19:39:53', '3');
INSERT INTO customer_session VALUES ('200', '8a49d096-1ae5-4a26-b287-acd3278f9b32-c', '', '2018-11-07 19:40:11', '3');
INSERT INTO customer_session VALUES ('201', 'dd8137e2-0999-4c58-93a4-3cff1c7549df-c', '', '2018-11-07 19:58:51', '3');
INSERT INTO customer_session VALUES ('202', '68d4ae7f-2aa3-481f-97cf-8a64b3b5e476-c', '', '2018-11-07 20:00:03', '3');
INSERT INTO customer_session VALUES ('203', 'e8646ba9-3bcd-4f2a-ba93-9a5b90bae0d1-c', '', '2018-11-07 20:08:47', '3');
INSERT INTO customer_session VALUES ('204', 'ea0e15de-ab56-4899-b497-274b09d1e70f-c', '', '2018-11-07 20:10:07', '3');
INSERT INTO customer_session VALUES ('205', 'cdfeb755-b005-4463-8489-e596da843acb-c', '', '2018-11-07 20:11:24', '3');
INSERT INTO customer_session VALUES ('206', '64b2f542-7f74-452a-8cac-921a0df69e37-c', '', '2018-11-07 20:21:10', '3');
INSERT INTO customer_session VALUES ('207', '1c01c61e-a69f-4268-8f26-0b926f1b8a4e-c', '', '2018-11-07 20:30:50', '3');
INSERT INTO customer_session VALUES ('208', 'b6e1b7a7-d058-486d-96d9-ab8b9ea1356b-c', '', '2018-11-07 20:31:10', '3');

-- ----------------------------
-- Table structure for `datum`
-- ----------------------------
DROP TABLE IF EXISTS `datum`;
CREATE TABLE `datum` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `key_name` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=28 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of datum
-- ----------------------------
INSERT INTO datum VALUES ('27', 'test', 'test');

-- ----------------------------
-- Table structure for `diagnosis_and_treatment`
-- ----------------------------
DROP TABLE IF EXISTS `diagnosis_and_treatment`;
CREATE TABLE `diagnosis_and_treatment` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `doctor` varchar(255) DEFAULT NULL,
  `medicinec` varchar(255) DEFAULT NULL,
  `medicinew` varchar(255) DEFAULT NULL,
  `number` varchar(255) DEFAULT NULL,
  `other` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  `xyjb` varchar(255) DEFAULT NULL,
  `zfm` varchar(255) DEFAULT NULL,
  `zyjb` varchar(255) DEFAULT NULL,
  `zyzh` varchar(255) DEFAULT NULL,
  `zzzf` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=62 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of diagnosis_and_treatment
-- ----------------------------
INSERT INTO diagnosis_and_treatment VALUES ('60', '小龙', '无', '无', '11', '无', '西药', '神经病型先天性碘缺乏综合征', '救治', '囊痈', '凉燥袭肺证', '先攻后补');
INSERT INTO diagnosis_and_treatment VALUES ('58', '小龙', '无', '无', '12', '无', '啊', '胰岛素依赖型糖尿病', 'tad', '登豆疮-9', ' 阴虚证,肺虚邪恋证', '湿泥疗法');
INSERT INTO diagnosis_and_treatment VALUES ('59', '小龙', '无', '无', '12', '无', '1', '神经病型先天性碘缺乏综合征', '无', '筋疝', ' 阴虚证', '宣通气机,矿泉疗法');
INSERT INTO diagnosis_and_treatment VALUES ('61', '无', '无', '无', '无', '无', '无', '胰岛素依赖型糖尿病', '无12', '筋疝', '心气虚证', '矿泉疗法');

-- ----------------------------
-- Table structure for `diagnosis_of_we`
-- ----------------------------
DROP TABLE IF EXISTS `diagnosis_of_we`;
CREATE TABLE `diagnosis_of_we` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `tigejiancha` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=69 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of diagnosis_of_we
-- ----------------------------
INSERT INTO diagnosis_of_we VALUES ('65', '无');
INSERT INTO diagnosis_of_we VALUES ('66', '无');
INSERT INTO diagnosis_of_we VALUES ('67', '无');
INSERT INTO diagnosis_of_we VALUES ('68', '无');

-- ----------------------------
-- Table structure for `diagnosis_of_zh`
-- ----------------------------
DROP TABLE IF EXISTS `diagnosis_of_zh`;
CREATE TABLE `diagnosis_of_zh` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `gerenshi` varchar(255) DEFAULT NULL,
  `guomingshi` varchar(255) DEFAULT NULL,
  `hunyushi` varchar(255) DEFAULT NULL,
  `jiazhushi` varchar(255) DEFAULT NULL,
  `jiwangshi` varchar(255) DEFAULT NULL,
  `maizhen` varchar(255) DEFAULT NULL,
  `maizhen_sel` varchar(255) DEFAULT NULL,
  `pifimaofa` varchar(255) DEFAULT NULL,
  `qinahoueryinjipaixiewu` varchar(255) DEFAULT NULL,
  `qita` varchar(255) DEFAULT NULL,
  `sehz` varchar(255) DEFAULT NULL,
  `shensexingtai` varchar(255) DEFAULT NULL,
  `shezheng` varchar(255) DEFAULT NULL,
  `toumainwuguanjinxiang` varchar(255) DEFAULT NULL,
  `wenzhen` varchar(255) DEFAULT NULL,
  `xianbingshi` varchar(255) DEFAULT NULL,
  `xiongfu` varchar(255) DEFAULT NULL,
  `yaobeishizhizhuajia` varchar(255) DEFAULT NULL,
  `zhenzhuang` varchar(255) DEFAULT NULL,
  `zusu` varchar(255) DEFAULT NULL,
  `shezhenimg_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK15h9a2pchd2m6njxsijj442vc` (`shezhenimg_id`)
) ENGINE=MyISAM AUTO_INCREMENT=59 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of diagnosis_of_zh
-- ----------------------------
INSERT INTO diagnosis_of_zh VALUES ('55', '无', '无', '无', '无', '无', '无', '脉浮数', '无', '无', '无', '无', '无', '苔质', '无', '无', '无', '无', '无', '皮肤痰痒', '无', '557');
INSERT INTO diagnosis_of_zh VALUES ('56', '无', '无', '无', '无', '无', '无', '脉弦紧', '无', '无', '无', '无', '无', '舌色', '无', '无', '无', '无', '无', '数脉', '无', '568');
INSERT INTO diagnosis_of_zh VALUES ('57', '无', '无', '无', '无', '无', '无', '脉浮数', '无', '无', '无', '无', '无', '舌色', '无', '无', '无', '无', '无', '眼睑浮肿', '无', '579');
INSERT INTO diagnosis_of_zh VALUES ('58', '无', '无', '无', '无', '无', '无', '脉牢', '无', '无', '无', '无', '无', '苔质', '无', '无', '无', '无', '无', '眼睑浮肿', '无', '590');

-- ----------------------------
-- Table structure for `dictionary`
-- ----------------------------
DROP TABLE IF EXISTS `dictionary`;
CREATE TABLE `dictionary` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `sys_type` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=50 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of dictionary
-- ----------------------------
INSERT INTO dictionary VALUES ('1', '君', 'zyzz');
INSERT INTO dictionary VALUES ('2', '臣', 'zyzz');
INSERT INTO dictionary VALUES ('3', '使', 'zyzz');
INSERT INTO dictionary VALUES ('4', '先煎', 'zyyf');
INSERT INTO dictionary VALUES ('5', '后下', 'zyyf');
INSERT INTO dictionary VALUES ('6', '唐', 'cdd');
INSERT INTO dictionary VALUES ('7', '宋', 'cdd');
INSERT INTO dictionary VALUES ('8', '元', 'cdd');
INSERT INTO dictionary VALUES ('9', '明', 'cdd');
INSERT INTO dictionary VALUES ('10', '清', 'cdd');
INSERT INTO dictionary VALUES ('11', '民国', 'cdd');
INSERT INTO dictionary VALUES ('12', '时方', 'fj');
INSERT INTO dictionary VALUES ('13', '经验方', 'fj');
INSERT INTO dictionary VALUES ('14', '外敷', 'gytj');
INSERT INTO dictionary VALUES ('15', '内服', 'gytj');
INSERT INTO dictionary VALUES ('16', '散', 'jxgl');
INSERT INTO dictionary VALUES ('17', '丸', 'jxgl');
INSERT INTO dictionary VALUES ('18', '膏', 'jxgl');
INSERT INTO dictionary VALUES ('19', '马科', 'kfl');
INSERT INTO dictionary VALUES ('20', '伞形科', 'kfl');
INSERT INTO dictionary VALUES ('21', '紫金牛科', 'kfl');
INSERT INTO dictionary VALUES ('22', '斑蝥属', 'sfl');
INSERT INTO dictionary VALUES ('23', '菘蓝属', 'sfl');
INSERT INTO dictionary VALUES ('24', '半边莲属', 'sfl');
INSERT INTO dictionary VALUES ('26', '菊科', 'kfl');
INSERT INTO dictionary VALUES ('27', '安息香科', 'kfl');
INSERT INTO dictionary VALUES ('28', '木兰科', 'kfl');
INSERT INTO dictionary VALUES ('29', '大就科', 'kfl');
INSERT INTO dictionary VALUES ('30', '茜草科', 'kfl');
INSERT INTO dictionary VALUES ('31', '百合科', 'kfl');
INSERT INTO dictionary VALUES ('32', '豆科', 'kfl');
INSERT INTO dictionary VALUES ('33', '天南星科', 'kfl');
INSERT INTO dictionary VALUES ('34', '银杏科', 'kfl');
INSERT INTO dictionary VALUES ('35', '半夏属', 'sfl');
INSERT INTO dictionary VALUES ('36', '黄芩属', 'sfl');
INSERT INTO dictionary VALUES ('37', '薄荷属', 'sfl');
INSERT INTO dictionary VALUES ('38', '蝙蝠葛属', 'sfl');
INSERT INTO dictionary VALUES ('39', '珊瑚菜属', 'sfl');
INSERT INTO dictionary VALUES ('40', '胡椒属', 'sfl');
INSERT INTO dictionary VALUES ('41', '木姜子属', 'sfl');
INSERT INTO dictionary VALUES ('42', '蓖麻属', 'sfl');
INSERT INTO dictionary VALUES ('43', '蓼属', 'sfl');
INSERT INTO dictionary VALUES ('44', '槟榔属', 'sfl');
INSERT INTO dictionary VALUES ('45', '佐', 'zyzz');
INSERT INTO dictionary VALUES ('46', '其它', 'zyzz');
INSERT INTO dictionary VALUES ('47', '包煎', 'zyyf');
INSERT INTO dictionary VALUES ('48', '捣碎', 'zyyf');
INSERT INTO dictionary VALUES ('49', '烊化', 'zyyf');

-- ----------------------------
-- Table structure for `image`
-- ----------------------------
DROP TABLE IF EXISTS `image`;
CREATE TABLE `image` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `url` varchar(255) DEFAULT NULL,
  `western_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKmf03623qpqyohdqtwwjmwt9lw` (`western_id`)
) ENGINE=MyISAM AUTO_INCREMENT=554 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of image
-- ----------------------------
INSERT INTO image VALUES ('521', null, null, '/img/2018-11-07/15415796116131541579611613_.jpg', null);
INSERT INTO image VALUES ('546', null, null, '/img/2018-11-07/15415796116131541579611613_.jpg', '547');
INSERT INTO image VALUES ('524', null, null, '/img/2018-11-07/15415797227931541579722793_.jpg', null);
INSERT INTO image VALUES ('525', null, null, '/img/2018-11-07/15415797391511541579739151_.jpg', null);
INSERT INTO image VALUES ('526', null, null, '/img/2018-11-07/15415797449441541579744943_.jpg', null);
INSERT INTO image VALUES ('527', null, null, '/img/2018-11-07/15415797495761541579749576_.jpg', null);
INSERT INTO image VALUES ('528', null, null, '/img/2018-11-07/15415797552771541579755277_.jpg', null);
INSERT INTO image VALUES ('529', null, null, '/img/2018-11-07/15415797596231541579759623_.jpg', null);
INSERT INTO image VALUES ('530', null, null, '/img/2018-11-07/15415797659051541579765905_.jpg', null);
INSERT INTO image VALUES ('531', null, null, '/img/2018-11-07/15415797700071541579770007_.jpg', null);
INSERT INTO image VALUES ('532', null, null, '/img/2018-11-07/15415797749581541579774958_.jpg', null);
INSERT INTO image VALUES ('533', null, null, '/img/2018-11-07/15415797791181541579779117_.jpg', null);
INSERT INTO image VALUES ('534', null, null, '/img/2018-11-07/15415797839271541579783927_.jpg', null);
INSERT INTO image VALUES ('535', null, null, '/img/2018-11-07/15415797391511541579739151_.jpg', '569');
INSERT INTO image VALUES ('536', null, null, '/img/2018-11-07/15415797449441541579744943_.jpg', '570');
INSERT INTO image VALUES ('537', null, null, '/img/2018-11-07/15415797495761541579749576_.jpg', '571');
INSERT INTO image VALUES ('538', null, null, '/img/2018-11-07/15415797552771541579755277_.jpg', '572');
INSERT INTO image VALUES ('539', null, null, '/img/2018-11-07/15415797596231541579759623_.jpg', '573');
INSERT INTO image VALUES ('540', null, null, '/img/2018-11-07/15415797659051541579765905_.jpg', '574');
INSERT INTO image VALUES ('541', null, null, '/img/2018-11-07/15415797700071541579770007_.jpg', '575');
INSERT INTO image VALUES ('542', null, null, '/img/2018-11-07/15415797749581541579774958_.jpg', '576');
INSERT INTO image VALUES ('543', null, null, '/img/2018-11-07/15415797791181541579779117_.jpg', '577');
INSERT INTO image VALUES ('544', null, null, '/img/2018-11-07/15415797839271541579783927_.jpg', '578');
INSERT INTO image VALUES ('545', null, null, '/img/2018-11-07/15415797227931541579722793_.jpg', '579');
INSERT INTO image VALUES ('547', null, null, '/img/2018-11-07/15415939038071541593903807_.jpg', null);
INSERT INTO image VALUES ('552', null, null, '/img/2018-11-07/15415941189891541594118989_.jpg', '580');
INSERT INTO image VALUES ('549', null, null, '/img/2018-11-07/15415939170981541593917098_.jpg', null);
INSERT INTO image VALUES ('551', null, null, '/img/2018-11-07/15415941189891541594118989_.jpg', null);
INSERT INTO image VALUES ('553', null, null, '/img/2018-11-07/15415939170981541593917098_.jpg', '590');
INSERT INTO image VALUES ('520', null, null, '/img/2018-11-07/15415791244971541579124497_.jpg', null);
INSERT INTO image VALUES ('518', null, null, '/img/2018-11-07/15415713278821541571327882_.jpg', '536');
INSERT INTO image VALUES ('519', null, null, '/img/2018-11-07/15415713148751541571314875_.jpg', '546');

-- ----------------------------
-- Table structure for `medicine`
-- ----------------------------
DROP TABLE IF EXISTS `medicine`;
CREATE TABLE `medicine` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `liang` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `yongfa` varchar(255) DEFAULT NULL,
  `zhuyong` varchar(255) DEFAULT NULL,
  `dat_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKo3bnpdspagnjq87bjko3xp5m3` (`dat_id`)
) ENGINE=MyISAM AUTO_INCREMENT=2262 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of medicine
-- ----------------------------
INSERT INTO medicine VALUES ('2250', '12', '新的中药', '先煎', '君', '53');
INSERT INTO medicine VALUES ('2248', '11', '当归', '后下', '使', '53');
INSERT INTO medicine VALUES ('2249', '12', '新的中药', '先煎', '君', '53');
INSERT INTO medicine VALUES ('2241', '12', '新的中药', '后下', '臣', '56');
INSERT INTO medicine VALUES ('2251', '12', '黄芩', '后下', '臣', '57');
INSERT INTO medicine VALUES ('2257', '12', '知母', '后下', '臣', '58');
INSERT INTO medicine VALUES ('2253', '12', '寒水石', '捣碎', '使', '59');
INSERT INTO medicine VALUES ('2256', '12', '西洋参', '包煎', '臣', '60');
INSERT INTO medicine VALUES ('2261', '11', '知母', '先煎', '君', '61');

-- ----------------------------
-- Table structure for `other_message`
-- ----------------------------
DROP TABLE IF EXISTS `other_message`;
CREATE TABLE `other_message` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `date` varchar(255) DEFAULT NULL,
  `grxd` varchar(255) DEFAULT NULL,
  `huifangneirong` varchar(255) DEFAULT NULL,
  `huifangren` varchar(255) DEFAULT NULL,
  `lsdy` varchar(255) DEFAULT NULL,
  `qita` varchar(255) DEFAULT NULL,
  `xylxpj` varchar(255) DEFAULT NULL,
  `zjdp` varchar(255) DEFAULT NULL,
  `zylxpj` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=59 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of other_message
-- ----------------------------
INSERT INTO other_message VALUES ('55', '', '无', '无', '无', '无', '无', '恶化', '无', '恶化');
INSERT INTO other_message VALUES ('56', '', '无', '无', '无', '无', '无', '恶化', '无', '恶化');
INSERT INTO other_message VALUES ('57', '', '无', '无', '无', '无', '无', '恶化', '无', '恶化');
INSERT INTO other_message VALUES ('58', '', '无', '无', '无', '无', '无', '恶化', '无', '恶化');

-- ----------------------------
-- Table structure for `patient`
-- ----------------------------
DROP TABLE IF EXISTS `patient`;
CREATE TABLE `patient` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `address` varchar(255) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `birthplace` varchar(255) DEFAULT NULL,
  `card_id` bigint(20) DEFAULT NULL,
  `citizenship` varchar(255) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `end_date` datetime DEFAULT NULL,
  `ethnic` varchar(255) DEFAULT NULL,
  `first_date` datetime DEFAULT NULL,
  `height` double DEFAULT NULL,
  `marriage` int(11) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `profession` varchar(255) DEFAULT NULL,
  `sex` varchar(255) DEFAULT NULL,
  `time` int(11) DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  `visit_time` datetime DEFAULT NULL,
  `weight` double DEFAULT NULL,
  `zip_code` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of patient
-- ----------------------------
INSERT INTO patient VALUES ('1', '资阳', '12', '资阳', null, '啊', '2018-11-07 20:21:22', null, '12', null, null, '1', '小龙', '18328463514', '13', '男', '0', null, '2018-11-07 20:21:22', '12', '1');
INSERT INTO patient VALUES ('2', '成都', '19', '成都', null, '中国', '2018-08-14 10:42:40', '2018-11-07 20:17:27', '汉族', '2018-11-07 20:17:27', null, null, '测试用户', '17738849384', '码农', '男', null, null, null, '48', '343432');
INSERT INTO patient VALUES ('4', '成都', '22', '成都', null, '中国', '2018-11-06 10:46:35', '2018-11-07 14:16:02', '汉', '2018-11-06 11:45:35', null, '2', '张平', '18839940958', '无业', '男', '2', null, '2018-11-06 10:46:35', '49', '39940');
INSERT INTO patient VALUES ('5', '成都', '28', '德阳', null, '中国', '2018-11-06 10:49:25', null, '汉', null, null, '2', '成龙', '13849596879', '学生', '男', '0', null, '2018-11-06 10:49:25', '58', '3434');
INSERT INTO patient VALUES ('6', '成都', '12', '成都', null, '中国', '2018-11-07 14:12:29', null, '汉', null, null, '2', '测试', '123123123', '学生', '男', '0', null, '2018-11-07 14:12:29', '48', '1234');

-- ----------------------------
-- Table structure for `platform_manager`
-- ----------------------------
DROP TABLE IF EXISTS `platform_manager`;
CREATE TABLE `platform_manager` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `f_class` bigint(20) DEFAULT NULL,
  `is_menu` int(11) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `sys_type` varchar(255) DEFAULT NULL,
  `type` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=214 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of platform_manager
-- ----------------------------
INSERT INTO platform_manager VALUES ('154', '0', '1', '舌诊——舌质	', 'sz', '1');
INSERT INTO platform_manager VALUES ('106', '104', '0', '知母', 'zy', '0');
INSERT INTO platform_manager VALUES ('178', '119', '0', '湿泥疗法', 'zzzf', '2');
INSERT INTO platform_manager VALUES ('124', '0', '1', ' 相兼脉', 'mz', '1');
INSERT INTO platform_manager VALUES ('53', '43', '0', '筋疝', 'cdm', '2');
INSERT INTO platform_manager VALUES ('79', '0', '1', '心系证类', 'zh', '1');
INSERT INTO platform_manager VALUES ('131', '0', '1', ' 活血化瘀类', 'gxlx', '0');
INSERT INTO platform_manager VALUES ('9', '0', '1', '症状父类', 'zz', '1');
INSERT INTO platform_manager VALUES ('165', '9', '0', '数脉', 'zz', '2');
INSERT INTO platform_manager VALUES ('155', '154', '0', '舌色', 'sz', '1');
INSERT INTO platform_manager VALUES ('160', '99', '0', '巴豆霜', 'yp', '0');
INSERT INTO platform_manager VALUES ('119', '0', '1', ' 杂疗法', 'zzzf', '1');
INSERT INTO platform_manager VALUES ('163', '101', '0', '苦楝皮', 'yp', '0');
INSERT INTO platform_manager VALUES ('167', '9', '0', '皮肤痰痒', 'zz', '2');
INSERT INTO platform_manager VALUES ('80', '0', '1', ' 肺系证类', 'zh', '1');
INSERT INTO platform_manager VALUES ('147', '70', '1', '甲状腺疾患', 'wdm', '0');
INSERT INTO platform_manager VALUES ('108', '107', '0', '黄芩', 'zy', '0');
INSERT INTO platform_manager VALUES ('164', '109', '0', '西洋参', 'zy', '0');
INSERT INTO platform_manager VALUES ('25', '0', '1', '方剂主治类型', 'fjzz', '1');
INSERT INTO platform_manager VALUES ('166', '0', '1', '其它', 'zz', '1');
INSERT INTO platform_manager VALUES ('27', '0', '0', '默认方剂类型', 'fj', '1');
INSERT INTO platform_manager VALUES ('39', '27', '0', '华佗感冒方膏', 'fj', '2');
INSERT INTO platform_manager VALUES ('81', '0', '1', '脾系证类', 'zh', '1');
INSERT INTO platform_manager VALUES ('107', '103', '1', '清热燥湿类', 'zy', '0');
INSERT INTO platform_manager VALUES ('42', '0', '1', '皮肤病类-1', 'cdm', '1');
INSERT INTO platform_manager VALUES ('43', '0', '1', '男性前阴病类', 'cdm', '1');
INSERT INTO platform_manager VALUES ('44', '0', '1', '眼病类', 'cdm', '1');
INSERT INTO platform_manager VALUES ('45', '0', '1', '肛肠疾类', 'cdm', '1');
INSERT INTO platform_manager VALUES ('46', '0', '1', '传染病、寄生虫疾类', 'cdm', '1');
INSERT INTO platform_manager VALUES ('47', '42', '0', '登豆疮-9', 'cdm', '2');
INSERT INTO platform_manager VALUES ('48', '42', '0', '鹅掌风', 'cdm', '2');
INSERT INTO platform_manager VALUES ('49', '42', '0', '恶虫叮咬伤', 'cdm', '2');
INSERT INTO platform_manager VALUES ('50', '42', '0', ' 秃疮', 'cdm', '2');
INSERT INTO platform_manager VALUES ('51', '43', '0', '囊痈', 'cdm', '2');
INSERT INTO platform_manager VALUES ('52', '43', '0', '包茎', 'cdm', '2');
INSERT INTO platform_manager VALUES ('54', '43', '0', '精薄', 'cdm', '2');
INSERT INTO platform_manager VALUES ('55', '43', '0', '精冷', 'cdm', '2');
INSERT INTO platform_manager VALUES ('70', '0', '1', '内分泌、营养和代谢疾病', 'wdm', '0');
INSERT INTO platform_manager VALUES ('57', '44', '0', '赤脉传睛', 'cdm', '2');
INSERT INTO platform_manager VALUES ('58', '44', '0', '赤膜下垂', 'cdm', '2');
INSERT INTO platform_manager VALUES ('59', '44', '0', '赤丝虬脉', 'cdm', '2');
INSERT INTO platform_manager VALUES ('60', '44', '0', '倒睫拳毛', 'cdm', '2');
INSERT INTO platform_manager VALUES ('61', '44', '0', '电光伤目', 'cdm', '2');
INSERT INTO platform_manager VALUES ('62', '44', '0', '通睛', 'cdm', '2');
INSERT INTO platform_manager VALUES ('63', '45', '0', '肛门湿疡', 'cdm', '2');
INSERT INTO platform_manager VALUES ('64', '45', '0', '肛肠病类', 'cdm', '2');
INSERT INTO platform_manager VALUES ('65', '46', '0', '横痃', 'cdm', '2');
INSERT INTO platform_manager VALUES ('66', '46', '0', '百日咳', 'cdm', '2');
INSERT INTO platform_manager VALUES ('67', '46', '0', ' 急性蛊虫病', 'cdm', '2');
INSERT INTO platform_manager VALUES ('68', '46', '0', '噤口痢', 'cdm', '2');
INSERT INTO platform_manager VALUES ('150', '149', '0', '神经病型先天性碘缺乏综合征', 'wdm', '0');
INSERT INTO platform_manager VALUES ('151', '148', '1', '胰岛素依赖型糖尿病', 'wdm', '0');
INSERT INTO platform_manager VALUES ('182', '0', '1', '理气法', 'zzzf', '1');
INSERT INTO platform_manager VALUES ('77', '0', '1', ' 基本虚证类', 'zh', '1');
INSERT INTO platform_manager VALUES ('78', '0', '1', '虚实夹杂证类', 'zh', '1');
INSERT INTO platform_manager VALUES ('153', '77', '0', ' 阴虚证', 'zh', '2');
INSERT INTO platform_manager VALUES ('180', '116', '0', '食疗', 'zzzf', '2');
INSERT INTO platform_manager VALUES ('181', '0', '1', '清热法', 'zzzf', '1');
INSERT INTO platform_manager VALUES ('156', '0', '1', '舌诊——舌苔', 'sz', '1');
INSERT INTO platform_manager VALUES ('157', '156', '0', '苔质', 'sz', '1');
INSERT INTO platform_manager VALUES ('177', '112', '0', '标本兼治', 'zzzf', '2');
INSERT INTO platform_manager VALUES ('179', '119', '0', '矿泉疗法', 'zzzf', '2');
INSERT INTO platform_manager VALUES ('94', '0', '1', '清热类', 'yp', '0');
INSERT INTO platform_manager VALUES ('174', '112', '0', '祛邪扶正', 'zzzf', '2');
INSERT INTO platform_manager VALUES ('175', '112', '0', '攻补兼施', 'zzzf', '2');
INSERT INTO platform_manager VALUES ('99', '0', '1', '其他', 'yp', '0');
INSERT INTO platform_manager VALUES ('176', '112', '0', '先攻后补', 'zzzf', '2');
INSERT INTO platform_manager VALUES ('101', '0', '1', '驱虫类', 'yp', '0');
INSERT INTO platform_manager VALUES ('103', '0', '1', '清热类', 'zy', '0');
INSERT INTO platform_manager VALUES ('104', '103', '1', '清热泻火类', 'zy', '0');
INSERT INTO platform_manager VALUES ('105', '104', '0', '寒水石', 'zy', '0');
INSERT INTO platform_manager VALUES ('109', '110', '1', '补气类', 'zy', '0');
INSERT INTO platform_manager VALUES ('110', '0', '1', '虚补类', 'zy', '0');
INSERT INTO platform_manager VALUES ('111', '109', '0', '人参', 'zy', '0');
INSERT INTO platform_manager VALUES ('112', '0', '1', ' 治则', 'zzzf', '1');
INSERT INTO platform_manager VALUES ('172', '124', '0', '脉弦紧', 'mz', '2');
INSERT INTO platform_manager VALUES ('173', '121', '0', '脉伏', 'mz', '2');
INSERT INTO platform_manager VALUES ('116', '0', '1', ' 饮食疗法', 'zzzf', '1');
INSERT INTO platform_manager VALUES ('158', '94', '0', '忍冬藤', 'yp', '0');
INSERT INTO platform_manager VALUES ('171', '124', '0', '脉沉弦', 'mz', '2');
INSERT INTO platform_manager VALUES ('121', '0', '1', ' 单一脉象', 'mz', '1');
INSERT INTO platform_manager VALUES ('161', '101', '0', '焦槟榔', 'yp', '0');
INSERT INTO platform_manager VALUES ('159', '94', '0', '飞扬草', 'yp', '0');
INSERT INTO platform_manager VALUES ('127', '0', '1', '其他', 'mz', '1');
INSERT INTO platform_manager VALUES ('128', '0', '1', ' 清热类', 'gxlx', '0');
INSERT INTO platform_manager VALUES ('162', '101', '0', '使君子', 'yp', '0');
INSERT INTO platform_manager VALUES ('168', '121', '0', '新脉浮', 'mz', '2');
INSERT INTO platform_manager VALUES ('169', '121', '0', '脉牢', 'mz', '2');
INSERT INTO platform_manager VALUES ('134', '0', '1', '补虚类', 'gxlx', '0');
INSERT INTO platform_manager VALUES ('170', '124', '0', '脉浮数', 'mz', '2');
INSERT INTO platform_manager VALUES ('137', '0', '1', '其他', 'gxlx', '0');
INSERT INTO platform_manager VALUES ('148', '70', '1', ' 糖尿病', 'wdm', '0');
INSERT INTO platform_manager VALUES ('152', '151', '0', '胰岛素依赖型糖尿病', 'wdm', '0');
INSERT INTO platform_manager VALUES ('149', '147', '1', '先天性碘缺乏综合征', 'wdm', '0');
INSERT INTO platform_manager VALUES ('198', '25', '0', '外感风寒表证', 'fjzz', '2');
INSERT INTO platform_manager VALUES ('183', '0', '1', '理血法', 'zzzf', '1');
INSERT INTO platform_manager VALUES ('184', '0', '1', '解表法', 'zzzf', '1');
INSERT INTO platform_manager VALUES ('185', '0', '1', '祛湿法', 'zzzf', '1');
INSERT INTO platform_manager VALUES ('186', '0', '1', '温里法', 'zzzf', '1');
INSERT INTO platform_manager VALUES ('187', '0', '1', '祛暑法', 'zzzf', '1');
INSERT INTO platform_manager VALUES ('188', '182', '0', '宣通气机', 'zzzf', '2');
INSERT INTO platform_manager VALUES ('189', '182', '0', '利气疏导', 'zzzf', '2');
INSERT INTO platform_manager VALUES ('190', '131', '0', '活血止痛类', 'gxlx', '0');
INSERT INTO platform_manager VALUES ('191', '131', '0', '活血调经类', 'gxlx', '0');
INSERT INTO platform_manager VALUES ('192', '131', '0', '活血化瘀类', 'gxlx', '0');
INSERT INTO platform_manager VALUES ('193', '128', '0', '清热泻火类', 'gxlx', '0');
INSERT INTO platform_manager VALUES ('194', '128', '0', '清热燥湿类', 'gxlx', '0');
INSERT INTO platform_manager VALUES ('195', '128', '0', '清热解毒类', 'gxlx', '0');
INSERT INTO platform_manager VALUES ('196', '134', '0', '补阳类', 'gxlx', '0');
INSERT INTO platform_manager VALUES ('197', '134', '0', '补气类', 'gxlx', '0');
INSERT INTO platform_manager VALUES ('199', '25', '0', '外寒内饮证', 'fjzz', '2');
INSERT INTO platform_manager VALUES ('200', '25', '0', '水热互结痞证', 'fjzz', '2');
INSERT INTO platform_manager VALUES ('201', '25', '0', '肝郁脾弱血虚证', 'fjzz', '2');
INSERT INTO platform_manager VALUES ('202', '9', '0', '目昏', 'zz', '2');
INSERT INTO platform_manager VALUES ('203', '9', '0', '咽喉红', 'zz', '2');
INSERT INTO platform_manager VALUES ('204', '9', '0', '眼睑浮肿', 'zz', '2');
INSERT INTO platform_manager VALUES ('205', '79', '0', '心气虚证', 'zh', '2');
INSERT INTO platform_manager VALUES ('206', '79', '0', '心气血两虚证', 'zh', '2');
INSERT INTO platform_manager VALUES ('207', '80', '0', '肺虚邪恋证', 'zh', '2');
INSERT INTO platform_manager VALUES ('208', '80', '0', '痰浊阻肺证', 'zh', '2');
INSERT INTO platform_manager VALUES ('209', '80', '0', '凉燥袭肺证', 'zh', '2');
INSERT INTO platform_manager VALUES ('210', '81', '0', '脾虚营亏证', 'zh', '2');
INSERT INTO platform_manager VALUES ('211', '81', '0', '胃阳虚证', 'zh', '2');
INSERT INTO platform_manager VALUES ('212', '81', '0', '胃燥津伤证', 'zh', '2');
INSERT INTO platform_manager VALUES ('213', '78', '0', '精气亏虚证', 'zh', '2');

-- ----------------------------
-- Table structure for `platform_manager_data`
-- ----------------------------
DROP TABLE IF EXISTS `platform_manager_data`;
CREATE TABLE `platform_manager_data` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `pm_id` bigint(20) DEFAULT NULL,
  `x1` varchar(255) DEFAULT NULL,
  `x10` varchar(255) DEFAULT NULL,
  `x11` varchar(255) DEFAULT NULL,
  `x12` varchar(255) DEFAULT NULL,
  `x13` varchar(255) DEFAULT NULL,
  `x14` varchar(255) DEFAULT NULL,
  `x15` varchar(255) DEFAULT NULL,
  `x16` varchar(255) DEFAULT NULL,
  `x17` varchar(255) DEFAULT NULL,
  `x18` varchar(255) DEFAULT NULL,
  `x19` varchar(255) DEFAULT NULL,
  `x2` varchar(255) DEFAULT NULL,
  `x20` varchar(255) DEFAULT NULL,
  `x21` varchar(255) DEFAULT NULL,
  `x22` varchar(255) DEFAULT NULL,
  `x23` varchar(255) DEFAULT NULL,
  `x24` varchar(255) DEFAULT NULL,
  `x25` varchar(255) DEFAULT NULL,
  `x3` varchar(255) DEFAULT NULL,
  `x4` varchar(255) DEFAULT NULL,
  `x5` varchar(255) DEFAULT NULL,
  `x6` varchar(255) DEFAULT NULL,
  `x7` varchar(255) DEFAULT NULL,
  `x8` varchar(255) DEFAULT NULL,
  `x9` varchar(255) DEFAULT NULL,
  `platform_manager` tinyblob,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=178 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of platform_manager_data
-- ----------------------------
INSERT INTO platform_manager_data VALUES ('126', '167', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO platform_manager_data VALUES ('127', '168', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO platform_manager_data VALUES ('128', '169', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO platform_manager_data VALUES ('129', '170', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO platform_manager_data VALUES ('130', '171', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO platform_manager_data VALUES ('118', '162', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '使君子', null, null, null, null, null, null);
INSERT INTO platform_manager_data VALUES ('119', '163', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '苦楝皮', null, null, null, null, null, null);
INSERT INTO platform_manager_data VALUES ('117', '161', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '焦槟榔', null, null, null, null, null, null);
INSERT INTO platform_manager_data VALUES ('121', '106', null, null, null, null, null, null, null, '寒', '甘', '肝,肺,肾,胃', '', null, '', '', '', null, null, '', null, null, null, null, null, '菊科', '黄芩属,薄荷属', null);
INSERT INTO platform_manager_data VALUES ('125', '165', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO platform_manager_data VALUES ('124', '164', null, null, null, null, null, null, null, '温', '甘', '脾,肾', '', null, '', '', '', null, null, '', null, null, null, null, null, '伞形科', '半边莲属,黄芩属', null);
INSERT INTO platform_manager_data VALUES ('44', '48', null, null, '', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '因风湿蕴肤，或血虚风燥所致。以手掌水疱脱屑、粗糙、变厚、干燥皲裂，自觉痒痛为主要表现的癣病类疾病', '', '', null, null, null);
INSERT INTO platform_manager_data VALUES ('45', '49', null, null, '', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '因蚊子、臭虫、跳蚤等叮咬，虫毒侵袭肌肤所致。以皮肤见红色疹点、瘙痒等为主要表现的皮肤疾病。', '', '', null, null, null);
INSERT INTO platform_manager_data VALUES ('46', '50', null, null, '', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '因剃发感染，风热凝滞所致。以头部脱片状白屑，久则发失光泽、折断，自觉瘙痒为主要表现的皮肤病。', '', '', null, null, null);
INSERT INTO platform_manager_data VALUES ('47', '51', null, null, '', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '因肝肾湿热下注，或外湿内侵蕴酿成毒所致。以阴囊红肿热痛，肾子（睾丸）不肿大为主要表现的痈病类疾病。', '', '', null, null, null);
INSERT INTO platform_manager_data VALUES ('48', '52', null, null, '', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '多因先天所致。以包皮口细小，包皮不能上翻，龟头不能外露为主要表现的男性前阴疾病。', '', '', null, null, null);
INSERT INTO platform_manager_data VALUES ('49', '53', null, null, '', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '因血脉瘀滞所致。以阴囊筋脉曲张如蚯蚓状，伴有坠胀为主要表现的疝病类疾病。', '', '', null, null, null);
INSERT INTO platform_manager_data VALUES ('50', '54', null, null, '', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '因肾阳不足等所致。以精液稀薄而量多（大于8ml），影响生育力为主要表现的肾系疾病。\n', '', '', null, null, null);
INSERT INTO platform_manager_data VALUES ('51', '55', null, null, '', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '因肾阳不足，阴寒内盛等所致。以自觉射精时精液清冷，影响生育力为主要表现的肾系疾病。', '', '', null, null, null);
INSERT INTO platform_manager_data VALUES ('52', '57', null, null, '', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '因心火上炎，或阴虚火旺所致。以眦部生长赤脉，横侵白睛为主要表现的外障类疾病。\n', '', '', null, null, null);
INSERT INTO platform_manager_data VALUES ('53', '58', null, null, '', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '因风热壅盛所致。以黑睛上缘或四周出现赤脉密集的翳膜为主要表现的翳病类疾病。', '', '', null, null, null);
INSERT INTO platform_manager_data VALUES ('54', '59', null, null, '', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '因热郁血滞所致。以白睛出现赤丝纵横，或赤紫蟠曲、粗细不一，久不能愈为主要表现的外障类疾病。', '', '', null, null, null);
INSERT INTO platform_manager_data VALUES ('55', '60', null, null, '', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '因椒疮经久不愈，胞睑瘢痕挛缩内翻所致。以睫毛倒入，内刺眼珠，畏光流泪为主要表现的外障类疾病。', '', '', null, null, null);
INSERT INTO platform_manager_data VALUES ('56', '61', null, null, '', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '因电光刺伤白睛、黑睛浅层所致。以眼珠红赤畏光、流泪或疼痛为主要表现的损伤类疾病。\n', '', '', null, null, null);
INSERT INTO platform_manager_data VALUES ('57', '62', null, null, '', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '因禀赋不足、筋脉失调，或高热伤津所致。以双眼向内偏斜为主要表现的外障类疾病。', '', '', null, null, null);
INSERT INTO platform_manager_data VALUES ('58', '63', null, null, '', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '湿热污浊之邪下注，结聚于肛门部皮肤。以肛门部皮肤起丘疹、瘙痒、渗液等为主要表现的湿疮类疾病。', '', '', null, null, null);
INSERT INTO platform_manager_data VALUES ('59', '64', null, null, '', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '因先天形成，或手术损伤、肿物挤压等导致肛门、肛管变窄。以排便困难，便细为主要表现的肛门疾病。', '', '', null, null, null);
INSERT INTO platform_manager_data VALUES ('60', '65', null, null, '', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '发生于两腿合缝间的梅毒。以臖核肿大、溃破如鱼嘴为主要表现。生于左者名鱼口；生于右者名便毒。', '', '', null, null, null);
INSERT INTO platform_manager_data VALUES ('61', '66', null, null, '', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '时行疫邪犯肺，阻于气道而肺气上逆。以阵发呛咳，咳后有鸡鸣样回声为主要表现的疫病类疾病。\n', '', '', null, null, null);
INSERT INTO platform_manager_data VALUES ('62', '67', null, null, '', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '感染蛊虫疫毒初期，以肤痒、咳嗽、发热、腹痛腹泻等为主要表现者。', '', '', null, null, null);
INSERT INTO platform_manager_data VALUES ('63', '68', null, null, '', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '多因湿热疫毒蕴结肠中，邪毒亢盛，损伤气阴所致。以呕恶不食，下痢频繁，肌肉瘦削为特点的痢疾。', '', '', null, null, null);
INSERT INTO platform_manager_data VALUES ('106', '144', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO platform_manager_data VALUES ('116', '160', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '巴豆霜', null, null, null, null, null, null);
INSERT INTO platform_manager_data VALUES ('68', '83', '阳脱证\n', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '阳气衰竭而欲脱，以冷汗淋漓，身凉肢厥，神倦息微，面色苍白，脉微欲绝，舌淡苔润等为常见症的危重证候。', null, null, null, null, null, null, null);
INSERT INTO platform_manager_data VALUES ('69', '84', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '泛指气虚兼夹痰湿、水饮、瘀血等邪的证候。其症除有气虚表现外，并因实邪不同而各具特征。\n', null, null, null, null, null, null, null);
INSERT INTO platform_manager_data VALUES ('70', '85', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '正气亏虚，阳气浮动，以日久低热，劳累更显，食少乏力，气短懒言，舌淡脉虚为常见症的证候。', null, null, null, null, null, null, null);
INSERT INTO platform_manager_data VALUES ('72', '89', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO platform_manager_data VALUES ('73', '90', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO platform_manager_data VALUES ('74', '92', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO platform_manager_data VALUES ('77', '98', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, ' 黄芩', null, null, null, null, null, null);
INSERT INTO platform_manager_data VALUES ('78', '100', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, ' 巴豆霜', null, null, null, null, null, null);
INSERT INTO platform_manager_data VALUES ('79', '102', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '焦槟榔', null, null, null, null, null, null);
INSERT INTO platform_manager_data VALUES ('122', '105', null, null, null, null, null, null, null, '寒', '辛,咸', '心,肾,胃', '', null, '', '', '', null, null, '', null, null, null, null, null, '菊科,大就科', '半边莲属,薄荷属', null);
INSERT INTO platform_manager_data VALUES ('123', '111', null, null, null, null, null, null, null, '温', '甘', '肝,脾,肺,心', '', null, '', '', '', null, null, '', null, null, null, null, null, '菊科,大就科', '半边莲属', null);
INSERT INTO platform_manager_data VALUES ('84', '113', '祛邪安正', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '对于邪气实而正气偏虚的病证，应采取以消除病邪为主，扶助正气为辅，使邪去而正安或正复的治', null, null, null, null, null, null, null);
INSERT INTO platform_manager_data VALUES ('85', '114', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '对于虚实夹杂，或虚实病情相当的病证，可采用既扶正又祛邪，即祛邪与扶正并重的治疗原则。', null, null, null, null, null, null, null);
INSERT INTO platform_manager_data VALUES ('86', '115', null, null, null, null, null, null, null, null, null, null, null, '', null, null, null, null, null, null, '先攻邪后培补的治疗原则，用于体弱正虚而又有急须攻下或攻破之症的病证。', null, null, null, null, null, null, null);
INSERT INTO platform_manager_data VALUES ('87', '117', '食物疗法；食疗法；食物疗', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '应用具有药理作用的食物防治疾病的一种方法。药膳、药茶、药粥、药饮等都属食物疗法的范畴。', null, null, null, null, null, null, null);
INSERT INTO platform_manager_data VALUES ('131', '172', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO platform_manager_data VALUES ('132', '173', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO platform_manager_data VALUES ('112', '155', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO platform_manager_data VALUES ('113', '157', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO platform_manager_data VALUES ('114', '158', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '忍冬藤', null, null, null, null, null, null);
INSERT INTO platform_manager_data VALUES ('115', '159', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '飞扬草', null, null, null, null, null, null);
INSERT INTO platform_manager_data VALUES ('102', '47', null, null, '', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '因表虚里实，毒热入于营血所致。以皮肤大片潮红，出现群集性帽针头至粟粒大小脓疱为主要表现的皮肤疾病。', '', '', '没接语音', null, null);
INSERT INTO platform_manager_data VALUES ('109', '150', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO platform_manager_data VALUES ('110', '152', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO platform_manager_data VALUES ('111', '153', '阴液亏虚证', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '阴液不足，不能制阳，以潮热盗汗，午后颧红，五心烦热，口燥咽干，舌红少苔，脉细数等为常见症的证候。', null, null, null, null, null, null, null);
INSERT INTO platform_manager_data VALUES ('133', '174', '祛邪安正', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '对于邪气实而正气偏虚的病证，应采取以消除病邪为主，扶助正气为辅，使邪去而正安或正复的治', null, null, null, null, null, null, null);
INSERT INTO platform_manager_data VALUES ('134', '175', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '对于虚实夹杂，或虚实病情相当的病证，可采用既扶正又祛邪，即祛邪与扶正并重的治疗原则。', null, null, null, null, null, null, null);
INSERT INTO platform_manager_data VALUES ('135', '176', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '先攻邪后培补的治疗原则，用于体弱正虚而又有急须攻下或攻破之症的病证。', null, null, null, null, null, null, null);
INSERT INTO platform_manager_data VALUES ('136', '177', '标本同治', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '在病证出现标本并重的情况下，可采用治标与治本相结合的治疗原则。', null, null, null, null, null, null, null);
INSERT INTO platform_manager_data VALUES ('137', '178', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '用湿泥或药泥敷在人体的一定部位，或将整个身体置于泥中，以此来治疗疾病的一种方法。主要用于实热病证。', null, null, null, null, null, null, null);
INSERT INTO platform_manager_data VALUES ('138', '179', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '利用矿泉水内服外用，以防治疾病的一种方法，主要用于某些脏腑的病变及外科、皮肤科、妇科的病变。', null, null, null, null, null, null, null);
INSERT INTO platform_manager_data VALUES ('139', '180', '食物疗法；食疗法；食物疗', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '应用具有药理作用的食物防治疾病的一种方法。药膳、药茶、药粥、药饮等都属食物疗法的范畴。\n', null, null, null, null, null, null, null);
INSERT INTO platform_manager_data VALUES ('140', '188', '宣畅气机', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '具有调理宣通气机作用，适用于气机郁滞证的治疗方法。', null, null, null, null, null, null, null);
INSERT INTO platform_manager_data VALUES ('141', '189', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '具有行气导事作用，适用于气滞证的治疗方法。', null, null, null, null, null, null, null);
INSERT INTO platform_manager_data VALUES ('142', '190', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO platform_manager_data VALUES ('143', '191', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO platform_manager_data VALUES ('144', '192', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO platform_manager_data VALUES ('145', '193', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO platform_manager_data VALUES ('146', '194', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO platform_manager_data VALUES ('147', '195', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO platform_manager_data VALUES ('148', '196', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO platform_manager_data VALUES ('149', '197', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO platform_manager_data VALUES ('150', '198', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO platform_manager_data VALUES ('151', '199', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO platform_manager_data VALUES ('152', '200', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO platform_manager_data VALUES ('153', '201', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO platform_manager_data VALUES ('154', '202', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO platform_manager_data VALUES ('155', '203', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO platform_manager_data VALUES ('156', '204', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO platform_manager_data VALUES ('158', '205', '心气亏虚证', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '心脏与心神气虚，以心悸气短，精神疲倦，或有自汗，面白舌淡，脉弱等为常见症的证候。', null, null, null, null, null, null, null);
INSERT INTO platform_manager_data VALUES ('159', '206', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '气血两虚，心与心神失养，以心悸，神疲头晕，多梦健忘，面白舌淡，脉弱等为常见症的证候。', null, null, null, null, null, null, null);
INSERT INTO platform_manager_data VALUES ('160', '207', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '肺气虚弱，外邪留恋，以恶风寒，低热不退，咳嗽气短，神疲食少，舌淡脉弱等为常见症的证候。\n', null, null, null, null, null, null, null);
INSERT INTO platform_manager_data VALUES ('161', '208', '痰浊蕴肺证；痰湿阻肺证；痰湿蕴肺证', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '痰湿蕴结，肺气阻滞，以胸闷，咳嗽气喘，吐白痰量多，苔白滑腻，脉弦滑等为常见症的证候。', null, null, null, null, null, null, null);
INSERT INTO platform_manager_data VALUES ('162', '209', '燥寒犯肺证', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '凉燥犯肺，肺失宣降，以恶寒无汗，干咳少痰，苔白少津，脉浮紧等为常见症的证候。\n', null, null, null, null, null, null, null);
INSERT INTO platform_manager_data VALUES ('163', '210', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '脾失健运，营气亏虚，以食少腹胀，大便稀溏，形体消瘦，疲倦乏力，舌淡脉弱等为常见症的证候。', null, null, null, null, null, null, null);
INSERT INTO platform_manager_data VALUES ('164', '211', '胃虚寒证；胃阳亏虚证', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '阳气虚衰，胃失温煦，以胃痛绵绵、喜温喜按，食少脘痞，畏冷肢凉，舌淡苔白，脉沉迟无力等为常见症的证候。', null, null, null, null, null, null, null);
INSERT INTO platform_manager_data VALUES ('165', '212', '胃燥津亏证', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '津液耗损，胃失濡润，以胃脘嘈杂、痞闷，饥不欲食，口渴，便结，舌干少津等为常见症的证候。', null, null, null, null, null, null, null);
INSERT INTO platform_manager_data VALUES ('166', '213', '精亏证；精气不足证', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '精气亏少，以形体瘦削，头晕脑鸣，身材矮小，动作迟纯，智力低下，或精少精稀、阳痿早泄等为常见症的证候。', null, null, null, null, null, null, null);
INSERT INTO platform_manager_data VALUES ('177', '39', '备注', '正常煎服1', '膏', ' 阴虚证,凉燥袭肺证', null, null, null, null, '数脉,咽喉红', '神经病型先天性碘缺乏综合征', '鹅掌风,恶虫叮咬伤, 秃疮', '唐', null, null, null, null, null, null, '史记', '华佗', '清热泻火类,清热燥湿类,清热解毒类', null, null, '外感风寒表证,外寒内饮证', '外敷', null);
INSERT INTO platform_manager_data VALUES ('174', '108', '味苦', 'huangqi', '未知', '未知', '黄芪', '不超过1斤', '根', '寒', '甘', '大肠,小肠,胃', '百日咳', null, '外寒内饮证', '', '', null, '味苦', '', null, null, 'HQ', null, 'huangqi', '马科', '斑蝥属', null);

-- ----------------------------
-- Table structure for `prescription`
-- ----------------------------
DROP TABLE IF EXISTS `prescription`;
CREATE TABLE `prescription` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `menu_id` bigint(20) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `yf` varchar(255) DEFAULT NULL,
  `yl` varchar(255) DEFAULT NULL,
  `zy` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=44 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of prescription
-- ----------------------------
INSERT INTO prescription VALUES ('16', '145', '人参', '后下', '22', '君');
INSERT INTO prescription VALUES ('43', '39', '知母', '臣', '20', '君');
INSERT INTO prescription VALUES ('42', '39', '西洋参', '捣碎', '12', '其它');
INSERT INTO prescription VALUES ('41', '39', '人参', '烊化', '18', '臣');

-- ----------------------------
-- Table structure for `t_user`
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `account` varchar(255) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `icon` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `role_id` bigint(20) DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  `user_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO t_user VALUES ('3', 'admin', '2018-08-06 16:26:13', null, 'e0ubNdGWceeWiIcjL6Fzk3Cd8/nq/7OWciq7eX4UYyB8iYBIJY8afCy0tfayCynM', '0', '2018-08-06 16:26:13', 'admin');
INSERT INTO t_user VALUES ('5', 'xiaolong', '2018-08-08 16:37:08', null, 'p5hYqt1R/lBeWWNepvCdakEUgvGZjA7rK06B97+m9Cou9YpKYkTBxFgbs4cWKA0s', '0', '2018-11-07 09:58:55', 'xiaolong');
INSERT INTO t_user VALUES ('6', 'xiaohong', '2018-08-08 16:37:24', null, 'rz4cwSvRjJu+vgkBbsWnC5SsOeKN8CJV1y2SC6N7wafxjEYpOB9tZWYQuRopqauH', '1', '2018-11-07 14:54:58', 'xiaohong');
INSERT INTO t_user VALUES ('7', 'xiaolan', '2018-08-08 16:37:38', null, 'BVNcHkXRAjoKVjAC98mNj/y4ucBFAsG7/yja3bAx2QeF8yhdzRbR4Pw99h1//8ln', '2', '2018-08-08 16:37:38', 'xiaolan');
INSERT INTO t_user VALUES ('9', 'cxd', '2018-08-14 10:40:23', null, 'KR6BDVNUQi94sS7URsMpi2/tI80jnkyhg16Uu5qRG4sI7ig/RyOYg66KxsTEQjC0', '1', '2018-08-14 17:13:06', 'cxd');
INSERT INTO t_user VALUES ('10', 'longlong', '2018-11-07 14:54:29', null, 'zeE2PxgfRmO+Oyz84g7PSdGCzDB7B+xQXqdrQAXN8ZJ93dK3QU8jF8DiQHMhTMul', '2', '2018-11-07 14:55:00', 'longlong');

-- ----------------------------
-- Table structure for `visit_record`
-- ----------------------------
DROP TABLE IF EXISTS `visit_record`;
CREATE TABLE `visit_record` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `create_date` datetime DEFAULT NULL,
  `status` int(1) DEFAULT '0' COMMENT '默认不是医案',
  `visit_times` int(11) DEFAULT NULL,
  `diagnosis_treatment_id` bigint(20) DEFAULT NULL,
  `diagnosis_we_id` bigint(20) DEFAULT NULL,
  `diagnosis_zh_id` bigint(20) DEFAULT NULL,
  `other_id` bigint(20) DEFAULT NULL,
  `p_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKdpuiwslg8y656qibjt3ru1kd8` (`diagnosis_treatment_id`),
  KEY `FK51tqki2db8tsamn1qpnykfp7j` (`diagnosis_we_id`),
  KEY `FKh1qil9w41f8ljyvha8hayulgp` (`diagnosis_zh_id`),
  KEY `FKi420xf969avjskiybf5xiyhxt` (`other_id`),
  KEY `FK4a0qrswx9vfr2gknbcksrsc97` (`p_id`)
) ENGINE=MyISAM AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of visit_record
-- ----------------------------
INSERT INTO visit_record VALUES ('8', '2018-11-07 15:39:12', '1', '1', '58', '65', '55', '55', '1');
INSERT INTO visit_record VALUES ('9', '2018-11-07 15:49:29', '1', '2', '59', '66', '56', '56', '1');
INSERT INTO visit_record VALUES ('10', '2018-11-07 16:37:15', '0', '3', '60', '67', '57', '57', '1');
INSERT INTO visit_record VALUES ('11', '2018-11-07 20:17:27', '1', '1', '61', '68', '58', '58', '2');

-- ----------------------------
-- Table structure for `western_medicine`
-- ----------------------------
DROP TABLE IF EXISTS `western_medicine`;
CREATE TABLE `western_medicine` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `text` varchar(255) DEFAULT NULL,
  `d_of_we_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKkyuycv1yc8n97m65wxnaf5uq7` (`d_of_we_id`)
) ENGINE=MyISAM AUTO_INCREMENT=591 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of western_medicine
-- ----------------------------
INSERT INTO western_medicine VALUES ('569', 'xcg', '无', '67');
INSERT INTO western_medicine VALUES ('570', 'xdt', '无', '67');
INSERT INTO western_medicine VALUES ('571', 'ncg', '无', '67');
INSERT INTO western_medicine VALUES ('572', 'ct', '无', '67');
INSERT INTO western_medicine VALUES ('573', 'dbcg', '无', '67');
INSERT INTO western_medicine VALUES ('574', 'mri', '无', '67');
INSERT INTO western_medicine VALUES ('575', 'xsh', '无', '67');
INSERT INTO western_medicine VALUES ('576', 'cs', '无', '67');
INSERT INTO western_medicine VALUES ('577', 'x', '无', '67');
INSERT INTO western_medicine VALUES ('578', 'orther', '无', '67');
INSERT INTO western_medicine VALUES ('579', null, '', null);
INSERT INTO western_medicine VALUES ('580', 'xcg', '无', '68');
INSERT INTO western_medicine VALUES ('581', 'xdt', '无', '68');
INSERT INTO western_medicine VALUES ('582', 'ncg', '无', '68');
INSERT INTO western_medicine VALUES ('583', 'ct', '无', '68');
INSERT INTO western_medicine VALUES ('584', 'dbcg', '无', '68');
INSERT INTO western_medicine VALUES ('585', 'mri', '无', '68');
INSERT INTO western_medicine VALUES ('586', 'xsh', '无', '68');
INSERT INTO western_medicine VALUES ('547', 'xcg', '无', '65');
INSERT INTO western_medicine VALUES ('548', 'xdt', '无', '65');
INSERT INTO western_medicine VALUES ('549', 'ncg', '无', '65');
INSERT INTO western_medicine VALUES ('550', 'ct', '无', '65');
INSERT INTO western_medicine VALUES ('551', 'dbcg', '无', '65');
INSERT INTO western_medicine VALUES ('552', 'mri', '无', '65');
INSERT INTO western_medicine VALUES ('553', 'xsh', '无', '65');
INSERT INTO western_medicine VALUES ('554', 'cs', '无', '65');
INSERT INTO western_medicine VALUES ('555', 'x', '无', '65');
INSERT INTO western_medicine VALUES ('556', 'orther', '无', '65');
INSERT INTO western_medicine VALUES ('557', null, '无', null);
INSERT INTO western_medicine VALUES ('558', 'xcg', '无', '66');
INSERT INTO western_medicine VALUES ('559', 'xdt', '无', '66');
INSERT INTO western_medicine VALUES ('560', 'ncg', '无', '66');
INSERT INTO western_medicine VALUES ('561', 'ct', '无', '66');
INSERT INTO western_medicine VALUES ('562', 'dbcg', '无', '66');
INSERT INTO western_medicine VALUES ('563', 'mri', '无', '66');
INSERT INTO western_medicine VALUES ('564', 'xsh', '无', '66');
INSERT INTO western_medicine VALUES ('565', 'cs', '无', '66');
INSERT INTO western_medicine VALUES ('566', 'x', '无', '66');
INSERT INTO western_medicine VALUES ('567', 'orther', '无', '66');
INSERT INTO western_medicine VALUES ('568', null, '无', null);
INSERT INTO western_medicine VALUES ('587', 'cs', '无', '68');
INSERT INTO western_medicine VALUES ('588', 'x', '无', '68');
INSERT INTO western_medicine VALUES ('589', 'orther', '无', '68');
INSERT INTO western_medicine VALUES ('590', null, '无', null);
