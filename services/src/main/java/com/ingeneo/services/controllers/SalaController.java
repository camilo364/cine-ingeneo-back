package com.ingeneo.services.controllers;

import com.ingeneo.services.model.dto.ApiResponse;
import com.ingeneo.services.model.dto.request.CreateRoom;
import com.ingeneo.services.usecases.SalaUseCase;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SalaController {

    private final SalaUseCase useCase;

    public SalaController(SalaUseCase useCase) {
        this.useCase = useCase;
    }

    @PostMapping("/ingeneo/api/salas/crearSala")
    public ResponseEntity<ApiResponse> createRoom(@RequestBody CreateRoom request){
        ApiResponse apiResponse = useCase.crearSala(request);
        return ResponseEntity.status(apiResponse.getStatus()).body(apiResponse);
    }
}
