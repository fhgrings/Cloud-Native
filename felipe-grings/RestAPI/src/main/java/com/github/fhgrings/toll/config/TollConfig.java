package com.github.fhgrings.toll.config;

import com.github.fhgrings.toll.service.CalculateChange;
import com.github.fhgrings.toll.service.PriceList;
import com.github.fhgrings.toll.app.Toll;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@ComponentScan(basePackages = "app.app")

@Component
public class TollConfig {

    @Bean
    public Toll toll(){
        return new Toll();
    }

    @Bean
    public CalculateChange calculateChange() {
        return new CalculateChange();
    }

    @Bean
    public PriceList priceList() {
        return new PriceList();
    }

}
