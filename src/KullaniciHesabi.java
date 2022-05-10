public class KullaniciHesabi {
    private String kullaniciadi;
    private String sifre;

    public KullaniciHesabi(String kullaniciadi, String sifre){
        this.kullaniciadi = kullaniciadi;
        this.sifre = sifre;
    }

    public String getKullaniciadi() {
        return kullaniciadi;
    }

    public void setKullaniciadi(String kullaniciadi) {
        this.kullaniciadi = kullaniciadi;
    }

    public String getSifre() {
        return sifre;
    }

    public void setSifre(String sifre) {
        this.sifre = sifre;
    }

    public String toStirng(){
        return "Kullanıcı adı: " + getKullaniciadi() + "\nŞifre: " + getSifre();
    }
}
