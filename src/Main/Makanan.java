package Main;

import java.util.Arrays;

public class Makanan {
    
    int[] idTmp, hrgTmp, stokTmp;
    String[] namaTmp;
    
    int[] id  = {
       19001,
       19002,
       19003,
       19004,
       19005,
       19006,
       19007,
       19008
    };
    
    String[] nama = {
        "Cassava",
        "French Fries BBQ",
        "French Fries Cheese",
        "Risoles",
        "Lumpia",
        "Waffle",
        "Pancake",
        "Churros"
    };
    
    int[] harga = {
        20000,
        23000,
        23000,
        18000,
        18000,
        30000,
        30000,
        25000
    };
    
    int[] stok = {
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
        System.out.println("| No  | ID Makanan  | Nama Makanan          | Harga     | Stok  |");
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
 