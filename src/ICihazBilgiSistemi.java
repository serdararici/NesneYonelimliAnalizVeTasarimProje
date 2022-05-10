import java.sql.SQLException;

public interface ICihazBilgiSistemi {
    public KullaniciHesabi kullaniciDogrula(String kullaniciadi, String sifre) throws SQLException;
}
