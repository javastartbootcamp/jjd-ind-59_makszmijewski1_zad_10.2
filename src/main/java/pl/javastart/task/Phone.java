package pl.javastart.task;

import pl.javastart.task.contract.Contract;

public class Phone {
    private Contract contract;

    public Phone(Contract contract) {
        this.contract = contract;
    }

    public void sendSms() {
        contract.sendSms();
    }

    public void sendMms() {
        contract.sendMms();
    }

    public void call(int seconds) {
        contract.call(seconds);
    }

    public void printAccountState() {
        contract.showInfo();
    }
}
