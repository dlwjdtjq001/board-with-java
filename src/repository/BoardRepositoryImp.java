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
        Optional<Board> targetBoard = boardList.stream()
                .filter(x -> x.getBno() == board.getBno())
                .findFirst(); //옵셔널(board) 반환
        targetBoard.ifPresentOrElse(x -> {
            System.out.println("삭제를 완료했습니다.");
            boardList.remove(x);} , () ->{
            System.out.println("해당 게시글이 존재하지 않습니다.");
        });
    }
    @Override
    public void clear() {
        boardList.clear();
    }
}
