package Main;

import java.util.Arrays;

public class Minuman {
    
    int[] idTmp, hrgTmp, stokTmp;
    String[] namaTmp;
    
    int[] id  = {
       20001,
       20002,
       20003,
       20004,
       20005,
       20006,
       20007,
       20008,
       20009,
       20010,
       20011,
       20012,
       20013,
       20014,
       20015,
       20016,
       20017,
       20018,
       20019,
       20020,
       20021
    };
    
    String[] nama = {
        "Indonesian Tubruk",
        "V60",
        "Aeropress",
        "Syphon",
        "Vietnam Drip",
        "Long Black",
        "Espresso",
        "Capuccino",
        "Coffee Latte",
        "Iced Caramel",
        "Ice Cream",
        "Piccolo",
        "Flat White",
        "Macchiato",
        "Mochaccino",
        "Classic Affogato",
        "Lemon Tea",
        "Lychee Tea",
        "Chocolate",
        "Green Tea Latte",
        "Red Velvet Latte"
    };
    
    int[] harga = {
        20000,
        26000,
        26000,
        35000,
        23000,
        22000,
        20000,
        32000,
        32000,
        34000,
        9000,
        27000,
        32000,
        25000,
        36000,
        30000,
        23000,
        25000,
        35000,
        35000,
        35000
    };
    
    int[] stok = {
        100,
        100,
        100,
        100,
        100,
        100,
        100,
        100,
        100,
        100,
        100,
        100,
        100,
        100,
        100,
        100,
        100,
        100,
        100,
        100,
        100
    };
    
    public int ID(int i) {
        return id[i - 1];
    }
    
    public String NAMA(int i) {
        return nama[i - 1];
    }
    
    public int HARGA(int i) {
        return harga[i - 1];
    }
    
    public int length() {
        return id.length;
    }
    
    public void tambahData(String nama, int harga, int stok) {
        int i = length();
        
        idTmp = Arrays.copyOf(this.id, length());
        namaTmp = Arrays.copyOf(this.nama, length());
        hrgTmp = Arrays.copyOf(this.harga, length());
        stokTmp = Arrays.copyOf(this.stok, length());
        
        this.id = Arrays.copyOf(idTmp, length() + 1);
        this.nama = Arrays.copyOf(namaTmp, length() + 1);
        this.harga = Arrays.copyOf(hrgTmp, length() + 1);
        this.stok = Arrays.copyOf(stokTmp, length() + 1);
        
        this.id[i] = (this.id[i - 1] + 1);
        this.nama[i] = nama;
        this.harga[i] = harga;
        this.stok[i] = stok;
    }
    
    public void ubahData(String nama, int harga, int stok, int i) {
        this.nama[i] = nama;
        this.harga[i] = harga;
        this.stok[i] = stok;
    }
    
    public void hapusData(int i) {        
        int k = 0;
        
        idTmp = Arrays.copyOf(this.id, length());
        namaTmp = Arrays.copyOf(this.nama, length());
        hrgTmp = Arrays.copyOf(this.harga, length());
        stokTmp = Arrays.copyOf(this.stok, length());
        
        this.nama = new String[length() - 1];
        this.harga = new int[length() - 1];
        this.stok = new int[length() - 1];
        this.id = new int[length() - 1];
        
        for(int j = 0; j < idTmp.length; j++) {
            if(i != j) {
                this.id[k] = idTmp[j];
                this.nama[k] = namaTmp[j];
                this.harga[k] = hrgTmp[j];
                this.stok[k] = stokTmp[j];
                k++;
            }
        }
    }
    
    public void tampilData() {
        System.out.println("+-----+-------------+-----------------------+-----------+-------+");
        System.out.println("| No  | ID Minuman  | Nama Minuman          | Harga     | Stok  |");
        System.out.println("+-----+-------------+-----------------------+-----------+-------+");
        for(int i = 0; i < length(); i++) {
            System.out.printf("%-5s","| " + (i + 1) );
            System.out.print(" |" + id[i]    + "\t    ");
            System.out.printf("%-24s", "| " + nama[i]);
            System.out.print("| " + harga[i] + "\t| " + stok[i] + "\t|" );
            System.out.println("");
        }
        System.out.println("+-----+-------------+-----------------------+-----------+-------+");
    }
    
    public void kurangiStok(int i, int value) {
        stok[i - 1] = (stok[i - 1] - value);
    }
}
