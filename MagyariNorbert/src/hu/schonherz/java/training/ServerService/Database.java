package hu.schonherz.java.training.ServerService;

public interface Database {
  
  public enum Status {RUNNING, STOPPED}
  
  /**
   * Tell the status of Database
   * @return String of status of Database
   */
  public abstract String getStatus();
  
  /**
   * Tell the URL connection of the Database
   * @return Sting of URL connection to the Database
   */
<<<<<<< HEAD
  public abstract String getConnectionURL();
=======
  default String getConnectionURL() {
    return "localhost:98765";
  }
>>>>>>> c4bc2faea37cc837a00763b91c277400d53113fd
  
}
