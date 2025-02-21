package controller;

import dto.Board;

public interface BoardController {
    void printMenu();
    void printAllBoard();
    void read(int sno);
    void create(String title, String content, String writer);
    void update(int bno, String title, String content, String writer);
    void delete(int bno);
    void clear();
    boolean valid(int bno);
}
