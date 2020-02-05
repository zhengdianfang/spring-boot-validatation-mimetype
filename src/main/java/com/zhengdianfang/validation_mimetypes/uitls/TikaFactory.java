package com.zhengdianfang.validation_mimetypes.uitls;

import org.apache.tika.config.TikaConfig;
import org.apache.tika.detect.Detector;

public class TikaFactory {

    private static Detector detector = null;

    public static Detector getDetector() {
        if (detector == null) {
            TikaConfig defaultConfig = TikaConfig.getDefaultConfig();
            detector = defaultConfig.getDetector();
        }
        return detector;
    }
}
