package com.ejobim.opplat.wjl;

import java.math.BigDecimal;

public class Apple {
    private Integer id;
    private String name;
    private BigDecimal money;
    private Integer num;
    public Apple(Integer id, String name, BigDecimal money, Integer num) {
        this.id = id;
        this.name = name;
        this.money = money;
        this.num = num;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    @Override
    public String toString() {
        return "Apple{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", money=" + money +
                ", num=" + num +
                '}';
    }

    public static void main(String[] args) {
        System.out.println(System.nanoTime());

        //System.out.println(getInt(1000000));
       /* new HashMap<>();
        new ConcurrentHashMap();
        stackLeakByThread();*/

        //System.out.println( fun(4,1));
    }
    public static  int getInt(int n){
        if(n==0){
            return 0;
        }
        if(n==1){
            return 1;
        }
        return getInt(n-1)+getInt(n-2);
    }
    public static void stackLeakByThread(){
        while (true){
            new Thread(){
                public void  run(){
                    while (true){
                    }
                }
            }.start();
        }
    }

}
