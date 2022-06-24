package com.example.cetakfotoku2;

import java.util.ArrayList;
import java.util.List;

public class KatalogFotoUtil {
    private static int[] ridArray = {
            R.drawable.prau,
            R.drawable.bromo,
            R.drawable.merapi,
            R.drawable.kelimutu,
            R.drawable.rinjani,

    };

    private  static String[] filenameArray ={
            "prau",
            "bromo",
            "merapi",
            "kelimutu",
            "rinjani",

    };

    private static List<KatalogFoto> katalogFotoList;

    public static void init(){
        katalogFotoList = new ArrayList<>();
        int nArray = ridArray.length;
        for(int i=0;i<nArray;i++){
            katalogFotoList.add(new KatalogFoto(ridArray[i], filenameArray[i]));
        }
    }
    public static List<KatalogFoto> getKatalogFotoList(){
        return katalogFotoList;
    }
    public static KatalogFoto getKatalogFotoAt(int i){
        return katalogFotoList.get(i);
    }
}
