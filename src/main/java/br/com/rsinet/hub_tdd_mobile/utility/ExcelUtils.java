package br.com.rsinet.hub_tdd_mobile.utility;

import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {

	private static XSSFSheet ExcelWSheet;

	private static XSSFWorkbook ExcelWBook;

	private static XSSFCell Cell;

	// This method is to set the File path and to open the Excel file, Pass Excel
	// Path and Sheetname as Arguments to this method

	public static void setExcelFile(String Path, String SheetName) throws Exception {

		try {

			// Open the Excel file
			FileInputStream ExcelFile = new FileInputStream(Path);

			// Access the required test data sheet
			ExcelWBook = new XSSFWorkbook(ExcelFile);

			ExcelWSheet = ExcelWBook.getSheet(SheetName);

		} catch (Exception e) {

			throw (e);

		}

	}

//This method is to read the test data from the Excel cell, in this we are passing parameters as Row num and Col num

	public static String getCellData(int RowNum, int ColNum) throws Exception {

		try {

			Cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);

			String CellData = Cell.getStringCellValue();

			return CellData;

		} catch (Exception e) {

			return "";

		}

	}
	
	/* Metodo que recebe o arquivo do Excel e informa qual planilha contem a Massa de Dados */
	public static void setupMassa(String planilha) throws Exception {
		ExcelUtils.setExcelFile(Constant.Path_TestData + Constant.File_TestData, planilha);
	}

	public static String usuario() throws Exception {
		return ExcelUtils.getCellData(1, 0);
	}

	public static String email() throws Exception {
		return ExcelUtils.getCellData(1, 1);
	}

	public static String senha() throws Exception {
		return ExcelUtils.getCellData(1, 2);
	}

	public static String confirmSenha() throws Exception {
		return ExcelUtils.getCellData(1, 3);
	}
	
	public static String primeiroNome() throws Exception {
		return ExcelUtils.getCellData(1, 4);
	}
	
	public static String ultimoNome() throws Exception {
		return ExcelUtils.getCellData(1, 5);
	}
	
	public static String phone() throws Exception {
		return ExcelUtils.getCellData(1, 6);
	}
	
	public static String pais() throws Exception {
		return ExcelUtils.getCellData(1, 7);
	}
	
	public static String cidade() throws Exception {
		return ExcelUtils.getCellData(1, 8);
	}
	
	public static String endereco()throws Exception {
		return ExcelUtils.getCellData(1, 9);
	}
	
	public static String estado() throws Exception {
		return ExcelUtils.getCellData(1, 10);
	}
	
	public static String cep() throws Exception {
		return ExcelUtils.getCellData(1, 11);
	}
	
//	public static String usuarioJaExistente() throws Exception {
//		return ExcelUtils.getCellData(13,1);
//	}
//	
//	/* Dados extraidos do Excel e utilizados no Campo de Pesquisa e Tela Principal */
//	public static String categoria() throws Exception {
//		return ExcelUtils.getCellData(3, 0);
//	}
//	
//	public static String produtoValido() throws Exception {
//		return ExcelUtils.getCellData(3, 1);
//	}
//	
//	public static String produtoInvalido() throws Exception {
//		return ExcelUtils.getCellData(11, 0);
//	}
//	
//	public static String mensagemEsperadaParaProdutoInvalidoObtido() throws Exception {
//		return ExcelUtils.getCellData(11, 1);
//	}
//	
//	public static String quantidadeDeProdutosDoCarrinho() throws Exception {
//		return ExcelUtils.getCellData(7, 0);
//	}
//	
//	public static String mensagemEsperadaParaQuantidadeDeProdutosInvalidos() throws Exception {
//		return ExcelUtils.getCellData(7, 1);
//	}

//This method is to write in the Excel cell, Row num and Col num are the parameters

//public static void setCellData(String Result,  int RowNum, int ColNum) throws Exception	{
//
//		try{
//
//			Row  = ExcelWSheet.getRow(RowNum);
//
//		Cell = Row.getCell(ColNum, org.apache.poi.ss.usermodel.Row.RETURN_BLANK_AS_NULL);
//
//		if (Cell == null) {
//
//			Cell = Row.createCell(ColNum);
//
//			Cell.setCellValue(Result);
//
//			} else {
//
//				Cell.setCellValue(Result);
//
//			}
//
//// Constant variables Test Data path and Test Data file name
//
//				FileOutputStream fileOut = new FileOutputStream(Constant.Path_TestData + Constant.File_TestData);
//
//				ExcelWBook.write(fileOut);
//
//				fileOut.flush();
//
//				fileOut.close();
//
//			}catch(Exception e){
//
//				throw (e);
//
//		}
//
//	}

}