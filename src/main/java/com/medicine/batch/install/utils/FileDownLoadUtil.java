package com.medicine.batch.install.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;

import com.medicine.exception.BusinessException;
import com.medicine.exception.ErrorCode;

/**
 * @author FuDu
 * @date 2019-04-03
 * @desc 用于用户下载导出的病人和就诊信息
 */
@Component
public class FileDownLoadUtil {
	// 下载文件功能
	public void downloadLocal(String filePath, HttpServletResponse response) {
		InputStream inStream;
		try {
			inStream = new FileInputStream(filePath);
			response.reset();
			response.setContentType("bin");
			response.addHeader("Content-Disposition", "attachment; filename=\"" + getFileName(filePath) + "\"");
			byte[] b = new byte[1024];
			int len;
			while ((len = inStream.read(b)) > 0) {
				response.getOutputStream().write(b, 0, len);
			}
			inStream.close();
		} catch (FileNotFoundException e) {
			throw new BusinessException(ErrorCode.FILE_NOT_EXIST);
		} catch (IOException e) {
			throw new BusinessException(ErrorCode.IO_EXCEPTION);
		}
	}
	
	public String getFileName(String filePath) {
		return filePath.substring(filePath.lastIndexOf("/") + 1, filePath.length());
	}
}
