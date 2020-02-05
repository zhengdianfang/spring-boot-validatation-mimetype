package com.zhengdianfang.validation_mimetypes.validators;

import com.zhengdianfang.validation_mimetypes.annotations.ExtensionCheck;
import org.apache.commons.io.FilenameUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class FileExtensionValidator implements ConstraintValidator<ExtensionCheck, MultipartFile> {

    private static final String ANY = "*";
    private String[] extensions;

    @Override
    public void initialize(ExtensionCheck annotation) {
        this.extensions = annotation.extensions();
    }

    @Override
    public boolean isValid(MultipartFile file, ConstraintValidatorContext context) {

        String detectExtension = FilenameUtils.getExtension(file.getOriginalFilename());

        for (String extension : extensions) {
            if(ANY.equals(extension) || extension.equalsIgnoreCase(detectExtension)) {
                return true;
            }
        }

        return false;
    }

}
