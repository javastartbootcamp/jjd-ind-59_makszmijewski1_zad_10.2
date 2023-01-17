package pl.javastart.task.contract;

public class CardContract extends Contract {
    private static final double SMS_COST = 0.1;
    private static final double MMS_COST = 0.2;
    private static final double ONE_MINUTE_CALL_COST = 0.5;
    private static final double ONE_SECOND_CALL_COST = ONE_MINUTE_CALL_COST / 60;
    private double balance;

    public CardContract(double balance) {
        this.balance = balance;
    }

    @Override
    public void sendSms() {
        if (balance >= SMS_COST) {
            System.out.println("SMS wysłany");
            smsCounter++;
            balance -= SMS_COST;
        } else {
            System.out.println("Nie udało się wysłać SMSa");
        }
    }

    @Override
    public void sendMms() {
        if (balance >= MMS_COST) {
            System.out.println("MMS wysłany");
        } else {
            System.out.println("Nie udało się wysłać MMSa");
        }
    }

    @Override
    public void call(int seconds) {
        double callCost = seconds * ONE_SECOND_CALL_COST;
        if (balance >= callCost) {
            System.out.println("Rozmowa trwała " + seconds + " sekund");
            balance -= callCost;
            callSecondsCounter += seconds;
        } else if (balance <= 0) {
            System.out.println("Nie udało się zadzwonić");
        } else {
            double possibleCallSeconds = balance / ONE_SECOND_CALL_COST;
            System.out.println("Rozmowa przerwana, udało się rozmawiać "
                    + possibleCallSeconds + " sekund");
            balance = 0;
            callSecondsCounter += possibleCallSeconds;
        }
    }

    @Override
    public void showInfo() {
        super.showInfo();
        System.out.println("Na koncie zostało " + String.format("%.2f", balance) + "zł");
    }
}
