package com.zhengdianfang.validation_mimetypes.annotations;

import com.zhengdianfang.validation_mimetypes.validators.FileMimeTypeValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = FileMimeTypeValidator.class)
public @interface MimeTypeCheck {

    String message() default "Illegal File MIME Type";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
    /**
     * @return the mime type the annotated string must match, e.g. application/pdf. Per default any mime type  is allowed
     */
    String[] mimeTypes() default {"*"};

}
