package dev.haroldo;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;

import io.quarkus.arc.DefaultBean;
import io.quarkus.arc.profile.IfBuildProfile;

public class IdentificadorTransacaoProducer {
	
	@Produces
	@DefaultBean
	@RequestScoped
	public IdentificadorTransacao produceTeste() {
		return new IdentificadorTransacao("Teste-");
	}
	
	@Produces
	@IfBuildProfile("prod")
	@RequestScoped
	public IdentificadorTransacao produceProd() {
		return new IdentificadorTransacao("Prod-");
	}

}
