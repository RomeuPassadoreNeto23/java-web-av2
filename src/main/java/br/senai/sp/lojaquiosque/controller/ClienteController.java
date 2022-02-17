package br.senai.sp.lojaquiosque.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.senai.sp.lojaquiosque.dao.DaoCliente;
import br.senai.sp.lojaquiosque.model.Cliente;
import br.senai.sp.lojaquiosque.model.FaixaEtaria;
import br.senai.sp.lojaquiosque.model.Genero;
import br.senai.sp.lojaquiosque.model.TipoProduto;

@Controller
public class ClienteController {
	
	
	@RequestMapping("formCliente")
	public String formGenero(Model model) {
		model.addAttribute("genero",Genero.values());
		model.addAttribute("tipos",TipoProduto.values());
		model.addAttribute("faixa",FaixaEtaria.values());
		
		return "formCliente";
		
	}
	
	@RequestMapping("listacliente")
	public String Listarcliente(Model model) {
		DaoCliente dao = new DaoCliente();
		model.addAttribute("Cliente",dao.listar());
		
		return "listacliente";
	}
	
	@RequestMapping("salvarClinete")
	public String salvarCliente(Cliente cliente) {
		System.out.println(cliente.getNome());
		System.out.println(cliente.getIdade());
		System.out.println(cliente.getEndereco());
		System.out.println(cliente.getTelefoOuCelular());
		System.out.println(cliente.getTipoproduto());
		System.out.println(cliente.getGenero());
		DaoCliente dao = new DaoCliente();
		dao.inserir(cliente);
		
		return "redirect:listacliente" ;
		
		
	}
	

}
