public class Main {
    public static void main(String[] args) {
//        int a = 5;

//        if (a == 5) {
//            System.out.println("A = 5");
//        } else {
//            System.out.println("A != 5");
//        }
//
//        if (a > 10) {
//            System.out.println("A > 5");
//        } else if (a > 0) {
//            System.out.println("A > 5");
//        }
//
//        switch (a) {
//            case 5:
//                System.out.println("a == 5");
//                break;
//            case 2:
//                System.out.println("a == 2");
//                break;
//            default:
//                System.out.println("Нет совпадений");
//                break;
//        }
//
//        int b = a == 5 ? 10 : 100;
//        System.out.println(b);

        int variable = 1000;
        System.out.println(variable % 2 == 0 ? variable + " is even" : variable + " is odd");

        if (variable >= 0 && variable < 10) {
            System.out.println("Digit capacity = 1");
        } else if (variable >= 10 && variable < 100) {
            System.out.println("Digit capacity = 2");
        } else if (variable >= 100 && variable < 1000) {
            System.out.println("Digit capacity = 3");
        } else {
            System.out.println("No if statement for this number: " + variable);
        }

        int b = 0;
        if (b != 0 && 10/b < 1) {
            System.out.println("yes");
        }

//        for (int i = 0; i < 10; i++) {
//            if (i == 3) {
//                continue;
//            }
//            if (i == 5) {
//                break;
//            }
//            System.out.println(i);
//        }

//        int a = 5;
//        while (a < 10) {
//            System.out.println(a);
//            a++;
//        }

//        do {
//            System.out.println(a);
//            a++;
//        } while (a == 5);


    }

}
