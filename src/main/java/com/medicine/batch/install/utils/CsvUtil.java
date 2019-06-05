package com.medicine.batch.install.utils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.Charset;

import org.springframework.stereotype.Component;

import com.csvreader.CsvReader;
import com.csvreader.CsvWriter;
import com.medicine.exception.BusinessException;
import com.medicine.exception.ErrorCode;

@Component
public class CsvUtil {
	// 初始化读取文件
	public CsvReader initReader(String filePath, boolean readHeader) {
		// 创建CSV读对象 例如:CsvReader(文件路径，分隔符，编码格式);
		CsvReader reader = null;
		try {
			reader = new CsvReader(filePath, ',', Charset.forName("UTF-8"));
			//是否要表头, 如果需要表头的话, 应设为 true
			if (readHeader)	reader.readHeaders();
		} catch (FileNotFoundException e) {
			throw new BusinessException(ErrorCode.FILE_NOT_EXIST);
		} catch (IOException e) {
			throw new BusinessException(ErrorCode.IO_EXCEPTION);
		}
		return reader;
	}
	
	// 初始化读取文件
	public CsvReader initReader(String filePath) {
		// 创建CSV读对象 例如:CsvReader(文件路径，分隔符，编码格式);
		CsvReader reader = null;
		try {
			reader = new CsvReader(filePath, ',', Charset.forName("UTF-8"));
			reader.readHeaders();
		} catch (FileNotFoundException e) {
			throw new BusinessException(ErrorCode.FILE_NOT_EXIST);
		} catch (IOException e) {
			throw new BusinessException(ErrorCode.IO_EXCEPTION);
		}
		return reader;
	}
	
	// 初始化写文件
	public static CsvWriter initWriter(String filePath) {
		CsvWriter writer = new CsvWriter(filePath, ',', Charset.forName("UTF-8"));
		return writer;
	}
	
	public static void closeReader(CsvReader reader) {
		if (null != reader)	reader.close();
	}
	
	public static void closeWriter(CsvWriter writer) {
		if (null != writer) writer.close();
	}
}
