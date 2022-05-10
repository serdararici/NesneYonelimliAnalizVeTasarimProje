import java.sql.SQLException;

public class CihazBilgiSistemi implements ICihazBilgiSistemi{

    private IVeritabaniRepository veritabani;

    public CihazBilgiSistemi(IVeritabaniRepository veritabani){
        this.veritabani = veritabani;
    }
    @Override
    public KullaniciHesabi kullaniciDogrula(String kullaniciadi, String sifre) throws SQLException {
        return veritabani.kullaniciDogrula(kullaniciadi,sifre);
    }
}
