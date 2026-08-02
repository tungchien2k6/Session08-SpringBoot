package com.ra.session08.config;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CloudinaryConfig {
    @Value("${cloudinary_name}")
    private String cloudinaryName;
    @Value("${cloudinary_key_api}")
    private String cloudinaryKeyApi;
    @Value("${cloudinary_key_secret}")
    private String cloudinaryKeySecret;

    @Bean
    public Cloudinary cloudinary() {
        return new Cloudinary(
                ObjectUtils.asMap(
                        "cloud_name", cloudinaryName,
                        "api_key", cloudinaryKeyApi,
                        "api_secret", cloudinaryKeySecret
                )
        );
    }
}
