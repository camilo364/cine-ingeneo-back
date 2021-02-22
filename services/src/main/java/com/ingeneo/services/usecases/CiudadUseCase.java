package com.ingeneo.services.usecases;

import com.ingeneo.services.model.dto.ApiResponse;
import com.ingeneo.services.model.entities.Ciudad;
import com.ingeneo.services.repositories.CiudadRepository;
import com.ingeneo.services.util.Constants;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CiudadUseCase {

    private final CiudadRepository ciudadRepository;

    public CiudadUseCase(CiudadRepository ciudadRepository){
        this.ciudadRepository = ciudadRepository;
    }

    public ApiResponse getAll(){
        Optional<List<Ciudad>> ciudades = ciudadRepository.getAll();
        return ciudades.map(ciudadesList -> new ApiResponse(Constants.SEARCH_SUCCESS_MESSAGE, ciudadesList,
                Constants.SUCCESS_CODE, true)).orElseGet(() -> new ApiResponse(Constants.SEARCH_SUCCESS_MESSAGE, null,
                Constants.SUCCESS_CODE, true));
    }
}
