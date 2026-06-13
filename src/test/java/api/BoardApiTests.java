package api;

import com.sii.entity.Board;
import com.sii.rest.BoardsApi;
import com.sii.utils.KanFaker;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.anyOf;
import static org.hamcrest.Matchers.is;

public class BoardApiTests extends BaseApiTest {

    @Test
    public void getBoards() {
        // given
        var publicWorkspaceId = getWorkspacePublicId();

        //when
        var response = BoardsApi.getAllBoardsForWorkspace(publicWorkspaceId);
        response.prettyPeek();
        response.then().statusCode(anyOf(is(200), is(201)));
    }

    @Test
    public void createBoard() {
        // given
        var publicWorkspaceId = getWorkspacePublicId();
        var board = new Board(KanFaker.boardName());

        // when
        var response = BoardsApi.createBoard(board, publicWorkspaceId);
        response
                .then()
                .statusCode(anyOf(is(200), is(201)));
    }
}
