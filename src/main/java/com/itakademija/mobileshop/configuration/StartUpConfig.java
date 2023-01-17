package com.itakademija.mobileshop.configuration;

import com.itakademija.mobileshop.model.Product;
import com.itakademija.mobileshop.model.ProductType;
import com.itakademija.mobileshop.repository.ProductRepository;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.PageRequest;

import java.math.BigDecimal;
import java.util.Currency;
import java.util.Locale;

@Configuration
public class StartUpConfig {

    public StartUpConfig(ProductRepository productRepository) {
        var products = productRepository.findAll(PageRequest.of(0, 12));
        if (products.stream().count() == 0) {

            var product = new Product();
            product.setCurrency(Currency.getInstance(Locale.US));
            product.setProductType(ProductType.MOBILE);
            product.setDescription("Predstavljen: Mart, 2022\n" +
                    "Ekran: 4.7”, Retina IPS LCD, 750 x 1334 px\n" +
                    "Chipset: Apple A15 Bionic\n" +
                    "Procesor: Hexa-core (2x 3.2 GHz Avalanche i 4 x1.8 GHz Blizzard jezgre)\n" +
                    "Grafika: Apple GPU (4-jezgre)\n" +
                    "RAM memorija: 4 GB\n" +
                    "Interna memorija: 128 GB\n" +
                    "microSD slot: NEMA\n" +
                    "Stražnje kamere:\n" +
                    "12 MP, f/1.8, PDAF, OIS\n" +
                    "Video 4K@60fps\n" +
                    "Prednja kamera:\n" +
                    "7 MP, f/2.2\n" +
                    "Video 1080p@120fps\n" +
                    "Kapacitet baterije: 2018 mAh\n" +
                    "Dodatno: senzor otiska prsta (smješten sprijeda), brzo punjenje baterije 20W, Qi Wireless punjenje 7.5W\n" +
                    "OS: iOS 15.4 ili noviji\n");
            product.setPrice(new BigDecimal("2000.00"));
            product.setName("Apple iPhone SE3 128GB");
            product.setQuantityInStock(23);
            product.setImage("https://www.google.com/aclk?sa=l&ai=DChcSEwjnlr7Qzcv8AhUQ03cKHYrZD1kYABAHGgJlZg&sig=AOD64_0HDpxoyTjRUG2luA6RrZUOR17OXA&adurl&ctype=5&ved=2ahUKEwiPmbTQzcv8AhXS2KQKHdfVDXgQvhd6BQgBEIQB");
            productRepository.save(product);

            var product2 = new Product();
            product2.setCurrency(Currency.getInstance(Locale.US));
            product2.setProductType(ProductType.MOBILE);
            product2.setDescription("Predstavljen: Februar, 2022\n" +
                    "Ekran: 6.6”, 1080 x 2340 px, Dynamic AMOLED 2X, 120Hz, HDR10+\n" +
                    "Chipset: Exynos 2200\n" +
                    "Procesor: Octa-core (1x 2.8 GHz Cortex-X2, 3x 2.5 GHz Cortex-A710 i 4x 1.8 GHz Cortex-A510 jezgre)\n" +
                    "Grafika: Xclipse 920\n" +
                    "RAM memorija: 8 GB\n" +
                    "Interna memorija: 256 GB\n" +
                    "microSD slot: NEMA\n" +
                    "Stražnje kamere:\n" +
                    "50 MP, f/1.8, 23mm, 1/1.56”, 1.0µm, Dual Pixel PDAF, OIS\n" +
                    "10 MP, f/2.4, 70mm (telefoto), 1/3.94”, 1.0µm, PDAF, OIS, 3x optički zoom\n" +
                    "12 MP, f/2.2, 13mm, 120˚ (širokokutna), 1/2.55” 1.4µm, Super Steady video\n" +
                    "Video 8K@24fps\n" +
                    "Prednja kamera:\n" +
                    "10 MP, f/2.2, 26mm, 1/3.24”, 1.22µm, Dual Pixel PDAF\n" +
                    "Video 4K@60fps\n" +
                    "Kapacitet baterije: 4500 mAh\n" +
                    "Dodatno: senzor otiska prsta (ultrasonični, smješten ispod ekrana), brzo punjenje baterije 45W, brzo Qi/PMA wireless punjenje od 15W, mogućnost punjenja drugih uređaja putem wirelessa snagom od 4.5W\n" +
                    "OS: Android 12, One UI 4.1\n");
            product2.setPrice(new BigDecimal("2100.00"));
            product2.setName("Samsung Galaxy S22 Plus 5G 256GB");
            product2.setQuantityInStock(10);
            product2.setImage("https://www.univerzalno.com/wp-content/uploads/2022/08/HP-440G6PO-AiO-1-2.jpg");
            productRepository.save(product2);


            var product3 = new Product();
            product3.setCurrency(Currency.getInstance(Locale.US));
            product3.setProductType(ProductType.MOBILE);
            product3.setDescription("Predstavljen: Mart, 2022\n" +
                    "Ekran: 6.6”, TFT LCD, 120Hz, 1080 x 2408 px\n" +
                    "Chipset: Exynos 1280\n" +
                    "Procesor: Octa-core (2x 2.4 GHz Cortex-A78 i 6x 2.0 GHz Cortex-A55 jezgre)\n" +
                    "Grafika: Mali-G68\n" +
                    "RAM memorija: 6 GB\n" +
                    "Interna memorija: 128 GB\n" +
                    "microSD slot: DA\n" +
                    "Stražnje kamere:\n" +
                    "50 MP, f/1.8, PDAF\n" +
                    "5 MP, f/2.2, 123˚ (širokokutna)\n" +
                    "2 MP, f/2.4, (senzor dubinske oštrine)\n" +
                    "2 MP, f/2.4, (macro)\n" +
                    "Video 4K@30fps\n" +
                    "Prednja kamera:\n" +
                    "8 MP, f/2.2\n" +
                    "Video 1080p@30fps\n" +
                    "Kapacitet baterije: 5000 mAh ili 6000 mAh (zavisno od tržišta)\n" +
                    "Dodatno: senzor otiska prsta (smješten bočno), brzo punjenje baterije 25W\n" +
                    "OS: Android 12, One UI 4.1\n");
            product3.setPrice(new BigDecimal("1400.00"));
            product3.setName("Samsung Galaxy M33 128GB");
            product3.setQuantityInStock(11);
            product3.setImage("https://khaleejitech.com/wp-content/uploads/2022/03/Samsung-Galaxy-M33-main.jpg");
            productRepository.save(product3);

            var product4 = new Product();
            product4.setCurrency(Currency.getInstance(Locale.US));
            product4.setProductType(ProductType.MOBILE);
            product4.setDescription("Huawei Y7p predstavljen je početkom 2020. godine. Donosi ekran od 6.39” HD+ rezolucije slike, izrađen u IPS tehnologiji. Pokreće ga Octa core procesor (Kirin 710F), sastavljen od 4x 2.2 GHz Cortex-A73 i 4x 1.7 GHz Cortex-A53 jezgri. U ovoj varijanti radi u paru sa 4 GB RAM memorije i 64 GB interne memorije, koju je moguće i dodatno proširiti putem microSD kartica kapaciteta do 512 GB. Ovaj model će zadovoljiti ljubitelje fotografije, a straga donosi 3 kamere, glavnu od 48 Mp, širokokutnu od 8 Mp i još jedan senzor od 2 Mp, koji služi za dubinsko mjerenje oštrine. Za selfije je zadužena kamera od 8 Mp, a maksimalna rezolucija videa je Full HD sa 30 fps. Od interesantnih opcija, Y7p posjeduje senzor otiska prsta (smješten straga), kao i punjenje baterije  od 10W (baterija kapaciteta 4000 mAh). Ovaj model iz tvornice stiže uz Android 9.0 Pie, ali bez podrške za Google Play Services.");
            product4.setPrice(new BigDecimal("599.90"));
            product4.setName("Huawei Y7p 64GB");
            product4.setQuantityInStock(12);
            product4.setImage("https://www.zaibis.com/wp-content/uploads/2020/09/Y7P-4.jpg");
            productRepository.save(product4);

            var product5 = new Product();
            product5.setCurrency(Currency.getInstance(Locale.US));
            product5.setProductType(ProductType.MOBILE);
            product5.setDescription("Huawei P40 Pro predstavljen je u martu 2020. godine. Ekskluzivni Huaweiev model donosi elegantno kućište i vrhunski OLED ekran od 6,58”, rezolucije slike 1200 x 2640 piksela. Pokreće ga octa core procesor sastavljen od 2x 2.8 GHz Cortex-A76, 2x 2.3 GHz Cortex-A76 i 4x 1.9 GHz Cortex-A55 jezgri. U ovoj varijanti uparen je sa 8 GB RAM memorije i 256 GB interne memorije, koju je moguće dodatno proširiti putem Nano Memory kartica kapaciteta do 256 GB. Od kamera, korisnicima su na raspolaganju 4 senzora straga. Glavna kamera je rezolucije 50 Mp, opremljena optičkim stabilizatorom slike, kojeg ima i periskop telefoto kamera od 12 Mp, koja simulira 5x optički zoom. Pored njih, tu se nalazi još jedna širokokutna kamera od 40 Mp, te TOF 3D senzor, koji služi za dubinsko mjerenje oštrine. Maksimalna rezolucija videa stražnjih kamera je 4K sa do 60 fps, a ovaj model može snimati i ultra usporeni video u Full HD rezoluciji sa 960 fps. Kada govorimo o prednjoj kameri, tu se nalazi senzor od 32 Mp, a uz njega je još jedan IR TOF 3D senzor, koji osim za mjerenje dubinske oštrine služi i za prepoznavanje lica. Od interesantnih opcija, spomenut ćemo i senzor otiska prsta (smješten ispod ekrana), kao i brzo punjenje baterije od 40W, wireless punjenje od 27W, kao i mogućnost punjenja drugih wireless uređaja istom snagom. Ovaj model iz tvornice stiže uz predinstaliran operativni sistem Android 10, bez podrške za Google Play Services.");
            product5.setPrice(new BigDecimal("1679.90"));
            product5.setName("Huawei P40 Pro 5G 256GB");
            product5.setQuantityInStock(13);
            product5.setImage("https://www.njuskalo.hr/image-w920x690/huawei-p40/huawei-p40-pro-256gb-sivi-racun-garanc-dostava-slika-138853125.jpg");
            productRepository.save(product5);

            var product6 = new Product();
            product6.setCurrency(Currency.getInstance(Locale.US));
            product6.setProductType(ProductType.MOBILE);
            product6.setDescription("Predstavljen: Januar, 2022\n" +
                    "Ekran: 6.4”, AMOLED, 90Hz, 1080 x 2400 px\n" +
                    "Chipset: Helio G96\n" +
                    "Procesor: Octa-core (2x 2.0 GHz Cortex-A76 i 6x 2.0 GHz Cortex-A55 jezgre)\n" +
                    "Grafika: Mali-G57 MC2\n" +
                    "RAM memorija: 8 GB\n" +
                    "Interna memorija: 128 GB\n" +
                    "microSD slot: DA\n" +
                    "Stražnje kamere:\n" +
                    "108 MP, f/1.9, 26mm, 1/1.52”, 0.7µm, PDAF\n" +
                    "8 MP, f/2.2, 118˚ (širokokutna)\n" +
                    "2 MP, f/2.4, (macro)\n" +
                    "2 MP, f/2.4, (senzor dubinske oštrine)\n" +
                    "Video 1080p@30fps\n" +
                    "Prednja kamera:\n" +
                    "16 MP, f/2.5, 1/3.06” 1.0µm\n" +
                    "Video 1080p@30fps\n" +
                    "Kapacitet baterije: 5000 mAh\n" +
                    "Dodatno: senzor otiska prsta (smješten bočno), brzo punjenje baterije 33W\n" +
                    "OS: Android 11\n");
            product6.setPrice(new BigDecimal("999.90"));
            product6.setName("Xiaomi Redmi Note 11S 128GB");
            product6.setQuantityInStock(14);
            product6.setImage("https://startech.ba/3658-medium_default/xiaomi-redmi-note-11s-6gb-128gb-grey.jpg");
            productRepository.save(product6);


            var product7 = new Product();
            product7.setCurrency(Currency.getInstance(Locale.US));
            product7.setProductType(ProductType.MOBILE);
            product7.setDescription("Predstavljen: Mart, 2022\n" +
                    "Ekran: 6.5”, IPS LCD, 720 x 1600 px\n" +
                    "Chipset: Helio G25\n" +
                    "Procesor: Octa-core (4x 2.0 GHz i 4x 1.5 GHz, Cortex-A53 jezgre)\n" +
                    "Grafika: PowerVR GE8320\n" +
                    "RAM memorija: 3 GB\n" +
                    "Interna memorija: 64 GB\n" +
                    "microSD slot: DA\n" +
                    "Stražnja kamera:\n" +
                    "13 MP, f/2.2, 1.0µm, AF\n" +
                    "Video 1080p@30fps\n" +
                    "Prednja kamera:\n" +
                    "5 MP\n" +
                    "Video 1080p@30fps\n" +
                    "Kapacitet baterije: 5000 mAh\n" +
                    "Dodatno: senzor otiska prsta (smješten straga)\n" +
                    "OS: Android 11, MIUI 12.5\n");
            product7.setPrice(new BigDecimal("399.90"));
            product7.setName("Xiaomi Redmi 10A 64GB");
            product7.setQuantityInStock(14);
            product7.setImage("https://startech.ba/4168-large_default/xiaomi-redmi-10a-4gb-64gb-black.jpg");
            productRepository.save(product7);


            var product8 = new Product();
            product8.setCurrency(Currency.getInstance(Locale.US));
            product8.setProductType(ProductType.MOBILE);
            product8.setDescription("Predstavljen: Septembar, 2021\n" +
                    "Ekran: 6.7”, Super Retina XDR OLED, 120Hz, 1284 x 2778 px\n" +
                    "Chipset: Apple A15 Bionic\n" +
                    "Procesor: Hexa-core (2x 3.2 GHz Avalanche i 4x 1.8 GHz Blizzard jezgre)\n" +
                    "Grafika: Apple GPU\n" +
                    "RAM memorija: 6 GB\n" +
                    "Interna memorija: 1 TB\n" +
                    "microSD slot: NEMA\n" +
                    "Stražnje kamere:\n" +
                    "12 MP, f/1.5, 26mm, 1.9µm, dual pixel PDAF, sensor-shift OIS\n" +
                    "12 MP, f/2.8, 77mm (telefoto), PDAF, OIS, 3x optical zoom\n" +
                    "12 MP, f/1.8, 13mm, 120˚ (širokokutna), PDAF\n" +
                    "TOF 3D LiDAR scanner (senzor dubinske oštrine)\n" +
                    "Video 4K@60fps\n" +
                    "Prednja kamera:\n" +
                    "12 MP, f/2.2, 23mm (wide), 1/3.6”\n" +
                    "SL 3D, (senzor dubinske oštrine)\n" +
                    "Video 4K@60fps\n" +
                    "Kapacitet baterije: 4352 mAh\n" +
                    "Dodatno: Face ID, brzo punjenje baterije 23W, MagSafe wireless punjenje 15W, Qi magnetic wireless punjenje 7.5W\n" +
                    "OS: iOS 15\n");
            product8.setPrice(new BigDecimal("3099.90"));
            product8.setName("Apple iPhone 13 Pro MAX 1TB");
            product8.setQuantityInStock(15);
            product8.setImage("https://www.univerzalno.com/wp-content/uploads/2022/08/HP-440G6PO-AiO-1-2.jpg");
            productRepository.save(product8);


            var product9 = new Product();
            product9.setCurrency(Currency.getInstance(Locale.US));
            product9.setProductType(ProductType.MOBILE);
            product9.setDescription("Predstavljen: Septembar, 2021\n" +
                    "Ekran: 5.4”, Super Retina XDR OLED, 1080 x 2340 px\n" +
                    "Chipset: Apple A15 Bionic\n" +
                    "Procesor: Hexa-core (2x 3.2 GHz Avalanche i 4x 1.8 GHz Blizzard jezgre)\n" +
                    "Grafika: Apple GPU\n" +
                    "RAM memorija: 4 GB\n" +
                    "Interna memorija: 128 GB\n" +
                    "microSD slot: NEMA\n" +
                    "Stražnje kamere:\n" +
                    "12 MP, f/1.6, 26mm, 1.7µm, dual pixel PDAF, optički stabilizator slike\n" +
                    "12 MP, f/2.4, 120˚, 13mm (širokokutna)\n" +
                    "Video 4K@60fps\n" +
                    "Prednja kamera:\n" +
                    "12 MP, f/2.2, 23mm, 1/3.6”\n" +
                    "SL 3D senzor dubinske oštrine\n" +
                    "Video 4K@60fps\n" +
                    "Kapacitet baterije: 2438 mAh\n" +
                    "Dodatno: Face ID, brzo punjenje baterije 20W, MagSafe wireless punjenje 15W, Qi magnetic wireless punjenje 7.5W\n" +
                    "OS: iOS 15\n");
            product9.setPrice(new BigDecimal("1599.90"));
            product9.setName("Apple iPhone 13 Mini 128GB");
            product9.setQuantityInStock(16);
            product9.setImage("https://cjenolov.ba/storage/media/5377/apple-iphone-13-mini-128gb.jpg");
            productRepository.save(product9);

            var product10 = new Product();
            product10.setCurrency(Currency.getInstance(Locale.US));
            product10.setProductType(ProductType.MOBILE);
            product10.setDescription("Apple iPhone 12 serija uređaja predstavljena je krajem 2020. godine. Apple je ovaj put ponudio čak 4 različita modela, najmanji i najjeftiniji je iPhone 12 mini, a slijede ga iPhone 12, iPhone 12 Pro te iPhone 12 Pro MAX, koji je najbolji i najskuplji model u ponudi. Zanimljivo je da svaki iPhone 12 posjeduje 5G povezivanje. Kada govorimo o najboljim verzijama, iPhone 12 Pro i Pro MAX ovaj put se ne razlikuju samo u dimenzijama, nego i u kamerama. iPhone 12 Pro MAX je najveći model, a stiže uz ekran od 6.7″, izrađen u XDR OLED tehnologiji, rezolucije slike 1284 x 2778 piksela. Pokreće ga Hexa core (6 jezgri) procesor (Apple A14 Bionic), sastavljen od 2x 3.1 GHz Firestorm i 4x 1.8 GHz Icestorm jezgri.");
            product10.setPrice(new BigDecimal("2349.90"));
            product10.setName("Apple iPhone 12 Pro MAX 128GB");
            product10.setQuantityInStock(17);
            product10.setImage("https://atstore.ba/wp-content/uploads/2020/10/iPhone_12_Pro_Max_Silver_PDP_Image_Position-2__en-US-scaled.jpg");
            productRepository.save(product10);

            var product11 = new Product();
            product11.setCurrency(Currency.getInstance(Locale.US));
            product11.setProductType(ProductType.MOBILE);
            product11.setDescription("Predstavljen: Februar, 2022\n" +
                    "Ekran: 6.6”, 1080 x 2340 px, Dynamic AMOLED 2X, 120Hz, HDR10+\n" +
                    "Chipset: Exynos 2200\n" +
                    "Procesor: Octa-core (1x 2.8 GHz Cortex-X2, 3x 2.5 GHz Cortex-A710 i 4x 1.8 GHz Cortex-A510 jezgre)\n" +
                    "Grafika: Xclipse 920\n" +
                    "RAM memorija: 8 GB\n" +
                    "Interna memorija: 128 GB\n" +
                    "microSD slot: NEMA\n" +
                    "Stražnje kamere:\n" +
                    "50 MP, f/1.8, 23mm, 1/1.56”, 1.0µm, Dual Pixel PDAF, OIS\n" +
                    "10 MP, f/2.4, 70mm (telefoto), 1/3.94”, 1.0µm, PDAF, OIS, 3x optički zoom\n" +
                    "12 MP, f/2.2, 13mm, 120˚ (širokokutna), 1/2.55” 1.4µm, Super Steady video\n" +
                    "Video 8K@24fps\n" +
                    "Prednja kamera:\n" +
                    "10 MP, f/2.2, 26mm, 1/3.24”, 1.22µm, Dual Pixel PDAF\n" +
                    "Video 4K@60fps\n" +
                    "Kapacitet baterije: 4500 mAh\n" +
                    "Dodatno: senzor otiska prsta (ultrasonični, smješten ispod ekrana), brzo punjenje baterije 45W, brzo Qi/PMA wireless punjenje od 15W, mogućnost punjenja drugih uređaja putem wirelessa snagom od 4.5W\n" +
                    "OS: Android 12, One UI 4.1\n");
            product11.setPrice(new BigDecimal("1899.00"));
            product11.setName("Samsung Galaxy S22 Plus 5G 128GB");
            product11.setQuantityInStock(18);
            product11.setImage("https://www.univerzalno.com/wp-content/uploads/2022/05/sams22plus-1.jpg");
            productRepository.save(product11);

            var product12 = new Product();
            product12.setCurrency(Currency.getInstance(Locale.US));
            product12.setProductType(ProductType.MOBILE);
            product12.setDescription("Predstavljen: Oktobar, 2020\n" +
                    "Ekran: 6.4”, IPS LCD, 720 x 1600 px\n" +
                    "Chipset: Helio G35\n" +
                    "Procesor: Octa-core (4x 2.3 GHz i 4x 1.8 GHz, Cortex-A53 jezgre)\n" +
                    "Grafika: PowerVR GE8320\n" +
                    "RAM memorija: 3 GB\n" +
                    "Interna memorija: 32 GB\n" +
                    "microSD slot: DA\n" +
                    "Stražnje kamere:\n" +
                    "13 MP, f/2.2, 28mm, 1.0µm, PDAF\n" +
                    "2 MP, f/2.4, (macro)\n" +
                    "2 MP, f/2.4, (senzor dubinske oštrine)\n" +
                    "Video 1080p@30fps\n" +
                    "Prednja kamera:\n" +
                    "5 MP, f/2.2, 1.12µm\n" +
                    "Video 1080p@30fps\n" +
                    "Kapacitet baterije: 5000 mAh\n" +
                    "Dodatno: brzo punjenje baterije 10W\n" +
                    "OS: Android 10\n");
            product12.setPrice(new BigDecimal("259.99"));
            product12.setName("Xiaomi Poco C3 32GB");
            product12.setQuantityInStock(19);
            product12.setImage("https://www.iphwc.com/wp-content/uploads/2021/08/Poco-C3-32_1.png");
            productRepository.save(product12);
        }
    }

}

