package br.com.pipoca.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.pipoca.model.entity.Filme;
import br.com.pipoca.model.service.FilmeService;

@Controller
public class ManterFilmesController {
	private FilmeService filmeService;
    
	public ManterFilmesController() {
        filmeService = new FilmeService();
    }
    
    @RequestMapping("/novo")
	public String novoFilme() {
		return "NovoFilme";
	}
	@RequestMapping("/inserir")
	public ModelAndView inserirFilme(@Valid Filme filme) {
		ModelAndView andView = new ModelAndView("Resultado");
		andView.addObject("filme", filme);
		return andView;
	}
}