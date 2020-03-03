package com.emperorws.hrmanagement.utils;

import com.emperorws.hrmanagement.model.*;
import org.apache.poi.hpsf.DocumentSummaryInformation;
import org.apache.poi.hpsf.SummaryInformation;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: EmperorWS
 * @Date: 2020/3/2 14:25
 * @Description: 员工薪资信息导入导出工具类
 **/
public class EmpSalPOIUtils {
    public static ResponseEntity<byte[]> employeesalary2Excel(List<Employeesalary> list) {
        //1. 创建一个 Excel 文档
        HSSFWorkbook workbook = new HSSFWorkbook();
        //2. 创建文档摘要
        workbook.createInformationProperties();
        //3. 获取并配置文档信息
        DocumentSummaryInformation docInfo = workbook.getDocumentSummaryInformation();
        //文档类别
        docInfo.setCategory("员工薪资信息");
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
        HSSFSheet sheet = workbook.createSheet("员工薪资信息表");
        //设置列的宽度
        sheet.setColumnWidth(0, 5 * 256);
        sheet.setColumnWidth(1, 12 * 256);
        sheet.setColumnWidth(2, 10 * 256);
        sheet.setColumnWidth(3, 20 * 256);
        sheet.setColumnWidth(4, 12 * 256);
        sheet.setColumnWidth(5, 20 * 256);
        sheet.setColumnWidth(6, 10 * 256);
        sheet.setColumnWidth(7, 10 * 256);
        sheet.setColumnWidth(8, 16 * 256);
        sheet.setColumnWidth(9, 12 * 256);
        sheet.setColumnWidth(10, 15 * 256);
        sheet.setColumnWidth(11, 20 * 256);
        sheet.setColumnWidth(12, 16 * 256);
        sheet.setColumnWidth(13, 14 * 256);
        sheet.setColumnWidth(14, 30 * 256);
        sheet.setColumnWidth(15, 30 * 256);
        sheet.setColumnWidth(16, 30 * 256);
        sheet.setColumnWidth(17, 30 * 256);
        sheet.setColumnWidth(18, 30 * 256);
        sheet.setColumnWidth(19, 30 * 256);
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
        c5.setCellValue("养老保险");
        HSSFCell c6 = r0.createCell(6);
        c6.setCellStyle(headerStyle);
        c6.setCellValue("医疗保险");
        HSSFCell c7 = r0.createCell(7);
        c7.setCellStyle(headerStyle);
        c7.setCellValue("失业保险");
        HSSFCell c8 = r0.createCell(8);
        c8.setCellStyle(headerStyle);
        c8.setCellValue("工伤保险");
        HSSFCell c9 = r0.createCell(9);
        c9.setCellStyle(headerStyle);
        c9.setCellValue("生育保险");
        HSSFCell c10 = r0.createCell(10);
        c10.setCellStyle(headerStyle);
        c10.setCellValue("补充医疗保险");
        HSSFCell c11 = r0.createCell(11);
        c11.setCellStyle(headerStyle);
        c11.setCellValue("住房公积金");
        HSSFCell c12 = r0.createCell(12);
        c12.setCellStyle(headerStyle);
        c12.setCellValue("企业年金");
        HSSFCell c13 = r0.createCell(13);
        c13.setCellStyle(headerStyle);
        c13.setCellValue("福利补贴");
        HSSFCell c14 = r0.createCell(14);
        c14.setCellStyle(headerStyle);
        c14.setCellValue("子女教育");
        HSSFCell c15 = r0.createCell(15);
        c15.setCellStyle(headerStyle);
        c15.setCellValue("继续教育");
        HSSFCell c16 = r0.createCell(16);
        c16.setCellStyle(headerStyle);
        c16.setCellValue("大病医疗");
        HSSFCell c17 = r0.createCell(17);
        c17.setCellStyle(headerStyle);
        c17.setCellValue("住房贷款利息");
        HSSFCell c18 = r0.createCell(18);
        c18.setCellStyle(headerStyle);
        c18.setCellValue("住房租金");
        HSSFCell c19 = r0.createCell(19);
        c19.setCellStyle(headerStyle);
        c19.setCellValue("赡养老人");
        for (int i = 0; i < list.size(); i++) {
            Employeesalary empsal=list.get(i);
            HSSFRow row = sheet.createRow(i + 1);
            HSSFCell cell0 = row.createCell(0);
            cell0.setCellStyle(intCellStyle);
            cell0.setCellValue(empsal.getEsid());
            HSSFCell cell1 = row.createCell(1);
            cell1.setCellStyle(intCellStyle);
            cell1.setCellValue(empsal.getWorkid());
            row.createCell(2).setCellValue(empsal.getEmployee().getEmpname());
            row.createCell(3).setCellValue(empsal.getDepartment().getDepname());
            row.createCell(4).setCellValue(empsal.getBasicsalary());
            row.createCell(5).setCellValue(empsal.getEndowment());
            row.createCell(6).setCellValue(empsal.getMedical());
            row.createCell(7).setCellValue(empsal.getUnemployment());
            row.createCell(8).setCellValue(empsal.getInjury());
            row.createCell(9).setCellValue(empsal.getMaternity());
            row.createCell(10).setCellValue(empsal.getAddmedical());
            row.createCell(11).setCellValue(empsal.getHousing());
            row.createCell(12).setCellValue(empsal.getEnterprisep());
            row.createCell(13).setCellValue(empsal.getWelfare().getWelname());
            row.createCell(14).setCellValue(empsal.getSpeadd1().getSadname());
            row.createCell(15).setCellValue(empsal.getSpeadd2().getSadname());
            row.createCell(16).setCellValue(empsal.getSpeadd3().getSadname());
            row.createCell(17).setCellValue(empsal.getSpeadd4().getSadname());
            row.createCell(18).setCellValue(empsal.getSpeadd5().getSadname());
            row.createCell(19).setCellValue(empsal.getSpeadd6().getSadname());
        }
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        HttpHeaders headers = new HttpHeaders();
        try {
            headers.setContentDispositionFormData("attachment", new String("员工薪资表.xls".getBytes("UTF-8"), "ISO-8859-1"));
            headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
            workbook.write(baos);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ResponseEntity<byte[]>(baos.toByteArray(), headers, HttpStatus.CREATED);
    }

    /**
     * Excel 解析成 员工薪资数据集合
     *
     * @param file
     * @param allWelfares
     * @param allSpeadds
     * @return
     */
    public static List<Employeesalary> excel2Employeesalary(MultipartFile file, List<Welfare> allWelfares, List<Speadd> allSpeadds) {
        List<Employeesalary> list = new ArrayList<>();
        Employeesalary empsal=null;
        try {
            //1. 创建一个 workbook 对象
            HSSFWorkbook workbook = new HSSFWorkbook(file.getInputStream());
            //2. 获取 workbook 中表单的数量
            int numberOfSheets = workbook.getNumberOfSheets();
            for (int i = 0; i < numberOfSheets; i++) {
                //3. 获取表单
                HSSFSheet sheet = workbook.getSheetAt(i);
                //4. 获取表单中的行数
                int physicalNumberOfRows = sheet.getPhysicalNumberOfRows();
                for (int j = 0; j < physicalNumberOfRows; j++) {
                    //5. 跳过标题行
                    if (j == 0) {
                        continue;//跳过标题行
                    }
                    //6. 获取行
                    HSSFRow row = sheet.getRow(j);
                    if (row == null) {
                        continue;//防止数据中间有空行
                    }
                    //7. 获取列数
                    int physicalNumberOfCells = row.getPhysicalNumberOfCells();
                    empsal = new Employeesalary();
                    for (int k = 0; k < physicalNumberOfCells; k++) {
                        HSSFCell cell = row.getCell(k);
                        switch (cell.getCellType()) {
                            case NUMERIC:
                                Integer cellValue0 = Integer.valueOf((int) cell.getNumericCellValue());
                                switch (k) {
                                    case 0:
                                        empsal.setEsid(cellValue0);
                                        break;
                                    case 1:
                                        empsal.setWorkid(cellValue0);
                                        break;
                                    case 4:
                                        empsal.setBasicsalary(cell.getNumericCellValue());
                                        break;
                                }
                                break;
                            case BOOLEAN:
                                Boolean cellValue1 = cell.getBooleanCellValue();
                                switch (k) {
                                    case 5:
                                        empsal.setEndowment(cellValue1);
                                        break;
                                    case 6:
                                        empsal.setMedical(cellValue1);
                                        break;
                                    case 7:
                                        empsal.setUnemployment(cellValue1);
                                        break;
                                    case 8:
                                        empsal.setInjury(cellValue1);
                                        break;
                                    case 9:
                                        empsal.setMaternity(cellValue1);
                                        break;
                                    case 10:
                                        empsal.setAddmedical(cellValue1);
                                        break;
                                    case 11:
                                        empsal.setHousing(cellValue1);
                                        break;
                                    case 12:
                                        empsal.setEnterprisep(cellValue1);
                                        break;
                                }
                                break;
                            case STRING:
                                String cellValue2 = cell.getStringCellValue();
                                switch (k) {
                                    case 13:
                                        int welfareIndex = allWelfares.indexOf(new Welfare(cellValue2));
                                        empsal.setWelid(allWelfares.get(welfareIndex).getWelid());
                                        break;
                                    case 14:
                                        int speaddIndex1 = allSpeadds.indexOf(new Speadd(cellValue2));
                                        empsal.setChildedu(allSpeadds.get(speaddIndex1).getSadid());
                                        break;
                                    case 15:
                                        int speaddIndex2 = allSpeadds.indexOf(new Speadd(cellValue2));
                                        empsal.setConedu(allSpeadds.get(speaddIndex2).getSadid());
                                        break;
                                    case 16:
                                        int speaddIndex3 = allSpeadds.indexOf(new Speadd(cellValue2));
                                        empsal.setSermedical(allSpeadds.get(speaddIndex3).getSadid());
                                        break;
                                    case 17:
                                        int speaddIndex4 = allSpeadds.indexOf(new Speadd(cellValue2));
                                        empsal.setHousingloan(allSpeadds.get(speaddIndex4).getSadid());
                                        break;
                                    case 18:
                                        int speaddIndex5 = allSpeadds.indexOf(new Speadd(cellValue2));
                                        empsal.setRental(allSpeadds.get(speaddIndex5).getSadid());
                                        break;
                                    case 19:
                                        int speaddIndex6 = allSpeadds.indexOf(new Speadd(cellValue2));
                                        empsal.setSupportold(allSpeadds.get(speaddIndex6).getSadid());
                                        break;
                                }
                                break;
                        }
                    }
                    list.add(empsal);
                }
            }
        }catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }
}
