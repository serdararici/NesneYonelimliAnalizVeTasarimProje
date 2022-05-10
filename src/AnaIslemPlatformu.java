import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class AnaIslemPlatformu implements IAnaIslemPlatformu{

    private final IEkran ekran;
    private final ITusTakimi tusTakimi;
    private final IAgArayuzu agArayuzu;
    private final IEyleyici eyleyici;
    private final ISicaklikAlgilayici sicaklikAlgilayici;
    private final ISubject publisher;

    private static final int SICAKLIK_GORUNTULE = 1;
    private static final int SOGUTUCU_AC = 2;
    private static final int SOGUTUCU_KAPAT = 3;
    private static final int CIKIS = 4;

    public AnaIslemPlatformu() {
        ekran=new Ekran();
        tusTakimi=new TusTakimi();
        agArayuzu=new AgArayuzu();
        eyleyici=new Eyleyici();
        sicaklikAlgilayici=new SicaklikAlgilayici();
        publisher=new Publisher();
        

    }

    @Override
    public void basla() throws SQLException {
        Araclar.kapali();
        ekran.mesajGoruntule("**********************************************");
        ekran.mesajGoruntule("Giriş yapmak için kullanıcı adınızı giriniz...");
        Araclar.bekle();
        String kullaniciadi = tusTakimi.stringVeriAl();
        IVeritabaniFactory veritabaniFactory = new VeritabaniFactory();
        ICihazBilgiSistemi cihazBilgiSistemi = veritabaniFactory.factoryMethod("MySql");
        //ICihazBilgiSistemi cihazBilgiSistemi = new CihazBilgiSistemi(new MySqlSurucu());  //Factory method kullanıldığı için kapatıldı.
        MySqlSurucu surucu = new MySqlSurucu();
        Araclar.algilama();
        Araclar.bekle(1000);
        if(surucu.kullaniciVarMi(kullaniciadi)){
            int sayac=3;
            while(sayac>0){
                ekran.mesajGoruntule("Şifrenizi giriniz...");
                String sifre = tusTakimi.stringVeriAl();
                KullaniciHesabi kullaniciHesabi = cihazBilgiSistemi.kullaniciDogrula(kullaniciadi,sifre);
                if (kullaniciHesabi !=null){
                    sayac=0;
                    Araclar.bekle(1000);
                    ekran.mesajGoruntule("Kullanıcı Doğrulama İşlemi Başarılı...");
                    Araclar.bekle(1000);
                    islemSecimi(agArayuzu);
                }
                else{
                    sayac-=1;
                    ekran.mesajGoruntule("Yanlış Şifre Girdiniz...("+sayac+" Hakkınız Kaldı!)");
                    if(sayac==0){
                        ekran.mesajGoruntule("Kullanıcı doğrulanamdı!!!");
                    }
                }
            }

        }else{
            System.out.println("Kullanıcı Bulunamadı...");
        }


    }

    private KullaniciHesabi kullaniciDogrula(String kullaniciadi, String sifre, ICihazBilgiSistemi cihazBilgiSistemi) throws SQLException {
        return cihazBilgiSistemi.kullaniciDogrula(kullaniciadi, sifre);
    }

    private void islemSecimi(IAgArayuzu agArayuzu){
        int secim;
        do{
            secim=anaMenuyuGoster();
            ekran.ekranTemizle();
            switch (secim) {
                case SICAKLIK_GORUNTULE:
                    Subscriber s1 = new Subscriber("Abone1");
                    Subscriber s2 = new Subscriber("Abone2");
                    Subscriber s3 = new Subscriber("Abone3");
                    Publisher p = new Publisher();
                    p.attach(s1);
                    p.attach(s2);
                    p.attach(s3);
                    ekran.sicaklikGoruntule(sicaklikAlgilayici,agArayuzu,p);
                    Araclar.bekle(1000);
                    break;
                case SOGUTUCU_AC:
                    Araclar.acilisTesti();
                    Araclar.bekle(1000);
                    //AgArayuzu agArayuzu = new AgArayuzu();
                    int sicaklik = agArayuzu.sicaklikGonder(sicaklikAlgilayici);
                    agArayuzu.sogutucuAc(eyleyici, sicaklikAlgilayici,sicaklik,tusTakimi,ekran);
                    Araclar.bekle(1000);
                    break;

                case SOGUTUCU_KAPAT:
                    Araclar.islemYapiliyor();
                    Araclar.bekle(1000);
                    //AgArayuzu agArayuzu1 = new AgArayuzu();
                    agArayuzu.sogutucuKapat();
                    Araclar.bekle(2000);
                    break;

                case CIKIS:
                    ekran.mesajGoruntule("Sistemden çıkılıyor...");
                    Araclar.bekle(1000);
                    Araclar.kapali();
                    break;
                default:
                    ekran.mesajGoruntule("1-4 arasında bir sayı girmelisiniz");
            }
        }while(secim!=4);
    }

    private int anaMenuyuGoster()
    {
        ekran.mesajGoruntule("**********************************************");
        ekran.mesajGoruntule("Ana Menu");
        ekran.mesajGoruntule("1-Sıcaklık Görüntüle");
        ekran.mesajGoruntule("2-Soğutucu Aç");
        ekran.mesajGoruntule("3-Soğutucu Kapat");
        ekran.mesajGoruntule("4-Cikis");
        ekran.mesajGoruntule("Seciminiz:");
        ekran.mesajGoruntule("**********************************************");
        return tusTakimi.veriAl();
    }

}
