package br.com.pipoca.model.service;

import java.io.IOException;
import br.com.pipoca.dao.FilmeDAO;
import br.com.pipoca.model.entity.Filme;

public class FilmeService {
	private FilmeDAO dao;
	
	public FilmeService() {
		dao = new FilmeDAO();
	}
	
	public Filme buscarFilme(int id) throws IOException{
		return dao.buscarFilme(id);
	}
	
	public Filme inserirFilme(Filme filme) throws IOException {
		int id = dao.inserirFilme(filme);
		filme.setId(id);
		return filme;
	}

}
