package br.senai.sp.lojaquiosque.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.senai.sp.lojaquiosque.model.TipoProduto;

@Controller
public class ClienteController {
	@RequestMapping("formCliente")
	public String form(Model model) {
		model.addAttribute("tipos",TipoProduto.values());
		return "formCliente";
		
	}

}
