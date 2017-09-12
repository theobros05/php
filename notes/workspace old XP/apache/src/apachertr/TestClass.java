package apachertr;
import java.io.File;
import java.io.FileOutputStream;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class TestClass {
    public static void main(String[] args){
        Workbook wb = new XSSFWorkbook();
        Sheet sheet = wb.createSheet("coverageData");
        int rownum = 0,cellnum=0;
        Row row1 = sheet.createRow((short)rownum++);
        //Set Color style start
        CellStyle row1style = wb.createCellStyle();
        row1style.setFillBackgroundColor(IndexedColors.LIGHT_GREEN.getIndex());
        row1style.setFillPattern(CellStyle.BIG_SPOTS);
        //Set Color style end
        Cell cell10 = row1.createCell((short)cellnum++);
        cell10.setCellStyle(row1style);
        cell10.setCellValue("cell data");
        try{             
            //Write the workbook in file system
            FileOutputStream out = new FileOutputStream(new File("Spreadsheet.xlsx"));
            wb.write(out); 
            out.close(); 
            System.out.println("Spreadsheet.xlsx written successfully on disk."); 
        } catch (Exception e) { e.printStackTrace(); } 
    }}