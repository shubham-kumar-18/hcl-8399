package HCL_Assessment_2_COREJAVA_2300320130247_Shubham_Kumar;
class Book{
    private int id;
    private String title;
    private String author;
    private String Issued;

    Book(int id, String title, String author, String Issued){
        this.id = id;
        this.title = title;
        this.author = author;
        this.Issued = Issued;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getIssued() {
        return Issued;
    }

    public void setIssued(String issued) {
        Issued = issued;
    }
    public void display(){
        System.out.println("ID: " + id + " Title: " + title + " Author: " + author + " Issued: " + Issued);
    }
}
class Latefee{
    protected int lateDays;

    public Latefee(int lateDays) {
        this.lateDays = lateDays;
    }

    public double calculateLateFee() throws Exception {
        if(lateDays <= 0){
            throw new Exception("Late fee cannot be negative");
        }
        return lateDays;
    }

}
class BookFee extends Latefee {

    public BookFee(int lateDays) {
        super(lateDays);
    }

    @Override
    public double calculateLateFee() throws Exception {
        if(lateDays <= 0){
            throw new Exception("Late fee cannot be negative");
        }
        return lateDays * 2;
    }
}
class DVD extends Latefee {

    public DVD(int lateDays) {
        super(lateDays);
    }

    @Override
    public double calculateLateFee() throws Exception {
        if(lateDays <= 0){
            throw new Exception("Late fee cannot be negative");
        }
        return lateDays * 5;
    }
}
class Magazine extends Latefee {

    public Magazine(int lateDays) {
        super(lateDays);
    }

    @Override
    public double calculateLateFee() throws Exception {
        if(lateDays <= 0){
            throw new Exception("Late fee cannot be negative");
        }
        return lateDays * 1;
    }
}

public class COREJAVA {
    public static void main(String[] args) {
        Book b = new Book(101,"A Summer","Ram Charan","available");
        Book b1 =new Book(102,"A Winter","Ram Krishna","available");
        Book b2 = new Book(103,"Winter is good","Laxman Das","available");
        Book b3 = new Book(104,"Summer is good","Rashit Das","Not available");

        b.display();
        b1.display();
        b2.display();
        b3.display();

        try{
            BookFee bookFee = new BookFee(5);
            Magazine magazine = new Magazine(5);
            DVD dvd = new DVD(5);
            DVD dvd1 = new DVD(-2);

            System.out.println("\n--- Late Fee Calculation ---");

            System.out.println("Book fee: Rs. " + bookFee.calculateLateFee());

            System.out.println("Magazine fee: Rs. " + magazine.calculateLateFee());

            System.out.println("DVD fee: Rs. " + dvd.calculateLateFee());
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }

    }
}

