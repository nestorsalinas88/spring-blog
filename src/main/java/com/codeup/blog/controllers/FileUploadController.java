package com.codeup.blog.controllers;

import com.codeup.blog.models.Document;
import com.codeup.blog.services.DocumentUploadService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;


@Controller
public class FileUploadController {
    private final DocumentUploadService docDao;

    @Autowired
    public FileUploadController(DocumentUploadService docDao) {
        this.docDao = docDao;
    }

    @GetMapping("/posts/fileupload")
    public String showUploadFileForm() {
        return "/posts/fileupload";
    }

    @PostMapping("/posts/fileupload")
    public ResponseEntity<Object> saveFile (
            @RequestParam(name = "file") MultipartFile uploadedFile) throws IOException {

        if (!uploadedFile.getOriginalFilename().isEmpty()) {
            Document upload = docDao.upload(uploadedFile);
            ObjectMapper objectMapper = new ObjectMapper();
            String entities = objectMapper.writeValueAsString(upload);

            return new ResponseEntity<>(entities,HttpStatus.OK);

        } else {
            return new ResponseEntity<>("Invalid file", HttpStatus.BAD_REQUEST);

        }

    }

    @PostMapping("/posts/upload")
    public @ResponseBody Document uploadDoc(
            @RequestParam(name = "file") MultipartFile uploadedFile) throws IOException {

        if (!uploadedFile.getOriginalFilename().isEmpty()) {
            Document upload = docDao.upload(uploadedFile);
            return new Document(upload);
        } else {
            return null;
        }

    }

}