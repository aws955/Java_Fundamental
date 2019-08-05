package java_20190805;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

//1. c:\dev\test\test1.txt 파일을 읽어온다. BufferedReader
//2. BufferedReader의 readLine() 메서드를 이용해서 한줄씩 읽어온다.
//3. 한줄 읽은 문자열을 String의 split("#")을 이용해서 String[] 반환받는다.
//4. [0] = >cell 입력한다. 
//5. 엑셀파일명 : c:\dev\test\test2.xls 파일로 저장한다.

public class ExcelDemo2 {
	public static void main(String[] args) {

		try {

			HSSFWorkbook workbook = null;
			FileReader fr = null;
			BufferedReader br = null;
			FileOutputStream fos = null;
				fr = new FileReader("c:\\dev\\test\\test1.txt");
				br = new BufferedReader(fr);

				workbook = new HSSFWorkbook();
				HSSFSheet sheet = workbook.createSheet("새파일1");
				HSSFSheet sheet1 = workbook.createSheet("새파일2");

				String readline = null;
				int j = 0;
				while ((readline = br.readLine()) != null) {
					String[] strArray = readline.split("#");
					HSSFRow row = sheet.createRow(j);
					HSSFRow row1 = sheet1.createRow(j);
					for (int i = 0; i < strArray.length; i++) {
						HSSFCell cell = row.createCell(i);
						HSSFCell cell1 = row1.createCell(i);
						cell.setCellValue(strArray[i]);
						cell1.setCellValue(strArray[i]);
					}
					j++;
				}
				
				fos = new FileOutputStream("c:\\dev\\test\\test2.xls");
				workbook.write(fos);

			fos.close();
			br.close();
			workbook.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
