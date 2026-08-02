package com.ra.session08.service;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UploadService {
    public final Cloudinary cloudinary;

    public String uploadFile(MultipartFile file) {
        String originalFilename = file.getOriginalFilename();
        String fileName = UUID.randomUUID().toString();
        if (originalFilename.contains(".") && originalFilename != null) {
            String nameWithoutExtension = originalFilename.substring(0, originalFilename.lastIndexOf("."));
            fileName = nameWithoutExtension.replace(" ", "_") + "_" + UUID.randomUUID();
        }
        Map options = ObjectUtils.asMap(
                "public_id", fileName
        );

        try {
            Map uploadResult = cloudinary.uploader().upload(file.getBytes(), options);
            return uploadResult.get("url").toString();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static final String UPLOAD_DIR = "uploads/";

    public String uploadToLocal(MultipartFile file) {
        try {
            Path uploadPath = Paths.get(UPLOAD_DIR);
            if (!Files.exists(uploadPath)) {
                Files.createDirectories(uploadPath);
            }

            String originalFilename = file.getOriginalFilename();
            Path filePath = uploadPath.resolve(originalFilename);
            Files.copy(file.getInputStream(), filePath);

            return filePath.toString();
        } catch (IOException e) {
            throw new RuntimeException("Lưu file thất bại", e);
        }
    }
}
