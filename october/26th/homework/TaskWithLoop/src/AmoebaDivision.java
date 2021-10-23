public class AmoebaDivision {
    private int initialNumberAmoebas;
    private int amoebaDivisionTime;
    private int researchPeriod;
    private int numberAmoebasAfterDivision;

    public AmoebaDivision(int initialNumberAmoebas, int amoebaDivisionTime, int researchPeriod, int numberAmoebasAfterDivision) {
        this.initialNumberAmoebas = initialNumberAmoebas;
        this.amoebaDivisionTime = amoebaDivisionTime;
        this.researchPeriod = researchPeriod;
        this.numberAmoebasAfterDivision = numberAmoebasAfterDivision;
    }

    public void getNumberAmoebasByDivisionPeriodsUsingForLoop() {
        System.out.println("For loop result: ");
        int numberAmoebas = initialNumberAmoebas;
        for (int divisionTime = amoebaDivisionTime; divisionTime <= researchPeriod; divisionTime += amoebaDivisionTime) {
            numberAmoebas *= numberAmoebasAfterDivision;
            printTimeAndNumberAmoebas(divisionTime, numberAmoebas);
        }
    }

    public void getNumberAmoebasByDivisionPeriodsUsingWhileLoop() {
        System.out.println("While loop result: ");
        int divisionTime = amoebaDivisionTime;
        int numberAmoebas = initialNumberAmoebas;
        while (divisionTime <= researchPeriod) {
            printTimeAndNumberAmoebas(divisionTime, numberAmoebas *= numberAmoebasAfterDivision);
            divisionTime += amoebaDivisionTime;
        }
    }

    private void printTimeAndNumberAmoebas(int divisionTime, int numberAmoebas) {
        System.out.println("At " + divisionTime + " o'clock the number of amoebas is " + numberAmoebas);
    }
}
