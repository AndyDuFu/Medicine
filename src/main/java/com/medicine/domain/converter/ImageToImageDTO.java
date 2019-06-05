package com.medicine.domain.converter;

import com.medicine.domain.attiendRecode.Image;
import com.medicine.domain.dto.attiendRecode.diagnosisAndtreatment.ImageDTO;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;

public class ImageToImageDTO {

    public static ImageDTO converter(Image image) {
        ImageDTO imageDTO = new ImageDTO();
        BeanUtils.copyProperties(image, imageDTO);
        return imageDTO;
    }

    public static List<ImageDTO> converter(List<Image> images) {
        List<ImageDTO> imageDTOS = new ArrayList<>();
        images.forEach(image -> imageDTOS.add(converter(image)));
        return imageDTOS;
    }
}
