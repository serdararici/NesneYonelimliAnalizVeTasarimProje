public class AgArayuzu implements IAgArayuzu{
    int sicaklik;
    @Override
    public int sicaklikGonder(ISicaklikAlgilayici sicaklikAlgilayici) {
        //SicaklikAlgilayici sicaklikAlgilayici = new SicaklikAlgilayici();
        sicaklik = sicaklikAlgilayici.sicaklikOku();
        //System.out.println("Şu anda sıcaklık "+ sicaklik + " C°");
        return sicaklik;
    }

    @Override
    public void sogutucuAc(IEyleyici eyleyici, ISicaklikAlgilayici sicaklikAlgilayici, int sicaklik, ITusTakimi tusTakimi, IEkran ekran) {
        //Eyleyici eyleyici = new Eyleyici();
        eyleyici.sogutucuAc(sicaklikAlgilayici,sicaklik, tusTakimi, ekran);
    }

    @Override
    public void sogutucuKapat() {
        Eyleyici eyleyici = new Eyleyici();
        eyleyici.sogutucuKapat();
    }
}
