package br.senai.sp.jandira.media_final;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import javax.swing.*;
import java.awt.*;
import java.util.Optional;

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

        buttonCalcularMedia.setOnAction(click -> {
            System.out.println("Botão clicado!");
            String nomeDigitado = textFieldNome.getText();
            labelAluno.setText("Nome do aluno: " + nomeDigitado);

            //Cacular Média
            //Obter as notas

            //Criar um vetor (array) de notas

            double[] notas = new double[4];
            String[] notasStr = new String[4];

            notasStr[0] = textFieldNota1.getText();
            notas[0] = Double.parseDouble(notasStr[0]);

            notasStr[1] = textFieldNota2.getText();
            notas[1] = Double.parseDouble(notasStr[1]);

            notasStr[2] =  textFieldNota3.getText();
            notas[2] = Double.parseDouble(notasStr[2]);

            notasStr[3] = textFieldNota4.getText();
            notas[3]= Double.parseDouble(notasStr[3]);

            //Uso de LOOP while (Enquanto)


            double mediaFinal = 0.0;
            int i =0;
            while (i<notas.length){

                mediaFinal= mediaFinal + notas[i];
                i= i + 1;
            }
            mediaFinal = mediaFinal/notas.length;



            String mediaFinalStr = String.format("%.2f",mediaFinal);

            labelMediaFinal.setText("Media final: " + mediaFinalStr);

        // Calcular Aprovado, reprovado ou Em Recuperação

            String situacao;

             if (mediaFinal< 4){
           situacao = "Reprovado";
             }else if (mediaFinal>=6){
           situacao ="Aprovado";
              }else {
                 situacao = "Recuperação";
              }

            labelSituacao.setText("Situação: " + situacao);

        });

        buttonLimpar.setOnAction(click->{

            textFieldNome.clear();
            textFieldNota1.clear();
            textFieldNota2.clear();
            textFieldNota3.clear();
            textFieldNota4.clear();

            labelMediaFinal.setText("Media Final: ");
            labelSituacao.setText("Situação : ");
            labelAluno.setText("Nome do aluno: ");
            textFieldNome.requestFocus();

        }); // Função Lambda

        buttonSair.setOnAction(actionEvent -> {
            Alert alerta = new Alert(Alert.AlertType.CONFIRMATION, "Fechar aplicação", ButtonType.YES,  ButtonType.NO);
            Optional<ButtonType>botaoPressionado = alerta.showAndWait();

            if (botaoPressionado.get()==ButtonType.YES) {
                Alert alerta2 = new Alert(Alert.AlertType.INFORMATION, "Até logo!");
                alerta2.showAndWait();
              System.exit(0);
            }


        });

    }
}
