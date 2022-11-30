package fr.rt.sdbmrestfulservice.dao;



import fr.rt.sdbmrestfulservice.metier.Fabricant;
import fr.rt.sdbmrestfulservice.metier.Marque;
import fr.rt.sdbmrestfulservice.metier.Pays;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class MarqueDAO extends DAO<Marque, Marque>{

    public MarqueDAO(Connection connexion)
    {
        super(connexion);
    }



    @Override
    public ArrayList<Marque> getAll()
    {
        // TODO Auto-generated method stub

        ArrayList<Marque> liste = new ArrayList<>();
        try (Statement stmt = connexion.createStatement()) {


            // Determine the column set column

            String strCmd = "SELECT id_marque,nom_marque from marque order by NOM_MARQUE";
            ResultSet rs = stmt.executeQuery(strCmd);

            while (rs.next()) {

                Marque marque = new Marque();
                marque.setId(rs.getInt(1));
                marque.setLibelle(rs.getString(2));
                liste.add(marque);

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
    public ArrayList<Marque> getLike(Marque objet) {
        return null;
    }

    @Override
    public Marque getByID(int id)
    {
        Marque marque = new Marque();
        try {

            PreparedStatement pStmt = connexion
                    .prepareStatement("SELECT id_marque,nom_marque from marque where id_marque = ?");
            // Determine the column set column

            pStmt.setInt(1, id);
            ResultSet rs = pStmt.executeQuery();
            while (rs.next()) {
                marque.setId(rs.getInt(1));
                marque.setLibelle(rs.getString(2));

            }
            rs.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return marque;
    }

    @Override
    public boolean insert(Marque objet)
    {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean update(Marque object)
    {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean delete(Marque object)
    {
        // TODO Auto-generated method stub
        return false;
    }

    public Pays getPaysByIdMarque(int id) {

        Pays pays = new Pays();
        try {

            PreparedStatement pStmt = connexion
                    .prepareStatement("SELECT p.id_pays,P.NOM_PAYS from PAYS as P\n" +
                            "join MARQUE as M on M.ID_PAYS = P.ID_PAYS\n" +
                            "where ID_MARQUE = ?");
            // Determine the column set column

            pStmt.setInt(1, id);
            ResultSet rs = pStmt.executeQuery();
            while (rs.next()) {
                pays.setId(rs.getInt(1));
                pays.setLibelle(rs.getString(2));

            }
            rs.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return pays;
    }

    public Fabricant getFabricantByMarque(Integer id) {
        Fabricant fabricant = new Fabricant();
        try {

            PreparedStatement pStmt = connexion
                    .prepareStatement("SELECT f.ID_FABRICANT,f.NOM_FABRICANT from FABRICANT as F join MARQUE as M on M.ID_FABRICANT = F.ID_FABRICANT where ID_MARQUE = ?");
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
}
