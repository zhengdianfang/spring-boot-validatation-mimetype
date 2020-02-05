package com.zhengdianfang.validation_mimetypes.validators;

import com.zhengdianfang.validation_mimetypes.annotations.MimeTypeCheck;
import com.zhengdianfang.validation_mimetypes.uitls.FileMimeTypeUtils;
import com.zhengdianfang.validation_mimetypes.uitls.TikaFactory;
import org.apache.tika.io.TikaInputStream;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.mime.MediaType;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.io.IOException;

public class FileMimeTypeValidator implements ConstraintValidator<MimeTypeCheck, MultipartFile> {

    private static final String ANY = "*";
    private String[] mimeTypes;

    @Override
    public void initialize(MimeTypeCheck annotation) {
        this.mimeTypes = annotation.mimeTypes();
    }

    @Override
    public boolean isValid(MultipartFile file, ConstraintValidatorContext context) {
        try {
            Metadata metadata = new Metadata();
            metadata.set(Metadata.RESOURCE_NAME_KEY, file.getOriginalFilename());
            MediaType mediaType = TikaFactory.getDetector().detect(TikaInputStream.get(file.getInputStream()), metadata);
            for (String mimeType : mimeTypes) {
                if (ANY.equals(mimeType) || FileMimeTypeUtils.getFileExtensionsWithMimeType(mediaType.toString()).contains(mimeType)) {
                    return true;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

}
