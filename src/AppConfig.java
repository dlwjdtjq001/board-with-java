import controller.BoardController;
import controller.BoardControllerImp;
import repository.BoardRepository;
import repository.BoardRepositoryImp;
import service.BoardService;
import service.BoardServiceImp;

public class AppConfig {
    private BoardRepository getBoardRepository(){
        return new BoardRepositoryImp();
    }

    public BoardService getBoardService(){
        return new BoardServiceImp(getBoardRepository());
    }

    public BoardController getBoardController(){
        return new BoardControllerImp(getBoardService());
    }
}
