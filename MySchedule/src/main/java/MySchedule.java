import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class MySchedule {


    private final SimpleIntegerProperty textNumber;
    private final SimpleStringProperty textDate;
    private final SimpleStringProperty textTime;
    private final SimpleStringProperty textNote;



    public MySchedule(Integer textNumber,String textDate, String textTime, String textNote){
        this.textNumber=new SimpleIntegerProperty(textNumber);
        this.textDate = new SimpleStringProperty(textDate);
        this.textTime = new SimpleStringProperty(textTime);
        this.textNote = new SimpleStringProperty(textNote);

    }

    public String getTextDate() {
        return textDate.get();
    }

    public String getTextNote() {
        return textNote.get();
    }

    public String getTextTime() {
        return textTime.get();
    }

    public int getTextNumber() { return textNumber.get();
    }
}
