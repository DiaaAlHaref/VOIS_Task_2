package fileReaders;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import utilities.HandleExceptions;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ReadFromExcelSheet {

    /**
     * Method return Test Data from file using Hashmap class
     * @return obj array of object[][] key, value form
     */
    public static Object[][] returnData() {

        File file = new File("src//test//resources//DataDriven//TestData.xlsx");

        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(file); //Load File

        } catch (FileNotFoundException e) {
            HandleExceptions.FileNotFoundExceptionHandling(e);
        }


        XSSFWorkbook wb = null;
        try {
            wb = new XSSFWorkbook(fileInputStream); //Page tab
        } catch (IOException e) {
            HandleExceptions.IOExceptionHandling(e);
        }


        XSSFSheet sheet = wb.getSheetAt(0);  //Sheet number

        int lastRowNum = sheet.getLastRowNum();
        int lastCellNum = sheet.getRow(0).getLastCellNum();    //Matrix length

        Object[][] obj = new Object[lastRowNum][1];          //2d array

        for (int i = 0; i < lastRowNum; i++) {
            Map<Object, Object> dataMap = new HashMap<>();
            for (int j = 0; j < lastCellNum; j++) {
                dataMap.put(sheet.getRow(0).getCell(j).toString(), sheet.getRow(i + 1).getCell(j).toString());

            }
            obj[i][0] = dataMap;
        }
        return obj;
    }
}
