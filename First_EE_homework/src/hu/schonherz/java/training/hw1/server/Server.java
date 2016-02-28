package hu.schonherz.java.training.hw1.server;

public abstract class Server {
	
	enum Status { RUNNING, STOPPED };
	
	private int cpuUsage;
	private int memoryUsage;
	private Status status = Status.STOPPED;
	
	public void startServer() {
		System.out.println("The server has been started!");
	}
	
	public void stopServer() {
		System.out.println("The server has been stopped!");
	}
	
	public void restartServer() {
		System.out.println("The server has been restarted!");
	}
	
	/**
	 * @return the cpuUsage
	 */
	public int getCpuUsage() {
		return cpuUsage;
	}
	
	/**
	 * @param cpuUsage the cpuUsage to set
	 */
	public void setCpuUsage(int cpuUsage) {
		this.cpuUsage = cpuUsage;
	}
	
	/**
	 * @return the memoryUsage
	 */
	public int getMemoryUsage() {
		return memoryUsage;
	}
	
	/**
	 * @param memoryUsage the memoryUsage to set
	 */
	public void setMemoryUsage(int memoryUsage) {
		this.memoryUsage = memoryUsage;
	}

	/**
	 * @return the status
	 */
	public Status getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(Status status) {
		this.status = status;
	}

}
