package br.com.alura.microservice.loja.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.com.alura.microservice.loja.client.FornecedorClient;
import br.com.alura.microservice.loja.dto.CompraDTO;
import br.com.alura.microservice.loja.dto.InfoFornecedorDTO;

@Service
public class CompraService {
	
	@Autowired
	private FornecedorClient fornecedorClient;
	
	public void realizaCompra(CompraDTO compra) {
		
		InfoFornecedorDTO info = fornecedorClient.getInfoPoEstado(compra.getEndereco().getEstado());
		
		System.out.println(info.getEndereco());
	}

}
