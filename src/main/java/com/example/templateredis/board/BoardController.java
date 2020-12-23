package com.example.templateredis.board;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;

    @PostMapping("/save")
    public Response<Long> save(@RequestBody Board board){
        return new Response<Long>(boardService.save(board));
    }

    @GetMapping("/{id}")
    public Response<Board> findOne(@PathVariable Long id){
        return new Response<Board>(boardService.findOne(id));
    }

    @GetMapping("/list")
    public Response<List<Board>> list(){
        return new Response<List<Board>>(boardService.findAll());
    }

    @PutMapping("/{id}")
    public Response<Long> update(@PathVariable Long id, @RequestBody Board board){
        return new Response<Long>(boardService.update(id, board));
    }

    @DeleteMapping("/{id}")
    public Response<Long> delete(@PathVariable Long id){
        return new Response<Long>(boardService.delete(id));
    }
}
