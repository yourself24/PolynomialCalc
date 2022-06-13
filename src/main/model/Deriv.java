package main.model;


public class Deriv implements IOp{

    public Result compute(Polinom p1, Polinom p2) {
        Result r=new Result();
        p2=new Polinom();
        if(p1.getElem().get(0).getDegree()!=0){
            for(Monom i:p1.getElem()) {
                Monom m=new Monom(i.getCoef()*i.getDegree(),i.getDegree()-1);
                /**
                 * power remains -1 for non-x monomials,but is still displayed as 0
                 */
                p2.addMonom(m);
            }
        }
        p1=p2;
        r.setResult(p1);
        return r;
    }

}
