package cn.edu.sdjzu.xg.xkgl.controller.sysAdmin.teacherManage;

import cn.edu.sdjzu.xg.xkgl.domain.ProTitle;
import cn.edu.sdjzu.xg.xkgl.domain.Teacher;
import cn.edu.sdjzu.xg.xkgl.service.ProTitleService;
import cn.edu.sdjzu.xg.xkgl.service.TeacherService;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@WebServlet("/excelInputTeacherController")
public class ExcelInputTeacherController extends HttpServlet {
    private File fileUpload; //与页面上属性名相同
    private String fileUploadFileName; //文件名+FileName
    private String fileUploadContentType; //文件名+ContentType
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        FileInputStream fileIn = new FileInputStream(new File(
                "E:\\1all\\项目测试1\\xkgl\\web\\WEB-INF\\file\\测试.xlsx"));
        //根据指定的文件输入流导入Excel从而产生Workbook对象
        Workbook wb0 = new XSSFWorkbook(fileIn);

        //获取Excel文档中的第一个表单
        Sheet sht0 = wb0.getSheetAt(0);
        //对Sheet中的每一行进行迭代
        for (Row r : sht0) {

            //如果当前行的行号（从0开始）未达到2（第三行）则从新循环
            if(r.getRowNum()<1){
                continue;
            }

            if(this.checkRowNull(r)==1) {
                    break;
                } else{
                    try {
                        //取出当前行第1个单元格数据，并封装在name属性上
                        String name = r.getCell(0).getStringCellValue();

                        r.getCell(1).setCellType(Cell.CELL_TYPE_STRING);
                        String no = r.getCell(1).getStringCellValue();

                        String sex = r.getCell(2).getStringCellValue();

                        r.getCell(3).setCellType(Cell.CELL_TYPE_STRING);
                        String proTitle_des = r.getCell(3).getStringCellValue();
                        ProTitle proTitle = ProTitleService.getInstance().findProTitle(1);
                        //创建实体类
                        Teacher teacher = new Teacher(no, "123456", name, no, sex, proTitle);
                        TeacherService.getInstance().add(teacher);
                    } catch(SQLException e){
                        e.printStackTrace();
                    }
                }
        }
        fileIn.close();

        request.setAttribute("message","导入成功");
        request.getRequestDispatcher("/pages/error.jsp").forward(request,response);
    }
    //判断行为空
    private int checkRowNull(Row r) {
        int num = 0;
        Iterator<Cell> cellItr =r.iterator();
        while(cellItr.hasNext()){
            Cell c =cellItr.next();
            if(c.getCellType() == 0){
                num++;
            }
        }
        return num;
    }
}
