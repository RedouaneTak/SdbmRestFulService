package fr.rt.sdbmrestfulservice.metier;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Pays {

    private int id;
    private String libelle;
    @JsonIgnore
    private Continent continent;

    public Pays()
    {

        continent = new Continent();
    }
    public Pays(int id, String libelle)
    {
        this.id = id;
        this.libelle = libelle;
        this.continent = new Continent();
    }

    public Pays(int id, String libelle, Continent continent)
    {
        this.id = id;
        this.libelle = libelle;
        this.continent = continent;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getLibelle()
    {
        return libelle;
    }

    public void setLibelle(String libelle)
    {
        this.libelle = libelle;
    }

    public Continent getContinent()
    {
        return continent;
    }

    public void setContinent(Continent continent)
    {
        this.continent = continent;
    }

    @Override
    public String toString()
    {
        return libelle;
    }
}
