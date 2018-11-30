package ba.unsa.etf.rpr;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ResourceBundle;

public class Controller implements Initializable {


    public TextField jmbg;

    public TextField getIme() {
        return ime;
    }

    public void setIme(TextField ime) {
        this.ime = ime;
    }

    public TextField ime;
    public TextField prezime;
    public TextField indeks;
    public Button prijava;
    public CheckBox boracka;
    public RadioButton samofinansirajuci;
    public ToggleGroup status;
    public RadioButton redovan;
    public ChoiceBox ciklus;
    public ChoiceBox godinaStudija;
    public ChoiceBox odsjek;
    public TextField email;
    public TextField telefon;
    public TextField adresa;
    public DatePicker datumR;
    public ComboBox mjestoRodjenja;
    //private boolean imeValidno;

    public Controller() {

    }


    @FXML
    public void initialize(URL location, ResourceBundle resources) {
        ime.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (validnoImePrezime(newValue)) {
                    ime.getStyleClass().removeAll("poljeNijeIspravno");
                    ime.getStyleClass().add("poljeIspravno");
                } else {
                    ime.getStyleClass().removeAll("poljeIspravno");
                    ime.getStyleClass().add("poljeNijeIspravno");
                }
            }
        });
        prezime.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (validnoImePrezime(newValue)) {
                    prezime.getStyleClass().removeAll("poljeNijeIspravno");
                    prezime.getStyleClass().add("poljeIspravno");
                } else {
                    prezime.getStyleClass().removeAll("poljeIspravno");
                    prezime.getStyleClass().add("poljeNijeIspravno");
                }
            }
        });
        indeks.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (validanIndex(newValue)) {
                    indeks.getStyleClass().removeAll("poljeNijeIspravno");
                    indeks.getStyleClass().add("poljeIspravno");
                } else {
                    indeks.getStyleClass().removeAll("poljeIspravno");
                    indeks.getStyleClass().add("poljeNijeIspravno");
                }
            }
        });
    }

    private boolean validnoImePrezime(String n) {
        if(n.trim().isEmpty()) return  false;
        if( !(n.charAt(0)>=65 && n.charAt(0)<=90))return false;
        if(n.length()>20) return  false;
        for(int i=1;i<n.length();i++){
            if(!(n.charAt(i)>=97 && n.charAt(i)<=122)) return false;
        }
        return true;
    }
    private boolean validanIndex(String n){
        int broj;
        try{
            broj=Integer.parseInt(n);
            if(broj<10000 ||broj>99999) return false;

        }catch (Exception e){
            return false;
        }
        return  true;
    }

    public void prijavi(ActionEvent actionEvent) {
        System.out.print(ime.textProperty().get()+" "+prezime.textProperty().get());
    }
}