package com.emperorws.hrmanagement.utils;

import com.emperorws.hrmanagement.model.Attelogmon;
import org.apache.poi.hpsf.DocumentSummaryInformation;
import org.apache.poi.hpsf.SummaryInformation;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

/**
 * @Author: EmperorWS
 * @Date: 2020/3/15 17:42
 * @Description: 员工考勤月度统计信息导出工具类
 **/
public class AttelogmonPOIUtils {
    public static ResponseEntity<byte[]> attelogmon2Excel(List<Attelogmon> list){
        //1. 创建一个 Excel 文档
        HSSFWorkbook workbook = new HSSFWorkbook();
        //2. 创建文档摘要
        workbook.createInformationProperties();
        //3. 获取并配置文档信息
        DocumentSummaryInformation docInfo = workbook.getDocumentSummaryInformation();
        //文档类别
        docInfo.setCategory("员工考勤月度统计信息");
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
        headerStyle.setAlignment(HorizontalAlignment.CENTER);
        headerStyle.setVerticalAlignment(VerticalAlignment.CENTER);
        HSSFCellStyle dateCellStyle = workbook.createCellStyle();
        dateCellStyle.setDataFormat(HSSFDataFormat.getBuiltinFormat("m/d/yy"));
        HSSFDataFormat format= workbook.createDataFormat();
        HSSFCellStyle datetimeCellStyle = workbook.createCellStyle();
        datetimeCellStyle.setDataFormat(format.getFormat("yyyy/MM/dd HH:mm:ss"));
        HSSFCellStyle intCellStyle = workbook.createCellStyle();
        intCellStyle.setDataFormat(HSSFDataFormat.getBuiltinFormat("00000000000"));
        HSSFSheet sheet = workbook.createSheet("员工考勤月度统计信息表");
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
        sheet.setColumnWidth(13, 20 * 256);
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
        c4.setCellValue("总工时");
        HSSFCell c5 = r0.createCell(5);
        c5.setCellStyle(headerStyle);
        c5.setCellValue("正常工时");
        HSSFCell c6 = r0.createCell(6);
        c6.setCellStyle(headerStyle);
        c6.setCellValue("缺勤工时");
        HSSFCell c7 = r0.createCell(7);
        c7.setCellStyle(headerStyle);
        c7.setCellValue("请假工时");
        HSSFCell c8 = r0.createCell(8);
        c8.setCellStyle(headerStyle);
        c8.setCellValue("调休工时");
        HSSFCell c9 = r0.createCell(9);
        c9.setCellStyle(headerStyle);
        c9.setCellValue("出差工时");
        HSSFCell c10 = r0.createCell(10);
        c10.setCellStyle(headerStyle);
        c10.setCellValue("加班工时");
        HSSFCell c11 = r0.createCell(11);
        c11.setCellStyle(headerStyle);
        c11.setCellValue("被统计月");
        HSSFCell c12 = r0.createCell(12);
        c12.setCellStyle(headerStyle);
        c12.setCellValue("被统计月");
        HSSFCell c13 = r0.createCell(13);
        c13.setCellStyle(headerStyle);
        c13.setCellValue("统计时间");
        for (int i = 0; i < list.size(); i++) {
            Attelogmon attelogmon=list.get(i);
            HSSFRow row = sheet.createRow(i + 1);
            HSSFCell cell0 = row.createCell(0);
            cell0.setCellStyle(intCellStyle);
            cell0.setCellValue(attelogmon.getAttelogmonid());
            HSSFCell cell1 = row.createCell(1);
            cell1.setCellStyle(intCellStyle);
            cell1.setCellValue(attelogmon.getWorkid());
            row.createCell(2).setCellValue(attelogmon.getEmployee().getEmpname());
            row.createCell(3).setCellValue(attelogmon.getDepartment().getDepname());
            row.createCell(4).setCellValue(attelogmon.getTotalh());
            row.createCell(5).setCellValue(attelogmon.getNormalh());
            row.createCell(6).setCellValue(attelogmon.getAbsenth());
            row.createCell(7).setCellValue(attelogmon.getLeaveh());
            row.createCell(8).setCellValue(attelogmon.getVacateh());
            row.createCell(9).setCellValue(attelogmon.getBusinessh());
            row.createCell(10).setCellValue(attelogmon.getOvertimeh());
            HSSFCell cell11 = row.createCell(11);
            cell11.setCellStyle(dateCellStyle);
            cell11.setCellValue(attelogmon.getFirstday());
            HSSFCell cell12 = row.createCell(12);
            cell12.setCellStyle(dateCellStyle);
            cell12.setCellValue(attelogmon.getEndday());
            HSSFCell cell13 = row.createCell(13);
            cell13.setCellStyle(datetimeCellStyle);
            cell13.setCellValue(attelogmon.getCaldate());
        }
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        HttpHeaders headers = new HttpHeaders();
        try {
            headers.setContentDispositionFormData("attachment", new String("员工考勤月度统计信息表.xls".getBytes("UTF-8"), "ISO-8859-1"));
            headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
            workbook.write(baos);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ResponseEntity<byte[]>(baos.toByteArray(), headers, HttpStatus.CREATED);
    }
}
