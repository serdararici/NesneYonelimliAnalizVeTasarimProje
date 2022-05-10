import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MySqlSurucu implements IVeritabaniRepository{

    @Override
    public KullaniciHesabi kullaniciDogrula(String kullaniciadiAl, String sifreAl) throws SQLException {
        KullaniciHesabi kullaniciHesabi = null;

        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet;
        ResultSet resultSet1;
        DbHelper helper = new DbHelper();
        try{
            connection = helper.getConnection();
            statement = connection.createStatement();
            //resultSet = statement.executeQuery("select kullaniciadi and sifre from kullanicilar where kullaniciadi ='"+kullaniciadiAl+"' and sifre ='"+sifreAl+"'");
            //resultSet = statement.executeQuery("select kullaniciadi and sifre from kullanicilar where kullaniciadi ='serdararici' and sifre ='12345'");
            resultSet = statement.executeQuery("select * from kullanicilar where kullaniciadi ='"+kullaniciadiAl+"' and sifre='"+sifreAl+"'");
            //resultSet1 = statement.executeQuery("SELECT sifre FROM kullanicilar");

            String kullaniciadi;
            String sifre;

            while(resultSet.next()){
                //String kullaniciadi = resultSet.getString("kullaniciadi");

                kullaniciadi = resultSet.getString("kullaniciadi");
                sifre = resultSet.getString("sifre");

                kullaniciHesabi = new KullaniciHesabi(kullaniciadi, sifre);
                //System.out.println(kullaniciHesabi);

                //System.out.println(resultSet.getString("kullaniciadi"));
            }
            System.out.println("Veritabanına Bağlanılıyor...");
            Araclar.bekle();

        }catch(SQLException exception){
            helper.showErrorMessage(exception);
        }
        finally {
            connection.close();
        }

        return kullaniciHesabi;
    }

    @Override
    public boolean kullaniciVarMi(String kulaniciadiAl) throws SQLException {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet;
        DbHelper helper = new DbHelper();
        boolean sonuc = true;

        try{
            connection = helper.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery("select count(id) as giris from kullanicilar where kullaniciadi='"+kulaniciadiAl+"'");

            //resultSet1 = statement.executeQuery("SELECT sifre FROM kullanicilar");

            String kullaniciadi;
            String sifre;


            while(resultSet.next()){
                //String kullaniciadi = resultSet.getString("kullaniciadi");

                //kullaniciadi = resultSet1.getString("kullaniciadi");

                int giris = resultSet.getInt("giris");
                //sifre = resultSet1.getString("sifre");

                //kullaniciHesabi = new KullaniciHesabi(kullaniciadi, sifre);
                //System.out.println(kullaniciHesabi);

                //System.out.println(resultSet.getString("kullaniciadi"));
                //System.out.println(kullaniciadi);
                //System.out.println(kulaniciadiAl);
                if(giris==1){
                    sonuc= true;
                }
                else{
                    sonuc= false;
                }
            }

        }catch(SQLException exception){
            helper.showErrorMessage(exception);
        }
        finally {
            connection.close();
        }
        return sonuc;
    }
}
