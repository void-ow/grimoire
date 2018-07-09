package model;

import lombok.Data;
import utils.dice.DTwenty;
import utils.messagelog.MessageLog;

@Data
public class Check {

    private String type = new String();
    private int requirement;
    private boolean fulfilled;
    private boolean checked;

    public Check(String type, int requirement) {
        this.type = type;
        this.requirement = requirement;
    }

    public Check(String type) {
        this.type = type;
        requirement = DTwenty.rollWithFloor(10);
    }

    public boolean check() {

        if (checked) {
            return fulfilled;
        }

        MessageLog.addMessage("Rolling " + type + " check", true);
        checked = true;

        int roll = DTwenty.rollAndPrint();

        if (roll > requirement) {
            fulfilled = true;
        }
        return fulfilled;
    }
}
