
import java.io.CharConversionException;
import java.io.IOException;
import java.nio.file.FileSystemException;

/* 
Перехват выборочных исключений

Метод handleExceptions должен вызывать метод BEAN.methodThrowExceptions.
•
Метод handleExceptions должен логировать исключение FileSystemException (вызвать метод BEAN.log), а затем пробросить его дальше.
•
Метод handleExceptions должен только логировать (вызвать метод BEAN.log) исключение CharConversionException.
•
Метод handleExceptions должен только логировать любое исключение IOException.
•
Добавь в объявление метода handleExceptions класс исключения FileSystemException.
•
Метод main должен использовать try..catch.
•
Метод main должен логировать исключения, которые кидает метод handleExceptions.
*/

public class Solution {
    public static StatelessBean BEAN = new StatelessBean();

    public static void main(String[] args) {
        
        
        try{
           handleExceptions(); 
        }
       catch(Exception e){
           
     
           
       }
   
             
       
    }

    public static void handleExceptions() throws FileSystemException{
         
         try{
        BEAN.methodThrowExceptions();
         }
         catch(FileSystemException e){
           
           BEAN.log(e);
           throw e;
           
       }
        catch(CharConversionException e){
            BEAN.log(e);
        }
        catch(IOException e){
            BEAN.log(e);
        } 
           
          
         
          
    }

    public static class StatelessBean {
        public void log(Exception exception) {
         //     StackTraceElement[] stack = Thread.currentThread().getStackTrace();
         //   System.out.println("Я метод " +stack[1].getMethodName()+
         //           " меня запустили со строки "+stack[2].getLineNumber()+" мой лог:");
            System.out.println(exception.getMessage() + ", " + exception.getClass().getSimpleName());
        }

        public void methodThrowExceptions() throws CharConversionException, FileSystemException, IOException {
            int i = (int) (Math.random() * 3);
            if (i == 0)
                throw new CharConversionException();
            if (i == 1)
                throw new FileSystemException("");
            if (i == 2)
                throw new IOException();
        }
    }
    
}
