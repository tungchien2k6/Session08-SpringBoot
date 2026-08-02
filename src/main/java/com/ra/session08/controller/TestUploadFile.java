package com.ra.session08.controller;


import com.ra.session08.service.UploadService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequiredArgsConstructor
public class TestUploadFile {
    private final UploadService uploadService;

    @PostMapping("/upload")
    public String uploadFile(@ModelAttribute("file") MultipartFile file) {
        return uploadService.uploadFile(file);
    }
}
