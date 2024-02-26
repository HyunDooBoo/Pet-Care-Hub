package pet.hub.app.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pet.hub.app.domain.board.Board;
import pet.hub.app.domain.board.BoardRepository;
import pet.hub.app.domain.board.BoardService;
import pet.hub.app.web.dto.board.BoardRequestDto;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/api/boards")
@RestController
public class BoardController {

    private final BoardRepository boardRepository;
    private final BoardService boardService;

    @PostMapping("")
    public ResponseEntity<Board> saveBoard(@RequestBody BoardRequestDto requestDto) {
        Board savedBoard = boardService.saveBoard(requestDto);
        return new ResponseEntity<>(savedBoard, HttpStatus.CREATED);
    }

    @PutMapping("/{boardId}")
    public ResponseEntity<Board> updateBoard(@PathVariable Long boardId, @RequestBody BoardRequestDto requestDto) {
        Board updatedBoard = boardService.updateBoard(boardId, requestDto);
        return new ResponseEntity<>(updatedBoard, HttpStatus.OK);
    }

    @GetMapping("/search")
    public List<Board> searchPosts(@RequestParam("keyword") String keyword) {
        return boardService.searchBoards(keyword);
    }

}
