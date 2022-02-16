package br.senai.sp.lojaquiosque.controller;

import org.springframework.stereotype.Controller;

@Controller
public class indexController {
	public String index() {
		System.out.println("passou aqui");
		return "index";
	}

}
