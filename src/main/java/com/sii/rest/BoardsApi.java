package com.sii.rest;

import com.sii.domain.dto.Board;
import io.restassured.response.Response;

import static com.sii.utils.ApiConfig.createRequestSpec;
import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;

public class BoardsApi {

    public static Response createBoard(Board board, String publicWorkspaceId) {
        return given(createRequestSpec(true))
                .pathParam("id", publicWorkspaceId)
                .contentType(JSON)
                .body(board)
                .post("/workspaces/{id}/boards");
    }

    public static Response getAllBoardsForWorkspace(String publicWorkspaceId) {
        return given(createRequestSpec(true))
                .pathParam("id", publicWorkspaceId)
                .get("/workspaces/{id}/boards");
    }

    public static Response removeBoard(String boardPublicId) {
        return given(createRequestSpec(true))
                .pathParam("id", boardPublicId)
                .delete("/boards/{id}");
    }
}