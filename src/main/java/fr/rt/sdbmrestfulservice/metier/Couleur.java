package fr.rt.sdbmrestfulservice.metier;

import java.util.Objects;

public class Couleur {
    private int id;
    private String libelle;

    public Couleur()
    {

    }

    public Couleur(Integer id, String libelle)
    {
        this.id = id;
        this.libelle = libelle;
    }

    public Integer getId()
    {
        return id;
    }

    public String getLibelle()
    {
        return libelle;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Couleur couleur = (Couleur) o;
        return id == couleur.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString()
    {
        return libelle;
    }
}
