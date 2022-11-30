package fr.rt.sdbmrestfulservice.dao;



import fr.rt.sdbmrestfulservice.metier.Couleur;
import fr.rt.sdbmrestfulservice.metier.Pays;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class CouleurDAO extends DAO <Couleur,Couleur>{
    public CouleurDAO(Connection connexion) {
        super(connexion);
    }

    @Override
    public Couleur getByID(int id) {
        Couleur couleur = new Couleur();
        try {

            PreparedStatement pStmt = connexion
                    .prepareStatement("SELECT id_couleur,nom_couleur from couleur where id_couleur = ?");
            // Determine the column set column

            pStmt.setInt(1, id);
            ResultSet rs = pStmt.executeQuery();
            while (rs.next()) {
                couleur.setId(rs.getInt(1));
                couleur.setLibelle(rs.getString(2));

            }
            rs.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return couleur;
    }

    public ArrayList<Couleur> getAll() {
        ArrayList<Couleur> liste = new ArrayList<>();
        try (Statement stmt = connexion.createStatement()) {


            // Determine the column set column

            String strCmd = "SELECT id_couleur,nom_couleur from couleur order by NOM_COULEUR";
            ResultSet rs = stmt.executeQuery(strCmd);

            while (rs.next()) {

                liste.add(new Couleur(rs.getInt(1),rs.getString(2)));


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
    public ArrayList<Couleur> getLike(Couleur objet) {
        return null;
    }

    @Override
    public boolean insert(Couleur couleur) {
        try {

            PreparedStatement pStmt = connexion
                    .prepareStatement("insert into COULEUR(NOM_COULEUR) VALUES (?);");
            // Determine the column set column

            pStmt.setString(1,couleur.getLibelle());


            //pStmt.executeQuery();
             pStmt.executeUpdate();

            System.out.println("couleur insert");

            return true;
        }

        // Handle any errors that may have occurred.
        catch (Exception e) {

            System.out.println("couleur error");
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean update(Couleur couleur) {
        try {

            PreparedStatement pStmt = connexion
                    .prepareStatement("update couleur set NOM_COULEUR = ? where ID_COULEUR = ?");
            // Determine the column set column

            pStmt.setString(1,couleur.getLibelle());
            pStmt.setInt(2,couleur.getId());

            //pStmt.executeQuery();
             pStmt.executeUpdate();


            return true;
        }

        // Handle any errors that may have occurred.
        catch (Exception e) {

            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean delete(Couleur couleur) {
        try {

            PreparedStatement pStmt = connexion
                    .prepareStatement("delete from couleur where id_couleur = ?");
            // Determine the column set column

            pStmt.setInt(1,couleur.getId());


            //pStmt.executeQuery();
            pStmt.executeUpdate();


            return true;
        }

        // Handle any errors that may have occurred.
        catch (Exception e) {

            e.printStackTrace();
            return false;
        }
    }
}
