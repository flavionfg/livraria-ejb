package br.com.caelum.livraria.dao;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.inject.Inject;

import br.com.caelum.livraria.modelo.Autor;

@Stateless
public class AutorDao {

	@Inject
	private Banco banco;
	
	@PostConstruct
	void aposCriacao() {
		System.out.println("AutorDao foi criado");
	}

	public void salva(Autor autor) {
		
		System.out.println("Salvando Autor " + autor.getNome());
		
		try {
			Thread.sleep(20000);//20 segundos
		} catch (InterruptedException e) {
			e.printStackTrace();
		} 
		
		
		banco.save(autor);
	}
	
	public List<Autor> todosAutores() {
		return banco.listaAutores();
	}

	public Autor buscaPelaId(Integer autorId) {
		Autor autor = this.banco.buscaPelaId(autorId);
		return autor;
	}
	
}
