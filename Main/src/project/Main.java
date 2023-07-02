package project;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
// its my variable rk you can give whatever you want
    Scanner rk = new Scanner(System.in);
    int val;
    	
    while(true) {	
        System.out.println("1. Admin");
        System.out.println("2. Agent/User");
        System.out.println("3. Exit");
        
        val = rk.nextInt();
        rk.nextLine();

        String entUName, entPass;

        // To check the values whether it's admin/agent/exit
        switch (val) {
            case 1:
                // To get the user entered username and password
                entUName = rk.nextLine();
                entPass = rk.nextLine();

                // To go to the Admin login page
                Admin admin = new Admin();
                boolean adminLoggedIn = admin.login(entUName, entPass);
                if (adminLoggedIn) {
                    System.out.println("Logged In");

                    // To add product details from the admin (call addProduct method)
                    System.out.println("Enter Product ID: ");
                    int pId = rk.nextInt();
                    rk.nextLine();
                    
                    System.out.println("Enter Product Name: ");
                    String pName = rk.nextLine();
                    
                    System.out.println("Enter Minimum Sell Quantity: ");
                    int mSqty = rk.nextInt();
                    
                    System.out.println("Enter Price: ");
                    int price = rk.nextInt();
                    
                    System.out.println("Enter Quantity: ");
                    int qty = rk.nextInt();
                    
                    admin.addProduct(pId, pName, mSqty, price, qty);
                    admin.viewAllProducts();
                    
                } 
                else {
                    System.out.println("Couldn't Login");
                }
                
                break;

            case 2:
                // To get the user entered username and password
                entUName = rk.nextLine();
                entPass = rk.nextLine();

                // To go to the Agent login page
                Agent agent = new Agent();
                boolean agentLoggedIn = agent.Agentlogin(entUName, entPass);
                
                if (agentLoggedIn) {
                    System.out.println("Logged In");
                    
                    agent.choice();
                } 
                
                else {
                    System.out.println("Couldn't Login");
                }
                
                break;

            case 3:
                System.out.println("Happy Customer...!!!");
                break;

            default:
                System.out.println("You entered an invalid input");
                main(null);
                break;
        	}
        }
    }
}