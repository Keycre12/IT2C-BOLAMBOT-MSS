
package sample;

import java.util.Scanner;


public class Sample {

        public void addBook(){
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Book Title: ");
        String b_title = sc.next();
        
        System.out.print("Book Genre: ");
        String b_genre = sc.next();
         System.out.print("Book Author: ");
        String b_author = sc.next();
       

        String sql = "INSERT INTO Sample ( b_title, b_genre, b_author) VALUES (?, ?, ?)";
        config conf = new config();
        conf.addBook(sql, b_title, b_genre, b_author);
    }
     public void viewBooks(){
   
    String cqry = "SELECT b_id, b_title, b_genre, b_author FROM Sample";
    String[] hrds = {"ID", "Title", "Genre", "Author"};
    String[] clmns = {"b_id", "b_title", "b_genre", "b_author"};

    config conf = new config();
    conf.viewBooks(cqry, hrds, clmns);
    }

     
     private void updateBook(){
         Scanner sc = new Scanner(System.in);
         System.out.println("Enter Book ID: ");
         int id = sc.nextInt();
         
         System.out.print("Enter new Book Title: ");
         String b_title = sc.next();
         
         System.out.print("Enter new Book Genre: ");
         String b_genre = sc.next();
         
          System.out.print("Enter new Book Author: ");
         String b_author = sc.next();
         
         String qry = "UPDATE Sample SET b_title = ?, b_genre = ?, b_author = ? WHERE b_id = ? ";
         
         config conf = new config();
         conf.updateBooks(qry, b_title, b_genre, b_author, id);
             
     }
      public void DeleteBook(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Book ID to delete: ");
        int id = sc.nextInt();
        
        
         String sqlDelete = "DELETE FROM Sample WHERE book_id = ?";
         config conf = new config();
         conf.deleteBook(sqlDelete, id);
       
}
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        Sample book = new Sample(); 
        String response;
        
        do{
            System.out.println("1. Add:");
            System.out.println("2. View:");
            System.out.println("3. Update:");
            System.out.println("4. Delete:");
            System.out.println("5. Exit:");
            
            System.out.print("Enter Action: ");
            int action = sc.nextInt();
            
            switch (action){
                case 1:
                    book.addBook();
                    
                    break;
                    
                case 2:
                   book.viewBooks();
                    break;
                    
                    case 3:
                   book.viewBooks();
                   book.updateBook();
                    break;
                    
                    case 4:
                    book.viewBooks();
                    book.DeleteBook();
                    book.viewBooks();
                    break;
                    
                    case 5: 
                        System.out.println("Exiting...");
                        break;
                    default:
                        System.out.println("Invalid action. Please try again.");
            }
            
            System.out.print("Continue (yes/no): ");
            response = sc.next();
            
        } while(response.equalsIgnoreCase("yes"));
        System.out.println("Thank You See You Soon!");
        
    }
    
}

    

