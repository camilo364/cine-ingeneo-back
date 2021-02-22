package com.ingeneo.services.usecases;

import com.ingeneo.services.model.dto.ApiResponse;
import com.ingeneo.services.model.dto.request.ChairArrangement;
import com.ingeneo.services.model.dto.request.CreateRoom;
import com.ingeneo.services.model.entities.Regla;
import com.ingeneo.services.model.entities.Sala;
import com.ingeneo.services.model.entities.Silla;
import com.ingeneo.services.model.exceptions.BusinessException;
import com.ingeneo.services.repositories.ReglaRepository;
import com.ingeneo.services.repositories.SalaRepository;
import com.ingeneo.services.repositories.SillaRepository;
import com.ingeneo.services.util.Constants;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SalaUseCase {

    private final SalaRepository salaRepository;
    private final ReglaRepository reglaRepository;
    private final SillaRepository sillaRepository;

    public SalaUseCase(SalaRepository salaRepository, ReglaRepository reglaRepository,
                       SillaRepository sillaRepository) {
        this.salaRepository = salaRepository;
        this.reglaRepository = reglaRepository;
        this.sillaRepository = sillaRepository;
    }

    public ApiResponse crearSala(CreateRoom request){
        Optional<Regla> maxRowRule = reglaRepository.findByProcessAndRule(
                Constants.CREATE_ROOM_PROCESS_NAME, Constants.MAX_ROWS_RULE_NAME);
        Optional<Regla> minRowRule = reglaRepository.findByProcessAndRule(
                Constants.CREATE_ROOM_PROCESS_NAME, Constants.MIN_ROWS_RULE_NAME);
        int maxRows = maxRowRule.map(rule -> Integer.parseInt(rule.getValue())).orElseGet(() -> 27);
        int minRows = minRowRule.map(rule -> Integer.parseInt(rule.getValue())).orElseGet(() -> 3);

        if(request.getArrows() < minRows || request.getArrows() > maxRows){
            throw new BusinessException(
                    String.format("La cantidad de filas debe estar entre %s y %s", minRows, maxRows));
        }

        if(request.getChairs() == null || request.getChairs().length != request.getArrows()){
            throw new BusinessException("Debe asignar un numero de sillas para cada fila");
        }

        validateChairsArrangement(request.getChairs());

        Sala sala = new Sala(null, request.getName(), request.getArrows(), request.getFormat(), request.getBranch());
        sala = salaRepository.save(sala);
        createChairs(request, sala.getId());
        return new ApiResponse("Sala creada correctamente", sala, Constants.SUCCESS_CODE, true);
    }

    private void validateChairsArrangement(ChairArrangement[] chairArrangements){
        Optional<Regla> maxChairRule = reglaRepository.findByProcessAndRule(
                Constants.CREATE_ROOM_PROCESS_NAME, Constants.MAX_CHAIR_RULE_NAME);
        Optional<Regla> minChairRule = reglaRepository.findByProcessAndRule(
                Constants.CREATE_ROOM_PROCESS_NAME, Constants.MIN_CHAIR_RULE_NAME);
        int maxChairs = maxChairRule.map(rule -> Integer.parseInt(rule.getValue())).orElseGet(() -> 10);
        int minChairs = minChairRule.map(rule -> Integer.parseInt(rule.getValue())).orElseGet(() -> 3);

        for (ChairArrangement c : chairArrangements) {
            if(c.getChairs() < minChairs || c.getChairs() > maxChairs){
                throw new BusinessException(
                        String.format("El numero de sillas para cada fila debe estar entre %s y %s",
                                minChairs, maxChairs));
            }
        }
    }

    private void createChairs(CreateRoom request, int idRoom){
        for(int i = 0; i<request.getArrows(); i++){
            ChairArrangement chairArrangement = request.getChairs()[i];
            String letter = Character.toString((char)('A'+i));
            for(int j = 0; j< chairArrangement.getChairs(); j++){
                Silla silla = new Silla(null, idRoom, letter, j+1, Constants.ENABLE);
                sillaRepository.save(silla);
            }
        }
    }
}
