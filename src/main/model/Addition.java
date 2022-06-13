package main.model;

import java.util.Collections;

public class Addition implements IOp {

    public Result compute(Polinom p1, Polinom p2) {
        Polinom p = new Polinom();
        for (Monom i : p1.getElem()){/**
         *iteration and comparison of each monomial of p1 with each monomial of p2;
         */
            int ok = 0;
            for (Monom j : p2.getElem()) {
                if (i.getDegree() == j.getDegree()) {/**
                 *if equal,the sum is made and the result is written only if sum >0
                 */
                    if (i.getCoef() + j.getCoef() != 0)p.addMonom(new Monom(i.getCoef() + j.getCoef(), i.getDegree()));
                    ok = 1;
                }
            }
            if (ok == 0) {/**
             *if ok has not changed,it means we haven't found any equalities
             */
                p.addMonom(new Monom(i.getCoef(), i.getDegree())); /**
                 *=>> must add to result
                 */

            }
        }
        for (Monom j : p2.getElem()) {/**
         * iterating through second polynomial
         */
            int ok = 0;
            for (Monom i : p1.getElem()) {
                if (i.getDegree() == j.getDegree()) {/**
                 * comparing. if we find equality=> ok=1
                 */
                    ok = 1;
                }
            }
            if (ok == 0) { /**
             *if unchanged,must add to result
             */
                p.addMonom(new Monom(j.getCoef(), j.getDegree()));
            }
        }
        Collections.sort(p.getElem());  /**
         *sorting of monomials in the result;
         */
        Result r = new Result(p);
        return r;
    }
}
