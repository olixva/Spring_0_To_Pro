package com.example.springframework.config;

import com.example.springframework.primary.CustomerAServiceImpl;
import com.example.springframework.primary.CustomerService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
// Esta anotacion se usa para importar configuraciones de xml (no se usa)
// @ImportResource()
public class BeansConfig {

    /*
    Esta opcion se usa para configurar clases que provienen de frameworks/librerias externas
     */
    @Bean
    public CustomerService customerAService() {
        return new CustomerAServiceImpl();
    }
}
