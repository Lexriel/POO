import java.lang.Math;

public class TD1{

    public static void main(String[] args){

	/* Question 1 */
	int x = 2;
	int y = 5;
	System.out.println("Start: (x,y) = (" + x +"," + y +")");
	/* en utilisant une variable temporaire */
	/* inconvénient : utilise une variable supplémentaire */
	int tmp = x;
	x = y;
	y = tmp;
	System.out.println("  Permutation: (x,y) = (" + x +"," + y +")");
	/* en utilisant l'opération XOR (OU EXCLUSIF) */
	/* inconvénient : doit être implémenté dans le langage utilisé */
	x = x ^ y;
	y = x ^ y;
	x = x ^ y;
	System.out.println("  Permutation: (x,y) = (" + x +"," + y +")");
	/* en utilisant des additions-soustractions */
	/* inconvénient : risque de dépassement */
	x = x + y;
	y = x - y;
	x = x - y;
	System.out.println("  Permutation: (x,y) = (" + x +"," + y +")");

	/* Question 2 */
	int res;
	if (x > y)
	    res = x;
	else
	    res = y;
	System.out.println("  max(x,y) = " + res);

	/* Question 3 */
	int z = 7;
	System.out.println("Start: (x,y,z) = (" + x +"," + y + "," + z + ")");
	/* Solution adaptée */
	res = x;
	if (y > res)
	    res = y;
	if (z > res)
	    res = z;
	System.out.println("  max(x,y,z) = " + res);
	/* Solution difficile à lire */
	if (x > y)
	    if (x > z)
		res = x;
	    else
		res = z;
	else
	    if (y > z)
		res = y;
	    else
		res = z;

	/* Question 4 */
	x = 24;
	y = 36;
	System.out.println("Start: (x,y) = (" + x +"," + y +")");
	while (x*y != 0){
	    if (x > y)
		x = x - y;
	    else
		y = y - x;
	}
	if (x == 0)
	    res = y;
	else /* (y == 0) */
	    res = x;
	System.out.println("  pgcd(x,y) = " + res);

	/* Question 5 */
	x = 31;
	int i;
	boolean b = true;
	for (i=2; i<x; i++){
	    if (x % i == 0)
		b = false;
	}
	System.out.println("Is " + x + " a prime number ? " + b);

	/* Question 6 */
	int n = 5;
	int[] tabn;
	tabn = new int[n];
	// tabn = {2,3};
	
	/* Question 7 */
	double[][] mat = new double[3][3];
	// double[][] mat = {{1,2,3}, {0,1,2}, {2,1,4}};
	int j;
	double s = 0;
	/* Remplissage de mat avec des valeurs aléatoires de 0 à 10 */
	System.out.println("Matrice mat:");
	// String mot = "Hello";
	// System.out.println(mat.length);
	// System.out.println(mat[0].length);
	// System.out.println(mot.length());
	
	for (i=0; i<mat.length; i++){
	    for (j=0; j<mat.length; j++){
		tmp = (int) (Math.random() * 10 * 100);
		mat[i][j] = tmp / 100.0;
		System.out.print("  " + mat[i][j]);
	    }
	    System.out.print("\n");
	}
	/* Calcul de la somme des diagonales */
	for (i=0; i<mat.length; i++){
	    s += mat[i][i];
	}
	System.out.println("Sum(mat[i,i]) = " + s);

	/* Question 8 */
	int[] tab = {22,19,14,6,14,7};
	System.out.print("Start: tab = ");
	for (int elt : tab)
	    System.out.print(elt + "  ");
	System.out.print("\n");
	int max = tab[0];
	for (i=1; i<tab.length; i++)
	    if (tab[i] > max)
		max = tab[i];
	System.out.println("  max(tab) = " + max);
	
	/* Question 9 */
	int index = tab.length;
	int valeur = 14;
	i = -1;
	while (++i<n){
	    if (tab[i] == valeur){
		index = i;
		break;
	    }
	}
	System.out.println("  valeur = " + valeur);
	System.out.println("  index = " + index);

	/* Question 10 */
	n = 4;
	int[][] tp = new int[n+1][];
	for (i=0; i<tp.length; i++)
	    tp[i] = new int[i+1];
	/* Affectations de 1 pour la colonne p=0 et la diagonale */
	for (i=0; i<n+1; i++){
	    tp[i][0] = 1;
	    tp[i][i] = 1;
	}
	/* Calcul des C_n^p intérieurs */
	/* Attention : on s'arrête à length-1 comme la case du dessus
	   n'existe pas pour les 1 en diagonale */
	for (i=2; i<tp.length; i++){
	    for (j=1; j<tp[i].length-1; j++){
		tp[i][j] = tp[i-1][j-1] + tp[i-1][j];
	    }
	}
	/* Affichage du triangle de Pascal */
	System.out.println("Pascal's triangle for n = " + n + ":");
	for (i=0; i<tp.length; i++){
	    for (j=0; j<tp[i].length; j++){
		System.out.print("  " + tp[i][j]);
	    }
	    System.out.print("\n");
	}

	/* Question 11 */
	int[] t = {7,4,-1,5,3,1,-1};
	int nb_entiers_tete = 0;
	i = 0;
	while (t[i++] > 0)
	    nb_entiers_tete++;
	System.out.print("Start: tab = ");
	for (i=0; i<t.length; i++)
	    System.out.print(t[i] + "  ");
	System.out.print("\n");
	System.out.println("  integers in head of tab = " + nb_entiers_tete);

	/* Question 12 */
	int l = 0;
	int l_max = 0;
	for (i=0; i<t.length; i++){
	    if (t[i] < 0 && l>l_max){
		l_max = l;
		l = 0;
	    }
	    else
		l++;
	}
	System.out.println("  longuest sequence of integers in tab = " + l_max);

	/* Question 13 - tri bulle */
	System.out.print("  bubble sort of tab = ");
	n = t.length;
	while (n > 1){
	    for (i=0; i<n-1; i++){
		if (t[i] > t[i+1]){
		    tmp = t[i];
		    t[i] = t[i+1];
		    t[i+1] = tmp;
		}
	    }
	    n--;
	}
	for (i=0; i<t.length; i++)
	    System.out.print(t[i] + "  ");
	System.out.print("\n");


    }

    
}

