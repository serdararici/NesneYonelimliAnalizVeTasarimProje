public interface IEkran {
    public void sicaklikGoruntule(ISicaklikAlgilayici sicaklikAlgilayici, IAgArayuzu agArayuzu, ISubject publisher);
    public void mesajGoruntule(String mesaj);
    public void ekranTemizle();
}
