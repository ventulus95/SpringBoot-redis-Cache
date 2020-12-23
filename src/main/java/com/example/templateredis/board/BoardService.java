package com.example.templateredis.board;

import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class BoardService {

    private final BoardRepository boardRepository;

    @Transactional
    public Long save(Board board) {
        boardRepository.save(board);

        return board.getId();
    }

        @Cacheable(key = "#id", value="findOne")
        public Board findOne(Long id){
            return boardRepository.findById(id).get();
        }

    public List<Board> findAll(){
        return boardRepository.findAll();
    }

    @Transactional
    public Long delete(Long id){
        boardRepository.deleteById(id);

        return id;
    }

    @Transactional
    public Long update(Long id, Board board){
        Board findBoard = boardRepository.findById(id).get();
        findBoard.update(board);

        return id;
    }
}
