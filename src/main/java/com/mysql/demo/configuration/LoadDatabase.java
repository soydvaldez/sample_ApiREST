package com.mysql.demo.configuration;

import com.mysql.demo.api.orders.repository.Order;
import com.mysql.demo.api.orders.repository.OrderRepository;
import com.mysql.demo.api.orders.OrderStatus;
import lombok.extern.log4j.Log4j2;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;
import java.time.ZoneId;

@Configuration
@Log4j2
public class LoadDatabase {
    @Bean
    CommandLineRunner initDatabase(OrderRepository repository) {

        return args -> {
            Order order = new Order();
            order.setNombre("Antonio");
            order.setApellidoPaterno("Garcia");
            order.setApellidoMaterno("Garza");
            order.setCiudad("Cd Mexico");
            order.setCodigoPostal(5000);
            order.setColonia("Alta Tension");
            order.setDomicilio("Av San Jeronimo Colonia.Alta Tension Numero 1500");
            order.setEstado("Cd Mexico");
            order.setColonia("Alta Tension");
            order.setFechaPedido(LocalDateTime.now(ZoneId.of("UTC")));
            order.setReferencias("Enfrente de un corporativo, grupo Bimbo");
            order.setStatus(OrderStatus.PENDING);

            log.info("Preloading " + repository.save(order));
        };
    }
}
