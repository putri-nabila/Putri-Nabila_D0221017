package POS;

public class Barang {
int id;
String nama;
String jenis;
double harga;
int stock;
int terjual;
    
    public Barang(int id, String nama, String jenis, double harga, int stock) {
        this.id = id;
        this.nama = nama;
        this.jenis = jenis;
        this.harga = harga;
        this.stock = stock;
    }

    public Barang(int id, String nama, String jenis, double harga, int stock, int terjual) {
        this.id = id;
        this.nama = nama;
        this.jenis = jenis;
        this.harga = harga;
        this.stock = stock;
        this.terjual = terjual;
    }

    public String toString(){
        String tampil = ""+id+" ; "+nama+" ; "+jenis+" ; "+harga+" ; "+stock+" ; "+terjual+"";
        return tampil;
    }
}
