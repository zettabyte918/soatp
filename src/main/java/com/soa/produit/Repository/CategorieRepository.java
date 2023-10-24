package com.soa.produit.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.soa.produit.Entities.Categorie;
import com.soa.produit.Entities.Produit;

@RepositoryRestResource(path = "rest")

public interface CategorieRepository extends JpaRepository<Categorie, Long> {
}