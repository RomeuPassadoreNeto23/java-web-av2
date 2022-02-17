package br.senai.sp.lojaquiosque.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.senai.sp.lojaquiosque.dao.DaoCliente;
import br.senai.sp.lojaquiosque.model.Cliente;
import br.senai.sp.lojaquiosque.model.Genero;
import br.senai.sp.lojaquiosque.model.TipoProduto;

@Controller
public class ClienteController {
	
	public String form(Model model) {
		model.addAttribute("tipos",TipoProduto.values());
		return "formCliente";
		
	}
	@RequestMapping("formCliente")
	public String formGenero(Model model) {
		model.addAttribute("genero",Genero.values());
		return "formCliente";
		
	}
	
	@RequestMapping("listacliente")
	public String Listarcliente(Model model) {
		DaoCliente = new DaoCliente();
		model.addAttribute("produtos",dao.listar());
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
		
		
		return "redirect:listacliente" ;
		
		
	}
	

}
