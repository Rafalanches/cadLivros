package com.senai.rafael.PrjLivro.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.senai.rafael.PrjLivro.entities.Livro;

public interface LivroRepository extends JpaRepository<Livro, Long> {

}