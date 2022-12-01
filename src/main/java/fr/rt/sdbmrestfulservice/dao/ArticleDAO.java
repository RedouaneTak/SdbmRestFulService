package fr.rt.sdbmrestfulservice.dao;



import fr.rt.sdbmrestfulservice.metier.*;
import fr.rt.sdbmrestfulservice.service.ArticleSearch;

import java.sql.*;
import java.util.ArrayList;

public class ArticleDAO extends DAO<Article, ArticleSearch> {
    public ArticleDAO(Connection connexion) {super(connexion);}



    @Override
    public ArrayList<Article> getLike(ArticleSearch articleSearch) {
        ResultSet rs;
        ArrayList<Article> liste = new ArrayList<>();
        String procedureStockee = "{call dbo.SP_ARTICLE_QBE (?,?,?,?,?,?,?,?,?,?)}";
        try (CallableStatement cStmt = this.connexion.prepareCall(procedureStockee))
        {

            cStmt.setString(1,articleSearch.getLibelle());
            cStmt.setInt(2 ,articleSearch.getCouleur().getId());
            cStmt.setInt(3,articleSearch.getType().getId());
            cStmt.setInt(4,articleSearch.getPays().getId());
            cStmt.setInt(5,articleSearch.getContinent().getId());
            cStmt.setInt(6,articleSearch.getVolume());
            cStmt.setInt(7,articleSearch.getMarque().getId());
            cStmt.setInt(8,articleSearch.getFabricant().getId());
            cStmt.setFloat(9,articleSearch.getTitrageMin());
            cStmt.setFloat(10,articleSearch.getTitrageMax());


            cStmt.execute();
            rs = cStmt.getResultSet();

            while (rs.next())
            {
                // création d'un nouveal article à partir d'une ligne du resultset
                Article newArticle = new Article(rs.getInt(3),(rs.getString(4)));
                newArticle.setId(rs.getInt(3));
                newArticle.setLibelle(rs.getString(4));
                newArticle.setPrixAchat(rs.getFloat(5));
                newArticle.setVolume(rs.getInt(6));
                newArticle.setTitrage(rs.getFloat(7));
                newArticle.setCouleur(new Couleur(rs.getInt(8),rs.getString(9)));
                newArticle.setTypeBiere(new TypeBiere(rs.getInt(1),rs.getString(2)));

                Marque newMarque = new Marque();

                newMarque.setId(rs.getInt(15));
                newMarque.setLibelle(rs.getString(14));
                newMarque.setPays(new Pays(rs.getInt(10), rs.getString(11), new Continent(rs.getInt(12), rs.getString(13))));

                newMarque.setFabricant(new Fabricant(rs.getInt(16),rs.getString(17)));


                newArticle.setMarque(newMarque);
                newArticle.setStock(rs.getInt(18));
                liste.add(newArticle);



            }
            rs.close();
        }

        // Handle any errors that may have occurred.
        catch (Exception e)
        {
            e.printStackTrace();
        }


        return liste;
    }


    @Override
    public Article getByID(int id) {
        Article article =new Article();
        try (Statement stmt = connexion.createStatement()) {


            // Determine the column set column

            PreparedStatement pStmt = connexion
                    .prepareStatement("SELECT * from article where id_article = ?");
            // Determine the column set column

            pStmt.setInt(1, id);
            ResultSet rs = pStmt.executeQuery();

            while (rs.next()) {

                article.setId(rs.getInt(1));
                article.setLibelle(rs.getString(2));
                article.setPrixAchat(rs.getFloat(3));
                article.setVolume(rs.getInt(4));
                article.setTitrage(rs.getFloat(5));
                article.setMarque(new Marque(rs.getInt(6),""));
                article.setCouleur(new Couleur(rs.getInt(7),""));
                article.setTypeBiere(new TypeBiere(rs.getInt(8),""));
                article.setStock(rs.getInt(9));


            }
            rs.close();


        }
        // Handle any errors that may have occurred.
        catch (Exception e) {
            e.printStackTrace();
        }
        return article;
    }

    @Override
    public ArrayList<Article> getAll() {
        ArrayList<Article> liste = new ArrayList<>();
        try (Statement stmt = connexion.createStatement()) {


            // Determine the column set column

            String strCmd = "SELECT * from ARTICLE";
            ResultSet rs = stmt.executeQuery(strCmd);

            while (rs.next()) {

                Article article = new Article();
                article.setId(rs.getInt(1));
                article.setLibelle(rs.getString(2));
                article.setPrixAchat(rs.getFloat(3));
                article.setVolume(rs.getInt(4));
                article.setTitrage(rs.getFloat(5));
                article.setMarque(new Marque(rs.getInt(6),""));
                article.setCouleur(new Couleur(rs.getInt(7),""));
                article.setTypeBiere(new TypeBiere(rs.getInt(8),""));
                article.setStock(rs.getInt(9));

                liste.add(article);


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
    public boolean insert(Article article) {

        try {

            PreparedStatement pStmt = connexion
                    .prepareStatement("insert into article (NOM_ARTICLE,PRIX_ACHAT,VOLUME,TITRAGE,ID_MARQUE,ID_COULEUR,ID_TYPE,STOCK) " +
                            "VALUES (?,?,?,?,?,?,?,?)");
            // Determine the column set column

            pStmt.setString(1,article.getLibelle());
            pStmt.setFloat(2,article.getPrixAchat());
            pStmt.setInt(3,article.getVolume());
            pStmt.setFloat(4,article.getTitrage());
            pStmt.setInt(5,article.getMarque().getId());
            pStmt.setInt(6,article.getCouleur().getId());
            pStmt.setInt(7,article.getTypeBiere().getId());
            pStmt.setInt(8,article.getStock());




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
    public boolean update(Article article) {
        try {

            PreparedStatement pStmt = connexion
                    .prepareStatement("update article set NOM_ARTICLE = ?,PRIX_ACHAT=?,VOLUME=?,TITRAGE=?,ID_MARQUE=?,ID_COULEUR=?,ID_TYPE=?,STOCK=? where ID_ARTICLE = ?");
            // Determine the column set column

            pStmt.setString(1,article.getLibelle());
            pStmt.setFloat(2,article.getPrixAchat());
            pStmt.setInt(3,article.getVolume());
            pStmt.setFloat(4,article.getTitrage());
            pStmt.setInt(5,article.getMarque().getId());
            pStmt.setInt(6,article.getCouleur().getId());
            pStmt.setInt(7,article.getTypeBiere().getId());
            pStmt.setInt(8,article.getStock());
            pStmt.setInt(9,article.getId());




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
    public boolean delete(Article article) {


        try {

            PreparedStatement pStmt = connexion
                    .prepareStatement("delete from article where ID_ARTICLE = ?");
            // Determine the column set column

            pStmt.setInt(1,article.getId());





            int r = pStmt.executeUpdate();

            if(r==0){
                return false;
            }else{
                return true;
            }

        }

        // Handle any errors that may have occurred.
        catch (Exception e) {

            e.printStackTrace();
            return false;
        }

    }
}
