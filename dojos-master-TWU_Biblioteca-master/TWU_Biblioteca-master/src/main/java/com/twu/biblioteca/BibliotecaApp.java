package com.twu.biblioteca;

import com.twu.biblioteca.bean.Book;
import com.twu.biblioteca.bean.Movie;
import com.twu.biblioteca.bean.User;
import com.twu.biblioteca.service.BookService;
import com.twu.biblioteca.service.MovieService;
import com.twu.biblioteca.service.UserService;
import com.twu.biblioteca.util.GetInputMsgUtil;
import com.twu.biblioteca.util.InputUtil;

public class BibliotecaApp {
    private BookService bookservice = new BookService();
    private MovieService movieService = new MovieService();
    private UserService userService = new UserService();
    private InputUtil inputUtil = new InputUtil();
    public static User user;

    public void setInputUtil(InputUtil inputUtil) {
        this.inputUtil = inputUtil;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public void setMovieService(MovieService movieService) {
        this.movieService = movieService;
    }

    public void setBookservice(BookService bookservice) {
        this.bookservice = bookservice;
    }

    public static void main(String[] args) {
        BibliotecaApp bibliotecaApp = new BibliotecaApp();
        InputUtil inputUtil = new InputUtil();
        bibliotecaApp.welcome();

        while(true){
            System.out.println("--------------------------------------");
            System.out.println("" +
                    "1.List of Book\n" +
                    "2.List of Movie\n" +
                    "3.Login\n" +
                    "4.exit");
            int choose = inputUtil.getInt("please enter number which you want to do: ");
            bibliotecaApp.noLoginChoosePart(choose);
        }
    }
    /**
      *@author fengpei
      *@Description 选择1,2，3，或4
      *@Param choose：选择的数字
      *@Return none
      **/
    public void noLoginChoosePart(int choose){
        switch (choose) {
            case 1: {
                bookservice.ShowBooks();
                break;
            }
            case 2:{
                movieService.ShowMovies();
                break;
            }
            case 3: {
                UserLogin(new GetInputMsgUtil().getUser());
                break;
            }
            case 4:{
                System.exit(0);
            }
            default:{
                System.out.println("Please select a valid option");
            }
        }
    }
    /**
     *@author fengpei
     *@Description 用户进行登录，进行后续操作
     *@Param inputUser：用户输入的用户信息，包括了用户名和密码
     *@Return none
     **/
    public void UserLogin(User inputUser) {
        int roleNumber = userService.Login(inputUser);
        if(roleNumber == -1) {
            System.out.println("Sorry,Wrong library_number or password!");
        }else if(roleNumber == 0){
            System.out.println("Successful!");
            Boolean[] arr = new Boolean[1];
            arr[0] = true;
            while(arr[0]) {
                System.out.println("--------------------------------------");
                System.out.println("" +
                        "1.List of Book\n" +
                        "2.List of Movie\n" +
                        "3.Checkout book\n" +
                        "4.Return book\n" +
                        "5.Checkout Movie\n" +
                        "6.User Information\n" +
                        "7.exit");
                int choose = inputUtil.getInt("please enter number which you want to do: ");
                customerChoosePart(choose,arr);
            }
        }else{
            System.out.println("Successful!");
            Boolean[] arr = new Boolean[1];
            arr[0] = true;
            while(arr[0]) {
                System.out.println("--------------------------------------");
                System.out.println("" +
                        "1.List of Book\n" +
                        "2.List of Movie\n" +
                        "3.Checkout book\n" +
                        "4.Return book\n" +
                        "5.Checkout Movie\n" +
                        "6.Checkout book list\n" +
                        "7.User Information\n" +
                        "8.exit");
                int choose = inputUtil.getInt("please enter number which you want to do: ");
                adminChoosePart(choose, arr);
            }
        }
    }
    /**
     *@author fengpei
     *@Description 用户是顾客时的选择列表
     *@Param choose：选择的数字，arr[]：控制while循环
     *@Return none
     **/
    public void customerChoosePart(int choose, Boolean arr[]) {
        switch (choose) {
            case 1: {
                bookservice.ShowBooks();
                break;
            }
            case 2:{
                movieService.ShowMovies();
                break;
            }
            case 3: {
                ChooseCheckoutBook(new GetInputMsgUtil().getBook());
                break;
            }
            case 4: {
                ChooseReturnBook(new GetInputMsgUtil().getBook());
                break;
            }
            case 5: {
                ChooseCheckoutMovie(new GetInputMsgUtil().getMovie());
                break;
            }
            case 6: {
                userService.ShowUserInformation(user);
                break;
            }
            case 7 : System.exit(0);
            case 10000: {
                arr[0] = false;
                break;
            }
            default:{
                System.out.println("Please select a valid option");
            }
        }

    }
    /**
     *@author fengpei
     *@Description 用户是图书管理员时的选择列表
     *@Param choose：选择的数字，arr[]：控制while循环
     *@Return none
     **/
    public void adminChoosePart(int choose, Boolean arr[]) {
        switch (choose){
            case 1: {
                bookservice.ShowBooks();
                break;
            }
            case 2:{
                movieService.ShowMovies();
                break;
            }
            case 3: {
                ChooseCheckoutBook(new GetInputMsgUtil().getBook());
                break;
            }
            case 4: {
                ChooseReturnBook(new GetInputMsgUtil().getBook());
                break;
            }
            case 5: {
                ChooseCheckoutMovie(new GetInputMsgUtil().getMovie());
                break;
            }
            case 6: {
                userService.ShowCheckoutBookList();
                break;
            }
            case 7: {
                userService.ShowUserInformation(user);
                break;
            }
            case 8 : System.exit(0);
            case 10000: {
                arr[0] = false;
                break;
            }
            default:{
                System.out.println("Please select a valid option");
            }
        }
    }
    /**
     *@author fengpei
     *@Description 进行借电影操作，查看是否有电影并给予相应的回应
     *@Param Movie：需要借的电影
     *@Return none
     **/
    public void ChooseCheckoutMovie(Movie movie) {
        boolean isSuccess = movieService.CheckOutMovie(movie);

        System.out.println(isSuccess ? "Thank you! Enjoy the movie":"sorry,the movie is not available");
    }

    public void welcome(){
        System.out.println("Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!");
    }
    /**
      *@author fengpei
      *@Description 进行借书操作，查看是否有书并给予相应的回应
      *@Param book：需要借的图书
      *@Return none
      **/
    public void ChooseCheckoutBook(Book book){
        boolean isSuccess = bookservice.CheckOutBook(book);
        System.out.println(isSuccess?"Thank you! Enjoy the book":"sorry,the book is not available");
    }
    /**
      *@author fengpei
      *@Description 进行还书操作，查看图书是否为本图书馆内图书，并给予相应的回应
      *@Param book：进行归还的图书
      *@Return none
      **/
    public void ChooseReturnBook(Book book){
        System.out.println(bookservice.ReturnBook(book)?"Thank you for returning the book":"That is not a valid book to return");
    }
}
