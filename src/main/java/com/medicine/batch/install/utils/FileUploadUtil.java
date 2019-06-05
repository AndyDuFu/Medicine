package com.medicine.batch.install.utils;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.google.common.collect.Lists;
import com.medicine.exception.BusinessException;
import com.medicine.exception.ErrorCode;

@Component
public class FileUploadUtil {
	@Value("${web.base-path}")
	private String basePath;

	@Value("${web.img-path}")
	private String imgPath;
	
	@Value("${web.xls-path}")
	private String xlsPath;
	
	// 上传 xls 文件
	public String uploadFile(MultipartFile attach) {
		String suffix = getSuffix(attach.getOriginalFilename());
		if(!suffix.equalsIgnoreCase(".xls")) {
			throw new BusinessException(ErrorCode.UPLOAD_XLS_FORMAT_ERROR);
		}
		String filePath = xlsPath + "/" + attach.getOriginalFilename();
		try {
			File targetFile = new File(filePath);
			FileUtils.copyInputStreamToFile(attach.getInputStream(), targetFile);
		} catch (IOException e) {
			throw new BusinessException(ErrorCode.FILE_UPLOAD_ERROR);
		}
		return filePath;
	}

	// 上传图片文件
	public String uploadImage(MultipartFile file) {
		List<String> suffixs = Lists.newArrayList(".gif", ".png", ".jpg", ".jpeg");
		String suffix = getSuffix(file.getOriginalFilename());
		if(!suffixs.contains(suffix.toLowerCase())) {
			throw new BusinessException(ErrorCode.UPLOAD_IMG_FORMAT_ERROR);
		}
		String imgName = UUID.randomUUID() + "_" + String.valueOf(System.currentTimeMillis())+ suffix;
		String imgUrl = basePath + imgPath;
		File image = new File(imgUrl + imgName);
		try {
			FileUtils.copyInputStreamToFile(file.getInputStream(), image);
		} catch (IOException e) {
			throw new BusinessException(ErrorCode.FILE_UPLOAD_ERROR);
		}
		return imgPath + imgName;
	}

	public String getSuffix(String path) {
		return path.substring(path.lastIndexOf("."), path.length());
	}

	public static void main(String[] args) {
		System.out.println(UUID.randomUUID() + "_" + String.valueOf(System.currentTimeMillis()) + ".jpg");
	}
}
