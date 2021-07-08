
package Main;

import java.util.Scanner;

public class NewMain {
    
    boolean a = true;
    int i = 0;
    
    Scanner scn = new Scanner(System.in);
    
    void rekursive() {
        System.out.print("Masukkan Angka : "); int b = scn.nextInt();
        if(b < 10) {
            rekursive();
        }
    }
    
    void mains() {
        do{
            System.out.println("=>");
            System.out.println("Balik");
            System.out.println("=>");
            System.out.print("Masukkan Pilihan : "); int c = scn.nextInt();
            switch(c) {
                case 1 :
                    rekursive();
                    break;
                case 2 :
                    a = false;
                    break;
            }
        }while(a);
    }

    public static void main(String[] args) {
        new NewMain().mains();
    }
    
}
