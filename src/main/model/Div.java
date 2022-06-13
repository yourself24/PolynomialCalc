package main.model;



import java.util.*;

public class Div implements IOp {

    public Result compute(Polinom p1, Polinom p2) {
        Polinom s = new Polinom();
        Bipol r = new Bipol();
        if(p1.getElem().get(0).getCoef()==0) {/**
         * if coefficient of p1=0 => result is 0;
         */
            r.setRest(new Polinom());
            r.setResult(new Polinom());
            return r;}
        else {while (p1.getElem().get(0).getDegree() >= p2.getElem().get(0).getDegree()) { /**
         *division is done while degree of p1 > degree of p2
         */
            Monom m = new Monom(p1.getElem().get(0).getCoef() / p2.getElem().get(0).getCoef(),p1.getElem().get(0).getDegree() - p2.getElem().get(0).getDegree());
            Polinom p = new Polinom();
            p.addMonom(m);
            s.addMonom(m); /**
             *polynomial used for storing result
             */
            IOp mul = new Multiply();
            p= mul.compute(p, p2).getResult();  /**
             *p2 is multiplied with p(resulted from division of first monomials of p1 and p2)
             */
            IOp sub = new Sub();
            p1 = sub.compute(p1, p).getResult(); /**
             *the result from above is substracted from p1
             */
            if (p1.getElem().isEmpty()) {/**
             *if sub result is 0=>result is 0 too
             */
                List<Monom> l = new ArrayList<Monom>();
                l.add(new Monom(0, 0));
                p1.setElem(l);
            }
            r.setRest(p1);
            r.setResult(s);
            if (p1.getElem().get(0).getCoef() == 0 && p1.getElem().size() == 1) {
                r.setRest(new Polinom());
            }
        }
            return r;
        }
    }
}
