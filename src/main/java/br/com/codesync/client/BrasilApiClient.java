package br.com.codesync.client;

import br.com.codesync.client.dto.response.BrasilAddressResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;


@HttpExchange("/cep/v1")
public interface BrasilApiClient {

    @GetExchange("/{cep}")
    ResponseEntity<BrasilAddressResponse> getAddressByZipCode(@PathVariable("cep") String cep);
}
