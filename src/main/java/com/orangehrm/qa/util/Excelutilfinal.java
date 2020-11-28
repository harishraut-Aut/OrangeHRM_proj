package com.orangehrm.qa.util;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

//i have created this utility ok to use in our program 
//i googled this methods.. 
public class Excelutilfinal
	{
		// simple utility file ihave created using poiu libraries ..

		static XSSFWorkbook workbook;
		static XSSFSheet sheet;

		// parametrizing constructor to pass excelfile path and sheetname..
		public Excelutilfinal(String excelPath, String sheetName)
			{
				try
					{
						workbook = new XSSFWorkbook(excelPath);
						sheet = workbook.getSheet(sheetName);

					}
				catch (Exception e)
					{
						e.printStackTrace();

					}

			}

		public static int getRowCount()
			{

				int rowcount = 0;

				try
					{

						rowcount = sheet.getPhysicalNumberOfRows();
						System.out.println("the no of rows are : " + rowcount + "\n");

					}
				catch (Exception exp)
					{
						System.out.println(exp.getMessage());
						System.out.println(exp.getCause());
						exp.printStackTrace();

					}
				return rowcount;

			}

		public static int getColCount()
			{
				int columncount = 0;

				try
					{

						columncount = sheet.getRow(0).getPhysicalNumberOfCells();
						System.out.println("the no of columns are : " + columncount + "\n");

					}
				catch (Exception exp)
					{
						System.out.println(exp.getMessage());
						System.out.println(exp.getCause());
						exp.printStackTrace();

					}
				return columncount;

			}

		public static String getCelldatastring(int rownum, int colnum)
			{
				String celldata = null;
				try
					{
						celldata = sheet.getRow(rownum).getCell(colnum).getStringCellValue();
						// both column and row values starts from 0
						// System.out.println(celldata);

					}
				catch (Exception exp)
					{
						System.out.println(exp.getMessage());
						System.out.println(exp.getCause());
						exp.printStackTrace();

					}
				return celldata;

			}

		public static double getCelldatanumeric(int rowNum, int colNum)
			{
				double celldata = 0;
				try
					{
						celldata = sheet.getRow(rowNum).getCell(colNum).getNumericCellValue();
						// both column and row values starts from 0
						// System.out.println(celldata);

					}
				catch (Exception exp)
					{
						System.out.println(exp.getMessage());
						System.out.println(exp.getCause());
						exp.printStackTrace();

					}
				return celldata;

			}

	}
