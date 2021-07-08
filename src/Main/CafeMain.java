package Main;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class CafeMain {

    static String Z;
    static Makanan makanan = new Makanan();
    static Minuman minuman = new Minuman();
    static Bean bean = new Bean();
    static Scanner scn = new Scanner(System.in);
    static int harga, stok, pilihan, count = 0, quantity, trsCount = 1, ind, inds, counts;

    static int a = 0;
    static float kembali;
    static String nama, question, User = "Aal";
    static boolean UPmain=true, UPpilihan1=true, UPpilihan2=true, UPpilihan3=true, UPpilihan4=true, UPbean=true;

    static int[] hrg = new int[100];
    static int[] hrg2 = new int[100];
    static int[] qty = new int[100];
    static int[] qty2 = new int[100];
    static String[] nm = new String[100];
    static String[] nm2 = new String[100];

    public static void main(String[] args) {
        do {
            System.out.println("");
            System.out.println("");
            System.out.println("+============================+");
            System.out.println("|  P O V E R O  C O F F E E  |");
            System.out.println("+============================+");
            System.out.println("");
            System.out.println("Pilihan : ");
            System.out.println("");
            System.out.println("1. Transaksi");
            System.out.println("2. Makanan");
            System.out.println("3. Minuman");
            System.out.println("4. Bean");
            System.out.println("5. Keluar");
            System.out.println("");
            System.out.print("Masukkan pilihan : ");
            pilihan = scn.nextInt();
            switch (pilihan) {
                case 1:
                    pilihan1();
                    break;
                case 2:
                    pilihan2();
                    break;
                case 3:
                    pilihan3();
                    break;
                case 4:
                    pilihan4();
                    break;
                case 5:
                    UPmain = false;
                    break;
            }
        } while (UPmain);
    }

    static int subTotal() {
        int total = 0;
        for (int i = 0; i < count; i++) {
            total += ((hrg[i] * qty[i]) + (hrg2[i] * qty2[i]));
        }
        return total;
    }

    static float total() {
        return (subTotal() + pajak());
    }

    static float pajak() {
        return (subTotal() * 10f / 100);
    }

    static void pilihan1() {
        do {
            System.out.println("");
            System.out.println("1. Menu Makanan");
            System.out.println("2. Menu Minuman");
            System.out.println("3. Simpan");
            System.out.println("4. Kembali");
            System.out.println("");
            System.out.print("Masukkan pilihan : ");
            pilihan = scn.nextInt();
            switch (pilihan) {
                case 1:
                    System.out.println("");
                    System.out.println("=> MAKANAN =========");
                    System.out.println("");
                    makanan.tampilData();
                    System.out.println("");
                    do {
                        System.out.print("Masukkan ID makanan    : ");
                        String z = scn.next().substring(2);
                        pilihan = Integer.parseInt(z);
                        quantity = validInt("Masukkan banyak pesanan   : ");
                        if (quantity > makanan.stok[pilihan - 1] || quantity < 1) {
                            System.out.println("stok kurang");
                        } else {
                            if (merge(makanan.NAMA(pilihan))) {
                                qty[ind] += quantity;
                            } else {
                                qty[count] = quantity;
                                makanan.kurangiStok(pilihan, quantity);
                                nm[count] = makanan.NAMA(pilihan);
                                hrg[count] = makanan.HARGA(pilihan);
                                count++;
                            }
                        }
                        System.out.println("");
                        System.out.print("Apakah anda ingin menambah makanan? (Y/N) ");
                        question = scn.next().toUpperCase();
                        System.out.println("");
                    } while (question.equals("Y"));
                    break;
                case 2:
                    System.out.println("");
                    System.out.println("=> MINUMAN =========");
                    System.out.println("");
                    minuman.tampilData();
                    System.out.println("");
                    do {
                        System.out.print("Masukkan ID minuman    : ");
                        String z = scn.next().substring(2);
                        pilihan = Integer.parseInt(z);
                        quantity = validInt("Masukkan banyak pesanan   : ");
                        if (quantity > minuman.stok[pilihan - 1] || quantity < 1) {
                            System.out.println("stok kurang");
                        } else {
                            if (merge(minuman.NAMA(pilihan))) {
                                qty[ind] += quantity;
                            } else {
                                qty[count] = quantity;
                                minuman.kurangiStok(pilihan, quantity);
                                nm[count] = minuman.NAMA(pilihan);
                                hrg[count] = minuman.HARGA(pilihan);
                                count++;

                            }
                        }

                        if (pilihan <= 16) { 
                            bean();
                        }
                        System.out.println("");
                        System.out.print("Apakah anda ingin menambah minuman? (Y/N) ");
                        question = scn.next().toUpperCase();
                        System.out.println("");

                    } while (question.equals("Y"));
                    break;
                case 3:
                    System.out.println("");
                    System.out.println("Total                    : " + total());
                    do {
                        System.out.print("Bayar                    : ");
                        pilihan = scn.nextInt();
                    } while (pilihan < total());
                    kembali = pilihan - total();
                    System.out.print("Masukkan nama customer   : ");
                    question = scn.next();

                    System.out.println("\n\n\n");
                    System.out.println("    Povero Coffee Shop Malang    ");
                    System.out.println("\n");
                    System.out.print(tanggalSekarang() + " " + waktuSekarang());
                    System.out.printf("%21s", User);
                    System.out.print("\n");
                    System.out.print("No. Order : ");
                    System.out.printf("%03d", trsCount);
                    System.out.printf("%20s", "MLG");
                    System.out.println("\n-----------------------------------");
                    System.out.printf("%-6s", "" + question);
                    System.out.println("\n-----------------------------------");
                    System.out.printf("%-20s", "Barang");
                    System.out.printf("%-6s", "Jumlah");
                    System.out.printf("%9s", "Total");
                    System.out.println("");
                    System.out.println("-----------------------------------");
                    for (int i = 0; i < count; i++) {
                        System.out.printf("%-20s", nm[i]);
                        System.out.printf("%-6s", "  " + qty[i]);
                        System.out.printf("%9d", (qty[i] * hrg[i]));
                        System.out.println("");
                    }
                    for (int i = 0; i < counts; i++) {
                        System.out.printf("%-20s", nm2[i]);
                        System.out.printf("%-6s", "  " + qty2[i]);
                        System.out.printf("%9d", (qty2[i] * hrg2[i]));
                        System.out.println("");
                    }
                    System.out.println("\n-----------------------------------");
                    System.out.print("Subtotal      ");
                    System.out.printf("%21d", Math.round(subTotal()));
                    System.out.print("\nDiscount      ");
                    System.out.printf("%21s", "(0)");
                    System.out.print("\nServ.Charge   ");
                    System.out.printf("%21s", "0");
                    System.out.print("\nPajak         ");
                    System.out.printf("%21d", Math.round(pajak()));
                    System.out.println("\n-----------------------------------");
                    System.out.print("TOTAL         ");
                    System.out.printf("%21s", "Rp. " + Math.round(total()));
                    System.out.println("\n-----------------------------------");
                    System.out.print("Tunai         ");
                    System.out.printf("%21d", pilihan);
                    System.out.println("\n-----------------------------------");
                    System.out.print("Kembalian     ");
                    System.out.printf("%21d", Math.round(kembali));
                    System.out.println("\n-----------------------------------");
                    System.out.println("\n");
                    System.out.println(" Terima kasih atas kunjungan Anda.");
                    System.out.println("         ENJOY THE COFFEE.        ");
                    System.out.println("\n\n\n\n");
                    count = 0;
                    main(null);
                    break;
                default:
                    main(null);
                    break;
            }
        } while (UPpilihan1);
    }

    static boolean merge(String nm) {
        boolean found = false;
        for (int i = 0; i < count; i++) {
            if (nm.equals(CafeMain.nm2[i])) {
                found = true;
                ind = i;
            }
        }
        return found;
    }

    static boolean merges(String nms) {
        boolean founds = false;
        for (int i = 0; i < counts; i++) {
            if (nms.equals(CafeMain.nm2[i])) {
                founds = true;
                inds = i;
            }
        }
        return founds;
    }

    static void bean() {
        do {
            int r = qty[count - 1];
            System.out.println("");
            System.out.println("=> BEAN =========");
            System.out.println("");
            bean.tampilData();
            System.out.println("");
            do {
                System.out.print("\nMasukkan ID bean    : ");
                String z = scn.next().substring(2);
                pilihan = Integer.parseInt(z);
                quantity = validInt("Masukkan banyak pesanan   : ");
                if (quantity > bean.stok[pilihan - 1] || quantity < 1) {
                    System.out.println("stok kurang");
                } else {

                    if ((quantity + a) > r) {
                        System.out.println("Terlalu banyak pesanan! maksimal : " + (r) + ",\n Sementara bean terpilih (" + a + ")");
                        question = "Y";
                    } else {
                        if (a < r) {
                            a += quantity;
                            question = "Y";

                            if (merges(minuman.NAMA(pilihan))) {
                                qty2[inds] += quantity;
                            } else {
                                qty2[counts] = quantity;
                                bean.kurangiStok(pilihan, quantity);
                                nm2[counts] = bean.NAMA(pilihan);
                                hrg2[counts] = bean.HARGA(pilihan);
                                counts++;

                            }
                        }

                        if (a == r) {
                            question = "N";
                            UPbean=false;
                        }
                    }

                }

            } while (question.equals("Y"));
            a = 0;
            UPpilihan1=true;
            
        } while (UPbean);

    }

    static void pilihan2() {
        do {
            System.out.println("");
            makanan.tampilData();
            System.out.println("");
            System.out.println("1. Tambah Makanan");
            System.out.println("2. Ubah Makanan");
            System.out.println("3. Hapus Makanan");
            System.out.println("4. Kembali");
            System.out.println("");
            System.out.print("Masukkan pilihan : ");
            pilihan = scn.nextInt();
            switch (pilihan) {
                case 1:
                    do {
                        System.out.println("");
                        System.out.print("Masukkan Nama     : ");
                        nama = scn.next();
                        do {
                            System.out.print("Masukkan Harga    : ");
                            harga = scn.nextInt();
                        } while (harga < 1 || harga > 100000);
                        do {
                            stok = validInt("Masukkan Stock   : ");
                        } while (stok < 1 || stok > 100);
                        makanan.tambahData(nama, harga, stok);
                        System.out.println("");
                        do {
                            System.out.print("Apakah anda ingin menambah lagi? (Y/N) ");
                            question = scn.next().toUpperCase();
                            if (question.equals("N")) {
                                UPpilihan2 = false;
                                break;
                            }
                        } while (!question.equals("Y"));
                    } while (question.equals("Y"));
                    pilihan2();
                    break;
                case 2:
                    System.out.println("");
                    System.out.print("Masukkan ID makanan yang akan diubah : ");
                    String z = scn.next().substring(2);
                    pilihan = Integer.parseInt(z);
                    System.out.println("");
                    System.out.print("Masukkan Nama     : ");
                    nama = scn.next();
                    do {
                        System.out.print("Masukkan Harga    : ");
                        harga = scn.nextInt();
                    } while (harga < 1 || harga > 100000);
                    do {
                        stok = validInt("Masukkan Stock   : ");
                    } while (stok < 1 || stok > 100);
                    makanan.ubahData(nama, harga, stok, pilihan - 1);
                    UPpilihan2=true;
                    break;
                case 3:
                    System.out.println("");
                    System.out.print("Masukkan ID makanan yang akan dihapus : ");
                    z = scn.next().substring(2);
                    pilihan = Integer.parseInt(z);
                    System.out.println("");
                    makanan.hapusData(pilihan - 1);
                    UPpilihan2=true;
                    break;
                default:
                    main(null);
                    break;
            }
        } while (UPpilihan2);
    }

    static void pilihan3() {
        do {
            System.out.println("");
            minuman.tampilData();
            System.out.println("");
            System.out.println("1. Tambah Minuman");
            System.out.println("2. Ubah Minuman");
            System.out.println("3. Hapus Minuman");
            System.out.println("4. Kembali");
            System.out.println("");
            System.out.print("Masukkan pilihan : ");
            pilihan = scn.nextInt();
            switch (pilihan) {
                case 1:
                    do {
                        System.out.println("");
                        System.out.print("Masukkan Nama     : ");
                        nama = scn.next();
                        do {
                            System.out.print("Masukkan Harga    : ");
                            harga = scn.nextInt();
                        } while (harga < 1 || harga > 100000);
                        do {
                            stok = validInt("Masukkan Stock   : ");
                        } while (stok < 1 || stok > 100);
                        minuman.tambahData(nama, harga, stok);
                        System.out.println("");
                        do {
                            System.out.print("Apakah anda ingin menambah lagi? (Y/N) ");
                            question = scn.next().toUpperCase();
                            if (question.equals("N")) {
                                pilihan3();
                                break;
                            }
                        } while (!question.equals("Y"));
                    } while (question.equals("Y"));
                    pilihan3();
                    break;
                case 2:
                    System.out.println("");
                    System.out.print("Masukkan ID minuman yang akan diubah : ");
                    String z = scn.next().substring(2);
                    pilihan = Integer.parseInt(z);
                    System.out.println("");
                    System.out.print("Masukkan Nama     : ");
                    nama = scn.next();
                    do {
                        System.out.print("Masukkan Harga    : ");
                        harga = scn.nextInt();
                    } while (harga < 1 || harga > 100000);
                    do {
                        stok = validInt("Masukkan Stock   : ");
                    } while (stok < 1 || stok > 100);
                    minuman.ubahData(nama, harga, stok, pilihan - 1);
                    UPpilihan3=true;
                    break;
                case 3:
                    System.out.println("");
                    System.out.print("Masukkan ID minuman yang akan dihapus : ");
                    z = scn.next().substring(2);
                    pilihan = Integer.parseInt(z);
                    System.out.println("");
                    minuman.hapusData(pilihan - 1);
                    UPpilihan3=true;
                    break;
                default:
                    main(null);
                    break;
            }
        } while (UPpilihan3);
    }

    static void pilihan4() {
        do {
            System.out.println("");
            bean.tampilData();
            System.out.println("");
            System.out.println("1. Tambah Bean");
            System.out.println("2. Ubah Bean");
            System.out.println("3. Hapus Bean");
            System.out.println("4. Kembali");
            System.out.println("");
            System.out.print("Masukkan pilihan : ");
            pilihan = scn.nextInt();
            switch (pilihan) {
                case 1:
//                    do {
                        System.out.println("");
                        System.out.print("Masukkan Nama     : ");
                        nama = scn.next();
                        do {
                            System.out.print("Masukkan Harga    : ");
                            harga = scn.nextInt();
                        } while (harga < 1 || harga > 100000);
                        do {
                            stok = validInt("Masukkan Stock   : ");
                        } while (stok < 1 || stok > 100);
                        bean.tambahData(nama, harga, stok);
                        System.out.println("");
                        UPpilihan4=true;
                    break;
                case 2:
                    System.out.println("");
                    System.out.print("Masukkan ID Bean yang akan diubah : ");
                    String z = scn.next().substring(2);
                    pilihan = Integer.parseInt(z);
                    System.out.println("");
                    System.out.print("Masukkan Nama     : ");
                    nama = scn.next();
                    do {
                        System.out.print("Masukkan Harga    : ");
                        harga = scn.nextInt();
                    } while (harga < 1 || harga > 100000);
                    do {
                        stok = validInt("Masukkan Stock   : ");
                    } while (stok < 1 || stok > 100);
                    bean.ubahData(nama, harga, stok, pilihan - 1);
                    UPpilihan4=true;
                    break;
                case 3:
                    System.out.println("");
                    System.out.print("Masukkan ID Bean yang akan dihapus : ");
                    z = scn.next().substring(2);
                    pilihan = Integer.parseInt(z);
                    System.out.println("");
                   
                    bean.hapusData(pilihan - 1);
                    UPpilihan4=true;
                    break;
                default:
                    main(null);
                    break;
            }
        } while (UPpilihan4);
    }

    static int validInt(String prefix) {
        System.out.print(prefix);
        while (!scn.hasNextInt()) {
            System.out.print(prefix);
            scn.next();
        }
        return scn.nextInt();
    }

    static String tanggalSekarang() {
        return new SimpleDateFormat("dd/MM/yy").format(new Date());
    }

    static String waktuSekarang() {
        return new SimpleDateFormat("HH:mm").format(new Date());
    }
}
