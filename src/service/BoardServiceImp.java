package service;

import dto.Board;
import repository.BoardRepository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public class BoardServiceImp implements BoardService {
    BoardRepository boardRepository;
    static private int bno = 1;

    public BoardServiceImp(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    @Override
    public List<Board> getBoardList() {
        return boardRepository.getBoardList();
    }

    @Override
    public void create(Board board) {
        boardRepository.setBoardList(board);
    }

    @Override
    public Optional<Board> read(int bno) {
        return boardRepository.getBoardList().stream()
                .filter(x -> x.getBno() == bno)
                .findFirst();
    }

    @Override
    public void update(int bno,Board board) {
         Board targetBoard = boardRepository.getBoardList()
                 .stream()
                 .filter(x -> x.getBno() == bno)
                 .findFirst()
                 .orElse(null); // 지울 dto
         boardRepository.deleteBoardList(targetBoard);
         boardRepository.setBoardList(board);
    }

    @Override
    public void delete(int bno) {
        Board targetBoard = boardRepository.getBoardList()
                .stream()
                .filter(x -> x.getBno() == bno)
                .findFirst()
                .orElse(null); // 지울 dto
        boardRepository.deleteBoardList(targetBoard);
    }

    @Override
    public void clear() {
        boardRepository.clear();
    }

    public boolean valid(int bno){
        return boardRepository.getBoardList().stream()
                .anyMatch(x -> x.getBno() == bno);
    }
}
