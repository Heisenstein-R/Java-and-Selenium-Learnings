package com.testNGpractice;

import java.util.ArrayList;
import com.test.util.XLS_Reader;

public class UtilExcelSheetReader {

	static XLS_Reader reader;

	public static ArrayList<Object[]> getExcelData() {

		ArrayList<Object[]> mydata = new ArrayList<Object[]>();
		try {
			reader = new XLS_Reader(
					"C:\\Users\\91938\\eclipse-workspace\\SeleniumLearnings\\src\\com\\excelsheetpackage\\DataForTestNGDataProviderTest.xlsx");
		} catch (Exception e) {
			e.printStackTrace();
		}
		for (int rowNum = 2; rowNum <= reader.getRowCount("DataForTestNGDataProviderTest"); rowNum++) {

			String title = reader.getCellData("DataForTestNGDataProviderTest", "title", rowNum);
			String firstname = reader.getCellData("DataForTestNGDataProviderTest", "firstname", rowNum);
			String lastname = reader.getCellData("DataForTestNGDataProviderTest", "lastname", rowNum);
			String mail = reader.getCellData("DataForTestNGDataProviderTest", "mail", rowNum);
			String password = reader.getCellData("DataForTestNGDataProviderTest", "password", rowNum);
			String phone = reader.getCellData("DataForTestNGDataProviderTest", "phone", rowNum);
			String gender = reader.getCellData("DataForTestNGDataProviderTest", "gender", rowNum);
			String address1 = reader.getCellData("DataForTestNGDataProviderTest", "address1", rowNum);
			String address2 = reader.getCellData("DataForTestNGDataProviderTest", "address2", rowNum);
			String city = reader.getCellData("DataForTestNGDataProviderTest", "city", rowNum);
			String state = reader.getCellData("DataForTestNGDataProviderTest", "state", rowNum);
			String country = reader.getCellData("DataForTestNGDataProviderTest", "country", rowNum);
			String textarea = reader.getCellData("DataForTestNGDataProviderTest", "textarea", rowNum);
			String yesorno = reader.getCellData("DataForTestNGDataProviderTest", "yesorno", rowNum);

			Object ob[] = { title, firstname, lastname, mail, password, phone, gender, address1, address2, city, state,
					country, textarea, yesorno };
			mydata.add(ob);
		}
		return mydata;
	}

}
