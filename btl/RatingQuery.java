import java.io.*;
import java.util.*;

public class RatingQuery {
    private ArrayList<Rating> edges;
    private ArrayList<Product> productList;
    private ArrayList<Customer> customerList;

    public RatingQuery(String customerPath, String productPath, String ratingPath){
        edges = new ArrayList<Rating>();
        productList = new ArrayList<Product>();
        customerList = new ArrayList<Customer>();
        readCustomerFile(customerPath);
        readProductFile(productPath);
        buildGraph(ratingPath);
    }

    public void printGraph(){
		for(int i = 0; i < edges.size(); i++){
			System.out.println(edges.get(i));
		}
	}

    public boolean readCustomerFile(String filePath){
        try{
            File f = new File(filePath);
            Scanner sc = new Scanner(f);
            while(sc.hasNextLine()){
                String content = sc.nextLine();
                String[] attributes = content.split(",");
                Customer tmpCustomer = new Customer(attributes[0], attributes[1], attributes[2]);
                customerList.add(tmpCustomer);
            }
            sc.close();
        }catch(FileNotFoundException e){
            System.out.println("File not found");
            return false;
        } 
        return true;
    }

    public boolean readProductFile(String filePath){
        try{
            File f = new File(filePath);
            Scanner sc = new Scanner(f);
            while(sc.hasNextLine()){
                String content = sc.nextLine();
                String[] attributes = content.split(",");
                Product tmpProduct = new Product(Integer.parseInt(attributes[0]), attributes[1], attributes[2]);
                productList.add(tmpProduct);
            }
            sc.close();
        }catch(FileNotFoundException e){
            System.out.println("File not found");
            return false;
        } 
        return true;
    }

    public void addEdge(Customer u, Product v, int w){
		////code here
        edges.add(new Rating(u,v,w));
	}

    public boolean buildGraph(String filePath){
        try{
            File f = new File(filePath);
            Scanner sc = new Scanner(f);
            while(sc.hasNextLine()){
                String content = sc.nextLine();
                String[] attributes = content.split(",");
                Customer tmpCustomer = new Customer();
                Product tmpProduct = new Product();
                for(Customer c : customerList){
                    if(c.getCustomerId().equals(attributes[0]))
                        tmpCustomer = c;
                }
                for(Product p : productList){
                    if(p.getProductId() == Integer.parseInt(attributes[1]))
                        tmpProduct = p;
                }
                addEdge(tmpCustomer, tmpProduct, Integer.parseInt(attributes[2]));
            }
            sc.close();
        }catch(FileNotFoundException e){
            System.out.println("File not found");
            return false;
        } 
        return true;
    }

    public ArrayList<Product> query1(String customerId){
        //code here and change the return value
        //danh gia tren 3 sao
        //B1: tim kiem trong list edges customer co' customer can tim
        //B2: tim trong trong sub list weight >= 3
        //B3: add nhung thang tim duoc vao list product
        ArrayList<Product> result = new ArrayList<>();
        for(Rating edge: edges){
            Customer customer = edge.getCustomer();
            if(customer.getCustomerId().equals(customerId)){
                if(edge.getStars() >= 3){
                    result.add(edge.getProduct());
                }
            }
        }
        return result;
    }

    public Integer query2(int productId){
        //code here and change the return value
        //return so luong nam gioi' danh gia san pham tren 3 sao
        //B1: tim trong list edges product co' productId can tim
        //B2: tim kiem trong sub list edge customer co' gioi tinh nam
        //B3: count so edge thoa dieu kien >= 3
        int count = 0;
        for(Rating edge: edges){
            Product product = edge.getProduct();
            if(product.getProductId() == productId){
                if(edge.getCustomer().getGender().equals("M")){
                    if(edge.getStars() >= 3) count++;
                }
            }
        }
        return count;
    }


    public ArrayList<Product> query3(){
        //code here and change the return value
        //tra ve danh sach nhung san pham bi. danh' gia boi 50% khach hang la nu
        ArrayList<Product> result = new ArrayList<>();

        ArrayList<CoupleRating> coupleList = new ArrayList<>();
        for(Product product : productList){
            coupleList.add(new CoupleRating(product));
        }

        for(Rating edge: edges){
            int edgeProductId = edge.getProduct().getProductId();
            for(CoupleRating couple : coupleList){
                if(couple.getProduct().getProductId() == edgeProductId){
                    //add vao array list customer
                    couple.addCustomerIntoList(edge.getCustomer());
                }
            }
        }

        for(CoupleRating couple: coupleList){
            if(couple.isMoreThanHalf()) result.add(couple.getProduct());
        }
        return result;
    }

    public <E> boolean writeFile(String filePath, ArrayList<E> list){
        try{
            File f = new File(filePath);
            FileWriter fw = new FileWriter(f);
            if(list.size() == 0){
                fw.write("No item here");
                fw.close();
                return true;
            }
            for(E data : list){
                fw.write(data + "\n");
            }
            fw.close();
        }catch(IOException e){
            System.out.println("Can't write file");
            return false;
        }

        return true;
    }

    public <E> boolean writeFile(String filePath, E data){
        try{
            File f = new File(filePath);
            FileWriter fw = new FileWriter(f);
            fw.write(data.toString());
            fw.close();
        }catch(IOException e){
            System.out.println("Can't write file");
            return false;
        }
        return true;    
    }
}

class CoupleRating {
    private ArrayList<Customer> customers;
    private Product product;

    public ArrayList<Customer> getCustomers() {
        return this.customers;
    }

    public void setCustomers(ArrayList<Customer> customers) {
        this.customers = customers;
    }

    public Product getProduct() {
        return this.product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public CoupleRating(Product product){
        customers = new ArrayList<>();
        this.product = product;
    }

    public void addCustomerIntoList(Customer customer){
        this.customers.add(customer);
    }

    public boolean isMoreThanHalf(){
        Double countFemale = 0.0;
        Double countAll = 0.0;
        Double res = 0.0;
        for(Customer customer : customers){
            countAll += 1.0;
            if(customer.getGender().equals("F")) countFemale += 1.0;
        }
        if(countAll == 0.0) return false;
        res = countFemale/countAll;
        return res >= 0.5;
    }
}
