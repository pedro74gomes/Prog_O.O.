
/**
 * Escreva a descrição da classe Test_I aqui.
 * 
 * @author (pedro) 
 * @version (03/2021)
 */
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.FileInputStream;

public class Test_I{
  public static void main(String [] args){
    Scanner ler = new Scanner(System.in);
    ExI exs = new ExI();
    System.out.println("Introduza qual alinea quer: ");
    int alinea = ler.nextInt();
    switch(alinea) {
                 case 1: System.out.println("Introduza uma data: ");
                         int dia = ler.nextInt();
                         int mes = ler.nextInt();
                         int ano = ler.nextInt();
                         ler.close();
                         int diaS=exs.SaberData(dia,mes,ano);
                         System.out.println("A data que inseriu corresponde a um/uma "+ exs.DiadaSemana(diaS) + ".\n");
                 break;
                 case 2: System.out.println("Introduza a primeira data: "); // Esta captura podia ter sido feita num array (como foi feito na 7) o que facilitaria as coisas ¯\_(ツ)_/¯, agora já está feito.
                         int dia1 = ler.nextInt();
                         int mes1 = ler.nextInt();
                         int ano1 = ler.nextInt();
                         System.out.println("Introduza a segunda data: ");
                         int dia2 = ler.nextInt();
                         int mes2 = ler.nextInt();
                         int ano2 = ler.nextInt();
                         ler.close();
                         ano1%=100; ano2%=100;
                         int ind = Math.min((ano1),(ano2));
                         int total = 0;
                         if(ind == ano2) { total = exs.converter(dia1+dia2,mes1+mes2,ano1,ind);
                         }else { total = exs.converter(dia1+dia2,mes1+mes2,ano2,ind);
                         }
                         System.out.println((total)+"D"+" "+((total)*24)+"H"+" "+((total)*1440)+"M"+" "+((total)*86400)+"S");
                 break;
                 case 3: System.out.println("Quantas classificações vai querer comparar: ");
                         int size = ler.nextInt();
                         int[] classif= new int[size];
                         for(int i=0;i<size;i++){
                            System.out.println("Digite a classificação: ");
                            classif[i] = ler.nextInt();
                          }
                          ler.close();
                          int[] nClass = exs.mergeClass(classif,size);
                          System.out.println("Entre o intervalo de [0, 5[ são "+nClass[0] +", já entre [5, 10[ existe/existem "+nClass[1]+", entre [10, 15[ são "+nClass[2]+" e finalmente entre [15, 20] existe/existem "+nClass[3]+ ".\n");
                 break;
                 case 4: System.out.println("Quantas temperaturas vai querer comparar: ");
                         int length = ler.nextInt();
                         int[] temperaturas= new int[length];
                         for(int i=0;i<length;i++){
                           System.out.println("Digite a sua temperatura: ");
                           temperaturas[i] = ler.nextInt();
                         }
                         ler.close();
                         int[] vals = exs.calcTemp(temperaturas,length);
                         System.out.println("A média das "+length+" temperaturas foi de "+ ((IntStream.of(temperaturas).sum()) /2) +" graus.\nA maior variação registou-se entre os dias "+(vals[2]+=1)+"  e "+(vals[1]+=1)+", tendo a temperatura subido/descido "+vals[0]+" graus.");
                 break;
                 case 5: System.out.println("Insira um valor real para a base e a altura do triângulo: "); 
                         try{BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                          String line;
                          String num;
                          while ((line = reader.readLine()) != null){
                              if (line.contains("0.0")) {break;}
                              num = exs.areaPer(line);
                              System.out.println("A área e o perímetro do triângulo são "+num);
                              System.out.println("Insira um valor real para a base e a altura do triângulo: "); 
                          }
                          } catch (IOException e) { e.printStackTrace(); }
                 break;
                 case 6: System.out.println("Indique um nº inteiro: ");
                         int val = ler.nextInt();
                         ler.close();
                         int[] list = exs.primos(val); 
                         System.out.println("Os valores primos do valor "+ val +" são: " + Arrays.toString(list) + ".\n");
                 break;
                 case 7: System.out.println("Indique a sua data de nascimento (dia mês ano): ");
                        int nascimento[] = new int[3];
                         for(int i=0;i<3;i++){
                             nascimento[i] = ler.nextInt();
                         }
                         ler.close();
                         String[] lista = exs.nasciHora(nascimento);
                         System.out.println("A sua idade atual em horas corresponde a "+lista[0] +". Este calculo foi realizado a "+lista[1]+".\n");
                 break;
                 default: System.out.println("Essa alínea não existe, tente outra.");
                 break;
                }
  }
}
