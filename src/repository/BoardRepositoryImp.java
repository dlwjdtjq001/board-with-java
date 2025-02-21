package repository;

import dto.Board;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class BoardRepositoryImp implements BoardRepository{
    private final List<Board> boardList = new ArrayList<>(); // board 리스트 컬렉션

    @Override
    public List<Board> getBoardList() {
        return boardList;
    }
    @Override
    public void setBoardList(Board board){
        boardList.add(board);
    }
    @Override
    public void deleteBoardList(Board board){
        boardList.removeIf(x -> x.getBno() == board.getBno());
    }
    @Override
    public void clear() {
        boardList.clear();
    }
}
