package br.com.alura.microservice.loja.services;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.alura.microservice.loja.client.FornecedorClient;
import br.com.alura.microservice.loja.dto.CompraDTO;
import br.com.alura.microservice.loja.dto.InfoPedidoDTO;
import br.com.alura.microservice.loja.model.Compra;
import org.slf4j.Logger;

@Service
public class CompraService {
	
	private static Logger logger = LoggerFactory.getLogger(CompraService.class);
	
	@Autowired
	private FornecedorClient fornecedorClient;
	
	public Compra realizaCompra(CompraDTO compra) {
		
		//InfoFornecedorDTO info = fornecedorClient.getInfoPoEstado(compra.getEndereco().getEstado());
		
		logger.info("Compra: {}", compra);
		
		InfoPedidoDTO pedido = fornecedorClient.realizaPedido(compra.getItens());
		
		fornecedorClient.realizaPedido(compra.getItens());
					
		Compra compraSalva = new Compra();
		compraSalva.setPedidoId(pedido.getId());
		compraSalva.setTempoDePreparo(pedido.getTempoDePreparo());
		compraSalva.setEnderecoDestino(compra.getEndereco().toString());
		
		return compraSalva;
	}

}
