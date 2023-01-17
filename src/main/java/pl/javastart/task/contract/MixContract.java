package pl.javastart.task.contract;

public class MixContract extends Contract {
    private static final double SMS_COST = 0.1;
    private static final double MMS_COST = 0.2;
    private static final double ONE_MINUTE_CALL_COST = 0.5;
    private static final double ONE_SECOND_CALL_COST = ONE_MINUTE_CALL_COST / 60;
    private static final double POSSIBLE_SMS = 150;
    private static final double POSSIBLE_MMS = 15;
    private static final double POSSIBLE_CALL_SECONDS = 5000;
    private double balance;

    public MixContract(double balance) {
        this.balance = balance;
    }

    public void sendSms() {
        if (smsCounter < POSSIBLE_SMS) {
            System.out.println("SMS wysłany");
            smsCounter++;
        } else if (balance >= SMS_COST) {
            System.out.println("SMS wysłany");
            balance -= SMS_COST;
            smsCounter++;
        } else {
            System.out.println("Nie udało się wysłać SMSa");
        }
    }

    public void sendMms() {
        if (mmsCounter < POSSIBLE_MMS) {
            System.out.println("MMS wysłany");
            mmsCounter++;
        } else if (balance >= MMS_COST) {
            System.out.println("MMS wysłany");
            balance -= MMS_COST;
            mmsCounter++;
        } else {
            System.out.println("Nie udało się wysłać MMSa");
        }
    }

    public void call(int seconds) {
        double possibleCallSeconds = POSSIBLE_CALL_SECONDS + (balance / ONE_SECOND_CALL_COST);
        if (callSecondsCounter + seconds <= possibleCallSeconds) {
            System.out.println("Rozmowa trwała " + seconds + " sekund");
            callSecondsCounter += seconds;
            if (callSecondsCounter < POSSIBLE_CALL_SECONDS) {
                possibleCallSeconds -= seconds;
            } else {
                balance = ((possibleCallSeconds - seconds) * ONE_SECOND_CALL_COST);
                possibleCallSeconds = balance / ONE_SECOND_CALL_COST;
            }

        } else if (possibleCallSeconds <= 0) {
            System.out.println("Nie udało się zadzwonić");
        } else {
            System.out.println("Rozmowa przerwana, udało się rozmawiać "
                    + possibleCallSeconds + " sekund");
            callSecondsCounter += possibleCallSeconds;
            balance = 0;
        }

    }

    @Override
    public void showInfo() {
        super.showInfo();
        System.out.println("Na koncie zostało " + String.format("%.2f", balance) + "zł");
    }
}
