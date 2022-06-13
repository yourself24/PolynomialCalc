package main.model;

import java.util.ArrayList;
import java.util.List;



public class Polinom {
    private List<Monom> elem;

    //constructors
    public Polinom(List<Monom> elem) {
        super();
        this.elem = elem;
    }

    public Polinom(){
        elem=new ArrayList<Monom>();

    }

    //getter
    public List<Monom> getElem() {
        return elem;
    }

    //setter
    public void setElem(List<Monom> elem) {
        this.elem = elem;
    }

    /**adding a monomial in the polynomial
     *
     *
     */
    public void addMonom(Monom m)
    {
        elem.add(m);
    }


    public String toString() {

        String s="";
        if(elem.isEmpty() )  s="0";
        else {
            for(Monom i:elem) {

                s=s+i.toString();
            }
            if(s.charAt(0)=='+')
                s=s.substring(1,s.length());
        }
        if(s.charAt(0)==' ') s="0";
        return s;

    }




}
