import java.sql.SQLException;

public interface IVeritabaniRepository {
    public KullaniciHesabi kullaniciDogrula(String kullaniciadi, String sifre) throws SQLException;
    public boolean kullaniciVarMi(String kulaniciadi) throws SQLException;
}
