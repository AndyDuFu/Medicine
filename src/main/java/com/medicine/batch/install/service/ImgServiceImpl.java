package com.medicine.batch.install.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.medicine.batch.install.model.Img;
import com.medicine.batch.install.repository.ImgRepository;
import com.medicine.batch.install.serviceImpl.ImgService;

@Service
@Transactional
public class ImgServiceImpl implements ImgService {
	@Resource
	private ImgRepository imgRepository;
	
	@Override
	public Img save(Img img) {
		return imgRepository.save(img);
	}
	
	@Override
	public void saveAll(List<Img> imgs) {
		imgRepository.saveAll(imgs);
	}
}
