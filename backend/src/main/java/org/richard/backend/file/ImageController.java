package org.richard.backend.file;

import jakarta.annotation.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

@RestController
@RequestMapping("/images")
public class ImageController {

//    @GetMapping("/{filename}")
//    public ResponseEntity<Resource> getImage(@PathVariable String filename) throws IOException {
//        Path filePath = Paths.get("path/to/images", filename);
//        var resource = new UrlResource(filePath.toUri());
//
//        if (!resource.exists()) {
//            throw new FileNotFoundException("File not found: " + filename);
//        }
//
//        return ResponseEntity.ok()
//                .contentType(MediaType.IMAGE_JPEG) // Adjust MIME type based on the file format
//                .body((Resource) resource);
//    }
}