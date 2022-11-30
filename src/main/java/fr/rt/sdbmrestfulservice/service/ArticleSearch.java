package fr.rt.sdbmrestfulservice.service;

import fr.rt.sdbmrestfulservice.metier.*;

public class ArticleSearch {

    private int id;

    private String libelle;

    private float prix_achatr;

    private int volume;

    private float titrageMin;
    private float titrageMax;

    private int stock;

    private Pays pays;

    private Continent continent;

    private Fabricant fabricant;

    private Marque marque;

    private Couleur couleur;

    private TypeBiere type;

    public ArticleSearch(){

        pays = new Pays();
        continent = new Continent();
        fabricant = new Fabricant();
        marque = new Marque();
        couleur = new Couleur();
        type = new TypeBiere();

    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getLibelle() {
        return libelle;
    }
    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public float getPrix_achatr() {
        return prix_achatr;
    }
    public void setPrix_achatr(float prix_achatr) {
        this.prix_achatr = prix_achatr;
    }

    public int getVolume() {
        return volume;
    }
    public void setVolume(int volume) {
        this.volume = volume;
    }

    public float getTitrageMin() {
        return titrageMin;
    }

    public void setTitrageMin(float titrageMin) {
        this.titrageMin = titrageMin;
    }

    public float getTitrageMax() {
        return titrageMax;
    }

    public void setTitrageMax(float titrageMax) {
        this.titrageMax = titrageMax;
    }

    public int getStock() {
        return stock;
    }
    public void setStock(int stock) {
        this.stock = stock;
    }

    public Pays getPays() {
        return pays;
    }
    public void setPays(Pays pays) {
        this.pays = pays;
    }

    public Continent getContinent() {
        return continent;
    }
    public void setContinent(Continent continent) {
        this.continent = continent;
    }

    public Fabricant getFabricant() {
        return fabricant;
    }
    public void setFabricant(Fabricant fabricant) {
        this.fabricant = fabricant;
    }

    public Marque getMarque() {
        return marque;
    }
    public void setMarque(Marque marque) {
        this.marque = marque;
    }

    public Couleur getCouleur() {
        return couleur;
    }
    public void setCouleur(Couleur couleur) {
        this.couleur = couleur;
    }

    public TypeBiere getType() {
        return type;
    }
    public void setType(TypeBiere type) {
        this.type = type;
    }
}
