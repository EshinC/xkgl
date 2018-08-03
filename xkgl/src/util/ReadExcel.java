package util;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * @describe 通过路径获取Excel文件，并将Excel文件数据传入DAO
 * @author zhutianpeng
 *
 */
public class ReadExcel {
    /**
     *


 Map<Integer,String> map = new HashMap<Integer,String>();
 List<Map<Integer,String>> list = new ArrayList<Map<Integer,String>>();
 HSSFWorkbook workbook;
 //  ConnectorA a = new ConnectorA();

 public void readExcelFile(String filePath){
 try {
 FileInputStream excelFile = new FileInputStream(filePath);
 workbook = new HSSFWorkbook(excelFile);
 //读入Excel文件的第一个表
 HSSFSheet sheet = workbook.getSheetAt(0);
 //从文件第二行开始读取，第一行为标识行
 for(int i=1;i<=sheet.getLastRowNum();i++){
 System.out.println("行数："+sheet.getPhysicalNumberOfRows());
 HSSFRow row = sheet.getRow(i);
 if(row==null){
 continue;
 }
 for(int j=1;j<=row.getPhysicalNumberOfCells();j++){
 if(row.getCell(j)!=null){
 // 注意：一定要设成这个，否则可能会出现乱码
 //                      row.getCell(j).setEncoding(HSSFCell.ENCODING_UTF_16);
 String str = getCellValue(row.getCell(j));
 map.put(j,str);
 }
 }
 UploadExcelImpl ue = new UploadExcelImpl();
 ue.uploadExcel(map);
 map.clear();
 }
 } catch (FileNotFoundException e) {
 e.printStackTrace();
 System.out.println("【Excel路径有误，请重新确认Excel路径...】");
 } catch (IOException e) {
 e.printStackTrace();
 System.out.println("【文件输入有误，请重新确定您要加入的文件...】");
 }
 }

 //传入cell的值，进行cell值类型的判断，并返回String类型
 private static String getCellValue(HSSFCell cell){
 String value = null;
 //简单的查检列类型
 System.out.println("cell.getCellType():"+cell.getCellType());
 switch(cell.getCellType())  {

 case HSSFCell.CELL_TYPE_STRING://字符串
 System.out.println("HSSFCell.CELL_TYPE_STRING:"+HSSFCell.CELL_TYPE_STRING);
 value = cell.getRichStringCellValue().toString();
 break;
 case HSSFCell.CELL_TYPE_NUMERIC://数字
 System.out.println("HSSFCell.CELL_TYPE_NUMERIC:"+HSSFCell.CELL_TYPE_NUMERIC);
 long dd = (long)cell.getNumericCellValue();
 value = dd+"";
 break;
 case HSSFCell.CELL_TYPE_BLANK:
 System.out.println("HSSFCell.CELL_TYPE_BLANK:"+HSSFCell.CELL_TYPE_BLANK);
 value = "";
 break;
 case HSSFCell.CELL_TYPE_FORMULA:
 System.out.println("HSSFCell.CELL_TYPE_FORMULA:"+HSSFCell.CELL_TYPE_FORMULA);
 value = String.valueOf(cell.getCellFormula());
 break;
 case HSSFCell.CELL_TYPE_BOOLEAN://boolean型值
 System.out.println("HSSFCell.CELL_TYPE_BOOLEAN:"+HSSFCell.CELL_TYPE_BOOLEAN);
 value = String.valueOf(cell.getBooleanCellValue());
 break;
 case HSSFCell.CELL_TYPE_ERROR:
 System.out.println("HSSFCell.CELL_TYPE_ERROR:"+HSSFCell.CELL_TYPE_ERROR);
 value = String.valueOf(cell.getErrorCellValue());
 break;
 default:
 System.out.println("default");
 break;
 }
 return value;
 }
 }*/

 }