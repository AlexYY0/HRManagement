/*
SQLyog Ultimate v12.08 (32 bit)
MySQL - 5.7.25 : Database - HRManagement
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`HRManagement` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;

USE `HRManagement`;

/*Table structure for table `calendar` */
/*0普通工作日1周末双休日2需要补班的工作日3法定节假日*/

DROP TABLE IF EXISTS `calendar`;

CREATE TABLE `calendar` (
  `caleId` int(11) NOT NULL AUTO_INCREMENT,
  `date` date DEFAULT NULL COMMENT '日期',
  `status` tinyint(2) DEFAULT NULL COMMENT '日期状态',
  PRIMARY KEY (`caleId`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `calendar` */

insert into `calendar`(`caleId`,`date`,`status`) values (1,'2019-12-31',0);

/*Table structure for table `employee` */

DROP TABLE IF EXISTS `employee`;

CREATE TABLE `employee` (
  `workId` int(11) NOT NULL,
  `empName` varchar(16) DEFAULT NULL COMMENT '员工姓名',
  `gender` enum('男','女') DEFAULT NULL COMMENT '员工性别',
  `birthday` date DEFAULT NULL COMMENT '出生日期',
  `idCard` char(18) DEFAULT NULL COMMENT '身份证号',
  `marital` enum('已婚','未婚','离异') DEFAULT NULL COMMENT '婚姻状况',
  `nation` varchar(32) DEFAULT NULL COMMENT '民族',
  `nativePlace` varchar(32) DEFAULT NULL COMMENT '籍贯',
  `politic` varchar(32) DEFAULT NULL COMMENT '政治面貌',
  `email` varchar(32) DEFAULT NULL COMMENT '电子邮箱',
  `cellphone` varchar(11) DEFAULT NULL COMMENT '电话号码',
  `address` varchar(64) DEFAULT NULL COMMENT '家庭住址',
  `depId` int(11) DEFAULT NULL COMMENT '所属部门',
  `workState` enum('兼职','实习','在职','离职','退休','其他') DEFAULT NULL COMMENT '任职状态',
  `school` varchar(32) DEFAULT NULL COMMENT '毕业院校',
  `specialty` varchar(32) DEFAULT NULL COMMENT '所属专业',
  `hDegree` enum('博士','硕士','本科','大专','高中','初中','小学','其他') DEFAULT NULL COMMENT '最高学历',
  PRIMARY KEY (`workId`),
  KEY `depId` (`depId`),
  CONSTRAINT `employee_ibfk_1` FOREIGN KEY (`depId`) REFERENCES `department` (`depId`)
) ENGINE=InnoDB AUTO_INCREMENT=52 DEFAULT CHARSET=utf8;

/*Data for the table `employee` */

insert  into `employee`(`workId`,`empName`,`gender`,`birthday`,`idCard`,`marital`,`nation`,`nativePlace`,`politic`,`email`,`cellphone`,`address`,`depId`,`workState`,`school`,`specialty`,`hDegree`) values (1,'李涛','男','1990-01-01','610122199001011256','未婚','汉族','重庆','中共党员','1734766965@qq.com','18565558897','重庆市北碚区',1,'在职','哈佛大学','信息管理与信息系统','博士'),(2,'陈静','女','1989-02-01','421288198902011234','已婚','汉族','海南','中共预备党员','chenjing@qq.com','18795556693','海南省海口市美兰区',4,'在职','武汉大学','市场营销','高中'),(3,'赵琳浩','男','1993-03-04','610122199303041456','未婚','汉族','陕西','共青团员','zhao@qq.com','15698887795','陕西省西安市莲湖区',5,'在职','哈尔滨理工大学','电子工程','博士'),(4,'鹿存亮','男','1990-01-03','610122199001031456','已婚','壮族','陕西','共青团员','zhao@qq.com','15612347795','陕西省西安市莲湖区',8,'在职','哈尔滨理工大学','电子工程','高中'),(5,'姚森','男','1991-02-05','610122199102058952','已婚','维吾尔族','河南','民革党员','yaosen@qq.com','14785559936','河南洛阳人民大道58号',78,'在职','西北大学','室内装修设计','硕士'),(6,'云星','女','1993-01-05','610122199301054789','已婚','回族','陕西西安','民盟盟员','yunxing@qq.com','15644442252','陕西西安新城区',81,'在职','西安电子科技学校','通信工程','硕士'),(7,'贾旭明','男','1993-11-11','610122199311111234','已婚','汉族','广东广州','民建会员','jiaxuming@qq.com','15644441234','广东省广州市天河区冼村路',82,'在职','西北大学','通信工程','初中'),(8,'张黎明','男','1991-02-01','610144199102014569','已婚','满族','广东','民进会员','zhangliming@qq.com','18979994478','广东珠海',85,'离职','清华大学','考古','高中'),(9,'薛磊','男','1992-07-01','610144199207017895','已婚','蒙古族','陕西西安','农工党党员','xuelei@qq.com','15648887741','西安市雁塔区',86,'在职','华胥中学','无','初中'),(10,'张洁','女','1990-10-09','420177199010093652','未婚','汉族','海南','致公党党员','zhangjie@qq.com','13695557742','海口市美兰区',87,'在职','海南侨中','无','高中'),(11,'彭万里','男','1990-01-01','610122199001011256','已婚','汉族','陕西','九三学社社员','laowang@qq.com','18565558897','深圳市南山区',89,'实习','深圳大学','信息管理与信息系统','本科'),(12,'高大山','女','1989-02-01','421288198902011234','已婚','藏族','海南','台盟盟员','chenjing@qq.com','18795556693','海南省海口市美兰区',91,'离职','武汉大学','市场营销','高中'),(13,'谢大海','男','1993-03-04','610122199303041456','未婚','汉族','陕西','无党派民主人士','zhao@qq.com','15698887795','陕西省西安市莲湖区',92,'离职','哈尔滨理工大学','电子工程','博士'),(14,'马宏宇','男','1990-01-03','610122199001031456','已婚','汉族','陕西','普通公民','zhao@qq.com','15612347795','陕西省西安市莲湖区',93,'在职','哈尔滨理工大学','电子工程','高中'),(15,'林莽','男','1991-02-05','610122199102058952','已婚','藏族','河南','普通公民','yaosen@qq.com','14785559936','河南洛阳人民大道58号',94,'实习','西北大学','室内装修设计','初中'),(16,'黄强辉','女','1993-01-05','610122199301054789','已婚','汉族','陕西西安','普通公民','yunxing@qq.com','15644442252','陕西西安新城区',96,'在职','西安电子科技学校','通信工程','硕士'),(17,'章汉夫','男','1993-11-11','610122199311111234','已婚','高山族','广东广州','中共党员','jiaxuming@qq.com','15644441234','广东省广州市天河区冼村路',104,'在职','西北大学','通信工程','初中'),(18,'王一亭','男','1991-02-01','610144199102014569','已婚','傣族','广东','中共预备党员','zhangliming@qq.com','18979994478','广东珠海',91,'在职','清华大学','考古','高中'),(19,'范长江','男','1992-07-01','610144199207017895','已婚','汉族','陕西西安','共青团员','xuelei@qq.com','15648887741','西安市雁塔区',92,'兼职','华胥中学','无','初中'),(20,'林君雄','女','1990-10-09','420177199010093652','未婚','汉族','海南','共青团员','zhangjie@qq.com','13695557742','海口市美兰区',92,'实习','海南侨中','无','高中'),(21,'谭平山','男','1990-01-01','610122199001011256','已婚','汉族','陕西','民盟盟员','laowang@qq.com','18565558897','深圳市南山区',8,'在职','深圳大学','信息管理与信息系统','本科'),(22,'朱希亮','女','1989-02-01','421288198902011234','离异','傣族','海南','共青团员','chenjing@qq.com','18795556693','海南省海口市美兰区',82,'退休','武汉大学','市场营销','高中'),(23,'李四光','男','1990-01-03','610122199001031456','已婚','汉族','陕西','农工党党员','zhao@qq.com','15612347795','陕西省西安市莲湖区',92,'离职','哈尔滨理工大学','电子工程','高中'),(24,'甘铁生','男','1991-02-05','610122199102058952','已婚','彝族','河南','台盟盟员','yaosen@qq.com','14785559936','河南洛阳人民大道58号',92,'在职','西北大学','室内装修设计','初中'),(25,'马继祖','女','1993-01-05','610122199301054789','离异','瑶族','陕西西安','无党派民主人士','yunxing@qq.com','15644442252','陕西西安新城区',92,'在职','西安电子科技学校','通信工程','硕士'),(26,'程孝先','男','1993-11-11','610122199311111234','已婚','朝鲜族','广东广州','中共党员','jiaxuming@qq.com','15644441234','广东省广州市天河区冼村路',78,'在职','西北大学','通信工程','初中'),(27,'宗敬先','男','1991-02-01','610144199102014569','已婚','侗族','广东','中共预备党员','zhangliming@qq.com','18979994478','广东珠海',91,'在职','清华大学','考古','高中'),(28,'年广嗣','男','1992-07-01','610144199207017895','已婚','土家族','陕西西安','中共预备党员','xuelei@qq.com','15648887741','西安市雁塔区',92,'退休','华胥中学','无','初中'),(29,'汤绍箕','男','1990-01-01','610122199001011256','已婚','布依族','陕西','共青团员','laowang@qq.com','18565558897','深圳市南山区',8,'兼职','深圳大学','信息管理与信息系统','本科'),(30,'吕显祖','女','1989-02-01','421288198902011234','已婚','哈萨克族','海南','无党派民主人士','chenjing@qq.com','18795556693','海南省海口市美兰区',82,'兼职','武汉大学','市场营销','高中'),(31,'何光宗','男','1993-03-04','610122199303041456','未婚','佤族','陕西','民革党员','zhao@qq.com','15698887795','陕西省西安市莲湖区',91,'在职','哈尔滨理工大学','电子工程','博士'),(32,'孙念','男','1990-01-03','610122199001031456','已婚','东乡族','陕西','中共党员','zhao@qq.com','15612347795','陕西省西安市莲湖区',92,'在职','哈尔滨理工大学','电子工程','高中'),(33,'马建国','男','1991-02-05','610122199102058952','已婚','朝鲜族','河南','无党派民主人士','yaosen@qq.com','14785559936','河南洛阳人民大道58号',92,'退休','西北大学','室内装修设计','初中'),(34,'节振国','女','1993-01-05','610122199301054789','已婚','柯尔克孜族','陕西西安','民盟盟员','yunxing@qq.com','15644442252','陕西西安新城区',92,'退休','西安电子科技学校','通信工程','硕士'),(35,'冯兴国','男','1993-11-11','610122199311111234','已婚','纳西族','广东广州','中共预备党员','jiaxuming@qq.com','15644441234','广东省广州市天河区冼村路',78,'实习','西北大学','通信工程','初中'),(36,'郝爱民','男','1991-02-01','610144199102014569','离异','佤族','广东','共青团员','zhangliming@qq.com','18979994478','广东珠海',91,'兼职','清华大学','考古','高中'),(37,'于学忠','男','1992-07-01','610144199207017895','已婚','达斡尔族','陕西西安','民革党员','xuelei@qq.com','15648887741','西安市雁塔区',92,'在职','华胥中学','无','初中'),(38,'马连良','女','1990-10-09','420177199010093652','未婚','侗族','海南','民盟盟员','zhangjie@qq.com','13695557742','海口市美兰区',92,'实习','海南侨中','无','高中'),(39,'胡宝善','男','1990-01-01','610122199001011256','已婚','仫佬族','陕西','中共预备党员','laowang@qq.com','18565558897','深圳市南山区',8,'兼职','深圳大学','信息管理与信息系统','本科'),(40,'李宗仁','女','1989-02-01','421288198902011234','已婚','羌族','海南','民革党员','chenjing@qq.com','18795556693','海南省海口市美兰区',82,'实习','武汉大学','市场营销','高中'),(41,'洪学智','男','1993-03-04','610122199303041456','未婚','侗族','陕西','共青团员','zhao@qq.com','15698887795','陕西省西安市莲湖区',91,'在职','哈尔滨理工大学','电子工程','博士'),(42,'余克勤','男','1990-01-03','610122199001031456','已婚','布朗族','陕西','中共党员','zhao@qq.com','15612347795','陕西省西安市莲湖区',92,'在职','哈尔滨理工大学','电子工程','高中'),(43,'杨惟义','男','1991-02-05','610122199102058952','离异','毛难族','河南','民盟盟员','yaosen@qq.com','14785559936','河南洛阳人民大道58号',92,'实习','西北大学','室内装修设计','初中'),(44,'李文信','女','1993-01-05','610122199301054789','已婚','哈萨克族','陕西西安','农工党党员','yunxing@qq.com','15644442252','陕西西安新城区',92,'在职','西安电子科技学校','通信工程','硕士'),(45,'王德茂','男','1993-11-11','610122199311111234','已婚','锡伯族','广东广州','中共预备党员','jiaxuming@qq.com','15644441234','广东省广州市天河区冼村路',78,'退休','西北大学','通信工程','初中'),(46,'李书诚','男','1991-02-01','610144199102014569','已婚','东乡族','广东','中共党员','zhangliming@qq.com','18979994478','广东珠海',91,'退休','清华大学','考古','高中'),(47,'高尚德','男','1992-07-01','610144199207017895','已婚','塔吉克族','陕西西安','民盟盟员','xuelei@qq.com','15648887741','西安市雁塔区',92,'实习','华胥中学','无','初中'),(48,'汤念祖','女','1990-10-09','420177199010093652','未婚','侗族','海南','共青团员','zhangjie@qq.com','13695557742','海口市美兰区',92,'退休','海南侨中','无','高中'),(49,'何光宗','男','1990-01-01','610122199001011256','离异','乌孜别克族','陕西','中共党员','laowang@qq.com','18565558897','深圳市南山区',8,'退休','深圳大学','信息管理与信息系统','本科'),(50,'钱运高','女','1989-02-01','421288198902011234','已婚','纳西族','海南','农工党党员','chenjing@qq.com','18795556693','海南省海口市美兰区',82,'退休','武汉大学','市场营销','高中'),(51,'王仁兴','男','2019-11-24','610144199905056666','已婚','鄂温克族','广东','中共预备党员','584991843@qq.com','18566667777','广东深圳',89,'退休','深圳大学','计算机科学','本科');

/*Table structure for table `department` */

DROP TABLE IF EXISTS `department`;

CREATE TABLE `department` (
  `depId` int(11) NOT NULL AUTO_INCREMENT,
  `depName` varchar(32) DEFAULT NULL COMMENT '部门名称',
  `parentId` int(11) DEFAULT NULL,
  `depPath` varchar(255) DEFAULT NULL,
  `enabled` tinyint(1) DEFAULT '1',
  `isParent` tinyint(1) DEFAULT '0',
  `leaderId` int(11) DEFAULT NULL,
  PRIMARY KEY (`depId`),
  KEY `dLeaderId` (`leaderId`),
  CONSTRAINT `department_ibfk_1` FOREIGN KEY (`leaderId`) REFERENCES `employee` (`workId`)
) ENGINE=InnoDB AUTO_INCREMENT=105 DEFAULT CHARSET=utf8;

/*Data for the table `department` */

insert  into `department`(`depId`,`depName`,`parentId`,`depPath`,`enabled`,`isParent`,`leaderId`) values (1,'股东会',-1,'.1',1,1,1),(4,'董事会',1,'.1.4',1,1,2),(5,'总经理',4,'.1.4.5',1,1,3),(8,'财务部',5,'.1.4.5.8',1,0,4),(78,'市场部',5,'.1.4.5.78',1,1,5),(81,'华北市场部',78,'.1.4.5.78.81',1,1,12),(82,'华南市场部',78,'.1.4.5.78.82',1,0,13),(85,'石家庄市场部',81,'.1.4.5.78.81.85',1,0,15),(86,'西北市场部',78,'.1.4.5.78.86',1,1,14),(87,'西安市场',86,'.1.4.5.78.86.87',1,1,16),(89,'长安区市场',87,'.1.4.5.78.86.87.89',1,0,17),(91,'研发部',5,'.1.4.5.91',1,0,6),(92,'运维部',5,'.1.4.5.92',1,1,7),(93,'销售部',92,'.1.4.5.92.93',1,0,8),(94,'办公室',92,'.1.4.5.92.94',1,0,9),(96,'北京分部',1,'.1.96',1,1,10),(104,'领导班子',96,'.1.96.104',1,0,11);


/*Table structure for table `employeeChange` */

DROP TABLE IF EXISTS `employeeChange`;

CREATE TABLE `employeeChange` (
  `empcId` int(11) NOT NULL AUTO_INCREMENT,
  `workId` int(11) DEFAULT NULL COMMENT '员工工号',
  `afterDepId` int(11) DEFAULT NULL COMMENT '调动后部门',
  `empChanDate` date DEFAULT NULL COMMENT '调动日期',
  `empChanRemark` varchar(255) DEFAULT NULL COMMENT '调动备注',
  PRIMARY KEY (`empcId`),
  KEY `workId` (`workId`),
  CONSTRAINT `employeeChange_ibfk_1` FOREIGN KEY (`workId`) REFERENCES `employee` (`workId`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Data for the table `employeeChange` */

insert into `employeeChange`(`empcId`,`workId`,`afterDepId`,`empChanDate`,`empChanRemark`) values (1,45,8,'2019-10-07','该员工更适合此部门！'),(2,46,96,'2020-01-02','该员工能力出众，去领导北京分部事务。'),(3,47,81,'2019-05-20','该员工工作懈怠，降职处理。');

/*Table structure for table `contractInfo` */

DROP TABLE IF EXISTS `contractInfo`;

CREATE TABLE `contractInfo` (
  `contId` int(11) NOT NULL AUTO_INCREMENT,
  `workId` int(11) DEFAULT NULL COMMENT '员工工号',
  `beginContract` date DEFAULT NULL COMMENT '合同开始时间',
  `endContract` date DEFAULT NULL COMMENT '合同结束时间',
  `content` varchar(4095) DEFAULT NULL COMMENT '合同内容',
  `signDate` date DEFAULT NULL COMMENT '签合同时间',
  PRIMARY KEY (`contId`),
  KEY `workId` (`workId`),
  CONSTRAINT `contractInfo_ibfk_1` FOREIGN KEY (`workId`) REFERENCES `employee` (`workId`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `contractInfo` */

insert into `contractInfo`(`contId`,`workId`,`beginContract`,`endContract`,`content`,`signDate`) values (1,1,'2002-04-06','2022-04-05','https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1517070040185&di=be0375e0c3db6c311b837b28c208f318&imgtype=0&src=http%3A%2F%2Fimg2.soyoung.com%2Fpost%2F20150213%2F6%2F20150213141918532.jpg','2002-04-05'),(2,2,'2002-04-25','2022-04-24','http://b-ssl.duitang.com/uploads/item/201901/17/20190117230425_eofqv.thumb.700_0.jpg;http://img5.imgtn.bdimg.com/it/u=151799558,1417326231&fm=26&gp=0.jpg','2002-01-23');

/*Table structure for table `taxRate` */

DROP TABLE IF EXISTS `taxRate`;

CREATE TABLE `taxRate` (
  `trId` int(11) NOT NULL AUTO_INCREMENT,
  `trMin` double DEFAULT NULL COMMENT '税收最小值',
  `trMax` double DEFAULT NULL COMMENT '税收最大值',
  `trPercent` double DEFAULT NULL COMMENT '税率百分比',
  `quiDeduction` double DEFAULT NULL COMMENT '速算扣除数',
  PRIMARY KEY (`trId`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

/*Data for the table `taxRate` */

insert into `taxRate`(`trId`,`trMin`,`trMax`,`trPercent`,`quiDeduction`) values (1,0,3000,3,0),(2,3000,12000,10,210),(3,12000,25000,20,1410),(4,25000,35000,25,2660),(5,35000,55000,30,4410),(6,55000,80000,35,7160),(7,80000,NULL,45,15160);

/*Table structure for table `treatment` */

DROP TABLE IF EXISTS `treatment`;

CREATE TABLE `treatment` (
  `tretId` int(11) NOT NULL AUTO_INCREMENT,
  `tretName` varchar(16) DEFAULT NULL COMMENT '待遇名称',
  `tretPercent` double DEFAULT NULL COMMENT '个人缴纳比例',
  PRIMARY KEY (`tretId`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

/*Data for the table `treatment` */

insert into `treatment`(`tretId`,`tretName`,`tretPercent`) values (1,'养老保险',8),(2,'医疗保险',2),(3,'失业保险',1),(4,'工伤保险',0),(5,'生育保险',0),(6,'补充医疗保险',4),(7,'住房公积金',10),(8,'企业年金',4);

/*Table structure for table `welfare` */

DROP TABLE IF EXISTS `welfare`;

CREATE TABLE `welfare` (
  `welId` int(11) NOT NULL AUTO_INCREMENT,
  `welName` varchar(16) DEFAULT NULL COMMENT '福利名称',
  `traffic` double DEFAULT NULL COMMENT '交通补贴',
  `catering` double DEFAULT NULL COMMENT '餐饮补贴',
  `communication` double DEFAULT NULL COMMENT '通信补贴',
  `bonus` double DEFAULT NULL COMMENT '奖金',
  `other` double DEFAULT NULL COMMENT '其它',
  PRIMARY KEY (`welId`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Data for the table `welfare` */

insert into `welfare`(`welId`,`welName`,`traffic`,`catering`,`communication`,`bonus`,`other`) values (1,'研发部补贴',100,300,20,0,0),(2,'运维部补贴',500,250,10,0,0),(3,'财务部补贴',200,400,0,200,0);

/*Table structure for table `specialAdditionalDeduction` */

DROP TABLE IF EXISTS `specialAdditionalDeduction`;

CREATE TABLE `specialAdditionalDeduction` (
  `sadId` int(11) NOT NULL AUTO_INCREMENT,
  `sadName` varchar(16) DEFAULT NULL COMMENT '专扣名称',
  `sadMoney` double DEFAULT NULL COMMENT '专扣金额',
  PRIMARY KEY (`sadId`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

/*Data for the table `specialAdditionalDeduction` */

insert into `specialAdditionalDeduction`(`sadId`,`sadName`,`sadMoney`) values (1,'无',0),(2,'子女教育',1000),(3,'继续教育之学历(学位)继续教育',400),(4,'继续教育之职业资格继续教育',300),(5,'住房贷款利息',1000),(6,'住房租金之一线城市',1500),(7,'住房租金之二线城市',1100),(8,'住房租金之三线城市',800),(9,'赡养老人之独生子女',2000),(10,'赡养老人之非独生子女自定义1',1),(11,'大病医疗之最高',80000),(12,'大病医疗之自定义',1);

/*Table structure for table `employeeSalary` */

DROP TABLE IF EXISTS `employeeSalary`;

CREATE TABLE `employeeSalary` (
  `esId` int(11) NOT NULL AUTO_INCREMENT,
  `workId` int(11) DEFAULT NULL COMMENT '员工工号',
  `basicSalary` double DEFAULT NULL COMMENT '基础薪资',
  `endowment` tinyint(1) DEFAULT '0' COMMENT '养老保险',
  `medical` tinyint(1) DEFAULT '0' COMMENT '医疗保险',
  `unemployment` tinyint(1) DEFAULT '0' COMMENT '失业保险',
  `injury` tinyint(1) DEFAULT '0' COMMENT '工伤保险',
  `maternity` tinyint(1) DEFAULT '0' COMMENT '生育保险',
  `addMedical` tinyint(1) DEFAULT '0' COMMENT '补充医疗保险',
  `housing` tinyint(1) DEFAULT '0' COMMENT '住房公积金',
  `enterpriseP` tinyint(1) DEFAULT '0' COMMENT '企业年金',
  `welId` int(11) DEFAULT NULL COMMENT '福利补贴编号',
  `childEdu` int(11) DEFAULT NULL COMMENT '子女教育',
  `conEdu` int(11) DEFAULT NULL COMMENT '继续教育',
  `serMedical` int(11) DEFAULT NULL COMMENT '大病医疗',
  `housingLoan` int(11) DEFAULT NULL COMMENT '住房贷款利息',
  `rental` int(11) DEFAULT NULL COMMENT '住房租金',
  `supportOld` int(11) DEFAULT NULL COMMENT '赡养老人',
  PRIMARY KEY (`esId`),
  KEY `workId` (`workId`),
  KEY `welId` (`welId`),
  KEY `childEduId` (`childEdu`),
  KEY `conEduId` (`conEdu`),
  KEY `serMedicalId` (`serMedical`),
  KEY `housingLoanId` (`housingLoan`),
  KEY `rentalId` (`rental`),
  KEY `supportOldId` (`supportOld`),
  CONSTRAINT `employeeSalary_ibfk_1` FOREIGN KEY (`welId`) REFERENCES `welfare` (`welId`),
  CONSTRAINT `employeeSalary_ibfk_2` FOREIGN KEY (`childEdu`) REFERENCES `specialAdditionalDeduction` (`sadId`),
  CONSTRAINT `employeeSalary_ibfk_3` FOREIGN KEY (`conEdu`) REFERENCES `specialAdditionalDeduction` (`sadId`),
  CONSTRAINT `employeeSalary_ibfk_4` FOREIGN KEY (`serMedical`) REFERENCES `specialAdditionalDeduction` (`sadId`),
  CONSTRAINT `employeeSalary_ibfk_5` FOREIGN KEY (`housingLoan`) REFERENCES `specialAdditionalDeduction` (`sadId`),
  CONSTRAINT `employeeSalary_ibfk_6` FOREIGN KEY (`rental`) REFERENCES `specialAdditionalDeduction` (`sadId`),
  CONSTRAINT `employeeSalary_ibfk_7` FOREIGN KEY (`supportOld`) REFERENCES `specialAdditionalDeduction` (`sadId`),
  CONSTRAINT `employeeSalary_ibfk_8` FOREIGN KEY (`workId`) REFERENCES `employee` (`workId`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `employeeSalary` */

insert into `employeeSalary`(`esId`,`workId`,`basicSalary`,`endowment`,`medical`,`unemployment`,`injury`,`maternity`,`addMedical`,`housing`,`enterpriseP`,`welId`,`childEdu`,`conEdu`,`serMedical`,`housingLoan`,`rental`,`supportOld`) values (1,1,6000,1,1,1,1,1,1,1,1,1,2,3,11,5,6,9);

/*Table structure for table `salaryScheme` */

DROP TABLE IF EXISTS `salaryScheme`;

CREATE TABLE `salaryScheme` (
  `ssId` int(11) NOT NULL AUTO_INCREMENT,
  `ssName` varchar(16) DEFAULT NULL COMMENT '计算方法名',
  `compMethod` varchar(255) DEFAULT NULL COMMENT '计算公式',
  PRIMARY KEY (`ssId`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Data for the table `salaryScheme` */

insert into `salaryScheme`(`ssId`,`ssName`,`compMethod`) values (1,'月薪计算','税后工资=税前基础工资-[（税前基础工资+福利补贴-六险二金-起征点(5000)-专项附加扣除）X税率-速算扣除数]-六险二金'),(2,'12+1','税后年终奖=税前基础月薪-[（税前基础月薪-起征点(5000)）X税率-速算扣除数]'),(3,'12+2','税后年终奖=税前基础月薪X2-[（税前基础月薪X2-起征点(5000)）X税率-速算扣除数]');

/*Table structure for table `salaryAdjustment` */

DROP TABLE IF EXISTS `salaryAdjustment`;

CREATE TABLE `salaryAdjustment` (
  `saId` int(11) NOT NULL AUTO_INCREMENT,
  `workId` int(11) DEFAULT NULL COMMENT '员工工号',
  `saDate` timestamp DEFAULT CURRENT_TIMESTAMP COMMENT '调薪日期',
  `saRemark` varchar(255) DEFAULT NULL COMMENT '调薪备注',
  PRIMARY KEY (`saId`),
  KEY `workId` (`workId`),
  CONSTRAINT `salaryAdjustment_ibfk_1` FOREIGN KEY (`workId`) REFERENCES `employee` (`workId`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `salaryAdjustment` */

insert into `salaryAdjustment`(`saId`,`workId`,`saDate`,`saRemark`) values (1,1,'2020-01-02 9:30:30','公司上市');

/*Table structure for table `salaryInfo` */

DROP TABLE IF EXISTS `salaryInfo`;

CREATE TABLE `salaryInfo` (
  `siId` int(11) NOT NULL AUTO_INCREMENT,
  `workId` int(11) DEFAULT NULL COMMENT '员工工号',
  `basicSalary` double DEFAULT NULL COMMENT '基础薪资',
  `absenteeism` double DEFAULT NULL COMMENT '缺勤扣除工资',
  `overtime` double DEFAULT NULL COMMENT '加班工资',
  `busiTrip` double DEFAULT NULL COMMENT '出差补助',
  `endowment` double DEFAULT '0' COMMENT '养老保险',
  `medical` double DEFAULT '0' COMMENT '医疗保险',
  `unemployment` double DEFAULT '0' COMMENT '失业保险',
  `injury` double DEFAULT '0' COMMENT '工伤保险',
  `maternity` double DEFAULT '0' COMMENT '生育保险',
  `addMedical` double DEFAULT '0' COMMENT '补充医疗保险',
  `housing` double DEFAULT '0' COMMENT '住房公积金',
  `enterpriseP` double DEFAULT '0' COMMENT '企业年金',
  `childEdu` double DEFAULT NULL COMMENT '子女教育',
  `conEdu` double DEFAULT NULL COMMENT '继续教育',
  `serMedical` double DEFAULT NULL COMMENT '大病医疗',
  `housingLoan` double DEFAULT NULL COMMENT '住房贷款利息',
  `rental` double DEFAULT NULL COMMENT '住房租金',
  `supportOld` double DEFAULT NULL COMMENT '赡养老人',
  `traffic` double DEFAULT NULL COMMENT '交通补贴',
  `catering` double DEFAULT NULL COMMENT '餐饮补贴',
  `communication` double DEFAULT NULL COMMENT '通信补贴',
  `other` double DEFAULT NULL COMMENT '其它补贴',
  `bonus` double DEFAULT NULL COMMENT '奖金',
  `sums` double DEFAULT NULL COMMENT '合计',
  `salFirstDay` date DEFAULT NULL COMMENT '发月薪第一天',
  `salEndDay` date DEFAULT NULL COMMENT '发月薪最后一天',
  `payoffDate` timestamp DEFAULT CURRENT_TIMESTAMP COMMENT '计算薪资时间',
  PRIMARY KEY (`siId`),
  KEY `workId` (`workId`),
  CONSTRAINT `salaryInfo_ibfk_1` FOREIGN KEY (`workId`) REFERENCES `employee` (`workId`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `salaryInfo` */

insert into `salaryInfo`(`siId`,`workId`,`basicSalary`,`absenteeism`,`overtime`,`busiTrip`,`endowment`,`medical`,`unemployment`,`injury`,`maternity`,`addMedical`,`housing`,`enterpriseP`,`childEdu`,`conEdu`,`serMedical`,`housingLoan`,`rental`,`supportOld`,`traffic`,`catering`,`communication`,`other`,`bonus`,`sums`,`salFirstDay`,`salEndDay`,`payoffDate`) values (1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,'2019-12-01','2019-12-31',NULL);

/*Table structure for table `businessHours` */

DROP TABLE IF EXISTS `businessHours`;

CREATE TABLE `businessHours` (
  `busiHoursId` int(11) NOT NULL AUTO_INCREMENT,
  `busiHoursName` varchar(16) DEFAULT NULL COMMENT '班次名称',
  `beginTime` time DEFAULT NULL COMMENT '上班时间',
  `endTime` time DEFAULT NULL COMMENT '下班时间',
  `beginRest` time DEFAULT NULL COMMENT '开始休息',
  `endRest` time DEFAULT NULL COMMENT '结束休息',
  PRIMARY KEY (`busiHoursId`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `businessHours` */

insert into `businessHours`(`busiHoursId`,`busiHoursName`,`beginTime`,`endTime`,`beginRest`,`endRest`) values (1,'休息','00:00:00','00:00:00','00:00:00','00:00:00'),(2,'正班','9:00:00','18:00:00','12:00:00','13:00:00');

/*Table structure for table `workingSchedule` */

DROP TABLE IF EXISTS `workingSchedule`;

CREATE TABLE `workingSchedule` (
  `wsId` int(11) NOT NULL AUTO_INCREMENT,
  `workId` int(11) DEFAULT NULL COMMENT '员工工号',
  `today` date DEFAULT NULL COMMENT '今天日期',
  `todaySche` int(11) DEFAULT NULL COMMENT '今天班次',
  PRIMARY KEY (`wsId`),
  KEY `todaySche` (`todaySche`),
  CONSTRAINT `workingSchedule_ibfk_1` FOREIGN KEY (`todaySche`) REFERENCES `businessHours` (`busiHoursId`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8;

/*Data for the table `workingSchedule` */

insert into `workingSchedule`(`wsId`,`workId`,`today`,`todaySche`) values (1,1,'2020-01-01',1),(2,1,'2020-01-02',2),(3,1,'2020-01-03',2),(4,1,'2020-01-04',2),(5,1,'2020-01-05',2),(6,1,'2020-01-06',2),(7,1,'2020-01-07',2),(8,1,'2020-01-08',2),(9,1,'2020-01-09',2),(10,1,'2020-01-10',2),(11,1,'2020-01-11',2),(12,1,'2020-01-12',2),(13,1,'2020-01-13',2),(14,1,'2020-01-14',2),(15,1,'2020-01-15',2),(16,1,'2020-01-16',2),(17,1,'2020-01-17',2),(18,1,'2020-01-18',2),(19,1,'2020-01-19',2),(20,1,'2020-01-20',2),(21,1,'2020-01-21',2),(22,1,'2020-01-22',2),(23,1,'2020-01-23',2),(24,1,'2020-01-24',2),(25,1,'2020-01-25',2),(26,1,'2020-01-26',2),(27,1,'2020-01-27',2),(28,1,'2020-01-28',2),(29,1,'2020-01-29',2),(30,1,'2020-01-30',2),(31,1,'2020-01-31',2);

/*Table structure for table `applyAttendanceTransaction` */

DROP TABLE IF EXISTS `applyAttendanceTransaction`;

CREATE TABLE `applyAttendanceTransaction` (
  `aatId` int(11) NOT NULL AUTO_INCREMENT,
  `workId` int(11) DEFAULT NULL COMMENT '员工工号',
  `category` enum('请假','调休','出差','加班') DEFAULT NULL COMMENT '事务类别',
  `reason` varchar(255) DEFAULT NULL COMMENT '申请原因',
  `appBeginDate` datetime DEFAULT NULL COMMENT '事务开始时间',
  `appEndDate` datetime DEFAULT NULL COMMENT '事务结束时间',
  `total` double DEFAULT NULL COMMENT '总共事务时间/小时',
  `appDate` timestamp DEFAULT CURRENT_TIMESTAMP COMMENT '申请时间',
  `isSubmit` tinyint(1) DEFAULT 0 COMMENT '是否提交',
  `isApprove` tinyint(1) DEFAULT NULL COMMENT '领导意见',
  PRIMARY KEY (`aatId`),
  KEY `workId` (`workId`),
  CONSTRAINT `applyAttendanceTransaction_ibfk_1` FOREIGN KEY (`workId`) REFERENCES `employee` (`workId`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `applyAttendanceTransaction` */

insert into `applyAttendanceTransaction`(`aatId`,`workId`,`category`,`reason`,`appBeginDate`,`appEndDate`,`total`,`appDate`,`isSubmit`,`isApprove`) values (1,1,'出差','签合同！','2020-01-03 09:00:00','2020-01-04 18:00:00',8,NULL,0,NULL);

/*Table structure for table `attendanceStatus` */

DROP TABLE IF EXISTS `attendanceStatus`;

CREATE TABLE `attendanceStatus` (
  `atteStaId` int(11) NOT NULL AUTO_INCREMENT,
  `atteStaName` varchar(16) DEFAULT NULL COMMENT '状态名称',
  PRIMARY KEY (`atteStaId`)
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8;

/*Data for the table `attendanceStatus` */

insert into `attendanceStatus`(`atteStaId`,`atteStaName`) values (00,'未签到/未签退'),(01,'未签到/早退'),(02,'未签到/正常签退'),(10,'迟到/未签退'),(11,'迟到/早退'),(12,'迟到/正常签退'),(20,'正常签到/未签退'),(21,'正常签到/早退'),(22,'正常签到/正常签退');

/*Table structure for table `attendanceLogOfDay` */

DROP TABLE IF EXISTS `attendanceLogOfDay`;

CREATE TABLE `attendanceLogOfDay` (
  `atteLogDayId` int(11) NOT NULL AUTO_INCREMENT,
  `workId` int(11) DEFAULT NULL COMMENT '员工工号',
  `clockInDay` date DEFAULT NULL COMMENT '打卡日期',
  `signInTime` time DEFAULT 0 COMMENT '签到时间',
  `signOutTime` time DEFAULT 0 COMMENT '签退时间',
  `clockInFlag` int(11) DEFAULT 0 COMMENT '考勤状态',
  `needHours` double DEFAULT NULL COMMENT '需要工作时间',
  `workingHours` double DEFAULT 0 COMMENT '实际工作时间',
  PRIMARY KEY (`atteLogDayId`),
  KEY `workId` (`workId`),
  KEY `clockInFlag` (`clockInFlag`),
  CONSTRAINT `attendanceLogOfDay_ibfk_1` FOREIGN KEY (`workId`) REFERENCES `employee` (`workId`),
  CONSTRAINT `attendanceLogOfDay_ibfk_2` FOREIGN KEY (`clockInFlag`) REFERENCES `attendanceStatus` (`atteStaId`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `attendanceLogOfDay` */

insert into `attendanceLogOfDay`(`atteLogDayId`,`workId`,`clockInDay`,`signInTime`,`signOutTime`,`clockInFlag`,`needHours`,`workingHours`) values (1,1,'2020-01-15','08:35:00','18:15.46',1,8,8),(2,1,'2020-01-16','08:35:00','18:15.46',1,8,8),(3,1,'2020-01-17','09:40:00','18:15.46',2,8,7.4),(4,1,'2020-01-18','08:35:00','15:15.46',2,8,7.4),(5,1,'2020-01-19',NULL,NULL,3,8,0);

/*Table structure for table `attendanceLogOfMonth` */

DROP TABLE IF EXISTS `attendanceLogOfMonth`;

CREATE TABLE `attendanceLogOfMonth` (
  `atteLogMonId` int(11) NOT NULL AUTO_INCREMENT,
  `workId` int(11) DEFAULT NULL COMMENT '员工工号',
  `totalH` double DEFAULT 0 COMMENT '总工时',
  `normalH` double DEFAULT 0 COMMENT '正常工时',
  `absentH` double DEFAULT 0 COMMENT '缺勤工时',
  `leaveH` double DEFAULT 0 COMMENT '请假工时',
  `vacateH` double DEFAULT 0 COMMENT '调休工时',
  `businessH` double DEFAULT 0 COMMENT '出差工时',
  `overtimeH` double DEFAULT 0 COMMENT '加班工时',
  `firstDay` date DEFAULT NULL COMMENT '被统计月第一天',
  `endDay` date DEFAULT NULL COMMENT '被统计月最后一天',
  `calDate` timestamp DEFAULT CURRENT_TIMESTAMP COMMENT '统计时间',
  PRIMARY KEY (`atteLogMonId`),
  KEY `workId` (`workId`),
  CONSTRAINT `attendanceLogOfMonth_ibfk_1` FOREIGN KEY (`workId`) REFERENCES `employee` (`workId`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `attendanceLogOfMonth` */

insert into `attendanceLogOfMonth`(`atteLogMonId`,`workId`,`totalH`,`normalH`,`absentH`,`leaveH`,`vacateH`,`businessH`,`overtimeH`,`firstDay`,`endDay`) values (1,1,240,240,0,0,0,0,0,'2019-12-01','2019-12-31');

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `userId` int(11) NOT NULL AUTO_INCREMENT,
  `workId` int(11) DEFAULT NULL COMMENT '员工工号',
  `openId` varchar(32) DEFAULT NULL COMMENT '微信OpenID',
  `username` varchar(255) DEFAULT NULL COMMENT '用户名',
  `password` varchar(255) DEFAULT NULL COMMENT '密码',
  `userface` varchar(255) DEFAULT NULL COMMENT '用户头像',
  `enabled` tinyint(1) DEFAULT 0 COMMENT '用户可用',
  `userRemark` varchar(255) DEFAULT NULL COMMENT '用户备注',
  PRIMARY KEY (`userId`),
  KEY `workId` (`workId`),
  UNIQUE KEY `username` (`username`),
  CONSTRAINT `user_ibfk_1` FOREIGN KEY (`workId`) REFERENCES `employee` (`workId`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `user` */

insert into `user`(`userId`,`workId`,`openId`,`username`,`password`,`userface`,`enabled`,`userRemark`) values (1,1,null,'ceo','$2a$10$ySG2lkvjFHY5O0./CPIE1OI8VJsuKYEzOYzqIa7AJR6sEgSzUFOAm','http://bpic.588ku.com/element_pic/01/40/00/64573ce2edc0728.jpg',1,'董事长'),(2,2,null,'admin','$2a$10$ySG2lkvjFHY5O0./CPIE1OI8VJsuKYEzOYzqIa7AJR6sEgSzUFOAm','http://bpic.588ku.com/element_pic/01/40/00/64573ce2edc0728.jpg',1,'系统管理员');

/*Table structure for table `role` */

DROP TABLE IF EXISTS `role`;

CREATE TABLE `role` (
  `roleId` int(11) NOT NULL AUTO_INCREMENT,
  `enName` varchar(16) DEFAULT NULL COMMENT '角色英文名',
  `zhName` varchar(16) DEFAULT NULL COMMENT '角色中文名',
  PRIMARY KEY (`roleId`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `role` */

insert into `role`(`roleId`,`enName`,`zhName`) values (1,'ROLE_admin','系统管理员'),(2,'ROLE_employee','普通员工');

/*Table structure for table `user_Role` */

DROP TABLE IF EXISTS `user_Role`;

CREATE TABLE `user_Role` (
  `uRoleId` int(11) NOT NULL AUTO_INCREMENT,
  `userId` int(11) DEFAULT NULL COMMENT '员工工号',
  `roleId` int(11) DEFAULT NULL COMMENT '角色ID',
  PRIMARY KEY (`uRoleId`),
  KEY `userId` (`userId`),
  KEY `roleId` (`roleId`),
  CONSTRAINT `user_Role_ibfk_1` FOREIGN KEY (`userId`) REFERENCES `user` (`userId`) ON DELETE CASCADE,
  CONSTRAINT `user_Role_ibfk_2` FOREIGN KEY (`roleId`) REFERENCES `role` (`roleId`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `user_Role` */

insert into `user_Role`(`uRoleId`,`userId`,`roleId`) values (1,1,1);

/*Table structure for table `permission` */

DROP TABLE IF EXISTS `permission`;

CREATE TABLE `permission` (
  `pId` int(11) NOT NULL AUTO_INCREMENT,
  `url` varchar(64) DEFAULT NULL,
  `path` varchar(64) DEFAULT NULL,
  `component` varchar(64) DEFAULT NULL,
  `name` varchar(64) DEFAULT NULL,
  `iconCls` varchar(64) DEFAULT NULL,
  `keepAlive` tinyint(1) DEFAULT NULL,
  `requireAuth` tinyint(1) DEFAULT NULL,
  `parentId` int(11) DEFAULT NULL,
  `enabled` tinyint(1) DEFAULT '1',
  PRIMARY KEY (`pId`),
  KEY `parentId` (`parentId`),
  CONSTRAINT `permission_ibfk_1` FOREIGN KEY (`parentId`) REFERENCES `permission` (`pId`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8;

/*Data for the table `permission` */

insert  into `permission`(`pId`,`url`,`path`,`component`,`name`,`iconCls`,`keepAlive`,`requireAuth`,`parentId`,`enabled`) values (1,'/',NULL,NULL,'所有',NULL,NULL,NULL,NULL,1),(2,'/','/home','Home','首页','fas fa-home',NULL,1,1,1),(3,'/','/home','Home','部门管理','fas fa-users',NULL,1,1,1),(4,'/','/home','Home','员工信息管理','fas fa-address-book',NULL,1,1,1),(5,'/','/home','Home','员工薪资管理','fas fa-money-check-alt',NULL,1,1,1),(6,'/','/home','Home','员工考勤管理','fas fa-user-clock',NULL,1,1,1),(7,'/','/home','Home','系统管理','fas fa-sliders-h',NULL,1,1,1),(8,'/work/bench/**','/work/bench','WorkBench','工作台',NULL,NULL,1,2,1),(9,'/organization/management/**','/org/manage','OrgManage','部门组织机构管理',NULL,NULL,1,3,1),(10,'/employee/basic/**','/emp/basic','EmpBasic','员工基本信息管理',NULL,NULL,1,4,1),(11,'/salary/taxrate/**','/sal/tr','SalTr','税率表',NULL,NULL,1,5,1),(12,'/salary/treatment/**','/sal/treatment','SalTreatment','保障性待遇表',NULL,NULL,1,5,1),(13,'/salary/welfare/**','/sal/welfare','SalWelfare','福利表',NULL,NULL,1,5,1),(14,'/salary/specialadditionaldeduction/**','/sal/sad','SalSad','专项附加扣除表',NULL,NULL,1,5,1),(15,'/salary/employee/**','/sal/emp','SalEmp','员工基础薪资管理',NULL,NULL,1,5,1),(16,'/salary/scheme/**','/sal/scheme','SalScheme','薪资计算方案管理',NULL,NULL,1,5,1),(17,'/salary/check/**','/sal/check','SalCheck','薪资核算',NULL,NULL,1,5,1),(19,'/salary/information/**','/sal/info','SalInfo','员工历史薪资信息管理',NULL,NULL,1,5,1),(20,'/attendance/workingschedule/**','/att/ws','AttWs','排班管理',NULL,NULL,1,6,1),(21,'/attendance/transactionapp/**','/att/traapp','AttTraapp','考勤事务申请',NULL,NULL,1,6,1),(22,'/attendance/transactionmanagement/**','/att/tramanagement','AttTramanagement','考勤事务管理',NULL,NULL,1,6,1),(23,'/attendance/transactioninfo/**','/att/transactioninfo','AttTransactioninfo','考勤事务信息管理',NULL,NULL,1,6,1),(24,'/attendance/managementofday/**','/att/manaofday','AttManaOfDay','每日考勤管理',NULL,NULL,1,6,1),(25,'/attendance/managementofmonth/**','/att/manaofmonth','AttManaOfMon','考勤月度统计',NULL,NULL,1,6,1),(26,'/system/rolepermission/**','/sys/rolep','SysRolep','角色权限管理',NULL,NULL,1,7,1),(27,'/system/userrole/**','/sys/userrole','SysUserrole','用户角色管理',NULL,NULL,1,7,1),(28,'/system/log/**','/sys/log','SysLog','系统日志管理',NULL,NULL,1,7,1);

/*Table structure for table `permission_Role` */

DROP TABLE IF EXISTS `permission_Role`;

CREATE TABLE `permission_Role` (
  `pRoleId` int(11) NOT NULL AUTO_INCREMENT,
  `pId` int(11) DEFAULT NULL,
  `roleId` int(11) DEFAULT NULL,
  PRIMARY KEY (`pRoleId`),
  KEY `pId` (`pId`),
  KEY `roleId` (`roleId`),
  CONSTRAINT `permission_Role_ibfk_1` FOREIGN KEY (`pId`) REFERENCES `permission` (`pId`),
  CONSTRAINT `permission_Role_ibfk_2` FOREIGN KEY (`roleId`) REFERENCES `role` (`roleId`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;

/*Data for the table `permission_Role` */

insert into `permission_Role`(`pRoleId`,`pId`,`roleId`) values (1,8,1),(2,9,1),(3,10,1),(4,11,1),(5,12,1),(6,13,1),(7,14,1),(8,15,1),(9,16,1),(10,17,1),(11,18,1),(12,19,1),(13,20,1),(14,21,1),(15,22,1),(16,23,1),(17,24,1),(18,25,1),(19,26,1),(20,27,1),(21,28,1);

/*Table structure for table `systemLog` */

DROP TABLE IF EXISTS `systemLog`;

CREATE TABLE `systemLog` (
  `sysLogId` int(11) NOT NULL AUTO_INCREMENT,
  `workId` int(11) DEFAULT NULL COMMENT '员工工号',
  `broswer` varchar(64) DEFAULT NULL COMMENT '浏览器',
  `version` varchar(64) DEFAULT NULL COMMENT '浏览器版本',
  `ip` varchar(16) DEFAULT NULL COMMENT 'IP地址',
  `logContent` longtext DEFAULT NULL COMMENT '日志内容',
  `description` longtext DEFAULT NULL COMMENT '日志描述',
  `logTime` timestamp DEFAULT CURRENT_TIMESTAMP COMMENT '操作时间',
  PRIMARY KEY (`sysLogId`),
  KEY `workId` (`workId`),
  CONSTRAINT `systemLog_ibfk_1` FOREIGN KEY (`workId`) REFERENCES `employee` (`workId`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `systemLog` */

insert into `systemLog`(`sysLogId`,`workId`,`broswer`,`version`,`ip`,`logContent`,`description`,`logTime`) values (1,1,'Chrome','1.1.1','127.0.0.1','employee','test',NULL);

/*Table structure for View `empSalVisual` */

DROP VIEW IF EXISTS empSalVisual;

CREATE VIEW empSalVisual AS
SELECT
'2000以下' AS '区间',
COUNT(CASE WHEN e.`basicSalary` BETWEEN 0 AND 2000 THEN 1 ELSE NULL END) AS '人数'
FROM employeesalary e
UNION ALL
SELECT
'2001~4000' AS '区间',
COUNT(CASE WHEN e.`basicSalary` BETWEEN 2001 AND 4000 THEN 1 ELSE NULL END) AS '人数'
FROM employeesalary e
UNION ALL
SELECT
'4001~6000' AS '区间',
COUNT(CASE WHEN e.`basicSalary` BETWEEN 4001 AND 6000 THEN 1 ELSE NULL END) AS '人数'
FROM employeesalary e
UNION ALL
SELECT
'6001~8000' AS '区间',
COUNT(CASE WHEN e.`basicSalary` BETWEEN 6001 AND 8000 THEN 1 ELSE NULL END) AS '人数'
FROM employeesalary e
UNION ALL
SELECT
'8001~10000' AS '区间',
COUNT(CASE WHEN e.`basicSalary` BETWEEN 8001 AND 10000 THEN 1 ELSE NULL END) AS '人数'
FROM employeesalary e
UNION ALL
SELECT
'10001~12000' AS '区间',
COUNT(CASE WHEN e.`basicSalary` BETWEEN 10001 AND 12000 THEN 1 ELSE NULL END) AS '人数'
FROM employeesalary e
UNION ALL
SELECT
'12001~14000' AS '区间',
COUNT(CASE WHEN e.`basicSalary` BETWEEN 12001 AND 14000 THEN 1 ELSE NULL END) AS '人数'
FROM employeesalary e
UNION ALL
SELECT
'14001~16000' AS '区间',
COUNT(CASE WHEN e.`basicSalary` BETWEEN 14001 AND 16000 THEN 1 ELSE NULL END) AS '人数'
FROM employeesalary e
UNION ALL
SELECT
'16001~18000' AS '区间',
COUNT(CASE WHEN e.`basicSalary` BETWEEN 16001 AND 18000 THEN 1 ELSE NULL END) AS '人数'
FROM employeesalary e
UNION ALL
SELECT
'18001~20000' AS '区间',
COUNT(CASE WHEN e.`basicSalary` BETWEEN 18001 AND 20000 THEN 1 ELSE NULL END) AS '人数'
FROM employeesalary e
UNION ALL
SELECT
'20001以上' AS '区间',
COUNT(CASE WHEN e.`basicSalary`>20001 THEN 1 ELSE NULL END) AS '人数'
FROM employeesalary e

/* Procedure structure for procedure `addDep` */

/*!50003 DROP PROCEDURE IF EXISTS  `addDep` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `addDep`(in depName varchar(32),in parentId int,in enabled boolean,in leaderId int,out result int,out result2 int)
begin
  declare did int;
  declare pDepPath varchar(64);
  insert into department set depName=depname,parentId=parentid,enabled=enabled,leaderId=leaderid;
  select row_count() into result;
  select last_insert_id() into did;
  set result2=did;
  select depPath into pDepPath from department where depId=parentid;
  update department set depPath=concat(pDepPath,'.',did) where depId=did;
  update department set isParent=true where depId=parentid;
end */$$
DELIMITER ;

/* Procedure structure for procedure `deleteDep` */

/*!50003 DROP PROCEDURE IF EXISTS  `deleteDep` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `deleteDep`(in did int,out result int)
begin
  declare ecount int;
  declare pid int;
  declare pcount int;
  declare a int;
  select count(*) into a from department where depId=did and isParent=false;
  if a=0 then set result=-2;
  else
  select count(*) into ecount from employee where depId=did;
  if ecount>0 then set result=-1;
  else 
  select parentId into pid from department where depId=did;
  delete from department where depId=did and isParent=false;
  select row_count() into result;
  select count(*) into pcount from department where parentId=pid;
  if pcount=0 then update department set isParent=false where depId=pid;
  end if;
  end if;
  end if;
end */$$
DELIMITER ;

/* Procedure structure for procedure `addEmpAndUser` */

/*!50003 DROP PROCEDURE IF EXISTS  `addEmpAndUser` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `addEmpAndUser`(in workId int,in empName varchar(16),in gender char(16),in birthday Date,in idCard char(18),in marital char(16),in nation varchar(32),in nativePlace varchar(32),in politic varchar(32),in email varchar(32),in cellphone char(11),in address varchar(64),in depId int,in workState char(32),in school varchar(32),in specialty varchar(32),in hDegree char(32),out result int,out result2 int)
begin
	declare did int;
	declare t_error int default 0;
	declare continue handler for sqlexception set t_error=1;
	start transaction;
	set autocommit = 0;
	  insert into employee set workId=workId,empName=empName,gender=gender,birthday=birthday,idCard=idCard,marital=marital,nation=nation,nativePlace=nativePlace,politic=politic,email=email,cellphone=cellphone,address=address,depId=depId,workState=workState,school=school,specialty=specialty,hDegree=hDegree;
	  select row_count() into result;
	  insert into user set workId=workId,username=workId,password='$2a$10$ySG2lkvjFHY5O0./CPIE1OI8VJsuKYEzOYzqIa7AJR6sEgSzUFOAm',userface='http://bpic.588ku.com/element_pic/01/40/00/64573ce2edc0728.jpg',enabled=1,userRemark='AutoCreate';
	  select last_insert_id() into did;
	  insert into user_Role set userId=did,roleId=2;
	  select row_count() into result2;
	if t_error=1 then  
        rollback;
    else  
        commit; 
    end if; 
end */$$
DELIMITER ;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
