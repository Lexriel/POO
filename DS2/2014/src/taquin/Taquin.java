package taquin;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author  jc
 */
public class Taquin{
	
    // Q2
	
    private Tuile[][] lesTuiles;
    private int ligneTrou;
    private int colTrou;

    /** créée un taquin de hxl tuiles, les tuiles sont initialement bien ordonnées et le trou est "en bas à droite" (= position (h-1,l-1))
     * @param h la hauteur du taquin
     * @param l la largeur du taquin
     */
    public Taquin(int h, int l){
	this.lesTuiles = new Tuile[h][l];
	for(int i=0; i<h; i++){
	    for(int j=0; j<l; j++)
		this.lesTuiles[i][j] = new Tuile(i*l+j);
	}
	this.ligneTrou = h-1;
	this.colTrou = l-1;
	this.lesTuiles[this.ligneTrou][this.colTrou] = Tuile.TROU;
    }

    // Q4.2
    private static int nbMelange = 100;
    private static Random rand = new Random(); 

    public void melanger(){
	int deplacement = 0;
	int alea;
	DirectionDeplacement dir;
	while (deplacement < Taquin.nbMelange){
	    alea = Taquin.rand.nextInt(4);
	    // on choisit une direction au hasard
	    dir = DirectionDeplacement.values()[alea];
	    try{
		// on tente de réalliser le déplacement
		this.deplacement(dir);
		// le déplacement est réussi : on incrémente
		deplacement++;
	    }
	    catch(DeplacementImpossibleException e){ // le déplacement a échoué
		// nop : deplacement impossible donc on n'incrémente pas 'deplacement' notamment
	    }
	}
    }
	
    // LA SUITE EST HORS SUJET
	
    // HORS SUJET -> supposée définie 
    public void deplacement(DirectionDeplacement dir) throws DeplacementImpossibleException{
	// deplacements impossibles - pourrait être géré par une méthode abstraite de DirectionDeplacement, mais hors programme
	if ((dir == DirectionDeplacement.haut && this.ligneTrou == 0) ||
	    (dir == DirectionDeplacement.bas && this.ligneTrou == (this.lesTuiles.length -1)) ||
	    (dir == DirectionDeplacement.gauche && this.colTrou == 0) ||
	    (dir == DirectionDeplacement.droite && this.colTrou ==(this.lesTuiles[0].length -1))){
	    throw new DeplacementImpossibleException();
	}
	//	des attributs sur les valeurs du type énuméré DirectionDeplacement auraient été judicieux
	// du style "dx" et "dy" et du coup : "this.deplacementTour(dir.dx, dir.dy)" aurait suffi à la place des ligne suivantes, cf type DirectionDeplacement
	if (dir == DirectionDeplacement.haut){
	    this.deplacementTrou(-1, 0);
	}
	if (dir == DirectionDeplacement.bas){
	    this.deplacementTrou(+1, 0);
	}
	if (dir == DirectionDeplacement.gauche){
	    this.deplacementTrou(0, -1);
	}
	if (dir == DirectionDeplacement.droite){
	    this.deplacementTrou(0, +1);
	}
    }

    /** deplacement de deltaLigne/deltaCol (+ ou -1) du trou
     * @param deltaLigne
     * @param deltaCol
     */
    // HORS SUJET : non demandée
    private void deplacementTrou(int deltaLigne, int deltaCol){
	Tuile tmp;
	tmp = this.lesTuiles[this.ligneTrou+deltaLigne][this.colTrou+deltaCol];
	this.lesTuiles[this.ligneTrou+deltaLigne][this.colTrou+deltaCol] = Tuile.TROU;
	this.lesTuiles[this.ligneTrou][this.colTrou] = tmp;
	this.ligneTrou = this.ligneTrou + deltaLigne;
	this.colTrou = this.colTrou + deltaCol;
    }	
}
