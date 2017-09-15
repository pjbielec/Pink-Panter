package com.przemyslawjbielec.pinkpanter;

import com.przemyslawjbielec.pinkpanter.datamodel.TodoData;
import com.przemyslawjbielec.pinkpanter.datamodel.TodoItem;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.time.LocalDate;

/**
 * Created by Przemek on 19.07.2017.
 */
public class DialogController {

    @FXML
    private TextField shortDescriptionDB;

    @FXML
    private TextArea longDescriptionDB;

    @FXML
    private DatePicker deadlinePickerDB;

    public TodoItem processResults(){
        String shortDescription = shortDescriptionDB.getText().trim();
        String longDescription = longDescriptionDB.getText().trim();
        LocalDate deadlineDate = deadlinePickerDB.getValue();

        TodoItem newItem = new TodoItem(shortDescription, longDescription, deadlineDate);
        TodoData.getInstance().addTodoItem(newItem);
        return newItem;
    }

}
