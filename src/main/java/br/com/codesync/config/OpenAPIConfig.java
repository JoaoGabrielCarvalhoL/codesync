package br.com.codesync.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenAPIConfig {

    private static final String SECURITY_SCHEME_NAME = "bearerAuth";

    @Bean
    public OpenAPI openApi() {

        return new OpenAPI()
                .addSecurityItem(new SecurityRequirement().addList(SECURITY_SCHEME_NAME))
                .components(new Components().addSecuritySchemes("security", this.securityScheme()))
                .info(new Info()
                        .title("Codesync")
                        .version("1.0.0")
                        .description("Core Backend Platform for CodeSync Project Management and Analysis.")
                        .contact(new Contact()
                                .name("João Gabriel Carvalho")
                                .email("quantitech@mail.com")
                                .url("https://github.com/JoaoGabrielCarvalhoL/codesync"))
                        .license(new License()
                                .name("Apache 2.0")
                                .url("https://www.apache.org/licenses/LICENSE-2.0.html")));
    }

    private SecurityScheme securityScheme() {
        return new SecurityScheme().description("Insert Bearer Token Valid")
                .type(SecurityScheme.Type.HTTP)
                .in(SecurityScheme.In.HEADER)
                .scheme("bearer")
                .bearerFormat("JWT")
                .name("security");
    }
}
