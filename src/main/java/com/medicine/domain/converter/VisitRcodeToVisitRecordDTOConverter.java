package com.medicine.domain.converter;

import com.medicine.domain.VisitRecord;
import com.medicine.domain.attiendRecode.*;
import com.medicine.domain.dto.VisitRecordDTO;
import com.medicine.domain.dto.attiendRecode.DiagnosisOfWeDTO;
import com.medicine.domain.dto.attiendRecode.DiagnosisOfZhDTO;
import com.medicine.domain.dto.attiendRecode.diagnosisAndtreatment.*;
import com.medicine.domain.dto.attiendRecode.diagnosisOfZh.AskDTO;
import com.medicine.domain.dto.attiendRecode.diagnosisOfZh.LookDTO;
import com.medicine.domain.dto.attiendRecode.diagnosisOfZh.WqDTO;
import com.medicine.domain.dto.attiendRecode.diagnosisOfZh.ZhaiyaoDTO;
import com.medicine.domain.dto.attiendRecode.orther.AnyuDTO;
import com.medicine.domain.dto.attiendRecode.orther.HuifangjiluDTO;
import com.medicine.domain.dto.attiendRecode.orther.OrtherDTO;
import com.medicine.domain.dto.attiendRecode.orther.ZhiliaoxiaoguoDTO;
import com.medicine.util.CharacterUtils;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;

public class VisitRcodeToVisitRecordDTOConverter{




    public static VisitRecordDTO convert(VisitRecord visitRecord) {
        VisitRecordDTO visitRecordDTO = new VisitRecordDTO();
        BeanUtils.copyProperties(visitRecord, visitRecordDTO);
        visitRecordDTO.setDate(visitRecord.getCreateDate());
        // 中医四诊 这个是根据前端定的api
        DiagnosisOfZh diagnosisOfZh = visitRecord.getDiagnosisOfZh();
        DiagnosisOfZhDTO diagnosisOfZhDTO = new DiagnosisOfZhDTO();
        AskDTO askDTO = new AskDTO();
        LookDTO lookDTO = new LookDTO();
        WqDTO wqDTO = new WqDTO();
        ZhaiyaoDTO zhaiyaoDTO = new ZhaiyaoDTO();



        BeanUtils.copyProperties(diagnosisOfZh, wqDTO);
        BeanUtils.copyProperties(diagnosisOfZh, zhaiyaoDTO);
        BeanUtils.copyProperties(diagnosisOfZh, askDTO);
        BeanUtils.copyProperties(diagnosisOfZh, lookDTO);
        WesternMedicineDTO westernMedicineDTO = new WesternMedicineDTO();
        if (diagnosisOfZh.getWesternMedicine() != null) {
            westernMedicineDTO.setId(diagnosisOfZh.getWesternMedicine().getId());
            westernMedicineDTO.setText(diagnosisOfZh.getWesternMedicine().getText());
            westernMedicineDTO.setImg(setImageDTO(diagnosisOfZh));
        }

        lookDTO.setShezhenimg(westernMedicineDTO);
        diagnosisOfZhDTO.setAsk(askDTO);
        diagnosisOfZhDTO.setLook(lookDTO);
        diagnosisOfZhDTO.setZhaiyao(zhaiyaoDTO);
        diagnosisOfZhDTO.setWq(wqDTO);
        diagnosisOfZhDTO.setId(diagnosisOfZh.getId());
        visitRecordDTO.setDiagnosisOfZh(diagnosisOfZhDTO);

        // 西医检查
        DiagnosisOfWeDTO diagnosisOfWeDTO = new DiagnosisOfWeDTO();
        DiagnosisOfWe diagnosisOfWe = visitRecord.getDiagnosisOfWe();
        List<WesternMedicine> westernMedicines = diagnosisOfWe.getWesternMedicines();
        if (westernMedicines != null) {
            westernMedicines.forEach(westernMedicine -> {
                WesternMedicineDTO e = new WesternMedicineDTO();
                e.setId(westernMedicine.getId());
                e.setImg(setImageDTO(westernMedicine.getImg()));
                e.setText(westernMedicine.getText());
                switch (westernMedicine.getName()) {
                    case "xcg":
                        diagnosisOfWeDTO.setXcg(e);
                        break;
                    case "xdt":
                        diagnosisOfWeDTO.setXdt(e);
                        break;
                    case "ncg":
                        diagnosisOfWeDTO.setNcg(e);
                        break;
                    case "ct":
                        diagnosisOfWeDTO.setCt(e);
                        break;
                    case "dbcg":
                        diagnosisOfWeDTO.setDbcg(e);
                        break;
                    case "mri":
                        diagnosisOfWeDTO.setMri(e);
                        break;
                    case "xsh":
                        diagnosisOfWeDTO.setXsh(e);
                        break;
                    case "cs":
                        diagnosisOfWeDTO.setCs(e);
                        break;
                    case "x":
                        diagnosisOfWeDTO.setX(e);
                        break;
                    case "orther":
                        diagnosisOfWeDTO.setOrther(e);
                        break;
                }
            });
        }
        diagnosisOfWeDTO.setTigejiancha(diagnosisOfWe.getTigejiancha());
        diagnosisOfWeDTO.setId(diagnosisOfWe.getId());
        visitRecordDTO.setDiagnosisOfWe(diagnosisOfWeDTO);

        // 诊断治疗
        DiagnosisAndTreatment diagnosisAndtreatment = visitRecord.getDiagnosisAndtreatment();
        DiagnosisAndtreatmentDTO diagnosisAndtreatmentDTO = new DiagnosisAndtreatmentDTO();
        ZdyzlDTO zdyzlDTO = new ZdyzlDTO();
        BeanUtils.copyProperties(diagnosisAndtreatment, zdyzlDTO);
        CfDTO cfDTO = new CfDTO();
        ZycfDTO zycfDTO = new ZycfDTO();
        OtherDTO otherDTO = new OtherDTO();

        BeanUtils.copyProperties(diagnosisAndtreatment, zdyzlDTO);
        BeanUtils.copyProperties(diagnosisAndtreatment, zycfDTO);
        BeanUtils.copyProperties(diagnosisAndtreatment, otherDTO);
        otherDTO.setOrther(diagnosisAndtreatment.getOther());
        cfDTO.setOrther(otherDTO);

        zycfDTO.setMedicine(MedicineToMedicineDTO.converter(diagnosisAndtreatment.getMedicine()));
        cfDTO.setZycf(zycfDTO);
        diagnosisAndtreatmentDTO.setCf(cfDTO);
        diagnosisAndtreatmentDTO.setZdyzl(zdyzlDTO);
        diagnosisAndtreatmentDTO.setId(diagnosisAndtreatment.getId());
        visitRecordDTO.setDiagnosisAndtreatment(diagnosisAndtreatmentDTO);
        // 其他
        OtherMessage otherMessage = visitRecord.getOtherMessage();
        OrtherDTO ortherDTO = new OrtherDTO();
        HuifangjiluDTO huifangjiluDTO = new HuifangjiluDTO();
        AnyuDTO anyuDTO = new AnyuDTO();
        ZhiliaoxiaoguoDTO zhiliaoxiaoguoDTO = new ZhiliaoxiaoguoDTO();
        BeanUtils.copyProperties(otherMessage, huifangjiluDTO);
        BeanUtils.copyProperties(otherMessage, anyuDTO);
        anyuDTO.setQita(otherMessage.getQita());
        BeanUtils.copyProperties(otherMessage, zhiliaoxiaoguoDTO);
        ortherDTO.setAnyu(anyuDTO);
        ortherDTO.setHuifangjilu(huifangjiluDTO);
        ortherDTO.setZhiliaoxiaoguo(zhiliaoxiaoguoDTO);
        ortherDTO.setId(otherMessage.getId());
        visitRecordDTO.setOrther(ortherDTO);
        return visitRecordDTO;
    }

    public static List<VisitRecordDTO> convert(List<VisitRecord> visitRecords) {
        List<VisitRecordDTO> visitRecordDTOS = new ArrayList<>();
        if (visitRecords != null) {
            visitRecords.forEach(
                    visitRecord -> visitRecordDTOS.add(
                            convert(visitRecord)
                    )
            );
        }
        return visitRecordDTOS;
    }


    public static List<ImageDTO> setImageDTO(DiagnosisOfZh diagnosisOfZh) {
        return setImageDTO(diagnosisOfZh.getWesternMedicine().getImg());
    }

    public static List<ImageDTO> setImageDTO(List<Image> img) {
        List<ImageDTO> imgDTOS = new ArrayList<>();
        img.forEach(image -> {
            ImageDTO imageDTO = new ImageDTO();
            imageDTO.setUrl(image.getUrl());
            imageDTO.setUid(image.getId());
            imgDTOS.add(imageDTO);
        });
        return imgDTOS;
    }
}
