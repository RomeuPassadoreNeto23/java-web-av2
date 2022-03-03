package br.senai.sp.lojaquiosque.controller;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.senai.sp.lojaquiosque.dao.DaoCliente;
import br.senai.sp.lojaquiosque.model.Cliente;
import br.senai.sp.lojaquiosque.model.FaixaEtaria;
import br.senai.sp.lojaquiosque.model.Genero;
import br.senai.sp.lojaquiosque.model.TelefoneOuCelular;
import br.senai.sp.lojaquiosque.model.TipoProduto;

@Controller
public class ClienteController {

	@RequestMapping("formCliente")
	public String formGenero(Model model) {
		model.addAttribute("genero", Genero.values());
		model.addAttribute("tipos", TipoProduto.values());
		model.addAttribute("faixa", FaixaEtaria.values());
		model.addAttribute("tptelefone", TelefoneOuCelular.values());

		return "formCliente";

	}

	@RequestMapping("salvarClinete")
	public String salvarCliente(Cliente cliente) {
		System.out.println(cliente.getNome());
		System.out.println(cliente.getEndereco());
		System.out.println(cliente.getContato());
		System.out.println(cliente.getTptelefone());
		System.out.println(cliente.getEmail());
		System.out.println(cliente.getTprodutos());
		System.out.println(cliente.getIdade());
		System.out.println(cliente.getFaixa_etaria());

		DaoCliente dao = new DaoCliente();
		cliente.setEatacadastro(Calendar.getInstance());
		if(cliente.getId() == null) {
			dao.inserir(cliente);
		}else {
			dao.atualizar(cliente);
		}

		


		return "redirect:listacliente";

	}

	@RequestMapping("listacliente")
	public String Listarcliente(Model model) {
		DaoCliente dao = new DaoCliente();
		model.addAttribute("cliente", dao.listar());

		return "listacliente";
	}

	@RequestMapping("excluirCliente")
	public String excluir(long idcliente) {
		DaoCliente dao = new DaoCliente();
		dao.excluir(idcliente);
		return "redirect:listacliente";
		
	}
	@RequestMapping("alterarCliente")
	public String alterar(long idcliente, Model model) {
		model.addAttribute("genero", Genero.values());
		model.addAttribute("tipos", TipoProduto.values());
		model.addAttribute("faixa", FaixaEtaria.values());
		model.addAttribute("tptelefone", TelefoneOuCelular.values());
		DaoCliente dao = new DaoCliente();
		model.addAttribute("cliente", dao.buscar(idcliente));
		
		return "forward:formCliente";
	}
	@RequestMapping("tabelaestajsp")
	public String tabelaestajsp(Model model) {
		DaoCliente dao = new DaoCliente();
		model.addAttribute("generoh", dao.listargeneroh().size());
		DaoCliente dao2 = new DaoCliente();
		model.addAttribute("mulher", dao2.listargef().size());
		DaoCliente dao3 = new DaoCliente();
	
		int idadecli = 0;
		int jovem = 0;
		int adulto = 0;
		int idoso = 0;
		for(Cliente i : dao3.listaridade()) {
			  idadecli = i.getIdade();
			  if(idadecli < 20) {
				  jovem += 1;
				  System.out.println(jovem);
			  }else if (idadecli > 20) {
				  adulto += 1;
				  System.out.println(adulto);
				
			}else if (idadecli > 50) {
				idoso += 1;
				System.out.println(idoso);
				
			}
			  
		}
		model.addAttribute("jovem",jovem );
		model.addAttribute("adulto",adulto );
		model.addAttribute("idoso",idoso );
		DaoCliente dao4 = new DaoCliente();
		//@DateTimeFormat(pattern = "hh:mm:ss")
		
		
		 
		Date hora;
		for(Cliente i :dao4.listar()) {
			
	       	hora =	i.getEatacadastro().getTime();
			
		}
		
	    

		return "tabelaestajsp";
	}

}
