package tn.esprit.rh.achat.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tn.esprit.rh.achat.entities.Produit;

import static org.junit.jupiter.api.Assertions.*;

public class ProduitServiceImplTest {

    private Produit produit;

    @BeforeEach
    void setUp() {
        produit = new Produit();
        produit.setLibelleProduit("Produit Test");
        produit.setPrixUnitaire(100f);
        produit.setQteStock(10);
    }

    @Test
    void testProduitLibelle() {
        assertEquals("Produit Test", produit.getLibelleProduit());
    }

    @Test
    void testProduitPrix() {
        assertEquals(100f, produit.getPrixUnitaire());
    }

    @Test
    void testProduitQteStock() {
        assertEquals(10, produit.getQteStock());
    }

    @Test
    void testProduitNotNull() {
        assertNotNull(produit);
    }
}
