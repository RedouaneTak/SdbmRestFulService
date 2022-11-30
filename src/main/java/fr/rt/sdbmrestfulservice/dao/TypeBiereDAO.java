package fr.rt.sdbmrestfulservice.dao;



import fr.rt.sdbmrestfulservice.metier.Couleur;
import fr.rt.sdbmrestfulservice.metier.TypeBiere;

import java.lang.reflect.Type;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class TypeBiereDAO extends DAO<TypeBiere,TypeBiere> {
    public TypeBiereDAO(Connection connexion){super(connexion);}


    @Override
    public TypeBiere getByID(int id) {
        TypeBiere typeBiere = new TypeBiere();
        try {

            PreparedStatement pStmt = connexion
                    .prepareStatement("SELECT id_type,nom_type from typebiere where id_type = ?");
            // Determine the column set column

            pStmt.setInt(1, id);
            ResultSet rs = pStmt.executeQuery();
            while (rs.next()) {
                typeBiere.setId(rs.getInt(1));
                typeBiere.setLibelle(rs.getString(2));

            }
            rs.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return typeBiere;
    }

    @Override
    public ArrayList<TypeBiere> getAll() {
        ArrayList<TypeBiere> liste = new ArrayList<>();
        try (Statement stmt = connexion.createStatement()) {


            // Determine the column set column

            String strCmd = "SELECT ID_TYPE, NOM_TYPE from TYPEBIERE order by NOM_TYPE";
            ResultSet rs = stmt.executeQuery(strCmd);

            while (rs.next()) {

                TypeBiere typeBiere = new TypeBiere();
                typeBiere.setId(rs.getInt(1));
                typeBiere.setLibelle(rs.getString(2));
                liste.add(typeBiere);
               // liste.add(new TypeBiere(rs.getInt(1),rs.getString(2)));


            }
            rs.close();

        }
        // Handle any errors that may have occurred.
        catch (Exception e) {
            e.printStackTrace();
        }
        return liste;
    }

    @Override
    public ArrayList<TypeBiere> getLike(TypeBiere objet) {
        return null;
    }

    @Override
    public boolean insert(TypeBiere objet) {
        return false;
    }

    @Override
    public boolean update(TypeBiere object) {
        return false;
    }

    @Override
    public boolean delete(TypeBiere object) {
        return false;
    }
}
