package com.senai.rafael.PrjLivro.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.senai.rafael.PrjLivro.entities.Livro;
import com.senai.rafael.PrjLivro.services.LivroService;




@RestController
@RequestMapping("/livros")
public class LivroController {
	
	@GetMapping("/home")
    public String paginaInicial() {
        return "index";
    }
	private final LivroService livroService;
	
	@Autowired
	public LivroController(LivroService livroService) {
		this.livroService = livroService;		
	}
	@GetMapping("/{id}")	
    public ResponseEntity<Livro> getJogo(@PathVariable Long id) {
        Livro livro = livroService.getLivroById(id);
        if (livro != null) {
            return ResponseEntity.ok(livro);
        } else {
            return ResponseEntity.notFound().build();
        }
    }	
	@PostMapping
	public Livro createLivro(@RequestBody Livro livro) {
		return livroService.saveLivro(livro);
	}
	
	@DeleteMapping("/{id}")
	public void deleteLivro(@PathVariable Long id) {
		livroService.deleteLivro(id);
	}
	
		@GetMapping
		public ResponseEntity<List<Livro>> getAllLivros(RequestEntity<Void> requestEntity) {
			String method = requestEntity.getMethod().name();
			String contentType = requestEntity.getHeaders().getContentType().toString();
			List<Livro> livros = livroService.getAllLivros();
			return ResponseEntity.status(HttpStatus.OK).header("Method", method).header("Content-Type", contentType)
					.body(livros);
		}
		
		@PutMapping("/{id}")
		public Livro updateJogo(@PathVariable Long id, @RequestBody Livro livro) {
		    return livroService.updateLivro(id, livro);
		}
	
	

}
