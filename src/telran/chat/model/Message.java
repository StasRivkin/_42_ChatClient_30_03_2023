package telran.chat.model;

import java.io.Serializable;
import java.time.LocalTime;

public class Message implements Serializable {
    private static final long serialVersionUID = 1L;
    String nickName;
    LocalTime time;
    String message;

    public Message(String nickName, String message) {
        this.nickName = nickName;
        this.time = LocalTime.now();
        this.message = message;
    }

    public String getNickName() {
        return nickName;
    }

    public LocalTime getTime() {
        return time;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return nickName + " [" + time + "] : " + message;
    }
}
