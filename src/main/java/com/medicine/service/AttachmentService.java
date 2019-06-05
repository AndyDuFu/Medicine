package com.medicine.service;

import com.medicine.domain.Attachment;

public interface AttachmentService {

    Attachment save(Attachment attachment);

    Attachment findById(Long id);
}
