package br.senai.sp.lojaquiosque.controller;

import org.springframework.stereotype.Controller;

import br.senai.sp.lojaquiosque.dao.ConnectionFactory;

@Controller
public class indexController {
	public String index() {
		System.out.println("passou aqui "+ ConnectionFactory.conectar());
		return "index";
	}

}
