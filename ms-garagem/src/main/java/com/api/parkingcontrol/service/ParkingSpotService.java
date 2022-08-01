package com.api.parkingcontrol.service;

import com.api.parkingcontrol.model.entites.ParkingSpot;
import com.api.parkingcontrol.model.dto.ParkingSpotDto;
import com.api.parkingcontrol.model.exception.ObjectConflictException;
import com.api.parkingcontrol.model.exception.ObjectInternalErrorExcption;
import com.api.parkingcontrol.model.exception.ObjectNotFoundException;
import com.api.parkingcontrol.repository.ParkingSpotRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Optional;


@RequiredArgsConstructor
@Service
public class ParkingSpotService {

    private final ParkingSpotRepository parkingSpotRepository;

    @Transactional
    public ParkingSpot save(ParkingSpotDto parkingSpotDto){
        try{
            findByPlacaCarro(parkingSpotDto.getPlacaCarro());
            findByNVagaEstacionamento(parkingSpotDto.getNumeroVagaEstacionamento());
            findApartamentoAndBloco(parkingSpotDto.getApartamento(),parkingSpotDto.getBloco());
            var parkingSpot= new ParkingSpot();
            BeanUtils.copyProperties(parkingSpotDto,parkingSpot);
            parkingSpot.setDataRegistro(LocalDateTime.now(ZoneId.of("UTC")));
            return parkingSpotRepository.save(parkingSpot);
        } catch (ObjectConflictException exception){
            throw new ObjectConflictException(exception.getMessage());
        } catch (RuntimeException exception){
           throw new ObjectInternalErrorExcption(exception.getMessage());
        }


    }

    public Page<ParkingSpot> findAll(Pageable pageable){
        return parkingSpotRepository.findAll(pageable);
    }
    public ParkingSpot findById(Long id){
        Optional<ParkingSpot> parkingSpot= parkingSpotRepository.findById(id);
        if(!parkingSpot.isPresent()){
            throw new ObjectNotFoundException("Vaga nao encontrada...");

        }
        return parkingSpot.get();
    }
    @Transactional
    public void delete(Long id) {
        Optional<ParkingSpot> parkingSpot= Optional.ofNullable(findById(id));
        parkingSpotRepository.delete(parkingSpot.get());
    }

    public ParkingSpot update(Long id, ParkingSpotDto parkingSpotDto){
        Optional<ParkingSpot>parkingSpot=Optional.ofNullable(findById(id));
        parkingSpot.get().MapperDto(parkingSpotDto);
        return parkingSpotRepository.save(parkingSpot.get());
    }

    private boolean findByPlacaCarro(String placaCarro){
        if(parkingSpotRepository.existsByPlacaCarro(placaCarro)){
          throw new ObjectConflictException("Conflito : carro ja esta registrado!!");
        }
        return  parkingSpotRepository.existsByPlacaCarro(placaCarro);
    }

    private boolean findByNVagaEstacionamento(String VEstacionamento){
        if(parkingSpotRepository.existsByNumeroVagaEstacionamento(VEstacionamento)){
            throw new ObjectConflictException("Conflito : Vaga j[a esta sendo usada!!");
        }
        return parkingSpotRepository.existsByNumeroVagaEstacionamento(VEstacionamento);
    }

    private boolean findApartamentoAndBloco(String apartamento, String bloco){
        if(parkingSpotRepository.existsByApartamentoAndBloco(apartamento,bloco)){
            throw new ObjectConflictException("Conflito : ja tem uma vaga registrada para o Apartamento e bloco !!");
        }
        return parkingSpotRepository.existsByApartamentoAndBloco(apartamento,bloco);
    }


}
