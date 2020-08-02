package com.twu.biblioteca;

import com.twu.biblioteca.bean.Book;
import com.twu.biblioteca.bean.Movie;
import com.twu.biblioteca.service.BookService;
import com.twu.biblioteca.service.MovieService;
import com.twu.biblioteca.util.GetInputMsgUtil;
import com.twu.biblioteca.util.InputUtil;

public class BibliotecaApp {
    private BookService bookservice = new BookService();
    private MovieService movieService = new MovieService();

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

        System.out.println("" +
                "1.List of Book\n" +
                "2.List of Movie\n" +
                "3.Checkout book\n" +
                "4.Return book\n" +
                "5.Checkout Movie\n" +
                "6.Return Movie\n" +
                "7.exit");

        while(true){
            int choose = inputUtil.getInt("please enter number which you want to do: ");
            bibliotecaApp.choosePart(choose);
            if(choose == 7) return;
        }
    }
    /**
      *@author fengpei
      *@Description 选择1,2，3，或4
      *@Param choose：选择的数字
      *@Return none
      **/
    public void choosePart(int choose){
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
                break;
            }
            case 7 : break;
            default:{
                System.out.println("Please select a valid option");
            }
        }
    }

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
