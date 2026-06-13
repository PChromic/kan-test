package com.sii.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonValue;
import com.sii.utils.KanFaker;
import lombok.RequiredArgsConstructor;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record Board(
        String name,
        List<String> lists,
        List<String> labels,
        BoardType type,
        String sourceBoardPublicId
) {
    public Board(String name) {
        this(name, List.of(), List.of(), null, null);
    }

    @RequiredArgsConstructor
    public enum BoardType {
        REGULAR("regular"),
        TEMPLATE("template");

        private final String value;

        @JsonValue
        public String getValue() { return value; }
    }
}
