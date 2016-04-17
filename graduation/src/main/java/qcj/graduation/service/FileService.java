package qcj.graduation.service;

import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import qcj.graduation.model.Student;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Qiao on 2016/4/12.
 */
@Service
public class FileService {

    @Autowired
    private StudentService studentService;

    public void download(HttpServletResponse response, Boolean flag) throws IOException {
        String tableName;
        List<Student> students = new ArrayList<>();
        if (flag) {
            students = studentService.getSignInList();
            tableName = "已签到人员";
        } else {
            students = studentService.getNotSignInList();
            tableName = "未签到人员";
        }


        //创建HSSFWorkbook对象(excel的文档对象)
        HSSFWorkbook wkb = new HSSFWorkbook();
        //建立新的sheet对象（excel的表单）
        HSSFSheet sheet = wkb.createSheet("签到表");
        sheet.setColumnWidth(3, 100 * 50);
        //在sheet里创建第一行，参数为行索引(excel的行)，可以是0～65535之间的任何一个
        HSSFRow row1 = sheet.createRow(0);
        //创建单元格（excel的单元格，参数为列索引，可以是0～255之间的任何一个
        HSSFCell cell = row1.createCell(0);
        //居中
        cell.getCellStyle().setAlignment(HSSFCellStyle.ALIGN_CENTER);
        //设置单元格内容
        cell.setCellValue(tableName);
        //合并单元格CellRangeAddress构造参数依次表示起始行，截至行，起始列， 截至列
        sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, 3));


        //在sheet里创建第二行
        HSSFRow row2 = sheet.createRow(1);
        //创建单元格并设置单元格内容
        row2.createCell(0).setCellValue("学号");
        row2.createCell(1).setCellValue("班级");
        row2.createCell(2).setCellValue("姓名");
        row2.createCell(3).setCellValue("联系方式");
        //在sheet里创建第三行
        for (int i = 0; i < students.size(); i++) {
            Student student = students.get(i);
            HSSFRow row = sheet.createRow(i+2);
            row.createCell(0).setCellValue(student.getCode());
            row.createCell(1).setCellValue(student.getClassCode());
            row.createCell(2).setCellValue(student.getName());
            row.createCell(3).setCellValue(student.getCellphone());
        }

        //输出Excel文件
        OutputStream output = response.getOutputStream();
        response.reset();
        response.setHeader("Content-disposition", "attachment; filename=" + new String(tableName.getBytes("GBK"),"ISO8859-1") + ".xls");
        response.setContentType("application/msexcel");
        wkb.write(output);
        output.close();
    }
}
