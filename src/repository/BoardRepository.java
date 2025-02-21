package repository;

import dto.Board;

import java.util.HashMap;
import java.util.List;

public interface BoardRepository {
    List<Board> getBoardList();
    void setBoardList(Board board);

    void deleteBoardList(Board board);

    void clear();
}
