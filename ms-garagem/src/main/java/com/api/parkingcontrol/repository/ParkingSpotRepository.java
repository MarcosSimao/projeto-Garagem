package com.api.parkingcontrol.repository;

import com.api.parkingcontrol.model.entites.ParkingSpot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ParkingSpotRepository extends JpaRepository<ParkingSpot, Long> {

    boolean existsByPlacaCarro(String placaCarro);
    boolean existsByNumeroVagaEstacionamento(String n);
    boolean existsByApartamentoAndBloco(String apartamento,String bloco);
}
