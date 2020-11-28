package com.orangehrm.qa.dataproviders;

import org.testng.annotations.DataProvider;

import com.orangehrm.qa.util.Excelutilfinal;

public class LoginPageDD_dataprovider
	{

		// this you can do in same class but avoid confusion i've created this class

		@DataProvider(name = "test2data")
		public Object[][] getdata()
			{
				String excelPath = "D:\\Classwork\\OrangeHRMTest\\src\\main\\java\\com\\orangehrm\\qa\\testdata\\OrangeHRM_DD_approach.xlsx";
				String sheetName = "LoginPage";
				Object data[][] = testdata(excelPath, sheetName);
				return data;
			}

		// this code you can put in baseclass or util class since if using different
		// excel files cause unstable poi api im putting it here this will extract the
		// data one by one from excel file
		public Object[][] testdata(String excelPath, String sheetName)

			{

				Excelutilfinal excel = new Excelutilfinal(excelPath, sheetName);

				int rowcount = excel.getRowCount();
				int colcount = excel.getColCount();

				Object data[][] = new Object[rowcount - 1][colcount];

				for (int i = 1; i < rowcount; i++)
					{
						for (int j = 0; j < colcount; j++)
							{
								// always use getcelldatastring method cause it will give you string and other
								// integers also use ' this symbol before any number it will be considered as
								// string also dont open excel file during operation
								String celldata = excel.getCelldatastring(i, j);
								// System.out.print(celldata+" |");
								data[i - 1][j] = celldata;
							}
						// System.out.println();

					}
				return data;
			}
	}