package com.ingeneo.services.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ApiResponse {
    private final String message;
    private final Object data;
    private final int status;
    private final boolean success;
}
