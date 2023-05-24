package com.green.board7.fileupload;


import com.green.board7.fileupload.model.FileuploadInsDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/fileupload")
public class FileuploadController {
    private final Logger LOGGER;
    private final FileuploadService service;
    @Autowired
    public FileuploadController(FileuploadService service) {
        LOGGER= LoggerFactory.getLogger(FileuploadController.class);
        this.service = service;
    }

    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.MULTIPART_FORM_DATA_VALUE})
    public void fileupload(@RequestPart FileuploadInsDto dto
                            , @RequestPart MultipartFile img){ //파일은 무조건 MultipartFile타입으로 받아야한다
       LOGGER.info("dto :"+dto);
        LOGGER.info("imgFileName :"+ img.getOriginalFilename());

        service.fileUpload(dto,img);

    }
}
