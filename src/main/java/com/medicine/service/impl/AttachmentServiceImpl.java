package com.medicine.service.impl;

import com.medicine.domain.Attachment;
import com.medicine.domain.repository.AttachmentRepository;
import com.medicine.service.AttachmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

@Service
public class AttachmentServiceImpl implements AttachmentService {

    @Autowired
    private AttachmentRepository repository;


    @Override
    public Attachment save(Attachment attachment) {
        return repository.save(attachment);
    }

    @Override
    public Attachment findById(Long id) {
        Attachment attachment = new Attachment();
        attachment.setId(id);
        Example<Attachment> example = Example.of(attachment);
        return repository.findOne(example).get();
    }
}
