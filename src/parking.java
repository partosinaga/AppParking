import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class parking {
    @SuppressWarnings("Duplicates") //menghilangkan duplicate warning intelliJ
    public static void main(String[] args) {

        int jkend, cont;
        long cost;
        long car_rate = 4000;
        long bus_rate = 6000;
        long mtrcy_rate = 2000;
        String timeIn, timeOut;
        boolean quit = false;
        Date ti = null;
        Date to = null;
        Scanner input = new Scanner(System.in);
        SimpleDateFormat format = new SimpleDateFormat("HH.mm");

        do {
            System.out.println("==========MENU==========");
            System.out.println("----JENIS  KENDARAAN----");
            System.out.println("(1) Mobil - "+car_rate+"/jam");
            System.out.println("(2) Bus/Truck - "+bus_rate+"/jam");
            System.out.println("(3) Motor - "+mtrcy_rate+"/jam");
            System.out.println("------------------------");
            System.out.println("(4) Exit");
            System.out.println("========================");

            System.out.print("Pilihan :");
            jkend = input.nextInt();
            if (jkend == 1 || jkend == 2 || jkend == 3) { //validasi tidak di run kalau pilihan menu == 4/quit
                System.out.print("Jam masuk (format [HH.mm]) : ");
                timeIn = input.next();
                System.out.print("Jam keluar (format [HH.mm]) : ");
                timeOut = input.next();
            } else {
                timeIn = null;
                timeOut = null;
            }
            switch (jkend) {
                case 1:
                    try {//pengecekan format jam dan parse format jam
                        ti = format.parse(timeIn);
                        to = format.parse(timeOut);
                        if (ti.getTime() > to.getTime()) { //validasi jam masuk lebih besar dari jam keluar
                            System.out.println("GAGAL: Jam masuk tidak boleh lebih besar dan Jam keluar!");
                            System.out.println("======TERIMA KASIH======");
                            System.out.println("");
                        } else {
                            //dalam milliseconds
                            long diff = to.getTime() - ti.getTime();
                            long diffMinutes = diff / (60 * 1000) % 60;
                            long diffHours = diff / (60 * 60 * 1000) % 24;

                            System.out.println("Durasi: " + diffHours + " jam, " + diffMinutes + " menit, ");
                            if (diffMinutes >= 30) { //penggenapan ke atas kalau lebih dari 30 menit
                                cost = (diffHours + 1) * car_rate;
                            } else {
                                cost = diffHours * car_rate;
                            }
                            System.out.println("Tarif: IDR " + cost);
                            System.out.println("======TERIMA KASIH======");
                            System.out.println("");
                        }
                    } catch (Exception e) {
                        System.out.println("GAGAL: Pastikan format waktu benar, format 24 jam. mis = 12.30");
                        System.out.println("======TERIMA KASIH======");
                        System.out.println("");
                    }
                    break;
                case 2:
                    try {//pengecekan format jam dan parse format jam
                        ti = format.parse(timeIn);
                        to = format.parse(timeOut);
                        if (ti.getTime() > to.getTime()) { //validasi jam masuk lebih besar dari jam keluar
                            System.out.println("GAGAL: Jam masuk tidak boleh lebih besar dan Jam keluar!");
                            System.out.println("======TERIMA KASIH======");
                            System.out.println("");
                        } else {
                            //dalam milliseconds
                            long diff = to.getTime() - ti.getTime();
                            long diffMinutes = diff / (60 * 1000) % 60;
                            long diffHours = diff / (60 * 60 * 1000) % 24;

                            System.out.println("Durasi: " + diffHours + " jam, " + diffMinutes + " menit, ");
                            if (diffMinutes >= 30) { //penggenapan ke atas kalau lebih dari 30 menit
                                cost = (diffHours + 1) * bus_rate;
                            } else {
                                cost = diffHours * bus_rate;
                            }
                            System.out.println("Tarif: IDR " + cost);
                            System.out.println("======TERIMA KASIH======");
                            System.out.println("");
                        }
                    } catch (Exception e) {
                        System.out.println("GAGAL: Pastikan format waktu benar, format 24 jam. mis = 12.30");
                        System.out.println("======TERIMA KASIH======");
                        System.out.println("");
                    }
                    break;
                case 3:
                    try {//pengecekan format jam dan parse format jam
                        ti = format.parse(timeIn);
                        to = format.parse(timeOut);
                        if (ti.getTime() > to.getTime()) { //validasi jam masuk lebih besar dari jam keluar
                            System.out.println("GAGAL: Jam masuk tidak boleh lebih besar dan Jam keluar!");
                            System.out.println("======TERIMA KASIH======");
                            System.out.println("");
                        } else {
                            //dalam milliseconds
                            long diff = to.getTime() - ti.getTime();
                            long diffMinutes = diff / (60 * 1000) % 60;
                            long diffHours = diff / (60 * 60 * 1000) % 24;

                            System.out.println("Durasi: " + diffHours + " jam, " + diffMinutes + " menit, ");
                            if (diffMinutes >= 30) { //penggenapan ke atas kalau lebih dari 30 menit
                                cost = (diffHours + 1) * mtrcy_rate;
                            } else {
                                cost = diffHours * mtrcy_rate;
                            }
                            System.out.println("Tarif: IDR " + cost);
                            System.out.println("======TERIMA KASIH======");
                            System.out.println("");
                        }
                    } catch (Exception e) {
                        System.out.println("GAGAL: Pastikan format waktu benar, format 24 jam. mis = 12.30");
                        System.out.println("======TERIMA KASIH======");
                        System.out.println("");
                    }
                    break;
                case 4:
                    quit = true;
                    break;
                default:
                    System.out.println("Menu tidak ditemukan!");
                    System.out.println("======TERIMA KASIH======");
                    System.out.println("");
            }

            System.out.println("Lanjut?");
            System.out.println("(1) YES");
            System.out.println("(2) NO");
            cont = input.nextInt();
            if (cont != 1) {
                System.exit(0);
            }
            System.out.println("");

        }
        while (!quit);
    }

}