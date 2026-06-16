package com.sii.api;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record BoardResponse(
        String publicId,
        String name,
        String slug,
        String type,
        String visibility
) {}
