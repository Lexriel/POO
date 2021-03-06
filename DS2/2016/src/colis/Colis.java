package colis;

import java.util.ArrayList;
import java.util.List;

import article.AbstractArticle;

public class Colis{

    protected Adresse adresse;
    protected List<AbstractArticle> lesArticles;
    private boolean estExpedie;

    public Colis(Adresse adresse){
	this.adresse = adresse;
	this.lesArticles = new ArrayList<AbstractArticle>();
	this.estExpedie = false;
    }

    /**
     * fournit le montant des frais d'exp�dition de ce colis, � partir du total
     * des frais d'exp�dition de chacun des aritcles du colis 
     * @return le montant des frais d'exp�dition de ce colis
     */
    public float getFraisExpedition(){
	float somme = 0;
	for (AbstractArticle article : this.lesArticles){
	    somme = somme + article.fraisExpedition();
	}
	return somme;
    }

    public boolean estExpedie(){
	return this.estExpedie;
    }

    public void expedier(){
	this.estExpedie = true;
    }

    public List<AbstractArticle> allArticles(){
	return this.lesArticles;
    }

    /** ajoute un article � ce colis tant qu'il n'a pas �t� exp�di�, sinon une
     * exception est d�clench�e
     * @param article l'article ajout�
     * @throws ColisExpedieException si le colis a d�j� �t� exp�di�
     */
    public void ajouterArticle(AbstractArticle article) throws ColisExpedieException{
	if (this.estExpedie){
	    throw new ColisExpedieException();
	}
	this.lesArticles.add(article);
    }

    public String bordereauDEnvoi(){
	String result = "";
	for (AbstractArticle article : this.lesArticles){
	    result = result + article.toString();
	}
	return result;
    }

    public float getPrixTTC(){
	float prixTotal = 0;
	for (AbstractArticle article : this.lesArticles){
	    prixTotal = prixTotal + article.getPrixTTC();
	}
	return prixTotal;
    }

    // sans doute prevoir methode removeArticle(...) mais hors-sujet
}
