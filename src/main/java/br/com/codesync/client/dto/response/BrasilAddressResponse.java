package br.com.codesync.client.dto.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record BrasilAddressResponse(
		String cep,
	    String state,
	    String city,
	    String neighborhood,
	    String street,
	    String service) {

}
