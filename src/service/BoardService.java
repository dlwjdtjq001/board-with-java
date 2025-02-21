package service;

import dto.Board;

import java.util.List;
import java.util.Optional;

public interface BoardService {
    List<Board> getBoardList();

    void create(Board board);

    Optional<Board> read(int bno);

    void update(int bno,Board board);

    void delete(int bno);

    void clear();

    public boolean valid(int bno);

}
