package com.medicine.batch.install.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.medicine.batch.install.model.Img;
import com.medicine.batch.install.serviceImpl.ImgService;
import com.medicine.batch.install.utils.FileUploadUtil;



/**
 * @author FuDu
 * @date 2019-03-25
 * @desc 将上传的图片和批量导入的用户关联起来
 */
@RestController
@RequestMapping("/relate")
public class RelatePatientImg {
	@Resource
	private FileUploadUtil fileUpload;
	@Resource
	private ImgService imgService;
	
	// 将上传的单张图片和批量导入的用户关联起来
	@PostMapping("/img")
	public Map<String, Object> uploadImg(@RequestParam("file")MultipartFile file, Integer relatedId) {
		Map<String, Object> result = new HashMap<String, Object>();
		//1. 上传图片
		String imgPath = fileUpload.uploadImage(file);
		//2. 关联图片信息
		Img img = new Img();
		img.setUrl(imgPath);
		img.setWesternId(relatedId);
		imgService.save(img);
		//3. 返回上传图片信息
		result.put("imgPath", imgPath);
		return result;
	}
	
	// 将上传的多张图片和批量导入的用户关联起来
	@PostMapping("/imgs")
	public Map<String, Object> uploadImg(@RequestParam("files")MultipartFile[] files, Integer relatedId) {
		Map<String, Object> result = new HashMap<String, Object>();
		List<String> imgPaths = new ArrayList<String>();
		List<Img> imgs = new ArrayList<Img>();
		for(MultipartFile file : files) {
			//1. 上传图片
			String imgPath = fileUpload.uploadImage(file);
			//2. 关联图片信息
			Img img = new Img();
			img.setUrl(imgPath);
			img.setWesternId(relatedId);
			imgs.add(img);
			//3. 返回图片信息
			imgPaths.add(imgPath);
		}
		imgService.saveAll(imgs);
		result.put("imgPath", imgPaths);
		return result;
	}
}
