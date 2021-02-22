package com.ingeneo.services.usecases;

import com.ingeneo.services.model.dto.ApiResponse;
import com.ingeneo.services.model.entities.Formato;
import com.ingeneo.services.repositories.FormatoRepository;
import com.ingeneo.services.util.Constants;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FormatoUseCase {
    private final FormatoRepository formatoRepository;

    public FormatoUseCase(FormatoRepository formatoRepository) {
        this.formatoRepository = formatoRepository;
    }

    public ApiResponse getAll(){
        Optional<List<Formato>> formatos = formatoRepository.getAll();
        return formatos.map(formatosList -> new ApiResponse(Constants.SEARCH_SUCCESS_MESSAGE, formatosList,
                Constants.SUCCESS_CODE, true)).orElseGet(() -> new ApiResponse(Constants.SEARCH_SUCCESS_MESSAGE, null,
                Constants.SUCCESS_CODE, true));
    }
}
