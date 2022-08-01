package com.api.parkingcontrol.model.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ParkingSpotDto {
    @NotBlank
    private String numeroVagaEstacionamento;
    @NotBlank
    @Size(max = 7)
    private String placaCarro;
    @NotBlank
    private String marcaCarro;
    @NotBlank
    private String modeloCar;
    @NotBlank
    private String corCarro;
    @NotBlank
    private String nomeresponsavel;
    @NotBlank
    private String apartamento;
    @NotBlank
    private String bloco;
}
