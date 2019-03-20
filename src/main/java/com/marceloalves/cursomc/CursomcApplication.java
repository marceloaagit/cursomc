package com.marceloalves.cursomc;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.marceloalves.cursomc.domain.Categoria;
import com.marceloalves.cursomc.domain.Cidade;
import com.marceloalves.cursomc.domain.Estado;
import com.marceloalves.cursomc.domain.Produto;
import com.marceloalves.cursomc.repositoreis.CategoriaRepositoy;
import com.marceloalves.cursomc.repositoreis.CidadeRepositoy;
import com.marceloalves.cursomc.repositoreis.EstadoRepositoy;
import com.marceloalves.cursomc.repositoreis.ProdutoRepositoy;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner {

	@Autowired
	CategoriaRepositoy categoriaRepository;

	@Autowired
	ProdutoRepositoy produtoRepositoy;
	
	@Autowired
	CidadeRepositoy cidadeRepositoy;
	
	@Autowired
	EstadoRepositoy estadoRepositoy;

	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Categoria cat1 = new Categoria(null, "Informática");
		Categoria cat2 = new Categoria(null, "Escritório");

		Produto p1 = new Produto(null, "Computador", 2000.0);
		Produto p2 = new Produto(null, "Impressora", 800.0);
		Produto p3 = new Produto(null, "Mouse", 80.0);

		cat1.getProdutos().addAll(Arrays.asList(p1, p2, p3));
		cat2.getProdutos().addAll(Arrays.asList(p2));

		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1, cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));

		categoriaRepository.saveAll(Arrays.asList(cat1, cat2));
		produtoRepositoy.saveAll(Arrays.asList(p1, p2, p3));
		
		Estado est1 = new Estado(null, "Minas Gerais");
		Estado est2 = new Estado(null, "São Paulo");
		
		Cidade c1 = new Cidade(null, "Uberlândia", est1);
		Cidade c2 = new Cidade(null, "São Paulo", est2);
		Cidade c3 = new Cidade(null, "Campinas", est2);
		
		
		est1.getCidades().addAll(Arrays.asList(c1));
		est2.getCidades().addAll(Arrays.asList(c2, c3));
		
		estadoRepositoy.saveAll(Arrays.asList(est1, est2));
		cidadeRepositoy.saveAll(Arrays.asList(c1, c2, c3));
		
		

	}

}
