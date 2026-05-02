package tn.esprit.rh.achat.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import tn.esprit.rh.achat.entities.Produit;
import tn.esprit.rh.achat.repositories.CategorieProduitRepository;
import tn.esprit.rh.achat.repositories.ProduitRepository;
import tn.esprit.rh.achat.repositories.StockRepository;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ProduitServiceImplTest {

    @Mock
    ProduitRepository produitRepository;

    @Mock
    StockRepository stockRepository;

    @Mock
    CategorieProduitRepository categorieProduitRepository;

    @InjectMocks
    ProduitServiceImpl produitService;

    private Produit produit;

    @BeforeEach
    void setUp() {
        produit = new Produit();
        produit.setIdProduit(1L);
        produit.setLibelleProduit("Produit Test");
    }

    @Test
    void testRetrieveAllProduits() {
        when(produitRepository.findAll()).thenReturn(Arrays.asList(produit));
        List<Produit> result = produitService.retrieveAllProduits();
        assertNotNull(result);
        assertEquals(1, result.size());
        verify(produitRepository, times(1)).findAll();
    }

    @Test
    void testAddProduit() {
        when(produitRepository.save(produit)).thenReturn(produit);
        Produit result = produitService.addProduit(produit);
        assertNotNull(result);
        assertEquals("Produit Test", result.getLibelleProduit());
        verify(produitRepository, times(1)).save(produit);
    }

    @Test
    void testUpdateProduit() {
        when(produitRepository.save(produit)).thenReturn(produit);
        Produit result = produitService.updateProduit(produit);
        assertNotNull(result);
        verify(produitRepository, times(1)).save(produit);
    }

    @Test
    void testRetrieveProduit() {
        when(produitRepository.findById(1L)).thenReturn(Optional.of(produit));
        Produit result = produitService.retrieveProduit(1L);
        assertNotNull(result);
        assertEquals(1L, result.getIdProduit());
        verify(produitRepository, times(1)).findById(1L);
    }

    @Test
    void testDeleteProduit() {
        doNothing().when(produitRepository).deleteById(1L);
        produitService.deleteProduit(1L);
        verify(produitRepository, times(1)).deleteById(1L);
    }
}
