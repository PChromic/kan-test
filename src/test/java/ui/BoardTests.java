package ui;

import com.sii.entity.Board;
import com.sii.pageobjects.BoardsOverviewPage;
import com.sii.rest.BoardsApi;
import com.sii.utils.KanFaker;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;


public class BoardTests extends UserAlreadyLoggedInTest {
    private final BoardsOverviewPage boardsOverviewPage = new BoardsOverviewPage();
    private String apiBoardName;

    @BeforeMethod(onlyForGroups = {"createBoard"})
    public void createBoardViaApi() {
        apiBoardName = KanFaker.boardName();
        BoardsApi.createBoard(new Board(apiBoardName), WORKSPACE_ID);
    }

    @Test
    public void cleanUp() {
        var boards = (List<String>) BoardsApi.getAllBoardsForWorkspace(WORKSPACE_ID).body().jsonPath().get("publicId");
        for (var board : boards) {
            BoardsApi.removeBoard(board);
        }
    }

    @Test
    public void shouldCreateNewBoard_ThenArchive() {
        // given
        var boardName = KanFaker.boardName();

        boardsOverviewPage
                .clickNewBoard()
                .enterName(boardName)
                .submit()
                .clickOptionsMenu()
                // when
                .clickArchiveBoard()
                // then
                .validateBoardWithNameIsNotActive(boardName)
                .clickArchivedTab()
                .validateBoardWithNameIsArchived(boardName);
    }

    @Test(groups = {"createBoard"})
    public void shouldCreateNewBoard_ThenArchive_ThenReturnToActive() {
        // when
        boardsOverviewPage
                .get()
                .getBoardCardByName(apiBoardName)
                .click()
                .clickNewCard();
    }
}
