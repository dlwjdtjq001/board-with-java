package service;

import dto.Board;

import java.util.List;

public interface BoardService {
    List<Board> getBoardList();

    void create(Board board);

    Board read(int bno);

    void update(int bno,Board board);

    void delete(int bno);

    void clear();

}
