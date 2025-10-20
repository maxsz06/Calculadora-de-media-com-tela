package br.senai.sp.jandira.media_final;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import javax.swing.*;
import java.awt.*;

//------------------------------------------------//

public class MediaFinalApp extends Application {

    public static void main(String[] args) {
        launch(args);
    }


    @Override   //Metodo responsavel por iniciar o "Stage (Palco)"
    public void start(Stage stage) throws Exception {


        stage.setWidth(600);    // Determinar o tamanho do stage
        stage.setHeight(600);   // Determinar o tamanho do stage


        stage.setTitle("Média Final");  //Derteminar o título do stage (tela/janela)


        BorderPane root = new BorderPane();   // Painel Raiz (root)




        Label labelTitulo= new Label();       // Painel Titulo (top)
        labelTitulo.setText("Escola \"Prof. Vicente Amato\"");


        //Formatação do texto da label

        labelTitulo.setStyle("-fx-text-fill: #fc1c03; -fx-font-size:32;-fx-font-weight:bold"); // alterando a cor do titulo, Tamanho
        labelTitulo.setPadding(new Insets(10,0,10,10)); //Delimitar o espaçamento



        //Painel formulario

        VBox painelFormulario = new VBox();
        painelFormulario.setPadding(new Insets (0,0,10,10));

        Label labelNome = new Label("Nome do Aluno");
        Label labelNota1 = new Label("Nota 1");
        Label labelNota2 = new Label("Nota 2");
        Label labelNota3 = new Label("Nota 3");
        Label labelNota4 = new Label("Nota 4");
        TextField textFieldNome = new TextField("");
        TextField textFieldNota1 = new TextField("");
        TextField textFieldNota2 = new TextField("");
        TextField textFieldNota3 = new TextField("");
        TextField textFieldNota4 = new TextField("");

        painelFormulario.getChildren().addAll(

                labelNome, textFieldNome,
                labelNota1, textFieldNota1,
                labelNota2, textFieldNota2,
                labelNota3, textFieldNota3,
                labelNota4, textFieldNota4

        ); //Adiciona o "Label" e "TextField" ao agrupamento para mandar para o (Root)




        // Painel Resultado (Bottom)

        VBox painelResultado = new VBox();
        painelResultado.setPadding(new Insets (0,0,20,10));

        Label labelAluno = new Label("Nome do Aluno: ");
        Label labelMediaFinal = new Label("Media final: ");
        Label labelSituacao = new Label("Situação: ");

        painelResultado.getChildren().addAll(labelAluno,labelMediaFinal,labelSituacao);//Adiciona o "Label" e "TextField" ao agrupamento para mandar para o (Root)



        //Painel de Botoes

        VBox painelDeBotoes = new VBox();
        painelDeBotoes.setPadding(new Insets (0,10,10,0));
        painelDeBotoes.setSpacing(10);

        Button buttonCalcularMedia = new Button("Calcular Média");
        buttonCalcularMedia.setPrefHeight(30);
        buttonCalcularMedia.setPrefWidth(100);

        Button buttonLimpar = new Button("Limpar");
        buttonLimpar.setPrefWidth(100);
        buttonLimpar.setPrefHeight(30);

        Button buttonSair = new Button("Sair");
        buttonSair.setPrefWidth(100);
        buttonSair.setPrefHeight(30);

        painelDeBotoes.getChildren().addAll(buttonCalcularMedia,buttonLimpar,buttonSair);//Adiciona o "Label" e "TextField" ao agrupamento para mandar para o (Root)




        //Definir onde vai ficar cada caixa

        root.setBottom(painelResultado);
        root.setTop(labelTitulo);
        root.setRight(painelDeBotoes);
        root.setLeft(painelFormulario);

        Scene scene= new Scene(root);

        stage.setScene(scene);





        stage.show();//Mostrar o Stage (Tela/Janela)


        //Eventos de clique dos botões

    }

}
