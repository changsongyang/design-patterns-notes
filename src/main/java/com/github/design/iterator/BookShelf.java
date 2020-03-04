package com.github.design.iterator;


/**
 * 功能描述: 表示书架类
 * @author: qinxuewu
 * @date: 2020/1/23 11:43
 * @since 1.0.0
 */
public class BookShelf  implements  Aggregate{
    private  Book[] books;
    private  int last=0;

    public BookShelf(int max) {
        this.books =new Book[max];
    }

    public  Book getBookIndex(int i){
        return  books[i];
    }
    public void addBook(Book book){
        this.books[last]=book;
        last++;
    }

    public  int getLength(){
        return  last;
    }

    @Override
    public Iterator iterator() {
        return null;
    }
}
