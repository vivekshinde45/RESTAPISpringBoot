package com.book.restapi.bootrestapibooks.helper;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileTransferHelper {
    private final String path = "C:\\Users\\vivshind\\Downloads\\Java\\SpringBoot\\bootrestapibooks\\src\\main\\resources\\static";

    public boolean uploadFile(MultipartFile file) {
        try {
            var getInputStream = file.getInputStream();
            var _path = Paths.get(path + File.separator + file.getOriginalFilename());
            var fileUploadType = StandardCopyOption.REPLACE_EXISTING;
            Files.copy(getInputStream, _path, fileUploadType);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
