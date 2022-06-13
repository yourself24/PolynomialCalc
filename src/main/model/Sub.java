package main.model;


public class Sub implements IOp {

    public Result compute(Polinom p1, Polinom p2) {
        Result r=new Result();
        for(Monom i:p2.getElem()) {   /**
         multiplication of each monomial of p2 with -1
         **/
            i.setCoef(i.getCoef()*(-1));
        }
        IOp add=new Addition();
        /**
         *
         */
        r=add.compute(p1,p2); /**
         addition between p1 and -p2
         *
         */
        return r;

    }

}
