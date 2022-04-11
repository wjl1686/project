package com.ejobim.opplat.hypo;

import com.ejobim.opplat.util.DateUtils;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TestJdk {
    @Test
    public void testDate(){
        Date curr = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        System.out.println(DateUtils.getDateOfWeek("2019-05-18"));
    }
}
