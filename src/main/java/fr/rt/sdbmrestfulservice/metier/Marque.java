package fr.rt.sdbmrestfulservice.metier;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Objects;

public class Marque {


    private int id;
    private String libelle;
    @JsonIgnore
    private Pays pays;
    @JsonIgnore
    private Fabricant fabricant;

    public Marque(int id,String libelle){
        this.id = id;
        this.libelle = libelle;
    }

    public Marque(){

    }

    public Integer getId()
    {
        return id;
    }

    public void setId(Integer id)
    {
        this.id=id;
    }

    public String getLibelle()
    {
        return libelle;
    }

    public void setLibelle(String libelle)
    {
        this.libelle=libelle;
    }

    public Pays getPays()
    {
        return pays;
    }

    public void setPays(Pays pays)
    {
        this.pays = pays;
    }

    public Fabricant getFabricant()
    {
        return fabricant;
    }

    public void setFabricant(Fabricant fabricant)
    {
        this.fabricant = fabricant;
    }

    @Override
    public String toString()
    {
        return libelle;
    }

    public int idProperty() {
        return id;
    }

    public String libelleProperty() {
        return libelle;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Marque marque = (Marque) o;
        return id == marque.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
