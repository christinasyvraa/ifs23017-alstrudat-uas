package del.ifs23017;

import org.junit.jupiter.api.Test;

import java.io.*;

import static org.junit.jupiter.api.Assertions.*;

class AppTest {

  @Test
  void testOutputSesuaiContohUAS() {
    // Simulasi input dari soal
    String input = String.join("\n",
        "Aek Bolon Jae, Aek Bolon Julu, Bonan Dolok, Lumban Bagasan",
        "Aek Bolon Jae=>Aek Bolon Julu:4.2,Bonan Dolok:3.6",
        "Bonan Dolok=> Lumban Bagasan:5.1",
        "Lumban Bagasan=>Aek Bolon Julu:3.3",
        "FINISH",
        "Lumban Bagasan=>Aek Bolon Jae",
        "1|Menggunakan Sepeda Motor|40"
    );

    // Backup input/output stream asli
    InputStream originalIn = System.in;
    PrintStream originalOut = System.out;

    try {
      // Siapkan input dan tangkap output
      ByteArrayInputStream testIn = new ByteArrayInputStream(input.getBytes());
      ByteArrayOutputStream testOut = new ByteArrayOutputStream();

      System.setIn(testIn);
      System.setOut(new PrintStream(testOut));

      // Jalankan aplikasi
      App.main(new String[0]);

      String output = testOut.toString();

      // Validasi output utama
      assertTrue(output.contains("Peta Jalur Wilayah:"));
      assertTrue(output.contains("Aek Bolon Jae -> Aek Bolon Julu (4.2km), Bonan Dolok (3.6km)"));
      assertTrue(output.contains("Daftar Jarak terdekat dari Lumban Bagasan ke Aek Bolon Jae"));
      assertTrue(output.contains("Jalur 1 (7.5km): Aek Bolon Julu (3.3km) -> Aek Bolon Jae (4.2km)"));
      assertTrue(output.contains("Menggunakan Sepeda Motor dari Jalur 1 sejauh 7.5km"));
      assertTrue(output.contains("Waktu yang perlu ditempuh untuk mencapai tujuan: 11.25 menit"));
      assertTrue(output.contains("-> Tiba di Aek Bolon Julu sejauh 3.3km selama 4.95 menit"));
      assertTrue(output.contains("-> Tiba di Aek Bolon Jae sejauh 4.2km selama 6.30 menit"));

    } finally {
      // Kembalikan stream asli
      System.setIn(originalIn);
      System.setOut(originalOut);
    }
  }
}
