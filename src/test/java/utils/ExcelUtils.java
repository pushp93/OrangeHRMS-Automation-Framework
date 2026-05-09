package utils;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {

	
	static XSSFWorkbook workbook;
    static XSSFSheet sheet;

    public static Object[][] getExcelData(String fileName,
                                          String sheetName)
            throws IOException {

        String path = System.getProperty("user.dir")
                + "/src/test/resources/testdata/"
                + fileName;

        FileInputStream fis = new FileInputStream("D:\\testingworkspace\\OrangeHRMS\\src\\test\\resources\\testdata\\LoginData.xlsx");

        workbook = new XSSFWorkbook(fis);

        sheet = workbook.getSheet("logindataset");

        int rowCount = sheet.getPhysicalNumberOfRows();

        int colCount = sheet.getRow(0).getLastCellNum();

        Object[][] data = new Object[rowCount - 1][colCount];

        DataFormatter formatter = new DataFormatter();

        for(int i = 1; i < rowCount; i++) {

            for(int j = 0; j < colCount; j++) {

                data[i - 1][j] =
                        formatter.formatCellValue(
                                sheet.getRow(i).getCell(j));
            }
        }

        workbook.close();

        return data;
    }
}

