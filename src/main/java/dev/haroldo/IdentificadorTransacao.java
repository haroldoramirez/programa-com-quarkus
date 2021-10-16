package dev.haroldo;

import java.time.Instant;
import java.util.Random;

public class IdentificadorTransacao {
	
	private String prefixo;
	private int idTransacao;
	private Instant inicio;
	
	public IdentificadorTransacao(String prefixo) {
		super();
		this.prefixo = prefixo;
		this.idTransacao = new Random().nextInt();
		this.inicio = Instant.now();
	}

	public String getIdentificadorTransacao() {
		return prefixo + idTransacao + " - " + inicio;
	}
	
}
