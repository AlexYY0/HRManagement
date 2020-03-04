package com.emperorws.hrmanagement.utils;

import com.emperorws.hrmanagement.model.Salaryinfo;
import org.apache.poi.hpsf.DocumentSummaryInformation;
import org.apache.poi.hpsf.SummaryInformation;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

/**
 * @Author: EmperorWS
 * @Date: 2020/3/3 17:22
 * @Description: 员工历史薪资信息导出工具类
 **/
public class SalInfoPOIUtils {
    public static ResponseEntity<byte[]> salaryinfo2Excel(List<Salaryinfo> list){
        //1. 创建一个 Excel 文档
        HSSFWorkbook workbook = new HSSFWorkbook();
        //2. 创建文档摘要
        workbook.createInformationProperties();
        //3. 获取并配置文档信息
        DocumentSummaryInformation docInfo = workbook.getDocumentSummaryInformation();
        //文档类别
        docInfo.setCategory("员工历史薪资信息");
        //文档管理员
        docInfo.setManager("EmperorWS");
        //设置公司信息
        docInfo.setCompany("www.EmperorWS.club");
        //4. 获取文档摘要信息
        SummaryInformation summInfo = workbook.getSummaryInformation();
        //文档标题
        summInfo.setTitle("员工薪资信息表");
        //文档作者
        summInfo.setAuthor("EmperorWS");
        // 文档备注
        summInfo.setComments("本文档由 EmperorWS 提供");
        //5. 创建样式
        //创建标题行的样式
        HSSFCellStyle headerStyle = workbook.createCellStyle();
        headerStyle.setFillForegroundColor(IndexedColors.YELLOW.index);
        headerStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        HSSFCellStyle dateCellStyle = workbook.createCellStyle();
        dateCellStyle.setDataFormat(HSSFDataFormat.getBuiltinFormat("m/d/yy"));
        HSSFCellStyle intCellStyle = workbook.createCellStyle();
        intCellStyle.setDataFormat(HSSFDataFormat.getBuiltinFormat("00000000000"));
        HSSFSheet sheet = workbook.createSheet("员工历史薪资信息表");
        //设置列的宽度
        sheet.setColumnWidth(0, 5 * 256);
        sheet.setColumnWidth(1, 12 * 256);
        sheet.setColumnWidth(2, 10 * 256);
        sheet.setColumnWidth(3, 10 * 256);
        sheet.setColumnWidth(4, 10 * 256);
        sheet.setColumnWidth(5, 10 * 256);
        sheet.setColumnWidth(6, 10 * 256);
        sheet.setColumnWidth(7, 10 * 256);
        sheet.setColumnWidth(8, 10 * 256);
        sheet.setColumnWidth(9, 10 * 256);
        sheet.setColumnWidth(10, 10 * 256);
        sheet.setColumnWidth(11, 10 * 256);
        sheet.setColumnWidth(12, 10 * 256);
        sheet.setColumnWidth(13, 10 * 256);
        sheet.setColumnWidth(14, 10 * 256);
        sheet.setColumnWidth(15, 10 * 256);
        sheet.setColumnWidth(16, 10 * 256);
        sheet.setColumnWidth(17, 10 * 256);
        sheet.setColumnWidth(18, 10 * 256);
        sheet.setColumnWidth(19, 10 * 256);
        sheet.setColumnWidth(20, 10 * 256);
        sheet.setColumnWidth(21, 10 * 256);
        sheet.setColumnWidth(22, 10 * 256);
        sheet.setColumnWidth(23, 10 * 256);
        sheet.setColumnWidth(24, 10 * 256);
        sheet.setColumnWidth(25, 10 * 256);
        sheet.setColumnWidth(26, 10 * 256);
        sheet.setColumnWidth(27, 10 * 256);
        sheet.setColumnWidth(28, 15 * 256);
        //6. 创建标题行
        HSSFRow r0 = sheet.createRow(0);
        HSSFCell c0 = r0.createCell(0);
        c0.setCellValue("编号");
        c0.setCellStyle(headerStyle);
        HSSFCell c1 = r0.createCell(1);
        c1.setCellStyle(headerStyle);
        c1.setCellValue("员工工号");
        HSSFCell c2 = r0.createCell(2);
        c2.setCellStyle(headerStyle);
        c2.setCellValue("员工姓名");
        HSSFCell c3 = r0.createCell(3);
        c3.setCellStyle(headerStyle);
        c3.setCellValue("所属部门");
        HSSFCell c4 = r0.createCell(4);
        c4.setCellStyle(headerStyle);
        c4.setCellValue("基础薪资");
        HSSFCell c5 = r0.createCell(5);
        c5.setCellStyle(headerStyle);
        c5.setCellValue("缺勤扣除工资");
        HSSFCell c6 = r0.createCell(6);
        c6.setCellStyle(headerStyle);
        c6.setCellValue("加班工资");
        HSSFCell c7 = r0.createCell(7);
        c7.setCellStyle(headerStyle);
        c7.setCellValue("出差补助");
        HSSFCell c8 = r0.createCell(8);
        c8.setCellStyle(headerStyle);
        c8.setCellValue("养老保险");
        HSSFCell c9 = r0.createCell(9);
        c9.setCellStyle(headerStyle);
        c9.setCellValue("医疗保险");
        HSSFCell c10 = r0.createCell(10);
        c10.setCellStyle(headerStyle);
        c10.setCellValue("失业保险");
        HSSFCell c11 = r0.createCell(11);
        c11.setCellStyle(headerStyle);
        c11.setCellValue("工伤保险");
        HSSFCell c12 = r0.createCell(12);
        c12.setCellStyle(headerStyle);
        c12.setCellValue("生育保险");
        HSSFCell c13 = r0.createCell(13);
        c13.setCellStyle(headerStyle);
        c13.setCellValue("补充医疗保险");
        HSSFCell c14 = r0.createCell(14);
        c14.setCellStyle(headerStyle);
        c14.setCellValue("住房公积金");
        HSSFCell c15 = r0.createCell(15);
        c15.setCellStyle(headerStyle);
        c15.setCellValue("企业年金");
        HSSFCell c16 = r0.createCell(16);
        c16.setCellStyle(headerStyle);
        c16.setCellValue("子女教育");
        HSSFCell c17 = r0.createCell(17);
        c17.setCellStyle(headerStyle);
        c17.setCellValue("继续教育");
        HSSFCell c18 = r0.createCell(18);
        c18.setCellStyle(headerStyle);
        c18.setCellValue("大病医疗");
        HSSFCell c19 = r0.createCell(19);
        c19.setCellStyle(headerStyle);
        c19.setCellValue("住房贷款利息");
        HSSFCell c20 = r0.createCell(20);
        c20.setCellStyle(headerStyle);
        c20.setCellValue("住房租金");
        HSSFCell c21 = r0.createCell(21);
        c21.setCellStyle(headerStyle);
        c21.setCellValue("赡养老人");
        HSSFCell c22 = r0.createCell(22);
        c22.setCellStyle(headerStyle);
        c22.setCellValue("交通补贴");
        HSSFCell c23 = r0.createCell(23);
        c23.setCellStyle(headerStyle);
        c23.setCellValue("餐饮补贴");
        HSSFCell c24 = r0.createCell(24);
        c24.setCellStyle(headerStyle);
        c24.setCellValue("通信补贴");
        HSSFCell c25 = r0.createCell(25);
        c25.setCellStyle(headerStyle);
        c25.setCellValue("其它补贴");
        HSSFCell c26 = r0.createCell(26);
        c26.setCellStyle(headerStyle);
        c26.setCellValue("奖金");
        HSSFCell c27 = r0.createCell(27);
        c27.setCellStyle(headerStyle);
        c27.setCellValue("合计");
        HSSFCell c28 = r0.createCell(28);
        c28.setCellStyle(headerStyle);
        c28.setCellValue("计算薪资时间");
        for (int i = 0; i < list.size(); i++) {
            Salaryinfo salaryinfo=list.get(i);
            HSSFRow row = sheet.createRow(i + 1);
            HSSFCell cell0 = row.createCell(0);
            cell0.setCellStyle(intCellStyle);
            cell0.setCellValue(salaryinfo.getSiid());
            HSSFCell cell1 = row.createCell(1);
            cell1.setCellStyle(intCellStyle);
            cell1.setCellValue(salaryinfo.getWorkid());
            row.createCell(2).setCellValue(salaryinfo.getEmployee().getEmpname());
            row.createCell(3).setCellValue(salaryinfo.getDepartment().getDepname());
            row.createCell(4).setCellValue(salaryinfo.getBasicsalary());
            row.createCell(5).setCellValue(salaryinfo.getAbsenteeism());
            row.createCell(6).setCellValue(salaryinfo.getOvertime());
            row.createCell(7).setCellValue(salaryinfo.getBusitrip());
            row.createCell(8).setCellValue(salaryinfo.getEndowment());
            row.createCell(9).setCellValue(salaryinfo.getMedical());
            row.createCell(10).setCellValue(salaryinfo.getUnemployment());
            row.createCell(11).setCellValue(salaryinfo.getInjury());
            row.createCell(12).setCellValue(salaryinfo.getMaternity());
            row.createCell(13).setCellValue(salaryinfo.getAddmedical());
            row.createCell(14).setCellValue(salaryinfo.getHousing());
            row.createCell(15).setCellValue(salaryinfo.getEnterprisep());
            row.createCell(16).setCellValue(salaryinfo.getChildedu());
            row.createCell(17).setCellValue(salaryinfo.getConedu());
            row.createCell(18).setCellValue(salaryinfo.getSermedical());
            row.createCell(19).setCellValue(salaryinfo.getHousingloan());
            row.createCell(20).setCellValue(salaryinfo.getRental());
            row.createCell(21).setCellValue(salaryinfo.getSupportold());
            row.createCell(22).setCellValue(salaryinfo.getTraffic());
            row.createCell(23).setCellValue(salaryinfo.getCatering());
            row.createCell(24).setCellValue(salaryinfo.getCommunication());
            row.createCell(25).setCellValue(salaryinfo.getOther());
            row.createCell(26).setCellValue(salaryinfo.getBonus());
            row.createCell(27).setCellValue(salaryinfo.getSums());
            HSSFCell cell28 = row.createCell(28);
            cell28.setCellStyle(dateCellStyle);
            cell28.setCellValue(salaryinfo.getPayoffdata());
        }
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        HttpHeaders headers = new HttpHeaders();
        try {
            headers.setContentDispositionFormData("attachment", new String("员工历史薪资信息表.xls".getBytes("UTF-8"), "ISO-8859-1"));
            headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
            workbook.write(baos);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ResponseEntity<byte[]>(baos.toByteArray(), headers, HttpStatus.CREATED);
    }
}
