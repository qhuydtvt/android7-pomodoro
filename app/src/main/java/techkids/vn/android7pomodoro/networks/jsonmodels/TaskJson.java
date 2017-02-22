package techkids.vn.android7pomodoro.networks.jsonmodels;

import com.google.gson.annotations.SerializedName;

/**
 * Created by huynq on 2/22/17.
 */

public class TaskJson {

    @SerializedName("color")
    public String color;
    @SerializedName("done")
    public boolean done;
    @SerializedName("name")
    public String name;
    @SerializedName("id")
    public String id;
    @SerializedName("payment_per_hour")
    public double paymentPerHour;
    @SerializedName("local_id")
    public String localId;
    @SerializedName("due_date")
    public String dueDate;

    public TaskJson(String color, boolean done, String name, String id, double paymentPerHour, String localId, String dueDate) {
        this.color = color;
        this.done = done;
        this.name = name;
        this.id = id;
        this.paymentPerHour = paymentPerHour;
        this.localId = localId;
        this.dueDate = dueDate;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getPaymentPerHour() {
        return paymentPerHour;
    }

    public void setPaymentPerHour(double paymentPerHour) {
        this.paymentPerHour = paymentPerHour;
    }

    public String getLocalId() {
        return localId;
    }

    public void setLocalId(String localId) {
        this.localId = localId;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }
}
