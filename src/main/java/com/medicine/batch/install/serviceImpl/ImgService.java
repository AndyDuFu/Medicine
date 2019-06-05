package com.medicine.batch.install.serviceImpl;

import java.util.List;

import com.medicine.batch.install.model.Img;

public interface ImgService {
	public Img save(Img img);
	public void saveAll(List<Img> imgs);
}
