package com.sii.rest;

import io.restassured.response.Response;

import static com.sii.utils.ApiConfig.createRequestSpec;
import static io.restassured.RestAssured.given;

public class BoardsApi {

    public static Response getAllBoardsForWorkspace(String publicWorkspaceId) {
        return given(createRequestSpec(true))
                .pathParam("id", publicWorkspaceId)
                .get("/workspaces/{id}/boards");
    }
}