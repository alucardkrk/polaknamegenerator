package com.alucardkrk.randompolakgenerator.persongenerator;

import java.util.Random;

public class Person {

    private String postalCode;
    private String idNumber;
    private String pesel;
    private String birthDate;


    public Person() {
        int sex = new Random().nextInt(2);
        String tempPesel =generatePesel(sex);
        this.pesel = tempPesel;
        this.birthDate=generateBirthDate(tempPesel);
        this.idNumber=generateIDNumber();
        this.postalCode=generatePostalCode();
    }
    public Person(int sex){
        String tempPesel =generatePesel(sex);
        this.pesel = tempPesel;
        this.birthDate=generateBirthDate(tempPesel);
        this.idNumber=generateIDNumber();
        this.postalCode=generatePostalCode();
    }

    protected static String generatePesel(int sex) {

        /** Method generates pesel number.
         @param sex if negative or 0 returns pesel number for female. If positive returns pesel for male.
         */
        String pesel;
        int rok;
        int miesiac;
        int dzien;
        int seria1;
        int plec[] = new int[5];

        if (sex<=0)
        {   plec[0] =0;
            plec[1] =2;
            plec[2] =4;
            plec[3] =6;
            plec[4] =8;}
        else
        {
            plec[0] =1;
            plec[1] =3;
            plec[2] =5;
            plec[3] =7;
            plec[4] =9;
        }

        Random random = new Random();
        seria1 = 1 + random.nextInt(99);
        rok = 10  + random.nextInt(89);
        miesiac = 1+ random.nextInt(12);
        if (miesiac==2)
            dzien = 1+ random.nextInt(27);
        else
            dzien = 1+ random.nextInt(29);
        pesel= String.format("%02d%02d%02d%03d%d",rok,miesiac,dzien,seria1,plec[random.nextInt(plec.length)]);
        // generujemy sume kontrolną
        int j = 0;
        int[] mnozniki = {1,3,7,9};
        int suma =0;
        for (int i = 0; i <10 ; i++) {
            int cyfra = Integer.parseInt(pesel.substring(i,1+i));
            int mnoznik=mnozniki[j];
            j++;
            if (j>3)
                j=0;
            suma = suma + cyfra*mnoznik;
        }
        suma = suma%10;
        suma = 10-suma;
        suma = suma%10;
        pesel = pesel+suma;
        return pesel;
    }

    private String generateBirthDate(String pesel){
        String year = pesel.substring(0,2);
        String month = pesel.substring(2,4);
        String day = pesel.substring(4,6);
        int yearbegin= 19;
        return day+"-"+month+"-"+yearbegin+year;
    }
    private String generateIDNumber(){
        String idnumber = "";
        char[] tab = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
        Random random = new Random();
        int pos1 = random.nextInt(tab.length);
        int pos2 = random.nextInt(tab.length);
        int pos3 = random.nextInt(tab.length);
        int pos4 = 1+ random.nextInt(9);
        int pos5 = 1+ random.nextInt(9);
        int pos6 = 1+ random.nextInt(9);
        int pos7 = 1+ random.nextInt(9);
        int pos8 = 1+ random.nextInt(9);
        int wagi[] = {7,3,1,7,3,1,7,3};
        int control =0;
        control = ((10+pos1)*wagi[0])+((10+pos2)*wagi[1])+((10+pos3)*wagi[2])+((pos4)*wagi[3])+((pos5)*wagi[4])+((pos6)*wagi[5])+((pos7)*wagi[6])+((pos8)*wagi[7]);
        control =control%10;
        idnumber = String.format("%c%c%c%d%d%d%d%d%d",tab[pos1],tab[pos2],tab[pos3],control,pos4,pos5,pos6,pos7,pos8);
        return idnumber;
    }

    private String generatePostalCode(){

        Random random = new Random();
        int fpart = 1+ random.nextInt(99);
        int spart = 1+ random.nextInt(999);
        String code = String.format("%02d-%03d",fpart,spart);

        return code;
    }





    public String getPostalCode() {
        return postalCode;
    }

    public String getIdNumber() {
        return idNumber;
    }
    public String getPesel() {
        return pesel;
    }

    public String getBirthDate() {
        return birthDate;
    }

}