package com.movieapp.dahp_ccptpm_be.service;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;

@Service
public class UploadService {
    @Autowired
    private Cloudinary cloudinary;

    public String uploadVideo(MultipartFile file) throws IOException {
        String resourceType = "video";
        Map<?, ?> uploadResult = cloudinary.uploader().upload(file.getBytes(), ObjectUtils.asMap(
                "resource_type", resourceType, // Định nghĩa loại file là video
                "folder", "videos_short" // Định nghĩa thư mục đích trong Cloudinary
        ));

        return uploadResult.get("url").toString(); // Trả về URL đầy đủ của video đã upload
    }
}
