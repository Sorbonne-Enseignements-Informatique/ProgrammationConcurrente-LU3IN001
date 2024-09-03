package pc.test;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.junit.jupiter.api.Test;

import pc.MatriceEntiere;
import pc.TaillesNonConcordantesException;

public class TestMatriceEntiere {

	@Test
	public void testOriginal() {

		// -------------------- Test initialisation et affichage

		try {
			MatriceEntiere m1 = MatriceEntiere.parseMatrix(new File("data/donnees_somme1"));
			{
				MatriceEntiere mat = m1;
				assertEquals(10, mat.nbLignes());
				assertEquals(10, mat.nbColonnes());
				int[] tab = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2,
						3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 6, 6,
						6, 6, 6, 6, 6, 6, 6, 6, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 9, 9, 9, 9,
						9, 9, 9, 9, 9, 9 };
				checkValues(tab, mat);
				
				// test sortie de la matrice
				testSerialisation(mat);
			}

			MatriceEntiere m2 = MatriceEntiere.parseMatrix(new File("data/donnees_produit1"));
			{
				MatriceEntiere mat = m2;
				assertEquals(5, mat.nbLignes());
				assertEquals(4, mat.nbColonnes());
				int[] tab = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20 };
				checkValues(tab, mat);
				
				testSerialisation(mat);
			}

			MatriceEntiere m3 = MatriceEntiere.parseMatrix(new File("data/donnees_somme2"));
			{
				MatriceEntiere mat = m3;
				assertEquals(10, mat.nbLignes());
				assertEquals(10, mat.nbColonnes());
				int[] tab = { 0, -1, 2, -3, 4, -5, 6, -7, 8, 9, 0, 1, -2, 3, -4, 5, -6, 7, -8, 9, 0, -1, 2, -3, 4, -5,
						6, -7, 8, 9, 0, 1, -2, 3, -4, 5, -6, 7, -8, 9, 0, -1, 2, -3, 4, -5, 6, -7, 8, 9, 0, 1, -2, 3,
						-4, 5, -6, 7, -8, 9, 0, -1, 2, -3, 4, -5, 6, -7, 8, 9, 0, 1, -2, 3, -4, 5, -6, 7, -8, 9, 0, -1,
						2, -3, 4, -5, 6, -7, 8, 9, 0, 1, -2, 3, -4, 5, -6, 7, -8, 9 };
				checkValues(tab, mat);
			}
			MatriceEntiere m4 = MatriceEntiere.parseMatrix(new File("data/donnees_produit2"));
			{
				MatriceEntiere mat = m4;
				assertEquals(4, mat.nbLignes());
				assertEquals(8, mat.nbColonnes());
				int[] tab = { -1, 2, -3, 4, -5, 6, -7, 8, -9, 10, -11, 12, -13, 14, -15, 16, 4, 6, 2, -4, 8, 9, 7, 0,
						-41, 6, -87, -53, 4, 3, -5, 8 };
				checkValues(tab, mat);
			}

			// utilise toString
			System.out.println("------------------ matrice 1 ------------------\n" + m1);
			System.out.println("------------------ matrice 2 ------------------\n" + m2);

			// -------------------- Test somme
			System.out.println("------------------ Test somme 1 ------------------");
			System.out.println(m1.toString() + "+\n" + m3.toString() + "=\n");
			try {
				MatriceEntiere mat = m1.ajoute(m3);
				assertEquals(10, mat.nbLignes());
				assertEquals(10, mat.nbColonnes());
				int[] tab = { 0, -1, 2, -3, 4, -5, 6, -7, 8, 9, 1, 2, -1, 4, -3, 6, -5, 8, -7, 10, 2, 1, 4, -1, 6, -3,
						8, -5, 10, 11, 3, 4, 1, 6, -1, 8, -3, 10, -5, 12, 4, 3, 6, 1, 8, -1, 10, -3, 12, 13, 5, 6, 3, 8,
						1, 10, -1, 12, -3, 14, 6, 5, 8, 3, 10, 1, 12, -1, 14, 15, 7, 8, 5, 10, 3, 12, 1, 14, -1, 16, 8,
						7, 10, 5, 12, 3, 14, 1, 16, 17, 9, 10, 7, 12, 5, 14, 3, 16, 1, 18 };
				checkValues(tab, mat);
			} catch (TaillesNonConcordantesException e) {
				System.out.println(e.getMessage());
			}
			System.out.println("------------------ Test somme 2 ------------------");
			System.out.println(m1.toString() + "+\n" + m2.toString() + "=\n");
			try {
				System.out.println(m1.ajoute(m2));
				fail("Exception attendue");
			} catch (TaillesNonConcordantesException e) {
				// on attend bien une exception
				System.out.println(e.getMessage());
			}

			// -------------------- Test produit
			System.out.println("------------------ Test produit 1 ------------------");
			System.out.println(m2.toString() + "*\n" + m4.toString() + "=\n");
			try {
				MatriceEntiere mat = m2.produit(m4);
				assertEquals(5, mat.nbLignes());
				assertEquals(8, mat.nbColonnes());
				int[] tab = { -171, 64, -367, -196, 9, 73, -36, 72, -359, 160, -763, -360, -15, 201, -116, 200, -547,
						256, -1159, -524, -39, 329, -196, 328, -735, 352, -1555, -688, -63, 457, -276, 456, -923, 448,
						-1951, -852, -87, 585, -356, 584 };
				checkValues(tab, mat);
				System.out.println(mat);
			} catch (TaillesNonConcordantesException e) {
				System.out.println(e.getMessage());
				fail("Exception non attendue");
			}
			System.out.println("------------------ Test produit 2 ------------------");
			System.out.println(m2.toString() + "*\n" + m3.toString() + "=\n");
			try {
				System.out.println(m2.produit(m3));
				fail("Exception attendue");
			} catch (TaillesNonConcordantesException e) {
				// on attend bien une exception
				System.out.println(e.getMessage());
			}

			// -------------------- Test produit scalaire
			{
				System.out.println("------------------ Test scalaire ------------------");
				MatriceEntiere mat = m2.produitParScalaire(3);
				assertEquals(5, mat.nbLignes());
				assertEquals(4, mat.nbColonnes());
				int[] tab = { 3, 6, 9, 12, 15, 18, 21, 24, 27, 30, 33, 36, 39, 42, 45, 48, 51, 54, 57, 60 };
				checkValues(tab, mat);
				System.out.println(mat.toTest());
			}
			// -------------------- Test transposee
			{
				System.out.println("------------------ Test transposee ------------------");
				MatriceEntiere mat = m2.transposee();
				assertEquals(4, mat.nbLignes());
				assertEquals(5, mat.nbColonnes());
				int[] tab = { 1, 5, 9, 13, 17, 2, 6, 10, 14, 18, 3, 7, 11, 15, 19, 4, 8, 12, 16, 20 };
				checkValues(tab, mat);
				System.out.println(mat);
			}
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

	public void testSerialisation(MatriceEntiere mat) throws FileNotFoundException, IOException {
		FileOutputStream fos = new FileOutputStream(new File("data/test1"));
		fos.write(mat.toString().getBytes());
		fos.close();
		MatriceEntiere mat2 = MatriceEntiere.parseMatrix(new File("data/test1"));
		assertTrue(mat.equals(mat2));
	}

	private void checkValues(int[] tab, MatriceEntiere mat) {
		for (int i = 0; i < mat.nbLignes() * mat.nbColonnes(); i++) {
			assertEquals(tab[i], mat.getElem(i / mat.nbColonnes(), i % mat.nbColonnes()));
		}
	}

}
