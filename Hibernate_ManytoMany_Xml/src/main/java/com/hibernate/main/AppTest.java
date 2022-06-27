package com.hibernate.main;

import com.hibernate.model.Author;
import com.hibernate.model.Book;
import com.hibernate.session.SessionProvider;
import java.util.ArrayList;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class AppTest {
    public static void main(String[] args) {
        Session session = SessionProvider.getSession();
        System.out.println(session);
            
            Book book=new Book();
            book.setBookId(101);
            book.setBookName("java");
            book.setIsbnCode("201");
            
            Book book2=new Book();
            book2.setBookId(102);
            book2.setBookName("C++");
            book2.setIsbnCode("202");
            
            Author author1=new Author();
            author1.setAuthorId(1001);
            author1.setAuthorName("John");
            author1.setAuthorAddress("hyd");
            
            Author author2=new Author();
            author2.setAuthorId(1002);
            author2.setAuthorName("Robert");
            author2.setAuthorAddress("hyd");
            
            ArrayList authorsList=new ArrayList();
            
            authorsList.add(author1);
            authorsList.add(author2);
            book.setAuthors(authorsList);
            book2.setAuthors(authorsList);
            
            Transaction transaction=session.beginTransaction();
            
            session.save(book);
            session.save(book2);
            
            transaction.commit();
        }
    }
  

