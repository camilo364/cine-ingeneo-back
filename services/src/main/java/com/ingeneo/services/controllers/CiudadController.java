package com.ingeneo.services.controllers;

import com.ingeneo.services.model.dto.ApiResponse;
import com.ingeneo.services.usecases.CiudadUseCase;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CiudadController {

    private final CiudadUseCase useCase;

    public CiudadController(CiudadUseCase useCase){
        this.useCase = useCase;
    }
    
    @GetMapping("/ingeneo/api/ciudades")
    public ResponseEntity<ApiResponse> getAll(){
        ApiResponse apiResponse = useCase.getAll();
        return ResponseEntity.status(apiResponse.getStatus()).body(apiResponse);
    }
}
