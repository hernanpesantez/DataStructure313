
import java.util.Scanner;
/**
 * Created by hernanpesantez on 9/12/17.
 */

public class X14101468 extends Polynomial {
    public static void main(String args[]) throws Exception {

        Polynomial p = new X14101468("x^9"),
                q = new X14101468("x^9");
        Utility.run(p, q);
        
        
        Scanner sc=new Scanner(System.in);
        
    }

    public X14101468(String s) {



        try {


            parseString(s);

        }catch (Exception e){
            System.out.println("Wrong format of string "+e.getMessage());
        }

    }

    public X14101468() {
        super();
    }


    public Polynomial add(Polynomial p) {
        Polynomial ans = new X14101468();
        // complete this code

        DNode<Term> sQ, sP;
        try{
            sQ=p.data.getFirst();
        }catch (Exception e){
            sQ=null;

        }

        try{
            sP=this.data.getFirst();
        }catch (Exception e){
            sP=null;

        }


        while (sQ!=null||sP!=null) {



            //If the degree of the terms are the same
            if (sQ != null&&sQ.getData()!=null && sP != null&&sP.getData()!=null) {


                if ((sP.getData().getDegree() == sQ.getData().getDegree())) {

                    sP.getData().setCoefficient(sP.getData().getCoefficient() + sQ.getData().getCoefficient());
                    ans.data.addLast(sP.getData());

                    sQ = sQ.getNext();
                    sP = sP.getNext();

                }

            }

                //If the degree of the terms are not the same
                 if (sP != null && sP.getData() != null) {
                     ans.data.addLast(sP.getData());
                     sP = sP.getNext();
                 } else {
                     sP = null;
                 }

                if (sQ != null && sQ.getData() != null) {

                    ans.data.addLast(sQ.getData());
                    sQ = sQ.getNext();

                } else {
                    sQ = null;
                }


        }

      return ans;
    }


    public Polynomial subtract(Polynomial p) {
        Polynomial ans = new X14101468();
        // complete this code


        DNode<Term> dP,dQ;
        try{
            dP=p.data.getFirst();
        }catch (Exception e){
            dP=null;

        }

        try{
            dQ=this.data.getFirst();
        }catch (Exception e){
            dQ=null;

        }


        while (dQ!=null||dP!=null) {



            //If the degree of the terms are the same
            if (dQ != null&&dQ.getData()!=null && dP != null&&dP.getData()!=null) {


                if ((dP.getData().getDegree() == dQ.getData().getDegree())&&(dP.getData().getCoefficient()==dQ.getData().getCoefficient())) {


                    dP.getData().setCoefficient(0.0);
                    dP.getData().setDegree(0);
                    ans.data.addLast(dP.getData());

                    dQ = dQ.getNext();
                    dP = dP.getNext();

                }


            }

            //If the degree of the terms are not the same

            if (dQ != null && dQ.getData() != null) {

                ans.data.addLast(dQ.getData());
                dQ = dQ.getNext();

            } else {
                dQ = null;
            }


            if (dP != null && dP.getData() != null) {
                dP.getData().setCoefficient(dP.getData().getCoefficient()*-1.0);
                ans.data.addLast(dP.getData());

                dP = dP.getNext();

            } else {
                dP = null;

            }


        }

        return ans;
    }

    public Polynomial multiply(Polynomial p) {

        Polynomial ans = new X14101468();

        // complete this code


        DNode<Term> pQ, pP;
        try{
            pP=p.data.getFirst();
        }catch (Exception e){
            pP=null;

        }

        try{
            pQ=this.data.getFirst();
        }catch (Exception e){
            pQ=null;

        }


        while (pP!=null||pQ!=null) {


            //If the degree of the terms are the same
            if (pP != null && pP.getData() != null) {

                                                                         
                pP.getData().setCoefficient(pP.getData().getCoefficient() *-1.0* pQ.getData().getCoefficient());
                pP.getData().setDegree(pP.getData().getDegree() + pQ.getData().getDegree());
                ans.data.addLast(pP.getData());

                pP = pP.getNext();
                

            } else {

                pQ = null;
                pP = null;
            }
        }


        return ans;
    }

    public Polynomial divide(Polynomial p) throws Exception {
        Polynomial ans = new X14101468();


        //the division method needs work
        
        
        DNode<Term> pQ, pP;
        Term termQ,termP;
        try{
            pP=p.data.getFirst();
            termP=p.data.getFirst().getData();
        }catch (Exception e){
            pP=null;
            termP=null;

        }

        try{
            pQ=this.data.getFirst();
            termQ=this.data.getFirst().getData();

        }catch (Exception e){
            pQ=null;
            termQ=null;

        }


        while (pP!=null||pQ!=null) {


            if (pP != null && pP.getData() != null&&pQ != null && pQ.getData() != null) {


                termP.setDegree(termP.getDegree()-termQ.getDegree());
                termQ.setDegree(termP.getDegree()-termQ.getDegree());

                ans.data.addLast(pP.getData());
                ans.data.addLast(pQ.getData());
                ans.multiply(p);
                ans.add(p);
                ans.multiply(p);


                pP = pP.getNext();
                pQ=pQ.getNext();


            } else {

                pQ = null;
                pP = null;
            }
        }


        return ans;
    }

    public Polynomial remainder(Polynomial p) throws Exception {
        Polynomial ans = new X14101468();
        // complete this code
        return ans;
    }

    public void parseString(String s) {

        int degree = 0;
        // make all x UpperCase
        s = s.toUpperCase();
        //eliminate all spaces
        s = s.replaceAll(" ", "");

        int[] sign = new int[s.length()];

        int[] sign3 = new int[s.length()];

        int[] dSign = new int[s.length()];

        String[] T1 = null;
        String T = null;

        T = s.replace("^-", "^");
        T = T.replace("^+", "^");

        T1 = T.split("[-,+]");

        int[] eSign = new int[s.length()];

        for (int i = 0; i < s.length(); i++) {
            dSign[i] = 0;
        }
        for (int i = 0; i < s.length(); i++) {
            eSign[i] = 0;
        }

        //get sing of coefficient 
        for (int i = 0; i < s.length(); i++) {

            if (s.charAt(i) == '^') {
                if (s.charAt(i + 1) == '-') {

                    dSign[i + 1] += -1;
                }
            }
            if (s.charAt(i) == '^') {
                if (s.charAt(i + 1) != '-') {
                    dSign[i + 1] += 1;
                }

            }
        }

        int n = 0;

        for (int i = 0; i < T1.length; i++) {
            if (T1[i].contains("X^")) {
                for (int k = 0; k < dSign.length; k++) {
                    if (dSign[k] == -1) {
                        eSign[n] = -1;
                        n++;
                    }
                    if (dSign[k] == 1) {
                        eSign[n] = 1;
                        n++;
                    }
                }
                break;
            }
        }

        s = T;
        String[] terms = s.split("[-,+]");

        for (int i = 0; i < s.length(); i++) {
            sign[i] = 0;

        }

        //get the sign for the first term
        if (s.charAt(0) == '-') {
            sign[0] += -1;
        } else if (s.charAt(0) == '+') {
            sign[0] += 1;
        } else {
            sign[0] += 1;
        }
        //find where the sing are located
        int p = 0;
        for (int i = 0; i < s.length(); i++) {

            if (s.charAt(i) == '+') {

                p++;
                sign[i] += 1;
                sign3[p] += 1;
            } else if (s.charAt(i) == '-') {

                p++;

                sign[i] += -1;
                sign3[p] += -1;
            }
        }
        sign3[0] = sign[0];
        //sings of terms

        int a = 0;
        try {

            //main for loop where all the terms are added
            for (int i = 0; i < terms.length; i++) {

                String d = null;
                String c = null;
                double coeff = 0.0;

                for (int j = 0; j < terms[i].length(); j++) {

                    if (terms[i].charAt(j) == 'X') {

                        c = terms[i].substring(0, j);
                        if (c.contains("0") || c.contains("1")
                                || c.contains("2") || c.contains("3")
                                || c.contains("4") || c.contains("5")
                                || c.contains("6") || c.contains("7")
                                || c.contains("8") || c.contains("9")) {

                            coeff = sign3[i] * Double.parseDouble(c);

                        } else {

                            coeff = sign3[i] * 1.0;

                        }
                        break;
                    }

                    if (!terms[i].contains("X")) {

                        coeff = sign3[i] * Double.parseDouble(terms[i]);
                    }
                }
                degree = 0;
                for (int k = 0; k < terms[i].length(); k++) {

                    if (terms[i].charAt(k) == '^') {

                        d = terms[i].substring(k + 1);
                        degree = eSign[a] * Integer.parseInt(d);
                        a++;
                    } else if (terms[i].charAt(terms[i].length() - 1) == 'X') {
                        degree = 1;
                        break;

                    } else if (!terms[i].contains("X")) {

                        degree = 0;
                        break;

                    }
            }

                Term term = new Term(coeff, degree);

                try {

                    if (data.isEmpty()) {
                        data.addFirst(term);
                    } else {
                        data.addLast(term);
                    }
                } catch (Exception e) {
                    System.out.print(e.getMessage());
                }


            }

        }catch (Exception e){
            System.out.print(e.getMessage());
        }
    }
}





