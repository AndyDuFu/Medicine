package com.medicine.batch.install.utils;

import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.medicine.batch.install.constant.PatientAndVisitRecord;
import com.medicine.batch.install.enums.DateFormat;
import com.medicine.batch.install.enums.ExcelEnum;
import com.medicine.batch.install.model.PatientRecord;
import com.medicine.exception.BusinessException;
import com.medicine.exception.ErrorCode;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

/**
 * @author FuDu
 * @date 2019-03-22
 * @desc 处理读取 excel 文件
 */
@Component
public class ExcelUtil {
	@Value("${web.base-path}")
	private String basePath;
	@Value("${web.file-dowload}")
	private String realPath;
	// excel 文件的标题栏
	private Map<String, Integer> header;
	// excel 的内容
	private List<List<String>> rows;
	
	public Map<String, Integer> getHeader() {
		return header;
	}

	public void setHeader(Map<String, Integer> header) {
		this.header = header;
	}

	public List<List<String>> getRows() {
		return rows;
	}

	public void setRows(List<List<String>> rows) {
		this.rows = rows;
	}

	// 根据 excel 文件的路径获取该文件第一个 sheet 下的所有内容
	public void init(String filePath) {
		// 创建输入流，读取Excel
		InputStream inputStream = null;
		Workbook workbook = null;
		try {
			inputStream = new FileInputStream(filePath);
			workbook = Workbook.getWorkbook(inputStream);
			// 只读取第一个 sheet 的内容
			Sheet sheet = workbook.getSheet(0);
			// 获取第一行的标题栏
			header = new HashMap<String, Integer>();
			for(int i = 0; i < sheet.getColumns(); i++) {
				String title = sheet.getCell(i, 0).getContents();
				header.put(title, i);
			}
			// 具体内容从第 2 行开始
			rows = new ArrayList<List<String>>();
			for(int m = 1; m < sheet.getRows(); m++) {
				List<String> row = new ArrayList<String>();
				for(int n = 0; n < sheet.getColumns(); n++) {
					row.add(sheet.getCell(n, m).getContents());
				}
				if(!validRowIsEmpty(row)) {
					rows.add(row);
				}
			}
		} catch (FileNotFoundException e) {
			throw new BusinessException(ErrorCode.FILE_NOT_EXIST);
		} catch (BiffException e) {
			throw new BusinessException(ErrorCode.PARSE_EXCEL_ERROR);
		} catch (IOException e) {
			throw new BusinessException(ErrorCode.IO_EXCEPTION);
		} finally {
			closeIO(inputStream);
			workbook.close();
		}
	}
	
	// 将记录写入 excel -xls 文件
	public String writeExcel(List<PatientRecord> patientRecords) {
		String filePath = basePath + realPath + generateFileName() + ExcelEnum.EXCEL_XLS_SUFFIX.value();
		//1.创建 HSSFWorkbook 对象
		HSSFWorkbook workbook = new HSSFWorkbook();
		//2.添加 sheet
		HSSFSheet sheet = workbook.createSheet(ExcelEnum.EXCEL_XLS_SHEET_PV.desc());
		//3.添加标题栏
		createHeader(sheet);
		//4.添加病患和就诊记录
		addPatientsAndVisitRecords(sheet, patientRecords);
		//5.生成文件
		FileOutputStream outputStream = null;
		try {
			outputStream = new FileOutputStream(filePath);
			workbook.write(outputStream);
		} catch (FileNotFoundException e) {
			throw new BusinessException(ErrorCode.FILE_NOT_EXIST);
		} catch (IOException e) {
			throw new BusinessException(ErrorCode.IO_EXCEPTION);
		} finally {
			closeIO(outputStream);
			closeWorkbook(workbook);
		}
		return filePath;
    }
	
	// 以时间格式生成文件名
	public String generateFileName() {
		SimpleDateFormat format = new SimpleDateFormat(DateFormat.FORMAT4.format());
		return format.format(new Date());
	}
	
	
	// 添加 excel-xls 文件标题栏
	public void createHeader(HSSFSheet sheet) {
		List<String> titles = PatientAndVisitRecord.TITLE_DESC;
		HSSFRow row = sheet.createRow(0);
		for(int i = 0; i < titles.size(); i++) {
			row.createCell(i).setCellValue(titles.get(i));
		}
	}
	
	// 添加病患和就诊记录
	public void addPatientsAndVisitRecords(HSSFSheet sheet, List<PatientRecord> patientRecords) {
		for(int m = 0; m < patientRecords.size(); m++) {
			HSSFRow row = sheet.createRow(m+1);
			PatientRecord patientRecord = patientRecords.get(m);
			List<String> properties = patientRecord.properties();
			for(int n = 0; n < properties.size(); n++) {
				row.createCell(n).setCellValue(properties.get(n));
			}
		}
	}
	
	// 判断解析的 xls 文件的行是否是空行
	public boolean validRowIsEmpty(List<String> list) {
		return list.stream().allMatch(element -> element.equals(""));
	}
	
	// 删除文件
	public void removeFile(String filePath) {
		File file = new File(filePath);
		if(file.exists()) {
			file.delete();
		}
	}
	
	// 关闭 HSSFWorkbook
	public void closeWorkbook(HSSFWorkbook workbook) {
		try {
			if(null != workbook) {
				workbook.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// 关闭输入流输出流
	public void closeIO(Closeable... ios) {
		try {
			for (Closeable io : ios) {
				if (null != io) {
					io.close();
				}
			}
		} catch (IOException e) {
			throw new BusinessException(ErrorCode.IO_EXCEPTION);
		}
	}
}
