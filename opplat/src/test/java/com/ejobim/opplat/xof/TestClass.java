package com.ejobim.opplat.xof;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.ejobim.opplat.util.DateUtils;
import com.ejobim.opplat.util.FileUtils;
import groovy.lang.Binding;
import groovy.lang.GroovyShell;

import java.io.*;
import java.util.*;

import static java.lang.System.out;

public class TestClass {

    public static void main(String[] args){
        Binding binding = new Binding();
        binding.setVariable("V1", 1.1);

        binding.setVariable("language", "Groovy");
        GroovyShell shell = new GroovyShell(binding);
        Object value = shell.evaluate("V1");
        System.out.println(value);

    }

    private static List<String> readText(String fileName){
        BufferedReader in = null;
        List<String> list = new ArrayList<>();
        try {
            in = new BufferedReader(new InputStreamReader(new FileInputStream(fileName),"UTF-8"));
            String str = null;
            while (true) {
                if (!((str = in.readLine()) != null)) break;
                list.add(str);

            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return list;
    }


}
