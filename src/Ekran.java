public class Ekran implements IEkran{
    ISubject publisher;
    @Override
    public void sicaklikGoruntule(ISicaklikAlgilayici sicaklikAlgilayici, IAgArayuzu agArayuzu, ISubject publisher) {
        //AgArayuzu agArayuzu = new AgArayuzu();
        int sicaklik = agArayuzu.sicaklikGonder(sicaklikAlgilayici);
        System.out.println("Şu anda sıcaklık "+ sicaklik + " C°");
        if(30<sicaklik){
            publisher.notify("Dikkat! *Sıcaklık 30 C° 'nin üstünde*");
        }else if(sicaklik<0){
            publisher.notify(("Dikkat! *Sıcaklık 0 C° 'nin altında*"));
        }


    }

    @Override
    public void mesajGoruntule(String mesaj) {
        System.out.println(mesaj);
    }

    @Override
    public void ekranTemizle() {

    }
}
