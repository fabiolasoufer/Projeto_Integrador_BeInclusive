package org.beinclusive.beinclusive.repository;

import java.util.List;

import org.beinclusive.beinclusive.model.PostagemModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostagemRepository extends JpaRepository<PostagemModel, Long> {

    public List<PostagemModel> findAllbyTituloContainingIgnoreCase(String titulo);
}
