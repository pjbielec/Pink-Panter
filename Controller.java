package com.przemyslawjbielec.pinkpanter;

import com.przemyslawjbielec.pinkpanter.datamodel.TodoData;
import com.przemyslawjbielec.pinkpanter.datamodel.TodoItem;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;

import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

public class Controller {

    private List<TodoItem> stuffToDo;
    @FXML
    private ListView<TodoItem> toDoListView;
    @FXML
    private TextArea itemDetailsArea;
    @FXML
    private Label deadlineDate;
    @FXML
    private BorderPane mainBorderPane;

    public void initialize() {

//        toDoListView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<TodoItem>() {
//            @Override
//            public void changed(ObservableValue<? extends TodoItem> observable, TodoItem oldValue, TodoItem newValue) {
//                if (newValue != null){
//                    TodoItem item = toDoListView.getSelectionModel().getSelectedItem();
//                    itemDetailsArea.setText(item.getLongDescription());
//                    DateTimeFormatter df = DateTimeFormatter.ofPattern("d MMMM yyyy");
//                    deadlineDate.setText(df.format(item.getDeadline()));
//                }
//            }
//        });
        toDoListView.getItems().setAll(TodoData.getInstance().getTodoItems());
        toDoListView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        toDoListView.getSelectionModel().selectFirst();

    }

    @FXML
    public void showNewItemDialogBox(){
        Dialog<ButtonType> dialog = new Dialog<>();
        dialog.initOwner(mainBorderPane.getScene().getWindow());
        dialog.setTitle("Adding New Thing");
        dialog.setHeaderText("This dialog box helps in creation of new Todo Item");
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("todoItemDialogBox.fxml"));
        try {
            dialog.getDialogPane().setContent(fxmlLoader.load());
        } catch (IOException e){
            System.out.println("Couldn't load the dialog");
            e.printStackTrace();
            return;
        }

        dialog.getDialogPane().getButtonTypes().add(ButtonType.OK);
        dialog.getDialogPane().getButtonTypes().add(ButtonType.CANCEL);

        Optional<ButtonType> result = dialog.showAndWait();
        if (result.isPresent() && result.get() == ButtonType.OK) {
            System.out.println("OK pressed");
            DialogController controller = fxmlLoader.getController();
            TodoItem newItem = controller .processResults();
            toDoListView.getItems().setAll(TodoData.getInstance().getTodoItems());
            toDoListView.getSelectionModel().select(newItem);
        } else {
            System.out.println("Cancel pressed");
        }

    }

    @FXML
    public void handleClickOnListItem(){
        TodoItem item = toDoListView.getSelectionModel().getSelectedItem();
        itemDetailsArea.setText(item.getLongDescription());
        DateTimeFormatter df = DateTimeFormatter.ofPattern("d MMMM yyyy");
        deadlineDate.setText(df.format(item.getDeadline()));
    }

}
