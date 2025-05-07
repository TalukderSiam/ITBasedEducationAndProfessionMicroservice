package com.edupro.EducationWeb.service.ServiceImplemantation;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.edupro.EducationWeb.exception.CustomRuntimeException;
import com.edupro.EducationWeb.service.CloudinaryService;

@Service
public class CloudinaryServiceImplementation implements CloudinaryService {

    @Autowired
    private Cloudinary cloudinary;

    @Override
    public String uploadFile(MultipartFile file) {
        try {
            String contentType = file.getContentType();

            // Use 'raw' for non-image files like PDFs, DOCX, etc.
            String resourceType = (contentType != null && contentType.equals("application/pdf")) 
                ? "raw" 
                : "auto";

            Map<String, Object> options = ObjectUtils.asMap(
                "resource_type", resourceType,
                "use_filename", true,
                "unique_filename", false,
                "filename", file.getOriginalFilename(),
                "access_mode", "public"
                // You can uncomment this for big files:
                // "chunk_size", 6000000
            );

            Map uploadResult = cloudinary.uploader().upload(file.getBytes(), options);

            // Get the original URL
            String url = uploadResult.get("url").toString();

            // Force download if it's a raw file (like PDF)
            if ("raw".equals(resourceType)) {
                url = url.replace("/upload/", "/upload/fl_attachment/");
            }

            return url;

        } catch (Exception e) {
            throw new CustomRuntimeException(false, e.getMessage(), "CTSubject_Post",
                    "CTSubject", List.of());
        }
    }
}
