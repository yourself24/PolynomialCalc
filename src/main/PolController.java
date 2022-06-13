package main;

import main.model.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PolController {

    private PolView view;

    public PolController(PolView view) {
        this.view = view;
        this.view.addAddBtnListener(new CalcListener());
        this.view.addSubBtnListener(new CalcListener());
        this.view.addMulBtnListener(new CalcListener());
        this.view.addDivBtnListener(new CalcListener());
        this.view.addDerivBtnListener(new CalcListener());
        this.view.addIntegBtnListener(new CalcListener());
    }

    class CalcListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String s = e.getActionCommand();
            IOp op = this.getInstance(s);
            try {
                String p1S = view.getFirstPolinom();
                String p2S = view.getSecondPolinom();
                Polinom p1 = inputTransf(p1S);
                Polinom p2 = inputTransf(p2S);



                if (s.equals("∶")) {
                    if ((p2.getElem().get(0).getCoef() == 0 && p2.getElem().get(0).getDegree() == 0)
                            || p2.getElem().get(0).getDegree() > p1.getElem().get(0).getDegree()) {
                        if (p1.getElem().get(0).getDegree() == 0 && p1.getElem().get(0).getCoef() == 0) {
                            setareBipolinom(op, p1, p2);
                        } else
                            inputNecorespunzator();
                    } else {
                        setareBipolinom(op, p1, p2);
                    }
                } else {
                    setareRezultat(op, p1, p2);
                }
            } catch (NumberFormatException ex) {
                System.err.println("An  Exception occured. Details are provided below:");
                ex.printStackTrace(System.err);
            }
            catch(NullPointerException ex){
                System.err.println("Wrong Format!");

            }
            catch(IndexOutOfBoundsException ex){
                System.err.println("Invalid Format!");
            }

        }

        public IOp getInstance(String s) {
            switch (s) {
                case "+":
                    return new Addition();
                case "-":
                    return new Sub();
                case "∗":
                    return new Multiply();
                case "∶":
                    return new Div();
                case "Differentiate":
                    return new Deriv();
                case "Integrate":
                    return new Integrate();
                default:
                    return null;

            }
        }

        public Polinom inputTransf(String s) {
            Pattern p = Pattern.compile("(-?\\b\\d+)[xX]\\^(-?\\d+\\b)");

            Matcher m = p.matcher(s);

//            if(m.matches()==false){
//                System.err.println("Invalid Input!");
//                return new Polinom(null);
//            }
            Monom monom;
            Polinom pol = new Polinom();
            float c = 0;
            int d = 0;
            while (m.find()) {
                c = Float.valueOf(m.group(1));
                d = Integer.valueOf(m.group(2));
                monom = new Monom(c, d);
                pol.addMonom(monom);

            }
            return pol;

        }

        public void setareRezultat(IOp op, Polinom p1, Polinom p2) {
            Result r = new Result();
            r = op.compute(p1, p2);
            view.setCalcResult(r.getResult().toString());
            view.setCalcRest(null);

        }

        public void setareBipolinom(IOp op, Polinom p1, Polinom p2) {
            Bipol r = new Bipol();
            r = (Bipol) op.compute(p1, p2);
            view.setCalcResult(r.getResult().toString());
            view.setCalcRest(r.getRest().toString());
        }

        public void inputNecorespunzator() {
            System.out.println("Input necorespunzator !!!");
            view.setCalcResult(null);
            view.setCalcResult(null);
        }

    }

}