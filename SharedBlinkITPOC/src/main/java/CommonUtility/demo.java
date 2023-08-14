package CommonUtility;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class demo {
	
	public static void main(String[] args) {
		rupeesSplit("MRP ₹ (Incl. of all taxes): ₹575.00");
	}
	public static String rupeesSplit(String inputvalue) {

		String str = inputvalue;
		String value = "";
		for (int i = 0; i < str.length(); i++) {
			Boolean flag = Character.isDigit(str.charAt(i));

			if (flag) {
//				System.out.println("'" + str.charAt(i) + "' is a number");
				value = value + str.charAt(i);
			}

			else {
				int compare = Character.compare(str.charAt(i), '.');
				if (compare == 0) {
					value = value + str.charAt(i);
				}
//				System.out.println("'" + str.charAt(i) + "' is a letter");

			}
		}

//		System.out.println(value);

		if (value.contains(".")) {

			String newValue = value.trim();

			int compare = Character.compare(newValue.charAt(0), '.');

			if (compare == 0) {
				newValue = newValue.substring(1);
			}

//			System.out.println(newValue);

			value = "";

			String[] split = newValue.split("\\.");
			System.out.println(split.length);

			if (split.length == 3) {
				value = split[1];
			} else if (split.length == 2) {
				value = split[0];
			} else if (split.length == 1) {
				value = split[0];
			}

		}

		System.out.println(value);

		return value;

	}
	
//	public XSSFWorkbook writeInWorkbookHeader(String name, XSSFWorkbook workbook) {
//
//		XSSFSheet sheet = workbook.getSheetAt(0);
//
//		int rowNum = sheet.getPhysicalNumberOfRows();
//
//		System.out.println(rowNum);
//
//		List<String> header = new ArrayList<String>();
//
//		header.add("Input Name");
//		header.add("Brand Name");
//		header.add("Title");
//		header.add("Size");
//		header.add(name + "_ID");
//		header.add(name + "_URL");
//		header.add(name + "_MRP");
//		header.add(name + "_selling_price");
//		header.add(name + "_availability");
//
//		Row r = sheet.createRow(rowNum);
//
//		for (int i = 0; i < header.size(); i++) {
//
//			Cell col = r.createCell(i);
//			col.setCellValue(header.get(i));
//		}
//
//		return workbook;
//	}

	public XSSFSheet writeIntoSheet(XSSFSheet sheet, List<List<String>> productData) {


		int rowNum = sheet.getPhysicalNumberOfRows();

		System.out.println("Non-Header: " + rowNum);

		for (List<String> list : productData) {

			Row r1 = sheet.createRow(rowNum);

			for (int j = 0; j < list.size(); j++) {

				Cell col = r1.createCell(j);
				col.setCellValue(list.get(j));
			}
			
			rowNum++;

		}
		return sheet;
	}

	

	
	public void writeIntoExcel(Workbook workbook, String OutputDataFilePath) {

		File file = new File(OutputDataFilePath);
		FileOutputStream outstream = null;

		try {
			outstream = new FileOutputStream(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		try {
			workbook.write(outstream);
		} catch (IOException e) {
			e.printStackTrace();
		}

		try {
			outstream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		try {
			workbook.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	
	public List<String> oldvalues(Row row){
		
		List<String> oldvalues = new ArrayList<String>();
		
		String InputBrandName = row.getCell(0).getStringCellValue();
		String InputPid = row.getCell(1).getStringCellValue();
		String InputCity = row.getCell(2).getStringCellValue();
		String InputTitle = row.getCell(3).getStringCellValue();
		String InputSize = row.getCell(4).getStringCellValue();
		String OldProductCode = row.getCell(5).getStringCellValue();
		String OldName = row.getCell(6).getStringCellValue();
		String OldMRP = row.getCell(7).getStringCellValue();
		String OldSP = row.getCell(8).getStringCellValue();
		String OldUOM = row.getCell(9).getStringCellValue();
		String OldMultiplier = row.getCell(10).getStringCellValue();
		String OldAvailability = row.getCell(11).getStringCellValue();
		
		oldvalues.add(InputBrandName);
		oldvalues.add(InputPid);
		oldvalues.add(InputCity);
		oldvalues.add(InputTitle);
		oldvalues.add(InputSize);
		oldvalues.add(OldProductCode);
		oldvalues.add(OldName);
		oldvalues.add(OldMRP);
		oldvalues.add(OldSP);
		oldvalues.add(OldUOM);
		oldvalues.add(OldMultiplier);
		oldvalues.add(OldAvailability);
		
		
		
		return oldvalues;
		
		
	}
		
	
	
	

}
