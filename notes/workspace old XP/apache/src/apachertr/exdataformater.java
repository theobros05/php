package apachertr;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Iterator;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class exdataformater {

    public static void main(String ar[]) {
        exdataformater rw = new exdataformater();
        rw.readDataFromExcel();

    }
    Object[][] data = null;

    public File getFile() throws FileNotFoundException {
        File here = new File("D:\\Data.xlsx");
        return new File(here.getAbsolutePath());

    }

    public Object[][] readDataFromExcel() {
        final DataFormatter df = new DataFormatter();
        try {

            FileInputStream file = new FileInputStream(getFile());
            //Create Workbook instance holding reference to .xlsx file
            XSSFWorkbook workbook = new XSSFWorkbook(file);

            //Get first/desired sheet from the workbook
            XSSFSheet sheet = workbook.getSheetAt(0);

            //Iterate through each rows one by one
            Iterator<Row> rowIterator = sheet.iterator();

            int rownum = 0;
            int colnum = 0;
            Row r=rowIterator.next();

            int rowcount=sheet.getLastRowNum();
            int colcount=r.getPhysicalNumberOfCells();
            data = new Object[rowcount][colcount];
            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();

                //For each row, iterate through all the columns
                Iterator<Cell> cellIterator = row.cellIterator();
                colnum = 0;
                while (cellIterator.hasNext()) {

                    Cell cell = cellIterator.next();
                    
                    DataFormatter formatter = new DataFormatter(  );
                    
                    String valueAsString = df.formatCellValue(cell);
                    
                    //Check the cell type and format accordingly
                    data[rownum][colnum] =  df.formatCellValue(cell);
                    System.out.print(df.formatCellValue(cell));
                    colnum++;
                    System.out.println("-");
                }
                rownum++;
                System.out.println("");
            }
            file.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return data;
    }
}