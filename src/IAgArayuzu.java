public interface IAgArayuzu {
    public int sicaklikGonder(ISicaklikAlgilayici sicaklikAlgilayici);
    public void sogutucuAc(IEyleyici eyleyici, ISicaklikAlgilayici sicaklikAlgilayici, int sicaklik, ITusTakimi tusTakimi, IEkran ekran);
    public void sogutucuKapat();
}
