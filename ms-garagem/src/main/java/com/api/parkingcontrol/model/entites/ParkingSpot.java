package com.api.parkingcontrol.model.entites;


import com.api.parkingcontrol.model.dto.ParkingSpotDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;


@Entity
@Table(name = "TB_PARKING_SPOT")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ParkingSpot implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = false,unique = true,length = 10)
    private String numeroVagaEstacionamento;
    @Column(nullable = false,unique = true,length = 7)
    private String placaCarro;
    @Column(nullable = false,length = 70)
    private String marcaCarro;
    @Column(nullable = false,length = 70)
    private String modeloCar;
    @Column(nullable = false,length = 70)
    private String corCarro;
    @Column(nullable = false)
    private LocalDateTime dataRegistro;
    @Column(nullable = true,length = 130)
    private String nomeresponsavel;
    @Column(nullable = false,length = 30)
    private String apartamento;
    @Column(nullable = false,length = 30)
    private String bloco;

    public  void MapperDto(ParkingSpotDto parkingSpotDto){
        this.numeroVagaEstacionamento=parkingSpotDto.getNumeroVagaEstacionamento();
        this.placaCarro=parkingSpotDto.getPlacaCarro();
        this.marcaCarro=parkingSpotDto.getMarcaCarro();
        this.modeloCar=parkingSpotDto.getModeloCar();
        this.corCarro=parkingSpotDto.getCorCarro();
        this.nomeresponsavel=parkingSpotDto.getNomeresponsavel();
        this.apartamento=parkingSpotDto.getApartamento();
        this.bloco=parkingSpotDto.getBloco();
    }


}
