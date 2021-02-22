package com.ingeneo.services.usecases;

import com.ingeneo.services.model.dto.ApiResponse;
import com.ingeneo.services.model.entities.Sucursal;
import com.ingeneo.services.model.exceptions.BusinessException;
import com.ingeneo.services.repositories.SucursalRepository;
import com.ingeneo.services.util.Constants;
import com.ingeneo.services.util.Validations;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SucursalUseCase {
    private final SucursalRepository sucursalRepository;

    public SucursalUseCase(SucursalRepository sucursalRepository) {
        this.sucursalRepository = sucursalRepository;
    }

    public ApiResponse findByCiudad(String idCiudad){
        if(idCiudad == null || Validations.isNotANumber(idCiudad)){
            throw new BusinessException("El id de la ciudad no es un numero");
        }
        Optional<List<Sucursal>> sucursales = sucursalRepository.findByCiudad(Integer.parseInt(idCiudad));

        return sucursales.map(sucursalesList -> new ApiResponse(Constants.SEARCH_SUCCESS_MESSAGE, sucursalesList,
                Constants.SUCCESS_CODE, true)).orElseGet(() -> new ApiResponse(Constants.SEARCH_SUCCESS_MESSAGE, null,
                Constants.SUCCESS_CODE, true));
    }
}
