/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Staskevicius;

//import edu.ktu.ds.lab2.demo.Car;
//import edu.ktu.ds.lab2.demo.CarMarket;
import edu.ktu.ds.lab2.utils.Ks;
import edu.ktu.ds.lab2.utils.ParsableAvlSet;
import edu.ktu.ds.lab2.utils.ParsableBstSet;
import edu.ktu.ds.lab2.utils.ParsableSortedSet;
import edu.ktu.ds.lab2.utils.Set;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.Locale;

/**
 *
 * @author Tomas
 */
public class ManualTest {
      static Device[] devices;
    static ParsableSortedSet<Device> cSeries = new ParsableBstSet<>(Device::new, Device.byPrice);

    public static void main(String[] args) throws CloneNotSupportedException {
        Locale.setDefault(Locale.US); // Suvienodiname skaičių formatus
        executeTest();
    }

    public static void executeTest() throws CloneNotSupportedException {
        Device d1 = new Device("Samsung", "Galaxy S8", 2016, 5.3, 700);
        Device d2 = new Device.Builder()
                .brand("Iphone")
                .model("X")
                .year(2018)
                .screenSize(6.0)
                .price(1799.99)
                .build();
        Device d3 = new Device.Builder().buildRandom();
        Device d4 = new Device("Samsung Galaxy S10 2017 7.0 1499.99");
        Device d5 = new Device("Google Watch 2 2019 1.5 399.89");
        Device d6 = new Device("Redmi Node5 2017 5.8 181.11");
        Device d7 = new Device("Nokia 3310 2001 1.5  50.0");
        Device d8 = new Device("LG L70 2015 4.5 80.31");
        Device d9 = new Device("Apple Ipod 3 2012 4.5 299.20");

        Device[] devicesArray = {d9, d7, d8, d5, d1, d6};

        Ks.oun("Auto Aibė:");
        ParsableSortedSet<Device> devicesSet = new ParsableBstSet<>(Device::new);

        for (Device d: devicesArray) {
            devicesSet.add(d);
            Ks.oun("Aibė papildoma: " + d + ". Jos dydis: " + devicesSet.size());
        }
        Ks.oun("");
        Ks.oun(devicesSet.toVisualizedString(""));

        ParsableSortedSet<Device> devicesSetCopy = (ParsableSortedSet<Device>) devicesSet.clone();

        devicesSetCopy.add(d2);
        devicesSetCopy.add(d3);
        devicesSetCopy.add(d4);
        Ks.oun("Papildyta prietaisų aibės kopija:");
        Ks.oun(devicesSetCopy.toVisualizedString(""));

        d9.setScreenSize(10000);

        Ks.oun("Originalas:");
        Ks.ounn(devicesSet.toVisualizedString(""));

        Ks.oun("Ar elementai egzistuoja aibėje?");
        for (Device d : devicesArray) {
            Ks.oun(d + ": " + devicesSet.contains(d));
        }
        Ks.oun(d2 + ": " + devicesSet.contains(d2));
        Ks.oun(d3 + ": " + devicesSet.contains(d3));
        Ks.oun(d4 + ": " + devicesSet.contains(d4));
        Ks.oun("");

        Ks.oun("Ar elementai egzistuoja aibės kopijoje?");
        for (Device d : devicesArray) {
            Ks.oun(d + ": " + devicesSetCopy.contains(d));
        }
        Ks.oun(d2 + ": " + devicesSetCopy.contains(d2));
        Ks.oun(d3 + ": " + devicesSetCopy.contains(d3));
        Ks.oun(d4 + ": " + devicesSetCopy.contains(d4));
        Ks.oun("");

      /*  Ks.oun("Elementų šalinimas iš kopijos. Aibės dydis prieš šalinimą:  " + devicesSetCopy.size());
        for (Device d : new Device[]{d2,d1, d9, d8, d5, d3, d4, d2, d7, d6, d7, d9}) {
            devicesSetCopy.remove(d);
            Ks.oun("Iš autoaibės kopijos pašalinama: " + d + ". Jos dydis: " + devicesSetCopy.size());
        }
        Ks.oun("");*/

        Ks.oun("Prietaisų aibė su iteratoriumi:");
        Ks.oun("");
        for (Device d : devicesSet) {
            Ks.oun(d);
        }
        Ks.oun("");
        Ks.oun("Prietaisų aibė AVL-medyje:");
        ParsableSortedSet<Device> devicesSetAvl = new ParsableAvlSet<>(Device::new);
        for (Device d : devicesArray) {
            devicesSetAvl.add(d);
        }
        Ks.ounn(devicesSetAvl.toVisualizedString(""));

        Ks.oun("Prietaisų aibė su iteratoriumi:");
        Ks.oun("");
        for (Device d : devicesSetAvl) {
            Ks.oun(d);
        }

        Ks.oun("");
        Ks.oun("Prietaisų aibė su atvirkštiniu iteratoriumi:");
        Ks.oun("");
        Iterator iter = devicesSetAvl.descendingIterator();
        while (iter.hasNext()) {
            Ks.oun(iter.next());
        }

        Ks.oun("");
        Ks.oun("Prietaisų aibės toString() metodas:");
        Ks.ounn(devicesSetAvl);

        // Išvalome ir suformuojame aibes skaitydami iš failo
        devicesSet.clear();
        devicesSetAvl.clear();

        Ks.oun("");
        Ks.oun("Prietaisų aibė DP-medyje:");
        devicesSet.load("data\\ban.txt");
        
        Ks.ounn(devicesSet.toVisualizedString(""));
        Ks.oun("Išsiaiškinkite, kodėl medis augo tik į vieną pusę.");

        Ks.oun("");
        Ks.oun("Prietaisų aibė AVL-medyje:");
        devicesSetAvl.load("data\\ban.txt");
        Ks.ounn(devicesSetAvl.toVisualizedString(""));
        
        
        Set<String> devicesSet4 = DeviceShop.duplicateCarMakes(devicesArray);
        Ks.oun("Pasikartojančios prietaisų markės:\n" + devicesSet4.toString());

        Set<String> devicesSet5 = DeviceShop.uniqueDeviceModels(devicesArray);
        Ks.oun("Unikalūs prietaisų modeliai:\n" + devicesSet5.toString());
        
        
        
        //devicesSet.headSet(d8);
        //Ks.oun("devicesSet before headSet\n" + devicesSetCopy.toString());
        //Set<Device> copyHeadSet = devicesSetCopy.headSet(d6);
        //if(copyHeadSet != null)
       // Ks.oun("devicesSet after headSet\n" + copyHeadSet.toString());
        
        //Set<Device> mergedSet = devicesSet.addSet(copyHeadSet);
        
        //Ks.oun("merged set: \n" + mergedSet);
        Ks.oun("copy devices set lower element " + devicesSetCopy.lower(d7));
        
        Ks.oun("devicesSet before removeAll\n" + devicesSet.toString());
        devicesSet.callRemoveAll();
        Ks.oun("devicesSet after removeAll\n" + devicesSet.toString());
        
    }

    static ParsableSortedSet generateSet(int kiekis, int generN) {
        devices = new Device[generN];
        for (int i = 0; i < generN; i++) {
            devices[i] = new Device.Builder().buildRandom();
        }
        Collections.shuffle(Arrays.asList(devices));

        cSeries.clear();
        Arrays.stream(devices).limit(kiekis).forEach(cSeries::add);
        return cSeries;
    }
}
