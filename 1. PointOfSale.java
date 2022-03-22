package POS;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class PointOfSale {

    public static void main(String[] args) throws IOException {
        //Deklarasi ArrayList Bertipe Object
        ArrayList<Barang> dataBarang = new ArrayList<>();
        //Deklarasi file
        String transaksi = "D:\\NetBeansProjects\\TugasAsd4\\src\\POS\\DataTransaksi.txt";
        Scanner sc = new Scanner(System.in);
        boolean running = true;
        int id = -1;//untuk id barang auto incremment

        while (running) {//kurung pembuka while utama
            //tampilan menu
            System.out.println("===========================================");
            System.out.println("           ==> M I R A I <==               ");
            System.out.println("===========================================");
            System.out.println("              (PILIHAN MENU)               ");
            System.out.println("-------------------------------------------");
            System.out.println("[T]  TAMBAH DATA BARANG");
            System.out.println("[R]  REMOVE DATA BARANG");
            System.out.println("[V]  VIEW DATA BARANG");
            System.out.println("[P]  PENJUALAN");
            System.out.println("[S]  SAVE");
            System.out.println("[E]  EXIT");
            System.out.println("-------------------------------------------");

            System.out.print("Menu yang Anda pilih adalah : ");
            String menu = sc.nextLine();
            System.out.println("-------------------------------------------");

            if (menu.equals("T")) {//kurung pembuka menu Tambah Data Barang
                boolean run = true;
                while (run) {
                    System.out.println("Anda memilih menu Tambah Data Barang");
                    System.out.println("====================================");
                    System.out.println("[TB]  TAMBAH BARANG");
                    System.out.println("[TSB] TAMBAH STOK BARANG");
                    System.out.println("[SL]  SELESAI");
                    System.out.println("====================================");
                    System.out.print("Sub menu yang Anda pilih adalah : ");
                    String subMenu = sc.nextLine();
                    System.out.println("------------------------------------");
                    if (subMenu.equals("TB")) {//kurung pembuka sub menu Tambah Barang
                        System.out.println("Anda memilih sub menu Tambah Barang");
                        System.out.println("-------------------------------------------");
                        id++;
                        System.out.print("Nama Barang : ");
                        String nama = sc.nextLine();

                        System.out.print("Jenis Barang : ");
                        String jenis = sc.nextLine();

                        System.out.print("Harga Barang : Rp.");
                        String strHarga = sc.nextLine();
                        double harga = Double.parseDouble(strHarga);

                        System.out.print("Stock Barang : ");
                        String strStock = sc.nextLine();
                        int stock = Integer.parseInt(strStock);

                        Barang barang = new Barang(id, nama, jenis, harga, stock);//membuat object
                        dataBarang.add(barang);//menambahkan barang ke dalam ArrayList dataBarang
                        System.out.println("-------------------------------------------");
                    }//kurung penutup sub menu Tambah Barang
                    else if (subMenu.equals("TSB")) {//kurung pembuka sub menu Tambah Stock Barang
                        int index = -1;
                        boolean ditemukan = false;
                        System.out.println("Anda memilih sub menu Tambah Stock Barang");
                        System.out.println("-----------------------------------------");
                        System.out.print("Tambah stock dengan id : ");
                        int idTambah = sc.nextInt();
                        for (int j = 0; j < dataBarang.size(); j++) {
                            if (dataBarang.get(j).id == idTambah) {
                                index = j;
                                ditemukan = true;
                            }
                        }
                        if (ditemukan == true) {//kurung pembuka id ditemukan
                            System.out.println("-----------------------------------------");
                            System.out.println("id yang Anda masukkan ditemukan");
                            System.out.print("Jumlah penambahan stock : ");
                            int tambahStock = sc.nextInt();
                            Barang updateStock = dataBarang.get(idTambah);
                            updateStock.stock = dataBarang.get(idTambah).stock + tambahStock;
                            System.out.println("Penambahan stock berhasil");
                        }//kurung penutup id ditemukan
                        else if (ditemukan == false) {//kurung pembuka id tidak ditemukan
                            System.out.println("-----------------------------------------");
                            System.out.println("id yang anda masukkan tidak ditemukan");
                            System.out.println("Penambahan stock gagal");
                        }//kurung penutup id tidak ditemukan
                    }//kurung penutup sub menu Tambah Stock Barang
                    else if (subMenu.equals("SL")) {//kurung pembuka sub menu Selesai
                        System.out.println("Selesai");
                        run = false;
                    }//kurung penutup sub menu Selesai
                    else {
                        System.out.println("Pilih sub menu dengan benar!!!");
                    }
                }
            }//kurung pembuka menu Tambah Data Barang
            else if (menu.equals("R")) {//kurung pembuka menu Remove Data Barang
                int index = -1;
                boolean ditemukan = false;
                System.out.println("Anda memilih menu Remove");
                System.out.println("------------------------------------");
                System.out.print("Remove data barang dengan : ");
                int hapus = sc.nextInt();
                System.out.println("------------------------------------");
                for (int j = 0; j < dataBarang.size(); j++) {
                    if (dataBarang.get(j).id == hapus) {
                        index = j;
                        ditemukan = true;
                    }
                }
                if (ditemukan == true) {//kurung pembuka id ditemukan
                    System.out.println("id yang anda masukkan ditemukan");
                    dataBarang.remove(hapus);
                    System.out.println("Remove data barang berhasil");
                }//kurung penutup id ditemukan
                else if (ditemukan == false) {//kurung pembuka id tidak ditemukan
                    System.out.println("-----------------------------------------");
                    System.out.println("id yang anda masukkan tidak ditemukan");
                    System.out.println("Remove data barang gagal");
                }//kurung penutup id tidak ditemukan
            }//kurung penutup menu Remove Data Barang
            else if (menu.equals("V")) {//kurung pembuka menu View
                System.out.println("=================================================================");
                System.out.println("                        Tampilan Data Barang                     ");
                System.out.println("=================================================================");
                System.out.println("id ; " + "nama ; " + "jenis ; " + "harga ; " + "stock ; " + "terjual ;\n");
                for (Barang b : dataBarang) {
                    System.out.println(b);
                }
            }//kurung penutup menu View
            else if (menu.equals("P")) {//kurung pembuka menu Penjualan
                boolean penjualan = true;
                int index = -1;
                while (penjualan) {
                    System.out.println("Anda memilih menu Penjualan");
                    System.out.println("===========================================");
                    System.out.println("[TP] TAMBAH PENJUALAN");
                    System.out.println("[SL] SELESAI");
                    System.out.println("===========================================");
                    System.out.print("Sub menu Penjualan yang Anda pilih : ");
                    String sub_menu = sc.nextLine();

                    if (sub_menu.equals("TP")) {//kurung pembuka Tambah Penjualan
                        boolean ditemukan = false;
                        System.out.println("Anda memilih sub menu Tambah Penjualan");
                        System.out.println("------------------------------------------------------------------------");
                        System.out.println("id ; " + "nama ; " + "jenis ; " + "harga ; " + "stock ; " + "terjual ;\n");
                        for (Barang b : dataBarang) {
                            System.out.println(b);
                        }
                        System.out.println("-------------------------------------------------------------------------");
                        System.out.print("Pilih id barang yang ingin dijual/dibeli : ");
                        int dijual = sc.nextInt();
                        for (int j = 0; j < dataBarang.size(); j++) {
                            if (dataBarang.get(j).id == dijual) {
                                index = j;
                                ditemukan = true;
                            }
                        }
                        if (ditemukan == true) {//kurung pembuka id ditemukan
                            System.out.println("-----------------------------------------");
                            System.out.println("id yang Anda masukkan ditemukan");
                            System.out.print("Jumlah barang yang akan dijual/dibeli : ");
                            int laku = sc.nextInt();
                            Barang update = dataBarang.get(dijual);
                            update.stock = dataBarang.get(dijual).stock - laku;
                            update.terjual = dataBarang.get(dijual).terjual + laku;

                            //penulisan data belanja/data transaksi
                            try {
                                FileWriter fileWriter = new FileWriter(transaksi, true);
                                fileWriter.write("                  ==> M I R A I <==                  ");
                                fileWriter.write("\n===================================================");
                                fileWriter.write("\nData Belanja");
                                fileWriter.write("\n-----------------------------------------------------");
                                fileWriter.write("\nid Barang       : " + dijual);
                                fileWriter.write("\nNama Barang     : " + dataBarang.get(index).nama);
                                fileWriter.write("\nJumlah Barang   : " + laku);
                                fileWriter.write("\nHarga Barang    : Rp. " + dataBarang.get(index).harga);
                                fileWriter.write("\n---------------------------------------------------");
                                fileWriter.write("\nTotal Bayar     : Rp. " + dataBarang.get(index).harga * laku);
                                fileWriter.write("\n===================================================");
                                fileWriter.close();
                            } catch (IOException e) {
                                System.err.println("Terjadi kesalahan karena : " + e.getMessage());
                            }
                            try {
                                File myFile = new File(transaksi);
                                Scanner fr = new Scanner(myFile);

                                while (fr.hasNextLine()) {
                                    String data = fr.nextLine();
                                    System.out.println(data);
                                }
                            } catch (IOException e) {
                                System.err.println("Terjadi kesalahan karena : " + e.getMessage());
                            }
                        }//kurung penutup id ditemukan
                        else if (ditemukan == false) {//kurung pembuka id tidak ditemukan
                            System.out.println("-----------------------------------------");
                            System.out.println("id yang anda masukkan tidak ditemukan");
                        }//kurung penutup id tidak ditemukan
                    }//kurung penutup Tambah Penjualan
                    else if (sub_menu.equals("SL")) {//kurung pembuka sub menu Selesai
                        System.out.println("Selesai");
                        penjualan = false;
                    }//kurung penutup sub menu Selesai
                    else {
                        System.out.println("Pilih sub menu dengan benar!!!");
                    }
                }
            }//kurung penutup menu Penjualan
            else if (menu.equals("S")) {//kurung pembuka menu Save
                System.out.println("Anda memilih menu Save");
                saveDataBarangToFile(dataBarang, "DataBarang.txt");
                System.out.println("Data berhasil disimpan");
            }//kurung pembuka menu Save
            
            else if (menu.equals("E")){//kurung pembuka menu Exit
                System.out.println("Anda memilih menu Exit");
                System.out.println("Proses pemilihan menu di akhiri");
                saveDataBarangToFile(dataBarang, "DataBarang.txt");
                running = false;
            }//kurung penutup menu Exit
            else {//kurung pembuka validasi pilihan menu
                System.out.println("Maaf, menu yang anda pilih tidak sesuai");
                System.out.println("Silahkan pilih menu dengan benar!!!");
            }//kurung pembuka validasi pilihan menu
        }//kurung penutup while utama
        sc.close();
    }

    public static boolean saveDataBarangToFile(ArrayList<Barang> dataBarang, String url) {//menyimpan data ke file
        boolean result = false;
        try {
            if (dataBarang != null && !dataBarang.isEmpty() && url != null) {
                FileWriter fw = new FileWriter(url);
                BufferedWriter bw = new BufferedWriter(fw);
                for (Barang b : dataBarang) {
                    bw.append(b.toString());
                    bw.append("\n");
                }
                bw.close();
                fw.close();
                result = true;
            }
        } catch (IOException e) {
            System.err.println("Prose penyimpanan data ke file gagal");
            e.printStackTrace();
        }
         return result ;
    }
    
    public static ArrayList<Barang> readDataBarangFromFile (String url){
        ArrayList<Barang> data = null;
        try{
            FileReader fr = new FileReader(url);
            BufferedReader br = new BufferedReader(fr);
            data = new ArrayList<>();
            String baris;
            while ((baris = br.readLine()) != null) {
                String [] elements = baris.split(" ; ");
                String strid = elements [0];
                int id = Integer.parseInt(strid);
                
                String nama = elements[1];
                
                String jenis = elements[2];
                
                String strHarga = elements [3];
                double harga = Double.parseDouble(strHarga);
                
                String strStock = elements[4];
                int stock = Integer.parseInt(strStock);
                
                String strTerjual = elements[5];
                int terjual = Integer.parseInt(strTerjual);
            }
            fr.close();
            br.close();
        }catch (IOException e) {
            System.err.println("Prose pembacaan data dari file gagal");
            e.printStackTrace();
        }
        return data;
    }
}
