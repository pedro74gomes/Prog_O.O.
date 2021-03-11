/**
 *  EX_I  
 * @author (pedro) 
 * @version (03/2021)
 */  
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Iterator;
import java.lang.Object;
import java.lang.*;
import java.util.*;
import java.io.*;
import java.util.Date;
import java.time.LocalDate;
import java.util.Calendar;

public class ExI{
    public String DiadaSemana(int diaS){
        switch(diaS) {
            case 0: return "Domingo";
            case 1: return "Segunda-feira";
            case 2: return "Terça-feira";
            case 3: return "Quarta-feira";
            case 4: return "Quinta-feira";
            case 5: return "Sexta-feira";
            case 6: return "Sábado";
        }
        return "None";
    }
    static int diasDoMesN[] = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    static int diasDoMesB[] = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    public static int[] maxArray(int[] temps,int length){
        int[] lista = new int[2];
        lista[1] = temps[0];
        for(int i = 1; i<length;i++){
            if (temps[i] > lista[1]){
            lista[1] = temps[i]; lista[0] = i;
            }
        }
        return lista;
    }
    public static int[] minArray(int[] temps,int length){
        int[] lista = new int[2];
        lista[1] = temps[0];
        for(int i = 1; i<length;i++){
            if (temps[i] < lista[1]){
            lista[1] = temps[i]; lista[0] = i;
            }
        }
        return lista;
    }
    public static int[] addElement(int len, int arr[], int x){ 
        int i;
        int newarr[] = new int[len + 1]; 
        for (i = 0; i < len; i++) 
        newarr[i] = arr[i]; 
        newarr[len] = x; 
        return newarr; 
    }
    public int SaberData(int dia,int mes, int ano){
        int novo = (ano-1900)*365;  // para dar certo deveria ser 'int novo =(int) ((ano-1900)*365.25)'
        if(ano%4 == 0 && mes < 3) novo--;
        for(int i = mes; i > 0; i--){
            if(i==2) novo+=28;
            else if(i==1 || i==3 || i==5 || i==7 || i==8 || i==10 || i==12) novo+=31;
            else novo+=30;
        }
        return novo % 7;
    }
    public int converter(int dia,int mes, int maxA, int minA){
        int val=0;
        int i = 0;
        while(maxA>minA){
            if(maxA%4 == 0) val+=366;
            else val+=365;
            maxA--;
        }
        while(i<mes-1){
            if(minA%4 != 0){val+=diasDoMesN[i];} 
            else {val+=diasDoMesB[i];}
            minA++;
            i++;
        }
        return val+dia;
    }
    public int[] mergeClass(int[] classif,int size){
        int[] total = {0,0,0,0};
        int i=0;
        while (i<size){
            if(classif[i]>=0 && classif[i]<5) total[0]+=1;
            else if (classif[i]>=5 && classif[i]<10) total[1]+=1;
            else if (classif[i]>=10 && classif[i]<15) total[2]+=1;
            else total[3]+=1;
            i++;
        }
        return total;
    }
    public int[] calcTemp(int[] temp, int length){
        int[] list = new int[1];
        int[] list1 = new int[2];
        list = (minArray(temp,length));
        list1 = (maxArray(temp,length));
        list[2] = list[0];
        list[0] = list1[1] - list[1];
        list[1] = list1[0];
        return list;
    }
    public String areaPer(String line){
        String[] vales = line.split(" ");
        float base = Float.parseFloat(vales[0]);
        float alt = Float.parseFloat(vales[1]);
        float area = (base*alt)/2;
        float hip = (float)Math.sqrt((alt*alt)+(base*base));
        float peri = hip+base+alt;
        return ""+String.format("%.5g%n", area)+" e "+String.format("%.5g%n", peri)+"";
    }
    public int[] primos(int val){
        int[] list = new int[val];
        int i = 1, num = 0, size=0;
        for (; i <= val; i++){ 		 		  
            int counter=0; 		  
            for(num =i; num>=1; num--){
                if(i%num==0){counter = counter + 1;}
            }
            if (counter ==2){
                size++;
                list = addElement(size,list, i);
	    }	
        }
        return list;
    }
    public String[] nasciHora(int[] nascimento){
        String[] calculo = new String[2];
        int val=0;
        int i=0;
        Date date = new Date();
        Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("Europe/Paris"));
        cal.setTime(date);
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        month+=1;
        int day = cal.get(Calendar.DAY_OF_MONTH);
        int hour = cal.get(Calendar.HOUR_OF_DAY);
        int minutes = cal.get(Calendar.MINUTE);
        calculo[1] = ""+day+" do "+month+" de "+year+" às "+hour+":"+minutes;
        int difd = Math.abs((day-nascimento[0])*24);
        int maxA = Math.max(nascimento[2],year);
        int minA = Math.min(nascimento[2],year);
        int maxM = Math.max(nascimento[1],month);
        if (year != nascimento[2] || month != nascimento[1]){
            while(maxA>minA){
            if(maxA%4 == 0) val+=(366*24);
            else val+=(365*24);
            maxA--;
            }
            while(i<maxM-1){
                if(minA%4 != 0){val+=diasDoMesN[i]*24;} 
                else {val+=diasDoMesB[i]*24;}
                minA++;
                i++;
            }
        }
        val+=difd;
        calculo[0] = String.valueOf(val);
        return calculo;
    }
}