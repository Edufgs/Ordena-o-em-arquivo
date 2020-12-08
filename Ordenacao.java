package com.compiladores;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;


/**
 * Programa que faz a ordenação de numeros em um arquivo texto
 * @author Eduardo Gonçalves da Silva
 */
public class Ordenacao {
    public static void main(String[] args){
        try{
            //abre o arquivo
            FileInputStream entrada = new FileInputStream("E:\\Eduardo\\Eduardo\\Semestres\\6 Semestre\\Compiladores\\Projetos\\Ordenacao\\arquivo.txt");//abre o arquivo
            InputStreamReader entradaFormatada = new InputStreamReader(entrada);//abre para leituda do arquivo (ele lê bytes e os decodifica em caracteres usando um especificado charset)
            BufferedReader entradaString = new BufferedReader(entradaFormatada);//Lê texto de um fluxo de entrada de caracteres, armazenando caracteres em buffer para fornecer uma leitura eficiente de caracteres, matrizes e linhas
            
            String linha = entradaString.readLine();
            
            char letra[] = linha.toCharArray();
            
            System.out.println("Sem ordenar:");
            System.out.print(letra);
                        
            //SelectionSort
            for (int fixo = 0; fixo < letra.length - 1; fixo++) {
                int menor = fixo;

                for (int i = menor + 1; i < letra.length; i++) {
                    if (letra[i] < letra[menor]) {
                        menor = i;
                    }
                }
                if (menor != fixo) {
                    int t = letra[fixo];
                    letra[fixo] = letra[menor];
                    letra[menor] = (char) t;
                }
            }
            
            entrada.close(); //fecha o arquivo de leitura
            
            System.out.println("\n\nDepois da Ordenação:");
            System.out.print(letra);
            
            FileWriter fSaida = new FileWriter("E:\\Eduardo\\Eduardo\\Semestres\\6 Semestre\\Compiladores\\Projetos\\Ordenacao\\arquivo.txt"); //abre o arquivo para gravação
            PrintWriter pSaida = new PrintWriter(fSaida); //abre o arquivo para gravar com outros metodos
                      
            pSaida.print(letra); //grava no arquivo no arquivo
            
            fSaida.close(); //Fecha arquivo de gravação
  
        }catch(IOException e){
            System.out.println("Erro na Abertura do arquivo!! = " + e);
        }
    }
}
