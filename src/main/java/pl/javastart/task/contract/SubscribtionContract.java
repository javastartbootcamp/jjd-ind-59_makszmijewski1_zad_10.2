package pl.javastart.task.contract;

public class SubscribtionContract extends Contract {

    private static final double MONTHLY_PAYMENT = 100;

    public void sendSms() {
        System.out.println("SMS wysłany");
        smsCounter++;
    }

    public void sendMms() {
        System.out.println("MMS wysłany");
        mmsCounter++;
    }

    public void call(int seconds) {
        System.out.println("Rozmowa trwała " + seconds + " sekund");
        callSecondsCounter += seconds;
    }

    @Override
    public void showInfo() {
        super.showInfo();
        System.out.println("Abonament - brak limitu rozmów");
    }
}
