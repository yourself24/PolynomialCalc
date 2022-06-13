package main.model;


public class Multiply implements IOp {

    public Result compute(Polinom p1, Polinom p2) {
        Result r = new Result();
        Polinom q = new Polinom();

        IOp add = new Addition();
        for (Monom i : p1.getElem()) {
            /**
         * Multiplication of each coeff of p1 with each coeff of p2
         */
            Polinom p = new Polinom();
            for (Monom j : p2.getElem()) {
                Monom monom = new Monom(i.getCoef() * j.getCoef(), i.getDegree() + j.getDegree());
                p.addMonom(monom);
            }
            r = add.compute(p, q);/**
             *Sum of the partial results from above
             */

            q = r.getResult();

        }
        return r;

    }

}
