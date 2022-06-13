package test;
import static org.junit.Assert.*;
import main.model.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.*;

public class JUnitTest {
    private static Polinom p1 = new Polinom();
    private static Polinom p2 = new Polinom();

    public JUnitTest() {

        Monom m1 = new Monom(2,3);
        Monom m2 = new Monom(-4,1);
        Monom m3 = new Monom(1,0);
        Monom m4 = new Monom(5,2);
        Monom m5 = new Monom(1,1);
        Monom m6 = new Monom(-6,0);
        List<Monom> l = new ArrayList<Monom>();
        List<Monom> l1 = new ArrayList<Monom>();
        l.add(m1);
        l.add(m2);
        l.add(m3);
        l1.add(m4);
        l1.add(m5);
        l1.add(m6);
        p1.setElem(l);
        p2.setElem(l1);
    }


    @Test
    public void testAdd(){
        IOp add=new Addition();
        Result r=new Result();
        r=add.compute(p1, p2);
        assertTrue(r.getResult().toString().equals("2x^3+5x^2-3x^1-5x^0"));


    }


    @Test
    public void testSub(){
       IOp sub=new Sub();
        Result r=new Result();
        r=sub.compute(p1, p2);
        assertTrue(r.getResult().toString().equals("2x^3-5x^2-5x^1+7x^0"));
    }
    @Test
    public void testMult(){
       IOp mul=new Multiply();
        Result r=new Result();
        r=mul.compute(p1, p2);
        assertTrue(r.getResult().toString().equals("10x^5+2x^4-32x^3+1x^2+25x^1-6x^0"));

    }

    @Test
    public void testDiv(){
       IOp div=new Div();
        Bipol r=new Bipol();
        r=(Bipol)div.compute(p1, p2);
        assertTrue(r.getResult().toString().equals("0.4x^1-0.08x^0-5.9604646E-9x^0"));
        assertTrue(r.getRest().toString().equals("-1.5199999x^1+0.5199999x^0"));

    }

    @Test
    public void testDeriv(){
       IOp deriv=new Deriv();
        Result r=new Result();
        r=deriv.compute(p1, null);
        assertTrue(r.getResult().toString().equals("6x^2-4x^0 "));
    }

    @Test
    public void testInteg(){
       IOp integ=new Integrate();
        Result r=new Result();
        r=integ.compute(p1, null);
        assertTrue(r.getResult().toString().equals("0.5x^4-2x^2+1x^1"));
    }

}