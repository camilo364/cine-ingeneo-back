package com.ingeneo.services.usecases;

import com.ingeneo.services.model.dto.ApiResponse;
import com.ingeneo.services.model.entities.Sucursal;
import com.ingeneo.services.model.exceptions.BusinessException;
import com.ingeneo.services.repositories.SucursalRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

class SucursalUseCaseTest {

    private SucursalRepository sucursalRepository;
    private SucursalUseCase useCase;

    @BeforeEach
    void setUp() {
        sucursalRepository = mock(SucursalRepository.class);
        useCase = new SucursalUseCase(sucursalRepository);
    }

    @Test
    void testFindByCiudad() {
        String idCiudad = "1";
        List<Sucursal> sucursals = new ArrayList<>();
        sucursals.add(new Sucursal(1, "MONTERREY", "ALGUNA", 1, 1, ""));

        when(sucursalRepository.findByCiudad(anyInt())).thenReturn(Optional.of(sucursals));

        ApiResponse apiResponse = useCase.findByCiudad(idCiudad);
        verify(sucursalRepository).findByCiudad(anyInt());
        assertNotNull(apiResponse);
        assertEquals(200, apiResponse.getStatus());
    }

    @Test
    void testFindByCiudadErrorOnParam() {
        BusinessException thrown = assertThrows(
                BusinessException.class,
                () -> useCase.findByCiudad("s"));

        assertNotNull(thrown);
        assertEquals("El id de la ciudad no es un numero", thrown.getMessage());
    }
}
