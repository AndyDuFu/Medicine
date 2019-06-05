package com.medicine.service.impl;

import com.medicine.domain.Attachment;
import com.medicine.domain.Datum;
import com.medicine.domain.dto.DatumDTO;
import com.medicine.domain.mapper.DatumMapper;
import com.medicine.domain.repository.AttachmentRepository;
import com.medicine.domain.repository.DatumRepository;
import com.medicine.service.DatumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Optional;

@Service
public class DatumServiceImpl implements DatumService {

    @Autowired
    private DatumRepository datumRepository;

    @Autowired
    private AttachmentRepository attachmentRepository;
    @Override
    public Datum save(Datum datum) {
        List<Attachment> attachments = datum.getAttachments();
        datum.setAttachments(null);
        Datum d = datumRepository.save(datum);
        if (datum.getId() != null) {
            List<Attachment> attach = attachmentRepository.findByDatumId(datum.getId());
            attach.forEach(e->{
                e.setDatum(null);
                attachmentRepository.save(e);
            });
        }
        if (attachments != null) {
            attachments.forEach(e->{
                Attachment attachment = new Attachment();
                attachment.setId(e.getId());
                Example<Attachment> example = Example.of(attachment);
                Attachment a = attachmentRepository.findOne(example).get();
                a.setDatum(d);
                attachmentRepository.save(a);
            });
        }
        return d;
    }

    @Override
    public void delete(Long id) {
        datumRepository.deleteById(id);
    }

    @Autowired
    private DatumMapper datumMapper;

    @Override
    public List<DatumDTO> findByTitleAndKey( String title, String key) {

        List<DatumDTO> datumDTOS = datumMapper.findByList(title, key);
        return datumDTOS;
    }
}
