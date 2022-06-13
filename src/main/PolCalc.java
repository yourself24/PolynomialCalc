package main;

public class PolCalc {

    public static void main(String[] args) {

        PolView view=new PolView();
        PolController controller=new PolController(view);
        view.setVisible(true);


    }

}
