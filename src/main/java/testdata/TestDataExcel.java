package testdata;

import constants.StringConstants;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public final class TestDataExcel {

    public static Object[][] readTestData(){
        Object[][] data = new Object[1][8];

        try {
            File file = new File(StringConstants.CUSTOMER_DATA_FILE_PATH);
            FileInputStream inputStream = new FileInputStream(file);
            XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
            XSSFSheet customer_sheet = workbook.getSheet("customer_details");
            int lastCellNum = customer_sheet.getRow(0).getLastCellNum();
            for (int i = 1; i <= customer_sheet.getLastRowNum(); i++) {
                for (int j = 0; j< lastCellNum; j++) {
                    data[i-1][j] = customer_sheet.getRow(i).getCell(j).getStringCellValue();
                }
            }
        }catch (FileNotFoundException e){
            System.out.println(e.getStackTrace());
        } catch (IOException e) {
            System.out.println(e.getStackTrace());
        }

        return data;
    }

    public static void main(String[] args){
        System.out.println("test");
        readTestData();
    }

}
