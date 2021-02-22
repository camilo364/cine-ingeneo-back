package com.ingeneo.services.controllers;

import com.ingeneo.services.model.dto.ApiResponse;
import com.ingeneo.services.usecases.FormatoUseCase;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FormatoController {
    private final FormatoUseCase useCase;

    public FormatoController(FormatoUseCase useCase) {
        this.useCase = useCase;
    }

    @GetMapping("/ingeneo/api/formatos")
    public ResponseEntity<ApiResponse> getAll(){
        ApiResponse apiResponse = useCase.getAll();
        return ResponseEntity.status(apiResponse.getStatus()).body(apiResponse);
    }
}
