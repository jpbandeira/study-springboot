package com.jpbandeira.springrestapi.controller.utils;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;

public class URL {

    public static List<Integer> decodeIntList(String s){
        String[] vetor = s.split(",");
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < vetor.length; i++){
            list.add(Integer.parseInt(vetor[i]));
        }
        return list;
    }

    public static String decodeParam(String s) throws UnsupportedEncodingException {
         return URLDecoder.decode(s, "UTF-8");
    }
}
