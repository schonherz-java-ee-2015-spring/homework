package hu.schonherz.homework.blog.core;


import hu.schonherz.homework.blog.core.repository.UserDao;
import hu.schonherz.homework.blog.core.repository.impl.UserJDBCTemplate;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    		UserDao tryy = new UserJDBCTemplate();
    		tryy.getAllUser();    		
    }
}
