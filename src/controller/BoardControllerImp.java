package controller;

import dto.Board;
import service.BoardService;

import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;
import java.util.NoSuchElementException;
import java.util.function.Consumer;
import java.util.function.Function;

public class BoardControllerImp implements BoardController {
    BoardService boardService;
    static int bno = 1;

    public BoardControllerImp(BoardService boardService) {
        this.boardService = boardService;
    }

    @Override
    public void printMenu() {
        System.out.println("[게시물 목록]");
        System.out.println("-----------------------------------------------------");
        System.out.printf("%-15s %-15s %-15s %s","no", "writer", "date", "title\n");
        System.out.println("-----------------------------------------------------");
    }

    @Override
    public void printAllBoard(){
        boardService.getBoardList()
                .stream()
                .sorted(Comparator.comparing(Board::getBno))
                .forEach(x ->
                System.out.printf("%-15s %-15s %-15s %s\n",x.getBno(), x.getBwritter(), dateToString.apply(x.getBdate()), x.getBtitle()));
    }

    private Function<Date,String> dateToString = date ->{
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy.MM.dd");
        return formatter.format(date);
    };
    @Override
    public void create(String title, String content, String writer){
        boardService.create(createPerfectBoard(bno++,title, content, writer));
    }
    @Override
    public void read(int bno) { //bno 받아서 해당하는 게시글 출력
        printBoard.accept(boardService.read(bno)
                .orElseGet(() -> createPerfectBoard(0,bno + "번 게시글은 존재하지 않습니다.",
                        "번호를 다시한번 확인해주세요.",
                        "해당 게시글은 번호를 잘못 입력하면 보여지는 게시글입니다.")));
    }
    public Consumer<Board> printBoard = x -> {
        System.out.println("###############");
        System.out.println("번호: " + x.getBno());
        System.out.println("제목: " + x.getBtitle());
        System.out.println("내용: " + x.getBcontent());
        System.out.println("작성자: " + x.getBwritter());
        System.out.println("날짜: " + dateToString.apply(x.getBdate()));
        System.out.println("###############");
    };

    @Override
    public void update(int bno, String title, String content, String writer ){
        boardService.update(bno, createPerfectBoard(bno,title,content,writer));
    }

    private Board createPerfectBoard(int bno ,String title, String content, String writer) {
        Board board = Board.builder()
                .bno(bno)
                .bdate(new Date())
                .btitle(title)
                .bcontent(content)
                .bwritter(writer)
                .build();
        return board;
    }

    @Override
    public void delete(int bno) {
        boardService.delete(bno);
    }

    @Override
    public void clear() {
        boardService.clear();
    }

    @Override
    public boolean valid(int bno) {
        return boardService.valid(bno);
    }
}
