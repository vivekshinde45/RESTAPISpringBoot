package com.book.restapi.bootrestapibooks.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.book.restapi.bootrestapibooks.helper.FileTransferHelper;

@RestController
public class FileProcessController {

    @Autowired
    private FileTransferHelper _fileTransferHelper;

    @PostMapping("/files")
    public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file) {
        try {
            if (!file.isEmpty()) {
                ResponseEntity.status(HttpStatus.BAD_GATEWAY).body("File must be passed");
            }
            boolean result = _fileTransferHelper.uploadFile(file);
            if (result) {
                return ResponseEntity.ok("File uploaded sucessfully");
            }
            return ResponseEntity.status(HttpStatus.BAD_GATEWAY).body("File transfer failed !! try again");
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.BAD_GATEWAY).body("File transfer failed !! try again");
        }

    }
}
