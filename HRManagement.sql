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



/*Data for the table `calendar` */


/*Table structure for table `employeeInfo` */

DROP TABLE IF EXISTS `employeeInfo`;

CREATE TABLE `employeeInfo` (
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
  CONSTRAINT `employeeInfo_ibfk_1` FOREIGN KEY (`depId`) REFERENCES `department` (`depId`)
) ENGINE=InnoDB AUTO_INCREMENT=52 DEFAULT CHARSET=utf8;

/*Data for the table `employeeInfo` */

insert  into `employeeInfo`(`workId`,`empName`,`gender`,`birthday`,`idCard`,`marital`,`nation`,`nativePlace`,`politic`,`email`,`cellphone`,`address`,`depId`,`workState`,`school`,`specialty`,`hDegree`) values (1,'李涛','男','1990-01-01','610122199001011256','未婚','汉族','重庆','中共党员','1734766965@qq.com','18565558897','重庆市北碚区',1,'在职','哈佛大学','信息管理与信息系统','博士'),(2,'陈静','女','1989-02-01','421288198902011234','已婚','汉族','海南','中共预备党员','chenjing@qq.com','18795556693','海南省海口市美兰区',4,'在职','武汉大学','市场营销','高中'),(3,'赵琳浩','男','1993-03-04','610122199303041456','未婚','汉族','陕西','共青团员','zhao@qq.com','15698887795','陕西省西安市莲湖区',5,'在职','哈尔滨理工大学','电子工程','博士'),(4,'鹿存亮','男','1990-01-03','610122199001031456','已婚','壮族','陕西','共青团员','zhao@qq.com','15612347795','陕西省西安市莲湖区',8,'在职','哈尔滨理工大学','电子工程','高中'),(5,'姚森','男','1991-02-05','610122199102058952','已婚','维吾尔族','河南','民革党员','yaosen@qq.com','14785559936','河南洛阳人民大道58号',78,'在职','西北大学','室内装修设计','硕士'),(6,'云星','女','1993-01-05','610122199301054789','已婚','回族','陕西西安','民盟盟员','yunxing@qq.com','15644442252','陕西西安新城区',81,'在职','西安电子科技学校','通信工程','硕士'),(7,'贾旭明','男','1993-11-11','610122199311111234','已婚','汉族','广东广州','民建会员','jiaxuming@qq.com','15644441234','广东省广州市天河区冼村路',82,'在职','西北大学','通信工程','初中'),(8,'张黎明','男','1991-02-01','610144199102014569','已婚','满族','广东','民进会员','zhangliming@qq.com','18979994478','广东珠海',85,'离职','清华大学','考古','高中'),(9,'薛磊','男','1992-07-01','610144199207017895','已婚','蒙古族','陕西西安','农工党党员','xuelei@qq.com','15648887741','西安市雁塔区',86,'在职','华胥中学','无','初中'),(10,'张洁','女','1990-10-09','420177199010093652','未婚','汉族','海南','致公党党员','zhangjie@qq.com','13695557742','海口市美兰区',87,'在职','海南侨中','无','高中'),(11,'彭万里','男','1990-01-01','610122199001011256','已婚','汉族','陕西','九三学社社员','laowang@qq.com','18565558897','深圳市南山区',89,'实习','深圳大学','信息管理与信息系统','本科'),(12,'高大山','女','1989-02-01','421288198902011234','已婚','藏族','海南','台盟盟员','chenjing@qq.com','18795556693','海南省海口市美兰区',91,'离职','武汉大学','市场营销','高中'),(13,'谢大海','男','1993-03-04','610122199303041456','未婚','汉族','陕西','无党派民主人士','zhao@qq.com','15698887795','陕西省西安市莲湖区',92,'离职','哈尔滨理工大学','电子工程','博士'),(14,'马宏宇','男','1990-01-03','610122199001031456','已婚','汉族','陕西','普通公民','zhao@qq.com','15612347795','陕西省西安市莲湖区',93,'在职','哈尔滨理工大学','电子工程','高中'),(15,'林莽','男','1991-02-05','610122199102058952','已婚','藏族','河南','普通公民','yaosen@qq.com','14785559936','河南洛阳人民大道58号',94,'实习','西北大学','室内装修设计','初中'),(16,'黄强辉','女','1993-01-05','610122199301054789','已婚','汉族','陕西西安','普通公民','yunxing@qq.com','15644442252','陕西西安新城区',96,'在职','西安电子科技学校','通信工程','硕士'),(17,'章汉夫','男','1993-11-11','610122199311111234','已婚','高山族','广东广州','中共党员','jiaxuming@qq.com','15644441234','广东省广州市天河区冼村路',104,'在职','西北大学','通信工程','初中'),(18,'王一亭','男','1991-02-01','610144199102014569','已婚','傣族','广东','中共预备党员','zhangliming@qq.com','18979994478','广东珠海',91,'在职','清华大学','考古','高中'),(19,'范长江','男','1992-07-01','610144199207017895','已婚','汉族','陕西西安','共青团员','xuelei@qq.com','15648887741','西安市雁塔区',92,'兼职','华胥中学','无','初中'),(20,'林君雄','女','1990-10-09','420177199010093652','未婚','汉族','海南','共青团员','zhangjie@qq.com','13695557742','海口市美兰区',92,'实习','海南侨中','无','高中'),(21,'谭平山','男','1990-01-01','610122199001011256','已婚','汉族','陕西','民盟盟员','laowang@qq.com','18565558897','深圳市南山区',8,'在职','深圳大学','信息管理与信息系统','本科'),(22,'朱希亮','女','1989-02-01','421288198902011234','离异','傣族','海南','共青团员','chenjing@qq.com','18795556693','海南省海口市美兰区',82,'退休','武汉大学','市场营销','高中'),(23,'李四光','男','1990-01-03','610122199001031456','已婚','汉族','陕西','农工党党员','zhao@qq.com','15612347795','陕西省西安市莲湖区',92,'离职','哈尔滨理工大学','电子工程','高中'),(24,'甘铁生','男','1991-02-05','610122199102058952','已婚','彝族','河南','台盟盟员','yaosen@qq.com','14785559936','河南洛阳人民大道58号',92,'在职','西北大学','室内装修设计','初中'),(25,'马继祖','女','1993-01-05','610122199301054789','离异','瑶族','陕西西安','无党派民主人士','yunxing@qq.com','15644442252','陕西西安新城区',92,'在职','西安电子科技学校','通信工程','硕士'),(26,'程孝先','男','1993-11-11','610122199311111234','已婚','朝鲜族','广东广州','中共党员','jiaxuming@qq.com','15644441234','广东省广州市天河区冼村路',78,'在职','西北大学','通信工程','初中'),(27,'宗敬先','男','1991-02-01','610144199102014569','已婚','侗族','广东','中共预备党员','zhangliming@qq.com','18979994478','广东珠海',91,'在职','清华大学','考古','高中'),(28,'年广嗣','男','1992-07-01','610144199207017895','已婚','土家族','陕西西安','中共预备党员','xuelei@qq.com','15648887741','西安市雁塔区',92,'退休','华胥中学','无','初中'),(29,'汤绍箕','男','1990-01-01','610122199001011256','已婚','布依族','陕西','共青团员','laowang@qq.com','18565558897','深圳市南山区',8,'兼职','深圳大学','信息管理与信息系统','本科'),(30,'吕显祖','女','1989-02-01','421288198902011234','已婚','哈萨克族','海南','无党派民主人士','chenjing@qq.com','18795556693','海南省海口市美兰区',82,'兼职','武汉大学','市场营销','高中'),(31,'何光宗','男','1993-03-04','610122199303041456','未婚','佤族','陕西','民革党员','zhao@qq.com','15698887795','陕西省西安市莲湖区',91,'在职','哈尔滨理工大学','电子工程','博士'),(32,'孙念','男','1990-01-03','610122199001031456','已婚','东乡族','陕西','中共党员','zhao@qq.com','15612347795','陕西省西安市莲湖区',92,'在职','哈尔滨理工大学','电子工程','高中'),(33,'马建国','男','1991-02-05','610122199102058952','已婚','朝鲜族','河南','无党派民主人士','yaosen@qq.com','14785559936','河南洛阳人民大道58号',92,'退休','西北大学','室内装修设计','初中'),(34,'节振国','女','1993-01-05','610122199301054789','已婚','柯尔克孜族','陕西西安','民盟盟员','yunxing@qq.com','15644442252','陕西西安新城区',92,'退休','西安电子科技学校','通信工程','硕士'),(35,'冯兴国','男','1993-11-11','610122199311111234','已婚','纳西族','广东广州','中共预备党员','jiaxuming@qq.com','15644441234','广东省广州市天河区冼村路',78,'实习','西北大学','通信工程','初中'),(36,'郝爱民','男','1991-02-01','610144199102014569','离异','佤族','广东','共青团员','zhangliming@qq.com','18979994478','广东珠海',91,'兼职','清华大学','考古','高中'),(37,'于学忠','男','1992-07-01','610144199207017895','已婚','达斡尔族','陕西西安','民革党员','xuelei@qq.com','15648887741','西安市雁塔区',92,'在职','华胥中学','无','初中'),(38,'马连良','女','1990-10-09','420177199010093652','未婚','侗族','海南','民盟盟员','zhangjie@qq.com','13695557742','海口市美兰区',92,'实习','海南侨中','无','高中'),(39,'胡宝善','男','1990-01-01','610122199001011256','已婚','仫佬族','陕西','中共预备党员','laowang@qq.com','18565558897','深圳市南山区',8,'兼职','深圳大学','信息管理与信息系统','本科'),(40,'李宗仁','女','1989-02-01','421288198902011234','已婚','羌族','海南','民革党员','chenjing@qq.com','18795556693','海南省海口市美兰区',82,'实习','武汉大学','市场营销','高中'),(41,'洪学智','男','1993-03-04','610122199303041456','未婚','侗族','陕西','共青团员','zhao@qq.com','15698887795','陕西省西安市莲湖区',91,'在职','哈尔滨理工大学','电子工程','博士'),(42,'余克勤','男','1990-01-03','610122199001031456','已婚','布朗族','陕西','中共党员','zhao@qq.com','15612347795','陕西省西安市莲湖区',92,'在职','哈尔滨理工大学','电子工程','高中'),(43,'杨惟义','男','1991-02-05','610122199102058952','离异','毛难族','河南','民盟盟员','yaosen@qq.com','14785559936','河南洛阳人民大道58号',92,'实习','西北大学','室内装修设计','初中'),(44,'李文信','女','1993-01-05','610122199301054789','已婚','哈萨克族','陕西西安','农工党党员','yunxing@qq.com','15644442252','陕西西安新城区',92,'在职','西安电子科技学校','通信工程','硕士'),(45,'王德茂','男','1993-11-11','610122199311111234','已婚','锡伯族','广东广州','中共预备党员','jiaxuming@qq.com','15644441234','广东省广州市天河区冼村路',78,'退休','西北大学','通信工程','初中'),(46,'李书诚','男','1991-02-01','610144199102014569','已婚','东乡族','广东','中共党员','zhangliming@qq.com','18979994478','广东珠海',91,'退休','清华大学','考古','高中'),(47,'高尚德','男','1992-07-01','610144199207017895','已婚','塔吉克族','陕西西安','民盟盟员','xuelei@qq.com','15648887741','西安市雁塔区',92,'实习','华胥中学','无','初中'),(48,'汤念祖','女','1990-10-09','420177199010093652','未婚','侗族','海南','共青团员','zhangjie@qq.com','13695557742','海口市美兰区',92,'退休','海南侨中','无','高中'),(49,'何光宗','男','1990-01-01','610122199001011256','离异','乌孜别克族','陕西','中共党员','laowang@qq.com','18565558897','深圳市南山区',8,'退休','深圳大学','信息管理与信息系统','本科'),(50,'钱运高','女','1989-02-01','421288198902011234','已婚','纳西族','海南','农工党党员','chenjing@qq.com','18795556693','海南省海口市美兰区',82,'退休','武汉大学','市场营销','高中'),(51,'王仁兴','男','2019-11-24','610144199905056666','已婚','鄂温克族','广东','中共预备党员','584991843@qq.com','18566667777','广东深圳',89,'退休','深圳大学','计算机科学','本科');

/*Table structure for table `department` */

DROP TABLE IF EXISTS `department`;

CREATE TABLE `department` (
  `depId` int(11) NOT NULL AUTO_INCREMENT,
  `depName` varchar(32) DEFAULT NULL COMMENT '部门名称',
  `parentId` int(11) DEFAULT NULL,
  `depPath` varchar(255) DEFAULT NULL,
  `enabled` tinyint(1) DEFAULT '0',
  `isParent` tinyint(1) DEFAULT '0',
  `leaderId` int(11) DEFAULT NULL,
  PRIMARY KEY (`depId`),
  KEY `dLeaderId` (`leaderId`),
  CONSTRAINT `department_ibfk_1` FOREIGN KEY (`leaderId`) REFERENCES `employeeInfo` (`workId`)
) ENGINE=InnoDB AUTO_INCREMENT=105 DEFAULT CHARSET=utf8;

/*Data for the table `department` */

insert  into `department`(`depId`,`depName`,`parentId`,`depPath`,`enabled`,`isParent`,`leaderId`) values (1,'股东会',-1,'.1',1,1,1),(4,'董事会',1,'.1.4',1,1,2),(5,'总经理',4,'.1.4.5',1,1,3),(8,'财务部',5,'.1.4.5.8',1,0,4),(78,'市场部',5,'.1.4.5.78',1,1,5),(81,'华北市场部',78,'.1.4.5.78.81',1,1,12),(82,'华南市场部',78,'.1.4.5.78.82',1,0,13),(85,'石家庄市场部',81,'.1.4.5.78.81.85',1,0,15),(86,'西北市场部',78,'.1.4.5.78.86',1,1,14),(87,'西安市场',86,'.1.4.5.78.86.87',1,1,16),(89,'长安区市场',87,'.1.4.5.78.86.87.89',1,0,17),(91,'研发部',5,'.1.4.5.91',1,0,6),(92,'运维部',5,'.1.4.5.92',1,1,7),(93,'销售部',92,'.1.4.5.92.93',1,0,8),(94,'办公室',92,'.1.4.5.92.94',1,0,9),(96,'北京分部',1,'.1.96',1,1,10),(104,'领导班子',96,'.1.96.104',1,0,11);


/*Table structure for table `employeeChange` */

DROP TABLE IF EXISTS `employeeChange`;

CREATE TABLE `employeeChange` (
  `empcId` int(11) NOT NULL AUTO_INCREMENT,
  `workId` int(11) DEFAULT NULL COMMENT '员工工号',
  `afterDepId` int(11) DEFAULT NULL COMMENT '调动后部门',
  `empChanData` date DEFAULT NULL COMMENT '调动日期',
  `empChanRemark` varchar(255) DEFAULT NULL COMMENT '调动备注',
  PRIMARY KEY (`empcId`),
  KEY `workId` (`workId`),
  CONSTRAINT `employeeChange_ibfk_1` FOREIGN KEY (`workId`) REFERENCES `employeeInfo` (`workId`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Data for the table `employeeChange` */

insert into `employeeChange`(`empcId`,`workId`,`afterDepId`,`empChanData`,`empChanRemark`) values (1,45,8,'2019-10-07','该员工更适合此部门！'),(2,46,96,'2020-01-02','该员工能力出众，去领导北京分部事务。'),(3,47,81,'2019-05-20','该员工工作懈怠，降职处理。');

/*Table structure for table `contractInfo` */

DROP TABLE IF EXISTS `contractInfo`;

CREATE TABLE `contractInfo` (
  `contId` int(11) NOT NULL AUTO_INCREMENT,
  `workId` int(11) DEFAULT NULL COMMENT '员工工号',
  `beginContract` date DEFAULT NULL COMMENT '合同开始时间',
  `endContract` date DEFAULT NULL COMMENT '合同结束时间',
  `content` varchar(255) DEFAULT NULL COMMENT '合同内容',
  PRIMARY KEY (`contId`),
  KEY `workId` (`workId`),
  CONSTRAINT `contractInfo_ibfk_1` FOREIGN KEY (`workId`) REFERENCES `employeeInfo` (`workId`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `contractInfo` */

insert into `contractInfo`(`contId`,`workId`,`beginContract`,`endContract`,`content`) values (1,1,'2002-04-06','2022-04-05','https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1517070040185&di=be0375e0c3db6c311b837b28c208f318&imgtype=0&src=http%3A%2F%2Fimg2.soyoung.com%2Fpost%2F20150213%2F6%2F20150213141918532.jpg'),(2,2,'2002-04-25','2022-04-24','http://b-ssl.duitang.com/uploads/item/201901/17/20190117230425_eofqv.thumb.700_0.jpg;http://img5.imgtn.bdimg.com/it/u=151799558,1417326231&fm=26&gp=0.jpg');

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
  `traffic` double DEFAULT NULL COMMENT '交通补贴',
  `catering` double DEFAULT NULL COMMENT '餐饮补贴',
  `communication` double DEFAULT NULL COMMENT '通信补贴',
  `bonus` double DEFAULT NULL COMMENT '奖金',
  `other` double DEFAULT NULL COMMENT '其它',
  PRIMARY KEY (`welId`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Data for the table `welfare` */

insert into `welfare`(`welId`,`traffic`,`catering`,`communication`,`bonus`,`other`) values (1,100,300,20,0,0),(2,500,250,10,0,0),(3,200,400,0,200,0);

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
  CONSTRAINT `employeeSalary_ibfk_8` FOREIGN KEY (`workId`) REFERENCES `employeeInfo` (`workId`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `employeeSalary` */

insert into `employeeSalary`(`esId`,`workId`,`basicSalary`,`endowment`,`medical`,`unemployment`,`injury`,`maternity`,`addMedical`,`housing`,`enterpriseP`,`welId`,`childEdu`,`conEdu`,`serMedical`,`housingLoan`,`rental`,`supportOld`) values (1,1,6000,1,1,1,1,1,1,1,1,1,2,3,11,5,6,9);

/*Table structure for table `salaryScheme` */



/*Data for the table `salaryScheme` */

/*Table structure for table `salaryAdjustment` */

DROP TABLE IF EXISTS `salaryAdjustment`;

CREATE TABLE `salaryAdjustment` (
  `saId` int(11) NOT NULL AUTO_INCREMENT,
  `workId` int(11) DEFAULT NULL COMMENT '员工工号',
  `saData` timestamp DEFAULT CURRENT_TIMESTAMP COMMENT '调薪日期',
  `saRemark` varchar(255) DEFAULT NULL COMMENT '调薪备注',
  PRIMARY KEY (`saId`),
  KEY `workId` (`workId`),
  CONSTRAINT `salaryAdjustment_ibfk_1` FOREIGN KEY (`workId`) REFERENCES `employeeInfo` (`workId`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `salaryAdjustment` */

insert into `salaryAdjustment`(`saId`,`workId`,`saData`,`saRemark`) values (1,1,'2020-01-02 9:30:30','公司上市');

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
  `payoffData` timestamp DEFAULT CURRENT_TIMESTAMP COMMENT '计算薪资时间',
  PRIMARY KEY (`siId`),
  KEY `workId` (`workId`),
  CONSTRAINT `salaryInfo_ibfk_1` FOREIGN KEY (`workId`) REFERENCES `employeeInfo` (`workId`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `salaryInfo` */

insert into `salaryInfo`(`siId`,`workId`,`basicSalary`,`absenteeism`,`overtime`,`busiTrip`,`endowment`,`medical`,`unemployment`,`injury`,`maternity`,`addMedical`,`housing`,`enterpriseP`,`childEdu`,`conEdu`,`serMedical`,`housingLoan`,`rental`,`supportOld`,`traffic`,`catering`,`communication`,`other`,`bonus`,`sums`,`payoffData`) values (1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,NULL);

/*Table structure for table `businessHours` */

DROP TABLE IF EXISTS `businessHours`;

CREATE TABLE `businessHours` (
  `busiHoursId` int(11) NOT NULL AUTO_INCREMENT,
  `busiHoursName` varchar(16) DEFAULT NULL COMMENT '班次名称',
  `beginTime` time DEFAULT NULL COMMENT '上班时间',
  `endTime` time DEFAULT NULL COMMENT '下班时间',
  PRIMARY KEY (`busiHoursId`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `businessHours` */

insert into `businessHours`(`busiHoursId`,`busiHoursName`,`beginTime`,`endTime`) values (1,'正班','9:00:00','18:00:00');

/*Table structure for table `workingSchedule` */



/*Data for the table `workingSchedule` */

/*Table structure for table `applyAttendanceTransaction` */

DROP TABLE IF EXISTS `applyAttendanceTransaction`;

CREATE TABLE `applyAttendanceTransaction` (
  `aatId` int(11) NOT NULL AUTO_INCREMENT,
  `workId` int(11) DEFAULT NULL COMMENT '员工工号',
  `category` enum('请假','调休','出差','加班') DEFAULT NULL COMMENT '事务类别',
  `reason` varchar(255) DEFAULT NULL COMMENT '申请原因',
  `appBeginData` datetime DEFAULT NULL COMMENT '事务开始时间',
  `appEndData` datetime DEFAULT NULL COMMENT '事务结束时间',
  `total` int(5) DEFAULT NULL COMMENT '总共事务时间/分钟',
  `appData` timestamp DEFAULT CURRENT_TIMESTAMP COMMENT '申请时间',
  `leaderId` int(11) DEFAULT NULL COMMENT '上级领导工号',
  `isApprove` tinyint(1) DEFAULT 0 COMMENT '领导意见',
  PRIMARY KEY (`aatId`),
  KEY `workId` (`workId`),
  KEY `aLeaderId` (`leaderId`),
  CONSTRAINT `applyAttendanceTransaction_ibfk_1` FOREIGN KEY (`workId`) REFERENCES `employeeInfo` (`workId`),
  CONSTRAINT `applyAttendanceTransaction_ibfk_2` FOREIGN KEY (`leaderId`) REFERENCES `employeeInfo` (`workId`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `applyAttendanceTransaction` */

insert into `applyAttendanceTransaction`(`aatId`,`workId`,`category`,`reason`,`appBeginData`,`appEndData`,`total`,`appData`,`leaderId`,`isApprove`) values (1,1,'出差','签合同！','2019-12-15 09:00:00','2019-12-18 18:00:00',1680,NULL,1,1);

/*Table structure for table `attendanceLog` */

DROP TABLE IF EXISTS `attendanceLog`;

CREATE TABLE `attendanceLog` (
  `atteLogId` int(11) NOT NULL AUTO_INCREMENT,
  `workId` int(11) DEFAULT NULL COMMENT '员工工号',
  `clockInDay` date DEFAULT NULL COMMENT '打卡日期',
  `signInTime` time DEFAULT NULL COMMENT '签到时间',
  `signOutTime` time DEFAULT NULL COMMENT '签退时间',
  `clockInFlag` varchar(16) DEFAULT NULL COMMENT '考勤状态',
  `workingHours` int(5) DEFAULT NULL COMMENT '工作时间/分钟',
  PRIMARY KEY (`atteLogId`),
  KEY `workId` (`workId`),
  CONSTRAINT `attendanceLog_ibfk_1` FOREIGN KEY (`workId`) REFERENCES `employeeInfo` (`workId`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `attendanceLog` */

insert into `attendanceLog`(`atteLogId`,`workId`,`clockInDay`,`signInTime`,`signOutTime`,`clockInFlag`,`workingHours`) values (1,1,'2020-01-15','08:35:00','18:15.46','正常',420);

/*Table structure for table `userAccountInfo` */

DROP TABLE IF EXISTS `userAccountInfo`;

CREATE TABLE `userAccountInfo` (
  `userId` int(11) NOT NULL AUTO_INCREMENT,
  `workId` int(11) DEFAULT NULL COMMENT '员工工号',
  `username` varchar(255) DEFAULT NULL COMMENT '用户名',
  `password` varchar(255) DEFAULT NULL COMMENT '密码',
  `userEnabled` tinyint(1) DEFAULT 0 COMMENT '用户可用',
  `userRemark` varchar(255) DEFAULT NULL COMMENT '用户备注',
  PRIMARY KEY (`userId`),
  KEY `workId` (`workId`),
  CONSTRAINT `userAccountInfo_ibfk_1` FOREIGN KEY (`workId`) REFERENCES `employeeInfo` (`workId`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `userAccountInfo` */

insert into `userAccountInfo`(`userId`,`workId`,`username`,`password`,`userEnabled`,`userRemark`) values (1,1,'ceo','123',1,'董事长');

/*Table structure for table `role` */

DROP TABLE IF EXISTS `role`;

CREATE TABLE `role` (
  `roleId` int(11) NOT NULL AUTO_INCREMENT,
  `enName` varchar(16) DEFAULT NULL COMMENT '角色英文名',
  `zhName` varchar(16) DEFAULT NULL COMMENT '角色中文名',
  PRIMARY KEY (`roleId`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `role` */

insert into `role`(`roleId`,`enName`,`zhName`) values (1,'ROLE_admin','系统管理员');

/*Table structure for table `user_Role` */

DROP TABLE IF EXISTS `user_Role`;

CREATE TABLE `user_Role` (
  `uRoleId` int(11) NOT NULL AUTO_INCREMENT,
  `userId` int(11) DEFAULT NULL COMMENT '员工工号',
  `roleId` int(11) DEFAULT NULL COMMENT '角色ID',
  PRIMARY KEY (`uRoleId`),
  KEY `userId` (`userId`),
  KEY `roleId` (`roleId`),
  CONSTRAINT `user_Role_ibfk_1` FOREIGN KEY (`userId`) REFERENCES `userAccountInfo` (`userId`) ON DELETE CASCADE,
  CONSTRAINT `user_Role_ibfk_2` FOREIGN KEY (`roleId`) REFERENCES `role` (`roleId`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `user_Role` */

insert into `user_Role`(`uRoleId`,`userId`,`roleId`) values (1,1,1);

/*Table structure for table `permissions` */

DROP TABLE IF EXISTS `permissions`;

CREATE TABLE `permissions` (
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
  CONSTRAINT `permissions_ibfk_1` FOREIGN KEY (`parentId`) REFERENCES `permissions` (`pId`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8;

/*Data for the table `permissions` */

insert  into `permissions`(`pId`,`url`,`path`,`component`,`name`,`iconCls`,`keepAlive`,`requireAuth`,`parentId`,`enabled`) values (1,'/',NULL,NULL,'所有',NULL,NULL,NULL,NULL,1),(2,'/','/home','Home','首页工作台','fas fa-home',NULL,1,1,1),(3,'/','/home','Home','部门管理','fas fa-users',NULL,1,1,1),(4,'/','/home','Home','员工信息管理','fas fa-address-book',NULL,1,1,1),(5,'/','/home','Home','员工薪资管理','fas fa-money-check-alt',NULL,1,1,1),(6,'/','/home','Home','员工考勤管理','fas fa-user-clock',NULL,1,1,1),(7,'/','/home','Home','系统管理','fas fa-sliders-h',NULL,1,1,1),(8,'/organization/Management/**','/org/manage','OrgManage','部门组织机构管理',NULL,NULL,1,3,1),(9,'/employee/basic/**','/emp/basic','EmpBasic','员工基本信息管理',NULL,NULL,1,4,1),(10,'/salary/taxrate/**','/sal/tr','SalTr','税率表',NULL,NULL,1,5,1),(11,'/salary/treatment/**','/sal/treatment','SalTreatment','保障性待遇表',NULL,NULL,1,5,1),(12,'/salary/welfare/**','/sal/welfare','SalWelfare','福利表',NULL,NULL,1,5,1),(13,'/salary/specialadditionaldeduction/**','/sal/sad','SalSad','专项附加扣除表',NULL,NULL,1,5,1),(14,'/salary/employee/**','/sal/emp','SalEmp','员工基础薪资管理',NULL,NULL,1,5,1),(15,'/salary/scheme/**','/sal/scheme','SalScheme','薪资计算方案管理',NULL,NULL,1,5,1),(16,'/salary/check/**','/sal/check','SalCheck','薪资核算',NULL,NULL,1,5,1),(17,'/salary/adjustment/**','/sal/adjustment','SalAdjustment','员工基础薪资调整',NULL,NULL,1,5,1),(18,'/salary/information/**','/sal/info','SalInfo','员工历史薪资信息管理',NULL,NULL,1,5,1),(19,'/attendance/workingschedule/**','/att/ws','AttWs','排班管理',NULL,NULL,1,6,1),(20,'/attendance/transactionapp/**','/att/traapp','AttTraapp','考勤事务申请',NULL,NULL,1,6,1),(21,'/attendance/transactionmanagement/**','/att/tramanagement','AttTramanagement','考勤事务管理',NULL,NULL,1,6,1),(22,'/attendance/transactioninfo/**','/att/transactioninfo','AttTransactioninfo','考勤事务信息管理',NULL,NULL,1,6,1),(23,'/attendance/management/**','/att/management','AttManagement','考勤管理',NULL,NULL,1,6,1),(24,'/system/rolepermission/**','/sys/rolep','SysRolep','角色权限管理',NULL,NULL,1,7,1),(25,'/system/userrole/**','/sys/userrole','StaUserrole','用户角色管理',NULL,NULL,1,7,1),(26,'/system/log/**','/sys/log','SysLog','系统日志管理',NULL,NULL,1,7,1);

/*Table structure for table `permission_Role` */

DROP TABLE IF EXISTS `permission_Role`;

CREATE TABLE `permission_Role` (
  `pRoleId` int(11) NOT NULL AUTO_INCREMENT,
  `pId` int(11) DEFAULT NULL,
  `roleId` int(11) DEFAULT NULL,
  PRIMARY KEY (`pRoleId`),
  KEY `pId` (`pId`),
  KEY `roleId` (`roleId`),
  CONSTRAINT `permission_Role_ibfk_1` FOREIGN KEY (`pId`) REFERENCES `permissions` (`pId`),
  CONSTRAINT `permission_Role_ibfk_2` FOREIGN KEY (`roleId`) REFERENCES `role` (`roleId`)
) ENGINE=InnoDB AUTO_INCREMENT=283 DEFAULT CHARSET=utf8;

/*Data for the table `permission_Role` */

insert into `permission_Role`(`pRoleId`,`pId`,`roleId`) values (1,8,1),(2,9,1),(3,10,1),(4,11,1),(5,12,1),(6,13,1),(7,14,1),(8,15,1),(9,16,1),(10,17,1),(11,18,1),(12,19,1),(13,20,1),(14,21,1),(15,22,1),(16,23,1),(17,24,1),(18,25,1),(19,26,1);

/*Table structure for table `systemLog` */

DROP TABLE IF EXISTS `systemLog`;

CREATE TABLE `systemLog` (
  `sysLogId` int(11) NOT NULL AUTO_INCREMENT,
  `workId` int(11) DEFAULT NULL COMMENT '员工工号',
  `broswer` varchar(64) DEFAULT NULL COMMENT '浏览器',
  `ip` varchar(16) DEFAULT NULL COMMENT 'IP地址',
  `logContent` longtext DEFAULT NULL COMMENT '日志内容',
  `logTime` timestamp DEFAULT CURRENT_TIMESTAMP COMMENT '操作时间',
  PRIMARY KEY (`sysLogId`),
  KEY `workId` (`workId`),
  CONSTRAINT `systemLog_ibfk_1` FOREIGN KEY (`workId`) REFERENCES `employeeInfo` (`workId`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `systemLog` */

insert into `systemLog`(`sysLogId`,`workId`,`broswer`,`ip`,`logContent`,`logTime`) values (1,1,'Chrome','127.0.0.1','登录',NULL);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
