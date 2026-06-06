package api;

import com.sii.rest.BoardsApi;
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
}
