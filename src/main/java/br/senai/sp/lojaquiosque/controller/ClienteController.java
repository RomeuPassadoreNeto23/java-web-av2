package br.senai.sp.lojaquiosque.controller;

import java.util.Calendar;

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
		dao.inserir(cliente);

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
	@RequestMapping("alterarProduto")
	public String alterar(long idcliente, Model model) {
		DaoCliente dao = new DaoCliente();
		//model.addAttribute("produto", dao.buscar(idcliente));
		
		return "forward:formProduto";
	}

}
