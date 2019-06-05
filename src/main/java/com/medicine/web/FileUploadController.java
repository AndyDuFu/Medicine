package com.medicine.web;

import com.medicine.domain.Attachment;
import com.medicine.domain.dto.ResponseDTO;
import com.medicine.util.JsonResult;
import com.medicine.util.UploadFile;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/apiM/upload")
public class FileUploadController {

    @Autowired
    private UploadFile uploadFile;

    @ApiOperation(value = "上传图片", notes = "需要file，和用户id，图片分类，返回的是地址")
    @RequestMapping(value = "/uploadImg",method = RequestMethod.POST)
    @ResponseBody
    public JsonResult uploadImg(@RequestParam("file") MultipartFile file
                             ) throws IllegalStateException, IOException {
        return JsonResult.builder().data(uploadFile.uploadImg(file)).build();
    }

    @ApiOperation(value = "上传文件", notes = "/apiM/upload/uploadFile")
    @RequestMapping(value = "/uploadFile",method = RequestMethod.POST)
    @ResponseBody
    public ResponseDTO uploadFile(@RequestParam("file") MultipartFile file
    ) throws IllegalStateException, IOException {
        Attachment attachment = uploadFile.uploadFile(file);
        return ResponseDTO.convert(attachment);
    }


}
