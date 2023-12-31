package com.soa.produit;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.soa.produit.Entities.Categorie;
import com.soa.produit.Entities.Produit;
import com.soa.produit.Repository.CategorieRepository;
import com.soa.produit.Repository.ProduitRepository;

@SpringBootTest
class ProduitApplicationTests {

	@Autowired
	private ProduitRepository produitRepository;

	@Autowired
	private CategorieRepository categeRepository;

	@Test
	public void testCreateProduit() {
		Produit prod = new Produit("mac", 1500.500, new Date());
		Categorie cat = new Categorie("new cat", "des cat");
		categeRepository.save(cat);
		prod.setCategorie(cat);
		produitRepository.save(prod);
	}

	@Test
	public void testFindProduit() {
		// Produit p = produitRepository.findById(2L).get();
		List<Produit> p = produitRepository.findAll();
		System.out.println("*****************************");
		System.out.println(p.toString());
	}

	@Test
	public void testUpdateProduit() {
		Produit p = produitRepository.findById(1L).get();
		p.setPrixProduit(2000.0);
		produitRepository.save(p);
		System.out.println(p);
	}

	@Test
	public void testDeleteProduit() {
		produitRepository.deleteById(1L);
	}

	@Test
	public void testFindAllProduits() {
		List<Produit> prods = produitRepository.findAll();

		for (Produit p : prods)
			System.out.println(p.toString());

	}

	@Test
	public void testFindProduitByNom() {
		List<Produit> prods = produitRepository.findByNomProduit("PS 4");
		for (Produit p : prods)
			System.out.println(p);
	}

	@Test
	public void testFindProduitByNomContains() {
		List<Produit> prods = produitRepository.findByNomProduitContains("P");

		for (Produit p : prods)
			System.out.println(p);

	}

	@Test
	public void testfindByNomPrix() {
		List<Produit> prods = produitRepository.findByNomPrix("PS 4", 1000.0);
		for (Produit p : prods) {
			System.out.println(p);
		}
	}

	@Test
	public void testfindByCategorie() {
		Categorie cat = new Categorie();
		cat.setIdCat(1L);
		List<Produit> prods = produitRepository.findByCategorie(cat);
		for (Produit p : prods) {
			System.out.println(p);
		}
	}

	@Test
	public void findByCategorieIdCat() {
		List<Produit> prods = produitRepository.findByCategorieIdCat(1L);
		for (Produit p : prods) {
			System.out.println(p);
		}
	}

	@Test
	public void testfindByOrderByNomProduitAsc() {
		List<Produit> prods = produitRepository.findByOrderByNomProduitAsc();
		for (Produit p : prods) {
			System.out.println(p);
		}
	}

	@Test
	public void testTrierProduitsNomsPrix() {
		List<Produit> prods = produitRepository.trierProduitsNomsPrix();

		for (Produit p : prods) {
			System.out.println(p);
		}

	}

}
