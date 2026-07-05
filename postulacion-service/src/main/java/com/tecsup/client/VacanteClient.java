package com.tecsup.client;

import com.tecsup.dto.VacanteDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "vacante-service")
public interface VacanteClient {

    @GetMapping("/api/vacantes/{id}")
    VacanteDTO obtenerVacante(@PathVariable Long id);
}