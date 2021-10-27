public class Commercial {
   private String name ;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void CalculateBill(int unit){
     double total = unit * 5 ;
        System.out.println("Bill Amount : "+total);
    }
}
