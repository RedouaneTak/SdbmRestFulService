package fr.rt.sdbmrestfulservice.metier;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Objects;

public class Article {


    private Integer id;

    private String libelle;

    private Integer volume;


    private Float titrage;


    private Float prixAchat;


    private Marque marque;

    private Couleur couleur;

    private TypeBiere typeBiere;

    private Integer stock;



    public Article()
    {
        couleur = new Couleur();
        typeBiere = new TypeBiere();
        marque = new Marque();
    }

    public Article(Integer id, String libelle)
    {
        this.id = id;
        this.libelle = libelle;
        couleur = new Couleur();
        typeBiere = new TypeBiere();
        marque = new Marque();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public Integer getVolume() {
        return volume;
    }

    public void setVolume(Integer volume) {
        this.volume = volume;
    }

    public Float getTitrage() {
        return titrage;
    }

    public void setTitrage(Float titrage) {
        this.titrage = titrage;
    }

    public Float getPrixAchat() {
        return prixAchat;
    }

    public void setPrixAchat(Float prixAchat) {
        this.prixAchat = prixAchat;
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

    public TypeBiere getTypeBiere() {
        return typeBiere;
    }

    public void setTypeBiere(TypeBiere typeBiere) {
        this.typeBiere = typeBiere;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Article article = (Article) o;
        return Objects.equals(id, article.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
