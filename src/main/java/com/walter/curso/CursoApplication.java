package com.walter.curso;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.walter.curso.domain.Categoria;
import com.walter.curso.domain.Cidade;
import com.walter.curso.domain.Cliente;
import com.walter.curso.domain.Endereco;
import com.walter.curso.domain.Estado;
import com.walter.curso.domain.Produto;
import com.walter.curso.domain.enums.TipoCliente;
import com.walter.curso.repositories.CategoriaRepository;
import com.walter.curso.repositories.CidadeRepository;
import com.walter.curso.repositories.ClienteRepository;
import com.walter.curso.repositories.EnderecoRepository;
import com.walter.curso.repositories.EstadoRepository;
import com.walter.curso.repositories.ProdutoRepository;

@SpringBootApplication
public class CursoApplication implements CommandLineRunner {
	
	@Autowired
	CategoriaRepository categoriaRepository;
	
	@Autowired
	ProdutoRepository produtoRepository;

	@Autowired
	EstadoRepository estadoRepository;
	
	@Autowired
	CidadeRepository cidadeRepository;
	
	@Autowired
	ClienteRepository clienteRepository;
	
	@Autowired
	EnderecoRepository enderecoRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(CursoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Categoria cat1 = new Categoria(null, "informatica");
		Categoria cat2 = new Categoria(null, "escritorio");
		
		Produto p1 = new Produto(null, "computador", 2000.00);
		Produto p2 = new Produto(null, "impressora", 800.00);
		Produto p3 = new Produto(null, "mouse", 80.00);
		
		cat1.getProdutos().addAll(Arrays.asList(p1, p2, p3));
		cat2.getProdutos().addAll(Arrays.asList(p2));
		
		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1,cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));
		
		categoriaRepository.saveAll(Arrays.asList(cat1, cat2));		
		produtoRepository.saveAll(Arrays.asList(p1, p2, p3));
		
		Estado est1 = new Estado(null, "minas gerais");
		Estado est2 = new Estado(null, "sao paulo");
		
		Cidade cid1 = new Cidade(null, "uberlandia", est1);
		Cidade cid2 = new Cidade(null, "sao paulo", est2);
		Cidade cid3 = new Cidade(null, "campinas", est2);
		
		est1.getCidades().addAll(Arrays.asList(cid1));
		est2.getCidades().addAll(Arrays.asList(cid2, cid3));
		
		estadoRepository.saveAll(Arrays.asList(est1, est2));
		cidadeRepository.saveAll(Arrays.asList(cid1, cid2, cid3));
		
		Cliente cli1 = new Cliente(null, "maria silva", "maria@gmail.com", "01137358300", TipoCliente.PESSOA_FISICA);
		cli1.getTelefones().addAll(Arrays.asList("6182071249", "6191708314"));
		Endereco e1 = new Endereco(null, "rua tal", "555", "apto 100", "centro", "72000000", cli1, cid1);
		Endereco e2 = new Endereco(null, "avenida matos", "103", "sala 108", "jardim", "72000000", cli1, cid2);
		cli1.getEnderecos().addAll(Arrays.asList(e1, e2));		
		
		clienteRepository.saveAll(Arrays.asList(cli1));
		enderecoRepository.saveAll(Arrays.asList(e1, e2));
		
	}

	
	
}
