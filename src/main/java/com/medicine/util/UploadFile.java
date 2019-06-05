package com.medicine.util;

import com.medicine.domain.Attachment;
import com.medicine.domain.attiendRecode.Image;
import com.medicine.domain.dto.attiendRecode.diagnosisAndtreatment.ImageDTO;
import com.medicine.service.AttachmentService;
import com.medicine.service.ImageService;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

@Slf4j
@Data
@Component
public class UploadFile {

	@Value("${server.ip}")
	private String serverIp;

	@Value("${web.upload-path}")
	private String filePath;

	@Value("${web.base-path}")
	private String basePath;

	@Value("${web.img-path}")
	private String imgPath;

	@Value("${web.file-path}")
	private String webFilePath;

	@Autowired
	private ImageService imageService;

	public ImageDTO uploadImg(MultipartFile file) throws IllegalStateException, IOException {
		if (file != null) {// 判断上传的文件是否为空
			String path, type;// 文件路径
			String imgUrl = basePath + imgPath;
			if (!new File(imgUrl).exists()) {
				new File(imgUrl).mkdirs();
			}
			String fileName = System.currentTimeMillis() + "_"
					+ file.getOriginalFilename().substring(file.getOriginalFilename().indexOf(".") + 0);// 文件原名称
			log.info("上传的文件原名称:" + fileName);
			// 判断文件类型
			type = fileName.indexOf(".") != -1 ? fileName.substring(fileName.lastIndexOf(".") + 1, fileName.length())
					: null;
			if (type != null) {// 判断文件类型是否为空
				if ("GIF".equals(type.toUpperCase()) || "PNG".equals(type.toUpperCase())
						|| "JPG".equals(type.toUpperCase()) || "JPEG".equals(type.toUpperCase())) {
					// 自定义的文件名称
					String trueFileName = String.valueOf(System.currentTimeMillis()) + fileName;
					// 设置存放图片文件的路径
					path = imgUrl + trueFileName;
					System.out.println("存放图片文件的路径:" + path);
					// 转存文件到指定的路径
					file.transferTo(new File(path));
					log.info("文件成功上传到指定目录下:" + file);
					Image image = new Image();
					image.setUrl(imgPath + trueFileName);
					image = imageService.save(image);
					ImageDTO imageDTO = new ImageDTO();
					imageDTO.setUid(image.getId());
					imageDTO.setUrl(image.getUrl());
					return imageDTO;
				} else {
					log.info("不是我们想要的文件类型,请按要求重新上传");
				}
			} else {
				log.info("文件类型为空");
			}
		} else {
			log.info("没有找到相对应的文件");
		}
		return null;
	}

	@Autowired
	private AttachmentService attachmentService;

	public Attachment uploadFile(MultipartFile file) throws IllegalStateException, IOException {
		if (file != null) {// 判断上传的文件是否为空
			String path, type;// 文件路径
			LocalDate localDate = LocalDate.now();
			/*
			 * String imgUrl = "/file/" + localDate + "/";
			 * 
			 * String imgUrl = "/img/"; String pathName = filePath + imgUrl; if
			 * (!new File(pathName).exists()) { new File(pathName).mkdirs(); }
			 */

			String filePath = basePath + webFilePath;

			if (!new File(filePath).exists()) {
				new File(filePath).mkdirs();
			}

			String fileName = System.currentTimeMillis() + "_"
					+ file.getOriginalFilename().substring(file.getOriginalFilename().indexOf(".") + 0);// 文件原名称
			log.info("上传的文件原名称:" + fileName);
			// 判断文件类型
			type = fileName.indexOf(".") != -1 ? fileName.substring(fileName.lastIndexOf(".") + 1, fileName.length())
					: null;
			if (type != null) {// 判断文件类型是否为空
				// 自定义的文件名称
				String trueFileName = String.valueOf(System.currentTimeMillis()) + fileName;
				path = filePath + trueFileName;
				// 转存文件到指定的路径
				file.transferTo(new File(path));
				log.info("文件成功上传到指定目录下:" + file);
				Attachment attachment = new Attachment();
				ZoneId zone = ZoneId.systemDefault();
				Instant instant = localDate.atStartOfDay().atZone(zone).toInstant();
				java.util.Date date = Date.from(instant);
				attachment.setCreateDate(date);
				attachment.setFileName(file.getOriginalFilename());
				attachment.setFilePath(webFilePath + trueFileName);
				attachment.setFileSize(file.getSize());
				attachment = attachmentService.save(attachment);
				return attachment;
			} else {
				log.info("文件类型为空");
			}
		} else {
			log.info("没有找到相对应的文件");
		}

		return null;
	}

}
