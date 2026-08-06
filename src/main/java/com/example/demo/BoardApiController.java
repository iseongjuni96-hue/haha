package com.example.demo;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.UUID;

import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/boards")
@RequiredArgsConstructor
public class BoardApiController {

    private final BoardRepository boardRepository;

    // 💡 파일 저장 경로 설정 (프로젝트 Root 밑 uploads 폴더)
    private final String uploadDir = System.getProperty("user.dir") + "/uploads/";

    @GetMapping
    public List<Board> list() {
        return boardRepository.findAll();
    }

    // 💡 글 작성 (파일 업로드 처리 추가)
    @PostMapping
    public ResponseEntity<?> save(
            @RequestParam("title") String title,
            @RequestParam("writer") String writer,
            @RequestParam("content") String content,
            @RequestParam(value = "file", required = false) MultipartFile file
    ) throws IOException {

        String savedFileName = null;

        if (file != null && !file.isEmpty()) {
            File dir = new File(uploadDir);
            if (!dir.exists()) {
                dir.mkdirs(); // uploads 폴더가 없으면 자동 생성
            }

            // 파일명 중복 방지 UUID
            savedFileName = UUID.randomUUID().toString() + "_" + file.getOriginalFilename();
            File dest = new File(uploadDir + savedFileName);
            file.transferTo(dest);
        }

        Board board = new Board();
        board.setTitle(title);
        board.setWriter(writer);
        board.setContent(content);
        board.setFileName(savedFileName);

        Board savedBoard = boardRepository.save(board);
        return ResponseEntity.ok(savedBoard);
    }

    @GetMapping("/{id}")
    public Board detail(@PathVariable Long id) {
        return boardRepository.findById(id).orElseThrow();
    }

    @PutMapping("/{id}")
    public Board update(@PathVariable Long id, @RequestBody Board data) {
        Board board = boardRepository.findById(id).orElseThrow();
        board.setTitle(data.getTitle());
        board.setWriter(data.getWriter());
        board.setContent(data.getContent());

        return boardRepository.save(board);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        boardRepository.deleteById(id);
    }

    // 💡 이미지/파일 조회 및 다운로드 API 추가
    @GetMapping("/files/{fileName:.+}")
    public ResponseEntity<Resource> getFile(@PathVariable String fileName) throws MalformedURLException {
        Path filePath = Paths.get(uploadDir).resolve(fileName).normalize();
        Resource resource = new UrlResource(filePath.toUri());

        if (!resource.exists()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "inline; filename=\"" + resource.getFilename() + "\"")
                .body(resource);
    }
}