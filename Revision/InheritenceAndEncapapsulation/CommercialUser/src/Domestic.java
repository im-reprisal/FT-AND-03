public class Domestic extends Commercial{
    @Override
    public void CalculateBill(int unit) {
        double total = unit * 2.5 ;
        System.out.println(total);
    }
}
