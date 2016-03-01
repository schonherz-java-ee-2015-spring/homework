package hu.schonherz.java.training.thread;


public class SynchronizedObject {
  
  private int num = 0;
  
<<<<<<< HEAD
  public synchronized int getNum() {
=======
  //public synchronized int getNum() { // Thread2 wait till Thread1 finish its work
                                       // Thread1 and 2 will execute it after each other
  public int getNum() {
>>>>>>> c4bc2faea37cc837a00763b91c277400d53113fd
    num++;
    /*try {
      Thread.sleep(500);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }*/
    return num;
  }

}
