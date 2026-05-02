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
        produit.setCodeProduit("P001");
        produit.setPrix(100f);
    }

    @Test
    void testProduitLibelle() {
        assertEquals("Produit Test", produit.getLibelleProduit());
    }

    @Test
    void testProduitCode() {
        assertEquals("P001", produit.getCodeProduit());
    }

    @Test
    void testProduitPrix() {
        assertEquals(100f, produit.getPrix());
    }

    @Test
    void testProduitNotNull() {
        assertNotNull(produit);
    }
}
