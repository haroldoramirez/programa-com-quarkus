package dev.haroldo;

import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;

import io.quarkus.arc.Lock;
import io.quarkus.arc.Lock.Type;

@Lock //Os metodos aqui dentro nao podem ser chamados de forma paralela, controla o acesso a alguns metodos especificos
@ApplicationScoped //BeanStateless uma instancia dessa classe em toda a minha aplicacao
public final class FrutasService {
	
	@Inject
	IdentificadorTransacao identificadorTransacao;
	
	@Lock(value = Type.READ, time = 3, unit = TimeUnit.SECONDS)
	public List<Fruta> list() {
		System.out.println(identificadorTransacao.getIdentificadorTransacao());
		return Fruta.listAll();
	}
	
	@Transactional
	public void novaFruta(InserirFrutaDTO inserirFrutaDTO) {
		
		System.out.println(identificadorTransacao.getIdentificadorTransacao());
		
		Fruta fruta = new Fruta();
		fruta.nome = "Maça";
		fruta.qtd = 5;
		fruta.persist();
		
	}

}
