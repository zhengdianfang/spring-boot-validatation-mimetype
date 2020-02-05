package com.zhengdianfang.validation_mimetypes.uitls;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FileMimeTypeUtils {
    private static HashMap<String, String> mimeTypeConfigs = new HashMap() {{
        put("aac", "audio/aac");
        put("abw", "application/x-abiword");
        put("arc", "application/x-freearc");
        put("avi", "application/vnd.amazon.ebook");
        put("azw", "application/vnd.amazon.ebook");
        put("bin", "application/octet-stream");
        put("bmp", "image/bmp");
        put("bz", "application/x-bzip");
        put("bz2", "application/x-bzip2");
        put("csh", "application/x-csh");
        put("css", "text/css");
        put("csv", "text/csv");
        put("doc", "application/msword");
        put("docx", "application/vnd.openxmlformats-officedocument.wordprocessingml.document");
        put("eot", "application/vnd.ms-fontobject");
        put("epub", "application/epub+zip");
        put("gif", "image/gif");
        put("htm", "text/html");
        put("html", "text/html");
        put("jar", "application/java-archive");
        put("jpeg", "image/jpeg");
        put("jpg", "image/jpeg");
        put("js", "text/javascript");
        put("json", "application/json");
        put("jsonld", "application/ld+json");
        put("mjs", "text/javascript");
        put("mp3", "audio/mpeg");
        put("mpeg", "video/mpeg");
        put("mpkg", "application/vnd.apple.installer+xml");
        put("odp", "application/vnd.oasis.opendocument.presentation");
        put("ods", "application/vnd.oasis.opendocument.spreadsheet");
        put("odt", "application/vnd.oasis.opendocument.text");
        put("oga", "audio/ogg");
        put("ogv", "video/ogg");
        put("ogx", "application/ogg");
        put("png", "image/png");
        put("pdf", "application/pdf");
        put("ppt", "application/vnd.ms-powerpoint");
        put("pptx", "application/vnd.openxmlformats-officedocument.presentationml.presentation");
        put("rar", "application/x-rar-compressed");
        put("rtf", "application/rtf");
        put("sh", "application/x-sh");
        put("svg", "image/svg+xml");
        put("swf", "application/x-shockwave-flash");
        put("tar", "application/x-tar");
        put("txt", "text/plain");
        put("wav", "audio/wav");
        put("weba", "audio/webm");
        put("webm", "video/webm");
        put("webp", "image/webp");
        put("woff", "font/woff");
        put("woff2", "font/woff2");
        put("xhtml", "application/xhtml+xml");
        put("xls", "application/vnd.ms-excel");
        put("xlsx", "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        put("xml", "application/xml");
        put("zip", "application/zip");
    }};

    public static List<String> getFileExtensionsWithMimeType(String mimeType) {
        List<String> extentions = new ArrayList();
        for (String key : mimeTypeConfigs.keySet()) {
            if (mimeTypeConfigs.get(key).equals(mimeType)) {
                extentions.add(key);
            }
        }
        return extentions;
    }
}
