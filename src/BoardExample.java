import controller.BoardController;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class BoardExample {
    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();
        BoardController boardController = appConfig.getBoardController();
        Scanner sc = new Scanner(System.in);
        boolean run = true;
        while(run){
            boardController.printMenu();
            boardController.printAllBoard();
            System.out.println("");
            System.out.println("메인 메뉴 : 1.Create | 2.Read | 3.Clear | 4.Exit");
            System.out.print("메뉴 선택: ");
            int menuNum = sc.nextInt();
            sc.nextLine();
            Map<Integer,Runnable> list = new HashMap<>();

            list.put(1, () -> {
                System.out.println("[새 게시물 입력]");
                System.out.println("제목: ");
                String title = sc.nextLine();
                System.out.println("내용: ");
                String content = sc.nextLine();
                System.out.println("작성자: ");
                String writer = sc.nextLine();
                System.out.println("보조 메뉴: 1.Ok | 2.Cancel");
                System.out.print("메뉴 선택: ");
                int supportMenuNum = sc.nextInt();
                if(supportMenuNum == 1){
                    boardController.create(title, content, writer);
                }
            });

            list.put(2, () -> {
                int bno = sc.nextInt();
                System.out.print("bno: ");
                sc.nextLine();
                boardController.read(bno);
                System.out.println("보조 메뉴: 1.Update | 2.Delete | 3.List");
                System.out.print("메뉴 선택: ");
                int supportMenuNum = sc.nextInt();
                if(supportMenuNum == 1){
                    sc.nextLine();
                    System.out.println("제목: ");
                    String title = sc.nextLine();
                    System.out.println("내용: ");
                    String content = sc.nextLine();
                    System.out.println("작성자: ");
                    String writer = sc.nextLine();
                    boardController.update(bno,title,content,writer);
                    System.out.println("보조 메뉴: 1.Ok | 2.Cancel");
                    System.out.print("메뉴 선택: ");
                    int supportMenuNum1 = sc.nextInt();
                    if(supportMenuNum1 == 1){
                        boardController.create(title, content, writer);
                    }
                }else if(supportMenuNum == 2){
                    boardController.delete(bno);
                }
            });

            list.put(3, () -> {
                boardController.clear();
                System.out.println("[전체 게시물 삭제]");
            });

            list.put(4, () -> {
                System.out.println("프로그램 종료");
                System.exit(0);
            });

            list.getOrDefault(menuNum, () -> System.out.println("잘못된 입력입니다.")).run();
        }
    }
}