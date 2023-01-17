package pl.javastart.task.contract;

public abstract class Contract {
    protected int smsCounter = 0;
    protected int mmsCounter = 0;
    protected int callSecondsCounter = 0;

    public abstract void sendSms();

    public abstract void sendMms();

    public abstract void call(int seconds);

    public void showInfo() {
        System.out.println("=== STAN KONTA ===");
        System.out.println("Wysłanych SMSów: " + smsCounter);
        System.out.println("Wysłanych MMSów: " + mmsCounter);
        System.out.println("Liczba sekund rozmowy: " + callSecondsCounter);
    }
}
