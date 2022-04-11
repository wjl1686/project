package com.ejobim.opplat.util;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

public class UploadFileUtils {

    public static  String uplpadFile(MultipartFile multipartFile, String localPath, String urlPath){
        String fileName = multipartFile.getOriginalFilename();
        String extension = fileName.substring(fileName.lastIndexOf(".")+1,fileName.length());
        String newFileName = System.currentTimeMillis() + "." + extension;
        File dest = new File(localPath + newFileName);
        try {
            if(!dest.getParentFile().exists()){
                System.out.println(dest.getParentFile().getAbsolutePath());
                dest.getParentFile().mkdirs();
            }
            multipartFile.transferTo(dest);
        } catch (IOException e) {
            return null;
        }
        return urlPath + newFileName;
    }


    public static int getFileType(String fileName){
        String extension = fileName.substring(fileName.lastIndexOf(".")+1,fileName.length());
        if("gpg".equalsIgnoreCase(extension)||"gif".equalsIgnoreCase(extension)||"png".equalsIgnoreCase(extension)){
            return 1;
        }else{
            return 2;
        }

    }


    public static void main(String[] args){


    }
}
