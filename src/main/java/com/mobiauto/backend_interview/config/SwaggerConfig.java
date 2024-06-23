package com.mobiauto.backend_interview.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI defaultOpenAPI() {
        Server server = new Server();
        server.setUrl("http://localhost:8080");
        server.setDescription("Development MobiAuto");

        Contact contact = new Contact();
        contact.setName("Henrique Sena");
        contact.setUrl("https://henriquegsena.github.io/");

        Info info = new Info()
                .title("Documentacao de Api Mobiauto")
                .version("1.0.0")
                .description("Ferramenta de gestao de revendas de veiculos")
                .contact(contact);
        return  new OpenAPI().info(info).servers(List.of(server));
    }
}
