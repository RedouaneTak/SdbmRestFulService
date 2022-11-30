package fr.rt.sdbmrestfulservice.dao;



import fr.rt.sdbmrestfulservice.metier.Fabricant;
import fr.rt.sdbmrestfulservice.metier.TypeBiere;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class FabricantDAO extends DAO <Fabricant,Fabricant>{

    public FabricantDAO(Connection connexion) {
        super(connexion);
    }

    public ArrayList<Fabricant> getAll() {
        ArrayList<Fabricant> liste = new ArrayList<>();
        try (Statement stmt = connexion.createStatement()) {


            // Determine the column set column

            String strCmd = "SELECT id_fabricant,nom_fabricant from fabricant order by nom_fabricant";
            ResultSet rs = stmt.executeQuery(strCmd);

            while (rs.next()) {
                Fabricant fabricant = new Fabricant();
                fabricant.setId(rs.getInt(1));
                fabricant.setLibelle( rs.getString(2));
                liste.add(fabricant);
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
    public Fabricant getByID(int id) {
        Fabricant fabricant = new Fabricant();
        try {

            PreparedStatement pStmt = connexion
                    .prepareStatement("SELECT id_fabricant,nom_fabricant from fabricant where id_fabricant = ?");
            // Determine the column set column

            pStmt.setInt(1, id);
            ResultSet rs = pStmt.executeQuery();
            while (rs.next()) {
                fabricant.setId(rs.getInt(1));
                fabricant.setLibelle(rs.getString(2));

            }
            rs.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return fabricant;
    }

    @Override
    public boolean insert(Fabricant objet) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean update(Fabricant object) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean delete(Fabricant object) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public ArrayList<Fabricant> getLike(Fabricant objet) {
        // TODO Auto-generated method stub
        return new ArrayList<>();
    }
}
