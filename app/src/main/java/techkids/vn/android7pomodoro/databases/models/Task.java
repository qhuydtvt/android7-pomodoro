package techkids.vn.android7pomodoro.databases.models;

/**
 * Created by huynq on 2/8/17.
 */

public class Task {
    private String name;
    private String color;
    private float paymentPerHour;
    private boolean isDone;

    public Task(String name, String color) {
        this.name = name;
        this.color = color;
        this.isDone = false;
    }

    public Task(String name, String color, float paymentPerHour) {
        this.name = name;
        this.color = color;
        this.paymentPerHour = paymentPerHour;
        this.isDone = false;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public float getPaymentPerHour() {
        return paymentPerHour;
    }

    public void setPaymentPerHour(float paymentPerHour) {
        this.paymentPerHour = paymentPerHour;
    }

    public boolean isDone() {
        return isDone;
    }

    public void setDone(boolean done) {
        isDone = done;
    }

    public void flipDone() {
        isDone = !isDone;
    }

    @Override
    public String toString() {
        return "Task{" +
                "name='" + name + '\'' +
                ", color='" + color + '\'' +
                '}';
    }
}
