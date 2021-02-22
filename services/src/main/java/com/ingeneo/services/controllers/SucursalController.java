package com.ingeneo.services.controllers;

import com.ingeneo.services.model.dto.ApiResponse;
import com.ingeneo.services.usecases.SucursalUseCase;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SucursalController {

    private final SucursalUseCase useCase;

    public SucursalController(SucursalUseCase useCase) {
        this.useCase = useCase;
    }

    @GetMapping("/ingeneo/api/sucursales")
    public ResponseEntity<ApiResponse> getAll(@RequestParam("idCiudad") String idCiudad){
        ApiResponse apiResponse = useCase.findByCiudad(idCiudad);
        return ResponseEntity.status(apiResponse.getStatus()).body(apiResponse);
    }
}
