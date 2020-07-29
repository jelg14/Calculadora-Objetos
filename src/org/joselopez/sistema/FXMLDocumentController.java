/*
Programador: Jose Eduardo lopez Gonzalez
Creado: 23/04/19
    23/04/19: creacion de controlador, clase principal, vista 
              y metodos de texto, botones y handleButtonAction.
    24/04/19: creacion de metodo existepunto.
 */
package org.joselopez.sistema;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class FXMLDocumentController implements Initializable {
    float dato1,dato2,resultado;
    int opcion;
   
   
            
    @FXML private TextField txtValores;
    @FXML private Button btnmasmenos;
    @FXML private Button btncero;
    @FXML private Button btnpunto;
    @FXML private Button btnigual;
    @FXML private Button btnuno;  
    @FXML private Button btndos;
    @FXML private Button btntres;
    @FXML private Button btncuatro;
    @FXML private Button btncinco;
    @FXML private Button btnseis;
    @FXML private Button btnsiete;
    @FXML private Button btnocho;
    @FXML private Button btnnueve;
    @FXML private Button btnsuma;
    @FXML private Button btnresta;
    @FXML private Button btnmultiplicacion;
    @FXML private Button btnCE;
    @FXML private Button btnC;
    @FXML private Button btnunoequis;
    @FXML private Button btndivision;
    @FXML private Button btnporcentaje;
    @FXML private Button btnpotencia;
    @FXML private Button btnraiz;
    
    @FXML
    private void handleButtonAction (ActionEvent event){
        
        if(event.getSource()==btnuno)
            txtValores.setText(txtValores.getText()+"1");
        else if(event.getSource()==btndos)
            txtValores.setText(txtValores.getText()+"2");
        else if(event.getSource()==btntres)
            txtValores.setText(txtValores.getText()+"3");
        else if(event.getSource()==btncuatro)
            txtValores.setText(txtValores.getText()+"4");
        else if(event.getSource()==btncinco)
            txtValores.setText(txtValores.getText()+"5");
        else if(event.getSource()==btnseis)
            txtValores.setText(txtValores.getText()+"6");
        else if(event.getSource()==btnsiete)
            txtValores.setText(txtValores.getText()+"7");
        else if(event.getSource()==btnocho)
            txtValores.setText(txtValores.getText()+"8");
        else if(event.getSource()==btnnueve)
            txtValores.setText(txtValores.getText()+"9");
        else if(event.getSource()==btncero)
            txtValores.setText(txtValores.getText()+"0");
        else if(event.getSource()==btnpunto){
            String cadena;
            cadena = txtValores.getText();
            if(cadena.length()<= 0)
                txtValores.setText("0.");
            else{
                if(!existepunto(txtValores.getText())){
                    txtValores.setText(txtValores.getText()+".");
                }
            }
        }else if(event.getSource()==btnsuma ){
            if(dato1==0){
                dato1= Float.parseFloat(txtValores.getText());
                txtValores.setText("");
                opcion=1;
            }else{
                dato1=dato1+Float.parseFloat(txtValores.getText());
                txtValores.setText("");
                opcion = 1;
            }
        }else if(event.getSource()==btnresta){
            if(dato1==0){
                dato1=Float.parseFloat(txtValores.getText());
                txtValores.setText("");
                opcion = 2;
            }else{
                dato1=dato1-Float.parseFloat(txtValores.getText());
                txtValores.setText("");
                opcion =2;
            }
        }else if(event.getSource()==btnmultiplicacion){
            dato1=Float.parseFloat(txtValores.getText());
            txtValores.setText("");
            opcion = 3;
        }else if(event.getSource()==btndivision){
            dato1=Float.parseFloat(txtValores.getText());
            txtValores.setText(" ");
            opcion=4;
        }else if(event.getSource()==btnporcentaje){
            dato2=Float.parseFloat(txtValores.getText());
            txtValores.setText(" ");
            txtValores.setText(String.valueOf(dato1*dato2/100));
            
        }else if(event.getSource()==btnigual){
            dato2 = Float.parseFloat(txtValores.getText());
            txtValores.setText("");
            switch(opcion){
                case 1:
                    resultado = dato1 + dato2;
                    txtValores.setText(String.valueOf(resultado));
                break;
                
                case 2:
                    resultado = dato1 - dato2;
                    txtValores.setText(String.valueOf(resultado));              
                break;
                
                case 3:
                    resultado = dato1 * dato2;
                    txtValores.setText(String.valueOf(resultado));
                break;
                
                case 4:
                    if(dato2!=0){
                        resultado = dato1 / dato2;
                        txtValores.setText(String.valueOf(resultado));
                    }else{
                        txtValores.setText("MATH ERROR");
                    }
                break;
            }
            dato1=0;
        }else if(event.getSource()==btnpotencia){
            dato1=Float.parseFloat(txtValores.getText());
            resultado=dato1*dato1;
            txtValores.setText(String.valueOf(resultado));
            dato1=0;
        }else if(event.getSource()==btnmasmenos){
            dato1=Float.parseFloat(txtValores.getText());
            if(dato1 != 0){
                resultado = dato1 * -1;
                txtValores.setText(String.valueOf(resultado));
            }
            dato1=0;
        }else if(event.getSource()==btnunoequis){
            dato1=Float.parseFloat(txtValores.getText());
            if(dato1 != 0){
                resultado = 1/dato1;
                txtValores.setText(String.valueOf(resultado)); 
            }else{
                txtValores.setText("MATH ERROR");
            }         
            dato1=0;
        }else if(event.getSource()==btnC){
            dato1=0;
            dato2=0;
            resultado=0;
            txtValores.setText(" ");
        }else if(event.getSource()==btnCE){
            dato2=0;
            txtValores.setText(" ");
        }else if(event.getSource()==btnraiz){
            dato1=Float.parseFloat(txtValores.getText());
            resultado= (float) Math.sqrt(dato1);
            txtValores.setText(String.valueOf(resultado));
            dato1=0;
        }
    } 
    
    @FXML
    public static boolean existepunto(String cadena){
        boolean result;
        result=false;

        for (int i = 0; i < cadena.length(); i++) {
            if (cadena.substring(i, i+1).equals(".")) {
                result=true;             
            }   
        }
        return result;          
    }
        
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }    
}